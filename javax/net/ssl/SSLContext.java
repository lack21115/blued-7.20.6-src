package javax.net.ssl;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/SSLContext.class */
public class SSLContext {
    private static SSLContext DEFAULT;
    private final String protocol;
    private final Provider provider;
    private final SSLContextSpi spiImpl;
    private static final String SERVICE = "SSLContext";
    private static final Engine ENGINE = new Engine(SERVICE);

    protected SSLContext(SSLContextSpi sSLContextSpi, Provider provider, String str) {
        this.provider = provider;
        this.protocol = str;
        this.spiImpl = sSLContextSpi;
    }

    public static SSLContext getDefault() throws NoSuchAlgorithmException {
        SSLContext sSLContext;
        synchronized (ENGINE) {
            if (DEFAULT == null) {
                DEFAULT = getInstance("Default");
            }
            sSLContext = DEFAULT;
        }
        return sSLContext;
    }

    public static SSLContext getInstance(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("protocol == null");
        }
        Engine.SpiAndProvider engine = ENGINE.getInstance(str, (Object) null);
        return new SSLContext((SSLContextSpi) engine.spi, engine.provider, str);
    }

    public static SSLContext getInstance(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (str2 == null) {
            throw new IllegalArgumentException("Provider is null");
        }
        if (str2.length() == 0) {
            throw new IllegalArgumentException("Provider is empty");
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        return getInstance(str, provider);
    }

    public static SSLContext getInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider is null");
        }
        if (str == null) {
            throw new NullPointerException("protocol == null");
        }
        return new SSLContext((SSLContextSpi) ENGINE.getInstance(str, provider, null), provider, str);
    }

    public static void setDefault(SSLContext sSLContext) {
        if (sSLContext == null) {
            throw new NullPointerException("sslContext == null");
        }
        synchronized (ENGINE) {
            DEFAULT = sSLContext;
        }
    }

    public final SSLEngine createSSLEngine() {
        return this.spiImpl.engineCreateSSLEngine();
    }

    public final SSLEngine createSSLEngine(String str, int i) {
        return this.spiImpl.engineCreateSSLEngine(str, i);
    }

    public final SSLSessionContext getClientSessionContext() {
        return this.spiImpl.engineGetClientSessionContext();
    }

    public final SSLParameters getDefaultSSLParameters() {
        return this.spiImpl.engineGetDefaultSSLParameters();
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final SSLSessionContext getServerSessionContext() {
        return this.spiImpl.engineGetServerSessionContext();
    }

    public final SSLServerSocketFactory getServerSocketFactory() {
        return this.spiImpl.engineGetServerSocketFactory();
    }

    public final SSLSocketFactory getSocketFactory() {
        return this.spiImpl.engineGetSocketFactory();
    }

    public final SSLParameters getSupportedSSLParameters() {
        return this.spiImpl.engineGetSupportedSSLParameters();
    }

    public final void init(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) throws KeyManagementException {
        this.spiImpl.engineInit(keyManagerArr, trustManagerArr, secureRandom);
    }
}
