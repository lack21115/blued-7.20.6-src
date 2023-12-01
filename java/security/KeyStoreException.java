package java.security;

/* loaded from: source-2895416-dex2jar.jar:java/security/KeyStoreException.class */
public class KeyStoreException extends GeneralSecurityException {
    private static final long serialVersionUID = -1119353179322377262L;

    public KeyStoreException() {
    }

    public KeyStoreException(String str) {
        super(str);
    }

    public KeyStoreException(String str, Throwable th) {
        super(str, th);
    }

    public KeyStoreException(Throwable th) {
        super(th);
    }
}
