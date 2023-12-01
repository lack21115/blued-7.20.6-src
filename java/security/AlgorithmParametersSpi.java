package java.security;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

/* loaded from: source-2895416-dex2jar.jar:java/security/AlgorithmParametersSpi.class */
public abstract class AlgorithmParametersSpi {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineGetEncoded() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineGetEncoded(String str) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(byte[] bArr) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(byte[] bArr, String str) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String engineToString();
}
