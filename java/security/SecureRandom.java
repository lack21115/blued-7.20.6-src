package java.security;

import java.nio.ByteOrder;
import java.security.Provider;
import java.util.Random;
import libcore.io.Memory;
import org.apache.harmony.security.fortress.Engine;
import org.apache.harmony.security.fortress.Services;
import org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl;

/* loaded from: source-2895416-dex2jar.jar:java/security/SecureRandom.class */
public class SecureRandom extends Random {
    private static volatile SecureRandom internalSecureRandom;
    private static final long serialVersionUID = 4940670005562187L;
    private final String algorithm;
    private final Provider provider;
    private final SecureRandomSpi secureRandomSpi;
    private static final String SERVICE = "SecureRandom";
    private static final Engine ENGINE = new Engine(SERVICE);

    public SecureRandom() {
        super(0L);
        Provider.Service secureRandomService = Services.getSecureRandomService();
        if (secureRandomService == null) {
            this.provider = null;
            this.secureRandomSpi = new SHA1PRNG_SecureRandomImpl();
            this.algorithm = "SHA1PRNG";
            return;
        }
        try {
            this.provider = secureRandomService.getProvider();
            this.secureRandomSpi = (SecureRandomSpi) secureRandomService.newInstance(null);
            this.algorithm = secureRandomService.getAlgorithm();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected SecureRandom(SecureRandomSpi secureRandomSpi, Provider provider) {
        this(secureRandomSpi, provider, "unknown");
    }

    private SecureRandom(SecureRandomSpi secureRandomSpi, Provider provider, String str) {
        super(0L);
        this.provider = provider;
        this.algorithm = str;
        this.secureRandomSpi = secureRandomSpi;
    }

    public SecureRandom(byte[] bArr) {
        this();
        setSeed(bArr);
    }

    public static SecureRandom getInstance(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        Engine.SpiAndProvider engine = ENGINE.getInstance(str, (Object) null);
        return new SecureRandom((SecureRandomSpi) engine.spi, engine.provider, str);
    }

    public static SecureRandom getInstance(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        return getInstance(str, provider);
    }

    public static SecureRandom getInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        return new SecureRandom((SecureRandomSpi) ENGINE.getInstance(str, provider, null), provider, str);
    }

    public static byte[] getSeed(int i) {
        SecureRandom secureRandom = internalSecureRandom;
        SecureRandom secureRandom2 = secureRandom;
        if (secureRandom == null) {
            secureRandom2 = new SecureRandom();
            internalSecureRandom = secureRandom2;
        }
        return secureRandom2.generateSeed(i);
    }

    public byte[] generateSeed(int i) {
        return this.secureRandomSpi.engineGenerateSeed(i);
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public final Provider getProvider() {
        return this.provider;
    }

    @Override // java.util.Random
    protected final int next(int i) {
        int i2;
        if (i < 0) {
            i2 = 0;
        } else {
            i2 = i;
            if (i > 32) {
                i2 = 32;
            }
        }
        int i3 = (i2 + 7) / 8;
        byte[] bArr = new byte[i3];
        int i4 = 0;
        nextBytes(bArr);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= i3) {
                return i4 >>> ((i3 * 8) - i2);
            }
            i4 = (bArr[i6] & 255) | (i4 << 8);
            i5 = i6 + 1;
        }
    }

    @Override // java.util.Random
    public void nextBytes(byte[] bArr) {
        synchronized (this) {
            this.secureRandomSpi.engineNextBytes(bArr);
        }
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[8];
        Memory.pokeLong(bArr, 0, j, ByteOrder.BIG_ENDIAN);
        setSeed(bArr);
    }

    public void setSeed(byte[] bArr) {
        synchronized (this) {
            this.secureRandomSpi.engineSetSeed(bArr);
        }
    }
}
