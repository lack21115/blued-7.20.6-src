package com.igexin.push.f;

import android.text.TextUtils;
import android.util.Base64;
import com.getui.gtc.base.crypt.CryptTools;
import java.security.MessageDigest;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/g.class */
public class g {
    public static String d;
    private static boolean f = false;
    private static int g = 0;
    private static byte[] h;
    private static byte[] i;
    private static final int j = 200;
    private static final String e = g.class.getName();

    /* renamed from: a  reason: collision with root package name */
    public static String f23648a = com.igexin.push.a.k;
    public static String b = com.igexin.push.a.j;

    /* renamed from: c  reason: collision with root package name */
    public static String f23649c = "";

    static {
        d = "";
        try {
            h = h();
            byte[] g2 = g();
            i = g2;
            f = (h == null || g2 == null || b.getBytes() == null) ? false : true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "|load key error = " + th.toString(), new Object[0]);
            f = false;
            d = th.getMessage();
        }
        if (f) {
            com.igexin.c.a.c.a.a(e, "load Encrypt key success ~~~~~~~");
            com.igexin.c.a.c.a.a(e + "|load  Encrypt key success ~~~~~~~", new Object[0]);
            return;
        }
        com.igexin.c.a.c.a.a(e, "load key error ++++++++");
        com.igexin.c.a.c.a.a(e + "|load key error ++++++++", new Object[0]);
        if (TextUtils.isEmpty(d)) {
            d = "value = null, normal error";
        }
    }

    public static String a(String str, byte[] bArr) throws Exception {
        byte[] bytes = str.getBytes();
        byte[] bArr2 = new byte[bytes.length + bArr.length];
        int a2 = com.igexin.c.a.b.g.a(bytes, bArr2, 0, bytes.length);
        if (bArr.length > 0) {
            com.igexin.c.a.b.g.a(bArr, bArr2, a2, bArr.length);
        }
        return Base64.encodeToString(d(bArr2), 2);
    }

    public static boolean a() {
        return f;
    }

    public static byte[] a(com.igexin.push.c.c.a aVar, int i2, int i3) {
        byte[] bArr = new byte[aVar.f23329a + 11];
        com.igexin.c.a.b.g.a(i2, bArr, 0);
        com.igexin.c.a.b.g.a(i3, bArr, 4);
        com.igexin.c.a.b.g.b((short) aVar.f23329a, bArr, 8);
        bArr[10] = aVar.b;
        com.igexin.c.a.b.g.a(aVar.e, bArr, 11, aVar.f23329a);
        return d(bArr);
    }

    public static byte[] a(byte[] bArr) {
        return com.igexin.c.a.a.a.b(bArr, com.igexin.push.core.e.M);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            return CryptTools.encrypt("AES/CFB/NoPadding", new SecretKeySpec(i, "AES"), new IvParameterSpec(bArr2), bArr);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(e, " httpId encrypt  http data  fail ~~~~~~~");
            com.igexin.c.a.c.a.a(e + "| httpId encrypt  http data  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    public static byte[] b() {
        if (f) {
            try {
                byte[] bArr = new byte[h.length];
                System.arraycopy((Object) h, 0, (Object) bArr, 0, h.length);
                return CryptTools.encrypt("RSA/NONE/OAEPWithSHA1AndMGF1Padding", CryptTools.parsePublicKey("RSA", f23648a), bArr);
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
                com.igexin.c.a.c.a.a(e + "| getSocketAESKey  fail ~~~~~~~" + th.getMessage(), new Object[0]);
                return new byte[0];
            }
        }
        return new byte[0];
    }

    public static byte[] b(byte[] bArr) {
        return c(bArr);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            return CryptTools.decrypt("AES/CFB/NoPadding", new SecretKeySpec(i, "AES"), new IvParameterSpec(bArr2), bArr);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(e, " httpId decrypt  http data  fail ~~~~~~~");
            com.igexin.c.a.c.a.a(e + "| httpId decrypt  http data  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    public static byte[] c() {
        return b.getBytes();
    }

    public static byte[] c(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        try {
            return CryptTools.encrypt("AES/CFB/NoPadding", new SecretKeySpec(h, "AES"), new IvParameterSpec(bArr2), bArr);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(e, " sockeId encrypt  http data  fail ~~~~~~~");
            com.igexin.c.a.c.a.a(e + "| sockeId encrypt  http data  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    public static boolean d() {
        try {
            h = h();
            byte[] g2 = g();
            i = g2;
            f = (h == null || g2 == null || b.getBytes() == null) ? false : true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "|load key error = " + th.toString(), new Object[0]);
            f = false;
        }
        if (f) {
            com.igexin.c.a.c.a.a(e, "load key success ~~~~~~~");
            com.igexin.c.a.c.a.a(e + "|load key success ~~~~~~~", new Object[0]);
        } else {
            com.igexin.c.a.c.a.a(e, "load key error ++++++++");
            com.igexin.c.a.c.a.a(e + "|load key error ++++++++", new Object[0]);
        }
        return f;
    }

    private static byte[] d(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            return CryptTools.decrypt("AES/CFB/NoPadding", new SecretKeySpec(h, "AES"), new IvParameterSpec(bArr2), bArr);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "| sockeId encrypt  http data  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    public static int e() {
        int i2 = g;
        g = i2 + 1;
        return i2;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        try {
            byte[] bytes = f23649c.getBytes();
            byte[] bArr3 = new byte[bytes.length];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= bytes.length) {
                    return CryptTools.decrypt("AES/CFB/NoPadding", new SecretKeySpec(c(bArr3), "AES"), new IvParameterSpec(c(bArr2)), bArr);
                }
                bArr3[i3] = (byte) (bytes[(bytes.length - i3) - 1] & 255);
                i2 = i3 + 1;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "| altAesDecSocket  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    public static String f() {
        byte[] j2 = j();
        byte[] bytes = p.b().getBytes();
        byte[] bArr = new byte[bytes.length + j2.length];
        com.igexin.c.a.b.g.a(j2, bArr, com.igexin.c.a.b.g.a(bytes, bArr, 0, bytes.length), j2.length);
        return Base64.encodeToString(bArr, 2);
    }

    private static byte[] f(byte[] bArr, byte[] bArr2) {
        try {
            byte[] bytes = f23649c.getBytes();
            byte[] bArr3 = new byte[bytes.length];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= bytes.length) {
                    return CryptTools.encrypt("AES/CFB/NoPadding", new SecretKeySpec(c(bArr3), "AES"), new IvParameterSpec(c(bArr2)), bArr);
                }
                bArr3[i3] = (byte) (bytes[(bytes.length - i3) - 1] & 255);
                i2 = i3 + 1;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "| altAesEncSocket  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    private static byte[] g() {
        try {
            return CryptTools.generateKey("AES", 128).getEncoded();
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(e, "generate  http key fail ~~~~~~~");
            com.igexin.c.a.c.a.a(e + "|generate  http key fail ~~~~~~~", new Object[0]);
            return null;
        }
    }

    private static byte[] h() {
        try {
            return CryptTools.generateKey("AES", 128).getEncoded();
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(e, "generate  socket key fail ~~~~~~~");
            com.igexin.c.a.c.a.a(e + "|generate  socket key fail ~~~~~~~", new Object[0]);
            return null;
        }
    }

    private static byte[] i() {
        return new byte[0];
    }

    private static byte[] j() {
        try {
            byte[] bArr = new byte[i.length];
            System.arraycopy((Object) i, 0, (Object) bArr, 0, i.length);
            return CryptTools.encrypt("RSA/NONE/OAEPWithSHA1AndMGF1Padding", CryptTools.parsePublicKey("RSA", f23648a), bArr);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a(e + "| getHttpAESKey  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }
}
