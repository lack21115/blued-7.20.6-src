package java.security.cert;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CertPathBuilder.class */
public class CertPathBuilder {
    private static final String DEFAULT_PROPERTY = "PKIX";
    private static final String PROPERTY_NAME = "certpathbuilder.type";
    private final String algorithm;
    private final Provider provider;
    private final CertPathBuilderSpi spiImpl;
    private static final String SERVICE = "CertPathBuilder";
    private static final Engine ENGINE = new Engine(SERVICE);

    protected CertPathBuilder(CertPathBuilderSpi certPathBuilderSpi, Provider provider, String str) {
        this.provider = provider;
        this.algorithm = str;
        this.spiImpl = certPathBuilderSpi;
    }

    public static final String getDefaultType() {
        String property = Security.getProperty(PROPERTY_NAME);
        return property != null ? property : DEFAULT_PROPERTY;
    }

    public static CertPathBuilder getInstance(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        Engine.SpiAndProvider engine = ENGINE.getInstance(str, (Object) null);
        return new CertPathBuilder((CertPathBuilderSpi) engine.spi, engine.provider, str);
    }

    public static CertPathBuilder getInstance(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("provider == null || provider.isEmpty()");
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        return getInstance(str, provider);
    }

    public static CertPathBuilder getInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        return new CertPathBuilder((CertPathBuilderSpi) ENGINE.getInstance(str, provider, null), provider, str);
    }

    public final CertPathBuilderResult build(CertPathParameters certPathParameters) throws CertPathBuilderException, InvalidAlgorithmParameterException {
        return this.spiImpl.engineBuild(certPathParameters);
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final Provider getProvider() {
        return this.provider;
    }
}
