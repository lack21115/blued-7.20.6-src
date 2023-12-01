package com.igexin.c.a.b;

import android.database.Cursor;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/g.class */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23248a = 512;
    public static final String b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    /* renamed from: c  reason: collision with root package name */
    static final char f23249c = '=';
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;
    public static final int h = 4;
    public static final int i = 5;
    public static final int j = 1;
    public static final int k = 2;
    private static final String l = "IoUtil";
    private static int[] m;

    public static int a(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) ((i2 >> 24) & 255);
        bArr[i3 + 1] = (byte) ((i2 >> 16) & 255);
        bArr[i3 + 2] = (byte) ((i2 >> 8) & 255);
        bArr[i3 + 3] = (byte) (i2 & 255);
        return 4;
    }

    public static int a(long j2, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((j2 >> 56) & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 7] = (byte) (j2 & 255);
        return 8;
    }

    public static int a(byte[] bArr, byte[] bArr2, int i2, int i3) {
        System.arraycopy((Object) bArr, 0, (Object) bArr2, i2, i3);
        return i3;
    }

    private static String a(String str, String str2, String str3) {
        if (str3 == null || str == null || str2 == null) {
            return null;
        }
        if (!str3.contains(str)) {
            return str3;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int indexOf = str3.indexOf(str);
            if (indexOf == -1) {
                sb.append(str3);
                return sb.toString();
            }
            sb.append(str3.substring(0, indexOf));
            sb.append(str2);
            str3 = str3.substring(indexOf + str.length());
        }
    }

    private static String a(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (!strArr[0].equals("")) {
            sb.append(strArr[0]);
            sb.append("://");
        }
        if (!strArr[1].equals("")) {
            sb.append(strArr[1]);
        }
        if (!strArr[2].equals("")) {
            sb.append(':');
            sb.append(strArr[2]);
        }
        if (!strArr[3].equals("")) {
            sb.append(strArr[3]);
            if (!strArr[3].equals(BridgeUtil.SPLIT_MARK)) {
                sb.append('/');
            }
        }
        if (!strArr[4].equals("")) {
            sb.append(strArr[4]);
        }
        if (!strArr[5].equals("")) {
            sb.append('?');
            sb.append(strArr[5]);
        }
        return sb.toString();
    }

    public static short a(byte[] bArr, int i2) {
        return (short) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
    }

    private static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(l, th.toString());
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                com.igexin.c.a.c.a.a(l, e2.toString());
            }
        }
    }

    private static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    private static void a(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
        b bVar = new b(outputStream, i2);
        a(inputStream, bVar);
        bVar.a();
    }

    public static byte[] a(int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 0;
        int i8 = i2;
        do {
            int i9 = i6 | ((i8 & 127) << 24);
            i3 = i8 >>> 7;
            i4 = i7 + 1;
            i5 = i9;
            if (i3 > 0) {
                i5 = (i9 >>> 8) | Integer.MIN_VALUE;
            }
            i6 = i5;
            i7 = i4;
            i8 = i3;
        } while (i3 > 0);
        byte[] bArr = new byte[i4];
        int i10 = 24;
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= i4) {
                return bArr;
            }
            bArr[i12] = (byte) (i5 >>> i10);
            i10 -= 8;
            i11 = i12 + 1;
        }
    }

    public static byte[] a(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2;
        byte[] bArr2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
            gZIPOutputStream = null;
        }
        try {
            gZIPOutputStream2.write(bArr);
            gZIPOutputStream2.finish();
            bArr2 = byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            gZIPOutputStream = gZIPOutputStream2;
            th = th2;
            try {
                com.igexin.c.a.c.a.a(th);
                gZIPOutputStream2 = gZIPOutputStream;
                bArr2 = null;
                a(gZIPOutputStream2);
                a(byteArrayOutputStream);
                return bArr2;
            } catch (Throwable th3) {
                a(gZIPOutputStream);
                a(byteArrayOutputStream);
                throw th3;
            }
        }
        a(gZIPOutputStream2);
        a(byteArrayOutputStream);
        return bArr2;
    }

    public static String[] a(String str) {
        StringBuilder sb = new StringBuilder(str.toLowerCase());
        String[] strArr = new String[6];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 6) {
                break;
            }
            strArr[i3] = "";
            i2 = i3 + 1;
        }
        int indexOf = str.indexOf(":");
        if (indexOf > 0) {
            strArr[0] = str.substring(0, indexOf);
            sb.delete(0, indexOf + 1);
        } else if (indexOf == 0) {
            throw new IllegalArgumentException("url format error - protocol");
        }
        if (sb.length() >= 2 && sb.charAt(0) == '/' && sb.charAt(1) == '/') {
            sb.delete(0, 2);
            int indexOf2 = sb.toString().indexOf(47);
            int i4 = indexOf2;
            if (indexOf2 < 0) {
                i4 = sb.length();
            }
            if (i4 != 0) {
                int lastIndexOf = sb.toString().lastIndexOf(58);
                if (lastIndexOf < 0) {
                    lastIndexOf = i4;
                } else if (lastIndexOf > i4) {
                    throw new IllegalArgumentException("url format error - port");
                } else {
                    strArr[2] = sb.toString().substring(lastIndexOf + 1, i4);
                }
                strArr[1] = sb.toString().substring(0, lastIndexOf);
                sb.delete(0, i4);
            }
        }
        if (sb.length() > 0) {
            String sb2 = sb.toString();
            int lastIndexOf2 = sb2.lastIndexOf(47);
            if (lastIndexOf2 > 0) {
                strArr[3] = sb2.substring(0, lastIndexOf2);
            } else if (lastIndexOf2 == 0) {
                if (sb2.indexOf(63) <= 0) {
                    strArr[3] = sb2;
                    return strArr;
                }
                throw new IllegalArgumentException("url format error - path");
            }
            if (lastIndexOf2 < sb2.length() - 1) {
                String substring = sb2.substring(lastIndexOf2 + 1);
                int indexOf3 = substring.indexOf(63);
                if (indexOf3 < 0) {
                    strArr[4] = substring;
                    return strArr;
                }
                strArr[4] = substring.substring(0, indexOf3);
                strArr[5] = substring.substring(indexOf3 + 1);
                return strArr;
            }
        } else {
            strArr[3] = BridgeUtil.SPLIT_MARK;
        }
        return strArr;
    }

    public static int b(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) ((i2 >> 8) & 255);
        bArr[i3 + 1] = (byte) (i2 & 255);
        return 2;
    }

    public static int b(byte[] bArr, int i2) {
        return (bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8);
    }

    private static void b(InputStream inputStream, OutputStream outputStream) throws IOException {
        a(new a(inputStream), outputStream);
    }

    public static byte[] b(int i2) {
        return new byte[]{(byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
    }

    public static byte[] b(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr2;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = gZIPInputStream.read();
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(read);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            com.igexin.c.a.c.a.a(th);
                            bArr2 = null;
                            a(byteArrayOutputStream);
                            a(gZIPInputStream);
                            a(byteArrayInputStream);
                            return bArr2;
                        } catch (Throwable th2) {
                            a(byteArrayOutputStream);
                            a(gZIPInputStream);
                            a(byteArrayInputStream);
                            throw th2;
                        }
                    }
                }
                bArr2 = byteArrayOutputStream.toByteArray();
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            gZIPInputStream = null;
            byteArrayOutputStream = null;
        }
        a(byteArrayOutputStream);
        a(gZIPInputStream);
        a(byteArrayInputStream);
        return bArr2;
    }

    private static int c(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) i2;
        return 1;
    }

    public static int c(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    public static byte[] c(byte[] bArr) throws RuntimeException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b bVar = new b(byteArrayOutputStream, 0);
            a(byteArrayInputStream, bVar);
            bVar.a();
            a(byteArrayInputStream);
            a(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } finally {
        }
    }

    public static long d(byte[] bArr, int i2) {
        return (bArr[i2 + 7] & 255) | ((bArr[i2] & 255) << 56) | ((bArr[i2 + 1] & 255) << 48) | ((bArr[i2 + 2] & 255) << 40) | ((bArr[i2 + 3] & 255) << 32) | ((bArr[i2 + 4] & 255) << 24) | ((bArr[i2 + 5] & 255) << 16) | ((bArr[i2 + 6] & 255) << 8);
    }

    private static byte[] d(byte[] bArr) throws RuntimeException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a(new a(byteArrayInputStream), byteArrayOutputStream);
            a(byteArrayInputStream);
            a(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } finally {
        }
    }

    private static int e(byte[] bArr, int i2) {
        return bArr[i2] & 255;
    }
}
