package java.security.cert;

import java.security.GeneralSecurityException;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CertificateException.class */
public class CertificateException extends GeneralSecurityException {
    private static final long serialVersionUID = 3192535253797119798L;

    public CertificateException() {
    }

    public CertificateException(String str) {
        super(str);
    }

    public CertificateException(String str, Throwable th) {
        super(str, th);
    }

    public CertificateException(Throwable th) {
        super(th);
    }
}
