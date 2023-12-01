package java.security.cert;

import java.security.GeneralSecurityException;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CRLException.class */
public class CRLException extends GeneralSecurityException {
    private static final long serialVersionUID = -6694728944094197147L;

    public CRLException() {
    }

    public CRLException(String str) {
        super(str);
    }

    public CRLException(String str, Throwable th) {
        super(str, th);
    }

    public CRLException(Throwable th) {
        super(th);
    }
}
