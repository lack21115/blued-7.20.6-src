package com.tencent.smtt.utils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/ByteUtils.class */
public class ByteUtils {
    public static void Word2Byte(byte[] bArr, int i, short s) {
        bArr[i] = (byte) (s >> 8);
        bArr[i + 1] = (byte) s;
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return stringBuffer.toString();
            }
            if ((bArr[i2] & 255) < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Long.toString(bArr[i2] & 255, 16));
            i = i2 + 1;
        }
    }

    public static byte[] subByte(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        if (i < 0 || i + i2 > length) {
            return null;
        }
        int i3 = i2;
        if (i2 < 0) {
            i3 = bArr.length - i;
        }
        byte[] bArr2 = new byte[i3];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i3) {
                return bArr2;
            }
            bArr2[i5] = bArr[i5 + i];
            i4 = i5 + 1;
        }
    }
}
