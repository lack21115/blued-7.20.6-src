package javax.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/KeyGenerator.class */
public class KeyGenerator {
    private static final Engine ENGINE = new Engine("KeyGenerator");
    private static final SecureRandom RANDOM = new SecureRandom();
    private final String algorithm;
    private final Provider provider;
    private final KeyGeneratorSpi spiImpl;

    protected KeyGenerator(KeyGeneratorSpi keyGeneratorSpi, Provider provider, String str) {
        this.provider = provider;
        this.algorithm = str;
        this.spiImpl = keyGeneratorSpi;
    }

    public static final KeyGenerator getInstance(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        Engine.SpiAndProvider engine = ENGINE.getInstance(str, (Object) null);
        return new KeyGenerator((KeyGeneratorSpi) engine.spi, engine.provider, str);
    }

    public static final KeyGenerator getInstance(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("Provider is null or empty");
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        return getInstance(str, provider);
    }

    public static final KeyGenerator getInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        return new KeyGenerator((KeyGeneratorSpi) ENGINE.getInstance(str, provider, null), provider, str);
    }

    public final SecretKey generateKey() {
        return this.spiImpl.engineGenerateKey();
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

    public final void init(SecureRandom secureRandom) {
        this.spiImpl.engineInit(secureRandom);
    }

    public final void init(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        this.spiImpl.engineInit(algorithmParameterSpec, RANDOM);
    }

    public final void init(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        this.spiImpl.engineInit(algorithmParameterSpec, secureRandom);
    }
}
