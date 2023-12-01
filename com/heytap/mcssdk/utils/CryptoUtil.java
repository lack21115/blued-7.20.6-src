package com.heytap.mcssdk.utils;

import android.text.TextUtils;
import com.heytap.mcssdk.base.Base64;
import com.heytap.msp.push.encrypt.AESEncrypt;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/utils/CryptoUtil.class */
public class CryptoUtil {
    public static String DES_KEY = "";
    public static final String DES_KEY_BASE64 = "Y29tLm5lYXJtZS5tY3M=";
    public static String mDecryptTag;

    public static String aesDecrypt(String str) {
        boolean z;
        String str2 = "";
        String str3 = str2;
        if (!TextUtils.isEmpty(str)) {
            try {
                String decrypt = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
                str2 = decrypt;
                LogUtil.d("sdkDecrypt aesDecrypt aes data ".concat(String.valueOf(decrypt)));
                z = true;
                str2 = decrypt;
            } catch (Exception e) {
                LogUtil.d("sdkDecrypt AES excepiton " + e.toString());
                z = false;
            }
            if (TextUtils.isEmpty(str2)) {
                z = false;
            }
            str3 = str2;
            if (!z) {
                try {
                    String decrypt2 = DESUtil.decrypt(str, getDesKey());
                    mDecryptTag = "DES";
                    SharedPreferenceManager.getInstance().saveDecryptTag(mDecryptTag);
                    str2 = decrypt2;
                    LogUtil.d("sdkDecrypt aesDecrypt des data ".concat(String.valueOf(decrypt2)));
                    return decrypt2;
                } catch (Exception e2) {
                    LogUtil.d("sdkDecrypt DES excepiton " + e2.toString());
                    str3 = str2;
                }
            }
        }
        return str3;
    }

    public static String desDecrypt(String str) {
        boolean z;
        String str2 = "";
        String str3 = str2;
        if (!TextUtils.isEmpty(str)) {
            try {
                String decrypt = DESUtil.decrypt(str, getDesKey());
                str2 = decrypt;
                LogUtil.d("sdkDecrypt desDecrypt des data ".concat(String.valueOf(decrypt)));
                z = true;
                str2 = decrypt;
            } catch (Exception e) {
                LogUtil.d("sdkDecrypt DES excepiton " + e.toString());
                z = false;
            }
            if (TextUtils.isEmpty(str2)) {
                z = false;
            }
            str3 = str2;
            if (!z) {
                try {
                    String decrypt2 = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
                    mDecryptTag = "AES";
                    SharedPreferenceManager.getInstance().saveDecryptTag(mDecryptTag);
                    str2 = decrypt2;
                    LogUtil.d("sdkDecrypt desDecrypt aes data ".concat(String.valueOf(decrypt2)));
                    return decrypt2;
                } catch (Exception e2) {
                    LogUtil.d("sdkDecrypt AES excepiton " + e2.toString());
                    str3 = str2;
                }
            }
        }
        return str3;
    }

    private static String getDesKey() {
        if (TextUtils.isEmpty(DES_KEY)) {
            DES_KEY = new String(Base64.decodeBase64(DES_KEY_BASE64));
        }
        byte[] swapBytes = swapBytes(getUTF8Bytes(DES_KEY));
        return swapBytes != null ? new String(swapBytes, Charset.forName("UTF-8")) : "";
    }

    public static byte[] getUTF8Bytes(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new byte[0];
        }
    }

    public static String sdkDecrypt(String str) {
        LogUtil.d("sdkDecrypt start data ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(mDecryptTag)) {
            mDecryptTag = SharedPreferenceManager.getInstance().getDecryptTag();
        }
        if ("DES".equals(mDecryptTag)) {
            LogUtil.d("sdkDecrypt start DES");
            return desDecrypt(str);
        }
        LogUtil.d("sdkDecrypt start AES");
        return aesDecrypt(str);
    }

    public static byte[] swapBytes(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            byte b = bArr[i2];
            int i3 = i2 + 1;
            bArr[i2] = bArr[i3];
            bArr[i3] = b;
            i = i2 + 2;
        }
    }
}
