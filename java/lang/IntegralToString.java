package java.lang;

/* loaded from: source-2895416-dex2jar.jar:java/lang/IntegralToString.class */
public final class IntegralToString {
    private static final ThreadLocal<char[]> BUFFER = new ThreadLocal<char[]>() { // from class: java.lang.IntegralToString.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public char[] initialValue() {
            return new char[20];
        }
    };
    private static final String[] SMALL_NONNEGATIVE_VALUES = new String[100];
    private static final String[] SMALL_NEGATIVE_VALUES = new String[100];
    private static final char[] TENS = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    private static final char[] ONES = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final char[] MOD_10_TABLE = {0, 1, 2, 2, 3, 3, 4, 5, 5, 6, 7, 7, '\b', '\b', '\t', 0};
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] UPPER_CASE_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private IntegralToString() {
    }

    public static StringBuilder appendByteAsHex(StringBuilder sb, byte b, boolean z) {
        char[] cArr = z ? UPPER_CASE_DIGITS : DIGITS;
        sb.append(cArr[(b >> 4) & 15]);
        sb.append(cArr[b & 15]);
        return sb;
    }

    public static void appendInt(AbstractStringBuilder abstractStringBuilder, int i) {
        convertInt(abstractStringBuilder, i);
    }

    public static void appendLong(AbstractStringBuilder abstractStringBuilder, long j) {
        convertLong(abstractStringBuilder, j);
    }

    public static String byteToHexString(byte b, boolean z) {
        char[] cArr = z ? UPPER_CASE_DIGITS : DIGITS;
        return new String(0, 2, new char[]{cArr[(b >> 4) & 15], cArr[b & 15]});
    }

    public static String bytesToHexString(byte[] bArr, boolean z) {
        char[] cArr = z ? UPPER_CASE_DIGITS : DIGITS;
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    private static String convertInt(AbstractStringBuilder abstractStringBuilder, int i) {
        boolean z;
        int i2;
        int i3;
        int i4;
        String str = null;
        if (i < 0) {
            int i5 = -i;
            z = true;
            i2 = i5;
            if (i5 < 100) {
                if (i5 < 0) {
                    str = "-2147483648";
                    i2 = i5;
                    z = true;
                } else {
                    String str2 = SMALL_NEGATIVE_VALUES[i5];
                    z = true;
                    str = str2;
                    i2 = i5;
                    if (str2 == null) {
                        String[] strArr = SMALL_NEGATIVE_VALUES;
                        str = i5 < 10 ? stringOf('-', ONES[i5]) : stringOf('-', TENS[i5], ONES[i5]);
                        strArr[i5] = str;
                        z = true;
                        i2 = i5;
                    }
                }
            }
        } else {
            z = false;
            i2 = i;
            if (i < 100) {
                String str3 = SMALL_NONNEGATIVE_VALUES[i];
                z = false;
                str = str3;
                i2 = i;
                if (str3 == null) {
                    String[] strArr2 = SMALL_NONNEGATIVE_VALUES;
                    str = i < 10 ? stringOf(ONES[i]) : stringOf(TENS[i], ONES[i]);
                    strArr2[i] = str;
                    z = false;
                    i2 = i;
                }
            }
        }
        if (str != null) {
            String str4 = str;
            if (abstractStringBuilder != null) {
                abstractStringBuilder.append0(str);
                str4 = null;
            }
            return str4;
        }
        char[] cArr = abstractStringBuilder != null ? BUFFER.get() : new char[11];
        int i6 = 11;
        while (true) {
            int i7 = i2;
            i3 = i6;
            i4 = i7;
            if (i7 < 65536) {
                break;
            }
            i2 = (int) ((1374389535 * i7) >>> 37);
            int i8 = i7 - (i2 * 100);
            int i9 = i6 - 1;
            cArr[i9] = ONES[i8];
            i6 = i9 - 1;
            cArr[i6] = TENS[i8];
        }
        while (i4 != 0) {
            int i10 = (52429 * i4) >>> 19;
            i3--;
            cArr[i3] = DIGITS[i4 - (i10 * 10)];
            i4 = i10;
        }
        int i11 = i3;
        if (z) {
            i11 = i3 - 1;
            cArr[i11] = '-';
        }
        if (abstractStringBuilder != null) {
            abstractStringBuilder.append0(cArr, i11, 11 - i11);
            return null;
        }
        return new String(i11, 11 - i11, cArr);
    }

    private static String convertLong(AbstractStringBuilder abstractStringBuilder, long j) {
        int intIntoCharArray;
        String str;
        int i = (int) j;
        if (i != j) {
            boolean z = j < 0;
            long j2 = j;
            if (z) {
                long j3 = -j;
                j2 = j3;
                if (j3 < 0) {
                    str = "-9223372036854775808";
                    if (abstractStringBuilder != null) {
                        abstractStringBuilder.append0("-9223372036854775808");
                        return null;
                    }
                }
            }
            char[] cArr = abstractStringBuilder != null ? BUFFER.get() : new char[20];
            int i2 = (int) (j2 % 1000000000);
            int intIntoCharArray2 = intIntoCharArray(cArr, 20, i2);
            while (intIntoCharArray2 != 11) {
                intIntoCharArray2--;
                cArr[intIntoCharArray2] = '0';
            }
            long j4 = ((j2 - i2) >>> 9) * (-8194354213138031507L);
            if (((-4294967296L) & j4) == 0) {
                intIntoCharArray = intIntoCharArray(cArr, intIntoCharArray2, (int) j4);
            } else {
                int i3 = (int) j4;
                int i4 = MOD_10_TABLE[(((429496729 * i3) + (i3 >>> 1)) + (i3 >>> 3)) >>> 28] - (((int) (j4 >>> 32)) << 2);
                int i5 = i4;
                if (i4 < 0) {
                    i5 = i4 + 10;
                }
                int i6 = intIntoCharArray2 - 1;
                cArr[i6] = DIGITS[i5];
                intIntoCharArray = intIntoCharArray(cArr, i6, ((int) ((j4 - i5) >>> 1)) * (-858993459));
            }
            int i7 = intIntoCharArray;
            if (z) {
                i7 = intIntoCharArray - 1;
                cArr[i7] = '-';
            }
            if (abstractStringBuilder != null) {
                abstractStringBuilder.append0(cArr, i7, 20 - i7);
                return null;
            }
            return new String(i7, 20 - i7, cArr);
        }
        str = convertInt(abstractStringBuilder, i);
        return str;
    }

    private static int intIntoCharArray(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        while (true) {
            i3 = i;
            i4 = i2;
            if (((-65536) & i2) == 0) {
                break;
            }
            int i5 = (int) ((1374389535 * (i2 >>> 2)) >>> 35);
            int i6 = i2 - (i5 * 100);
            int i7 = i - 1;
            cArr[i7] = ONES[i6];
            i = i7 - 1;
            cArr[i] = TENS[i6];
            i2 = i5;
        }
        while (i4 != 0) {
            int i8 = (52429 * i4) >>> 19;
            i3--;
            cArr[i3] = DIGITS[i4 - (i8 * 10)];
            i4 = i8;
        }
        return i3;
    }

    public static String intToBinaryString(int i) {
        int i2;
        int i3;
        char[] cArr = new char[32];
        int i4 = 32;
        do {
            i2 = i4 - 1;
            cArr[i2] = DIGITS[i & 1];
            i3 = i >>> 1;
            i4 = i2;
            i = i3;
        } while (i3 != 0);
        return new String(i2, 32 - i2, cArr);
    }

    public static String intToHexString(int i, boolean z, int i2) {
        char[] cArr = new char[8];
        int i3 = 8;
        char[] cArr2 = z ? UPPER_CASE_DIGITS : DIGITS;
        while (true) {
            int i4 = i3 - 1;
            cArr[i4] = cArr2[i & 15];
            int i5 = i >>> 4;
            i3 = i4;
            i = i5;
            if (i5 == 0) {
                i3 = i4;
                i = i5;
                if (8 - i4 >= i2) {
                    return new String(i4, 8 - i4, cArr);
                }
            }
        }
    }

    public static String intToOctalString(int i) {
        int i2;
        int i3;
        char[] cArr = new char[11];
        int i4 = 11;
        do {
            i2 = i4 - 1;
            cArr[i2] = DIGITS[i & 7];
            i3 = i >>> 3;
            i4 = i2;
            i = i3;
        } while (i3 != 0);
        return new String(i2, 11 - i2, cArr);
    }

    public static String intToString(int i) {
        return convertInt(null, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
        if (r7 > 36) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String intToString(int r6, int r7) {
        /*
            r0 = r7
            r1 = 2
            if (r0 < r1) goto Ld
            r0 = r7
            r8 = r0
            r0 = r7
            r1 = 36
            if (r0 <= r1) goto L10
        Ld:
            r0 = 10
            r8 = r0
        L10:
            r0 = r8
            r1 = 10
            if (r0 != r1) goto L1b
            r0 = r6
            java.lang.String r0 = intToString(r0)
            return r0
        L1b:
            r0 = 0
            r9 = r0
            r0 = r6
            if (r0 >= 0) goto L7c
            r0 = 1
            r9 = r0
            r0 = r6
            r7 = r0
        L25:
            r0 = r8
            r1 = 8
            if (r0 >= r1) goto L82
            r0 = 33
            r6 = r0
        L2e:
            r0 = r6
            char[] r0 = new char[r0]
            r13 = r0
            r0 = r6
            r11 = r0
        L36:
            r0 = r7
            r1 = r8
            int r0 = r0 / r1
            r12 = r0
            r0 = r11
            r1 = 1
            int r0 = r0 - r1
            r10 = r0
            r0 = r13
            r1 = r10
            char[] r2 = java.lang.IntegralToString.DIGITS
            r3 = r8
            r4 = r12
            int r3 = r3 * r4
            r4 = r7
            int r3 = r3 - r4
            char r2 = r2[r3]
            r0[r1] = r2
            r0 = r10
            r11 = r0
            r0 = r12
            r7 = r0
            r0 = r12
            if (r0 != 0) goto L36
            r0 = r10
            r7 = r0
            r0 = r9
            if (r0 == 0) goto L6e
            r0 = r10
            r1 = 1
            int r0 = r0 - r1
            r7 = r0
            r0 = r13
            r1 = r7
            r2 = 45
            r0[r1] = r2
        L6e:
            java.lang.String r0 = new java.lang.String
            r1 = r0
            r2 = r7
            r3 = r6
            r4 = r7
            int r3 = r3 - r4
            r4 = r13
            r1.<init>(r2, r3, r4)
            return r0
        L7c:
            r0 = r6
            int r0 = -r0
            r7 = r0
            goto L25
        L82:
            r0 = 12
            r6 = r0
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.IntegralToString.intToString(int, int):java.lang.String");
    }

    public static String longToBinaryString(long j) {
        int i;
        long j2;
        int i2 = (int) j;
        if (j < 0 || i2 != j) {
            char[] cArr = new char[64];
            int i3 = 64;
            do {
                i = i3 - 1;
                cArr[i] = DIGITS[((int) j) & 1];
                j2 = j >>> 1;
                i3 = i;
                j = j2;
            } while (j2 != 0);
            return new String(i, 64 - i, cArr);
        }
        return intToBinaryString(i2);
    }

    public static String longToHexString(long j) {
        int i;
        long j2;
        int i2 = (int) j;
        if (j < 0 || i2 != j) {
            char[] cArr = new char[16];
            int i3 = 16;
            do {
                i = i3 - 1;
                cArr[i] = DIGITS[((int) j) & 15];
                j2 = j >>> 4;
                i3 = i;
                j = j2;
            } while (j2 != 0);
            return new String(i, 16 - i, cArr);
        }
        return intToHexString(i2, false, 0);
    }

    public static String longToOctalString(long j) {
        int i;
        long j2;
        int i2 = (int) j;
        if (j < 0 || i2 != j) {
            char[] cArr = new char[22];
            int i3 = 22;
            do {
                i = i3 - 1;
                cArr[i] = DIGITS[((int) j) & 7];
                j2 = j >>> 3;
                i3 = i;
                j = j2;
            } while (j2 != 0);
            return new String(i, 22 - i, cArr);
        }
        return intToOctalString(i2);
    }

    public static String longToString(long j) {
        return convertLong(null, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r10 > 36) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String longToString(long r8, int r10) {
        /*
            Method dump skipped, instructions count: 160
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.IntegralToString.longToString(long, int):java.lang.String");
    }

    private static String stringOf(char... cArr) {
        return new String(0, cArr.length, cArr);
    }
}
