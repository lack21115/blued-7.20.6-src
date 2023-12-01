package java.lang;

@FindBugsSuppressWarnings({"DM_NUMBER_CTOR"})
/* loaded from: source-2895416-dex2jar.jar:java/lang/Long.class */
public final class Long extends Number implements Comparable<Long> {
    public static final long MAX_VALUE = Long.MAX_VALUE;
    public static final long MIN_VALUE = Long.MIN_VALUE;
    public static final int SIZE = 64;
    private static final Long[] SMALL_VALUES = null;
    public static final Class<Long> TYPE = null;
    private static final long serialVersionUID = 4290774380558885855L;
    private final long value;

    static {
        throw new VerifyError("bad dex opcode");
    }

    public Long(long j) {
        this.value = j;
    }

    public Long(String str) throws NumberFormatException {
        this(parseLong(str));
    }

    public static int bitCount(long j) {
        long j2 = j - ((j >>> 1) & 6148914691236517205L);
        long j3 = (j2 & 3689348814741910323L) + ((j2 >>> 2) & 3689348814741910323L);
        int i = ((int) (j3 >>> 32)) + ((int) j3);
        int i2 = (i & 252645135) + ((i >>> 4) & 252645135);
        int i3 = i2 + (i2 >>> 8);
        return (i3 + (i3 >>> 16)) & 127;
    }

    public static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (r0 == '+') goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Long decode(java.lang.String r5) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 184
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.Long.decode(java.lang.String):java.lang.Long");
    }

    public static Long getLong(String str) {
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

    public static Long getLong(String str, long j) {
        if (str == null || str.length() == 0) {
            return valueOf(j);
        }
        String property = System.getProperty(str);
        if (property == null) {
            return valueOf(j);
        }
        try {
            return decode(property);
        } catch (NumberFormatException e) {
            return valueOf(j);
        }
    }

    public static Long getLong(String str, Long l) {
        String property;
        if (str == null || str.length() == 0 || (property = System.getProperty(str)) == null) {
            return l;
        }
        try {
            return decode(property);
        } catch (NumberFormatException e) {
            return l;
        }
    }

    public static long highestOneBit(long j) {
        long j2 = j | (j >> 1);
        long j3 = j2 | (j2 >> 2);
        long j4 = j3 | (j3 >> 4);
        long j5 = j4 | (j4 >> 8);
        long j6 = j5 | (j5 >> 16);
        long j7 = j6 | (j6 >> 32);
        return j7 - (j7 >>> 1);
    }

    private static NumberFormatException invalidLong(String str) {
        throw new NumberFormatException("Invalid long: \"" + str + "\"");
    }

    public static long lowestOneBit(long j) {
        return (-j) & j;
    }

    public static int numberOfLeadingZeros(long j) {
        if (j < 0) {
            return 0;
        }
        if (j == 0) {
            return 64;
        }
        int i = 1;
        int i2 = (int) (j >>> 32);
        int i3 = i2;
        if (i2 == 0) {
            i = 1 + 32;
            i3 = (int) j;
        }
        int i4 = i3;
        int i5 = i;
        if ((i3 >>> 16) == 0) {
            i5 = i + 16;
            i4 = i3 << 16;
        }
        int i6 = i4;
        int i7 = i5;
        if ((i4 >>> 24) == 0) {
            i7 = i5 + 8;
            i6 = i4 << 8;
        }
        int i8 = i6;
        int i9 = i7;
        if ((i6 >>> 28) == 0) {
            i9 = i7 + 4;
            i8 = i6 << 4;
        }
        int i10 = i8;
        int i11 = i9;
        if ((i8 >>> 30) == 0) {
            i11 = i9 + 2;
            i10 = i8 << 2;
        }
        return i11 - (i10 >>> 31);
    }

    public static int numberOfTrailingZeros(long j) {
        int i = (int) j;
        return i != 0 ? Integer.numberOfTrailingZeros(i) : Integer.numberOfTrailingZeros((int) (j >>> 32)) + 32;
    }

    private static long parse(String str, int i, int i2, boolean z) {
        long j = Long.MIN_VALUE / i2;
        long j2 = 0;
        int length = str.length();
        while (i < length) {
            int digit = Character.digit(str.charAt(i), i2);
            if (digit == -1) {
                throw invalidLong(str);
            }
            if (j > j2) {
                throw invalidLong(str);
            }
            long j3 = (i2 * j2) - digit;
            if (j3 > j2) {
                throw invalidLong(str);
            }
            j2 = j3;
            i++;
        }
        long j4 = j2;
        if (!z) {
            long j5 = -j2;
            j4 = j5;
            if (j5 < 0) {
                throw invalidLong(str);
            }
        }
        return j4;
    }

    public static long parseLong(String str) throws NumberFormatException {
        return parseLong(str, 10);
    }

    public static long parseLong(String str, int i) throws NumberFormatException {
        boolean z = true;
        if (i < 2 || i > 36) {
            throw new NumberFormatException("Invalid radix: " + i);
        }
        if (str == null || str.isEmpty()) {
            throw invalidLong(str);
        }
        char charAt = str.charAt(0);
        int i2 = (charAt == '-' || charAt == '+') ? 1 : 0;
        if (i2 == str.length()) {
            throw invalidLong(str);
        }
        if (charAt != '-') {
            z = false;
        }
        return parse(str, i2, i, z);
    }

    public static long parsePositiveLong(String str) throws NumberFormatException {
        return parsePositiveLong(str, 10);
    }

    public static long parsePositiveLong(String str, int i) throws NumberFormatException {
        if (i < 2 || i > 36) {
            throw new NumberFormatException("Invalid radix: " + i);
        }
        if (str == null || str.length() == 0) {
            throw invalidLong(str);
        }
        return parse(str, 0, i, false);
    }

    public static long reverse(long j) {
        long j2 = ((j >>> 1) & 6148914691236517205L) | ((6148914691236517205L & j) << 1);
        long j3 = ((j2 >>> 2) & 3689348814741910323L) | ((3689348814741910323L & j2) << 2);
        long j4 = ((j3 >>> 4) & 1085102592571150095L) | ((1085102592571150095L & j3) << 4);
        long j5 = ((j4 >>> 8) & 71777214294589695L) | ((71777214294589695L & j4) << 8);
        long j6 = ((j5 >>> 16) & 281470681808895L) | ((281470681808895L & j5) << 16);
        return (j6 >>> 32) | (j6 << 32);
    }

    public static long reverseBytes(long j) {
        long j2 = ((j >>> 8) & 71777214294589695L) | ((71777214294589695L & j) << 8);
        long j3 = ((j2 >>> 16) & 281470681808895L) | ((j2 & 281470681808895L) << 16);
        return (j3 >>> 32) | (j3 << 32);
    }

    public static long rotateLeft(long j, int i) {
        return (j << i) | (j >>> (-i));
    }

    public static long rotateRight(long j, int i) {
        return (j >>> i) | (j << (-i));
    }

    public static int signum(long j) {
        if (j < 0) {
            return -1;
        }
        return j == 0 ? 0 : 1;
    }

    public static String toBinaryString(long j) {
        return IntegralToString.longToBinaryString(j);
    }

    public static String toHexString(long j) {
        return IntegralToString.longToHexString(j);
    }

    public static String toOctalString(long j) {
        return IntegralToString.longToOctalString(j);
    }

    public static String toString(long j) {
        return IntegralToString.longToString(j);
    }

    public static String toString(long j, int i) {
        return IntegralToString.longToString(j, i);
    }

    public static Long valueOf(long j) {
        return (j >= 128 || j < -128) ? new Long(j) : SMALL_VALUES[((int) j) + 128];
    }

    public static Long valueOf(String str) throws NumberFormatException {
        return valueOf(parseLong(str));
    }

    public static Long valueOf(String str, int i) throws NumberFormatException {
        return valueOf(parseLong(str, i));
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return (byte) this.value;
    }

    @Override // java.lang.Comparable
    public int compareTo(Long l) {
        return compare(this.value, l.value);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Long) && ((Long) obj).value == this.value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) this.value;
    }

    public int hashCode() {
        return (int) (this.value ^ (this.value >>> 32));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
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
