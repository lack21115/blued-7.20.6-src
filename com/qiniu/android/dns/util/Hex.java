package com.qiniu.android.dns.util;

import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/util/Hex.class */
public final class Hex {
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/util/Hex$HexDecodeException.class */
    public static class HexDecodeException extends IOException {
        public HexDecodeException(String str) {
            super(str);
        }
    }

    public static byte[] decodeHex(char[] cArr) throws HexDecodeException {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new HexDecodeException("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                return bArr;
            }
            int digit = toDigit(cArr[i], i);
            int i4 = i + 1;
            i = i4 + 1;
            bArr[i3] = (byte) (((digit << 4) | toDigit(cArr[i4], i4)) & 255);
            i2 = i3 + 1;
        }
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, true);
    }

    public static char[] encodeHex(byte[] bArr, boolean z) {
        return encodeHex(bArr, z ? DIGITS_LOWER : DIGITS_UPPER);
    }

    private static char[] encodeHex(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return cArr2;
    }

    public static String encodeHexString(byte[] bArr) {
        return new String(encodeHex(bArr));
    }

    protected static int toDigit(char c2, int i) throws HexDecodeException {
        int digit = Character.digit(c2, 16);
        if (digit != -1) {
            return digit;
        }
        throw new HexDecodeException("Illegal hexadecimal character " + c2 + " at index " + i);
    }
}
