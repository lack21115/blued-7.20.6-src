package javax.crypto;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.apache.harmony.crypto.internal.NullCipherSpi;
import org.apache.harmony.security.fortress.Engine;

/* loaded from: source-2895416-dex2jar.jar:javax/crypto/Cipher.class */
public class Cipher {
    private static final String ATTRIBUTE_MODES = "SupportedModes";
    private static final String ATTRIBUTE_PADDINGS = "SupportedPaddings";
    public static final int DECRYPT_MODE = 2;
    public static final int ENCRYPT_MODE = 1;
    public static final int PRIVATE_KEY = 2;
    public static final int PUBLIC_KEY = 1;
    public static final int SECRET_KEY = 3;
    public static final int UNWRAP_MODE = 4;
    public static final int WRAP_MODE = 3;
    private static SecureRandom secureRandom;
    private final Object initLock;
    private int mode;
    private Provider provider;
    private final Provider specifiedProvider;
    private final CipherSpi specifiedSpi;
    private CipherSpi spiImpl;
    private final String[] transformParts;
    private final String transformation;
    private static final String SERVICE = "Cipher";
    private static final Engine ENGINE = new Engine(SERVICE);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:javax/crypto/Cipher$NeedToSet.class */
    public enum NeedToSet {
        NONE,
        MODE,
        PADDING,
        BOTH
    }

    private Cipher(String str, String[] strArr, Provider provider) {
        this.initLock = new Object();
        this.transformation = str;
        this.transformParts = strArr;
        this.specifiedProvider = provider;
        this.specifiedSpi = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cipher(CipherSpi cipherSpi, Provider provider, String str) {
        this.initLock = new Object();
        if (cipherSpi == null) {
            throw new NullPointerException("cipherSpi == null");
        }
        if (!(cipherSpi instanceof NullCipherSpi) && provider == null) {
            throw new NullPointerException("provider == null");
        }
        this.specifiedProvider = provider;
        this.specifiedSpi = cipherSpi;
        this.transformation = str;
        this.transformParts = null;
    }

    private static void checkInputOffsetAndCount(int i, int i2, int i3) {
        if ((i2 | i3) < 0 || i2 > i || i - i2 < i3) {
            throw new IllegalArgumentException("input.length=" + i + "; inputOffset=" + i2 + "; inputLen=" + i3);
        }
    }

    private void checkMode(int i) {
        if (i != 1 && i != 2 && i != 4 && i != 3) {
            throw new InvalidParameterException("Invalid mode: " + i);
        }
    }

    private static String[] checkTransformation(String str) throws NoSuchAlgorithmException {
        String str2 = str;
        if (str.startsWith(BridgeUtil.SPLIT_MARK)) {
            str2 = str.substring(1);
        }
        String[] split = str2.split(BridgeUtil.SPLIT_MARK);
        if (split.length > 3) {
            throw invalidTransformation(str2);
        }
        String[] strArr = new String[3];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= split.length) {
                break;
            }
            String trim = split[i2].trim();
            if (!trim.isEmpty()) {
                strArr[i2] = trim;
            }
            i = i2 + 1;
        }
        if (strArr[0] == null) {
            throw invalidTransformation(str2);
        }
        if (!(strArr[1] == null && strArr[2] == null) && (strArr[1] == null || strArr[2] == null)) {
            throw invalidTransformation(str2);
        }
        return strArr;
    }

    private static Cipher getCipher(String str, Provider provider) throws NoSuchAlgorithmException, NoSuchPaddingException {
        if (str == null || str.isEmpty()) {
            throw invalidTransformation(str);
        }
        String[] checkTransformation = checkTransformation(str);
        if (tryCombinations(null, provider, checkTransformation) == null) {
            if (provider == null) {
                throw new NoSuchAlgorithmException("No provider found for " + str);
            }
            throw new NoSuchAlgorithmException("Provider " + provider.getName() + " does not provide " + str);
        }
        return new Cipher(str, checkTransformation, provider);
    }

    public static final Cipher getInstance(String str) throws NoSuchAlgorithmException, NoSuchPaddingException {
        return getCipher(str, null);
    }

    public static final Cipher getInstance(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException {
        if (str2 == null) {
            throw new IllegalArgumentException("provider == null");
        }
        Provider provider = Security.getProvider(str2);
        if (provider == null) {
            throw new NoSuchProviderException("Provider not available: " + str2);
        }
        return getInstance(str, provider);
    }

    public static final Cipher getInstance(String str, Provider provider) throws NoSuchAlgorithmException, NoSuchPaddingException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        return getCipher(str, provider);
    }

    public static final int getMaxAllowedKeyLength(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("transformation == null");
        }
        checkTransformation(str);
        return Integer.MAX_VALUE;
    }

    public static final AlgorithmParameterSpec getMaxAllowedParameterSpec(String str) throws NoSuchAlgorithmException {
        if (str == null) {
            throw new NullPointerException("transformation == null");
        }
        checkTransformation(str);
        return null;
    }

    private CipherSpi getSpi() {
        return getSpi(null);
    }

    private CipherSpi getSpi(Key key) {
        if (this.specifiedSpi != null) {
            return this.specifiedSpi;
        }
        synchronized (this.initLock) {
            if (this.spiImpl != null && key == null) {
                return this.spiImpl;
            }
            Engine.SpiAndProvider tryCombinations = tryCombinations(key, this.specifiedProvider, this.transformParts);
            if (tryCombinations == null) {
                throw new ProviderException("No provider for " + this.transformation);
            }
            this.spiImpl = (CipherSpi) tryCombinations.spi;
            this.provider = tryCombinations.provider;
            return this.spiImpl;
        }
    }

    private static NoSuchAlgorithmException invalidTransformation(String str) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("Invalid transformation: " + str);
    }

    private static boolean matchAttribute(Provider.Service service, String str, String str2) {
        String attribute;
        if (str2 == null || (attribute = service.getAttribute(str)) == null) {
            return true;
        }
        return str2.toUpperCase(Locale.US).matches(attribute.toUpperCase(Locale.US));
    }

    private static Engine.SpiAndProvider tryCombinations(Key key, Provider provider, String[] strArr) {
        Engine.SpiAndProvider tryTransform;
        Engine.SpiAndProvider tryTransform2;
        Engine.SpiAndProvider tryTransform3;
        return (strArr[1] == null || strArr[2] == null || (tryTransform3 = tryTransform(key, provider, new StringBuilder().append(strArr[0]).append(BridgeUtil.SPLIT_MARK).append(strArr[1]).append(BridgeUtil.SPLIT_MARK).append(strArr[2]).toString(), strArr, NeedToSet.NONE)) == null) ? (strArr[1] == null || (tryTransform2 = tryTransform(key, provider, new StringBuilder().append(strArr[0]).append(BridgeUtil.SPLIT_MARK).append(strArr[1]).toString(), strArr, NeedToSet.PADDING)) == null) ? (strArr[2] == null || (tryTransform = tryTransform(key, provider, new StringBuilder().append(strArr[0]).append("//").append(strArr[2]).toString(), strArr, NeedToSet.MODE)) == null) ? tryTransform(key, provider, strArr[0], strArr, NeedToSet.BOTH) : tryTransform : tryTransform2 : tryTransform3;
    }

    private static Engine.SpiAndProvider tryTransform(Key key, Provider provider, String str, String[] strArr, NeedToSet needToSet) {
        if (provider != null) {
            Provider.Service service = provider.getService(SERVICE, str);
            if (service == null) {
                return null;
            }
            return tryTransformWithProvider(key, strArr, needToSet, service);
        }
        ArrayList<Provider.Service> services = ENGINE.getServices(str);
        if (services == null) {
            return null;
        }
        Iterator<Provider.Service> it = services.iterator();
        while (it.hasNext()) {
            Engine.SpiAndProvider tryTransformWithProvider = tryTransformWithProvider(key, strArr, needToSet, it.next());
            if (tryTransformWithProvider != null) {
                return tryTransformWithProvider;
            }
        }
        return null;
    }

    private static Engine.SpiAndProvider tryTransformWithProvider(Key key, String[] strArr, NeedToSet needToSet, Provider.Service service) {
        if (key != null) {
            try {
                if (!service.supportsParameter(key)) {
                    return null;
                }
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                return null;
            }
        }
        if (matchAttribute(service, ATTRIBUTE_MODES, strArr[1]) && matchAttribute(service, ATTRIBUTE_PADDINGS, strArr[2])) {
            Engine.SpiAndProvider engine = ENGINE.getInstance(service, (String) null);
            if (engine.spi == null || engine.provider == null || !(engine.spi instanceof CipherSpi)) {
                return null;
            }
            CipherSpi cipherSpi = (CipherSpi) engine.spi;
            if ((needToSet == NeedToSet.MODE || needToSet == NeedToSet.BOTH) && strArr[1] != null) {
                cipherSpi.engineSetMode(strArr[1]);
            }
            if ((needToSet == NeedToSet.PADDING || needToSet == NeedToSet.BOTH) && strArr[2] != null) {
                cipherSpi.engineSetPadding(strArr[2]);
                return engine;
            }
            return engine;
        }
        return null;
    }

    public final int doFinal(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        if (this.mode == 1 || this.mode == 2) {
            if (byteBuffer == byteBuffer2) {
                throw new IllegalArgumentException("input == output");
            }
            return getSpi().engineDoFinal(byteBuffer, byteBuffer2);
        }
        throw new IllegalStateException();
    }

    public final int doFinal(byte[] bArr, int i) throws IllegalBlockSizeException, ShortBufferException, BadPaddingException {
        if (this.mode == 1 || this.mode == 2) {
            if (i < 0) {
                throw new IllegalArgumentException("outputOffset < 0. outputOffset=" + i);
            }
            return getSpi().engineDoFinal(null, 0, 0, bArr, i);
        }
        throw new IllegalStateException();
    }

    public final int doFinal(byte[] bArr, int i, int i2, byte[] bArr2) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        return doFinal(bArr, i, i2, bArr2, 0);
    }

    public final int doFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        if (this.mode == 1 || this.mode == 2) {
            checkInputOffsetAndCount(bArr.length, i, i2);
            return getSpi().engineDoFinal(bArr, i, i2, bArr2, i3);
        }
        throw new IllegalStateException();
    }

    public final byte[] doFinal() throws IllegalBlockSizeException, BadPaddingException {
        if (this.mode == 1 || this.mode == 2) {
            return getSpi().engineDoFinal(null, 0, 0);
        }
        throw new IllegalStateException();
    }

    public final byte[] doFinal(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException {
        if (this.mode == 1 || this.mode == 2) {
            return getSpi().engineDoFinal(bArr, 0, bArr.length);
        }
        throw new IllegalStateException();
    }

    public final byte[] doFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        if (this.mode == 1 || this.mode == 2) {
            checkInputOffsetAndCount(bArr.length, i, i2);
            return getSpi().engineDoFinal(bArr, i, i2);
        }
        throw new IllegalStateException();
    }

    public final String getAlgorithm() {
        return this.transformation;
    }

    public final int getBlockSize() {
        return getSpi().engineGetBlockSize();
    }

    public final ExemptionMechanism getExemptionMechanism() {
        return null;
    }

    public final byte[] getIV() {
        return getSpi().engineGetIV();
    }

    public final int getOutputSize(int i) {
        if (this.mode == 0) {
            throw new IllegalStateException("Cipher has not yet been initialized");
        }
        return getSpi().engineGetOutputSize(i);
    }

    public final AlgorithmParameters getParameters() {
        return getSpi().engineGetParameters();
    }

    public final Provider getProvider() {
        getSpi();
        return this.provider;
    }

    public final void init(int i, Key key) throws InvalidKeyException {
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        init(i, key, secureRandom);
    }

    public final void init(int i, Key key, AlgorithmParameters algorithmParameters) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        init(i, key, algorithmParameters, secureRandom);
    }

    public final void init(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom2) throws InvalidKeyException, InvalidAlgorithmParameterException {
        checkMode(i);
        getSpi(key).engineInit(i, key, algorithmParameters, secureRandom2);
        this.mode = i;
    }

    public final void init(int i, Key key, SecureRandom secureRandom2) throws InvalidKeyException {
        checkMode(i);
        getSpi(key).engineInit(i, key, secureRandom2);
        this.mode = i;
    }

    public final void init(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        init(i, key, algorithmParameterSpec, secureRandom);
    }

    public final void init(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom2) throws InvalidKeyException, InvalidAlgorithmParameterException {
        checkMode(i);
        getSpi(key).engineInit(i, key, algorithmParameterSpec, secureRandom2);
        this.mode = i;
    }

    public final void init(int i, Certificate certificate) throws InvalidKeyException {
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        init(i, certificate, secureRandom);
    }

    public final void init(int i, Certificate certificate, SecureRandom secureRandom2) throws InvalidKeyException {
        Set<String> criticalExtensionOIDs;
        boolean z;
        boolean[] keyUsage;
        checkMode(i);
        if ((certificate instanceof X509Certificate) && (criticalExtensionOIDs = ((X509Certificate) certificate).getCriticalExtensionOIDs()) != null && !criticalExtensionOIDs.isEmpty()) {
            Iterator<String> it = criticalExtensionOIDs.iterator();
            while (true) {
                z = false;
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals("2.5.29.15")) {
                    z = true;
                    break;
                }
            }
            if (z && (keyUsage = ((X509Certificate) certificate).getKeyUsage()) != null) {
                if (i == 1 && !keyUsage[3]) {
                    throw new InvalidKeyException("The public key in the certificate cannot be used for ENCRYPT_MODE");
                }
                if (i == 3 && !keyUsage[2]) {
                    throw new InvalidKeyException("The public key in the certificate cannot be used for WRAP_MODE");
                }
            }
        }
        PublicKey publicKey = certificate.getPublicKey();
        getSpi(publicKey).engineInit(i, publicKey, secureRandom2);
        this.mode = i;
    }

    public final Key unwrap(byte[] bArr, String str, int i) throws InvalidKeyException, NoSuchAlgorithmException {
        if (this.mode != 4) {
            throw new IllegalStateException();
        }
        return getSpi().engineUnwrap(bArr, str, i);
    }

    public final int update(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws ShortBufferException {
        if (this.mode == 1 || this.mode == 2) {
            if (byteBuffer == byteBuffer2) {
                throw new IllegalArgumentException("input == output");
            }
            return getSpi().engineUpdate(byteBuffer, byteBuffer2);
        }
        throw new IllegalStateException();
    }

    public final int update(byte[] bArr, int i, int i2, byte[] bArr2) throws ShortBufferException {
        return update(bArr, i, i2, bArr2, 0);
    }

    public final int update(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        if (this.mode == 1 || this.mode == 2) {
            if (bArr == null) {
                throw new IllegalArgumentException("input == null");
            }
            if (bArr2 == null) {
                throw new IllegalArgumentException("output == null");
            }
            if (i3 < 0) {
                throw new IllegalArgumentException("outputOffset < 0. outputOffset=" + i3);
            }
            checkInputOffsetAndCount(bArr.length, i, i2);
            if (bArr.length == 0) {
                return 0;
            }
            return getSpi().engineUpdate(bArr, i, i2, bArr2, i3);
        }
        throw new IllegalStateException();
    }

    public final byte[] update(byte[] bArr) {
        if (this.mode == 1 || this.mode == 2) {
            if (bArr == null) {
                throw new IllegalArgumentException("input == null");
            }
            if (bArr.length == 0) {
                return null;
            }
            return getSpi().engineUpdate(bArr, 0, bArr.length);
        }
        throw new IllegalStateException();
    }

    public final byte[] update(byte[] bArr, int i, int i2) {
        if (this.mode == 1 || this.mode == 2) {
            if (bArr == null) {
                throw new IllegalArgumentException("input == null");
            }
            checkInputOffsetAndCount(bArr.length, i, i2);
            if (bArr.length == 0) {
                return null;
            }
            return getSpi().engineUpdate(bArr, i, i2);
        }
        throw new IllegalStateException();
    }

    public final void updateAAD(ByteBuffer byteBuffer) {
        if (this.mode != 1 && this.mode != 2) {
            throw new IllegalStateException("Cipher is not initialized");
        }
        if (byteBuffer == null) {
            throw new IllegalArgumentException("input == null");
        }
        getSpi().engineUpdateAAD(byteBuffer);
    }

    public final void updateAAD(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("input == null");
        }
        if (this.mode != 1 && this.mode != 2) {
            throw new IllegalStateException();
        }
        if (bArr.length == 0) {
            return;
        }
        getSpi().engineUpdateAAD(bArr, 0, bArr.length);
    }

    public final void updateAAD(byte[] bArr, int i, int i2) {
        if (this.mode != 1 && this.mode != 2) {
            throw new IllegalStateException();
        }
        if (bArr == null) {
            throw new IllegalArgumentException("input == null");
        }
        checkInputOffsetAndCount(bArr.length, i, i2);
        if (bArr.length == 0) {
            return;
        }
        getSpi().engineUpdateAAD(bArr, i, i2);
    }

    public final byte[] wrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        if (this.mode != 3) {
            throw new IllegalStateException();
        }
        return getSpi().engineWrap(key);
    }
}
