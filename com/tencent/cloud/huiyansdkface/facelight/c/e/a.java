package com.tencent.cloud.huiyansdkface.facelight.c.e;

import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.SecureRandomStringUtils;
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

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/e/a.class */
public abstract class a {
    public static String a() {
        try {
            String randomNumeric = SecureRandomStringUtils.randomNumeric(10);
            String randomAlphabetic = SecureRandomStringUtils.randomAlphabetic(6);
            int randomNum = SecureRandomStringUtils.randomNum(6);
            return randomAlphabetic.substring(0, randomNum) + randomNumeric + randomAlphabetic.substring(randomNum);
        } catch (Exception e) {
            e.printStackTrace();
            WLogger.w("AESEncryptUtil", "generateKey failed!" + e.toString());
            KycWaSDK kycWaSDK = KycWaSDK.getInstance();
            kycWaSDK.trackCustomKVEvent(null, "faceservice_generate_key_fail", "generateKey failed!" + e.toString(), null);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
        cipher.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec("ItdzfwvGcrpuLlwz".getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
        cipher.init(2, secretKeySpec, new IvParameterSpec("ItdzfwvGcrpuLlwz".getBytes()));
        return cipher.doFinal(bArr);
    }
}
