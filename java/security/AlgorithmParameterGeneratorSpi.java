package java.security;

import java.security.spec.AlgorithmParameterSpec;

/* loaded from: source-2895416-dex2jar.jar:java/security/AlgorithmParameterGeneratorSpi.class */
public abstract class AlgorithmParameterGeneratorSpi {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract AlgorithmParameters engineGenerateParameters();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(int i, SecureRandom secureRandom);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException;
}
