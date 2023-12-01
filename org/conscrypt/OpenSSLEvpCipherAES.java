package org.conscrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import javax.crypto.NoSuchPaddingException;
import org.conscrypt.OpenSSLCipher;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES.class */
public abstract class OpenSSLEvpCipherAES extends OpenSSLEvpCipher {
    private static final int AES_BLOCK_SIZE = 16;

    /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLCipher$Mode;
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLCipher$Padding;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004a -> B:24:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004e -> B:6:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0052 -> B:30:0x0033). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0056 -> B:26:0x003e). Please submit an issue!!! */
        static {
            int[] iArr = new int[OpenSSLCipher.Padding.values().length];
            $SwitchMap$org$conscrypt$OpenSSLCipher$Padding = iArr;
            try {
                iArr[OpenSSLCipher.Padding.NOPADDING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Padding[OpenSSLCipher.Padding.PKCS5PADDING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[OpenSSLCipher.Mode.values().length];
            $SwitchMap$org$conscrypt$OpenSSLCipher$Mode = iArr2;
            try {
                iArr2[OpenSSLCipher.Mode.CBC.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Mode[OpenSSLCipher.Mode.CTR.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Mode[OpenSSLCipher.Mode.ECB.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES.class */
    public static class AES extends OpenSSLEvpCipherAES {

        /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES$CBC.class */
        public static class CBC extends AES {

            /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES$CBC$NoPadding.class */
            public static class NoPadding extends CBC {
                public NoPadding() {
                    super(OpenSSLCipher.Padding.NOPADDING);
                }
            }

            /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES$CBC$PKCS5Padding.class */
            public static class PKCS5Padding extends CBC {
                public PKCS5Padding() {
                    super(OpenSSLCipher.Padding.PKCS5PADDING);
                }
            }

            CBC(OpenSSLCipher.Padding padding) {
                super(OpenSSLCipher.Mode.CBC, padding);
            }
        }

        /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES$CTR.class */
        public static class CTR extends AES {
            public CTR() {
                super(OpenSSLCipher.Mode.CTR, OpenSSLCipher.Padding.NOPADDING);
            }
        }

        /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES$ECB.class */
        public static class ECB extends AES {

            /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES$ECB$NoPadding.class */
            public static class NoPadding extends ECB {
                public NoPadding() {
                    super(OpenSSLCipher.Padding.NOPADDING);
                }
            }

            /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES$ECB$PKCS5Padding.class */
            public static class PKCS5Padding extends ECB {
                public PKCS5Padding() {
                    super(OpenSSLCipher.Padding.PKCS5PADDING);
                }
            }

            ECB(OpenSSLCipher.Padding padding) {
                super(OpenSSLCipher.Mode.ECB, padding);
            }
        }

        AES(OpenSSLCipher.Mode mode, OpenSSLCipher.Padding padding) {
            super(mode, padding);
        }

        @Override // org.conscrypt.OpenSSLCipher
        void checkSupportedKeySize(int i) throws InvalidKeyException {
            if (i == 16 || i == 24 || i == 32) {
                return;
            }
            throw new InvalidKeyException("Unsupported key size: " + i + " bytes");
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES_128.class */
    public static class AES_128 extends OpenSSLEvpCipherAES {

        /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES_128$CBC.class */
        public static class CBC extends AES_128 {

            /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES_128$CBC$NoPadding.class */
            public static class NoPadding extends CBC {
                public NoPadding() {
                    super(OpenSSLCipher.Padding.NOPADDING);
                }
            }

            /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES_128$CBC$PKCS5Padding.class */
            public static class PKCS5Padding extends CBC {
                public PKCS5Padding() {
                    super(OpenSSLCipher.Padding.PKCS5PADDING);
                }
            }

            CBC(OpenSSLCipher.Padding padding) {
                super(OpenSSLCipher.Mode.CBC, padding);
            }
        }

        /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES_128$CTR.class */
        public static class CTR extends AES_128 {
            public CTR() {
                super(OpenSSLCipher.Mode.CTR, OpenSSLCipher.Padding.NOPADDING);
            }
        }

        /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES_128$ECB.class */
        public static class ECB extends AES_128 {

            /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES_128$ECB$NoPadding.class */
            public static class NoPadding extends ECB {
                public NoPadding() {
                    super(OpenSSLCipher.Padding.NOPADDING);
                }
            }

            /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES_128$ECB$PKCS5Padding.class */
            public static class PKCS5Padding extends ECB {
                public PKCS5Padding() {
                    super(OpenSSLCipher.Padding.PKCS5PADDING);
                }
            }

            ECB(OpenSSLCipher.Padding padding) {
                super(OpenSSLCipher.Mode.ECB, padding);
            }
        }

        AES_128(OpenSSLCipher.Mode mode, OpenSSLCipher.Padding padding) {
            super(mode, padding);
        }

        @Override // org.conscrypt.OpenSSLCipher
        void checkSupportedKeySize(int i) throws InvalidKeyException {
            if (i == 16) {
                return;
            }
            throw new InvalidKeyException("Unsupported key size: " + i + " bytes");
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES_256.class */
    public static class AES_256 extends OpenSSLEvpCipherAES {

        /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES_256$CBC.class */
        public static class CBC extends AES_256 {

            /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES_256$CBC$NoPadding.class */
            public static class NoPadding extends CBC {
                public NoPadding() {
                    super(OpenSSLCipher.Padding.NOPADDING);
                }
            }

            /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES_256$CBC$PKCS5Padding.class */
            public static class PKCS5Padding extends CBC {
                public PKCS5Padding() {
                    super(OpenSSLCipher.Padding.PKCS5PADDING);
                }
            }

            CBC(OpenSSLCipher.Padding padding) {
                super(OpenSSLCipher.Mode.CBC, padding);
            }
        }

        /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES_256$CTR.class */
        public static class CTR extends AES_256 {
            public CTR() {
                super(OpenSSLCipher.Mode.CTR, OpenSSLCipher.Padding.NOPADDING);
            }
        }

        /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES_256$ECB.class */
        public static class ECB extends AES_256 {

            /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES_256$ECB$NoPadding.class */
            public static class NoPadding extends ECB {
                public NoPadding() {
                    super(OpenSSLCipher.Padding.NOPADDING);
                }
            }

            /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipherAES$AES_256$ECB$PKCS5Padding.class */
            public static class PKCS5Padding extends ECB {
                public PKCS5Padding() {
                    super(OpenSSLCipher.Padding.PKCS5PADDING);
                }
            }

            ECB(OpenSSLCipher.Padding padding) {
                super(OpenSSLCipher.Mode.ECB, padding);
            }
        }

        AES_256(OpenSSLCipher.Mode mode, OpenSSLCipher.Padding padding) {
            super(mode, padding);
        }

        @Override // org.conscrypt.OpenSSLCipher
        void checkSupportedKeySize(int i) throws InvalidKeyException {
            if (i == 32) {
                return;
            }
            throw new InvalidKeyException("Unsupported key size: " + i + " bytes");
        }
    }

    OpenSSLEvpCipherAES(OpenSSLCipher.Mode mode, OpenSSLCipher.Padding padding) {
        super(mode, padding);
    }

    @Override // org.conscrypt.OpenSSLCipher
    void checkSupportedMode(OpenSSLCipher.Mode mode) throws NoSuchAlgorithmException {
        int i = AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Mode[mode.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return;
        }
        throw new NoSuchAlgorithmException("Unsupported mode " + mode.toString());
    }

    @Override // org.conscrypt.OpenSSLCipher
    void checkSupportedPadding(OpenSSLCipher.Padding padding) throws NoSuchPaddingException {
        int i = AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Padding[padding.ordinal()];
        if (i == 1 || i == 2) {
            return;
        }
        throw new NoSuchPaddingException("Unsupported padding " + padding.toString());
    }

    @Override // org.conscrypt.OpenSSLCipher
    String getBaseCipherName() {
        return "AES";
    }

    @Override // org.conscrypt.OpenSSLCipher
    int getCipherBlockSize() {
        return 16;
    }

    @Override // org.conscrypt.OpenSSLEvpCipher
    String getCipherName(int i, OpenSSLCipher.Mode mode) {
        return "aes-" + (i * 8) + "-" + mode.toString().toLowerCase(Locale.US);
    }
}
