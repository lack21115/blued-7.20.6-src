package javax.crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/SecretKeyFactory.class */
public class SecretKeyFactory {
    private static final Engine ENGINE = new Engine("SecretKeyFactory");
    private final String algorithm;
    private final Provider provider;
    private final SecretKeyFactorySpi spiImpl;

    protected SecretKeyFactory(SecretKeyFactorySpi secretKeyFactorySpi, Provider provider, String str) {
        this.provider = provider;
        this.algorithm = str;
        this.spiImpl = secretKeyFactorySpi;
    }

    public static final SecretKeyFactory getInstance(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        Engine.SpiAndProvider engine = ENGINE.getInstance(str, (Object) null);
        return new SecretKeyFactory((SecretKeyFactorySpi) engine.spi, engine.provider, str);
    }

    public static final SecretKeyFactory getInstance(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("Provider is null or empty");
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        return getInstance(str, provider);
    }

    public static final SecretKeyFactory getInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        return new SecretKeyFactory((SecretKeyFactorySpi) ENGINE.getInstance(str, provider, null), provider, str);
    }

    public final SecretKey generateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        return this.spiImpl.engineGenerateSecret(keySpec);
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final KeySpec getKeySpec(SecretKey secretKey, Class cls) throws InvalidKeySpecException {
        return this.spiImpl.engineGetKeySpec(secretKey, cls);
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public final SecretKey translateKey(SecretKey secretKey) throws InvalidKeyException {
        return this.spiImpl.engineTranslateKey(secretKey);
    }
}
