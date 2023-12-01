package c.t.m.g;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/s6.class */
public class s6 {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f3937a = new byte[0];

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

    public static byte[] a(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0) {
            return f3937a;
        }
        byte[] a2 = v2.a(r2.a(bArr), str);
        if (a2 == null || a2.length == 0) {
            return f3937a;
        }
        byte[] bArr2 = new byte[a2.length + 2];
        System.arraycopy(a(a2.length), 0, bArr2, 0, 2);
        System.arraycopy(a2, 0, bArr2, 2, a2.length);
        return bArr2;
    }
}
