package javax.crypto;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/ExemptionMechanism.class */
public class ExemptionMechanism {
    private static final Engine ENGINE = new Engine("ExemptionMechanism");
    private boolean generated;
    private Key initKey;
    private boolean isInit = false;
    private final String mechanism;
    private final Provider provider;
    private final ExemptionMechanismSpi spiImpl;

    protected ExemptionMechanism(ExemptionMechanismSpi exemptionMechanismSpi, Provider provider, String str) {
        this.mechanism = str;
        this.spiImpl = exemptionMechanismSpi;
        this.provider = provider;
    }

    public static final ExemptionMechanism getInstance(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        Engine.SpiAndProvider engine = ENGINE.getInstance(str, (Object) null);
        return new ExemptionMechanism((ExemptionMechanismSpi) engine.spi, engine.provider, str);
    }

    public static final ExemptionMechanism getInstance(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (str2 == null) {
            throw new IllegalArgumentException("provider == null");
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        return getInstance(str, provider);
    }

    public static final ExemptionMechanism getInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        return new ExemptionMechanism((ExemptionMechanismSpi) ENGINE.getInstance(str, provider, null), provider, str);
    }

    protected void finalize() {
        try {
            super.finalize();
        } catch (Throwable th) {
            throw new AssertionError(th);
        }
    }

    public final int genExemptionBlob(byte[] bArr) throws IllegalStateException, ShortBufferException, ExemptionMechanismException {
        return genExemptionBlob(bArr, 0);
    }

    public final int genExemptionBlob(byte[] bArr, int i) throws IllegalStateException, ShortBufferException, ExemptionMechanismException {
        if (this.isInit) {
            this.generated = false;
            int engineGenExemptionBlob = this.spiImpl.engineGenExemptionBlob(bArr, i);
            this.generated = true;
            return engineGenExemptionBlob;
        }
        throw new IllegalStateException("ExemptionMechanism is not initialized");
    }

    public final byte[] genExemptionBlob() throws IllegalStateException, ExemptionMechanismException {
        if (this.isInit) {
            this.generated = false;
            byte[] engineGenExemptionBlob = this.spiImpl.engineGenExemptionBlob();
            this.generated = true;
            return engineGenExemptionBlob;
        }
        throw new IllegalStateException("ExemptionMechanism is not initialized");
    }

    public final String getName() {
        return this.mechanism;
    }

    public final int getOutputSize(int i) throws IllegalStateException {
        if (this.isInit) {
            return this.spiImpl.engineGetOutputSize(i);
        }
        throw new IllegalStateException("ExemptionMechanism is not initialized");
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final void init(Key key) throws InvalidKeyException, ExemptionMechanismException {
        this.generated = false;
        this.spiImpl.engineInit(key);
        this.initKey = key;
        this.isInit = true;
    }

    public final void init(Key key, AlgorithmParameters algorithmParameters) throws InvalidKeyException, InvalidAlgorithmParameterException, ExemptionMechanismException {
        this.generated = false;
        this.spiImpl.engineInit(key, algorithmParameters);
        this.initKey = key;
        this.isInit = true;
    }

    public final void init(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException, ExemptionMechanismException {
        this.generated = false;
        this.spiImpl.engineInit(key, algorithmParameterSpec);
        this.initKey = key;
        this.isInit = true;
    }

    public final boolean isCryptoAllowed(Key key) throws ExemptionMechanismException {
        if (this.generated) {
            return this.initKey.equals(key) || Arrays.equals(this.initKey.getEncoded(), key.getEncoded());
        }
        return false;
    }
}
