package java.security;

import java.nio.ByteBuffer;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:java/security/MessageDigest.class */
public abstract class MessageDigest extends MessageDigestSpi {
    private static final Engine ENGINE = new Engine("MessageDigest");
    private String algorithm;
    private Provider provider;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/security/MessageDigest$MessageDigestImpl.class */
    public static class MessageDigestImpl extends MessageDigest {
        private MessageDigestSpi spiImpl;

        private MessageDigestImpl(MessageDigestSpi messageDigestSpi, Provider provider, String str) {
            super(str);
            ((MessageDigest) this).provider = provider;
            this.spiImpl = messageDigestSpi;
        }

        @Override // java.security.MessageDigestSpi
        public Object clone() throws CloneNotSupportedException {
            return new MessageDigestImpl((MessageDigestSpi) this.spiImpl.clone(), getProvider(), getAlgorithm());
        }

        @Override // java.security.MessageDigestSpi
        protected byte[] engineDigest() {
            return this.spiImpl.engineDigest();
        }

        @Override // java.security.MessageDigestSpi
        protected int engineGetDigestLength() {
            return this.spiImpl.engineGetDigestLength();
        }

        @Override // java.security.MessageDigestSpi
        protected void engineReset() {
            this.spiImpl.engineReset();
        }

        @Override // java.security.MessageDigestSpi
        protected void engineUpdate(byte b) {
            this.spiImpl.engineUpdate(b);
        }

        @Override // java.security.MessageDigestSpi
        protected void engineUpdate(byte[] bArr, int i, int i2) {
            this.spiImpl.engineUpdate(bArr, i, i2);
        }
    }

    protected MessageDigest(String str) {
        this.algorithm = str;
    }

    public static MessageDigest getInstance(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        Engine.SpiAndProvider engine = ENGINE.getInstance(str, (Object) null);
        Object obj = engine.spi;
        Provider provider = engine.provider;
        if (obj instanceof MessageDigest) {
            MessageDigest messageDigest = (MessageDigest) obj;
            messageDigest.algorithm = str;
            messageDigest.provider = provider;
            return messageDigest;
        }
        return new MessageDigestImpl((MessageDigestSpi) engine.spi, engine.provider, str);
    }

    public static MessageDigest getInstance(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        return getInstance(str, provider);
    }

    public static MessageDigest getInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        Object engine = ENGINE.getInstance(str, provider, null);
        if (engine instanceof MessageDigest) {
            MessageDigest messageDigest = (MessageDigest) engine;
            messageDigest.algorithm = str;
            messageDigest.provider = provider;
            return messageDigest;
        }
        return new MessageDigestImpl((MessageDigestSpi) engine, provider, str);
    }

    public static boolean isEqual(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= bArr.length) {
                break;
            }
            i |= bArr[i3] ^ bArr2[i3];
            i2 = i3 + 1;
        }
        return i == 0;
    }

    public int digest(byte[] bArr, int i, int i2) throws DigestException {
        if (bArr == null || i + i2 > bArr.length) {
            throw new IllegalArgumentException();
        }
        return engineDigest(bArr, i, i2);
    }

    public byte[] digest() {
        return engineDigest();
    }

    public byte[] digest(byte[] bArr) {
        update(bArr);
        return digest();
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final int getDigestLength() {
        int engineGetDigestLength = engineGetDigestLength();
        if (engineGetDigestLength != 0) {
            return engineGetDigestLength;
        }
        if (this instanceof Cloneable) {
            try {
                return ((MessageDigest) clone()).digest().length;
            } catch (CloneNotSupportedException e) {
                return 0;
            }
        }
        return 0;
    }

    public final Provider getProvider() {
        return this.provider;
    }

    public void reset() {
        engineReset();
    }

    public String toString() {
        return "MESSAGE DIGEST " + this.algorithm;
    }

    public void update(byte b) {
        engineUpdate(b);
    }

    public final void update(ByteBuffer byteBuffer) {
        engineUpdate(byteBuffer);
    }

    public void update(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("input == null");
        }
        engineUpdate(bArr, 0, bArr.length);
    }

    public void update(byte[] bArr, int i, int i2) {
        if (bArr == null || i + i2 > bArr.length) {
            throw new IllegalArgumentException();
        }
        engineUpdate(bArr, i, i2);
    }
}
