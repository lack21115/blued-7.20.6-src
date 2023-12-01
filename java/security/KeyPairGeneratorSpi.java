package java.security;

import java.security.spec.AlgorithmParameterSpec;

/* loaded from: source-2895416-dex2jar.jar:java/security/KeyPairGeneratorSpi.class */
public abstract class KeyPairGeneratorSpi {
    public abstract KeyPair generateKeyPair();

    public abstract void initialize(int i, SecureRandom secureRandom);

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new UnsupportedOperationException();
    }
}
