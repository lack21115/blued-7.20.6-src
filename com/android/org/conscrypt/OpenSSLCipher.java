package com.android.org.conscrypt;

import com.android.internal.content.NativeLibraryHelper;
import com.android.org.conscrypt.util.EmptyArray;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher.class */
public abstract class OpenSSLCipher extends CipherSpi {
    private int blockSize;
    private boolean calledUpdate;
    private OpenSSLCipherContext cipherCtx;
    private byte[] encodedKey;
    private boolean encrypting;
    private byte[] iv;
    private Mode mode;
    private int modeBlockSize;
    private Padding padding;

    /* renamed from: com.android.org.conscrypt.OpenSSLCipher$1  reason: invalid class name */
    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLCipher$Mode;
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLCipher$Padding = new int[Padding.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0086 -> B:52:0x0077). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x008a -> B:54:0x006b). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x008e -> B:48:0x005f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0092 -> B:44:0x0054). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0096 -> B:60:0x0049). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x009a -> B:56:0x003e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x009e -> B:50:0x0033). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00a2 -> B:6:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00a6 -> B:62:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Padding[Padding.NOPADDING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Padding[Padding.PKCS5PADDING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $SwitchMap$org$conscrypt$OpenSSLCipher$Mode = new int[Mode.values().length];
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Mode[Mode.CBC.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Mode[Mode.CFB.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Mode[Mode.CFB1.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Mode[Mode.CFB8.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Mode[Mode.CFB128.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Mode[Mode.CTR.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Mode[Mode.ECB.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Mode[Mode.OFB.ordinal()] = 8;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$AES.class */
    public static class AES extends OpenSSLCipher {
        private static final int AES_BLOCK_SIZE = 16;

        /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$AES$CBC.class */
        public static class CBC extends AES {

            /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$AES$CBC$NoPadding.class */
            public static class NoPadding extends CBC {
                public NoPadding() {
                    super(Padding.NOPADDING);
                }
            }

            /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$AES$CBC$PKCS5Padding.class */
            public static class PKCS5Padding extends CBC {
                public PKCS5Padding() {
                    super(Padding.PKCS5PADDING);
                }
            }

            public CBC(Padding padding) {
                super(Mode.CBC, padding);
            }
        }

        /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$AES$CFB.class */
        public static class CFB extends AES {
            public CFB() {
                super(Mode.CFB, Padding.NOPADDING);
            }
        }

        /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$AES$CTR.class */
        public static class CTR extends AES {
            public CTR() {
                super(Mode.CTR, Padding.NOPADDING);
            }
        }

        /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$AES$ECB.class */
        public static class ECB extends AES {

            /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$AES$ECB$NoPadding.class */
            public static class NoPadding extends ECB {
                public NoPadding() {
                    super(Padding.NOPADDING);
                }
            }

            /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$AES$ECB$PKCS5Padding.class */
            public static class PKCS5Padding extends ECB {
                public PKCS5Padding() {
                    super(Padding.PKCS5PADDING);
                }
            }

            public ECB(Padding padding) {
                super(Mode.ECB, padding);
            }
        }

        /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$AES$OFB.class */
        public static class OFB extends AES {
            public OFB() {
                super(Mode.OFB, Padding.NOPADDING);
            }
        }

        protected AES(Mode mode, Padding padding) {
            super(mode, padding);
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected void checkSupportedKeySize(int i) throws InvalidKeyException {
            switch (i) {
                case 16:
                case 24:
                case 32:
                    return;
                default:
                    throw new InvalidKeyException("Unsupported key size: " + i + " bytes");
            }
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected void checkSupportedMode(Mode mode) throws NoSuchAlgorithmException {
            switch (AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Mode[mode.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    return;
                default:
                    throw new NoSuchAlgorithmException("Unsupported mode " + mode.toString());
            }
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected void checkSupportedPadding(Padding padding) throws NoSuchPaddingException {
            switch (AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Padding[padding.ordinal()]) {
                case 1:
                case 2:
                    return;
                default:
                    throw new NoSuchPaddingException("Unsupported padding " + padding.toString());
            }
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected String getBaseCipherName() {
            return "AES";
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected int getCipherBlockSize() {
            return 16;
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected String getCipherName(int i, Mode mode) {
            return "aes-" + (i * 8) + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + mode.toString().toLowerCase(Locale.US);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$ARC4.class */
    public static class ARC4 extends OpenSSLCipher {
        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected void checkSupportedKeySize(int i) throws InvalidKeyException {
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected void checkSupportedMode(Mode mode) throws NoSuchAlgorithmException {
            throw new NoSuchAlgorithmException("ARC4 does not support modes");
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected void checkSupportedPadding(Padding padding) throws NoSuchPaddingException {
            throw new NoSuchPaddingException("ARC4 does not support padding");
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected String getBaseCipherName() {
            return "ARCFOUR";
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected int getCipherBlockSize() {
            return 0;
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected String getCipherName(int i, Mode mode) {
            return "rc4";
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected boolean supportsVariableSizeKey() {
            return true;
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$DESEDE.class */
    public static class DESEDE extends OpenSSLCipher {
        private static int DES_BLOCK_SIZE = 8;

        /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$DESEDE$CBC.class */
        public static class CBC extends DESEDE {

            /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$DESEDE$CBC$NoPadding.class */
            public static class NoPadding extends CBC {
                public NoPadding() {
                    super(Padding.NOPADDING);
                }
            }

            /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$DESEDE$CBC$PKCS5Padding.class */
            public static class PKCS5Padding extends CBC {
                public PKCS5Padding() {
                    super(Padding.PKCS5PADDING);
                }
            }

            public CBC(Padding padding) {
                super(Mode.CBC, padding);
            }
        }

        /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$DESEDE$CFB.class */
        public static class CFB extends DESEDE {
            public CFB() {
                super(Mode.CFB, Padding.NOPADDING);
            }
        }

        /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$DESEDE$ECB.class */
        public static class ECB extends DESEDE {

            /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$DESEDE$ECB$NoPadding.class */
            public static class NoPadding extends ECB {
                public NoPadding() {
                    super(Padding.NOPADDING);
                }
            }

            /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$DESEDE$ECB$PKCS5Padding.class */
            public static class PKCS5Padding extends ECB {
                public PKCS5Padding() {
                    super(Padding.PKCS5PADDING);
                }
            }

            public ECB(Padding padding) {
                super(Mode.ECB, padding);
            }
        }

        /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$DESEDE$OFB.class */
        public static class OFB extends DESEDE {
            public OFB() {
                super(Mode.OFB, Padding.NOPADDING);
            }
        }

        public DESEDE(Mode mode, Padding padding) {
            super(mode, padding);
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected void checkSupportedKeySize(int i) throws InvalidKeyException {
            if (i != 16 && i != 24) {
                throw new InvalidKeyException("key size must be 128 or 192 bits");
            }
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected void checkSupportedMode(Mode mode) throws NoSuchAlgorithmException {
            switch (AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Mode[mode.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 7:
                case 8:
                    return;
                case 5:
                case 6:
                default:
                    throw new NoSuchAlgorithmException("Unsupported mode " + mode.toString());
            }
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected void checkSupportedPadding(Padding padding) throws NoSuchPaddingException {
            switch (AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Padding[padding.ordinal()]) {
                case 1:
                case 2:
                    return;
                default:
                    throw new NoSuchPaddingException("Unsupported padding " + padding.toString());
            }
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected String getBaseCipherName() {
            return "DESede";
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected int getCipherBlockSize() {
            return DES_BLOCK_SIZE;
        }

        @Override // com.android.org.conscrypt.OpenSSLCipher
        protected String getCipherName(int i, Mode mode) {
            String str = i == 16 ? "des-ede" : "des-ede3";
            return mode == Mode.ECB ? str : str + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + mode.toString().toLowerCase(Locale.US);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$Mode.class */
    public enum Mode {
        CBC,
        CFB,
        CFB1,
        CFB8,
        CFB128,
        CTR,
        CTS,
        ECB,
        OFB,
        OFB64,
        OFB128,
        PCBC
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLCipher$Padding.class */
    public enum Padding {
        NOPADDING,
        PKCS5PADDING,
        ISO10126PADDING
    }

    protected OpenSSLCipher() {
        this.cipherCtx = new OpenSSLCipherContext(NativeCrypto.EVP_CIPHER_CTX_new());
        this.mode = Mode.ECB;
        this.padding = Padding.PKCS5PADDING;
    }

    protected OpenSSLCipher(Mode mode, Padding padding) {
        this.cipherCtx = new OpenSSLCipherContext(NativeCrypto.EVP_CIPHER_CTX_new());
        this.mode = Mode.ECB;
        this.padding = Padding.PKCS5PADDING;
        this.mode = mode;
        this.padding = padding;
        this.blockSize = getCipherBlockSize();
    }

    private int doFinalInternal(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        int i5;
        int i6 = i3;
        int i7 = i4;
        if (i2 > 0) {
            int updateInternal = updateInternal(bArr, i, i2, bArr2, i3, i4);
            i6 = i3 + updateInternal;
            i7 = i4 - updateInternal;
        }
        if (this.encrypting || this.calledUpdate) {
            int length = bArr2.length - i6;
            if (length >= i7) {
                i5 = NativeCrypto.EVP_CipherFinal_ex(this.cipherCtx.getContext(), bArr2, i6);
            } else {
                byte[] bArr3 = new byte[i7];
                int EVP_CipherFinal_ex = NativeCrypto.EVP_CipherFinal_ex(this.cipherCtx.getContext(), bArr3, 0);
                if (EVP_CipherFinal_ex > length) {
                    throw new ShortBufferException("buffer is too short: " + EVP_CipherFinal_ex + " > " + length);
                }
                i5 = EVP_CipherFinal_ex;
                if (EVP_CipherFinal_ex > 0) {
                    System.arraycopy(bArr3, 0, bArr2, i6, EVP_CipherFinal_ex);
                    i5 = EVP_CipherFinal_ex;
                }
            }
            reset();
            return (i6 + i5) - i3;
        }
        return 0;
    }

    private void engineInitInternal(int i, Key key, byte[] bArr, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArr2;
        if (i == 1 || i == 3) {
            this.encrypting = true;
        } else if (i != 2 && i != 4) {
            throw new InvalidParameterException("Unsupported opmode " + i);
        } else {
            this.encrypting = false;
        }
        if (!(key instanceof SecretKey)) {
            throw new InvalidKeyException("Only SecretKey is supported");
        }
        byte[] encoded = key.getEncoded();
        if (encoded == null) {
            throw new InvalidKeyException("key.getEncoded() == null");
        }
        checkSupportedKeySize(encoded.length);
        this.encodedKey = encoded;
        long EVP_get_cipherbyname = NativeCrypto.EVP_get_cipherbyname(getCipherName(encoded.length, this.mode));
        if (EVP_get_cipherbyname == 0) {
            throw new InvalidAlgorithmParameterException("Cannot find name for key length = " + (encoded.length * 8) + " and mode = " + this.mode);
        }
        int EVP_CIPHER_iv_length = NativeCrypto.EVP_CIPHER_iv_length(EVP_get_cipherbyname);
        if (bArr != null || EVP_CIPHER_iv_length == 0) {
            bArr2 = bArr;
            if (bArr != null) {
                bArr2 = bArr;
                if (bArr.length != EVP_CIPHER_iv_length) {
                    throw new InvalidAlgorithmParameterException("expected IV length of " + EVP_CIPHER_iv_length);
                }
            }
        } else {
            byte[] bArr3 = new byte[EVP_CIPHER_iv_length];
            bArr2 = bArr3;
            if (this.encrypting) {
                SecureRandom secureRandom2 = secureRandom;
                if (secureRandom == null) {
                    secureRandom2 = new SecureRandom();
                }
                secureRandom2.nextBytes(bArr3);
                bArr2 = bArr3;
            }
        }
        this.iv = bArr2;
        if (supportsVariableSizeKey()) {
            NativeCrypto.EVP_CipherInit_ex(this.cipherCtx.getContext(), EVP_get_cipherbyname, null, null, this.encrypting);
            NativeCrypto.EVP_CIPHER_CTX_set_key_length(this.cipherCtx.getContext(), encoded.length);
            NativeCrypto.EVP_CipherInit_ex(this.cipherCtx.getContext(), 0L, encoded, bArr2, this.encrypting);
        } else {
            NativeCrypto.EVP_CipherInit_ex(this.cipherCtx.getContext(), EVP_get_cipherbyname, encoded, bArr2, this.encrypting);
        }
        NativeCrypto.EVP_CIPHER_CTX_set_padding(this.cipherCtx.getContext(), this.padding == Padding.PKCS5PADDING);
        this.modeBlockSize = NativeCrypto.EVP_CIPHER_CTX_block_size(this.cipherCtx.getContext());
        this.calledUpdate = false;
    }

    private int getOutputSize(int i) {
        if (this.modeBlockSize == 1) {
            return i;
        }
        int i2 = NativeCrypto.get_EVP_CIPHER_CTX_buf_len(this.cipherCtx.getContext());
        if (this.padding == Padding.NOPADDING) {
            return i + i2;
        }
        int i3 = i + i2 + this.modeBlockSize;
        return i3 - (i3 % this.modeBlockSize);
    }

    private void reset() {
        NativeCrypto.EVP_CipherInit_ex(this.cipherCtx.getContext(), 0L, this.encodedKey, this.iv, this.encrypting);
        this.calledUpdate = false;
    }

    private final int updateInternal(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) throws ShortBufferException {
        int length = bArr2.length - i3;
        if (length < i4) {
            throw new ShortBufferException("output buffer too small during update: " + length + " < " + i4);
        }
        int EVP_CipherUpdate = NativeCrypto.EVP_CipherUpdate(this.cipherCtx.getContext(), bArr2, i3, bArr, i, i2);
        this.calledUpdate = true;
        return (i3 + EVP_CipherUpdate) - i3;
    }

    protected abstract void checkSupportedKeySize(int i) throws InvalidKeyException;

    protected abstract void checkSupportedMode(Mode mode) throws NoSuchAlgorithmException;

    protected abstract void checkSupportedPadding(Padding padding) throws NoSuchPaddingException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        if (bArr2 == null) {
            throw new NullPointerException("output == null");
        }
        return doFinalInternal(bArr, i, i2, bArr2, i3, getOutputSize(i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        if (this.encrypting || this.calledUpdate || i2 != 0) {
            int outputSize = getOutputSize(i2);
            byte[] bArr3 = new byte[outputSize];
            try {
                int doFinalInternal = doFinalInternal(bArr, i, i2, bArr3, 0, outputSize);
                bArr2 = bArr3;
                if (doFinalInternal != bArr3.length) {
                    return doFinalInternal == 0 ? EmptyArray.BYTE : Arrays.copyOfRange(bArr3, 0, doFinalInternal);
                }
            } catch (ShortBufferException e) {
                throw new RuntimeException("our calculated buffer was too small", e);
            }
        } else {
            reset();
            bArr2 = null;
        }
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return this.blockSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return this.iv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int i) {
        return getOutputSize(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.iv == null || this.iv.length <= 0) {
            return null;
        }
        try {
            AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(getBaseCipherName());
            algorithmParameters.init(this.iv);
            return algorithmParameters;
        } catch (IOException e) {
            return null;
        } catch (NoSuchAlgorithmException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec parameterSpec;
        if (algorithmParameters != null) {
            try {
                parameterSpec = algorithmParameters.getParameterSpec(IvParameterSpec.class);
            } catch (InvalidParameterSpecException e) {
                throw new InvalidAlgorithmParameterException(e);
            }
        } else {
            parameterSpec = null;
        }
        engineInit(i, key, parameterSpec, secureRandom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInitInternal(i, key, null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        engineInitInternal(i, key, algorithmParameterSpec instanceof IvParameterSpec ? ((IvParameterSpec) algorithmParameterSpec).getIV() : null, secureRandom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        try {
            Mode valueOf = Mode.valueOf(str.toUpperCase(Locale.US));
            checkSupportedMode(valueOf);
            this.mode = valueOf;
        } catch (IllegalArgumentException e) {
            NoSuchAlgorithmException noSuchAlgorithmException = new NoSuchAlgorithmException("No such mode: " + str);
            noSuchAlgorithmException.initCause(e);
            throw noSuchAlgorithmException;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        try {
            Padding valueOf = Padding.valueOf(str.toUpperCase(Locale.US));
            checkSupportedPadding(valueOf);
            this.padding = valueOf;
        } catch (IllegalArgumentException e) {
            NoSuchPaddingException noSuchPaddingException = new NoSuchPaddingException("No such padding: " + str);
            noSuchPaddingException.initCause(e);
            throw noSuchPaddingException;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public Key engineUnwrap(byte[] bArr, String str, int i) throws InvalidKeyException, NoSuchAlgorithmException {
        try {
            byte[] engineDoFinal = engineDoFinal(bArr, 0, bArr.length);
            if (i == 1) {
                return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(engineDoFinal));
            }
            if (i == 2) {
                return KeyFactory.getInstance(str).generatePrivate(new PKCS8EncodedKeySpec(engineDoFinal));
            }
            if (i == 3) {
                return new SecretKeySpec(engineDoFinal, str);
            }
            throw new UnsupportedOperationException("wrappedKeyType == " + i);
        } catch (InvalidKeySpecException e) {
            throw new InvalidKeyException(e);
        } catch (BadPaddingException e2) {
            throw new InvalidKeyException(e2);
        } catch (IllegalBlockSizeException e3) {
            throw new InvalidKeyException(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        return updateInternal(bArr, i, i2, bArr2, i3, getOutputSize(i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        int outputSize = getOutputSize(i2);
        byte[] bArr2 = outputSize > 0 ? new byte[outputSize] : EmptyArray.BYTE;
        try {
            int updateInternal = updateInternal(bArr, i, i2, bArr2, 0, outputSize);
            return bArr2.length == updateInternal ? bArr2 : updateInternal == 0 ? EmptyArray.BYTE : Arrays.copyOfRange(bArr2, 0, updateInternal);
        } catch (ShortBufferException e) {
            throw new RuntimeException("calculated buffer size was wrong: " + outputSize);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        try {
            byte[] encoded = key.getEncoded();
            return engineDoFinal(encoded, 0, encoded.length);
        } catch (BadPaddingException e) {
            IllegalBlockSizeException illegalBlockSizeException = new IllegalBlockSizeException();
            illegalBlockSizeException.initCause(e);
            throw illegalBlockSizeException;
        }
    }

    protected abstract String getBaseCipherName();

    protected abstract int getCipherBlockSize();

    protected abstract String getCipherName(int i, Mode mode);

    protected boolean supportsVariableSizeKey() {
        return false;
    }
}
