package java.lang;

/* loaded from: source-2895416-dex2jar.jar:java/lang/Double.class */
public final class Double extends Number implements Comparable<Double> {
    static final int EXPONENT_BIAS = 1023;
    static final int EXPONENT_BITS = 12;
    static final long EXPONENT_MASK = 9218868437227405312L;
    static final int MANTISSA_BITS = 52;
    static final long MANTISSA_MASK = 4503599627370495L;
    public static final int MAX_EXPONENT = 1023;
    public static final double MAX_VALUE = Double.MAX_VALUE;
    public static final int MIN_EXPONENT = -1022;
    public static final double MIN_NORMAL = Double.MIN_NORMAL;
    public static final double MIN_VALUE = Double.MIN_VALUE;
    public static final double NEGATIVE_INFINITY = Double.NEGATIVE_INFINITY;
    static final int NON_MANTISSA_BITS = 12;
    public static final double NaN = Double.NaN;
    public static final double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;
    static final long SIGN_MASK = Long.MIN_VALUE;
    public static final int SIZE = 64;
    public static final Class<Double> TYPE = double[].class.getComponentType();
    private static final long serialVersionUID = -9172774392245257468L;
    private final double value;

    public Double(double d) {
        this.value = d;
    }

    public Double(String str) throws NumberFormatException {
        this(parseDouble(str));
    }

    public static int compare(double d, double d2) {
        if (d > d2) {
            return 1;
        }
        if (d2 > d) {
            return -1;
        }
        if (d != d2 || 0.0d == d) {
            if (isNaN(d)) {
                return isNaN(d2) ? 0 : 1;
            } else if (isNaN(d2)) {
                return -1;
            } else {
                return (int) ((doubleToRawLongBits(d) >> 63) - (doubleToRawLongBits(d2) >> 63));
            }
        }
        return 0;
    }

    public static long doubleToLongBits(double d) {
        if (d != d) {
            return 9221120237041090560L;
        }
        return doubleToRawLongBits(d);
    }

    public static native long doubleToRawLongBits(double d);

    public static boolean isInfinite(double d) {
        return d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY;
    }

    public static boolean isNaN(double d) {
        return d != d;
    }

    public static native double longBitsToDouble(long j);

    public static double parseDouble(String str) throws NumberFormatException {
        return StringToReal.parseDouble(str);
    }

    public static String toHexString(double d) {
        int i;
        int i2;
        if (d != d) {
            return "NaN";
        }
        if (d == Double.POSITIVE_INFINITY) {
            return "Infinity";
        }
        if (d == Double.NEGATIVE_INFINITY) {
            return "-Infinity";
        }
        long doubleToLongBits = doubleToLongBits(d);
        boolean z = (Long.MIN_VALUE & doubleToLongBits) != 0;
        long j = (EXPONENT_MASK & doubleToLongBits) >>> 52;
        long j2 = doubleToLongBits & MANTISSA_MASK;
        if (j == 0 && j2 == 0) {
            return z ? "-0x0.0p0" : "0x0.0p0";
        }
        StringBuilder sb = new StringBuilder(10);
        if (z) {
            sb.append("-0x");
        } else {
            sb.append("0x");
        }
        if (j == 0) {
            sb.append("0.");
            int i3 = 13;
            while (true) {
                i2 = i3;
                if (j2 == 0 || (15 & j2) != 0) {
                    break;
                }
                j2 >>>= 4;
                i3 = i2 - 1;
            }
            String hexString = Long.toHexString(j2);
            if (j2 != 0 && i2 > hexString.length()) {
                int i4 = i2;
                int length = hexString.length();
                while (true) {
                    int i5 = i4 - length;
                    if (i5 == 0) {
                        break;
                    }
                    sb.append('0');
                    i4 = i5;
                    length = 1;
                }
            }
            sb.append(hexString);
            sb.append("p-1022");
        } else {
            sb.append("1.");
            int i6 = 13;
            while (true) {
                i = i6;
                if (j2 == 0 || (15 & j2) != 0) {
                    break;
                }
                j2 >>>= 4;
                i6 = i - 1;
            }
            String hexString2 = Long.toHexString(j2);
            if (j2 != 0 && i > hexString2.length()) {
                int i7 = i;
                int length2 = hexString2.length();
                while (true) {
                    int i8 = i7 - length2;
                    if (i8 == 0) {
                        break;
                    }
                    sb.append('0');
                    i7 = i8;
                    length2 = 1;
                }
            }
            sb.append(hexString2);
            sb.append('p');
            sb.append(Long.toString(j - 1023));
        }
        return sb.toString();
    }

    public static String toString(double d) {
        return RealToString.getInstance().doubleToString(d);
    }

    public static Double valueOf(double d) {
        return new Double(d);
    }

    public static Double valueOf(String str) throws NumberFormatException {
        return valueOf(parseDouble(str));
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return (byte) this.value;
    }

    @Override // java.lang.Comparable
    public int compareTo(Double d) {
        return compare(this.value, d.value);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Double) && doubleToLongBits(this.value) == doubleToLongBits(((Double) obj).value);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) this.value;
    }

    public int hashCode() {
        long doubleToLongBits = doubleToLongBits(this.value);
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return isInfinite(this.value);
    }

    public boolean isNaN() {
        return isNaN(this.value);
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) this.value;
    }

    @Override // java.lang.Number
    public short shortValue() {
        return (short) this.value;
    }

    public String toString() {
        return toString(this.value);
    }
}
