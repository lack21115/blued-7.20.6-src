package com.android.org.conscrypt;

import com.youzan.androidsdk.tool.AppSigning;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSignature.class */
public class OpenSSLSignature extends SignatureSpi {
    private OpenSSLDigestContext ctx;
    private final EngineType engineType;
    private final long evpAlgorithm;
    private OpenSSLKey key;
    private boolean signing;
    private final byte[] singleByte;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.android.org.conscrypt.OpenSSLSignature$1  reason: invalid class name */
    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSignature$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLSignature$EngineType = new int[EngineType.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002d -> B:17:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0031 -> B:15:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$org$conscrypt$OpenSSLSignature$EngineType[EngineType.RSA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLSignature$EngineType[EngineType.DSA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLSignature$EngineType[EngineType.EC.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSignature$EngineType.class */
    public enum EngineType {
        RSA,
        DSA,
        EC
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSignature$MD5RSA.class */
    public static final class MD5RSA extends OpenSSLSignature {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("RSA-MD5");

        public MD5RSA() throws NoSuchAlgorithmException {
            super(EVP_MD, EngineType.RSA, null);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSignature$SHA1DSA.class */
    public static final class SHA1DSA extends OpenSSLSignature {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("DSA-SHA1");

        public SHA1DSA() throws NoSuchAlgorithmException {
            super(EVP_MD, EngineType.DSA, null);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSignature$SHA1ECDSA.class */
    public static final class SHA1ECDSA extends OpenSSLSignature {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname(AppSigning.SHA1);

        public SHA1ECDSA() throws NoSuchAlgorithmException {
            super(EVP_MD, EngineType.EC, null);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSignature$SHA1RSA.class */
    public static final class SHA1RSA extends OpenSSLSignature {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("RSA-SHA1");

        public SHA1RSA() throws NoSuchAlgorithmException {
            super(EVP_MD, EngineType.RSA, null);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSignature$SHA224ECDSA.class */
    public static final class SHA224ECDSA extends OpenSSLSignature {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("SHA224");

        public SHA224ECDSA() throws NoSuchAlgorithmException {
            super(EVP_MD, EngineType.EC, null);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSignature$SHA224RSA.class */
    public static final class SHA224RSA extends OpenSSLSignature {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("RSA-SHA224");

        public SHA224RSA() throws NoSuchAlgorithmException {
            super(EVP_MD, EngineType.RSA, null);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSignature$SHA256ECDSA.class */
    public static final class SHA256ECDSA extends OpenSSLSignature {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname(AppSigning.SHA256);

        public SHA256ECDSA() throws NoSuchAlgorithmException {
            super(EVP_MD, EngineType.EC, null);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSignature$SHA256RSA.class */
    public static final class SHA256RSA extends OpenSSLSignature {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("RSA-SHA256");

        public SHA256RSA() throws NoSuchAlgorithmException {
            super(EVP_MD, EngineType.RSA, null);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSignature$SHA384ECDSA.class */
    public static final class SHA384ECDSA extends OpenSSLSignature {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("SHA384");

        public SHA384ECDSA() throws NoSuchAlgorithmException {
            super(EVP_MD, EngineType.EC, null);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSignature$SHA384RSA.class */
    public static final class SHA384RSA extends OpenSSLSignature {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("RSA-SHA384");

        public SHA384RSA() throws NoSuchAlgorithmException {
            super(EVP_MD, EngineType.RSA, null);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSignature$SHA512ECDSA.class */
    public static final class SHA512ECDSA extends OpenSSLSignature {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("SHA512");

        public SHA512ECDSA() throws NoSuchAlgorithmException {
            super(EVP_MD, EngineType.EC, null);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLSignature$SHA512RSA.class */
    public static final class SHA512RSA extends OpenSSLSignature {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("RSA-SHA512");

        public SHA512RSA() throws NoSuchAlgorithmException {
            super(EVP_MD, EngineType.RSA, null);
        }
    }

    private OpenSSLSignature(long j, EngineType engineType) throws NoSuchAlgorithmException {
        this.singleByte = new byte[1];
        this.engineType = engineType;
        this.evpAlgorithm = j;
    }

    /* synthetic */ OpenSSLSignature(long j, EngineType engineType, AnonymousClass1 anonymousClass1) throws NoSuchAlgorithmException {
        this(j, engineType);
    }

    private void checkEngineType(OpenSSLKey openSSLKey) throws InvalidKeyException {
        int EVP_PKEY_type = NativeCrypto.EVP_PKEY_type(openSSLKey.getPkeyContext());
        switch (AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLSignature$EngineType[this.engineType.ordinal()]) {
            case 1:
                if (EVP_PKEY_type != 6) {
                    throw new InvalidKeyException("Signature initialized as " + this.engineType + " (not RSA)");
                }
                return;
            case 2:
                if (EVP_PKEY_type != 116) {
                    throw new InvalidKeyException("Signature initialized as " + this.engineType + " (not DSA)");
                }
                return;
            case 3:
                if (EVP_PKEY_type != 408) {
                    throw new InvalidKeyException("Signature initialized as " + this.engineType + " (not EC)");
                }
                return;
            default:
                throw new InvalidKeyException("Key must be of type " + this.engineType);
        }
    }

    private void enableDSASignatureNonceHardeningIfApplicable() {
        OpenSSLKey openSSLKey = this.key;
        switch (AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLSignature$EngineType[this.engineType.ordinal()]) {
            case 2:
                NativeCrypto.set_DSA_flag_nonce_from_hash(openSSLKey.getPkeyContext());
                return;
            case 3:
                NativeCrypto.EC_KEY_set_nonce_from_hash(openSSLKey.getPkeyContext(), true);
                return;
            default:
                return;
        }
    }

    private void initInternal(OpenSSLKey openSSLKey, boolean z) throws InvalidKeyException {
        checkEngineType(openSSLKey);
        this.key = openSSLKey;
        this.signing = z;
        resetContext();
    }

    private final void resetContext() {
        OpenSSLDigestContext openSSLDigestContext = new OpenSSLDigestContext(NativeCrypto.EVP_MD_CTX_create());
        NativeCrypto.EVP_MD_CTX_init(openSSLDigestContext);
        if (this.signing) {
            enableDSASignatureNonceHardeningIfApplicable();
            NativeCrypto.EVP_SignInit(openSSLDigestContext, this.evpAlgorithm);
        } else {
            NativeCrypto.EVP_VerifyInit(openSSLDigestContext, this.evpAlgorithm);
        }
        this.ctx = openSSLDigestContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) throws InvalidParameterException {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        initInternal(OpenSSLKey.fromPrivateKey(privateKey), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        initInternal(OpenSSLKey.fromPublicKey(publicKey), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) throws InvalidParameterException {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        if (this.key == null) {
            throw new SignatureException("Need DSA or RSA or EC private key");
        }
        OpenSSLDigestContext openSSLDigestContext = this.ctx;
        try {
            try {
                byte[] bArr = new byte[NativeCrypto.EVP_PKEY_size(this.key.getPkeyContext())];
                int EVP_SignFinal = NativeCrypto.EVP_SignFinal(openSSLDigestContext, bArr, 0, this.key.getPkeyContext());
                byte[] bArr2 = new byte[EVP_SignFinal];
                System.arraycopy(bArr, 0, bArr2, 0, EVP_SignFinal);
                return bArr2;
            } catch (Exception e) {
                throw new SignatureException(e);
            }
        } finally {
            resetContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.singleByte[0] = b;
        engineUpdate(this.singleByte, 0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        OpenSSLDigestContext openSSLDigestContext = this.ctx;
        if (this.signing) {
            NativeCrypto.EVP_SignUpdate(openSSLDigestContext, bArr, i, i2);
        } else {
            NativeCrypto.EVP_VerifyUpdate(openSSLDigestContext, bArr, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        if (this.key == null) {
            throw new SignatureException("Need DSA or RSA public key");
        }
        try {
            boolean z = NativeCrypto.EVP_VerifyFinal(this.ctx, bArr, 0, bArr.length, this.key.getPkeyContext()) == 1;
            resetContext();
            return z;
        } catch (Exception e) {
            resetContext();
            return false;
        } catch (Throwable th) {
            resetContext();
            throw th;
        }
    }
}
