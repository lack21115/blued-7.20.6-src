package java.lang;

@FindBugsSuppressWarnings({"DM_NUMBER_CTOR"})
/* loaded from: source-2895416-dex2jar.jar:java/lang/Integer.class */
public final class Integer extends Number implements Comparable<Integer> {
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    public static final int MIN_VALUE = Integer.MIN_VALUE;
    private static final byte[] NTZ_TABLE = {32, 0, 1, 12, 2, 6, -1, 13, 3, -1, 7, -1, -1, -1, -1, 14, 10, 4, -1, -1, 8, -1, -1, 25, -1, -1, -1, -1, -1, 21, 27, 15, 31, 11, 5, -1, -1, -1, -1, -1, 9, -1, -1, 24, -1, -1, 20, 26, 30, -1, -1, -1, -1, 23, -1, 19, 29, -1, 22, 18, 28, 17, 16, -1};
    public static final int SIZE = 32;
    private static final Integer[] SMALL_VALUES = null;
    public static final Class<Integer> TYPE = null;
    private static final long serialVersionUID = 1360826667806852920L;
    private final int value;

    static {
        throw new VerifyError("bad dex opcode");
    }

    public Integer(int i) {
        this.value = i;
    }

    public Integer(String str) throws NumberFormatException {
        this(parseInt(str));
    }

    public static int bitCount(int i) {
        int i2 = i - ((i >> 1) & 1431655765);
        int i3 = (i2 & 858993459) + ((i2 >> 2) & 858993459);
        int i4 = ((i3 >> 4) + i3) & 252645135;
        int i5 = i4 + (i4 >> 8);
        return (i5 + (i5 >> 16)) & 63;
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (r0 == '+') goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Integer decode(java.lang.String r5) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 184
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.Integer.decode(java.lang.String):java.lang.Integer");
    }

    public static Integer getInteger(String str) {
        String property;
        if (str == null || str.length() == 0 || (property = System.getProperty(str)) == null) {
            return null;
        }
        try {
            return decode(property);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Integer getInteger(String str, int i) {
        if (str == null || str.length() == 0) {
            return valueOf(i);
        }
        String property = System.getProperty(str);
        if (property == null) {
            return valueOf(i);
        }
        try {
            return decode(property);
        } catch (NumberFormatException e) {
            return valueOf(i);
        }
    }

    public static Integer getInteger(String str, Integer num) {
        String property;
        if (str == null || str.length() == 0 || (property = System.getProperty(str)) == null) {
            return num;
        }
        try {
            return decode(property);
        } catch (NumberFormatException e) {
            return num;
        }
    }

    public static int highestOneBit(int i) {
        int i2 = i | (i >> 1);
        int i3 = i2 | (i2 >> 2);
        int i4 = i3 | (i3 >> 4);
        int i5 = i4 | (i4 >> 8);
        int i6 = i5 | (i5 >> 16);
        return i6 - (i6 >>> 1);
    }

    private static NumberFormatException invalidInt(String str) {
        throw new NumberFormatException("Invalid int: \"" + str + "\"");
    }

    public static int lowestOneBit(int i) {
        return (-i) & i;
    }

    public static int numberOfLeadingZeros(int i) {
        if (i <= 0) {
            return ((i ^ (-1)) >> 26) & 32;
        }
        int i2 = 1;
        int i3 = i;
        if ((i >> 16) == 0) {
            i2 = 1 + 16;
            i3 = i << 16;
        }
        int i4 = i2;
        int i5 = i3;
        if ((i3 >> 24) == 0) {
            i4 = i2 + 8;
            i5 = i3 << 8;
        }
        int i6 = i4;
        int i7 = i5;
        if ((i5 >> 28) == 0) {
            i6 = i4 + 4;
            i7 = i5 << 4;
        }
        int i8 = i6;
        int i9 = i7;
        if ((i7 >> 30) == 0) {
            i8 = i6 + 2;
            i9 = i7 << 2;
        }
        return i8 - (i9 >>> 31);
    }

    public static int numberOfTrailingZeros(int i) {
        return NTZ_TABLE[(((-i) & i) * 72416175) >>> 26];
    }

    private static int parse(String str, int i, int i2, boolean z) throws NumberFormatException {
        int i3 = Integer.MIN_VALUE / i2;
        int length = str.length();
        int i4 = 0;
        for (int i5 = i; i5 < length; i5++) {
            int digit = Character.digit(str.charAt(i5), i2);
            if (digit == -1) {
                throw invalidInt(str);
            }
            if (i3 > i4) {
                throw invalidInt(str);
            }
            int i6 = (i4 * i2) - digit;
            if (i6 > i4) {
                throw invalidInt(str);
            }
            i4 = i6;
        }
        int i7 = i4;
        if (!z) {
            int i8 = -i4;
            i7 = i8;
            if (i8 < 0) {
                throw invalidInt(str);
            }
        }
        return i7;
    }

    public static int parseInt(String str) throws NumberFormatException {
        return parseInt(str, 10);
    }

    public static int parseInt(String str, int i) throws NumberFormatException {
        boolean z = true;
        if (i < 2 || i > 36) {
            throw new NumberFormatException("Invalid radix: " + i);
        }
        if (str == null || str.isEmpty()) {
            throw invalidInt(str);
        }
        char charAt = str.charAt(0);
        int i2 = (charAt == '-' || charAt == '+') ? 1 : 0;
        if (i2 == str.length()) {
            throw invalidInt(str);
        }
        if (charAt != '-') {
            z = false;
        }
        return parse(str, i2, i, z);
    }

    public static int parsePositiveInt(String str) throws NumberFormatException {
        return parsePositiveInt(str, 10);
    }

    public static int parsePositiveInt(String str, int i) throws NumberFormatException {
        if (i < 2 || i > 36) {
            throw new NumberFormatException("Invalid radix: " + i);
        }
        if (str == null || str.length() == 0) {
            throw invalidInt(str);
        }
        return parse(str, 0, i, false);
    }

    public static int reverse(int i) {
        int i2 = ((i >>> 1) & 1431655765) | ((1431655765 & i) << 1);
        int i3 = ((i2 >>> 2) & 858993459) | ((i2 & 858993459) << 2);
        int i4 = ((i3 >>> 4) & 252645135) | ((i3 & 252645135) << 4);
        int i5 = ((i4 >>> 8) & 16711935) | ((i4 & 16711935) << 8);
        return (i5 >>> 16) | (i5 << 16);
    }

    public static int reverseBytes(int i) {
        int i2 = ((i >>> 8) & 16711935) | ((16711935 & i) << 8);
        return (i2 >>> 16) | (i2 << 16);
    }

    public static int rotateLeft(int i, int i2) {
        return (i << i2) | (i >>> (-i2));
    }

    public static int rotateRight(int i, int i2) {
        return (i >>> i2) | (i << (-i2));
    }

    public static int signum(int i) {
        return (i >> 31) | ((-i) >>> 31);
    }

    public static String toBinaryString(int i) {
        return IntegralToString.intToBinaryString(i);
    }

    public static String toHexString(int i) {
        return IntegralToString.intToHexString(i, false, 0);
    }

    public static String toOctalString(int i) {
        return IntegralToString.intToOctalString(i);
    }

    public static String toString(int i) {
        return IntegralToString.intToString(i);
    }

    public static String toString(int i, int i2) {
        return IntegralToString.intToString(i, i2);
    }

    public static Integer valueOf(int i) {
        return (i >= 128 || i < -128) ? new Integer(i) : SMALL_VALUES[i + 128];
    }

    public static Integer valueOf(String str) throws NumberFormatException {
        return valueOf(parseInt(str));
    }

    public static Integer valueOf(String str, int i) throws NumberFormatException {
        return valueOf(parseInt(str, i));
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return (byte) this.value;
    }

    @Override // java.lang.Comparable
    public int compareTo(Integer num) {
        return compare(this.value, num.value);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Integer) && ((Integer) obj).value == this.value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public short shortValue() {
        return (short) this.value;
    }

    public String toString() {
        return toString(this.value);
    }
}
