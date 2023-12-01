package java.security.cert;

import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CertificateFactorySpi.class */
public abstract class CertificateFactorySpi {
    public abstract CRL engineGenerateCRL(InputStream inputStream) throws CRLException;

    public abstract Collection<? extends CRL> engineGenerateCRLs(InputStream inputStream) throws CRLException;

    public CertPath engineGenerateCertPath(InputStream inputStream) throws CertificateException {
        throw new UnsupportedOperationException();
    }

    public CertPath engineGenerateCertPath(InputStream inputStream, String str) throws CertificateException {
        throw new UnsupportedOperationException();
    }

    public CertPath engineGenerateCertPath(List<? extends Certificate> list) throws CertificateException {
        throw new UnsupportedOperationException();
    }

    public abstract Certificate engineGenerateCertificate(InputStream inputStream) throws CertificateException;

    public abstract Collection<? extends Certificate> engineGenerateCertificates(InputStream inputStream) throws CertificateException;

    public Iterator<String> engineGetCertPathEncodings() {
        throw new UnsupportedOperationException();
    }
}
