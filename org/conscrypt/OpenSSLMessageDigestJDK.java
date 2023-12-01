package org.conscrypt;

import java.nio.ByteBuffer;
import java.security.MessageDigestSpi;
import java.security.NoSuchAlgorithmException;
import org.conscrypt.EvpMdRef;
import org.conscrypt.NativeRef;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLMessageDigestJDK.class */
public class OpenSSLMessageDigestJDK extends MessageDigestSpi implements Cloneable {
    private final NativeRef.EVP_MD_CTX ctx;
    private boolean digestInitializedInContext;
    private final long evp_md;
    private final byte[] singleByte;
    private final int size;

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLMessageDigestJDK$MD5.class */
    public static final class MD5 extends OpenSSLMessageDigestJDK {
        public MD5() throws NoSuchAlgorithmException {
            super(EvpMdRef.MD5.EVP_MD, EvpMdRef.MD5.SIZE_BYTES);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLMessageDigestJDK$SHA1.class */
    public static final class SHA1 extends OpenSSLMessageDigestJDK {
        public SHA1() throws NoSuchAlgorithmException {
            super(EvpMdRef.SHA1.EVP_MD, EvpMdRef.SHA1.SIZE_BYTES);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLMessageDigestJDK$SHA224.class */
    public static final class SHA224 extends OpenSSLMessageDigestJDK {
        public SHA224() throws NoSuchAlgorithmException {
            super(EvpMdRef.SHA224.EVP_MD, EvpMdRef.SHA224.SIZE_BYTES);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLMessageDigestJDK$SHA256.class */
    public static final class SHA256 extends OpenSSLMessageDigestJDK {
        public SHA256() throws NoSuchAlgorithmException {
            super(EvpMdRef.SHA256.EVP_MD, EvpMdRef.SHA256.SIZE_BYTES);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLMessageDigestJDK$SHA384.class */
    public static final class SHA384 extends OpenSSLMessageDigestJDK {
        public SHA384() throws NoSuchAlgorithmException {
            super(EvpMdRef.SHA384.EVP_MD, EvpMdRef.SHA384.SIZE_BYTES);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLMessageDigestJDK$SHA512.class */
    public static final class SHA512 extends OpenSSLMessageDigestJDK {
        public SHA512() throws NoSuchAlgorithmException {
            super(EvpMdRef.SHA512.EVP_MD, EvpMdRef.SHA512.SIZE_BYTES);
        }
    }

    private OpenSSLMessageDigestJDK(long j, int i) throws NoSuchAlgorithmException {
        this.singleByte = new byte[1];
        this.evp_md = j;
        this.size = i;
        this.ctx = new NativeRef.EVP_MD_CTX(NativeCrypto.EVP_MD_CTX_create());
    }

    private OpenSSLMessageDigestJDK(long j, int i, NativeRef.EVP_MD_CTX evp_md_ctx, boolean z) {
        this.singleByte = new byte[1];
        this.evp_md = j;
        this.size = i;
        this.ctx = evp_md_ctx;
        this.digestInitializedInContext = z;
    }

    private void ensureDigestInitializedInContext() {
        synchronized (this) {
            if (!this.digestInitializedInContext) {
                NativeCrypto.EVP_DigestInit_ex(this.ctx, this.evp_md);
                this.digestInitializedInContext = true;
            }
        }
    }

    @Override // java.security.MessageDigestSpi
    public Object clone() {
        NativeRef.EVP_MD_CTX evp_md_ctx = new NativeRef.EVP_MD_CTX(NativeCrypto.EVP_MD_CTX_create());
        if (this.digestInitializedInContext) {
            NativeCrypto.EVP_MD_CTX_copy_ex(evp_md_ctx, this.ctx);
        }
        return new OpenSSLMessageDigestJDK(this.evp_md, this.size, evp_md_ctx, this.digestInitializedInContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.MessageDigestSpi
    public byte[] engineDigest() {
        byte[] bArr;
        synchronized (this) {
            ensureDigestInitializedInContext();
            bArr = new byte[this.size];
            NativeCrypto.EVP_DigestFinal_ex(this.ctx, bArr, 0);
            this.digestInitializedInContext = false;
        }
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
        synchronized (this) {
            NativeCrypto.EVP_MD_CTX_cleanup(this.ctx);
            this.digestInitializedInContext = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte b) {
        synchronized (this) {
            this.singleByte[0] = b;
            engineUpdate(this.singleByte, 0, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.MessageDigestSpi
    public void engineUpdate(ByteBuffer byteBuffer) {
        synchronized (this) {
            if (byteBuffer.hasRemaining()) {
                if (!byteBuffer.isDirect()) {
                    super.engineUpdate(byteBuffer);
                    return;
                }
                long directBufferAddress = NativeCrypto.getDirectBufferAddress(byteBuffer);
                if (directBufferAddress == 0) {
                    super.engineUpdate(byteBuffer);
                    return;
                }
                int position = byteBuffer.position();
                if (position < 0) {
                    throw new RuntimeException("Negative position");
                }
                long j = position;
                int remaining = byteBuffer.remaining();
                if (remaining < 0) {
                    throw new RuntimeException("Negative remaining amount");
                }
                ensureDigestInitializedInContext();
                NativeCrypto.EVP_DigestUpdateDirect(this.ctx, directBufferAddress + j, remaining);
                byteBuffer.position(position + remaining);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        synchronized (this) {
            ensureDigestInitializedInContext();
            NativeCrypto.EVP_DigestUpdate(this.ctx, bArr, i, i2);
        }
    }
}
