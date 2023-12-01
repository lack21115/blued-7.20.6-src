package com.android.org.conscrypt;

import com.huawei.openalliance.ad.constant.at;
import com.tencent.qcloud.core.auth.AuthConstants;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.MacSpi;
import javax.crypto.SecretKey;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLMac.class */
public abstract class OpenSSLMac extends MacSpi {
    private OpenSSLDigestContext ctx;
    private final long evp_md;
    private final int evp_pkey_type;
    private OpenSSLKey macKey;
    private final byte[] singleByte;
    private final int size;

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLMac$HmacMD5.class */
    public static class HmacMD5 extends OpenSSLMac {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("md5");
        private static final int SIZE = NativeCrypto.EVP_MD_size(EVP_MD);

        public HmacMD5() {
            super(EVP_MD, SIZE, NativeCrypto.EVP_PKEY_HMAC);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLMac$HmacSHA1.class */
    public static class HmacSHA1 extends OpenSSLMac {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname(AuthConstants.SHA1);
        private static final int SIZE = NativeCrypto.EVP_MD_size(EVP_MD);

        public HmacSHA1() {
            super(EVP_MD, SIZE, NativeCrypto.EVP_PKEY_HMAC);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLMac$HmacSHA224.class */
    public static class HmacSHA224 extends OpenSSLMac {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("sha224");
        private static final int SIZE = NativeCrypto.EVP_MD_size(EVP_MD);

        public HmacSHA224() throws NoSuchAlgorithmException {
            super(EVP_MD, SIZE, NativeCrypto.EVP_PKEY_HMAC);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLMac$HmacSHA256.class */
    public static class HmacSHA256 extends OpenSSLMac {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname(at.aq);
        private static final int SIZE = NativeCrypto.EVP_MD_size(EVP_MD);

        public HmacSHA256() throws NoSuchAlgorithmException {
            super(EVP_MD, SIZE, NativeCrypto.EVP_PKEY_HMAC);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLMac$HmacSHA384.class */
    public static class HmacSHA384 extends OpenSSLMac {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("sha384");
        private static final int SIZE = NativeCrypto.EVP_MD_size(EVP_MD);

        public HmacSHA384() throws NoSuchAlgorithmException {
            super(EVP_MD, SIZE, NativeCrypto.EVP_PKEY_HMAC);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLMac$HmacSHA512.class */
    public static class HmacSHA512 extends OpenSSLMac {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("sha512");
        private static final int SIZE = NativeCrypto.EVP_MD_size(EVP_MD);

        public HmacSHA512() {
            super(EVP_MD, SIZE, NativeCrypto.EVP_PKEY_HMAC);
        }
    }

    private OpenSSLMac(long j, int i, int i2) {
        this.singleByte = new byte[1];
        this.evp_md = j;
        this.size = i;
        this.evp_pkey_type = i2;
    }

    private final void resetContext() {
        OpenSSLDigestContext openSSLDigestContext = new OpenSSLDigestContext(NativeCrypto.EVP_MD_CTX_create());
        NativeCrypto.EVP_MD_CTX_init(openSSLDigestContext);
        OpenSSLKey openSSLKey = this.macKey;
        if (openSSLKey != null) {
            NativeCrypto.EVP_DigestSignInit(openSSLDigestContext, this.evp_md, openSSLKey.getPkeyContext());
        }
        this.ctx = openSSLDigestContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.MacSpi
    public byte[] engineDoFinal() {
        byte[] EVP_DigestSignFinal = NativeCrypto.EVP_DigestSignFinal(this.ctx);
        resetContext();
        return EVP_DigestSignFinal;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.MacSpi
    public int engineGetMacLength() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.MacSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (!(key instanceof SecretKey)) {
            throw new InvalidKeyException("key must be a SecretKey");
        }
        if (algorithmParameterSpec != null) {
            throw new InvalidAlgorithmParameterException("unknown parameter type");
        }
        if (key instanceof OpenSSLKeyHolder) {
            this.macKey = ((OpenSSLKeyHolder) key).getOpenSSLKey();
        } else {
            byte[] encoded = key.getEncoded();
            if (encoded == null) {
                throw new InvalidKeyException("key cannot be encoded");
            }
            this.macKey = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_mac_key(this.evp_pkey_type, encoded));
        }
        resetContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.MacSpi
    public void engineReset() {
        resetContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.MacSpi
    public void engineUpdate(byte b) {
        this.singleByte[0] = b;
        engineUpdate(this.singleByte, 0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.MacSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        NativeCrypto.EVP_DigestUpdate(this.ctx, bArr, i, i2);
    }
}
