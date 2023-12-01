package javax.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.ProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/KeyAgreement.class */
public class KeyAgreement {
    private final String algorithm;
    private final Object initLock = new Object();
    private Provider provider;
    private final Provider specifiedProvider;
    private KeyAgreementSpi spiImpl;
    private static final String SERVICE = "KeyAgreement";
    private static final Engine ENGINE = new Engine(SERVICE);
    private static final SecureRandom RANDOM = new SecureRandom();

    protected KeyAgreement(KeyAgreementSpi keyAgreementSpi, Provider provider, String str) {
        this.spiImpl = keyAgreementSpi;
        this.specifiedProvider = provider;
        this.algorithm = str;
    }

    public static final KeyAgreement getInstance(String str) throws NoSuchAlgorithmException {
        return getKeyAgreement(str, null);
    }

    public static final KeyAgreement getInstance(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("Provider is null or empty");
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        return getKeyAgreement(str, provider);
    }

    public static final KeyAgreement getInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        return getKeyAgreement(str, provider);
    }

    private static KeyAgreement getKeyAgreement(String str, Provider provider) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        if (tryAlgorithm(null, provider, str) == null) {
            if (provider == null) {
                throw new NoSuchAlgorithmException("No provider found for " + str);
            }
            throw new NoSuchAlgorithmException("Provider " + provider.getName() + " does not provide " + str);
        }
        return new KeyAgreement(null, provider, str);
    }

    private KeyAgreementSpi getSpi() {
        return getSpi(null);
    }

    private KeyAgreementSpi getSpi(Key key) {
        synchronized (this.initLock) {
            if (this.spiImpl != null && key == null) {
                return this.spiImpl;
            }
            Engine.SpiAndProvider tryAlgorithm = tryAlgorithm(key, this.specifiedProvider, this.algorithm);
            if (tryAlgorithm == null) {
                throw new ProviderException("No provider for " + getAlgorithm());
            }
            this.spiImpl = (KeyAgreementSpi) tryAlgorithm.spi;
            this.provider = tryAlgorithm.provider;
            return this.spiImpl;
        }
    }

    private static Engine.SpiAndProvider tryAlgorithm(Key key, Provider provider, String str) {
        if (provider != null) {
            Provider.Service service = provider.getService(SERVICE, str);
            if (service == null) {
                return null;
            }
            return tryAlgorithmWithProvider(key, service);
        }
        ArrayList<Provider.Service> services = ENGINE.getServices(str);
        if (services == null) {
            return null;
        }
        Iterator<Provider.Service> it = services.iterator();
        while (it.hasNext()) {
            Engine.SpiAndProvider tryAlgorithmWithProvider = tryAlgorithmWithProvider(key, it.next());
            if (tryAlgorithmWithProvider != null) {
                return tryAlgorithmWithProvider;
            }
        }
        return null;
    }

    private static Engine.SpiAndProvider tryAlgorithmWithProvider(Key key, Provider.Service service) {
        Engine.SpiAndProvider spiAndProvider;
        if (key != null) {
            try {
                if (!service.supportsParameter(key)) {
                    return null;
                }
            } catch (NoSuchAlgorithmException e) {
                spiAndProvider = null;
            }
        }
        spiAndProvider = ENGINE.getInstance(service, (String) null);
        if (spiAndProvider.spi != null && spiAndProvider.provider != null) {
            if (!(spiAndProvider.spi instanceof KeyAgreementSpi)) {
                return null;
            }
            return spiAndProvider;
        }
        return null;
    }

    public final Key doPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        return getSpi().engineDoPhase(key, z);
    }

    public final int generateSecret(byte[] bArr, int i) throws IllegalStateException, ShortBufferException {
        return getSpi().engineGenerateSecret(bArr, i);
    }

    public final SecretKey generateSecret(String str) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        return getSpi().engineGenerateSecret(str);
    }

    public final byte[] generateSecret() throws IllegalStateException {
        return getSpi().engineGenerateSecret();
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final Provider getProvider() {
        getSpi();
        return this.provider;
    }

    public final void init(Key key) throws InvalidKeyException {
        getSpi(key).engineInit(key, RANDOM);
    }

    public final void init(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        getSpi(key).engineInit(key, secureRandom);
    }

    public final void init(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        getSpi(key).engineInit(key, algorithmParameterSpec, RANDOM);
    }

    public final void init(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        getSpi(key).engineInit(key, algorithmParameterSpec, secureRandom);
    }
}
