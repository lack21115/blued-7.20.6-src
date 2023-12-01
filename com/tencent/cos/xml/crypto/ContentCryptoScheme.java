package com.tencent.cos.xml.crypto;

import com.tencent.cos.xml.exception.CosXmlClientException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/ContentCryptoScheme.class */
public abstract class ContentCryptoScheme {
    static final long MAX_CBC_BYTES = 4503599627370496L;
    static final long MAX_CTR_BYTES = -1;
    static final long MAX_GCM_BLOCKS = 4294967294L;
    static final long MAX_GCM_BYTES = 68719476704L;
    static final ContentCryptoScheme AES_GCM = new AesGcm();
    static final ContentCryptoScheme AES_CTR = new AesCtr();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ContentCryptoScheme fromCEKAlgo(String str) {
        if (AES_CTR.getCipherAlgorithm().equals(str)) {
            return AES_CTR;
        }
        throw new UnsupportedOperationException("Unsupported content encryption scheme: " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] incrementBlocks(byte[] bArr, long j) {
        if (j == 0) {
            return bArr;
        }
        if (bArr == null || bArr.length != 16) {
            throw new IllegalArgumentException();
        }
        if (j > MAX_GCM_BLOCKS) {
            throw new IllegalStateException();
        }
        ByteBuffer allocate = ByteBuffer.allocate(8);
        int i = 12;
        while (true) {
            int i2 = i;
            if (i2 > 15) {
                break;
            }
            allocate.put(i2 - 8, bArr[i2]);
            i = i2 + 1;
        }
        long j2 = allocate.getLong() + j;
        if (j2 > MAX_GCM_BLOCKS) {
            throw new IllegalStateException();
        }
        allocate.rewind();
        byte[] array = allocate.putLong(j2).array();
        int i3 = 12;
        while (true) {
            int i4 = i3;
            if (i4 > 15) {
                return bArr;
            }
            bArr[i4] = array[i4 - 8];
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] adjustIV(byte[] bArr, long j) {
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CipherLite createAuxillaryCipher(SecretKey secretKey, byte[] bArr, int i, Provider provider, long j) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        return null;
    }

    CipherLite createCipherLite(SecretKey secretKey, byte[] bArr, int i) throws CosXmlClientException {
        return createCipherLite(secretKey, bArr, i, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CipherLite createCipherLite(SecretKey secretKey, byte[] bArr, int i, Provider provider) throws CosXmlClientException {
        String specificCipherProvider = getSpecificCipherProvider();
        try {
            Cipher cipher = specificCipherProvider != null ? Cipher.getInstance(getCipherAlgorithm(), specificCipherProvider) : provider != null ? Cipher.getInstance(getCipherAlgorithm(), provider) : Cipher.getInstance(getCipherAlgorithm());
            cipher.init(i, secretKey, new IvParameterSpec(bArr));
            return newCipherLite(cipher, secretKey, i);
        } catch (Exception e) {
            throw CosXmlClientException.internalException("Unable to build cipher: " + e.getMessage() + "\nMake sure you have the JCE unlimited strength policy files installed and configured for your JVM");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getBlockSizeInBytes();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String getCipherAlgorithm();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getIVLengthInBytes();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String getKeyGeneratorAlgorithm();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getKeyLengthInBits();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getKeySpec() {
        return getKeyGeneratorAlgorithm() + "_" + getKeyLengthInBits();
    }

    abstract long getMaxPlaintextSize();

    String getSpecificCipherProvider() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getTagLengthInBits() {
        return 0;
    }

    protected CipherLite newCipherLite(Cipher cipher, SecretKey secretKey, int i) {
        return new CipherLite(cipher, this, secretKey, i);
    }

    public String toString() {
        return "cipherAlgo=" + getCipherAlgorithm() + ", blockSizeInBytes=" + getBlockSizeInBytes() + ", ivLengthInBytes=" + getIVLengthInBytes() + ", keyGenAlgo=" + getKeyGeneratorAlgorithm() + ", keyLengthInBits=" + getKeyLengthInBits() + ", specificProvider=" + getSpecificCipherProvider() + ", tagLengthInBits=" + getTagLengthInBits();
    }
}
