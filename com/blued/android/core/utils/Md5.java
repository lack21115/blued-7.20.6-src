package com.blued.android.core.utils;

import com.anythink.core.common.k.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/Md5.class */
public final class Md5 {
    protected static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(File file) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(f.a);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] a2 = ByteArrayPool.a.a(1024);
            while (true) {
                int read = fileInputStream.read(a2);
                if (read <= 0) {
                    fileInputStream.close();
                    ByteArrayPool.a.a(a2);
                    return b(messageDigest.digest());
                }
                messageDigest.update(a2, 0, read);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        if (str != null) {
            try {
                return a(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static String a(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return null;
        }
        try {
            return a(str.getBytes("UTF-8"), bArr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(byte[] bArr) {
        String sb;
        synchronized (Md5.class) {
            try {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(f.a);
                    messageDigest.update(bArr);
                    byte[] digest = messageDigest.digest();
                    StringBuilder sb2 = new StringBuilder();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < digest.length) {
                            sb2.append(Integer.toHexString((digest[i2] & 255) | (-256)).substring(6));
                            i = i2 + 1;
                        } else {
                            sb = sb2.toString();
                        }
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb;
    }

    private static String a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i2 + i) {
                return stringBuffer.toString();
            }
            a(bArr[i4], stringBuffer);
            i3 = i4 + 1;
        }
    }

    private static String a(byte[] bArr, byte[] bArr2) {
        String sb;
        synchronized (Md5.class) {
            try {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(f.a);
                    messageDigest.update(bArr);
                    messageDigest.update(bArr2);
                    byte[] digest = messageDigest.digest();
                    StringBuilder sb2 = new StringBuilder();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < digest.length) {
                            sb2.append(Integer.toHexString((digest[i2] & 255) | (-256)).substring(6));
                            i = i2 + 1;
                        } else {
                            sb = sb2.toString();
                        }
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb;
    }

    private static void a(byte b, StringBuffer stringBuffer) {
        char[] cArr = a;
        char c = cArr[(b & 240) >> 4];
        char c2 = cArr[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }

    private static String b(byte[] bArr) {
        Log.b("Md5", "bytes.length = " + bArr.length);
        return a(bArr, 0, bArr.length);
    }
}
