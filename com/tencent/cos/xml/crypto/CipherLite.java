package com.tencent.cos.xml.crypto;

import com.tencent.cos.xml.exception.CosXmlClientException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.NullCipher;
import javax.crypto.SecretKey;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/CipherLite.class */
public class CipherLite {
    static final CipherLite Null = new CipherLite() { // from class: com.tencent.cos.xml.crypto.CipherLite.1
        @Override // com.tencent.cos.xml.crypto.CipherLite
        CipherLite createAuxiliary(long j) {
            return this;
        }

        @Override // com.tencent.cos.xml.crypto.CipherLite
        CipherLite createInverse() {
            return this;
        }
    };
    private final Cipher cipher;
    private final int cipherMode;
    private final ContentCryptoScheme scheme;
    private final SecretKey secreteKey;

    private CipherLite() {
        this.cipher = new NullCipher();
        this.scheme = null;
        this.secreteKey = null;
        this.cipherMode = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CipherLite(Cipher cipher, ContentCryptoScheme contentCryptoScheme, SecretKey secretKey, int i) {
        this.cipher = cipher;
        this.scheme = contentCryptoScheme;
        this.secreteKey = secretKey;
        this.cipherMode = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CipherLite createAuxiliary(long j) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        return this.scheme.createAuxillaryCipher(this.secreteKey, this.cipher.getIV(), this.cipherMode, this.cipher.getProvider(), j);
    }

    CipherLite createInverse() throws CosXmlClientException {
        int i = this.cipherMode;
        int i2 = 1;
        if (i != 2) {
            if (i != 1) {
                throw new UnsupportedOperationException();
            }
            i2 = 2;
        }
        return this.scheme.createCipherLite(this.secreteKey, this.cipher.getIV(), i2, this.cipher.getProvider());
    }

    CipherLite createUsingIV(byte[] bArr) throws CosXmlClientException {
        return this.scheme.createCipherLite(this.secreteKey, bArr, this.cipherMode, this.cipher.getProvider());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] doFinal() throws IllegalBlockSizeException, BadPaddingException {
        return this.cipher.doFinal();
    }

    byte[] doFinal(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException {
        return this.cipher.doFinal(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] doFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        return this.cipher.doFinal(bArr, i, i2);
    }

    final int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    final Cipher getCipher() {
        return this.cipher;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getCipherAlgorithm() {
        return this.cipher.getAlgorithm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getCipherMode() {
        return this.cipherMode;
    }

    final Provider getCipherProvider() {
        return this.cipher.getProvider();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ContentCryptoScheme getContentCryptoScheme() {
        return this.scheme;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] getIV() {
        return this.cipher.getIV();
    }

    int getOutputSize(int i) {
        return this.cipher.getOutputSize(i);
    }

    final String getSecretKeyAlgorithm() {
        return this.secreteKey.getAlgorithm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long mark() {
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean markSupported() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CipherLite recreate() throws CosXmlClientException {
        return this.scheme.createCipherLite(this.secreteKey, this.cipher.getIV(), this.cipherMode, this.cipher.getProvider());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        throw new IllegalStateException("mark/reset not supported");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] update(byte[] bArr, int i, int i2) {
        return this.cipher.update(bArr, i, i2);
    }
}
