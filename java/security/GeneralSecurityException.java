package java.security;

/* loaded from: source-2895416-dex2jar.jar:java/security/GeneralSecurityException.class */
public class GeneralSecurityException extends Exception {
    private static final long serialVersionUID = 894798122053539237L;

    public GeneralSecurityException() {
    }

    public GeneralSecurityException(String str) {
        super(str);
    }

    public GeneralSecurityException(String str, Throwable th) {
        super(str, th);
    }

    public GeneralSecurityException(Throwable th) {
        super(th);
    }
}
