package javax.crypto;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/ExemptionMechanismSpi.class */
public abstract class ExemptionMechanismSpi {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int engineGenExemptionBlob(byte[] bArr, int i) throws ShortBufferException, ExemptionMechanismException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineGenExemptionBlob() throws ExemptionMechanismException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int engineGetOutputSize(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(Key key) throws InvalidKeyException, ExemptionMechanismException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(Key key, AlgorithmParameters algorithmParameters) throws InvalidKeyException, InvalidAlgorithmParameterException, ExemptionMechanismException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException, ExemptionMechanismException;
}
