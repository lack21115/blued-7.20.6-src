package java.security;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:java/security/AlgorithmParameters.class */
public class AlgorithmParameters {
    private final String algorithm;
    private boolean initialized;
    private final Provider provider;
    private final AlgorithmParametersSpi spiImpl;
    private static final String SEVICE = "AlgorithmParameters";
    private static final Engine ENGINE = new Engine(SEVICE);

    protected AlgorithmParameters(AlgorithmParametersSpi algorithmParametersSpi, Provider provider, String str) {
        this.provider = provider;
        this.algorithm = str;
        this.spiImpl = algorithmParametersSpi;
    }

    public static AlgorithmParameters getInstance(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        Engine.SpiAndProvider engine = ENGINE.getInstance(str, (Object) null);
        return new AlgorithmParameters((AlgorithmParametersSpi) engine.spi, engine.provider, str);
    }

    public static AlgorithmParameters getInstance(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("provider == null || provider.isEmpty()");
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        return getInstance(str, provider);
    }

    public static AlgorithmParameters getInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        return new AlgorithmParameters((AlgorithmParametersSpi) ENGINE.getInstance(str, provider, null), provider, str);
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final byte[] getEncoded() throws IOException {
        if (this.initialized) {
            return this.spiImpl.engineGetEncoded();
        }
        throw new IOException("Parameter has not been initialized");
    }

    public final byte[] getEncoded(String str) throws IOException {
        if (this.initialized) {
            return this.spiImpl.engineGetEncoded(str);
        }
        throw new IOException("Parameter has not been initialized");
    }

    public final <T extends AlgorithmParameterSpec> T getParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (this.initialized) {
            return (T) this.spiImpl.engineGetParameterSpec(cls);
        }
        throw new InvalidParameterSpecException("Parameter has not been initialized");
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final void init(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (this.initialized) {
            throw new InvalidParameterSpecException("Parameter has already been initialized");
        }
        this.spiImpl.engineInit(algorithmParameterSpec);
        this.initialized = true;
    }

    public final void init(byte[] bArr) throws IOException {
        if (this.initialized) {
            throw new IOException("Parameter has already been initialized");
        }
        this.spiImpl.engineInit(bArr);
        this.initialized = true;
    }

    public final void init(byte[] bArr, String str) throws IOException {
        if (this.initialized) {
            throw new IOException("Parameter has already been initialized");
        }
        this.spiImpl.engineInit(bArr, str);
        this.initialized = true;
    }

    public final String toString() {
        if (this.initialized) {
            return this.spiImpl.engineToString();
        }
        return null;
    }
}
