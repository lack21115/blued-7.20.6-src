package java.security.cert;

import java.security.GeneralSecurityException;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CertStoreException.class */
public class CertStoreException extends GeneralSecurityException {
    private static final long serialVersionUID = 2395296107471573245L;

    public CertStoreException() {
    }

    public CertStoreException(String str) {
        super(str);
    }

    public CertStoreException(String str, Throwable th) {
        super(str, th);
    }

    public CertStoreException(Throwable th) {
        super(th);
    }
}
