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

package io.nem.sdk.model.transaction;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;
import org.bouncycastle.util.encoders.Hex;

import io.nem.core.crypto.Hashes;
import io.nem.sdk.model.mosaic.IllegalIdentifierException;


public class IdGenerator {

    public static BigInteger generateId(String name, BigInteger parentId) {
        byte[] parentIdBytes = new byte[8];
        ByteBuffer.wrap(parentIdBytes).put(parentId.toByteArray()); // GO
        ArrayUtils.reverse(parentIdBytes);

        byte[] bytes = name.getBytes();

        byte[] result = Hashes.sha3_256(parentIdBytes, bytes);
        byte[] low = Arrays.copyOfRange(result, 0, 4);
        byte[] high = Arrays.copyOfRange(result, 4, 8);
        ArrayUtils.reverse(low);
        ArrayUtils.reverse(high);

        byte[] last = ArrayUtils.addAll(high, low);

        return new BigInteger(last);
    }

    public static List<BigInteger> generateNamespacePath(String name) {
        String[] parts = name.split(Pattern.quote("."));
        List<BigInteger> path = new ArrayList<BigInteger>();

        if (parts.length == 0) {
            throw new IllegalIdentifierException("invalid namespace name");
        } else if (parts.length > 3) {
            throw new IllegalIdentifierException("too many parts");
        }

        BigInteger namespaceId = BigInteger.valueOf(0);


        for (int i = 0; i < parts.length; i++) {
            if (!parts[i].matches("^[a-z0-9][a-z0-9-_]*$")) {
                throw new IllegalIdentifierException("invalid namespace name");
            }
            namespaceId = generateId(parts[i], namespaceId);
            path.add(namespaceId);
        }

        return path;
    }

    public static BigInteger generateNamespaceId(String namespaceName) {
        List<BigInteger> namespacePath = generateNamespacePath(namespaceName);
        return namespacePath.get(namespacePath.size() - 1);
    }

    public static BigInteger generateSubNamespaceIdFromParentId(BigInteger parentId, String namespaceName) {
        return generateId(namespaceName, parentId);
    }
    
    public static BigInteger generateMosaicId(Integer nonce, String ownerPublicKeyHex) {
        byte[] nonceBytes = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(nonce).array();
        byte[] ownerPublicKeyBytes = Hex.decode(ownerPublicKeyHex);
        // compute hash of little-endian nonce and public key hex
        byte[] hash = Hashes.sha3_256(nonceBytes, ownerPublicKeyBytes);
        // take low and high 4 bytes
        byte[] low = Arrays.copyOfRange(hash, 0, 4);
        byte[] high = Arrays.copyOfRange(hash, 4, 8);
        // convert to little-endian
        ArrayUtils.reverse(low);
        ArrayUtils.reverse(high);
        // recombine back to one byte array
        // TODO check why does GO and high with 0x7FFFFFFF
        byte[] result = ArrayUtils.addAll(high, low);
        // return the result
        return new BigInteger(result);
    }
}
