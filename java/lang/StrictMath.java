package java.lang;

/* loaded from: source-2895416-dex2jar.jar:java/lang/StrictMath.class */
public final class StrictMath {
    public static final double E = 2.718281828459045d;
    public static final double PI = 3.141592653589793d;

    private StrictMath() {
    }

    public static native double IEEEremainder(double d, double d2);

    public static double abs(double d) {
        return Math.abs(d);
    }

    public static float abs(float f) {
        return Math.abs(f);
    }

    public static int abs(int i) {
        return Math.abs(i);
    }

    public static long abs(long j) {
        return Math.abs(j);
    }

    public static native double acos(double d);

    public static native double asin(double d);

    public static native double atan(double d);

    public static native double atan2(double d, double d2);

    public static native double cbrt(double d);

    public static native double ceil(double d);

    public static double copySign(double d, double d2) {
        long doubleToRawLongBits = Double.doubleToRawLongBits(d);
        double d3 = d2;
        if (d2 != d2) {
            d3 = 1.0d;
        }
        return Double.longBitsToDouble((Long.MAX_VALUE & doubleToRawLongBits) | (Long.MIN_VALUE & Double.doubleToRawLongBits(d3)));
    }

    public static float copySign(float f, float f2) {
        int floatToRawIntBits = Float.floatToRawIntBits(f);
        float f3 = f2;
        if (f2 != f2) {
            f3 = 1.0f;
        }
        return Float.intBitsToFloat((Integer.MAX_VALUE & floatToRawIntBits) | (Integer.MIN_VALUE & Float.floatToRawIntBits(f3)));
    }

    public static native double cos(double d);

    public static native double cosh(double d);

    public static native double exp(double d);

    public static native double expm1(double d);

    public static native double floor(double d);

    public static int getExponent(double d) {
        return Math.getExponent(d);
    }

    public static int getExponent(float f) {
        return Math.getExponent(f);
    }

    public static native double hypot(double d, double d2);

    public static native double log(double d);

    public static native double log10(double d);

    public static native double log1p(double d);

    public static double max(double d, double d2) {
        if (d <= d2) {
            if (d < d2) {
                return d2;
            }
            if (d != d2) {
                return Double.NaN;
            }
            if (d == 0.0d && (Double.doubleToLongBits(d) & Double.doubleToLongBits(d2) & Long.MIN_VALUE) == 0) {
                return 0.0d;
            }
        }
        return d;
    }

    public static float max(float f, float f2) {
        if (f <= f2) {
            if (f < f2) {
                return f2;
            }
            if (f != f2) {
                return Float.NaN;
            }
            if (f == 0.0f && (Float.floatToIntBits(f) & Float.floatToIntBits(f2) & Integer.MIN_VALUE) == 0) {
                return 0.0f;
            }
        }
        return f;
    }

    public static int max(int i, int i2) {
        return Math.max(i, i2);
    }

    public static long max(long j, long j2) {
        return j > j2 ? j : j2;
    }

    public static double min(double d, double d2) {
        double d3;
        if (d > d2) {
            d3 = d2;
        } else {
            d3 = d;
            if (d >= d2) {
                if (d != d2) {
                    return Double.NaN;
                }
                d3 = d;
                if (d == 0.0d) {
                    d3 = d;
                    if (((Double.doubleToLongBits(d) | Double.doubleToLongBits(d2)) & Long.MIN_VALUE) != 0) {
                        return 0.0d;
                    }
                }
            }
        }
        return d3;
    }

    public static float min(float f, float f2) {
        float f3;
        if (f > f2) {
            f3 = f2;
        } else {
            f3 = f;
            if (f >= f2) {
                if (f != f2) {
                    return Float.NaN;
                }
                f3 = f;
                if (f == 0.0f) {
                    f3 = f;
                    if (((Float.floatToIntBits(f) | Float.floatToIntBits(f2)) & Integer.MIN_VALUE) != 0) {
                        return 0.0f;
                    }
                }
            }
        }
        return f3;
    }

    public static int min(int i, int i2) {
        return Math.min(i, i2);
    }

    public static long min(long j, long j2) {
        return j < j2 ? j : j2;
    }

    public static double nextAfter(double d, double d2) {
        return (d == 0.0d && d2 == 0.0d) ? d2 : nextafter(d, d2);
    }

    public static float nextAfter(float f, double d) {
        return Math.nextAfter(f, d);
    }

    public static double nextUp(double d) {
        return Math.nextUp(d);
    }

    public static float nextUp(float f) {
        return Math.nextUp(f);
    }

    private static native double nextafter(double d, double d2);

    public static native double pow(double d, double d2);

    public static double random() {
        return Math.random();
    }

    public static native double rint(double d);

    public static int round(float f) {
        return Math.round(f);
    }

    public static long round(double d) {
        return Math.round(d);
    }

    public static double scalb(double d, int i) {
        long j;
        if (Double.isNaN(d) || Double.isInfinite(d) || d == 0.0d) {
            return d;
        }
        long doubleToLongBits = Double.doubleToLongBits(d);
        long j2 = (((int) ((9218868437227405312L & doubleToLongBits) >> 52)) - 1023) + i;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(Long.MAX_VALUE & doubleToLongBits) - 12;
        int i2 = numberOfLeadingZeros;
        if (numberOfLeadingZeros < 0) {
            i2 = 0;
        }
        long j3 = j2;
        if (Math.abs(d) < Double.MIN_NORMAL) {
            j3 = j2 - i2;
        }
        if (j3 > 1023) {
            return d > 0.0d ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }
        if (j3 < -1023) {
            long j4 = 1023 + j3 + i2;
            j = Math.abs(d) < Double.MIN_NORMAL ? shiftLongBits(4503599627370495L & doubleToLongBits, j4) : shiftLongBits((4503599627370495L & doubleToLongBits) | 4503599627370496L, j4 - 1);
        } else {
            j = Math.abs(d) >= Double.MIN_NORMAL ? ((1023 + j3) << 52) | (4503599627370495L & doubleToLongBits) : ((1023 + j3) << 52) | ((doubleToLongBits << (i2 + 1)) & 4503599627370495L);
        }
        return Double.longBitsToDouble(j | (doubleToLongBits & Long.MIN_VALUE));
    }

    public static float scalb(float f, int i) {
        int i2;
        if (Float.isNaN(f) || Float.isInfinite(f) || f == 0.0f) {
            return f;
        }
        int floatToIntBits = Float.floatToIntBits(f);
        int i3 = (((2139095040 & floatToIntBits) >> 23) - 127) + i;
        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(Integer.MAX_VALUE & floatToIntBits) - 9;
        int i4 = numberOfLeadingZeros;
        if (numberOfLeadingZeros < 0) {
            i4 = 0;
        }
        int i5 = i3;
        if (Math.abs(f) < Float.MIN_NORMAL) {
            i5 = i3 - i4;
        }
        if (i5 > 127) {
            return f > 0.0f ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
        }
        if (i5 < -127) {
            int i6 = i5 + 127 + i4;
            i2 = Math.abs(f) < Float.MIN_NORMAL ? shiftIntBits(floatToIntBits & 8388607, i6) : shiftIntBits((floatToIntBits & 8388607) | 8388608, i6 - 1);
        } else {
            i2 = Math.abs(f) >= Float.MIN_NORMAL ? ((i5 + 127) << 23) | (floatToIntBits & 8388607) : ((i5 + 127) << 23) | ((floatToIntBits << (i4 + 1)) & 8388607);
        }
        return Float.intBitsToFloat(i2 | (floatToIntBits & Integer.MIN_VALUE));
    }

    private static int shiftIntBits(int i, int i2) {
        if (i2 > 0) {
            return i << i2;
        }
        int i3 = -i2;
        if (Integer.numberOfLeadingZeros(Integer.MAX_VALUE & i) <= 32 - i3) {
            return (((i >> (i3 - 1)) & 1) == 0 || Integer.numberOfTrailingZeros(i) == i3 - 1) ? i >> i3 : (i >> i3) + 1;
        }
        return 0;
    }

    private static long shiftLongBits(long j, long j2) {
        long j3;
        if (j2 > 0) {
            j3 = j << ((int) j2);
        } else {
            long j4 = -j2;
            j3 = 0;
            if (Long.numberOfLeadingZeros(Long.MAX_VALUE & j) <= 64 - j4) {
                return (((j >> ((int) (j4 - 1))) & 1) == 0 || ((long) Long.numberOfTrailingZeros(j)) == j4 - 1) ? j >> ((int) j4) : (j >> ((int) j4)) + 1;
            }
        }
        return j3;
    }

    public static double signum(double d) {
        return Math.signum(d);
    }

    public static float signum(float f) {
        return Math.signum(f);
    }

    public static native double sin(double d);

    public static native double sinh(double d);

    public static native double sqrt(double d);

    public static native double tan(double d);

    public static native double tanh(double d);

    public static double toDegrees(double d) {
        return Math.toDegrees(d);
    }

    public static double toRadians(double d) {
        return Math.toRadians(d);
    }

    public static double ulp(double d) {
        if (Double.isInfinite(d)) {
            return Double.POSITIVE_INFINITY;
        }
        if (d == Double.MAX_VALUE || d == -1.7976931348623157E308d) {
            return pow(2.0d, 971.0d);
        }
        double abs = Math.abs(d);
        return nextafter(abs, Double.MAX_VALUE) - abs;
    }

    public static float ulp(float f) {
        return Math.ulp(f);
    }
}
