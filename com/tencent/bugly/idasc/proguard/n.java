package com.tencent.bugly.idasc.proguard;

import java.nio.ByteBuffer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/n.class */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f21635a;
    private static final byte[] b;

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 256) {
                f21635a = bArr2;
                b = bArr3;
                return;
            }
            bArr2[i2] = bArr[i2 >>> 4];
            bArr3[i2] = bArr[i2 & 15];
            i = i2 + 1;
        }
    }

    public static boolean a(int i, int i2) {
        return i == i2;
    }

    public static boolean a(long j, long j2) {
        return j == j2;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static boolean a(boolean z, boolean z2) {
        return z == z2;
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, position);
        return bArr;
    }
}
