package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/e.class */
public class e {
    static {
        Charset.forName("UTF-8");
    }

    public static String a(String str, String str2) {
        try {
            return a(str, str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            z.c("hmsSdk", "Unsupported encoding exception,utf-8");
            return "";
        }
    }

    public static String a(String str, byte[] bArr) {
        String str2;
        if (bArr == null || bArr.length == 0) {
            z.f("hmsSdk", "encrypt: content is empty or null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(a(bArr, a(HexUtil.hexStr2ByteArray(str))));
        } catch (NoSuchAlgorithmException e) {
            str2 = "encrypt(): getInstance - No such algorithm,transformation";
            z.f("hmsSdk", str2);
            return "";
        } catch (InvalidKeySpecException e2) {
            str2 = "encrypt(): Invalid key specification";
            z.f("hmsSdk", str2);
            return "";
        }
    }

    public static PublicKey a(byte[] bArr) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static byte[] a(byte[] bArr, PublicKey publicKey) {
        String str;
        try {
            if (publicKey != null) {
                Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
                cipher.init(1, publicKey);
                return cipher.doFinal(bArr);
            }
            throw new UnsupportedEncodingException("The loaded public key is null");
        } catch (UnsupportedEncodingException e) {
            str = "rsaEncrypt(): getBytes - Unsupported coding format!";
            z.f("hmsSdk", str);
            return new byte[0];
        } catch (InvalidKeyException e2) {
            str = "rsaEncrypt(): init - Invalid key!";
            z.f("hmsSdk", str);
            return new byte[0];
        } catch (NoSuchAlgorithmException e3) {
            str = "rsaEncrypt(): getInstance - No such algorithm,transformation";
            z.f("hmsSdk", str);
            return new byte[0];
        } catch (BadPaddingException e4) {
            str = "rsaEncrypt():False filling parameters!";
            z.f("hmsSdk", str);
            return new byte[0];
        } catch (IllegalBlockSizeException e5) {
            str = "rsaEncrypt(): doFinal - The provided block is not filled with";
            z.f("hmsSdk", str);
            return new byte[0];
        } catch (NoSuchPaddingException e6) {
            str = "rsaEncrypt():  No such filling parameters ";
            z.f("hmsSdk", str);
            return new byte[0];
        }
    }
}
