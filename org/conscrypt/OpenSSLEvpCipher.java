package org.conscrypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import org.conscrypt.NativeRef;
import org.conscrypt.OpenSSLCipher;

/* loaded from: source-3503164-dex2jar.jar:org/conscrypt/OpenSSLEvpCipher.class */
public abstract class OpenSSLEvpCipher extends OpenSSLCipher {
    private boolean calledUpdate;
    private final NativeRef.EVP_CIPHER_CTX cipherCtx;
    private int modeBlockSize;

    public OpenSSLEvpCipher(OpenSSLCipher.Mode mode, OpenSSLCipher.Padding padding) {
        super(mode, padding);
        this.cipherCtx = new NativeRef.EVP_CIPHER_CTX(NativeCrypto.EVP_CIPHER_CTX_new());
    }

    private void reset() {
        NativeCrypto.EVP_CipherInit_ex(this.cipherCtx, 0L, this.encodedKey, this.iv, isEncrypting());
        this.calledUpdate = false;
    }

    @Override // org.conscrypt.OpenSSLCipher
    int doFinalInternal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        int EVP_CipherFinal_ex;
        if (isEncrypting() || this.calledUpdate) {
            int length = bArr.length - i;
            if (length >= i2) {
                EVP_CipherFinal_ex = NativeCrypto.EVP_CipherFinal_ex(this.cipherCtx, bArr, i);
            } else {
                byte[] bArr2 = new byte[i2];
                EVP_CipherFinal_ex = NativeCrypto.EVP_CipherFinal_ex(this.cipherCtx, bArr2, 0);
                if (EVP_CipherFinal_ex > length) {
                    throw new ShortBufferWithoutStackTraceException("buffer is too short: " + EVP_CipherFinal_ex + " > " + length);
                } else if (EVP_CipherFinal_ex > 0) {
                    System.arraycopy((Object) bArr2, 0, (Object) bArr, i, EVP_CipherFinal_ex);
                }
            }
            reset();
            return (EVP_CipherFinal_ex + i) - i;
        }
        return 0;
    }

    @Override // org.conscrypt.OpenSSLCipher
    void engineInitInternal(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArr2;
        byte[] iv = algorithmParameterSpec instanceof IvParameterSpec ? ((IvParameterSpec) algorithmParameterSpec).getIV() : null;
        long EVP_get_cipherbyname = NativeCrypto.EVP_get_cipherbyname(getCipherName(bArr.length, this.mode));
        if (EVP_get_cipherbyname == 0) {
            throw new InvalidAlgorithmParameterException("Cannot find name for key length = " + (bArr.length * 8) + " and mode = " + this.mode);
        }
        boolean isEncrypting = isEncrypting();
        int EVP_CIPHER_iv_length = NativeCrypto.EVP_CIPHER_iv_length(EVP_get_cipherbyname);
        if (iv != null || EVP_CIPHER_iv_length == 0) {
            if (EVP_CIPHER_iv_length == 0 && iv != null) {
                throw new InvalidAlgorithmParameterException("IV not used in " + this.mode + " mode");
            }
            bArr2 = iv;
            if (iv != null) {
                if (iv.length != EVP_CIPHER_iv_length) {
                    throw new InvalidAlgorithmParameterException("expected IV length of " + EVP_CIPHER_iv_length + " but was " + iv.length);
                }
                bArr2 = iv;
            }
        } else if (!isEncrypting) {
            throw new InvalidAlgorithmParameterException("IV must be specified in " + this.mode + " mode");
        } else {
            byte[] bArr3 = new byte[EVP_CIPHER_iv_length];
            if (secureRandom != null) {
                secureRandom.nextBytes(bArr3);
                bArr2 = bArr3;
            } else {
                NativeCrypto.RAND_bytes(bArr3);
                bArr2 = bArr3;
            }
        }
        this.iv = bArr2;
        if (supportsVariableSizeKey()) {
            NativeCrypto.EVP_CipherInit_ex(this.cipherCtx, EVP_get_cipherbyname, null, null, isEncrypting);
            NativeCrypto.EVP_CIPHER_CTX_set_key_length(this.cipherCtx, bArr.length);
            NativeCrypto.EVP_CipherInit_ex(this.cipherCtx, 0L, bArr, bArr2, isEncrypting());
        } else {
            NativeCrypto.EVP_CipherInit_ex(this.cipherCtx, EVP_get_cipherbyname, bArr, bArr2, isEncrypting);
        }
        NativeCrypto.EVP_CIPHER_CTX_set_padding(this.cipherCtx, getPadding() == OpenSSLCipher.Padding.PKCS5PADDING);
        this.modeBlockSize = NativeCrypto.EVP_CIPHER_CTX_block_size(this.cipherCtx);
        this.calledUpdate = false;
    }

    abstract String getCipherName(int i, OpenSSLCipher.Mode mode);

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
        if (isEncrypting() != false) goto L19;
     */
    @Override // org.conscrypt.OpenSSLCipher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int getOutputSizeForFinal(int r5) {
        /*
            r4 = this;
            r0 = r4
            int r0 = r0.modeBlockSize
            r1 = 1
            if (r0 != r1) goto La
            r0 = r5
            return r0
        La:
            r0 = r4
            org.conscrypt.NativeRef$EVP_CIPHER_CTX r0 = r0.cipherCtx
            int r0 = org.conscrypt.NativeCrypto.get_EVP_CIPHER_CTX_buf_len(r0)
            r8 = r0
            r0 = r4
            org.conscrypt.OpenSSLCipher$Padding r0 = r0.getPadding()
            org.conscrypt.OpenSSLCipher$Padding r1 = org.conscrypt.OpenSSLCipher.Padding.NOPADDING
            if (r0 != r1) goto L22
            r0 = r8
            r1 = r5
            int r0 = r0 + r1
            return r0
        L22:
            r0 = r4
            org.conscrypt.NativeRef$EVP_CIPHER_CTX r0 = r0.cipherCtx
            boolean r0 = org.conscrypt.NativeCrypto.get_EVP_CIPHER_CTX_final_used(r0)
            r9 = r0
            r0 = 0
            r7 = r0
            r0 = r9
            if (r0 == 0) goto L3a
            r0 = r4
            int r0 = r0.modeBlockSize
            r6 = r0
            goto L3c
        L3a:
            r0 = 0
            r6 = r0
        L3c:
            r0 = r5
            r1 = r8
            int r0 = r0 + r1
            r1 = r6
            int r0 = r0 + r1
            r6 = r0
            r0 = r6
            r1 = r4
            int r1 = r1.modeBlockSize
            int r0 = r0 % r1
            if (r0 != 0) goto L55
            r0 = r7
            r5 = r0
            r0 = r4
            boolean r0 = r0.isEncrypting()
            if (r0 == 0) goto L5a
        L55:
            r0 = r4
            int r0 = r0.modeBlockSize
            r5 = r0
        L5a:
            r0 = r6
            r1 = r5
            int r0 = r0 + r1
            r5 = r0
            r0 = r5
            r1 = r5
            r2 = r4
            int r2 = r2.modeBlockSize
            int r1 = r1 % r2
            int r0 = r0 - r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.OpenSSLEvpCipher.getOutputSizeForFinal(int):int");
    }

    @Override // org.conscrypt.OpenSSLCipher
    int getOutputSizeForUpdate(int i) {
        return getOutputSizeForFinal(i);
    }

    @Override // org.conscrypt.OpenSSLCipher
    int updateInternal(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) throws ShortBufferException {
        int length = bArr2.length - i3;
        if (length >= i4) {
            int EVP_CipherUpdate = NativeCrypto.EVP_CipherUpdate(this.cipherCtx, bArr2, i3, bArr, i, i2);
            this.calledUpdate = true;
            return (EVP_CipherUpdate + i3) - i3;
        }
        throw new ShortBufferWithoutStackTraceException("output buffer too small during update: " + length + " < " + i4);
    }
}
