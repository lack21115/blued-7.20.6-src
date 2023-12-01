package java.security;

/* loaded from: source-2895416-dex2jar.jar:java/security/DigestException.class */
public class DigestException extends GeneralSecurityException {
    private static final long serialVersionUID = 5821450303093652515L;

    public DigestException() {
    }

    public DigestException(String str) {
        super(str);
    }

    public DigestException(String str, Throwable th) {
        super(str, th);
    }

    public DigestException(Throwable th) {
        super(th);
    }
}
