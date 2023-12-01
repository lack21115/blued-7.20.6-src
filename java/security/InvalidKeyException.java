package java.security;

/* loaded from: source-2895416-dex2jar.jar:java/security/InvalidKeyException.class */
public class InvalidKeyException extends KeyException {
    private static final long serialVersionUID = 5698479920593359816L;

    public InvalidKeyException() {
    }

    public InvalidKeyException(String str) {
        super(str);
    }

    public InvalidKeyException(String str, Throwable th) {
        super(str, th);
    }

    public InvalidKeyException(Throwable th) {
        super(th);
    }
}
