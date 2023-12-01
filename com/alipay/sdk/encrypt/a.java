package com.alipay.sdk.encrypt;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/encrypt/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4627a = 128;
    private static final int b = 64;

    /* renamed from: c  reason: collision with root package name */
    private static final int f4628c = 24;
    private static final int d = 8;
    private static final int e = 16;
    private static final int f = 4;
    private static final int g = -128;
    private static final char h = '=';
    private static final byte[] i = new byte[128];
    private static final char[] j = new char[64];

    static {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 128) {
                break;
            }
            i[i6] = -1;
            i5 = i6 + 1;
        }
        int i7 = 90;
        while (true) {
            int i8 = i7;
            if (i8 < 65) {
                break;
            }
            i[i8] = (byte) (i8 - 65);
            i7 = i8 - 1;
        }
        int i9 = 122;
        while (true) {
            int i10 = i9;
            i2 = 26;
            if (i10 < 97) {
                break;
            }
            i[i10] = (byte) ((i10 - 97) + 26);
            i9 = i10 - 1;
        }
        int i11 = 57;
        while (true) {
            int i12 = i11;
            if (i12 < 48) {
                break;
            }
            i[i12] = (byte) ((i12 - 48) + 52);
            i11 = i12 - 1;
        }
        byte[] bArr = i;
        bArr[43] = 62;
        bArr[47] = 63;
        int i13 = 0;
        while (true) {
            int i14 = i13;
            if (i14 > 25) {
                break;
            }
            j[i14] = (char) (i14 + 65);
            i13 = i14 + 1;
        }
        int i15 = 0;
        while (true) {
            int i16 = i15;
            i3 = 0;
            i4 = 52;
            if (i2 > 51) {
                break;
            }
            j[i2] = (char) (i16 + 97);
            i2++;
            i15 = i16 + 1;
        }
        while (i4 <= 61) {
            j[i4] = (char) (i3 + 48);
            i4++;
            i3++;
        }
        char[] cArr = j;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    private static int a(char[] cArr) {
        int i2 = 0;
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= length) {
                return i4;
            }
            int i5 = i4;
            if (!a(cArr[i2])) {
                cArr[i4] = cArr[i2];
                i5 = i4 + 1;
            }
            i2++;
            i3 = i5;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i2 = length % 24;
        int i3 = length / 24;
        char[] cArr = new char[(i2 != 0 ? i3 + 1 : i3) * 4];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < i3) {
            int i7 = i5 + 1;
            byte b2 = bArr[i5];
            int i8 = i7 + 1;
            byte b3 = bArr[i7];
            byte b4 = bArr[i8];
            byte b5 = (byte) (b3 & 15);
            byte b6 = (byte) (b2 & 3);
            int i9 = b2 >> 2;
            if ((b2 & Byte.MIN_VALUE) != 0) {
                i9 ^= 192;
            }
            byte b7 = (byte) i9;
            int i10 = b3 >> 4;
            if ((b3 & Byte.MIN_VALUE) != 0) {
                i10 ^= 240;
            }
            byte b8 = (byte) i10;
            int i11 = (b4 & Byte.MIN_VALUE) == 0 ? b4 >> 6 : (b4 >> 6) ^ 252;
            int i12 = i6 + 1;
            char[] cArr2 = j;
            cArr[i6] = cArr2[b7];
            int i13 = i12 + 1;
            cArr[i12] = cArr2[(b6 << 4) | b8];
            int i14 = i13 + 1;
            cArr[i13] = cArr2[(b5 << 2) | ((byte) i11)];
            cArr[i14] = cArr2[b4 & 63];
            i4++;
            i6 = i14 + 1;
            i5 = i8 + 1;
        }
        if (i2 == 8) {
            byte b9 = bArr[i5];
            byte b10 = (byte) (b9 & 3);
            int i15 = b9 >> 2;
            if ((b9 & Byte.MIN_VALUE) != 0) {
                i15 ^= 192;
            }
            int i16 = i6 + 1;
            char[] cArr3 = j;
            cArr[i6] = cArr3[(byte) i15];
            int i17 = i16 + 1;
            cArr[i16] = cArr3[b10 << 4];
            cArr[i17] = '=';
            cArr[i17 + 1] = '=';
        } else if (i2 == 16) {
            byte b11 = bArr[i5];
            byte b12 = bArr[i5 + 1];
            byte b13 = (byte) (b12 & 15);
            byte b14 = (byte) (b11 & 3);
            int i18 = b11 >> 2;
            if ((b11 & Byte.MIN_VALUE) != 0) {
                i18 ^= 192;
            }
            byte b15 = (byte) i18;
            int i19 = b12 >> 4;
            if ((b12 & Byte.MIN_VALUE) != 0) {
                i19 ^= 240;
            }
            int i20 = i6 + 1;
            char[] cArr4 = j;
            cArr[i6] = cArr4[b15];
            int i21 = i20 + 1;
            cArr[i20] = cArr4[((byte) i19) | (b14 << 4)];
            cArr[i21] = cArr4[b13 << 2];
            cArr[i21 + 1] = '=';
        }
        return new String(cArr);
    }

    private static boolean a(char c2) {
        return c2 == ' ' || c2 == '\r' || c2 == '\n' || c2 == '\t';
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int a2 = a(charArray);
        if (a2 % 4 != 0) {
            return null;
        }
        int i2 = a2 / 4;
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2 * 3];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2 - 1) {
            int i6 = i4 + 1;
            char c2 = charArray[i4];
            if (!c(c2)) {
                return null;
            }
            int i7 = i6 + 1;
            char c3 = charArray[i6];
            if (!c(c3)) {
                return null;
            }
            int i8 = i7 + 1;
            char c4 = charArray[i7];
            if (!c(c4)) {
                return null;
            }
            char c5 = charArray[i8];
            if (!c(c5)) {
                return null;
            }
            byte[] bArr2 = i;
            byte b2 = bArr2[c2];
            byte b3 = bArr2[c3];
            byte b4 = bArr2[c4];
            byte b5 = bArr2[c5];
            int i9 = i5 + 1;
            bArr[i5] = (byte) ((b2 << 2) | (b3 >> 4));
            int i10 = i9 + 1;
            bArr[i9] = (byte) (((b3 & 15) << 4) | ((b4 >> 2) & 15));
            i5 = i10 + 1;
            bArr[i10] = (byte) ((b4 << 6) | b5);
            i3++;
            i4 = i8 + 1;
        }
        int i11 = i4 + 1;
        char c6 = charArray[i4];
        byte[] bArr3 = null;
        if (c(c6)) {
            int i12 = i11 + 1;
            char c7 = charArray[i11];
            if (!c(c7)) {
                return null;
            }
            byte[] bArr4 = i;
            byte b6 = bArr4[c6];
            byte b7 = bArr4[c7];
            char c8 = charArray[i12];
            char c9 = charArray[i12 + 1];
            if (c(c8) && c(c9)) {
                byte[] bArr5 = i;
                byte b8 = bArr5[c8];
                byte b9 = bArr5[c9];
                int i13 = i5 + 1;
                bArr[i5] = (byte) ((b6 << 2) | (b7 >> 4));
                bArr[i13] = (byte) (((b7 & 15) << 4) | ((b8 >> 2) & 15));
                bArr[i13 + 1] = (byte) (b9 | (b8 << 6));
                return bArr;
            } else if (b(c8) && b(c9)) {
                if ((b7 & 15) != 0) {
                    return null;
                }
                int i14 = i3 * 3;
                byte[] bArr6 = new byte[i14 + 1];
                System.arraycopy((Object) bArr, 0, (Object) bArr6, 0, i14);
                bArr6[i5] = (byte) ((b6 << 2) | (b7 >> 4));
                return bArr6;
            } else {
                bArr3 = null;
                if (!b(c8)) {
                    bArr3 = null;
                    if (b(c9)) {
                        byte b10 = i[c8];
                        if ((b10 & 3) != 0) {
                            return null;
                        }
                        int i15 = i3 * 3;
                        bArr3 = new byte[i15 + 2];
                        System.arraycopy((Object) bArr, 0, (Object) bArr3, 0, i15);
                        bArr3[i5] = (byte) ((b6 << 2) | (b7 >> 4));
                        bArr3[i5 + 1] = (byte) (((b10 >> 2) & 15) | ((b7 & 15) << 4));
                    }
                }
            }
        }
        return bArr3;
    }

    private static boolean b(char c2) {
        return c2 == '=';
    }

    private static boolean c(char c2) {
        return c2 < 128 && i[c2] != -1;
    }
}
