package javax.crypto;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.ProviderException;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/Mac.class */
public class Mac implements Cloneable {
    private final String algorithm;
    private final Object initLock = new Object();
    private boolean isInitMac = false;
    private Provider provider;
    private final Provider specifiedProvider;
    private MacSpi spiImpl;
    private static final String SERVICE = "Mac";
    private static final Engine ENGINE = new Engine(SERVICE);

    protected Mac(MacSpi macSpi, Provider provider, String str) {
        this.specifiedProvider = provider;
        this.algorithm = str;
        this.spiImpl = macSpi;
    }

    public static final Mac getInstance(String str) throws NoSuchAlgorithmException {
        return getMac(str, null);
    }

    public static final Mac getInstance(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("Provider is null or empty");
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        return getMac(str, provider);
    }

    public static final Mac getInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        return getMac(str, provider);
    }

    private static Mac getMac(String str, Provider provider) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        if (tryAlgorithm(null, provider, str) == null) {
            if (provider == null) {
                throw new NoSuchAlgorithmException("No provider found for " + str);
            }
            throw new NoSuchAlgorithmException("Provider " + provider.getName() + " does not provide " + str);
        }
        return new Mac(null, provider, str);
    }

    private MacSpi getSpi() {
        return getSpi(null);
    }

    private MacSpi getSpi(Key key) {
        synchronized (this.initLock) {
            if (this.spiImpl != null && this.provider != null && key == null) {
                return this.spiImpl;
            } else if (this.algorithm == null) {
                return null;
            } else {
                Engine.SpiAndProvider tryAlgorithm = tryAlgorithm(key, this.specifiedProvider, this.algorithm);
                if (tryAlgorithm == null) {
                    throw new ProviderException("No provider for " + getAlgorithm());
                }
                if (this.spiImpl == null || this.provider != null) {
                    this.spiImpl = (MacSpi) tryAlgorithm.spi;
                }
                this.provider = tryAlgorithm.provider;
                return this.spiImpl;
            }
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
            if (!(spiAndProvider.spi instanceof MacSpi)) {
                return null;
            }
            return spiAndProvider;
        }
        return null;
    }

    public final Object clone() throws CloneNotSupportedException {
        MacSpi macSpi = null;
        MacSpi spi = getSpi();
        if (spi != null) {
            macSpi = (MacSpi) spi.clone();
        }
        Mac mac = new Mac(macSpi, this.provider, this.algorithm);
        mac.isInitMac = this.isInitMac;
        return mac;
    }

    public final void doFinal(byte[] bArr, int i) throws ShortBufferException, IllegalStateException {
        if (!this.isInitMac) {
            throw new IllegalStateException();
        }
        if (bArr == null) {
            throw new ShortBufferException("output == null");
        }
        if (i < 0 || i >= bArr.length) {
            throw new ShortBufferException("Incorrect outOffset: " + i);
        }
        MacSpi spi = getSpi();
        int engineGetMacLength = spi.engineGetMacLength();
        if (engineGetMacLength > bArr.length - i) {
            throw new ShortBufferException("Output buffer is short. Needed " + engineGetMacLength + " bytes.");
        }
        byte[] engineDoFinal = spi.engineDoFinal();
        System.arraycopy(engineDoFinal, 0, bArr, i, engineDoFinal.length);
    }

    public final byte[] doFinal() throws IllegalStateException {
        if (this.isInitMac) {
            return getSpi().engineDoFinal();
        }
        throw new IllegalStateException();
    }

    public final byte[] doFinal(byte[] bArr) throws IllegalStateException {
        if (this.isInitMac) {
            MacSpi spi = getSpi();
            if (bArr != null) {
                spi.engineUpdate(bArr, 0, bArr.length);
            }
            return spi.engineDoFinal();
        }
        throw new IllegalStateException();
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final int getMacLength() {
        return getSpi().engineGetMacLength();
    }

    public final Provider getProvider() {
        getSpi();
        return this.provider;
    }

    public final void init(Key key) throws InvalidKeyException {
        if (key == null) {
            throw new InvalidKeyException("key == null");
        }
        try {
            getSpi(key).engineInit(key, null);
            this.isInitMac = true;
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        }
    }

    public final void init(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (key == null) {
            throw new InvalidKeyException("key == null");
        }
        getSpi(key).engineInit(key, algorithmParameterSpec);
        this.isInitMac = true;
    }

    public final void reset() {
        getSpi().engineReset();
    }

    public final void update(byte b) throws IllegalStateException {
        if (!this.isInitMac) {
            throw new IllegalStateException();
        }
        getSpi().engineUpdate(b);
    }

    public final void update(ByteBuffer byteBuffer) {
        if (!this.isInitMac) {
            throw new IllegalStateException();
        }
        if (byteBuffer == null) {
            throw new IllegalArgumentException("input == null");
        }
        getSpi().engineUpdate(byteBuffer);
    }

    public final void update(byte[] bArr) throws IllegalStateException {
        if (!this.isInitMac) {
            throw new IllegalStateException();
        }
        if (bArr != null) {
            getSpi().engineUpdate(bArr, 0, bArr.length);
        }
    }

    public final void update(byte[] bArr, int i, int i2) throws IllegalStateException {
        if (!this.isInitMac) {
            throw new IllegalStateException();
        }
        if (bArr == null) {
            return;
        }
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IllegalArgumentException("Incorrect arguments. input.length=" + bArr.length + " offset=" + i + ", len=" + i2);
        }
        getSpi().engineUpdate(bArr, i, i2);
    }
}
