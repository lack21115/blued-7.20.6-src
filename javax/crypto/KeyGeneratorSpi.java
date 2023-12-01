package javax.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/KeyGeneratorSpi.class */
public abstract class KeyGeneratorSpi {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SecretKey engineGenerateKey();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(int i, SecureRandom secureRandom);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(SecureRandom secureRandom);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException;
}
