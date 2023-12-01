package java.lang;

import libcore.math.MathUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/lang/RealToString.class */
public final class RealToString {
    private static final ThreadLocal<RealToString> INSTANCE = new ThreadLocal<RealToString>() { // from class: java.lang.RealToString.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public RealToString initialValue() {
            return new RealToString();
        }
    };
    private static final double invLogOfTenBaseTwo = Math.log(2.0d) / Math.log(10.0d);
    private int digitCount;
    private final int[] digits;
    private int firstK;

    private RealToString() {
        this.digits = new int[64];
    }

    private native void bigIntDigitGenerator(long j, int i, boolean z, int i2);

    private String convertDouble(AbstractStringBuilder abstractStringBuilder, double d) {
        String str;
        long j;
        int i;
        int i2;
        long doubleToRawLongBits = Double.doubleToRawLongBits(d);
        boolean z = (Long.MIN_VALUE & doubleToRawLongBits) == 0;
        int i3 = (int) ((9218868437227405312L & doubleToRawLongBits) >> 52);
        long j2 = doubleToRawLongBits & 4503599627370495L;
        boolean z2 = j2 == 0;
        if (i3 == 2047) {
            str = z2 ? z ? "Infinity" : "-Infinity" : "NaN";
        } else {
            str = null;
            if (i3 == 0) {
                if (z2) {
                    str = z ? "0.0" : "-0.0";
                } else {
                    str = null;
                    if (j2 == 1) {
                        str = z ? "4.9E-324" : "-4.9E-324";
                    }
                }
            }
        }
        if (str != null) {
            return resultOrSideEffect(abstractStringBuilder, str);
        }
        int i4 = 52;
        if (i3 == 0) {
            int i5 = 1 - 1075;
            long j3 = j2;
            while (true) {
                j = j2;
                i = i5;
                i2 = i4;
                if ((4503599627370496L & j3) != 0) {
                    break;
                }
                j3 <<= 1;
                i4--;
            }
        } else {
            j = j2 | 4503599627370496L;
            i = i3 - 1075;
            i2 = 52;
        }
        this.digitCount = 0;
        this.firstK = 0;
        if ((-59 >= i || i >= 6) && (i != -59 || z2)) {
            bigIntDigitGenerator(j, i, i3 == 0, i2);
        } else {
            longDigitGenerator(j, i, i3 == 0, z2, i2);
        }
        StringBuilder sb = abstractStringBuilder != null ? abstractStringBuilder : new StringBuilder(26);
        if (d >= 1.0E7d || d <= -1.0E7d || (d > -0.001d && d < 0.001d)) {
            freeFormatExponential(sb, z);
        } else {
            freeFormat(sb, z);
        }
        if (abstractStringBuilder != null) {
            return null;
        }
        return sb.toString();
    }

    private void freeFormat(AbstractStringBuilder abstractStringBuilder, boolean z) {
        int i;
        int i2;
        if (!z) {
            abstractStringBuilder.append0('-');
        }
        int i3 = this.firstK;
        if (i3 < 0) {
            abstractStringBuilder.append0('0');
            abstractStringBuilder.append0('.');
            int i4 = i3;
            while (true) {
                int i5 = i4 + 1;
                if (i5 >= 0) {
                    break;
                }
                abstractStringBuilder.append0('0');
                i4 = i5;
            }
        }
        int i6 = 0 + 1;
        int i7 = this.digits[0];
        while (true) {
            if (i7 != -1) {
                abstractStringBuilder.append0((char) (i7 + 48));
            } else if (i3 >= -1) {
                abstractStringBuilder.append0('0');
            }
            if (i3 == 0) {
                abstractStringBuilder.append0('.');
            }
            int i8 = i3 - 1;
            if (i6 < this.digitCount) {
                i = i6 + 1;
                i2 = this.digits[i6];
            } else {
                i = i6;
                i2 = -1;
            }
            if (i2 == -1 && i8 < -1) {
                return;
            }
            int i9 = i;
            i7 = i2;
            i6 = i9;
            i3 = i8;
        }
    }

    private void freeFormatExponential(AbstractStringBuilder abstractStringBuilder, boolean z) {
        if (!z) {
            abstractStringBuilder.append0('-');
        }
        abstractStringBuilder.append0((char) (this.digits[0] + 48));
        abstractStringBuilder.append0('.');
        int i = this.firstK;
        int i2 = 0 + 1;
        int i3 = i;
        while (true) {
            i3--;
            if (i2 >= this.digitCount) {
                break;
            }
            abstractStringBuilder.append0((char) (this.digits[i2] + 48));
            i2++;
        }
        if (i3 == i - 1) {
            abstractStringBuilder.append0('0');
        }
        abstractStringBuilder.append0('E');
        IntegralToString.appendInt(abstractStringBuilder, i);
    }

    public static RealToString getInstance() {
        return INSTANCE.get();
    }

    private void longDigitGenerator(long j, int i, boolean z, boolean z2, int i2) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        int i3;
        boolean z3;
        boolean z4;
        if (i >= 0) {
            j2 = 1 << i;
            if (z2) {
                j3 = j << (i + 2);
                j4 = 4;
            } else {
                j3 = j << (i + 1);
                j4 = 2;
            }
        } else {
            j2 = 1;
            if (z || !z2) {
                j3 = j << 1;
                j4 = 1 << (1 - i);
            } else {
                j3 = j << 2;
                j4 = 1 << (2 - i);
            }
        }
        int ceil = (int) Math.ceil((((i + i2) - 1) * invLogOfTenBaseTwo) - 1.0E-10d);
        if (ceil > 0) {
            j7 = j4 * MathUtils.LONG_POWERS_OF_TEN[ceil];
            j6 = j3;
            j5 = j2;
        } else {
            j5 = j2;
            j6 = j3;
            j7 = j4;
            if (ceil < 0) {
                j5 = MathUtils.LONG_POWERS_OF_TEN[-ceil];
                j6 = j3 * j5;
                if (j2 != 1) {
                    j5 = j2 * j5;
                }
                j7 = j4;
            }
        }
        if (j6 + j5 > j7) {
            this.firstK = ceil;
            j8 = j6;
        } else {
            this.firstK = ceil - 1;
            j8 = j6 * 10;
            j5 *= 10;
        }
        while (true) {
            i3 = 0;
            int i4 = 3;
            while (i4 >= 0) {
                long j9 = j8 - (j7 << i4);
                int i5 = i3;
                if (j9 >= 0) {
                    j8 = j9;
                    i5 = i3 + (1 << i4);
                }
                i4--;
                i3 = i5;
            }
            z3 = j8 < j5;
            z4 = j8 + j5 > j7;
            if (z3 || z4) {
                break;
            }
            j8 *= 10;
            j5 *= 10;
            int[] iArr = this.digits;
            int i6 = this.digitCount;
            this.digitCount = i6 + 1;
            iArr[i6] = i3;
        }
        if (z3 && !z4) {
            int[] iArr2 = this.digits;
            int i7 = this.digitCount;
            this.digitCount = i7 + 1;
            iArr2[i7] = i3;
        } else if (z4 && !z3) {
            int[] iArr3 = this.digits;
            int i8 = this.digitCount;
            this.digitCount = i8 + 1;
            iArr3[i8] = i3 + 1;
        } else if ((j8 << 1) < j7) {
            int[] iArr4 = this.digits;
            int i9 = this.digitCount;
            this.digitCount = i9 + 1;
            iArr4[i9] = i3;
        } else {
            int[] iArr5 = this.digits;
            int i10 = this.digitCount;
            this.digitCount = i10 + 1;
            iArr5[i10] = i3 + 1;
        }
    }

    private static String resultOrSideEffect(AbstractStringBuilder abstractStringBuilder, String str) {
        String str2 = str;
        if (abstractStringBuilder != null) {
            abstractStringBuilder.append0(str);
            str2 = null;
        }
        return str2;
    }

    public void appendDouble(AbstractStringBuilder abstractStringBuilder, double d) {
        convertDouble(abstractStringBuilder, d);
    }

    public void appendFloat(AbstractStringBuilder abstractStringBuilder, float f) {
        convertFloat(abstractStringBuilder, f);
    }

    public String convertFloat(AbstractStringBuilder abstractStringBuilder, float f) {
        String str;
        int i;
        int i2;
        int i3;
        int floatToRawIntBits = Float.floatToRawIntBits(f);
        boolean z = (Integer.MIN_VALUE & floatToRawIntBits) == 0;
        int i4 = (2139095040 & floatToRawIntBits) >> 23;
        int i5 = floatToRawIntBits & 8388607;
        boolean z2 = i5 == 0;
        if (i4 == 255) {
            str = z2 ? z ? "Infinity" : "-Infinity" : "NaN";
        } else {
            str = null;
            if (i4 == 0) {
                str = null;
                if (z2) {
                    str = z ? "0.0" : "-0.0";
                }
            }
        }
        if (str != null) {
            return resultOrSideEffect(abstractStringBuilder, str);
        }
        int i6 = 23;
        if (i4 == 0) {
            int i7 = 1 - 150;
            int i8 = i7;
            int i9 = i5;
            if (i5 < 8) {
                i9 = i5 << 2;
                i8 = i7 - 2;
            }
            int i10 = i9;
            while (true) {
                i2 = i8;
                i3 = i6;
                i = i9;
                if ((8388608 & i10) != 0) {
                    break;
                }
                i10 <<= 1;
                i6--;
            }
        } else {
            i = i5 | 8388608;
            i2 = i4 - 150;
            i3 = 23;
        }
        this.digitCount = 0;
        this.firstK = 0;
        if ((-59 >= i2 || i2 >= 35) && (i2 != -59 || z2)) {
            bigIntDigitGenerator(i, i2, i4 == 0, i3);
        } else {
            longDigitGenerator(i, i2, i4 == 0, z2, i3);
        }
        StringBuilder sb = abstractStringBuilder != null ? abstractStringBuilder : new StringBuilder(26);
        if (f >= 1.0E7f || f <= -1.0E7f || (f > -0.001f && f < 0.001f)) {
            freeFormatExponential(sb, z);
        } else {
            freeFormat(sb, z);
        }
        if (abstractStringBuilder != null) {
            return null;
        }
        return sb.toString();
    }

    public String doubleToString(double d) {
        return convertDouble(null, d);
    }

    public String floatToString(float f) {
        return convertFloat(null, f);
    }
}
