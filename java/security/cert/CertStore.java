package java.security.cert;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.util.Collection;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CertStore.class */
public class CertStore {
    private static final String DEFAULT_PROPERTY = "LDAP";
    private static final String PROPERTY_NAME = "certstore.type";
    private final CertStoreParameters certStoreParams;
    private final Provider provider;
    private final CertStoreSpi spiImpl;
    private final String type;
    private static final String SERVICE = "CertStore";
    private static final Engine ENGINE = new Engine(SERVICE);

    protected CertStore(CertStoreSpi certStoreSpi, Provider provider, String str, CertStoreParameters certStoreParameters) {
        this.provider = provider;
        this.type = str;
        this.spiImpl = certStoreSpi;
        this.certStoreParams = certStoreParameters;
    }

    public static final String getDefaultType() {
        String property = Security.getProperty(PROPERTY_NAME);
        String str = property;
        if (property == null) {
            str = DEFAULT_PROPERTY;
        }
        return str;
    }

    public static CertStore getInstance(String str, CertStoreParameters certStoreParameters) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("type == null");
        }
        try {
            Engine.SpiAndProvider engine = ENGINE.getInstance(str, certStoreParameters);
            return new CertStore((CertStoreSpi) engine.spi, engine.provider, str, certStoreParameters);
        } catch (NoSuchAlgorithmException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                throw e;
            }
            throw new InvalidAlgorithmParameterException(e.getMessage(), cause);
        }
    }

    public static CertStore getInstance(String str, CertStoreParameters certStoreParameters, String str2) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("provider == null || provider.isEmpty()");
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        return getInstance(str, certStoreParameters, provider);
    }

    public static CertStore getInstance(String str, CertStoreParameters certStoreParameters, Provider provider) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (str == null) {
            throw new NullPointerException("type == null");
        }
        try {
            return new CertStore((CertStoreSpi) ENGINE.getInstance(str, provider, certStoreParameters), provider, str, certStoreParameters);
        } catch (NoSuchAlgorithmException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                throw e;
            }
            throw new InvalidAlgorithmParameterException(e.getMessage(), cause);
        }
    }

    public final Collection<? extends CRL> getCRLs(CRLSelector cRLSelector) throws CertStoreException {
        return this.spiImpl.engineGetCRLs(cRLSelector);
    }

    public final CertStoreParameters getCertStoreParameters() {
        if (this.certStoreParams == null) {
            return null;
        }
        return (CertStoreParameters) this.certStoreParams.clone();
    }

    public final Collection<? extends Certificate> getCertificates(CertSelector certSelector) throws CertStoreException {
        return this.spiImpl.engineGetCertificates(certSelector);
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final String getType() {
        return this.type;
    }
}
