package com.tencent.turingface.sdk.mfa;

import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/fi6GY.class */
public final class fi6GY {
    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 256) {
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

    public static byte[] a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, position);
        return bArr;
    }
}
