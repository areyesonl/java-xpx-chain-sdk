/*
 * Copyright 2018 NEM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.nem.sdk.infrastructure;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bouncycastle.util.encoders.Hex;

import io.nem.sdk.infrastructure.model.UInt64DTO;
import io.nem.sdk.infrastructure.utils.UInt64Utils;
import io.nem.sdk.model.account.Address;
import io.nem.sdk.model.account.PublicAccount;
import io.nem.sdk.model.blockchain.NetworkType;
import io.nem.sdk.model.mosaic.Mosaic;
import io.nem.sdk.model.mosaic.MosaicId;
import io.nem.sdk.model.mosaic.MosaicProperties;
import io.nem.sdk.model.mosaic.MosaicSupplyType;
import io.nem.sdk.model.namespace.NamespaceId;
import io.nem.sdk.model.namespace.NamespaceType;
import io.nem.sdk.model.transaction.*;
import io.reactivex.functions.Function;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class TransactionMapping implements Function<JsonObject, Transaction> {
    @Override
    public Transaction apply(JsonObject input) {
        JsonObject transaction = input.getJsonObject("transaction");
        int type = transaction.getInteger("type");

        switch (TransactionType.rawValueOf(type)) {
        	case TRANSFER: return new TransferTransactionMapping().apply(input);
        	case REGISTER_NAMESPACE: return new NamespaceCreationTransactionMapping().apply(input);
        	case MOSAIC_DEFINITION: return new MosaicCreationTransactionMapping().apply(input);
        	case MOSAIC_SUPPLY_CHANGE: return new MosaicSupplyChangeTransactionMapping().apply(input);
        	case MOSAIC_ALIAS: return new MosaicAliasTransactionMapping().apply(input);
        	case MODIFY_MULTISIG_ACCOUNT: return new MultisigModificationTransactionMapping().apply(input);
        	case AGGREGATE_COMPLETE: case AGGREGATE_BONDED: return new AggregateTransactionMapping().apply(input);
        	case LOCK: return new LockFundsTransactionMapping().apply(input);
        	case SECRET_LOCK: return new SecretLockTransactionMapping().apply(input);
        	case SECRET_PROOF: return new SecretProofTransactionMapping().apply(input);
        	default: throw new UnsupportedOperationException("Unimplemented transaction type " + type);
        }
    }

    /**
     * take array of unsigned integers and combine them to BigInteger
     * 
     * @param input json array
     * @return big integer represented by the array
     */
    BigInteger extractBigInteger(JsonArray input) {
        UInt64DTO uInt64DTO = new UInt64DTO();
        input.stream().forEach(item -> uInt64DTO.add(Long.parseLong(item.toString())));
        return UInt64Utils.toBigInt(uInt64DTO);
    }

    /**
     * extract transaction version from version
     * 
     * @param version version field of transaction
     * @return transaction version
     */
    Integer extractTransactionVersion(int version) {
    	// take second most significant byte of a version and return it as a number
        return (int) Long.parseLong(Integer.toHexString(version).substring(2, 4), 16);
    }

    /**
     * extract network type from the version
     * 
     * @param version version field of transaction
     * @return transaction network type
     */
    NetworkType extractNetworkType(int version) {
    	// take most significant byte of a version and return it as a number
        int networkType = (int) Long.parseLong(Integer.toHexString(version).substring(0, 2), 16);
        return NetworkType.rawValueOf(networkType);
    }

    /**
     * create transaction info based on the provided transaction meta json object
     * 
     * @param jsonObject json object representing the meta field
     * @return TransactionInfo instance representing the meta
     */
    public TransactionInfo createTransactionInfo(JsonObject jsonObject) {
    	// hash and id indicate standard transaction info
        if (jsonObject.containsKey("hash") && jsonObject.containsKey("id")) {
            return TransactionInfo.create(
            		extractBigInteger(jsonObject.getJsonArray("height")),
                    jsonObject.getInteger("index"),
                    jsonObject.getString("id"),
                    jsonObject.getString("hash"),
                    jsonObject.getString("merkleComponentHash"));
        }
    	// agrregateHash and id indicate aggregate transaction
        if (jsonObject.containsKey("aggregateHash") && jsonObject.containsKey("id")) {
            return TransactionInfo.createAggregate(extractBigInteger(jsonObject.getJsonArray("height")),
                    jsonObject.getInteger("index"),
                    jsonObject.getString("id"),
                    jsonObject.getString("aggregateHash"),
                    jsonObject.getString("aggregateId"));
        }
        // transaction with missing id
        return TransactionInfo.create(extractBigInteger(jsonObject.getJsonArray("height")),
        		jsonObject.getString("hash"),
                jsonObject.getString("merkleComponentHash"));
    }
}

/**
 * mapping for transfer transaction
 * 
 * @author tonowie
 */
class TransferTransactionMapping extends TransactionMapping {

    @Override
    public TransferTransaction apply(JsonObject input) {
    	// retrieve transaction info from meta field
        TransactionInfo transactionInfo = createTransactionInfo(input.getJsonObject("meta"));
        // retrieve transaction data from transaction field
        JsonObject transaction = input.getJsonObject("transaction");
        // deadline
        Deadline deadline = new Deadline(extractBigInteger(transaction.getJsonArray("deadline")));
        // mosaics
        List<Mosaic> mosaics;
        if (transaction.getJsonArray("mosaics") != null) {
            mosaics = transaction
                    .getJsonArray("mosaics")
                    .stream()
                    .map(item -> (JsonObject) item)
                    .map(mosaic -> new Mosaic(
                            new MosaicId(extractBigInteger(mosaic.getJsonArray("id"))),
                            extractBigInteger(mosaic.getJsonArray("amount"))))
                    .collect(Collectors.toList());
        } else {
        	mosaics = new ArrayList<>();
        }
        // message
        Message message;
        if (transaction.getJsonObject("message") != null) {
            final JsonObject messageObj = transaction.getJsonObject("message");
            int messageType = messageObj.getInteger("type");
            String messagePayload = messageObj.getString("payload");
            message = MessageFactory.createMessage(messageType, Hex.decode(messagePayload));
        } else {
        	message = PlainMessage.Empty;
        }
        // listener returns fee as uint64 "fee" and services return string "maxFee" so lets support both
        BigInteger fee;
        if (transaction.getString("maxFee") != null) {
        	fee = new BigInteger(transaction.getString("maxFee"));
        } else if (transaction.getJsonArray("fee") != null) {
        	fee = extractBigInteger(transaction.getJsonArray("fee"));
        } else {
        	throw new IllegalArgumentException("Fee is missing in the transaction description");
        }
        // version
        int version = transaction.getInteger("version");
        // create transfer transaction instance
        return new TransferTransaction(
                extractNetworkType(version),
                extractTransactionVersion(version),
                deadline,
                fee,
                Address.createFromEncoded(transaction.getString("recipient")),
                mosaics,
                message,
                transaction.getString("signature"),
                new PublicAccount(transaction.getString("signer"), extractNetworkType(version)),
                transactionInfo
        );
    }
}

/**
 * mapper for transaction that registers namespace
 * 
 * @author tonowie
 */
class NamespaceCreationTransactionMapping extends TransactionMapping {

    @Override
    public RegisterNamespaceTransaction apply(JsonObject input) {
    	// get transaction info and data
        TransactionInfo transactionInfo = this.createTransactionInfo(input.getJsonObject("meta"));
        JsonObject transaction = input.getJsonObject("transaction");
        // retrieve fields
        Deadline deadline = new Deadline(extractBigInteger(transaction.getJsonArray("deadline")));
        NamespaceType namespaceType = NamespaceType.rawValueOf(transaction.getInteger("namespaceType"));
        NamespaceId namespaceId = new NamespaceId(extractBigInteger(transaction.getJsonArray("namespaceId")));
        Optional<BigInteger> namespaceDuration = namespaceType == NamespaceType.RootNamespace ? Optional.of(extractBigInteger(transaction.getJsonArray("duration"))) : Optional.empty();
        Optional<NamespaceId> namespaceParentId = namespaceType == NamespaceType.SubNamespace ? Optional.of(new NamespaceId(extractBigInteger(transaction.getJsonArray("parentId")))) : Optional.empty();
        int version = transaction.getInteger("version");
        // return the register namespace transaction
        return new RegisterNamespaceTransaction(
                extractNetworkType(version),
                extractTransactionVersion(version),
                deadline,
                new BigInteger(transaction.getString("maxFee")),
                transaction.getString("name"),
                namespaceId,
                namespaceType,
                namespaceDuration,
                namespaceParentId,
                transaction.getString("signature"),
                new PublicAccount(transaction.getString("signer"), extractNetworkType(version)),
                transactionInfo
        );
    }
}

/**
 * transaction that creates new mosaic
 * 
 * @author tonowie
 */
class MosaicCreationTransactionMapping extends TransactionMapping {

    @Override
    public MosaicDefinitionTransaction apply(JsonObject input) {
    	// load transaction info and data
        TransactionInfo transactionInfo = this.createTransactionInfo(input.getJsonObject("meta"));
        JsonObject transaction = input.getJsonObject("transaction");
        // load data fields
        Deadline deadline = new Deadline(extractBigInteger(transaction.getJsonArray("deadline")));
        // construct properties
        JsonArray mosaicProperties = transaction.getJsonArray("properties");
        String flags = "00" + Integer.toBinaryString(extractBigInteger(mosaicProperties.getJsonObject(0).getJsonArray("value")).intValue());
        String bitMapFlags = flags.substring(flags.length() - 3, flags.length());
        MosaicProperties properties = new MosaicProperties(bitMapFlags.charAt(2) == '1',
                bitMapFlags.charAt(1) == '1',
                bitMapFlags.charAt(0) == '1',
                extractBigInteger(mosaicProperties.getJsonObject(1).getJsonArray("value")).intValue(),
                mosaicProperties.size() == 3 ? extractBigInteger(mosaicProperties.getJsonObject(2).getJsonArray("value")) : BigInteger.valueOf(0));
        int version = transaction.getInteger("version");
        // return instance of mosaic definition transaction
        return new MosaicDefinitionTransaction(
                extractNetworkType(version),
                extractTransactionVersion(version),
                deadline,
                new BigInteger(transaction.getString("maxFee")),
                new MosaicId(extractBigInteger(transaction.getJsonArray("mosaicId"))),
                transaction.getInteger("mosaicNonce"),
                properties,
                transaction.getString("signature"),
                new PublicAccount(transaction.getString("signer"), extractNetworkType(version)),
                transactionInfo
        );
    }
}

/**
 * transaction that creates alias between namespace and mosaic
 * 
 * @author tonowie
 */
class MosaicAliasTransactionMapping extends TransactionMapping {

    @Override
    public MosaicAliasDefinitionTransaction apply(JsonObject input) {
    	// load transaction info and data
        TransactionInfo transactionInfo = this.createTransactionInfo(input.getJsonObject("meta"));
        JsonObject transaction = input.getJsonObject("transaction");
        // load data fields
        Deadline deadline = new Deadline(extractBigInteger(transaction.getJsonArray("deadline")));
        int version = transaction.getInteger("version");
        // return instance of mosaic alias definition transaction
        return new MosaicAliasDefinitionTransaction(
                extractNetworkType(version),
                extractTransactionVersion(version),
                deadline,
                new BigInteger(transaction.getString("maxFee")),
                new MosaicId(extractBigInteger(transaction.getJsonArray("mosaicId"))),
                new NamespaceId(extractBigInteger(transaction.getJsonArray("namespaceId"))),
                transaction.getInteger("action"),
                transaction.getString("signature"),
                new PublicAccount(transaction.getString("signer"), extractNetworkType(version)),
                transactionInfo
        );
    }
}

class MosaicSupplyChangeTransactionMapping extends TransactionMapping {

    @Override
    public MosaicSupplyChangeTransaction apply(JsonObject input) {
        TransactionInfo transactionInfo = this.createTransactionInfo(input.getJsonObject("meta"));

        JsonObject transaction = input.getJsonObject("transaction");
        Deadline deadline = new Deadline(extractBigInteger(transaction.getJsonArray("deadline")));

        return new MosaicSupplyChangeTransaction(
                extractNetworkType(transaction.getInteger("version")),
                extractTransactionVersion(transaction.getInteger("version")),
                deadline,
                new BigInteger(transaction.getString("maxFee")),
                new MosaicId(extractBigInteger(transaction.getJsonArray("mosaicId"))),
                MosaicSupplyType.rawValueOf(transaction.getInteger("direction")),
                extractBigInteger(transaction.getJsonArray("delta")),
                transaction.getString("signature"),
                new PublicAccount(transaction.getString("signer"), extractNetworkType(transaction.getInteger("version"))),
                transactionInfo
        );
    }
}

class MultisigModificationTransactionMapping extends TransactionMapping {

    @Override
    public ModifyMultisigAccountTransaction apply(JsonObject input) {
        TransactionInfo transactionInfo = this.createTransactionInfo(input.getJsonObject("meta"));

        JsonObject transaction = input.getJsonObject("transaction");
        Deadline deadline = new Deadline(extractBigInteger(transaction.getJsonArray("deadline")));
        NetworkType networkType = extractNetworkType(transaction.getInteger("version"));

        List<MultisigCosignatoryModification> modifications = transaction.containsKey("modifications") ? transaction
                .getJsonArray("modifications")
                .stream()
                .map(item -> (JsonObject) item)
                .map(multisigModification -> new MultisigCosignatoryModification(
                        MultisigCosignatoryModificationType.rawValueOf(multisigModification.getInteger("type")),
                        PublicAccount.createFromPublicKey(multisigModification.getString("cosignatoryPublicKey"), networkType)))
                .collect(Collectors.toList()) : Collections.emptyList();

        return new ModifyMultisigAccountTransaction(
                networkType,
                extractTransactionVersion(transaction.getInteger("version")),
                deadline,
                extractBigInteger(transaction.getJsonArray("fee")),
                transaction.getInteger("minApprovalDelta"),
                transaction.getInteger("minRemovalDelta"),
                modifications,
                transaction.getString("signature"),
                new PublicAccount(transaction.getString("signer"), networkType),
                transactionInfo
        );
    }
}

class AggregateTransactionMapping extends TransactionMapping {

    @Override
    public AggregateTransaction apply(JsonObject input) {
        TransactionInfo transactionInfo = this.createTransactionInfo(input.getJsonObject("meta"));

        JsonObject transaction = input.getJsonObject("transaction");
        Deadline deadline = new Deadline(extractBigInteger(transaction.getJsonArray("deadline")));
        NetworkType networkType = extractNetworkType(transaction.getInteger("version"));

        List<Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < transaction.getJsonArray("transactions").getList().size(); i++) {
            JsonObject innerTransaction = transaction.getJsonArray("transactions").getJsonObject(i);
            innerTransaction.getJsonObject("transaction").put("deadline", transaction.getJsonArray("deadline"));
            innerTransaction.getJsonObject("transaction").put("fee", transaction.getJsonArray("fee"));
            innerTransaction.getJsonObject("transaction").put("signature", transaction.getString("signature"));
            if (!innerTransaction.containsKey("meta")) {
                innerTransaction.put("meta", input.getJsonObject("meta"));
            }
            transactions.add(new TransactionMapping().apply(innerTransaction));
        }

        List<AggregateTransactionCosignature> cosignatures = new ArrayList<>();
        if (transaction.getJsonArray("cosignatures") != null) {
            cosignatures = transaction
                    .getJsonArray("cosignatures")
                    .stream()
                    .map(item -> (JsonObject) item)
                    .map(aggregateCosignature -> new AggregateTransactionCosignature(
                            aggregateCosignature.getString("signature"),
                            new PublicAccount(aggregateCosignature.getString("signer"), networkType)))
                    .collect(Collectors.toList());
        }

        return new AggregateTransaction(
                networkType,
                TransactionType.rawValueOf(transaction.getInteger("type")),
                extractTransactionVersion(transaction.getInteger("version")),
                deadline,
                extractBigInteger(transaction.getJsonArray("fee")),
                transactions,
                cosignatures,
                transaction.getString("signature"),
                new PublicAccount(transaction.getString("signer"), networkType),
                transactionInfo
        );
    }
}

class LockFundsTransactionMapping extends TransactionMapping {

    @Override
    public LockFundsTransaction apply(JsonObject input) {
        TransactionInfo transactionInfo = this.createTransactionInfo(input.getJsonObject("meta"));

        JsonObject transaction = input.getJsonObject("transaction");
        Deadline deadline = new Deadline(extractBigInteger(transaction.getJsonArray("deadline")));
        NetworkType networkType = extractNetworkType(transaction.getInteger("version"));
        Mosaic mosaic;
        if (transaction.containsKey("mosaicId")) {
            mosaic = new Mosaic(new MosaicId(extractBigInteger(transaction.getJsonArray("mosaicId"))), extractBigInteger(transaction.getJsonArray("amount")));
        } else {
            mosaic = new Mosaic(new MosaicId(extractBigInteger(transaction.getJsonObject("mosaic").getJsonArray("id"))), extractBigInteger(transaction.getJsonObject("mosaic").getJsonArray("amount")));
        }
        return new LockFundsTransaction(
                networkType,
                extractTransactionVersion(transaction.getInteger("version")),
                deadline,
                new BigInteger(transaction.getString("maxFee")),
                mosaic,
                extractBigInteger(transaction.getJsonArray("duration")),
                new SignedTransaction("", transaction.getString("hash"), TransactionType.AGGREGATE_BONDED),
                transaction.getString("signature"),
                new PublicAccount(transaction.getString("signer"), networkType),
                transactionInfo
        );
    }
}

class SecretLockTransactionMapping extends TransactionMapping {

    @Override
    public SecretLockTransaction apply(JsonObject input) {
        TransactionInfo transactionInfo = this.createTransactionInfo(input.getJsonObject("meta"));

        JsonObject transaction = input.getJsonObject("transaction");
        Deadline deadline = new Deadline(extractBigInteger(transaction.getJsonArray("deadline")));
        NetworkType networkType = extractNetworkType(transaction.getInteger("version"));
        Mosaic mosaic;
        if (transaction.containsKey("mosaicId")) {
            mosaic = new Mosaic(new MosaicId(extractBigInteger(transaction.getJsonArray("mosaicId"))), extractBigInteger(transaction.getJsonArray("amount")));
        } else {
            mosaic = new Mosaic(new MosaicId(extractBigInteger(transaction.getJsonObject("mosaic").getJsonArray("id"))), extractBigInteger(transaction.getJsonObject("mosaic").getJsonArray("amount")));
        }
        return new SecretLockTransaction(
                networkType,
                extractTransactionVersion(transaction.getInteger("version")),
                deadline,
                extractBigInteger(transaction.getJsonArray("fee")),
                mosaic,
                extractBigInteger(transaction.getJsonArray("duration")),
                HashType.rawValueOf(transaction.getInteger("hashAlgorithm")),
                transaction.getString("secret"),
                Address.createFromEncoded(transaction.getString("recipient")),
                transaction.getString("signature"),
                new PublicAccount(transaction.getString("signer"), networkType),
                transactionInfo
        );
    }
}

class SecretProofTransactionMapping extends TransactionMapping {

    @Override
    public SecretProofTransaction apply(JsonObject input) {
        TransactionInfo transactionInfo = this.createTransactionInfo(input.getJsonObject("meta"));

        JsonObject transaction = input.getJsonObject("transaction");
        Deadline deadline = new Deadline(extractBigInteger(transaction.getJsonArray("deadline")));
        NetworkType networkType = extractNetworkType(transaction.getInteger("version"));

        return new SecretProofTransaction(
                networkType,
                extractTransactionVersion(transaction.getInteger("version")),
                deadline,
                extractBigInteger(transaction.getJsonArray("fee")),
                HashType.rawValueOf(transaction.getInteger("hashAlgorithm")),
                transaction.getString("secret"),
                transaction.getString("proof"),
                transaction.getString("signature"),
                new PublicAccount(transaction.getString("signer"), networkType),
                transactionInfo
        );
    }
}

