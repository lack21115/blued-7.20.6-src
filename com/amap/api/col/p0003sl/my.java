package com.amap.api.col.p0003sl;

import java.text.SimpleDateFormat;

/* renamed from: com.amap.api.col.3sl.my  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/my.class */
public final class my {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleDateFormat f5398a;
    private static String b;

    public static String a(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() < 2) {
                sb.append("0");
            }
            sb.append(hexString);
            if (str.length() > 0 && i2 < bArr.length - 1) {
                sb.append(str);
            }
            i = i2 + 1;
        }
    }

    public static byte[] a(long j) {
        byte[] bArr = new byte[6];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 6) {
                return bArr;
            }
            bArr[i2] = (byte) ((j >> (((6 - i2) - 1) * 8)) & 255);
            i = i2 + 1;
        }
    }
}
