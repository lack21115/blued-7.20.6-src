package com.tencent.smtt.utils;

import java.io.InputStream;
import java.security.MessageDigest;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/Md5Utils.class */
public class Md5Utils {
    /* JADX WARN: Removed duplicated region for block: B:63:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getMD5(java.io.File r5) {
        /*
            r0 = 0
            r8 = r0
            java.lang.String r0 = "MD5"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch: java.lang.Throwable -> Lb java.security.NoSuchAlgorithmException -> L1b java.io.FileNotFoundException -> L94 java.io.IOException -> L98
            r7 = r0
            goto L22
        Lb:
            r5 = move-exception
            r0 = r8
            r7 = r0
            goto L60
        L11:
            r0 = 0
            r5 = r0
            goto L72
        L16:
            r0 = 0
            r5 = r0
            goto L83
        L1b:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Lb java.io.FileNotFoundException -> L94 java.io.IOException -> L98
            r0 = 0
            r7 = r0
        L22:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lb java.io.FileNotFoundException -> L94 java.io.IOException -> L98
            r1 = r0
            r2 = r5
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lb java.io.FileNotFoundException -> L94 java.io.IOException -> L98
            r5 = r0
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L5b java.io.FileNotFoundException -> L9c java.io.IOException -> La0
            r8 = r0
        L31:
            r0 = r5
            r1 = r8
            int r0 = r0.read(r1)     // Catch: java.lang.Throwable -> L5b java.io.FileNotFoundException -> L9c java.io.IOException -> La0
            r6 = r0
            r0 = r6
            r1 = -1
            if (r0 == r1) goto L46
            r0 = r7
            r1 = r8
            r2 = 0
            r3 = r6
            r0.update(r1, r2, r3)     // Catch: java.lang.Throwable -> L5b java.io.FileNotFoundException -> L9c java.io.IOException -> La0
            goto L31
        L46:
            r0 = r7
            byte[] r0 = r0.digest()     // Catch: java.lang.Throwable -> L5b java.io.FileNotFoundException -> L9c java.io.IOException -> La0
            java.lang.String r0 = com.tencent.smtt.utils.ByteUtils.a(r0)     // Catch: java.lang.Throwable -> L5b java.io.FileNotFoundException -> L9c java.io.IOException -> La0
            r7 = r0
            r0 = r5
            r0.close()     // Catch: java.io.IOException -> L54
            r0 = r7
            return r0
        L54:
            r5 = move-exception
            r0 = r5
            r0.printStackTrace()
            r0 = r7
            return r0
        L5b:
            r8 = move-exception
            r0 = r5
            r7 = r0
            r0 = r8
            r5 = r0
        L60:
            r0 = r7
            if (r0 == 0) goto L70
            r0 = r7
            r0.close()     // Catch: java.io.IOException -> L6b
            goto L70
        L6b:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
        L70:
            r0 = r5
            throw r0
        L72:
            r0 = r5
            if (r0 == 0) goto L81
            r0 = r5
            r0.close()     // Catch: java.io.IOException -> L7c
            r0 = 0
            return r0
        L7c:
            r5 = move-exception
            r0 = r5
            r0.printStackTrace()
        L81:
            r0 = 0
            return r0
        L83:
            r0 = r5
            if (r0 == 0) goto L92
            r0 = r5
            r0.close()     // Catch: java.io.IOException -> L8d
            r0 = 0
            return r0
        L8d:
            r5 = move-exception
            r0 = r5
            r0.printStackTrace()
        L92:
            r0 = 0
            return r0
        L94:
            r5 = move-exception
            goto L16
        L98:
            r5 = move-exception
            goto L11
        L9c:
            r7 = move-exception
            goto L83
        La0:
            r7 = move-exception
            goto L72
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.Md5Utils.getMD5(java.io.File):java.lang.String");
    }

    public static String getMD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            return ByteUtils.a(messageDigest.digest());
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] getMD5(InputStream inputStream) {
        byte[] bArr = null;
        if (inputStream != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                bArr = null;
                if (messageDigest != null) {
                    byte[] bArr2 = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr2, 0, read);
                    }
                    bArr = messageDigest.digest();
                }
            } catch (Throwable th) {
                return null;
            }
        }
        return bArr;
    }

    public static byte[] getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception e) {
            return null;
        }
    }
}
