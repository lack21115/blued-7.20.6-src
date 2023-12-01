package java.security;

/* loaded from: source-2895416-dex2jar.jar:java/security/SignatureException.class */
public class SignatureException extends GeneralSecurityException {
    private static final long serialVersionUID = 7509989324975124438L;

    public SignatureException() {
    }

    public SignatureException(String str) {
        super(str);
    }

    public SignatureException(String str, Throwable th) {
        super(str, th);
    }

    public SignatureException(Throwable th) {
        super(th);
    }
}
