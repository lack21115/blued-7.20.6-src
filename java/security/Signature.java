package java.security;

import java.nio.ByteBuffer;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:java/security/Signature.class */
public abstract class Signature extends SignatureSpi {
    protected static final int SIGN = 2;
    protected static final int UNINITIALIZED = 0;
    protected static final int VERIFY = 3;
    final String algorithm;
    Provider provider;
    protected int state = 0;
    private static final String SERVICE = "Signature";
    private static final Engine ENGINE = new Engine(SERVICE);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/security/Signature$SignatureImpl.class */
    public static class SignatureImpl extends Signature {
        private final Object initLock;
        private final Provider specifiedProvider;
        private SignatureSpi spiImpl;

        public SignatureImpl(String str, Provider provider) {
            super(str);
            this.initLock = new Object();
            this.specifiedProvider = provider;
        }

        private SignatureImpl(String str, Provider provider, SignatureSpi signatureSpi) {
            this(str, provider);
            this.spiImpl = signatureSpi;
        }

        private SignatureSpi getSpi() {
            return getSpi(null);
        }

        private SignatureSpi getSpi(Key key) {
            synchronized (this.initLock) {
                if (this.spiImpl != null && key == null) {
                    return this.spiImpl;
                }
                Engine.SpiAndProvider tryAlgorithm = Signature.tryAlgorithm(key, this.specifiedProvider, this.algorithm);
                if (tryAlgorithm == null) {
                    throw new ProviderException("No provider for " + getAlgorithm());
                }
                this.spiImpl = (SignatureSpi) tryAlgorithm.spi;
                this.provider = tryAlgorithm.provider;
                return this.spiImpl;
            }
        }

        @Override // java.security.SignatureSpi
        public Object clone() throws CloneNotSupportedException {
            return new SignatureImpl(getAlgorithm(), getProvider(), this.spiImpl != null ? (SignatureSpi) this.spiImpl.clone() : null);
        }

        @Override // java.security.SignatureSpi
        protected Object engineGetParameter(String str) throws InvalidParameterException {
            return getSpi().engineGetParameter(str);
        }

        @Override // java.security.SignatureSpi
        protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
            getSpi(privateKey).engineInitSign(privateKey);
        }

        @Override // java.security.SignatureSpi
        protected void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
            getSpi(publicKey).engineInitVerify(publicKey);
        }

        @Override // java.security.SignatureSpi
        protected void engineSetParameter(String str, Object obj) throws InvalidParameterException {
            getSpi().engineSetParameter(str, obj);
        }

        @Override // java.security.SignatureSpi
        protected void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
            getSpi().engineSetParameter(algorithmParameterSpec);
        }

        @Override // java.security.SignatureSpi
        protected byte[] engineSign() throws SignatureException {
            return getSpi().engineSign();
        }

        @Override // java.security.SignatureSpi
        protected void engineUpdate(byte b) throws SignatureException {
            getSpi().engineUpdate(b);
        }

        @Override // java.security.SignatureSpi
        protected void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
            getSpi().engineUpdate(bArr, i, i2);
        }

        @Override // java.security.SignatureSpi
        protected boolean engineVerify(byte[] bArr) throws SignatureException {
            return getSpi().engineVerify(bArr);
        }

        @Override // java.security.Signature
        void ensureProviderChosen() {
            getSpi(null);
        }
    }

    protected Signature(String str) {
        this.algorithm = str;
    }

    public static Signature getInstance(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        return getSignature(str, null);
    }

    public static Signature getInstance(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException(str2);
        }
        return getSignature(str, provider);
    }

    public static Signature getInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("algorithm == null");
        }
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        return getSignature(str, provider);
    }

    private static Signature getSignature(String str, Provider provider) throws NoSuchAlgorithmException {
        if (str == null || str.isEmpty()) {
            throw new NoSuchAlgorithmException("Unknown algorithm: " + str);
        }
        Engine.SpiAndProvider tryAlgorithm = tryAlgorithm(null, provider, str);
        if (tryAlgorithm != null) {
            return tryAlgorithm.spi instanceof Signature ? (Signature) tryAlgorithm.spi : new SignatureImpl(str, provider);
        } else if (provider == null) {
            throw new NoSuchAlgorithmException("No provider found for " + str);
        } else {
            throw new NoSuchAlgorithmException("Provider " + provider.getName() + " does not provide " + str);
        }
    }

    private String stateToString(int i) {
        switch (i) {
            case 0:
                return "UNINITIALIZED";
            case 1:
            default:
                return "";
            case 2:
                return "SIGN";
            case 3:
                return "VERIFY";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Engine.SpiAndProvider tryAlgorithm(Key key, Provider provider, String str) {
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
            if (!(spiAndProvider.spi instanceof SignatureSpi)) {
                return null;
            }
            return spiAndProvider;
        }
        return null;
    }

    void ensureProviderChosen() {
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    @Deprecated
    public final Object getParameter(String str) throws InvalidParameterException {
        return engineGetParameter(str);
    }

    public final AlgorithmParameters getParameters() {
        return engineGetParameters();
    }

    public final Provider getProvider() {
        ensureProviderChosen();
        return this.provider;
    }

    public final void initSign(PrivateKey privateKey) throws InvalidKeyException {
        engineInitSign(privateKey);
        this.state = 2;
    }

    public final void initSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        engineInitSign(privateKey, secureRandom);
        this.state = 2;
    }

    public final void initVerify(PublicKey publicKey) throws InvalidKeyException {
        engineInitVerify(publicKey);
        this.state = 3;
    }

    public final void initVerify(java.security.cert.Certificate certificate) throws InvalidKeyException {
        Set<String> criticalExtensionOIDs;
        boolean z;
        boolean[] keyUsage;
        if ((certificate instanceof X509Certificate) && (criticalExtensionOIDs = ((X509Certificate) certificate).getCriticalExtensionOIDs()) != null && !criticalExtensionOIDs.isEmpty()) {
            Iterator<String> it = criticalExtensionOIDs.iterator();
            while (true) {
                z = false;
                if (!it.hasNext()) {
                    break;
                } else if ("2.5.29.15".equals(it.next())) {
                    z = true;
                    break;
                }
            }
            if (z && (keyUsage = ((X509Certificate) certificate).getKeyUsage()) != null && !keyUsage[0]) {
                throw new InvalidKeyException("The public key in the certificate cannot be used for digital signature purposes");
            }
        }
        engineInitVerify(certificate.getPublicKey());
        this.state = 3;
    }

    @Deprecated
    public final void setParameter(String str, Object obj) throws InvalidParameterException {
        engineSetParameter(str, obj);
    }

    public final void setParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        engineSetParameter(algorithmParameterSpec);
    }

    public final int sign(byte[] bArr, int i, int i2) throws SignatureException {
        if (bArr == null || i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IllegalArgumentException();
        }
        if (this.state != 2) {
            throw new SignatureException("Signature object is not initialized properly");
        }
        return engineSign(bArr, i, i2);
    }

    public final byte[] sign() throws SignatureException {
        if (this.state != 2) {
            throw new SignatureException("Signature object is not initialized properly");
        }
        return engineSign();
    }

    public String toString() {
        return "SIGNATURE " + this.algorithm + " state: " + stateToString(this.state);
    }

    public final void update(byte b) throws SignatureException {
        if (this.state == 0) {
            throw new SignatureException("Signature object is not initialized properly");
        }
        engineUpdate(b);
    }

    public final void update(ByteBuffer byteBuffer) throws SignatureException {
        if (this.state == 0) {
            throw new SignatureException("Signature object is not initialized properly");
        }
        engineUpdate(byteBuffer);
    }

    public final void update(byte[] bArr) throws SignatureException {
        if (this.state == 0) {
            throw new SignatureException("Signature object is not initialized properly");
        }
        engineUpdate(bArr, 0, bArr.length);
    }

    public final void update(byte[] bArr, int i, int i2) throws SignatureException {
        if (this.state == 0) {
            throw new SignatureException("Signature object is not initialized properly");
        }
        if (bArr == null || i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IllegalArgumentException();
        }
        engineUpdate(bArr, i, i2);
    }

    public final boolean verify(byte[] bArr) throws SignatureException {
        if (this.state != 3) {
            throw new SignatureException("Signature object is not initialized properly");
        }
        return engineVerify(bArr);
    }

    public final boolean verify(byte[] bArr, int i, int i2) throws SignatureException {
        if (this.state != 3) {
            throw new SignatureException("Signature object is not initialized properly");
        }
        if (bArr == null || i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IllegalArgumentException();
        }
        return engineVerify(bArr, i, i2);
    }
}
