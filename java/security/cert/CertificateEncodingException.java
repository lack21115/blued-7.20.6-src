package java.security.cert;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CertificateEncodingException.class */
public class CertificateEncodingException extends CertificateException {
    private static final long serialVersionUID = 6219492851589449162L;

    public CertificateEncodingException() {
    }

    public CertificateEncodingException(String str) {
        super(str);
    }

    public CertificateEncodingException(String str, Throwable th) {
        super(str, th);
    }

    public CertificateEncodingException(Throwable th) {
        super(th);
    }
}
