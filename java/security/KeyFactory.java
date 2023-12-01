package java.security;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:java/security/KeyFactory.class */
public class KeyFactory {
    private final String algorithm;
    private final Provider provider;
    private final KeyFactorySpi spiImpl;
    private static final String SERVICE = "KeyFactory";
    private static final Engine ENGINE = new Engine(SERVICE);

    protected KeyFactory(KeyFactorySpi keyFactorySpi, Provider provider, String str) {
        this.provider = provider;
        this.algorithm = str;
        this.spiImpl = keyFactorySpi;
    }

    public static KeyFactory getInstance(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        Engine.SpiAndProvider engine = ENGINE.getInstance(str, (Object) null);
        return new KeyFactory((KeyFactorySpi) engine.spi, engine.provider, str);
    }

    public static KeyFactory getInstance(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        return getInstance(str, provider);
    }

    public static KeyFactory getInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        return new KeyFactory((KeyFactorySpi) ENGINE.getInstance(str, provider, null), provider, str);
    }

    public final PrivateKey generatePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        return this.spiImpl.engineGeneratePrivate(keySpec);
    }

    public final PublicKey generatePublic(KeySpec keySpec) throws InvalidKeySpecException {
        return this.spiImpl.engineGeneratePublic(keySpec);
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final <T extends KeySpec> T getKeySpec(Key key, Class<T> cls) throws InvalidKeySpecException {
        return (T) this.spiImpl.engineGetKeySpec(key, cls);
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final Key translateKey(Key key) throws InvalidKeyException {
        return this.spiImpl.engineTranslateKey(key);
    }
}
