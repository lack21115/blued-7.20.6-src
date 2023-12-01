package com.android.internal.util;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/HexDump.class */
public class HexDump {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String dumpHexString(byte[] bArr) {
        return dumpHexString(bArr, 0, bArr.length);
    }

    public static String dumpHexString(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        byte[] bArr2 = new byte[16];
        int i3 = 0;
        sb.append("\n0x");
        sb.append(toHexString(i));
        int i4 = i;
        while (i4 < i + i2) {
            int i5 = i3;
            if (i3 == 16) {
                sb.append(" ");
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 >= 16) {
                        break;
                    }
                    if (bArr2[i7] <= 32 || bArr2[i7] >= 126) {
                        sb.append(".");
                    } else {
                        sb.append(new String(bArr2, i7, 1));
                    }
                    i6 = i7 + 1;
                }
                sb.append("\n0x");
                sb.append(toHexString(i4));
                i5 = 0;
            }
            byte b = bArr[i4];
            sb.append(" ");
            sb.append(HEX_DIGITS[(b >>> 4) & 15]);
            sb.append(HEX_DIGITS[b & 15]);
            bArr2[i5] = b;
            i4++;
            i3 = i5 + 1;
        }
        if (i3 != 16) {
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= ((16 - i3) * 3) + 1) {
                    break;
                }
                sb.append(" ");
                i8 = i9 + 1;
            }
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 >= i3) {
                    break;
                }
                if (bArr2[i11] <= 32 || bArr2[i11] >= 126) {
                    sb.append(".");
                } else {
                    sb.append(new String(bArr2, i11, 1));
                }
                i10 = i11 + 1;
            }
        }
        return sb.toString();
    }

    public static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            bArr[i2 / 2] = (byte) ((toByte(str.charAt(i2)) << 4) | toByte(str.charAt(i2 + 1)));
            i = i2 + 2;
        }
    }

    private static int toByte(char c) {
        if (c < '0' || c > '9') {
            if (c < 'A' || c > 'F') {
                if (c < 'a' || c > 'f') {
                    throw new RuntimeException("Invalid hex char '" + c + "'");
                }
                return (c - 'a') + 10;
            }
            return (c - 'A') + 10;
        }
        return c - '0';
    }

    public static byte[] toByteArray(byte b) {
        return new byte[]{b};
    }

    public static byte[] toByteArray(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static String toHexString(byte b) {
        return toHexString(toByteArray(b));
    }

    public static String toHexString(int i) {
        return toHexString(toByteArray(i));
    }

    public static String toHexString(byte[] bArr) {
        return toHexString(bArr, 0, bArr.length);
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        char[] cArr = new char[i2 * 2];
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            byte b = bArr[i4];
            int i5 = i3 + 1;
            cArr[i3] = HEX_DIGITS[(b >>> 4) & 15];
            i3 = i5 + 1;
            cArr[i5] = HEX_DIGITS[b & 15];
        }
        return new String(cArr);
    }
}
