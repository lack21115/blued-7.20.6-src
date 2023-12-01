package com.tencent.tmsqmsp.sdk.f;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/f/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f39756a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

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
                char[] cArr2 = f39756a;
                cArr[i3 + 1] = cArr2[b & 15];
                cArr[i3 + 0] = cArr2[((byte) (b >>> 4)) & 15];
                i = i2 + 1;
            } catch (Exception e) {
                g.a("Qp.b2h", 1, " === bytes2HexStr error === " + e.toString());
                return null;
            }
        }
    }
}
