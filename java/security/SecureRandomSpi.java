package java.security;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/security/SecureRandomSpi.class */
public abstract class SecureRandomSpi implements Serializable {
    private static final long serialVersionUID = -2991854161009191830L;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineGenerateSeed(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineNextBytes(byte[] bArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineSetSeed(byte[] bArr);
}
