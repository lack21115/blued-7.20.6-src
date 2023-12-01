package com.uc.crashsdk.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f26868a = {126, 147, 115, 241, 101, 198, 215, 134};
    private static final int[] b = {125, 185, 233, 226, 129, 142, 151, 176};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f26869c = {238, 185, 233, 179, 129, 142, 151, 167};

    public static String a(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[(int) file.length()];
                fileInputStream.read(bArr);
                g.a(fileInputStream);
                byte[] a2 = a(bArr, f26868a);
                if (a2 == null || a2.length <= 0) {
                    g.a((Closeable) null);
                    return null;
                }
                int length = a2.length - 1;
                String str2 = a2[length] == 10 ? new String(a2, 0, length) : new String(a2);
                g.a((Closeable) null);
                return str2;
            } catch (Exception e) {
                e = e;
                try {
                    g.a(e);
                    g.a(fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    g.a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                g.a(fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
        }
    }

    public static String a(String str, String str2, boolean z) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z2;
        byte[] bArr;
        String str3;
        boolean z3;
        String str4;
        boolean z4;
        boolean z5;
        if (z && !g.a(str)) {
            File file = new File(str);
            if (file.exists()) {
                if (file.length() > 3145728) {
                    return str;
                }
                byte[] e = g.e(file);
                if (e != null) {
                    if (e.length <= 0) {
                        return str;
                    }
                    if (z) {
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                                try {
                                    gZIPOutputStream.write(e);
                                    byteArrayOutputStream.flush();
                                } catch (Throwable th) {
                                    th = th;
                                    try {
                                        g.a(th);
                                        g.a(byteArrayOutputStream);
                                        g.a(gZIPOutputStream);
                                        bArr = byteArrayOutputStream.toByteArray();
                                        z2 = true;
                                        if (z2) {
                                        }
                                        return str;
                                    } catch (Throwable th2) {
                                        g.a(byteArrayOutputStream);
                                        g.a(gZIPOutputStream);
                                        throw th2;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                gZIPOutputStream = null;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            gZIPOutputStream = null;
                            byteArrayOutputStream = null;
                        }
                        g.a(byteArrayOutputStream);
                        g.a(gZIPOutputStream);
                        try {
                            bArr = byteArrayOutputStream.toByteArray();
                            z2 = true;
                        } catch (Throwable th5) {
                            g.a(th5);
                            z2 = false;
                            bArr = e;
                        }
                        if (z2 || bArr == null) {
                            return str;
                        }
                        if (bArr.length <= 0) {
                            return str;
                        }
                        str3 = str + str2;
                        z3 = true;
                    } else {
                        str3 = str;
                        z3 = false;
                        bArr = e;
                    }
                    if (z3) {
                        if (str3.equals(file.getName())) {
                            str4 = str3 + ".tmp";
                            z4 = true;
                        } else {
                            str4 = str3;
                            z4 = false;
                        }
                        File file2 = new File(str4);
                        if (g.a(file2, bArr)) {
                            z5 = true;
                            if (z4) {
                                file.delete();
                                file2.renameTo(file);
                                z5 = true;
                            }
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            return str3;
                        }
                    }
                }
            }
            return str;
        }
        return str;
    }

    public static boolean a(String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            g.a(th);
            fileOutputStream = null;
        }
        boolean z = false;
        if (fileOutputStream == null) {
            return false;
        }
        byte[] b2 = b(str2.getBytes(), f26868a);
        if (b2 == null) {
            g.a(fileOutputStream);
            return false;
        }
        try {
            fileOutputStream.write(b2);
            z = true;
        } finally {
            try {
                g.a(fileOutputStream);
                return z;
            } catch (Throwable th2) {
            }
        }
        g.a(fileOutputStream);
        return z;
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        if (bArr.length - 0 < 2 || iArr == null || iArr.length != 8) {
            return null;
        }
        int length = (bArr.length - 2) - 0;
        try {
            byte[] bArr2 = new byte[length];
            byte b2 = 0;
            for (int i = 0; i < length; i++) {
                byte b3 = (byte) (bArr[i + 0] ^ iArr[i % 8]);
                bArr2[i] = b3;
                b2 = (byte) (b2 ^ b3);
            }
            if (bArr[length + 0] == ((byte) ((iArr[0] ^ b2) & 255)) && bArr[length + 1 + 0] == ((byte) ((iArr[1] ^ b2) & 255))) {
                return bArr2;
            }
            return null;
        } catch (Exception e) {
            g.a(e);
            return null;
        }
    }

    private static byte[] b(byte[] bArr, int[] iArr) {
        if (bArr == null || iArr == null || iArr.length != 8) {
            return null;
        }
        int length = bArr.length;
        try {
            byte[] bArr2 = new byte[length + 2];
            byte b2 = 0;
            for (int i = 0; i < length; i++) {
                byte b3 = bArr[i];
                bArr2[i] = (byte) (iArr[i % 8] ^ b3);
                b2 = (byte) (b2 ^ b3);
            }
            bArr2[length] = (byte) (iArr[0] ^ b2);
            bArr2[length + 1] = (byte) (iArr[1] ^ b2);
            return bArr2;
        } catch (Exception e) {
            g.a(e);
            return null;
        }
    }
}
