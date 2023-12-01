package com.kwad.sdk.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ad.class */
public final class ad {
    static final char[] aaD = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    public static String W(File file) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        try {
            if (file == null) {
                return null;
            }
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
            } catch (Exception e) {
                e = e;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                file = null;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) file);
                throw th;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        String m = m(messageDigest.digest());
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                        return m;
                    }
                    messageDigest.update(bArr, 0, read);
                }
            } catch (Exception e2) {
                e = e2;
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String eC(String str) {
        return l(str.getBytes());
    }

    public static String eD(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            return toHexString(digest, 0, digest.length);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    public static String l(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int length = digest.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return sb.toString();
                }
                byte b = digest[i2];
                byte b2 = b;
                if (b < 0) {
                    b2 = b + 256;
                }
                if (b2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b2));
                i = i2 + 1;
            }
        } catch (Exception e) {
            return "";
        }
    }

    private static String m(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return stringBuffer.toString();
            }
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i2])));
            i = i2 + 1;
        }
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        ao.checkNotNull(bArr);
        if (i2 + 0 <= bArr.length) {
            int i3 = i2 * 2;
            char[] cArr = new char[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = bArr[i5 + 0] & 255;
                int i7 = i4 + 1;
                char[] cArr2 = aaD;
                cArr[i4] = cArr2[i6 >> 4];
                i4 = i7 + 1;
                cArr[i7] = cArr2[i6 & 15];
            }
            return new String(cArr, 0, i3);
        }
        throw new IndexOutOfBoundsException();
    }
}
