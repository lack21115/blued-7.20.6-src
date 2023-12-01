package com.tencent.smtt.utils;

import com.huawei.hms.framework.common.ExceptionCode;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/g.class */
public class g {
    private static String b = "";

    /* renamed from: c  reason: collision with root package name */
    private static byte[] f38960c;
    private static String g;
    private Cipher d;
    private Cipher e;

    /* renamed from: a  reason: collision with root package name */
    protected static final char[] f38959a = "0123456789abcdef".toCharArray();
    private static g f = null;

    private g() throws Exception {
        this.d = null;
        this.e = null;
        g = String.valueOf(new Random().nextInt(89999999) + ExceptionCode.CRASH_EXCEPTION) + String.valueOf(new Random().nextInt(89999999) + ExceptionCode.CRASH_EXCEPTION) + String.valueOf(new Random().nextInt(89999999) + ExceptionCode.CRASH_EXCEPTION);
        String str = "00000000";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 12) {
                f38960c = (str + g).getBytes();
                this.d = Cipher.getInstance("RSA/ECB/NoPadding");
                this.d.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(android.util.Base64.decode((d() + e()).getBytes(), 0))));
                b = b(this.d.doFinal(f38960c));
                SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(g.getBytes()));
                Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
                this.e = cipher;
                cipher.init(1, generateSecret);
                return;
            }
            str = str + String.valueOf(new Random().nextInt(89999999) + ExceptionCode.CRASH_EXCEPTION);
            i = i2 + 1;
        }
    }

    public static g a() {
        try {
            if (f == null) {
                f = new g();
            }
            return f;
        } catch (Exception e) {
            f = null;
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, String str) throws Exception {
        SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(1, generateSecret);
        return cipher.doFinal(bArr);
    }

    public static String b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return new String(cArr);
            }
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = f38959a;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
            i = i2 + 1;
        }
    }

    public static byte[] b(byte[] bArr, String str) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(2, generateSecret);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c() {
        return g;
    }

    private String d() {
        return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0";
    }

    private String e() {
        return "fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB";
    }

    public byte[] a(byte[] bArr) throws Exception {
        return this.e.doFinal(bArr);
    }

    public String b() {
        return b;
    }

    public byte[] c(byte[] bArr) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(g.getBytes()));
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(2, generateSecret);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            TbsLog.i(e);
            return null;
        }
    }
}
