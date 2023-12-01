package com.huawei.secure.android.common.util;

import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/util/EncryptUtil.class */
public class EncryptUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9531a = "EncryptUtil";
    private static final String b = "RSA";

    /* JADX WARN: Removed duplicated region for block: B:25:0x0023 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] generateSecureRandom(int r3) {
        /*
            r0 = r3
            byte[] r0 = new byte[r0]
            r6 = r0
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.security.NoSuchAlgorithmException -> L64
            r1 = 26
            if (r0 < r1) goto L1b
            java.security.SecureRandom r0 = java.security.SecureRandom.getInstanceStrong()     // Catch: java.security.NoSuchAlgorithmException -> L64
            r4 = r0
            goto L1d
        L13:
            java.lang.String r0 = com.huawei.secure.android.common.util.EncryptUtil.f9531a
            java.lang.String r1 = "getSecureRandomBytes: NoSuchAlgorithmException"
            com.huawei.secure.android.common.util.LogsUtil.e(r0, r1)
        L1b:
            r0 = 0
            r4 = r0
        L1d:
            r0 = r4
            r5 = r0
            r0 = r4
            if (r0 != 0) goto L29
            java.lang.String r0 = "SHA1PRNG"
            java.security.SecureRandom r0 = java.security.SecureRandom.getInstance(r0)     // Catch: java.lang.Exception -> L30 java.security.NoSuchAlgorithmException -> L68
            r5 = r0
        L29:
            r0 = r5
            r1 = r6
            r0.nextBytes(r1)     // Catch: java.lang.Exception -> L30 java.security.NoSuchAlgorithmException -> L68
            r0 = r6
            return r0
        L30:
            r4 = move-exception
            java.lang.String r0 = com.huawei.secure.android.common.util.EncryptUtil.f9531a
            r5 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            java.lang.String r1 = "getSecureRandomBytes getInstance: exception : "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r1 = r4
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r6
            java.lang.String r1 = r1.toString()
            com.huawei.secure.android.common.util.LogsUtil.e(r0, r1)
            goto L60
        L58:
            java.lang.String r0 = com.huawei.secure.android.common.util.EncryptUtil.f9531a
            java.lang.String r1 = "getSecureRandomBytes getInstance: NoSuchAlgorithmException"
            com.huawei.secure.android.common.util.LogsUtil.e(r0, r1)
        L60:
            r0 = 0
            byte[] r0 = new byte[r0]
            return r0
        L64:
            r4 = move-exception
            goto L13
        L68:
            r4 = move-exception
            goto L58
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.EncryptUtil.generateSecureRandom(int):byte[]");
    }

    @Deprecated
    public static String generateSecureRandomStr(int i) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i));
    }

    @Deprecated
    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance(b).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                String str2 = f9531a;
                LogsUtil.e(str2, "load Key Exception:" + e.getMessage(), true);
                return null;
            }
        } catch (IllegalArgumentException e2) {
            LogsUtil.e(f9531a, "base64 decode IllegalArgumentException", true);
            return null;
        } catch (Exception e3) {
            LogsUtil.e(f9531a, "base64 decode Exception", true);
            return null;
        }
    }

    @Deprecated
    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(b).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                String str2 = f9531a;
                LogsUtil.e(str2, "load Key Exception:" + e.getMessage(), true);
                return null;
            }
        } catch (IllegalArgumentException e2) {
            LogsUtil.e(f9531a, "base64 decode IllegalArgumentException", true);
            return null;
        } catch (Exception e3) {
            LogsUtil.e(f9531a, "base64 decode Exception", true);
            return null;
        }
    }
}
