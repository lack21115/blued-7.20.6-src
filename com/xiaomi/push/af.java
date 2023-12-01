package com.xiaomi.push;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/af.class */
public class af {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f27555a = "0123456789ABCDEF".toCharArray();

    public static String a(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder(i2 * 2);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return sb.toString();
            }
            int i5 = bArr[i + i4] & 255;
            sb.append(f27555a[i5 >> 4]);
            sb.append(f27555a[i5 & 15]);
            i3 = i4 + 1;
        }
    }

    public static boolean a(Context context) {
        return ae.f124a;
    }
}
