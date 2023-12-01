package com.tencent.qmsp.sdk.f;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/f/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f24912a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= bArr.length) {
                    return new String(cArr);
                }
                byte b = bArr[i2];
                int i3 = i2 * 2;
                cArr[i3 + 1] = f24912a[b & 15];
                cArr[i3 + 0] = f24912a[((byte) (b >>> 4)) & 15];
                i = i2 + 1;
            } catch (Exception e) {
                g.a("Qp.b2h", 1, " === bytes2HexStr error === " + e.toString());
                return null;
            }
        }
    }
}
