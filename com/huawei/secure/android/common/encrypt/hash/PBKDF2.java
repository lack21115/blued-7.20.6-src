package com.huawei.secure.android.common.encrypt.hash;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/encrypt/hash/PBKDF2.class */
public abstract class PBKDF2 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9461a = "PBKDF2";
    private static final String b = "PBKDF2WithHmacSHA1";

    /* renamed from: c  reason: collision with root package name */
    private static final String f9462c = "PBKDF2WithHmacSHA256";
    private static final String d = "";
    private static final int e = 8;
    private static final int f = 16;
    private static final int g = 32;
    private static final int h = 10000;
    private static final int i = 1000;

    private static boolean a(byte[] bArr, byte[] bArr2) {
        boolean z = false;
        if (bArr != null) {
            if (bArr2 == null) {
                return false;
            }
            int length = bArr.length ^ bArr2.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= bArr.length || i3 >= bArr2.length) {
                    break;
                }
                length |= bArr[i3] ^ bArr2[i3];
                i2 = i3 + 1;
            }
            z = false;
            if (length == 0) {
                z = true;
            }
        }
        return z;
    }

    private static byte[] a(char[] cArr, byte[] bArr, int i2, int i3, boolean z) {
        try {
            return (z ? SecretKeyFactory.getInstance(f9462c) : SecretKeyFactory.getInstance(b)).generateSecret(new PBEKeySpec(cArr, bArr, i2, i3)).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
            String str = f9461a;
            b.b(str, "pbkdf exception : " + e2.getMessage());
            return new byte[0];
        }
    }

    public static byte[] pbkdf2(char[] cArr, byte[] bArr, int i2, int i3) {
        return a(cArr, bArr, i2, i3, false);
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str) {
        return pbkdf2Encrypt(str, 10000);
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str, int i2) {
        return pbkdf2Encrypt(str, EncryptUtil.generateSecureRandom(8), i2, 32);
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str, byte[] bArr, int i2, int i3) {
        if (TextUtils.isEmpty(str)) {
            b.b(f9461a, "pwd is null.");
            return "";
        } else if (i2 < 1000) {
            b.b(f9461a, "iterations times is not enough.");
            return "";
        } else if (bArr == null || bArr.length < 8) {
            b.b(f9461a, "salt parameter is null or length is not enough");
            return "";
        } else if (i3 < 32) {
            b.b(f9461a, "cipherLen length is not enough");
            return "";
        } else {
            byte[] pbkdf2 = pbkdf2(str.toCharArray(), bArr, i2, i3 * 8);
            return HexUtil.byteArray2HexStr(bArr) + HexUtil.byteArray2HexStr(pbkdf2);
        }
    }

    public static String pbkdf2EncryptNew(String str) {
        return pbkdf2EncryptNew(str, 10000);
    }

    public static String pbkdf2EncryptNew(String str, int i2) {
        return pbkdf2EncryptNew(str, EncryptUtil.generateSecureRandom(16), i2, 32);
    }

    public static String pbkdf2EncryptNew(String str, byte[] bArr, int i2, int i3) {
        byte[] pbkdf2SHA256;
        if (TextUtils.isEmpty(str)) {
            b.b(f9461a, "pwd is null.");
            return "";
        } else if (i2 < 1000) {
            b.b(f9461a, "iterations times is not enough.");
            return "";
        } else if (bArr == null || bArr.length < 16) {
            b.b(f9461a, "salt parameter is null or length is not enough");
            return "";
        } else if (i3 < 32) {
            b.b(f9461a, "cipherLen length is not enough");
            return "";
        } else {
            if (Build.VERSION.SDK_INT < 26) {
                b.c(f9461a, "sha 1");
                pbkdf2SHA256 = pbkdf2(str.toCharArray(), bArr, i2, i3 * 8);
            } else {
                b.c(f9461a, "sha 256");
                pbkdf2SHA256 = pbkdf2SHA256(str.toCharArray(), bArr, i2, i3 * 8);
            }
            return HexUtil.byteArray2HexStr(bArr) + HexUtil.byteArray2HexStr(pbkdf2SHA256);
        }
    }

    public static byte[] pbkdf2SHA256(char[] cArr, byte[] bArr, int i2, int i3) {
        if (Build.VERSION.SDK_INT < 26) {
            b.b(f9461a, "system version not high than 26");
            return new byte[0];
        }
        return a(cArr, bArr, i2, i3, true);
    }

    @Deprecated
    public static boolean validatePassword(String str, String str2) {
        return validatePassword(str, str2, 10000);
    }

    @Deprecated
    public static boolean validatePassword(String str, String str2, int i2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 16) {
            return false;
        }
        return a(pbkdf2(str.toCharArray(), HexUtil.hexStr2ByteArray(str2.substring(0, 16)), i2, 256), HexUtil.hexStr2ByteArray(str2.substring(16)));
    }

    public static boolean validatePasswordNew(String str, String str2) {
        return validatePasswordNew(str, str2, 10000);
    }

    public static boolean validatePasswordNew(String str, String str2, int i2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 32) {
            return false;
        }
        String substring = str2.substring(0, 32);
        return a(Build.VERSION.SDK_INT < 26 ? pbkdf2(str.toCharArray(), HexUtil.hexStr2ByteArray(substring), i2, 256) : pbkdf2SHA256(str.toCharArray(), HexUtil.hexStr2ByteArray(substring), i2, 256), HexUtil.hexStr2ByteArray(str2.substring(32)));
    }
}
