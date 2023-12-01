package com.android.org.conscrypt;

import java.security.MessageDigestSpi;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLMessageDigestJDK.class */
public class OpenSSLMessageDigestJDK extends MessageDigestSpi implements Cloneable {
    private OpenSSLDigestContext ctx;
    private final long evp_md;
    private final byte[] singleByte;
    private final int size;

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLMessageDigestJDK$MD5.class */
    public static class MD5 extends OpenSSLMessageDigestJDK {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("md5");
        private static final int SIZE = NativeCrypto.EVP_MD_size(EVP_MD);

        public MD5() throws NoSuchAlgorithmException {
            super(EVP_MD, SIZE);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLMessageDigestJDK$SHA1.class */
    public static class SHA1 extends OpenSSLMessageDigestJDK {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("sha1");
        private static final int SIZE = NativeCrypto.EVP_MD_size(EVP_MD);

        public SHA1() throws NoSuchAlgorithmException {
            super(EVP_MD, SIZE);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLMessageDigestJDK$SHA224.class */
    public static class SHA224 extends OpenSSLMessageDigestJDK {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("sha224");
        private static final int SIZE = NativeCrypto.EVP_MD_size(EVP_MD);

        public SHA224() throws NoSuchAlgorithmException {
            super(EVP_MD, SIZE);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLMessageDigestJDK$SHA256.class */
    public static class SHA256 extends OpenSSLMessageDigestJDK {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("sha256");
        private static final int SIZE = NativeCrypto.EVP_MD_size(EVP_MD);

        public SHA256() throws NoSuchAlgorithmException {
            super(EVP_MD, SIZE);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLMessageDigestJDK$SHA384.class */
    public static class SHA384 extends OpenSSLMessageDigestJDK {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("sha384");
        private static final int SIZE = NativeCrypto.EVP_MD_size(EVP_MD);

        public SHA384() throws NoSuchAlgorithmException {
            super(EVP_MD, SIZE);
        }
    }

    /* loaded from: source-273268-dex2jar.jar:com/android/org/conscrypt/OpenSSLMessageDigestJDK$SHA512.class */
    public static class SHA512 extends OpenSSLMessageDigestJDK {
        private static final long EVP_MD = NativeCrypto.EVP_get_digestbyname("sha512");
        private static final int SIZE = NativeCrypto.EVP_MD_size(EVP_MD);

        public SHA512() throws NoSuchAlgorithmException {
            super(EVP_MD, SIZE);
        }
    }

    private OpenSSLMessageDigestJDK(long j, int i) throws NoSuchAlgorithmException {
        this.singleByte = new byte[1];
        this.evp_md = j;
        this.size = i;
        resetContext();
    }

    private OpenSSLMessageDigestJDK(long j, int i, OpenSSLDigestContext openSSLDigestContext) {
        this.singleByte = new byte[1];
        this.evp_md = j;
        this.size = i;
        this.ctx = openSSLDigestContext;
    }

    private final void resetContext() {
        OpenSSLDigestContext openSSLDigestContext = new OpenSSLDigestContext(NativeCrypto.EVP_MD_CTX_create());
        NativeCrypto.EVP_MD_CTX_init(openSSLDigestContext);
        NativeCrypto.EVP_DigestInit(openSSLDigestContext, this.evp_md);
        this.ctx = openSSLDigestContext;
    }

    @Override // java.security.MessageDigestSpi
    public Object clone() {
        OpenSSLDigestContext openSSLDigestContext = new OpenSSLDigestContext(NativeCrypto.EVP_MD_CTX_create());
        NativeCrypto.EVP_MD_CTX_init(openSSLDigestContext);
        NativeCrypto.EVP_MD_CTX_copy(openSSLDigestContext, this.ctx);
        return new OpenSSLMessageDigestJDK(this.evp_md, this.size, openSSLDigestContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.MessageDigestSpi
    public byte[] engineDigest() {
        byte[] bArr = new byte[this.size];
        NativeCrypto.EVP_DigestFinal(this.ctx, bArr, 0);
        resetContext();
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.MessageDigestSpi
    public int engineGetDigestLength() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.MessageDigestSpi
    public void engineReset() {
        resetContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte b) {
        this.singleByte[0] = b;
        engineUpdate(this.singleByte, 0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        NativeCrypto.EVP_DigestUpdate(this.ctx, bArr, i, i2);
    }
}
