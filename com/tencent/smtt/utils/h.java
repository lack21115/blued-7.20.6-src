package com.tencent.smtt.utils;

import com.huawei.hms.framework.common.ExceptionCode;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f38961a = "0123456789abcdef".toCharArray();
    private static h b;

    /* renamed from: c  reason: collision with root package name */
    private String f38962c;
    private String d;
    private String e;

    private h() {
        int nextInt = new Random().nextInt(89999999);
        int nextInt2 = new Random().nextInt(89999999);
        this.e = String.valueOf(nextInt + ExceptionCode.CRASH_EXCEPTION);
        this.f38962c = this.e + String.valueOf(nextInt2 + ExceptionCode.CRASH_EXCEPTION);
    }

    public static h a() {
        h hVar;
        synchronized (h.class) {
            try {
                if (b == null) {
                    b = new h();
                }
                hVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    private String b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return new String(cArr);
            }
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = f38961a;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
            i = i2 + 1;
        }
    }

    public byte[] a(byte[] bArr) throws Exception {
        return com.tencent.smtt.sdk.stat.a.a(this.e.getBytes(), bArr, 1);
    }

    public void b() throws Exception {
        Security.addProvider((Provider) Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
    }

    public String c() throws Exception {
        if (this.d == null) {
            byte[] bytes = this.f38962c.getBytes();
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            } catch (Exception e) {
                try {
                    b();
                    cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(android.util.Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
            this.d = b(cipher.doFinal(bytes));
        }
        return this.d;
    }
}
