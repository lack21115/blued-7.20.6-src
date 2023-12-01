package com.youzan.androidsdk.tool;

import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/AESUtils.class */
public class AESUtils {
    public static String APP_USER_INFO_KEY = "21c3f8be61244eab";
    public static String CIP_INSTANCE = "AES/CBC/PKCS5Padding";
    public static byte[] IV = "0102030405060708".getBytes();

    public static String AESEncrypt(String str, String str2) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(IV);
            Cipher cipher = Cipher.getInstance(CIP_INSTANCE);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encode(cipher.doFinal(bytes));
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String encoder(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!entry.getKey().equals("sign")) {
                sb.append(entry.getValue());
            }
        }
        sb.append(APP_USER_INFO_KEY);
        return Base64.md5(sb.toString());
    }
}
