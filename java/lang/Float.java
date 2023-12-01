package java.lang;

/* loaded from: source-2895416-dex2jar.jar:java/lang/Float.class */
public final class Float extends Number implements Comparable<Float> {
    static final int EXPONENT_BIAS = 127;
    static final int EXPONENT_BITS = 9;
    static final int EXPONENT_MASK = 2139095040;
    static final int MANTISSA_BITS = 23;
    static final int MANTISSA_MASK = 8388607;
    public static final int MAX_EXPONENT = 127;
    public static final float MAX_VALUE = Float.MAX_VALUE;
    public static final int MIN_EXPONENT = -126;
    public static final float MIN_NORMAL = Float.MIN_NORMAL;
    public static final float MIN_VALUE = Float.MIN_VALUE;
    public static final float NEGATIVE_INFINITY = Float.NEGATIVE_INFINITY;
    static final int NON_MANTISSA_BITS = 9;
    public static final float NaN = Float.NaN;
    public static final float POSITIVE_INFINITY = Float.POSITIVE_INFINITY;
    static final int SIGN_MASK = Integer.MIN_VALUE;
    public static final int SIZE = 32;
    public static final Class<Float> TYPE = float[].class.getComponentType();
    private static final long serialVersionUID = -2671257302660747028L;
    private final float value;

    public Float(double d) {
        this.value = (float) d;
    }

    public Float(float f) {
        this.value = f;
    }

    public Float(String str) throws NumberFormatException {
        this(parseFloat(str));
    }

    public static int compare(float f, float f2) {
        if (f > f2) {
            return 1;
        }
        if (f2 > f) {
            return -1;
        }
        if (f != f2 || 0.0f == f) {
            if (isNaN(f)) {
                return isNaN(f2) ? 0 : 1;
            } else if (isNaN(f2)) {
                return -1;
            } else {
                return (floatToRawIntBits(f) >> 31) - (floatToRawIntBits(f2) >> 31);
            }
        }
        return 0;
    }

    public static int floatToIntBits(float f) {
        if (f != f) {
            return 2143289344;
        }
        return floatToRawIntBits(f);
    }

    public static native int floatToRawIntBits(float f);

    public static native float intBitsToFloat(int i);

    public static boolean isInfinite(float f) {
        return f == Float.POSITIVE_INFINITY || f == Float.NEGATIVE_INFINITY;
    }

    public static boolean isNaN(float f) {
        return f != f;
    }

    public static float parseFloat(String str) throws NumberFormatException {
        return StringToReal.parseFloat(str);
    }

    public static String toHexString(float f) {
        int i;
        int i2;
        if (f != f) {
            return "NaN";
        }
        if (f == Float.POSITIVE_INFINITY) {
            return "Infinity";
        }
        if (f == Float.NEGATIVE_INFINITY) {
            return "-Infinity";
        }
        int floatToIntBits = floatToIntBits(f);
        boolean z = (Integer.MIN_VALUE & floatToIntBits) != 0;
        int i3 = (EXPONENT_MASK & floatToIntBits) >>> 23;
        int i4 = (MANTISSA_MASK & floatToIntBits) << 1;
        if (i3 == 0 && i4 == 0) {
            return z ? "-0x0.0p0" : "0x0.0p0";
        }
        StringBuilder sb = new StringBuilder(10);
        if (z) {
            sb.append("-0x");
        } else {
            sb.append("0x");
        }
        if (i3 == 0) {
            sb.append("0.");
            int i5 = i4;
            int i6 = 6;
            while (true) {
                i2 = i6;
                if (i5 == 0 || (i5 & 15) != 0) {
                    break;
                }
                i5 >>>= 4;
                i6 = i2 - 1;
            }
            String hexString = Integer.toHexString(i5);
            if (i5 != 0 && i2 > hexString.length()) {
                int i7 = i2;
                int length = hexString.length();
                while (true) {
                    int i8 = i7 - length;
                    if (i8 == 0) {
                        break;
                    }
                    sb.append('0');
                    i7 = i8;
                    length = 1;
                }
            }
            sb.append(hexString);
            sb.append("p-126");
        } else {
            sb.append("1.");
            int i9 = i4;
            int i10 = 6;
            while (true) {
                i = i10;
                if (i9 == 0 || (i9 & 15) != 0) {
                    break;
                }
                i9 >>>= 4;
                i10 = i - 1;
            }
            String hexString2 = Integer.toHexString(i9);
            if (i9 != 0 && i > hexString2.length()) {
                int i11 = i;
                int length2 = hexString2.length();
                while (true) {
                    int i12 = i11 - length2;
                    if (i12 == 0) {
                        break;
                    }
                    sb.append('0');
                    i11 = i12;
                    length2 = 1;
                }
            }
            sb.append(hexString2);
            sb.append('p');
            sb.append(i3 - 127);
        }
        return sb.toString();
    }

    public static String toString(float f) {
        return RealToString.getInstance().floatToString(f);
    }

    public static Float valueOf(float f) {
        return new Float(f);
    }

    public static Float valueOf(String str) throws NumberFormatException {
        return valueOf(parseFloat(str));
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return (byte) this.value;
    }

    @Override // java.lang.Comparable
    public int compareTo(Float f) {
        return compare(this.value, f.value);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Float) && floatToIntBits(this.value) == floatToIntBits(((Float) obj).value);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    public int hashCode() {
        return floatToIntBits(this.value);
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
