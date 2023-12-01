package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/encrypt/hash/SHA.class */
public final class SHA {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23071a = "SHA";

    /* renamed from: c  reason: collision with root package name */
    private static final String f23072c = "";
    private static final String b = "SHA-256";
    private static final String[] d = {b, "SHA-384", "SHA-512"};

    private SHA() {
    }

    private static boolean a(String str) {
        String[] strArr = d;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (strArr[i2].equals(str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static String sha256Encrypt(String str) {
        return shaEncrypt(str, b);
    }

    public static String shaEncrypt(String str, String str2) {
        byte[] bArr;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f23071a, "content or algorithm is null.");
            return "";
        } else if (!a(str2)) {
            b.b(f23071a, "algorithm is not safe or legal");
            return "";
        } else {
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                bArr = new byte[0];
                b.b(f23071a, "Error in generate SHA UnsupportedEncodingException");
            }
            return HexUtil.byteArray2HexStr(shaEncryptByte(bArr, str2));
        }
    }

    public static byte[] shaEncryptByte(byte[] bArr, String str) {
        if (bArr == null || TextUtils.isEmpty(str)) {
            b.b(f23071a, "content or algorithm is null.");
            return new byte[0];
        } else if (!a(str)) {
            b.b(f23071a, "algorithm is not safe or legal");
            return new byte[0];
        } else {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e) {
                b.b(f23071a, "Error in generate SHA NoSuchAlgorithmException");
                return new byte[0];
            }
        }
    }

    public static boolean validateSHA(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        return str2.equals(shaEncrypt(str, str3));
    }

    public static boolean validateSHA256(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(sha256Encrypt(str));
    }
}
