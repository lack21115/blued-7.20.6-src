package com.tencent.cos.xml.crypto;

import com.tencent.cos.xml.exception.CosXmlClientException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/AesGcm.class */
class AesGcm extends ContentCryptoScheme {
    @Override // com.tencent.cos.xml.crypto.ContentCryptoScheme
    CipherLite createAuxillaryCipher(SecretKey secretKey, byte[] bArr, int i, Provider provider, long j) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        try {
            return AES_CTR.createCipherLite(secretKey, AES_CTR.adjustIV(bArr, j), i, provider);
        } catch (CosXmlClientException e) {
            throw new InvalidKeyException(e);
        }
    }

    @Override // com.tencent.cos.xml.crypto.ContentCryptoScheme
    int getBlockSizeInBytes() {
        return 16;
    }

    @Override // com.tencent.cos.xml.crypto.ContentCryptoScheme
    String getCipherAlgorithm() {
        return "AES/GCM/NoPadding";
    }

    @Override // com.tencent.cos.xml.crypto.ContentCryptoScheme
    int getIVLengthInBytes() {
        return 12;
    }

    @Override // com.tencent.cos.xml.crypto.ContentCryptoScheme
    String getKeyGeneratorAlgorithm() {
        return "AES";
    }

    @Override // com.tencent.cos.xml.crypto.ContentCryptoScheme
    int getKeyLengthInBits() {
        return 256;
    }

    @Override // com.tencent.cos.xml.crypto.ContentCryptoScheme
    long getMaxPlaintextSize() {
        return 68719476704L;
    }

    @Override // com.tencent.cos.xml.crypto.ContentCryptoScheme
    String getSpecificCipherProvider() {
        return "BC";
    }

    @Override // com.tencent.cos.xml.crypto.ContentCryptoScheme
    int getTagLengthInBits() {
        return 128;
    }

    @Override // com.tencent.cos.xml.crypto.ContentCryptoScheme
    protected CipherLite newCipherLite(Cipher cipher, SecretKey secretKey, int i) {
        return new GCMCipherLite(cipher, secretKey, i);
    }
}
