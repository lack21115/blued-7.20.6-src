package java.security;

import java.security.spec.AlgorithmParameterSpec;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:java/security/AlgorithmParameterGenerator.class */
public class AlgorithmParameterGenerator {
    private final String algorithm;
    private final Provider provider;
    private final AlgorithmParameterGeneratorSpi spiImpl;
    private static final String SERVICE = "AlgorithmParameterGenerator";
    private static final Engine ENGINE = new Engine(SERVICE);
    private static final SecureRandom RANDOM = new SecureRandom();

    protected AlgorithmParameterGenerator(AlgorithmParameterGeneratorSpi algorithmParameterGeneratorSpi, Provider provider, String str) {
        this.provider = provider;
        this.algorithm = str;
        this.spiImpl = algorithmParameterGeneratorSpi;
    }

    public static AlgorithmParameterGenerator getInstance(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        Engine.SpiAndProvider engine = ENGINE.getInstance(str, (Object) null);
        return new AlgorithmParameterGenerator((AlgorithmParameterGeneratorSpi) engine.spi, engine.provider, str);
    }

    public static AlgorithmParameterGenerator getInstance(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        return getInstance(str, provider);
    }

    public static AlgorithmParameterGenerator getInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        return new AlgorithmParameterGenerator((AlgorithmParameterGeneratorSpi) ENGINE.getInstance(str, provider, null), provider, str);
    }

    public final AlgorithmParameters generateParameters() {
        return this.spiImpl.engineGenerateParameters();
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final void init(int i) {
        this.spiImpl.engineInit(i, RANDOM);
    }

    public final void init(int i, SecureRandom secureRandom) {
        this.spiImpl.engineInit(i, secureRandom);
    }

    public final void init(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        this.spiImpl.engineInit(algorithmParameterSpec, RANDOM);
    }

    public final void init(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        this.spiImpl.engineInit(algorithmParameterSpec, secureRandom);
    }
}
