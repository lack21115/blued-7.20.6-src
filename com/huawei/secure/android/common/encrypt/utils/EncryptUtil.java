package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;
import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/encrypt/utils/EncryptUtil.class */
public class EncryptUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9479a = "EncryptUtil";
    private static final String b = "RSA";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f9480c = false;
    private static boolean d = true;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.security.SecureRandom a() {
        /*
            Method dump skipped, instructions count: 187
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.utils.EncryptUtil.a():java.security.SecureRandom");
    }

    private static byte[] a(int i) {
        SecureRandom a2 = a();
        if (a2 == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        a2.nextBytes(bArr);
        return bArr;
    }

    public static SecureRandom genSecureRandom() {
        if (f9480c) {
            return a();
        }
        try {
            return Build.VERSION.SDK_INT >= 26 ? SecureRandom.getInstanceStrong() : SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            b.b(f9479a, "genSecureRandom: NoSuchAlgorithmException");
            return null;
        }
    }

    public static byte[] generateSecureRandom(int i) {
        if (f9480c) {
            return a(i);
        }
        byte[] bArr = new byte[i];
        SecureRandom secureRandom = null;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                secureRandom = SecureRandom.getInstanceStrong();
            }
        } catch (NoSuchAlgorithmException e) {
            b.b(f9479a, "getSecureRandomBytes: NoSuchAlgorithmException");
            secureRandom = null;
        }
        SecureRandom secureRandom2 = secureRandom;
        if (secureRandom == null) {
            try {
                secureRandom2 = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException e2) {
                b.b(f9479a, "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
                return new byte[0];
            } catch (Exception e3) {
                b.b(f9479a, "getSecureRandomBytes getInstance: exception : " + e3.getMessage());
                return new byte[0];
            }
        }
        secureRandom2.nextBytes(bArr);
        return bArr;
    }

    public static String generateSecureRandomStr(int i) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i));
    }

    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance(b).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                b.b(f9479a, "load Key Exception:" + e.getMessage());
                return null;
            }
        } catch (IllegalArgumentException e2) {
            b.b(f9479a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e3) {
            b.b(f9479a, "base64 decode Exception" + e3.getMessage());
            return null;
        }
    }

    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(b).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                b.b(f9479a, "load Key Exception:" + e.getMessage());
                return null;
            }
        } catch (IllegalArgumentException e2) {
            b.b(f9479a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e3) {
            b.b(f9479a, "base64 decode Exception" + e3.getMessage());
            return null;
        }
    }

    public static boolean isBouncycastleFlag() {
        return f9480c;
    }

    public static void setBouncycastleFlag(boolean z) {
        b.c(f9479a, "setBouncycastleFlag: " + z);
        f9480c = z;
    }
}
