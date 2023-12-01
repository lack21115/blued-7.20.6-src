package com.tencent.cloud.huiyansdkface.normal.tools.secure;

import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cos.xml.crypto.JceEncryptionConstants;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/normal/tools/secure/AESEncrypt.class */
public class AESEncrypt {
    public static final String ALGORITHM = "AES";
    private static final String SHA1PRNG = "SHA1PRNG";
    private String ivParameter;

    public AESEncrypt() {
        this.ivParameter = "ItdzfwvGcrpuLlwz";
    }

    public AESEncrypt(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            WLogger.e("AESEncrypt", "ivParameter is null!use default");
            str2 = "ItdzfwvGcrpuLlwz";
        }
        this.ivParameter = str2;
    }

    public static String generateKey() {
        try {
            String randomNumeric = SecureRandomStringUtils.randomNumeric(10);
            String randomAlphabetic = SecureRandomStringUtils.randomAlphabetic(6);
            int randomNum = SecureRandomStringUtils.randomNum(6);
            return randomAlphabetic.substring(0, randomNum) + randomNumeric + randomAlphabetic.substring(randomNum);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
        cipher.init(2, secretKeySpec, new IvParameterSpec(this.ivParameter.getBytes()));
        return cipher.doFinal(bArr);
    }

    public byte[] encrypt(String str, String str2, byte[] bArr) throws Exception {
        Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
        cipher.init(1, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(this.ivParameter.getBytes()));
        return cipher.doFinal(str.getBytes(str2));
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
        cipher.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(this.ivParameter.getBytes()));
        return cipher.doFinal(bArr);
    }

    public String getIvParameter() {
        return this.ivParameter;
    }

    public void setIvParameter(String str) {
        this.ivParameter = str;
    }
}
