package org.conscrypt;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.MacSpi;
import javax.crypto.SecretKey;
import org.conscrypt.EvpMdRef;
import org.conscrypt.NativeRef;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLMac.class */
public abstract class OpenSSLMac extends MacSpi {
    private NativeRef.HMAC_CTX ctx;
    private final long evp_md;
    private byte[] keyBytes;
    private final byte[] singleByte;
    private final int size;

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLMac$HmacMD5.class */
    public static final class HmacMD5 extends OpenSSLMac {
        public HmacMD5() {
            super(EvpMdRef.MD5.EVP_MD, EvpMdRef.MD5.SIZE_BYTES);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLMac$HmacSHA1.class */
    public static final class HmacSHA1 extends OpenSSLMac {
        public HmacSHA1() {
            super(EvpMdRef.SHA1.EVP_MD, EvpMdRef.SHA1.SIZE_BYTES);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLMac$HmacSHA224.class */
    public static final class HmacSHA224 extends OpenSSLMac {
        public HmacSHA224() throws NoSuchAlgorithmException {
            super(EvpMdRef.SHA224.EVP_MD, EvpMdRef.SHA224.SIZE_BYTES);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLMac$HmacSHA256.class */
    public static final class HmacSHA256 extends OpenSSLMac {
        public HmacSHA256() throws NoSuchAlgorithmException {
            super(EvpMdRef.SHA256.EVP_MD, EvpMdRef.SHA256.SIZE_BYTES);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLMac$HmacSHA384.class */
    public static final class HmacSHA384 extends OpenSSLMac {
        public HmacSHA384() throws NoSuchAlgorithmException {
            super(EvpMdRef.SHA384.EVP_MD, EvpMdRef.SHA384.SIZE_BYTES);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLMac$HmacSHA512.class */
    public static final class HmacSHA512 extends OpenSSLMac {
        public HmacSHA512() {
            super(EvpMdRef.SHA512.EVP_MD, EvpMdRef.SHA512.SIZE_BYTES);
        }
    }

    private OpenSSLMac(long j, int i) {
        this.singleByte = new byte[1];
        this.evp_md = j;
        this.size = i;
    }

    private final void resetContext() {
        NativeRef.HMAC_CTX hmac_ctx = new NativeRef.HMAC_CTX(NativeCrypto.HMAC_CTX_new());
        byte[] bArr = this.keyBytes;
        if (bArr != null) {
            NativeCrypto.HMAC_Init_ex(hmac_ctx, bArr, this.evp_md);
        }
        this.ctx = hmac_ctx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.MacSpi
    public byte[] engineDoFinal() {
        byte[] HMAC_Final = NativeCrypto.HMAC_Final(this.ctx);
        resetContext();
        return HMAC_Final;
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
        byte[] encoded = key.getEncoded();
        this.keyBytes = encoded;
        if (encoded == null) {
            throw new InvalidKeyException("key cannot be encoded");
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
        byte[] bArr = this.singleByte;
        bArr[0] = b;
        engineUpdate(bArr, 0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.MacSpi
    public void engineUpdate(ByteBuffer byteBuffer) {
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
            NativeCrypto.HMAC_UpdateDirect(this.ctx, directBufferAddress + j, remaining);
            byteBuffer.position(position + remaining);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.MacSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        NativeCrypto.HMAC_Update(this.ctx, bArr, i, i2);
    }
}
