package javax.net.ssl;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/TrustManagerFactory.class */
public class TrustManagerFactory {
    private static final String DEFAULT_PROPERTY = "PKIX";
    private static final String PROPERTY_NAME = "ssl.TrustManagerFactory.algorithm";
    private final String algorithm;
    private final Provider provider;
    private final TrustManagerFactorySpi spiImpl;
    private static final String SERVICE = "TrustManagerFactory";
    private static final Engine ENGINE = new Engine(SERVICE);

    protected TrustManagerFactory(TrustManagerFactorySpi trustManagerFactorySpi, Provider provider, String str) {
        this.provider = provider;
        this.algorithm = str;
        this.spiImpl = trustManagerFactorySpi;
    }

    public static final String getDefaultAlgorithm() {
        String property = Security.getProperty(PROPERTY_NAME);
        return property != null ? property : DEFAULT_PROPERTY;
    }

    public static final TrustManagerFactory getInstance(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        Engine.SpiAndProvider engine = ENGINE.getInstance(str, (Object) null);
        return new TrustManagerFactory((TrustManagerFactorySpi) engine.spi, engine.provider, str);
    }

    public static final TrustManagerFactory getInstance(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (str2 == null || str2.length() == 0) {
            throw new IllegalArgumentException("Provider is null or empty");
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        return getInstance(str, provider);
    }

    public static final TrustManagerFactory getInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("Provider is null");
        }
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        return new TrustManagerFactory((TrustManagerFactorySpi) ENGINE.getInstance(str, provider, null), provider, str);
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final TrustManager[] getTrustManagers() {
        return this.spiImpl.engineGetTrustManagers();
    }

    public final void init(KeyStore keyStore) throws KeyStoreException {
        this.spiImpl.engineInit(keyStore);
    }

    public final void init(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException {
        this.spiImpl.engineInit(managerFactoryParameters);
    }
}
