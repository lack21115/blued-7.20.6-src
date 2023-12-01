package java.security.cert;

import java.security.InvalidAlgorithmParameterException;
import java.util.Collection;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CertStoreSpi.class */
public abstract class CertStoreSpi {
    public CertStoreSpi(CertStoreParameters certStoreParameters) throws InvalidAlgorithmParameterException {
    }

    public abstract Collection<? extends CRL> engineGetCRLs(CRLSelector cRLSelector) throws CertStoreException;

    public abstract Collection<? extends Certificate> engineGetCertificates(CertSelector certSelector) throws CertStoreException;
}
