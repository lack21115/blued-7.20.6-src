package com.tencent.tinker.android.dx.util;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dx/util/Hex.class */
public final class Hex {
    private Hex() {
    }

    public static String dump(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        int i6 = i + i2;
        if ((i | i2 | i6) < 0 || i6 > bArr.length) {
            throw new IndexOutOfBoundsException("arr.length " + bArr.length + "; " + i + "..!" + i6);
        } else if (i3 >= 0) {
            if (i2 == 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer((i2 * 4) + 6);
            int i7 = i3;
            int i8 = i;
            int i9 = 0;
            while (i2 > 0) {
                if (i9 == 0) {
                    stringBuffer.append(i5 != 2 ? i5 != 4 ? i5 != 6 ? u4(i7) : u3(i7) : u2(i7) : u1(i7));
                    stringBuffer.append(": ");
                } else if ((i9 & 1) == 0) {
                    stringBuffer.append(' ');
                }
                stringBuffer.append(u1(bArr[i8]));
                i7++;
                i8++;
                int i10 = i9 + 1;
                i9 = i10;
                if (i10 == i4) {
                    stringBuffer.append('\n');
                    i9 = 0;
                }
                i2--;
            }
            if (i9 != 0) {
                stringBuffer.append('\n');
            }
            return stringBuffer.toString();
        } else {
            throw new IllegalArgumentException("outOffset < 0");
        }
    }

    public static String s1(int i) {
        char[] cArr = new char[3];
        if (i < 0) {
            cArr[0] = '-';
            i = -i;
        } else {
            cArr[0] = '+';
        }
        for (int i2 = 0; i2 < 2; i2++) {
            cArr[2 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    public static String s2(int i) {
        char[] cArr = new char[5];
        if (i < 0) {
            cArr[0] = '-';
            i = -i;
        } else {
            cArr[0] = '+';
        }
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[4 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    public static String s4(int i) {
        char[] cArr = new char[9];
        if (i < 0) {
            cArr[0] = '-';
            i = -i;
        } else {
            cArr[0] = '+';
        }
        for (int i2 = 0; i2 < 8; i2++) {
            cArr[8 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    public static String s8(long j) {
        char[] cArr = new char[17];
        if (j < 0) {
            cArr[0] = '-';
            j = -j;
        } else {
            cArr[0] = '+';
        }
        for (int i = 0; i < 16; i++) {
            cArr[16 - i] = Character.forDigit(((int) j) & 15, 16);
            j >>= 4;
        }
        return new String(cArr);
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length << 1);
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            sb.append(u1(bArr[i2]));
            i = i2 + 1;
        }
    }

    public static String u1(int i) {
        char[] cArr = new char[2];
        int i2 = i;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 2) {
                return new String(cArr);
            }
            cArr[1 - i4] = Character.forDigit(i2 & 15, 16);
            i2 >>= 4;
            i3 = i4 + 1;
        }
    }

    public static String u2(int i) {
        char[] cArr = new char[4];
        int i2 = i;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 4) {
                return new String(cArr);
            }
            cArr[3 - i4] = Character.forDigit(i2 & 15, 16);
            i2 >>= 4;
            i3 = i4 + 1;
        }
    }

    public static String u2or4(int i) {
        return i == ((char) i) ? u2(i) : u4(i);
    }

    public static String u3(int i) {
        char[] cArr = new char[6];
        int i2 = i;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 6) {
                return new String(cArr);
            }
            cArr[5 - i4] = Character.forDigit(i2 & 15, 16);
            i2 >>= 4;
            i3 = i4 + 1;
        }
    }

    public static String u4(int i) {
        char[] cArr = new char[8];
        int i2 = i;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 8) {
                return new String(cArr);
            }
            cArr[7 - i4] = Character.forDigit(i2 & 15, 16);
            i2 >>= 4;
            i3 = i4 + 1;
        }
    }

    public static String u8(long j) {
        char[] cArr = new char[16];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 16) {
                return new String(cArr);
            }
            cArr[15 - i2] = Character.forDigit(((int) j) & 15, 16);
            j >>= 4;
            i = i2 + 1;
        }
    }

    public static String uNibble(int i) {
        return new String(new char[]{Character.forDigit(i & 15, 16)});
    }
}
