package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import com.anythink.core.common.k.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.amap.api.col.3sl.hw  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hw.class */
public final class hw {
    public static String a(String str) {
        FileInputStream fileInputStream;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (!file.isFile() || !file.exists()) {
                return null;
            }
            byte[] bArr = new byte[2048];
            MessageDigest messageDigest = MessageDigest.getInstance(ib.c("ETUQ1"));
            fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        String e = ib.e(messageDigest.digest());
                        try {
                            fileInputStream.close();
                            return e;
                        } catch (IOException e2) {
                            it.a(e2, f.a, "gfm");
                            return e;
                        }
                    }
                    messageDigest.update(bArr, 0, read);
                } catch (Throwable th) {
                    th = th;
                    try {
                        it.a(th, f.a, "gfm");
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return null;
                            } catch (IOException e3) {
                                it.a(e3, f.a, "gfm");
                                return null;
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                it.a(e4, f.a, "gfm");
                            }
                        }
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static String a(byte[] bArr) {
        return ib.e(a(bArr, ib.c("ETUQ1")));
    }

    public static byte[] a(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            it.a(th, f.a, "gmb");
            return null;
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        return ib.e(d(str));
    }

    public static String c(String str) {
        return ib.f(e(str));
    }

    private static byte[] d(String str) {
        try {
            return f(str);
        } catch (Throwable th) {
            it.a(th, f.a, "gmb");
            return new byte[0];
        }
    }

    private static byte[] e(String str) {
        try {
            return f(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] f(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(ib.c("ETUQ1"));
        messageDigest.update(ib.a(str));
        return messageDigest.digest();
    }
}
