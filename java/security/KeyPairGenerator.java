package java.security;

import java.security.spec.AlgorithmParameterSpec;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:java/security/KeyPairGenerator.class */
public abstract class KeyPairGenerator extends KeyPairGeneratorSpi {
    private String algorithm;
    private Provider provider;
    private static final String SERVICE = "KeyPairGenerator";
    private static final Engine ENGINE = new Engine(SERVICE);
    private static final SecureRandom RANDOM = new SecureRandom();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/security/KeyPairGenerator$KeyPairGeneratorImpl.class */
    public static class KeyPairGeneratorImpl extends KeyPairGenerator {
        private KeyPairGeneratorSpi spiImpl;

        private KeyPairGeneratorImpl(KeyPairGeneratorSpi keyPairGeneratorSpi, Provider provider, String str) {
            super(str);
            ((KeyPairGenerator) this).provider = provider;
            this.spiImpl = keyPairGeneratorSpi;
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public KeyPair generateKeyPair() {
            return this.spiImpl.generateKeyPair();
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(int i, SecureRandom secureRandom) {
            this.spiImpl.initialize(i, secureRandom);
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            this.spiImpl.initialize(algorithmParameterSpec, secureRandom);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public KeyPairGenerator(String str) {
        this.algorithm = str;
    }

    public static KeyPairGenerator getInstance(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        Engine.SpiAndProvider engine = ENGINE.getInstance(str, (Object) null);
        Object obj = engine.spi;
        Provider provider = engine.provider;
        if (obj instanceof KeyPairGenerator) {
            KeyPairGenerator keyPairGenerator = (KeyPairGenerator) obj;
            keyPairGenerator.algorithm = str;
            keyPairGenerator.provider = provider;
            return keyPairGenerator;
        }
        return new KeyPairGeneratorImpl((KeyPairGeneratorSpi) obj, provider, str);
    }

    public static KeyPairGenerator getInstance(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        return getInstance(str, provider);
    }

    public static KeyPairGenerator getInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        Object engine = ENGINE.getInstance(str, provider, null);
        if (engine instanceof KeyPairGenerator) {
            KeyPairGenerator keyPairGenerator = (KeyPairGenerator) engine;
            keyPairGenerator.algorithm = str;
            keyPairGenerator.provider = provider;
            return keyPairGenerator;
        }
        return new KeyPairGeneratorImpl((KeyPairGeneratorSpi) engine, provider, str);
    }

    public final KeyPair genKeyPair() {
        return generateKeyPair();
    }

    @Override // java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        return null;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public void initialize(int i) {
        initialize(i, RANDOM);
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        initialize(algorithmParameterSpec, RANDOM);
    }

    @Override // java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
    }
}
