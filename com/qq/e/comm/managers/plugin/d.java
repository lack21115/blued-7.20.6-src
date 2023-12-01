package com.qq.e.comm.managers.plugin;

import com.amap.api.col.p0003sl.iu;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/managers/plugin/d.class */
class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f27923a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", iu.h, "f"};

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return stringBuffer.toString();
            }
            byte b = bArr[i2];
            byte b2 = b;
            if (b < 0) {
                b2 = b + 256;
            }
            stringBuffer.append(f27923a[b2 / 16] + f27923a[b2 % 16]);
            i = i2 + 1;
        }
    }
}
