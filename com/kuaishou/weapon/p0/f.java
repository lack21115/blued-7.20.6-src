package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import com.amap.api.col.p0003sl.iu;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f23833a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", iu.h, "f"};

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    private static String a(byte b) {
        byte b2 = b;
        if (b < 0) {
            b2 = b + 256;
        }
        return f23833a[b2 / 16] + f23833a[b2 % 16];
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        String c2 = c(messageDigest.digest());
                        try {
                            fileInputStream.close();
                            return c2;
                        } catch (Throwable th) {
                            return c2;
                        }
                    }
                    messageDigest.update(bArr, 0, read);
                }
            } catch (Throwable th2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return null;
                    } catch (Throwable th3) {
                        return null;
                    }
                }
                return null;
            }
        } catch (Throwable th4) {
            fileInputStream = null;
        }
    }

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str2 = new String(str);
        } catch (Throwable th) {
            str2 = null;
        }
        try {
            return a(MessageDigest.getInstance("MD5").digest(str2.getBytes()));
        } catch (Throwable th2) {
            return str2;
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return stringBuffer.toString();
            }
            stringBuffer.append(a(bArr[i2]));
            i = i2 + 1;
        }
    }

    public static String b(byte[] bArr) {
        String str = null;
        if (bArr != null) {
            if (bArr.length <= 0) {
                return null;
            }
            try {
                str = a(MessageDigest.getInstance("MD5").digest(bArr));
            } catch (Throwable th) {
                return null;
            }
        }
        return str;
    }

    public static String c(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return new String(cArr2);
            }
            byte b = bArr[i2];
            int i3 = i2 * 2;
            cArr2[i3] = cArr[(b >>> 4) & 15];
            cArr2[i3 + 1] = cArr[b & 15];
            i = i2 + 1;
        }
    }

    public static byte[] d(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr != null) {
            if (bArr.length <= 0) {
                return null;
            }
            try {
                bArr2 = MessageDigest.getInstance("MD5").digest(bArr);
            } catch (Throwable th) {
                return null;
            }
        }
        return bArr2;
    }
}
