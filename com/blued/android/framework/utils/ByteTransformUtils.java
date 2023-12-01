package com.blued.android.framework.utils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/ByteTransformUtils.class */
public class ByteTransformUtils {
    private static byte a(String str, String str2) {
        byte byteValue = (byte) (Byte.decode("0x" + str).byteValue() << 4);
        return (byte) (byteValue | Byte.decode("0x" + str2).byteValue());
    }

    public static String a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        while (i < i2) {
            String hexString = Integer.toHexString(bArr[i] & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
                stringBuffer.append(hexString);
            } else {
                stringBuffer.append(hexString);
            }
            i++;
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static byte[] a(String str) {
        int length = str.length() / 2;
        System.out.println(length);
        byte[] bArr = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            int i3 = i2 * 2;
            int i4 = i3 + 1;
            bArr[i2] = a(str.substring(i3, i4), str.substring(i4, i4 + 1));
            i = i2 + 1;
        }
    }
}
