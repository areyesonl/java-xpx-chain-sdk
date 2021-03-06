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

package io.proximax.core.crypto.ed25519;

import java.math.BigInteger;
import java.util.Arrays;

import io.proximax.core.crypto.CryptoException;
import io.proximax.core.crypto.DsaSigner;
import io.proximax.core.crypto.Hashes;
import io.proximax.core.crypto.KeyPair;
import io.proximax.core.crypto.Signature;
import io.proximax.core.crypto.ed25519.arithmetic.Ed25519EncodedFieldElement;
import io.proximax.core.crypto.ed25519.arithmetic.Ed25519EncodedGroupElement;
import io.proximax.core.crypto.ed25519.arithmetic.Ed25519Group;
import io.proximax.core.crypto.ed25519.arithmetic.Ed25519GroupElement;
import io.proximax.core.utils.ArrayUtils;

/**
 * Implementation of the DSA signer for Ed25519.
 */
public class Ed25519DsaSigner implements DsaSigner {

    private final KeyPair keyPair;

    /**
     * Creates a Ed25519 DSA signer.
     *
     * @param keyPair The key pair to use.
     */
    public Ed25519DsaSigner(final KeyPair keyPair) {
        this.keyPair = keyPair;
    }

    /**
     * Gets the underlying key pair.
     *
     * @return The key pair.
     */
    public KeyPair getKeyPair() {
        return this.keyPair;
    }

    @Override
    public Signature sign(final byte[] data) {
        if (!this.getKeyPair().hasPrivateKey()) {
            throw new CryptoException("cannot sign without private key");
        }

        // Hash the private key to improve randomness.
        final byte[] hash = Hashes.sha3_512(this.getKeyPair().getPrivateKey().getBytes());

        // r = H(hash_b,...,hash_2b-1, data) where b=256.
        final Ed25519EncodedFieldElement r = new Ed25519EncodedFieldElement(Hashes.sha3_512(
                Arrays.copyOfRange(hash, 32, 64),        // only include the last 32 bytes of the private key hash
                data));

        // Reduce size of r since we are calculating mod group order anyway
        final Ed25519EncodedFieldElement rModQ = r.modQ();

        // R = rModQ * base point.
        final Ed25519GroupElement R = Ed25519Group.BASE_POINT.scalarMultiply(rModQ);
        final Ed25519EncodedGroupElement encodedR = R.encode();

        // S = (r + H(encodedR, encodedA, data) * a) mod group order where
        // encodedR and encodedA are the little endian encodings of the group element R and the public key A and
        // a is the lower 32 bytes of hash after clamping.
        final Ed25519EncodedFieldElement h = new Ed25519EncodedFieldElement(Hashes.sha3_512(
                encodedR.getRaw(),
                this.getKeyPair().getPublicKey().getRaw(),
                data));
        final Ed25519EncodedFieldElement hModQ = h.modQ();
        final Ed25519EncodedFieldElement encodedS = hModQ.multiplyAndAddModQ(
                Ed25519Utils.prepareForScalarMultiply(this.getKeyPair().getPrivateKey()),
                rModQ);

        // Signature is (encodedR, encodedS)
        final Signature signature = new Signature(encodedR.getRaw(), encodedS.getRaw());
        if (!this.isCanonicalSignature(signature)) {
            throw new CryptoException("Generated signature is not canonical");
        }

        return signature;
    }

    @Override
    public boolean verify(final byte[] data, final Signature signature) {
        if (!this.isCanonicalSignature(signature)) {
            return false;
        }

        if (1 == ArrayUtils.isEqualConstantTime(this.getKeyPair().getPublicKey().getRaw(), new byte[32])) {
            return false;
        }

        // h = H(encodedR, encodedA, data).
        final byte[] rawEncodedR = signature.getBinaryR();
        final byte[] rawEncodedA = this.getKeyPair().getPublicKey().getRaw();
        final Ed25519EncodedFieldElement h = new Ed25519EncodedFieldElement(Hashes.sha3_512(
                rawEncodedR,
                rawEncodedA,
                data));

        // hReduced = h mod group order
        final Ed25519EncodedFieldElement hModQ = h.modQ();

        // Must compute A.
        final Ed25519GroupElement A = new Ed25519EncodedGroupElement(rawEncodedA).decode();
        A.precomputeForDoubleScalarMultiplication();

        // R = encodedS * B - H(encodedR, encodedA, data) * A
        final Ed25519GroupElement calculatedR = Ed25519Group.BASE_POINT.doubleScalarMultiplyVariableTime(
                A,
                hModQ,
                new Ed25519EncodedFieldElement(signature.getBinaryS()));

        // Compare calculated R to given R.
        final byte[] encodedCalculatedR = calculatedR.encode().getRaw();
        final int result = ArrayUtils.isEqualConstantTime(encodedCalculatedR, rawEncodedR);
        return 1 == result;
    }

    @Override
    public boolean isCanonicalSignature(final Signature signature) {
        return -1 == signature.getS().compareTo(Ed25519Group.GROUP_ORDER) &&
                1 == signature.getS().compareTo(BigInteger.ZERO);
    }

    @Override
    public Signature makeSignatureCanonical(final Signature signature) {
        final Ed25519EncodedFieldElement s = new Ed25519EncodedFieldElement(Arrays.copyOf(signature.getBinaryS(), 64));
        final Ed25519EncodedFieldElement sModQ = s.modQ();

        return new Signature(signature.getBinaryR(), sModQ.getRaw());
    }
}
