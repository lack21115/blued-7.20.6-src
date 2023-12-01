package com.android.org.conscrypt;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGeneratorSpi;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHParameterSpec;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLDHKeyPairGenerator.class */
public class OpenSSLDHKeyPairGenerator extends KeyPairGeneratorSpi {
    private static final BigInteger DEFAULT_GENERATOR = BigInteger.valueOf(2);
    private BigInteger prime;
    private int primeBits = 1024;
    private BigInteger generator = DEFAULT_GENERATOR;

    @Override // java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        OpenSSLKey openSSLKey = this.prime != null ? new OpenSSLKey(NativeCrypto.EVP_PKEY_new_DH(this.prime.toByteArray(), this.generator.toByteArray(), null, null)) : new OpenSSLKey(NativeCrypto.DH_generate_parameters_ex(this.primeBits, this.generator.longValue()));
        NativeCrypto.DH_generate_key(openSSLKey.getPkeyContext());
        return new KeyPair(new OpenSSLDHPublicKey(openSSLKey), new OpenSSLDHPrivateKey(openSSLKey));
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        this.prime = null;
        this.primeBits = i;
        this.generator = DEFAULT_GENERATOR;
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        this.prime = null;
        this.primeBits = 1024;
        this.generator = DEFAULT_GENERATOR;
        if (!(algorithmParameterSpec instanceof DHParameterSpec)) {
            if (algorithmParameterSpec != null) {
                throw new InvalidAlgorithmParameterException("Params must be DHParameterSpec");
            }
            return;
        }
        DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
        this.prime = dHParameterSpec.getP();
        BigInteger g = dHParameterSpec.getG();
        if (g != null) {
            this.generator = g;
        }
    }
}
