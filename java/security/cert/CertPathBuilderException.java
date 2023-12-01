package java.security.cert;

import java.security.GeneralSecurityException;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CertPathBuilderException.class */
public class CertPathBuilderException extends GeneralSecurityException {
    private static final long serialVersionUID = 5316471420178794402L;

    public CertPathBuilderException() {
    }

    public CertPathBuilderException(String str) {
        super(str);
    }

    public CertPathBuilderException(String str, Throwable th) {
        super(str, th);
    }

    public CertPathBuilderException(Throwable th) {
        super(th);
    }
}
