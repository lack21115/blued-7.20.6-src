package java.lang;

import java.util.Random;

/* loaded from: source-2895416-dex2jar.jar:java/lang/Math.class */
public final class Math {
    public static final double E = 2.718281828459045d;
    public static final double PI = 3.141592653589793d;
    private static Random random;

    private Math() {
    }

    public static native double IEEEremainder(double d, double d2);

    public static double abs(double d) {
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d) & Long.MAX_VALUE);
    }

    public static float abs(float f) {
        return Float.intBitsToFloat(Float.floatToRawIntBits(f) & Integer.MAX_VALUE);
    }

    public static int abs(int i) {
        return i >= 0 ? i : -i;
    }

    public static long abs(long j) {
        return j >= 0 ? j : -j;
    }

    public static native double acos(double d);

    public static native double asin(double d);

    public static native double atan(double d);

    public static native double atan2(double d, double d2);

    public static native double cbrt(double d);

    public static native double ceil(double d);

    public static double copySign(double d, double d2) {
        return Double.longBitsToDouble((Long.MAX_VALUE & Double.doubleToRawLongBits(d)) | (Long.MIN_VALUE & Double.doubleToRawLongBits(d2)));
    }

    public static float copySign(float f, float f2) {
        return Float.intBitsToFloat((Integer.MAX_VALUE & Float.floatToRawIntBits(f)) | (Integer.MIN_VALUE & Float.floatToRawIntBits(f2)));
    }

    public static native double cos(double d);

    public static native double cosh(double d);

    public static native double exp(double d);

    public static native double expm1(double d);

    public static native double floor(double d);

    public static int getExponent(double d) {
        return ((int) ((9218868437227405312L & Double.doubleToRawLongBits(d)) >> 52)) - 1023;
    }

    public static int getExponent(float f) {
        return ((2139095040 & Float.floatToRawIntBits(f)) >> 23) - 127;
    }

    public static native double hypot(double d, double d2);

    public static native double log(double d);

    public static native double log10(double d);

    public static native double log1p(double d);

    public static double max(double d, double d2) {
        double d3;
        if (d > d2) {
            d3 = d;
        } else {
            d3 = d2;
            if (d >= d2) {
                if (d != d2) {
                    return Double.NaN;
                }
                d3 = d2;
                if (Double.doubleToRawLongBits(d) == 0) {
                    return 0.0d;
                }
            }
        }
        return d3;
    }

    public static float max(float f, float f2) {
        float f3;
        if (f > f2) {
            f3 = f;
        } else {
            f3 = f2;
            if (f >= f2) {
                if (f != f2) {
                    return Float.NaN;
                }
                f3 = f2;
                if (Float.floatToRawIntBits(f) == 0) {
                    return 0.0f;
                }
            }
        }
        return f3;
    }

    public static int max(int i, int i2) {
        return i > i2 ? i : i2;
    }

    public static long max(long j, long j2) {
        return j > j2 ? j : j2;
    }

    public static double min(double d, double d2) {
        if (d <= d2) {
            if (d < d2) {
                return d;
            }
            if (d != d2) {
                return Double.NaN;
            }
            if (Double.doubleToRawLongBits(d) == Long.MIN_VALUE) {
                return 0.0d;
            }
        }
        return d2;
    }

    public static float min(float f, float f2) {
        if (f <= f2) {
            if (f < f2) {
                return f;
            }
            if (f != f2) {
                return Float.NaN;
            }
            if (Float.floatToRawIntBits(f) == Integer.MIN_VALUE) {
                return 0.0f;
            }
        }
        return f2;
    }

    public static int min(int i, int i2) {
        return i < i2 ? i : i2;
    }

    public static long min(long j, long j2) {
        return j < j2 ? j : j2;
    }

    public static double nextAfter(double d, double d2) {
        return (d == 0.0d && d2 == 0.0d) ? d2 : nextafter(d, d2);
    }

    public static float nextAfter(float f, double d) {
        float f2 = 0.0f;
        if (Float.isNaN(f) || Double.isNaN(d)) {
            f2 = Float.NaN;
        } else if (f == 0.0f && d == 0.0d) {
            return (float) d;
        } else {
            if ((f != Float.MIN_VALUE || d >= f) && (f != -1.4E-45f || d <= f)) {
                if (Float.isInfinite(f) && d != f) {
                    return f > 0.0f ? Float.MAX_VALUE : -3.4028235E38f;
                } else if ((f == Float.MAX_VALUE && d > f) || (f == -3.4028235E38f && d < f)) {
                    return f > 0.0f ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
                } else if (d > f) {
                    if (f > 0.0f) {
                        return Float.intBitsToFloat(Float.floatToIntBits(f) + 1);
                    }
                    if (f < 0.0f) {
                        return Float.intBitsToFloat(Float.floatToIntBits(f) - 1);
                    }
                    return Float.MIN_VALUE;
                } else if (d < f) {
                    if (f > 0.0f) {
                        return Float.intBitsToFloat(Float.floatToIntBits(f) - 1);
                    }
                    if (f < 0.0f) {
                        return Float.intBitsToFloat(Float.floatToIntBits(f) + 1);
                    }
                    return -1.4E-45f;
                } else {
                    return (float) d;
                }
            } else if (f <= 0.0f) {
                return 0.0f;
            }
        }
        return f2;
    }

    public static double nextUp(double d) {
        double d2 = Double.POSITIVE_INFINITY;
        if (Double.isNaN(d)) {
            d2 = Double.NaN;
        } else if (d != Double.POSITIVE_INFINITY) {
            if (d == 0.0d) {
                return Double.MIN_VALUE;
            }
            return d > 0.0d ? Double.longBitsToDouble(Double.doubleToLongBits(d) + 1) : Double.longBitsToDouble(Double.doubleToLongBits(d) - 1);
        }
        return d2;
    }

    public static float nextUp(float f) {
        float f2 = Float.POSITIVE_INFINITY;
        if (Float.isNaN(f)) {
            f2 = Float.NaN;
        } else if (f != Float.POSITIVE_INFINITY) {
            if (f == 0.0f) {
                return Float.MIN_VALUE;
            }
            return f > 0.0f ? Float.intBitsToFloat(Float.floatToIntBits(f) + 1) : Float.intBitsToFloat(Float.floatToIntBits(f) - 1);
        }
        return f2;
    }

    private static native double nextafter(double d, double d2);

    public static native double pow(double d, double d2);

    public static double random() {
        double nextDouble;
        synchronized (Math.class) {
            try {
                if (random == null) {
                    random = new Random();
                }
                nextDouble = random.nextDouble();
            } catch (Throwable th) {
                throw th;
            }
        }
        return nextDouble;
    }

    public static native double rint(double d);

    public static int round(float f) {
        if (f != f) {
            return 0;
        }
        return (int) floor(0.5f + f);
    }

    public static long round(double d) {
        if (d != d) {
            return 0L;
        }
        return (long) floor(0.5d + d);
    }

    public static double scalb(double d, int i) {
        long j;
        if (Double.isNaN(d) || Double.isInfinite(d) || d == 0.0d) {
            return d;
        }
        long doubleToLongBits = Double.doubleToLongBits(d);
        long j2 = (((9218868437227405312L & doubleToLongBits) >> 52) - 1023) + i;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(Long.MAX_VALUE & doubleToLongBits) - 12;
        if (numberOfLeadingZeros < 0) {
            numberOfLeadingZeros = 0;
        } else {
            j2 -= numberOfLeadingZeros;
        }
        if (j2 > 1023) {
            return d > 0.0d ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }
        if (j2 <= -1023) {
            long j3 = 1023 + j2 + numberOfLeadingZeros;
            j = abs(d) < Double.MIN_NORMAL ? shiftLongBits(4503599627370495L & doubleToLongBits, j3) : shiftLongBits((4503599627370495L & doubleToLongBits) | 4503599627370496L, j3 - 1);
        } else {
            j = abs(d) >= Double.MIN_NORMAL ? ((1023 + j2) << 52) | (4503599627370495L & doubleToLongBits) : ((1023 + j2) << 52) | ((doubleToLongBits << (numberOfLeadingZeros + 1)) & 4503599627370495L);
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
        if (numberOfLeadingZeros < 0) {
            numberOfLeadingZeros = 0;
        } else {
            i3 -= numberOfLeadingZeros;
        }
        if (i3 > 127) {
            return f > 0.0f ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
        }
        if (i3 <= -127) {
            int i4 = i3 + 127 + numberOfLeadingZeros;
            i2 = abs(f) < Float.MIN_NORMAL ? shiftIntBits(floatToIntBits & 8388607, i4) : shiftIntBits((floatToIntBits & 8388607) | 8388608, i4 - 1);
        } else {
            i2 = abs(f) >= Float.MIN_NORMAL ? ((i3 + 127) << 23) | (floatToIntBits & 8388607) : ((i3 + 127) << 23) | ((floatToIntBits << (numberOfLeadingZeros + 1)) & 8388607);
        }
        return Float.intBitsToFloat(i2 | (floatToIntBits & Integer.MIN_VALUE));
    }

    private static int shiftIntBits(int i, int i2) {
        int i3;
        if (i2 > 0) {
            i3 = i << i2;
        } else {
            int i4 = -i2;
            if (Integer.numberOfLeadingZeros(Integer.MAX_VALUE & i) > 32 - i4) {
                return 0;
            }
            int i5 = i >> i4;
            i3 = i5;
            if (((i >> (i4 - 1)) & 1) == 1) {
                int i6 = i5;
                if (Integer.numberOfTrailingZeros(i) < i4 - 1) {
                    i6 = i5 + 1;
                }
                i3 = i6;
                if (Integer.numberOfTrailingZeros(i) == i4 - 1) {
                    i3 = i6;
                    if ((i6 & 1) == 1) {
                        return i6 + 1;
                    }
                }
            }
        }
        return i3;
    }

    private static long shiftLongBits(long j, long j2) {
        long j3;
        if (j2 > 0) {
            j3 = j << ((int) j2);
        } else {
            long j4 = -j2;
            j3 = 0;
            if (Long.numberOfLeadingZeros(Long.MAX_VALUE & j) <= 64 - j4) {
                long j5 = j >> ((int) j4);
                j3 = j5;
                if (((j >> ((int) (j4 - 1))) & 1) == 1) {
                    long j6 = j5;
                    if (Long.numberOfTrailingZeros(j) < j4 - 1) {
                        j6 = j5 + 1;
                    }
                    j3 = j6;
                    if (Long.numberOfTrailingZeros(j) == j4 - 1) {
                        j3 = j6;
                        if ((j6 & 1) == 1) {
                            return j6 + 1;
                        }
                    }
                }
            }
        }
        return j3;
    }

    public static double signum(double d) {
        double d2;
        if (Double.isNaN(d)) {
            d2 = Double.NaN;
        } else {
            d2 = d;
            if (d > 0.0d) {
                return 1.0d;
            }
            if (d < 0.0d) {
                return -1.0d;
            }
        }
        return d2;
    }

    public static float signum(float f) {
        float f2;
        if (Float.isNaN(f)) {
            f2 = Float.NaN;
        } else {
            f2 = f;
            if (f > 0.0f) {
                return 1.0f;
            }
            if (f < 0.0f) {
                return -1.0f;
            }
        }
        return f2;
    }

    public static native double sin(double d);

    public static native double sinh(double d);

    public static native double sqrt(double d);

    public static native double tan(double d);

    public static native double tanh(double d);

    public static double toDegrees(double d) {
        return (180.0d * d) / 3.141592653589793d;
    }

    public static double toRadians(double d) {
        return (d / 180.0d) * 3.141592653589793d;
    }

    public static double ulp(double d) {
        if (Double.isInfinite(d)) {
            return Double.POSITIVE_INFINITY;
        }
        if (d == Double.MAX_VALUE || d == -1.7976931348623157E308d) {
            return pow(2.0d, 971.0d);
        }
        double abs = abs(d);
        return nextafter(abs, Double.MAX_VALUE) - abs;
    }

    public static float ulp(float f) {
        boolean z = true;
        if (Float.isNaN(f)) {
            return Float.NaN;
        }
        if (Float.isInfinite(f)) {
            return Float.POSITIVE_INFINITY;
        }
        if (f == Float.MAX_VALUE || f == -3.4028235E38f) {
            return (float) pow(2.0d, 104.0d);
        }
        float abs = abs(f);
        int floatToRawIntBits = Float.floatToRawIntBits(abs);
        int floatToRawIntBits2 = Float.floatToRawIntBits(Float.MAX_VALUE);
        if ((Integer.MAX_VALUE & floatToRawIntBits) == 0) {
            return Float.intBitsToFloat((Integer.MIN_VALUE & floatToRawIntBits2) | 1);
        }
        boolean z2 = floatToRawIntBits > 0;
        if (floatToRawIntBits <= floatToRawIntBits2) {
            z = false;
        }
        return Float.intBitsToFloat(z ^ z2 ? floatToRawIntBits + 1 : floatToRawIntBits - 1) - abs;
    }
}
