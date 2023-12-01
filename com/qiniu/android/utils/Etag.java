package com.qiniu.android.utils;

import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/Etag.class */
public final class Etag {
    public static String data(byte[] bArr) {
        return data(bArr, 0, bArr.length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String data(byte[] r6, int r7, int r8) {
        /*
            r0 = 0
            r12 = r0
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L3a
            r1 = r0
            r2 = r6
            r3 = r7
            r4 = r8
            r1.<init>(r2, r3, r4)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L3a
            r11 = r0
            r0 = r8
            long r0 = (long) r0
            r9 = r0
            r0 = r11
            r6 = r0
            r0 = r11
            r1 = r9
            java.lang.String r0 = stream(r0, r1)     // Catch: java.io.IOException -> L2d java.lang.Throwable -> L5a
            r12 = r0
            r0 = r11
            r0.close()     // Catch: java.lang.Exception -> L25
            r0 = r12
            return r0
        L25:
            r6 = move-exception
            r0 = r6
            r0.printStackTrace()
            r0 = r12
            return r0
        L2d:
            r12 = move-exception
            goto L3f
        L32:
            r6 = move-exception
            r0 = r12
            r11 = r0
            goto L62
        L3a:
            r12 = move-exception
            r0 = 0
            r11 = r0
        L3f:
            r0 = r11
            r6 = r0
            r0 = r12
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L5a
            r0 = r11
            if (r0 == 0) goto L58
            r0 = r11
            r0.close()     // Catch: java.lang.Exception -> L53
            r0 = 0
            return r0
        L53:
            r6 = move-exception
            r0 = r6
            r0.printStackTrace()
        L58:
            r0 = 0
            return r0
        L5a:
            r12 = move-exception
            r0 = r6
            r11 = r0
            r0 = r12
            r6 = r0
        L62:
            r0 = r11
            if (r0 == 0) goto L76
            r0 = r11
            r0.close()     // Catch: java.lang.Exception -> L6f
            goto L76
        L6f:
            r11 = move-exception
            r0 = r11
            r0.printStackTrace()
        L76:
            r0 = r6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.utils.Etag.data(byte[], int, int):java.lang.String");
    }

    public static String file(File file) throws IOException {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            String stream = stream(fileInputStream, file.length());
            try {
                fileInputStream.close();
                return stream;
            } catch (Exception e) {
                e.printStackTrace();
                return stream;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String file(String str) throws IOException {
        return file(new File(str));
    }

    private static byte[] oneBlock(byte[] bArr, InputStream inputStream, int i) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha-1");
            int length = bArr.length;
            while (i != 0) {
                int i2 = length > i ? i : length;
                inputStream.read(bArr, 0, i2);
                messageDigest.update(bArr, 0, i2);
                i -= i2;
            }
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String resultEncode(byte[][] bArr) {
        byte[] bArr2;
        byte b;
        byte[] bArr3 = bArr[0];
        int length = bArr3.length;
        byte[] bArr4 = new byte[length + 1];
        if (bArr.length != 1) {
            b = -106;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("sha-1");
                int length2 = bArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length2) {
                        break;
                    }
                    messageDigest.update(bArr[i2]);
                    i = i2 + 1;
                }
                bArr2 = messageDigest.digest();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            bArr2 = bArr3;
            b = 22;
        }
        bArr4[0] = b;
        System.arraycopy(bArr2, 0, bArr4, 1, length);
        return UrlSafeBase64.encodeToString(bArr4);
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [byte[], byte[][]] */
    public static String stream(InputStream inputStream, long j) throws IOException {
        if (j == 0) {
            return "Fto5o-5ea0sNMlW_75VgGJCv2AcJ";
        }
        byte[] bArr = new byte[65536];
        int i = (int) (((j + STMobileHumanActionNative.ST_MOBILE_HAND_666) - 1) / STMobileHumanActionNative.ST_MOBILE_HAND_666);
        ?? r0 = new byte[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return resultEncode(r0);
            }
            long j2 = j - (i3 * STMobileHumanActionNative.ST_MOBILE_HAND_666);
            long j3 = j2;
            if (j2 > STMobileHumanActionNative.ST_MOBILE_HAND_666) {
                j3 = 4194304;
            }
            r0[i3] = oneBlock(bArr, inputStream, (int) j3);
            i2 = i3 + 1;
        }
    }
}
