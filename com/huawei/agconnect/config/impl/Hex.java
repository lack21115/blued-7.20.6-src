package com.huawei.agconnect.config.impl;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/config/impl/Hex.class */
public class Hex {
    private static final char[] HEX_CODE = "0123456789ABCDEF".toCharArray();

    private static byte[] decodeHex(char[] cArr) {
        if ((cArr.length & 1) != 0) {
            throw new IllegalArgumentException("Odd number of characters.");
        }
        byte[] bArr = new byte[cArr.length >> 1];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= cArr.length) {
                return bArr;
            }
            int digit = Character.digit(cArr[i], 16);
            if (digit == -1) {
                throw new IllegalArgumentException("Illegal hexadecimal character at index " + i);
            }
            int i4 = i + 1;
            int digit2 = Character.digit(cArr[i4], 16);
            if (digit2 == -1) {
                throw new IllegalArgumentException("Illegal hexadecimal character at index " + i4);
            }
            i = i4 + 1;
            bArr[i3] = (byte) (((digit << 4) | digit2) & 255);
            i2 = i3 + 1;
        }
    }

    public static byte[] decodeHexString(String str) {
        return decodeHex(str.toCharArray());
    }

    public static String encodeHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            byte b = bArr[i2];
            sb.append(HEX_CODE[(b >> 4) & 15]);
            sb.append(HEX_CODE[b & 15]);
            i = i2 + 1;
        }
    }
}
