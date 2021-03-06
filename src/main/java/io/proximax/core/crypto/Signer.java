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

package io.proximax.core.crypto;

/**
 * Wraps DSA signing and verification logic.
 */
public class Signer implements DsaSigner {
    private final DsaSigner signer;

    /**
     * Creates a signer around a KeyPair.
     *
     * @param keyPair The KeyPair that should be used for signing and verification.
     */
    public Signer(final KeyPair keyPair) {
        this(keyPair, CryptoEngines.defaultEngine());
    }

    /**
     * Creates a signer around a KeyPair.
     *
     * @param keyPair The KeyPair that should be used for signing and verification.
     * @param engine  The crypto engine.
     */
    public Signer(final KeyPair keyPair, final CryptoEngine engine) {
        this(engine.createDsaSigner(keyPair));
    }

    /**
     * Creates a signer around a DsaSigner.
     *
     * @param signer The signer.
     */
    public Signer(final DsaSigner signer) {
        this.signer = signer;
    }

    @Override
    public Signature sign(final byte[] data) {
        return this.signer.sign(data);
    }

    @Override
    public boolean verify(final byte[] data, final Signature signature) {
        return this.signer.verify(data, signature);
    }

    @Override
    public boolean isCanonicalSignature(final Signature signature) {
        return this.signer.isCanonicalSignature(signature);
    }

    @Override
    public Signature makeSignatureCanonical(final Signature signature) {
        return this.signer.makeSignatureCanonical(signature);
    }
}
