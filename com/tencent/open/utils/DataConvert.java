package com.tencent.open.utils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/utils/DataConvert.class */
public class DataConvert {
    public static byte[] intToBytes2(int i) {
        byte[] bArr = new byte[4];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 4) {
                return bArr;
            }
            bArr[i3] = (byte) (i >> (24 - (i3 * 8)));
            i2 = i3 + 1;
        }
    }

    public static int putBytes2Bytes(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                return bArr.length;
            }
            bArr2[i2 + i4] = bArr[i4];
            i3 = i4 + 1;
        }
    }

    public static int putBytes2Bytes(byte[] bArr, byte[] bArr2, int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= bArr.length) {
                return bArr.length;
            }
            bArr2[i + i3] = bArr[i3];
            i2 = i3 + 1;
        }
    }

    public static int putInt2Bytes(int i, byte[] bArr, int i2) {
        byte[] intToBytes2 = intToBytes2(i);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= intToBytes2.length) {
                return intToBytes2.length;
            }
            bArr[i2 + i4] = intToBytes2[i4];
            i3 = i4 + 1;
        }
    }

    public static int putShort2Bytes(int i, byte[] bArr, int i2) {
        byte[] intToBytes2 = intToBytes2(i);
        bArr[i2 + 0] = intToBytes2[2];
        bArr[i2 + 1] = intToBytes2[3];
        return 2;
    }

    public static int putString2Bytes(String str, byte[] bArr, int i) {
        byte[] string2bytes = string2bytes(str);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= string2bytes.length) {
                return string2bytes.length;
            }
            bArr[i + i3] = string2bytes[i3];
            i2 = i3 + 1;
        }
    }

    public static byte[] string2bytes(String str) {
        String replace = str.replace(" ", "");
        int length = replace.length();
        int i = length / 2;
        int i2 = i;
        String str2 = replace;
        if (length % 2 == 1) {
            str2 = "0" + replace;
            i2 = i + 1;
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return bArr;
            }
            int i5 = i4 * 2;
            bArr[i4] = (byte) Integer.parseInt(str2.substring(i5, i5 + 2), 16);
            i3 = i4 + 1;
        }
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            String num = Integer.toString(bArr[i2] & 255, 16);
            String str = num;
            if (num.length() == 1) {
                str = "0" + num;
            }
            sb.append(str);
            i = i2 + 1;
        }
    }
}
