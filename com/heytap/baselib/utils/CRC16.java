package com.heytap.baselib.utils;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/baselib/utils/CRC16.class */
class CRC16 {
    private static final byte[] crc16_tab_h = {0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64, 1, -64, Byte.MIN_VALUE, 65, 1, -64, Byte.MIN_VALUE, 65, 0, -63, -127, 64};
    private static final byte[] crc16_tab_l = {0, -64, -63, 1, -61, 3, 2, -62, -58, 6, 7, -57, 5, -59, -60, 4, -52, 12, 13, -51, 15, -49, -50, 14, 10, -54, -53, 11, -55, 9, 8, -56, -40, 24, 25, -39, 27, -37, -38, 26, 30, -34, -33, 31, -35, 29, 28, -36, 20, -44, -43, 21, -41, 23, 22, -42, -46, 18, 19, -45, 17, -47, -48, 16, -16, 48, 49, -15, 51, -13, -14, 50, 54, -10, -9, 55, -11, 53, 52, -12, 60, -4, -3, 61, -1, 63, 62, -2, -6, 58, 59, -5, 57, -7, -8, 56, 40, -24, -23, 41, -21, 43, 42, -22, -18, 46, 47, -17, 45, -19, -20, 44, -28, 36, 37, -27, 39, -25, -26, 38, 34, -30, -29, 35, -31, 33, 32, -32, -96, 96, 97, -95, 99, -93, -94, 98, 102, -90, -89, 103, -91, 101, 100, -92, 108, -84, -83, 109, -81, 111, 110, -82, -86, 106, 107, -85, 105, -87, -88, 104, 120, -72, -71, 121, -69, 123, 122, -70, -66, 126, Byte.MAX_VALUE, -65, 125, -67, -68, 124, -76, 116, 117, -75, 119, -73, -74, 118, 114, -78, -77, 115, -79, 113, 112, -80, 80, -112, -111, 81, -109, 83, 82, -110, -106, 86, 87, -105, 85, -107, -108, 84, -100, 92, 93, -99, 95, -97, -98, 94, 90, -102, -101, 91, -103, 89, 88, -104, -120, 72, 73, -119, 75, -117, -118, 74, 78, -114, -113, 79, -115, 77, 76, -116, 68, -124, -123, 69, -121, 71, 70, -122, -126, 66, 67, -125, 65, -127, Byte.MIN_VALUE, 64};

    CRC16() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int calcCrc16(byte[] bArr) {
        return calcCrc16(bArr, 0, bArr.length);
    }

    private static int calcCrc16(byte[] bArr, int i, int i2) {
        return calcCrc16(bArr, i, i2, 65535);
    }

    private static int calcCrc16(byte[] bArr, int i, int i2, int i3) {
        int i4 = i3 & 255;
        int i5 = 0;
        byte b = (65280 & i3) >> 8;
        while (true) {
            int i6 = b;
            if (i5 >= i2) {
                return (((i6 & 255) << 8) | (i4 & 255)) & 65535;
            }
            int i7 = (i4 ^ bArr[i + i5]) & 255;
            byte b2 = crc16_tab_h[i7];
            b = crc16_tab_l[i7];
            i5++;
            i4 = i6 ^ b2;
        }
    }
}
