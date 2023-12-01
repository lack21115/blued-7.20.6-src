package java.security.cert;

import java.security.GeneralSecurityException;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CertPathValidatorException.class */
public class CertPathValidatorException extends GeneralSecurityException {
    private static final long serialVersionUID = -3083180014971893139L;
    private CertPath certPath;
    private int index;

    public CertPathValidatorException() {
        this.index = -1;
    }

    public CertPathValidatorException(String str) {
        super(str);
        this.index = -1;
    }

    public CertPathValidatorException(String str, Throwable th) {
        super(str, th);
        this.index = -1;
    }

    public CertPathValidatorException(String str, Throwable th, CertPath certPath, int i) {
        super(str, th);
        this.index = -1;
        if (certPath == null && i != -1) {
            throw new IllegalArgumentException("Index should be -1 when CertPath is null");
        }
        if (certPath != null && (i < -1 || i >= certPath.getCertificates().size())) {
            throw new IndexOutOfBoundsException();
        }
        this.certPath = certPath;
        this.index = i;
    }

    public CertPathValidatorException(Throwable th) {
        super(th);
        this.index = -1;
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getIndex() {
        return this.index;
    }
}
