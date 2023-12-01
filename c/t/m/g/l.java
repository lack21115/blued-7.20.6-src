package c.t.m.g;

import android.util.Base64;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/l.class */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f3870a = new byte[0];

    public static byte[] a(int i) {
        byte[] bArr = new byte[2];
        int i2 = i;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 2) {
                return bArr;
            }
            bArr[i4] = Integer.valueOf(i2 & 255).byteValue();
            i2 >>= 8;
            i3 = i4 + 1;
        }
    }

    public static byte[] a(String str) {
        try {
            return a(str.getBytes("UTF-8"), 4);
        } catch (Throwable th) {
            th.toString();
            return f3870a;
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        byte[] a2 = r2.a(bArr);
        String a3 = v2.a("fc_base");
        m3.a(a3);
        if (i != 1 && i != 2) {
            if (i != 3) {
                if (i == 4) {
                    byte[] a4 = v2.a(a2, a3);
                    if (!m3.a(a4)) {
                        byte[] encode = Base64.encode(a4, 2);
                        if (!m3.a(encode)) {
                            return encode;
                        }
                    }
                    return f3870a;
                }
                return f3870a;
            }
            a2 = v2.a(a2, a3);
        }
        if (m3.a(a2)) {
            return f3870a;
        }
        byte[] bArr2 = new byte[a2.length + 2];
        System.arraycopy((Object) a(a2.length), 0, (Object) bArr2, 0, 2);
        System.arraycopy((Object) a2, 0, (Object) bArr2, 2, a2.length);
        return bArr2;
    }
}
