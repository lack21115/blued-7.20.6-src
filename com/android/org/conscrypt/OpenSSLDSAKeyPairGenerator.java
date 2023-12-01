package com.android.org.conscrypt;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGeneratorSpi;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLDSAKeyPairGenerator.class */
public class OpenSSLDSAKeyPairGenerator extends KeyPairGeneratorSpi {
    private byte[] g;
    private byte[] p;
    private byte[] q;
    private int primeBits = 1024;
    private SecureRandom random = null;

    @Override // java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        byte[] bArr;
        if (this.random == null) {
            bArr = null;
        } else {
            bArr = new byte[20];
            this.random.nextBytes(bArr);
        }
        OpenSSLKey openSSLKey = new OpenSSLKey(NativeCrypto.DSA_generate_key(this.primeBits, bArr, this.g, this.p, this.q));
        return new KeyPair(new OpenSSLDSAPublicKey(openSSLKey), new OpenSSLDSAPrivateKey(openSSLKey));
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        this.primeBits = i;
        this.random = secureRandom;
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        this.random = secureRandom;
        if (!(algorithmParameterSpec instanceof DSAParameterSpec)) {
            if (algorithmParameterSpec != null) {
                throw new InvalidAlgorithmParameterException("Params must be DSAParameterSpec");
            }
            return;
        }
        DSAParameterSpec dSAParameterSpec = (DSAParameterSpec) algorithmParameterSpec;
        BigInteger g = dSAParameterSpec.getG();
        if (g != null) {
            this.g = g.toByteArray();
        }
        BigInteger p = dSAParameterSpec.getP();
        if (p != null) {
            this.p = p.toByteArray();
        }
        BigInteger q = dSAParameterSpec.getQ();
        if (q != null) {
            this.q = q.toByteArray();
        }
    }
}
