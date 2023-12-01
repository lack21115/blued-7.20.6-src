package java.security.cert;

import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CertificateFactory.class */
public class CertificateFactory {
    private final Provider provider;
    private final CertificateFactorySpi spiImpl;
    private final String type;
    private static final String SERVICE = "CertificateFactory";
    private static final Engine ENGINE = new Engine(SERVICE);

    protected CertificateFactory(CertificateFactorySpi certificateFactorySpi, Provider provider, String str) {
        this.provider = provider;
        this.type = str;
        this.spiImpl = certificateFactorySpi;
    }

    public static final CertificateFactory getInstance(String str) throws CertificateException {
        if (str == null) {
            throw new NullPointerException("type == null");
        }
        try {
            Engine.SpiAndProvider engine = ENGINE.getInstance(str, (Object) null);
            return new CertificateFactory((CertificateFactorySpi) engine.spi, engine.provider, str);
        } catch (NoSuchAlgorithmException e) {
            throw new CertificateException(e);
        }
    }

    public static final CertificateFactory getInstance(String str, String str2) throws CertificateException, NoSuchProviderException {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("provider == null || provider.isEmpty()");
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        return getInstance(str, provider);
    }

    public static final CertificateFactory getInstance(String str, Provider provider) throws CertificateException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (str == null) {
            throw new NullPointerException("type == null");
        }
        try {
            return new CertificateFactory((CertificateFactorySpi) ENGINE.getInstance(str, provider, null), provider, str);
        } catch (NoSuchAlgorithmException e) {
            throw new CertificateException(e);
        }
    }

    public final CRL generateCRL(InputStream inputStream) throws CRLException {
        return this.spiImpl.engineGenerateCRL(inputStream);
    }

    public final Collection<? extends CRL> generateCRLs(InputStream inputStream) throws CRLException {
        return this.spiImpl.engineGenerateCRLs(inputStream);
    }

    public final CertPath generateCertPath(InputStream inputStream) throws CertificateException {
        Iterator<String> certPathEncodings = getCertPathEncodings();
        if (certPathEncodings.hasNext()) {
            return this.spiImpl.engineGenerateCertPath(inputStream, certPathEncodings.next());
        }
        throw new CertificateException("There are no CertPath encodings");
    }

    public final CertPath generateCertPath(InputStream inputStream, String str) throws CertificateException {
        return this.spiImpl.engineGenerateCertPath(inputStream, str);
    }

    public final CertPath generateCertPath(List<? extends Certificate> list) throws CertificateException {
        return this.spiImpl.engineGenerateCertPath(list);
    }

    public final Certificate generateCertificate(InputStream inputStream) throws CertificateException {
        return this.spiImpl.engineGenerateCertificate(inputStream);
    }

    public final Collection<? extends Certificate> generateCertificates(InputStream inputStream) throws CertificateException {
        return this.spiImpl.engineGenerateCertificates(inputStream);
    }

    public final Iterator<String> getCertPathEncodings() {
        return this.spiImpl.engineGetCertPathEncodings();
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final String getType() {
        return this.type;
    }
}
