package java.security.cert;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/CertPathValidator.class */
public class CertPathValidator {
    private static final String DEFAULT_PROPERTY = "PKIX";
    private static final String PROPERTY_NAME = "certpathvalidator.type";
    private final String algorithm;
    private final Provider provider;
    private final CertPathValidatorSpi spiImpl;
    private static final String SERVICE = "CertPathValidator";
    private static final Engine ENGINE = new Engine(SERVICE);

    protected CertPathValidator(CertPathValidatorSpi certPathValidatorSpi, Provider provider, String str) {
        this.provider = provider;
        this.algorithm = str;
        this.spiImpl = certPathValidatorSpi;
    }

    public static final String getDefaultType() {
        String property = Security.getProperty(PROPERTY_NAME);
        return property != null ? property : DEFAULT_PROPERTY;
    }

    public static CertPathValidator getInstance(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        Engine.SpiAndProvider engine = ENGINE.getInstance(str, (Object) null);
        return new CertPathValidator((CertPathValidatorSpi) engine.spi, engine.provider, str);
    }

    public static CertPathValidator getInstance(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        return getInstance(str, provider);
    }

    public static CertPathValidator getInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        return new CertPathValidator((CertPathValidatorSpi) ENGINE.getInstance(str, provider, null), provider, str);
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final CertPathValidatorResult validate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        return this.spiImpl.engineValidate(certPath, certPathParameters);
    }
}
