package java.security.spec;

import java.security.GeneralSecurityException;

/* loaded from: source-2895416-dex2jar.jar:java/security/spec/InvalidKeySpecException.class */
public class InvalidKeySpecException extends GeneralSecurityException {
    private static final long serialVersionUID = 3546139293998810778L;

    public InvalidKeySpecException() {
    }

    public InvalidKeySpecException(String str) {
        super(str);
    }

    public InvalidKeySpecException(String str, Throwable th) {
        super(str, th);
    }

    public InvalidKeySpecException(Throwable th) {
        super(th);
    }
}
