package com.tencent.qmsp.sdk.f;

import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/f/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f24914a;

    static {
        new HashMap();
        f24914a = new byte[]{6, 120, -74, 67, 37, 123, 99, -11, 32, 48, -93, 65, 60, 58, 122, -8, 49, 117, -95, 83, 111};
    }

    public static String a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return new String(bArr2);
            }
            bArr2[i2] = (byte) (bArr[i2] ^ new byte[]{69, 16, -45, 32, 78, 91, 23, -99, 0, 0, 0, 0, 0, 0, 0, 0}[i2 % 8]);
            i = i2 + 1;
        }
    }
}
