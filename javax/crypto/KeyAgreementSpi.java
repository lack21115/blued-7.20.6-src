package javax.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/KeyAgreementSpi.class */
public abstract class KeyAgreementSpi {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int engineGenerateSecret(byte[] bArr, int i) throws IllegalStateException, ShortBufferException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SecretKey engineGenerateSecret(String str) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineGenerateSecret() throws IllegalStateException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;
}
