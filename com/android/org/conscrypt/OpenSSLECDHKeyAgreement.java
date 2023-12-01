package com.android.org.conscrypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLECDHKeyAgreement.class */
public final class OpenSSLECDHKeyAgreement extends KeyAgreementSpi {
    private int mExpectedResultLength;
    private OpenSSLKey mOpenSslPrivateKey;
    private byte[] mResult;

    private void checkCompleted() {
        if (this.mResult == null) {
            throw new IllegalStateException("Key agreement not completed");
        }
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException {
        if (this.mOpenSslPrivateKey == null) {
            throw new IllegalStateException("Not initialized");
        }
        if (z) {
            if (key == null) {
                throw new InvalidKeyException("key == null");
            }
            if (key instanceof PublicKey) {
                OpenSSLKey fromPublicKey = OpenSSLKey.fromPublicKey((PublicKey) key);
                byte[] bArr = new byte[this.mExpectedResultLength];
                int ECDH_compute_key = NativeCrypto.ECDH_compute_key(bArr, 0, fromPublicKey.getPkeyContext(), this.mOpenSslPrivateKey.getPkeyContext());
                if (ECDH_compute_key == -1) {
                    throw new RuntimeException("Engine returned " + ECDH_compute_key);
                }
                if (ECDH_compute_key != this.mExpectedResultLength) {
                    if (ECDH_compute_key >= this.mExpectedResultLength) {
                        throw new RuntimeException("Engine produced a longer than expected result. Expected: " + this.mExpectedResultLength + ", actual: " + ECDH_compute_key);
                    }
                    System.arraycopy(bArr, 0, this.mResult, 0, this.mResult.length);
                    bArr = new byte[ECDH_compute_key];
                }
                this.mResult = bArr;
                return null;
            }
            throw new InvalidKeyException("Not a public key: " + key.getClass());
        }
        throw new IllegalStateException("ECDH only has one phase");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i) throws ShortBufferException {
        checkCompleted();
        int length = bArr.length - i;
        if (this.mResult.length > length) {
            throw new ShortBufferException("Needed: " + this.mResult.length + ", available: " + length);
        }
        System.arraycopy(this.mResult, 0, bArr, i, this.mResult.length);
        return this.mResult.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String str) {
        checkCompleted();
        return new SecretKeySpec(engineGenerateSecret(), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() {
        checkCompleted();
        return this.mResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key == null) {
            throw new InvalidKeyException("key == null");
        }
        if (!(key instanceof PrivateKey)) {
            throw new InvalidKeyException("Not a private key: " + key.getClass());
        }
        OpenSSLKey fromPrivateKey = OpenSSLKey.fromPrivateKey((PrivateKey) key);
        this.mExpectedResultLength = (NativeCrypto.EC_GROUP_get_degree(NativeCrypto.EC_KEY_get0_group(fromPrivateKey.getPkeyContext())) + 7) / 8;
        this.mOpenSslPrivateKey = fromPrivateKey;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec != null) {
            throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
        }
        engineInit(key, secureRandom);
    }
}
