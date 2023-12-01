package java.math;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import libcore.math.MathUtils;

/* loaded from: source-2895416-dex2jar.jar:java/math/BigDecimal.class */
public class BigDecimal extends Number implements Comparable<BigDecimal>, Serializable {
    private static final int BI_SCALED_BY_ZERO_LENGTH = 11;
    private static final BigInteger[] FIVE_POW;
    private static final double LOG10_2 = 0.3010299956639812d;
    public static final BigDecimal ONE;
    public static final int ROUND_CEILING = 2;
    public static final int ROUND_DOWN = 1;
    public static final int ROUND_FLOOR = 3;
    public static final int ROUND_HALF_DOWN = 5;
    public static final int ROUND_HALF_EVEN = 6;
    public static final int ROUND_HALF_UP = 4;
    public static final int ROUND_UNNECESSARY = 7;
    public static final int ROUND_UP = 0;
    public static final BigDecimal TEN;
    private static final BigInteger[] TEN_POW;
    public static final BigDecimal ZERO;
    private static final long serialVersionUID = 6108874887143696463L;
    private transient int bitLength;
    private transient int hashCode;
    private BigInteger intVal;
    private transient int precision;
    private int scale;
    private transient long smallValue;
    private transient String toStringImage;
    private static final long[] LONG_FIVE_POW = {1, 5, 25, 125, 625, 3125, 15625, 78125, 390625, 1953125, 9765625, 48828125, 244140625, 1220703125, 6103515625L, 30517578125L, 152587890625L, 762939453125L, 3814697265625L, 19073486328125L, 95367431640625L, 476837158203125L, 2384185791015625L, 11920928955078125L, 59604644775390625L, 298023223876953125L, 1490116119384765625L, 7450580596923828125L};
    private static final int[] LONG_FIVE_POW_BIT_LENGTH = new int[LONG_FIVE_POW.length];
    private static final int[] LONG_POWERS_OF_TEN_BIT_LENGTH = new int[MathUtils.LONG_POWERS_OF_TEN.length];
    private static final BigDecimal[] BI_SCALED_BY_ZERO = new BigDecimal[11];
    private static final BigDecimal[] ZERO_SCALED_BY = new BigDecimal[11];
    private static final char[] CH_ZEROS = new char[100];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: java.math.BigDecimal$1  reason: invalid class name */
    /* loaded from: source-2895416-dex2jar.jar:java/math/BigDecimal$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode = new int[RoundingMode.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:43:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006b -> B:45:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x006f -> B:39:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0073 -> B:35:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0077 -> B:49:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007b -> B:47:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x007f -> B:41:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    static {
        Arrays.fill(CH_ZEROS, '0');
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= ZERO_SCALED_BY.length) {
                break;
            }
            BI_SCALED_BY_ZERO[i2] = new BigDecimal(i2, 0);
            ZERO_SCALED_BY[i2] = new BigDecimal(0, i2);
            i = i2 + 1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= LONG_FIVE_POW_BIT_LENGTH.length) {
                break;
            }
            LONG_FIVE_POW_BIT_LENGTH[i4] = bitLength(LONG_FIVE_POW[i4]);
            i3 = i4 + 1;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= LONG_POWERS_OF_TEN_BIT_LENGTH.length) {
                TEN_POW = Multiplication.bigTenPows;
                FIVE_POW = Multiplication.bigFivePows;
                ZERO = new BigDecimal(0, 0);
                ONE = new BigDecimal(1, 0);
                TEN = new BigDecimal(10, 0);
                return;
            }
            LONG_POWERS_OF_TEN_BIT_LENGTH[i6] = bitLength(MathUtils.LONG_POWERS_OF_TEN[i6]);
            i5 = i6 + 1;
        }
    }

    public BigDecimal(double d) {
        this.toStringImage = null;
        this.hashCode = 0;
        this.precision = 0;
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new NumberFormatException("Infinity or NaN: " + d);
        }
        long doubleToLongBits = Double.doubleToLongBits(d);
        this.scale = 1075 - ((int) ((doubleToLongBits >> 52) & 2047));
        long j = this.scale == 1075 ? (4503599627370495L & doubleToLongBits) << 1 : (4503599627370495L & doubleToLongBits) | 4503599627370496L;
        if (j == 0) {
            this.scale = 0;
            this.precision = 1;
        }
        long j2 = j;
        if (this.scale > 0) {
            int min = Math.min(this.scale, Long.numberOfTrailingZeros(j));
            j2 = j >>> min;
            this.scale -= min;
        }
        long j3 = (doubleToLongBits >> 63) != 0 ? -j2 : j2;
        int bitLength = bitLength(j3);
        if (this.scale < 0) {
            this.bitLength = bitLength == 0 ? 0 : bitLength - this.scale;
            if (this.bitLength < 64) {
                this.smallValue = j3 << (-this.scale);
            } else {
                BigInt bigInt = new BigInt();
                bigInt.putLongInt(j3);
                bigInt.shift(-this.scale);
                this.intVal = new BigInteger(bigInt);
            }
            this.scale = 0;
        } else if (this.scale <= 0) {
            this.smallValue = j3;
            this.bitLength = bitLength;
        } else if (this.scale >= LONG_FIVE_POW.length || LONG_FIVE_POW_BIT_LENGTH[this.scale] + bitLength >= 64) {
            setUnscaledValue(Multiplication.multiplyByFivePow(BigInteger.valueOf(j3), this.scale));
        } else {
            this.smallValue = LONG_FIVE_POW[this.scale] * j3;
            this.bitLength = bitLength(this.smallValue);
        }
    }

    public BigDecimal(double d, MathContext mathContext) {
        this(d);
        inplaceRound(mathContext);
    }

    public BigDecimal(int i) {
        this(i, 0);
    }

    private BigDecimal(int i, int i2) {
        this.toStringImage = null;
        this.hashCode = 0;
        this.precision = 0;
        this.smallValue = i;
        this.scale = i2;
        this.bitLength = bitLength(i);
    }

    public BigDecimal(int i, MathContext mathContext) {
        this(i, 0);
        inplaceRound(mathContext);
    }

    public BigDecimal(long j) {
        this(j, 0);
    }

    private BigDecimal(long j, int i) {
        this.toStringImage = null;
        this.hashCode = 0;
        this.precision = 0;
        this.smallValue = j;
        this.scale = i;
        this.bitLength = bitLength(j);
    }

    public BigDecimal(long j, MathContext mathContext) {
        this(j);
        inplaceRound(mathContext);
    }

    public BigDecimal(String str) {
        this(str.toCharArray(), 0, str.length());
    }

    public BigDecimal(String str, MathContext mathContext) {
        this(str.toCharArray(), 0, str.length());
        inplaceRound(mathContext);
    }

    public BigDecimal(BigInteger bigInteger) {
        this(bigInteger, 0);
    }

    public BigDecimal(BigInteger bigInteger, int i) {
        this.toStringImage = null;
        this.hashCode = 0;
        this.precision = 0;
        if (bigInteger == null) {
            throw new NullPointerException("unscaledVal == null");
        }
        this.scale = i;
        setUnscaledValue(bigInteger);
    }

    public BigDecimal(BigInteger bigInteger, int i, MathContext mathContext) {
        this(bigInteger, i);
        inplaceRound(mathContext);
    }

    public BigDecimal(BigInteger bigInteger, MathContext mathContext) {
        this(bigInteger);
        inplaceRound(mathContext);
    }

    public BigDecimal(char[] cArr) {
        this(cArr, 0, cArr.length);
    }

    public BigDecimal(char[] cArr, int i, int i2) {
        boolean z;
        int i3;
        this.toStringImage = null;
        this.hashCode = 0;
        this.precision = 0;
        int i4 = i + (i2 - 1);
        if (cArr == null) {
            throw new NullPointerException("in == null");
        }
        if (i4 >= cArr.length || i < 0 || i2 <= 0 || i4 < 0) {
            throw new NumberFormatException("Bad offset/length: offset=" + i + " len=" + i2 + " in.length=" + cArr.length);
        }
        StringBuilder sb = new StringBuilder(i2);
        int i5 = i;
        int i6 = i;
        if (i <= i4) {
            i5 = i;
            i6 = i;
            if (cArr[i] == '+') {
                i6 = i + 1;
                i5 = i + 1;
            }
        }
        int i7 = 0;
        boolean z2 = false;
        while (true) {
            z = z2;
            if (i6 > i4 || cArr[i6] == '.' || cArr[i6] == 'e' || cArr[i6] == 'E') {
                break;
            }
            int i8 = i7;
            boolean z3 = z;
            if (!z) {
                if (cArr[i6] == '0') {
                    i8 = i7 + 1;
                    z3 = z;
                } else {
                    z3 = true;
                    i8 = i7;
                }
            }
            i6++;
            i7 = i8;
            z2 = z3;
        }
        sb.append(cArr, i5, i6 - i5);
        int i9 = 0 + (i6 - i5);
        if (i6 > i4 || cArr[i6] != '.') {
            this.scale = 0;
            i3 = i9;
        } else {
            int i10 = i6 + 1;
            i6 = i10;
            while (i6 <= i4 && cArr[i6] != 'e' && cArr[i6] != 'E') {
                int i11 = i7;
                boolean z4 = z;
                if (!z) {
                    if (cArr[i6] == '0') {
                        i11 = i7 + 1;
                        z4 = z;
                    } else {
                        z4 = true;
                        i11 = i7;
                    }
                }
                i6++;
                i7 = i11;
                z = z4;
            }
            this.scale = i6 - i10;
            i3 = i9 + this.scale;
            sb.append(cArr, i10, this.scale);
        }
        if (i6 <= i4 && (cArr[i6] == 'e' || cArr[i6] == 'E')) {
            int i12 = i6 + 1;
            int i13 = i12;
            if (i12 <= i4) {
                i13 = i12;
                if (cArr[i12] == '+') {
                    int i14 = i12 + 1;
                    i13 = i12;
                    if (i14 <= i4) {
                        i13 = i12;
                        if (cArr[i14] != '-') {
                            i13 = i12 + 1;
                        }
                    }
                }
            }
            long parseInt = this.scale - Integer.parseInt(String.valueOf(cArr, i13, (i4 + 1) - i13));
            this.scale = (int) parseInt;
            if (parseInt != this.scale) {
                throw new NumberFormatException("Scale out of range");
            }
        }
        if (i3 >= 19) {
            setUnscaledValue(new BigInteger(sb.toString()));
            return;
        }
        this.smallValue = Long.parseLong(sb.toString());
        this.bitLength = bitLength(this.smallValue);
    }

    public BigDecimal(char[] cArr, int i, int i2, MathContext mathContext) {
        this(cArr, i, i2);
        inplaceRound(mathContext);
    }

    public BigDecimal(char[] cArr, MathContext mathContext) {
        this(cArr, 0, cArr.length);
        inplaceRound(mathContext);
    }

    private static BigDecimal addAndMult10(BigDecimal bigDecimal, BigDecimal bigDecimal2, int i) {
        if (i >= MathUtils.LONG_POWERS_OF_TEN.length || Math.max(bigDecimal.bitLength, bigDecimal2.bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[i]) + 1 >= 64) {
            BigInt bigInt = Multiplication.multiplyByTenPow(bigDecimal2.getUnscaledValue(), i).getBigInt();
            bigInt.add(bigDecimal.getUnscaledValue().getBigInt());
            return new BigDecimal(new BigInteger(bigInt), bigDecimal.scale);
        }
        return valueOf(bigDecimal.smallValue + (bigDecimal2.smallValue * MathUtils.LONG_POWERS_OF_TEN[i]), bigDecimal.scale);
    }

    private int approxPrecision() {
        return this.precision > 0 ? this.precision : ((int) ((this.bitLength - 1) * LOG10_2)) + 1;
    }

    private static int bitLength(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = i ^ (-1);
        }
        return 32 - Integer.numberOfLeadingZeros(i2);
    }

    private static int bitLength(long j) {
        long j2 = j;
        if (j < 0) {
            j2 = j ^ (-1);
        }
        return 64 - Long.numberOfLeadingZeros(j2);
    }

    private int decimalDigitsInLong(long j) {
        if (j == Long.MIN_VALUE) {
            return 19;
        }
        int binarySearch = Arrays.binarySearch(MathUtils.LONG_POWERS_OF_TEN, Math.abs(j));
        return binarySearch < 0 ? (-binarySearch) - 1 : binarySearch + 1;
    }

    private static BigDecimal divideBigIntegers(BigInteger bigInteger, BigInteger bigInteger2, int i, RoundingMode roundingMode) {
        int roundingBehavior;
        BigInteger[] divideAndRemainder = bigInteger.divideAndRemainder(bigInteger2);
        BigInteger bigInteger3 = divideAndRemainder[0];
        BigInteger bigInteger4 = divideAndRemainder[1];
        if (bigInteger4.signum() == 0) {
            return new BigDecimal(bigInteger3, i);
        }
        int signum = bigInteger.signum() * bigInteger2.signum();
        if (bigInteger2.bitLength() < 63) {
            roundingBehavior = roundingBehavior(bigInteger3.testBit(0) ? 1 : 0, (longCompareTo(Math.abs(bigInteger4.longValue()) * 2, Math.abs(bigInteger2.longValue())) + 5) * signum, roundingMode);
        } else {
            roundingBehavior = roundingBehavior(bigInteger3.testBit(0) ? 1 : 0, (bigInteger4.abs().shiftLeftOneBit().compareTo(bigInteger2.abs()) + 5) * signum, roundingMode);
        }
        return roundingBehavior != 0 ? bigInteger3.bitLength() < 63 ? valueOf(bigInteger3.longValue() + roundingBehavior, i) : new BigDecimal(bigInteger3.add(BigInteger.valueOf(roundingBehavior)), i) : new BigDecimal(bigInteger3, i);
    }

    private static BigDecimal dividePrimitiveLongs(long j, long j2, int i, RoundingMode roundingMode) {
        long j3 = j / j2;
        long j4 = j % j2;
        int signum = Long.signum(j);
        int signum2 = Long.signum(j2);
        long j5 = j3;
        if (j4 != 0) {
            j5 = j3 + roundingBehavior(((int) j3) & 1, (longCompareTo(Math.abs(j4) * 2, Math.abs(j2)) + 5) * signum * signum2, roundingMode);
        }
        return valueOf(j5, i);
    }

    private BigInteger getUnscaledValue() {
        if (this.intVal == null) {
            this.intVal = BigInteger.valueOf(this.smallValue);
        }
        return this.intVal;
    }

    private void inplaceRound(MathContext mathContext) {
        int precision;
        int precision2 = mathContext.getPrecision();
        if (approxPrecision() < precision2 || precision2 == 0 || (precision = precision() - precision2) <= 0) {
            return;
        }
        if (this.bitLength < 64) {
            smallRound(mathContext, precision);
            return;
        }
        BigInteger powerOf10 = Multiplication.powerOf10(precision);
        BigInteger[] divideAndRemainder = getUnscaledValue().divideAndRemainder(powerOf10);
        long j = this.scale - precision;
        long j2 = j;
        if (divideAndRemainder[1].signum() != 0) {
            int roundingBehavior = roundingBehavior(divideAndRemainder[0].testBit(0) ? 1 : 0, divideAndRemainder[1].signum() * (divideAndRemainder[1].abs().shiftLeftOneBit().compareTo(powerOf10) + 5), mathContext.getRoundingMode());
            if (roundingBehavior != 0) {
                divideAndRemainder[0] = divideAndRemainder[0].add(BigInteger.valueOf(roundingBehavior));
            }
            j2 = j;
            if (new BigDecimal(divideAndRemainder[0]).precision() > precision2) {
                divideAndRemainder[0] = divideAndRemainder[0].divide(BigInteger.TEN);
                j2 = j - 1;
            }
        }
        this.scale = safeLongToInt(j2);
        this.precision = precision2;
        setUnscaledValue(divideAndRemainder[0]);
    }

    private boolean isZero() {
        return this.bitLength == 0 && this.smallValue != -1;
    }

    private static int longCompareTo(long j, long j2) {
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }

    private BigDecimal movePoint(long j) {
        return isZero() ? zeroScaledBy(Math.max(j, 0L)) : j >= 0 ? this.bitLength < 64 ? valueOf(this.smallValue, safeLongToInt(j)) : new BigDecimal(getUnscaledValue(), safeLongToInt(j)) : ((-j) >= ((long) MathUtils.LONG_POWERS_OF_TEN.length) || this.bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int) (-j)] >= 64) ? new BigDecimal(Multiplication.multiplyByTenPow(getUnscaledValue(), safeLongToInt(-j)), 0) : valueOf(this.smallValue * MathUtils.LONG_POWERS_OF_TEN[(int) (-j)], 0);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.bitLength = this.intVal.bitLength();
        if (this.bitLength < 64) {
            this.smallValue = this.intVal.longValue();
        }
    }

    private static int roundingBehavior(int i, int i2, RoundingMode roundingMode) {
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                if (i2 != 0) {
                    throw new ArithmeticException("Rounding necessary");
                }
                return 0;
            case 2:
                return Integer.signum(i2);
            case 3:
            default:
                return 0;
            case 4:
                return Math.max(Integer.signum(i2), 0);
            case 5:
                return Math.min(Integer.signum(i2), 0);
            case 6:
                if (Math.abs(i2) >= 5) {
                    return Integer.signum(i2);
                }
                return 0;
            case 7:
                if (Math.abs(i2) > 5) {
                    return Integer.signum(i2);
                }
                return 0;
            case 8:
                if (Math.abs(i2) + i > 5) {
                    return Integer.signum(i2);
                }
                return 0;
        }
    }

    private static int safeLongToInt(long j) {
        if (j < -2147483648L || j > 2147483647L) {
            throw new ArithmeticException("Out of int range: " + j);
        }
        return (int) j;
    }

    private void setUnscaledValue(BigInteger bigInteger) {
        this.intVal = bigInteger;
        this.bitLength = bigInteger.bitLength();
        if (this.bitLength < 64) {
            this.smallValue = bigInteger.longValue();
        }
    }

    private void smallRound(MathContext mathContext, int i) {
        long j = MathUtils.LONG_POWERS_OF_TEN[i];
        long j2 = this.scale - i;
        long j3 = this.smallValue;
        long j4 = j3 / j;
        long j5 = j3 % j;
        long j6 = j4;
        long j7 = j2;
        if (j5 != 0) {
            long roundingBehavior = j4 + roundingBehavior(((int) j4) & 1, Long.signum(j5) * (longCompareTo(Math.abs(j5) * 2, j) + 5), mathContext.getRoundingMode());
            j6 = roundingBehavior;
            j7 = j2;
            if (Math.log10(Math.abs(roundingBehavior)) >= mathContext.getPrecision()) {
                j6 = roundingBehavior / 10;
                j7 = j2 - 1;
            }
        }
        this.scale = safeLongToInt(j7);
        this.precision = mathContext.getPrecision();
        this.smallValue = j6;
        this.bitLength = bitLength(j6);
        this.intVal = null;
    }

    private long valueExact(int i) {
        BigInteger bigIntegerExact = toBigIntegerExact();
        if (bigIntegerExact.bitLength() < i) {
            return bigIntegerExact.longValue();
        }
        throw new ArithmeticException("Rounding necessary");
    }

    public static BigDecimal valueOf(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new NumberFormatException("Infinity or NaN: " + d);
        }
        return new BigDecimal(Double.toString(d));
    }

    public static BigDecimal valueOf(long j) {
        return (j < 0 || j >= 11) ? new BigDecimal(j, 0) : BI_SCALED_BY_ZERO[(int) j];
    }

    public static BigDecimal valueOf(long j, int i) {
        return i == 0 ? valueOf(j) : (j != 0 || i < 0 || i >= ZERO_SCALED_BY.length) ? new BigDecimal(j, i) : ZERO_SCALED_BY[i];
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        getUnscaledValue();
        objectOutputStream.defaultWriteObject();
    }

    private static BigDecimal zeroScaledBy(long j) {
        return j == ((long) ((int) j)) ? valueOf(0L, (int) j) : j >= 0 ? new BigDecimal(0, Integer.MAX_VALUE) : new BigDecimal(0, Integer.MIN_VALUE);
    }

    public BigDecimal abs() {
        BigDecimal bigDecimal = this;
        if (signum() < 0) {
            bigDecimal = negate();
        }
        return bigDecimal;
    }

    public BigDecimal abs(MathContext mathContext) {
        BigDecimal negate = signum() < 0 ? negate() : new BigDecimal(getUnscaledValue(), this.scale);
        negate.inplaceRound(mathContext);
        return negate;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
        if (r6.isZero() == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.math.BigDecimal add(java.math.BigDecimal r6) {
        /*
            r5 = this;
            r0 = r5
            int r0 = r0.scale
            r1 = r6
            int r1 = r1.scale
            int r0 = r0 - r1
            r7 = r0
            r0 = r5
            boolean r0 = r0.isZero()
            if (r0 == 0) goto L49
            r0 = r7
            if (r0 > 0) goto L19
            r0 = r6
            r8 = r0
        L17:
            r0 = r8
            return r0
        L19:
            r0 = r5
            r8 = r0
            r0 = r6
            boolean r0 = r0.isZero()
            if (r0 != 0) goto L17
        L22:
            r0 = r7
            if (r0 != 0) goto L6d
            r0 = r5
            int r0 = r0.bitLength
            r1 = r6
            int r1 = r1.bitLength
            int r0 = java.lang.Math.max(r0, r1)
            r1 = 1
            int r0 = r0 + r1
            r1 = 64
            if (r0 >= r1) goto L56
            r0 = r5
            long r0 = r0.smallValue
            r1 = r6
            long r1 = r1.smallValue
            long r0 = r0 + r1
            r1 = r5
            int r1 = r1.scale
            java.math.BigDecimal r0 = valueOf(r0, r1)
            return r0
        L49:
            r0 = r6
            boolean r0 = r0.isZero()
            if (r0 == 0) goto L22
            r0 = r7
            if (r0 < 0) goto L22
            r0 = r5
            return r0
        L56:
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r1 = r0
            r2 = r5
            java.math.BigInteger r2 = r2.getUnscaledValue()
            r3 = r6
            java.math.BigInteger r3 = r3.getUnscaledValue()
            java.math.BigInteger r2 = r2.add(r3)
            r3 = r5
            int r3 = r3.scale
            r1.<init>(r2, r3)
            return r0
        L6d:
            r0 = r7
            if (r0 <= 0) goto L78
            r0 = r5
            r1 = r6
            r2 = r7
            java.math.BigDecimal r0 = addAndMult10(r0, r1, r2)
            return r0
        L78:
            r0 = r6
            r1 = r5
            r2 = r7
            int r2 = -r2
            java.math.BigDecimal r0 = addAndMult10(r0, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.math.BigDecimal.add(java.math.BigDecimal):java.math.BigDecimal");
    }

    public BigDecimal add(BigDecimal bigDecimal, MathContext mathContext) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        long j = this.scale - bigDecimal.scale;
        if (bigDecimal.isZero() || isZero() || mathContext.getPrecision() == 0) {
            return add(bigDecimal).round(mathContext);
        }
        if (approxPrecision() < j - 1) {
            bigDecimal2 = bigDecimal;
            bigDecimal3 = this;
        } else if (bigDecimal.approxPrecision() >= (-j) - 1) {
            return add(bigDecimal).round(mathContext);
        } else {
            bigDecimal2 = this;
            bigDecimal3 = bigDecimal;
        }
        if (mathContext.getPrecision() >= bigDecimal2.approxPrecision()) {
            return add(bigDecimal).round(mathContext);
        }
        int signum = bigDecimal2.signum();
        return new BigDecimal(signum == bigDecimal3.signum() ? Multiplication.multiplyByPositiveInt(bigDecimal2.getUnscaledValue(), 10).add(BigInteger.valueOf(signum)) : Multiplication.multiplyByPositiveInt(bigDecimal2.getUnscaledValue().subtract(BigInteger.valueOf(signum)), 10).add(BigInteger.valueOf(signum * 9)), bigDecimal2.scale + 1).round(mathContext);
    }

    public byte byteValueExact() {
        return (byte) valueExact(8);
    }

    @Override // java.lang.Comparable
    public int compareTo(BigDecimal bigDecimal) {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        int signum = signum();
        int signum2 = bigDecimal.signum();
        if (signum != signum2) {
            return signum < signum2 ? -1 : 1;
        } else if (this.scale == bigDecimal.scale && this.bitLength < 64 && bigDecimal.bitLength < 64) {
            if (this.smallValue < bigDecimal.smallValue) {
                return -1;
            }
            return this.smallValue > bigDecimal.smallValue ? 1 : 0;
        } else {
            long j = this.scale - bigDecimal.scale;
            int approxPrecision = approxPrecision() - bigDecimal.approxPrecision();
            if (approxPrecision > 1 + j) {
                return signum;
            }
            if (approxPrecision < j - 1) {
                return -signum;
            }
            BigInteger unscaledValue = getUnscaledValue();
            BigInteger unscaledValue2 = bigDecimal.getUnscaledValue();
            if (j < 0) {
                bigInteger = unscaledValue.multiply(Multiplication.powerOf10(-j));
                bigInteger2 = unscaledValue2;
            } else {
                bigInteger = unscaledValue;
                bigInteger2 = unscaledValue2;
                if (j > 0) {
                    bigInteger2 = unscaledValue2.multiply(Multiplication.powerOf10(j));
                    bigInteger = unscaledValue;
                }
            }
            return bigInteger.compareTo(bigInteger2);
        }
    }

    public BigDecimal divide(BigDecimal bigDecimal) {
        BigInteger unscaledValue = getUnscaledValue();
        BigInteger unscaledValue2 = bigDecimal.getUnscaledValue();
        long j = this.scale - bigDecimal.scale;
        int i = 0;
        int i2 = 1;
        int length = FIVE_POW.length;
        if (bigDecimal.isZero()) {
            throw new ArithmeticException("Division by zero");
        }
        if (unscaledValue.signum() == 0) {
            return zeroScaledBy(j);
        }
        BigInteger gcd = unscaledValue.gcd(unscaledValue2);
        BigInteger divide = unscaledValue.divide(gcd);
        BigInteger divide2 = unscaledValue2.divide(gcd);
        int lowestSetBit = divide2.getLowestSetBit();
        BigInteger shiftRight = divide2.shiftRight(lowestSetBit);
        while (true) {
            BigInteger[] divideAndRemainder = shiftRight.divideAndRemainder(FIVE_POW[i2]);
            if (divideAndRemainder[1].signum() == 0) {
                int i3 = i + i2;
                int i4 = i2;
                if (i2 < length - 1) {
                    i4 = i2 + 1;
                }
                shiftRight = divideAndRemainder[0];
                i2 = i4;
                i = i3;
            } else if (i2 == 1) {
                break;
            } else {
                i2 = 1;
            }
        }
        if (shiftRight.abs().equals(BigInteger.ONE)) {
            BigInteger bigInteger = divide;
            if (shiftRight.signum() < 0) {
                bigInteger = divide.negate();
            }
            int safeLongToInt = safeLongToInt(Math.max(lowestSetBit, i) + j);
            int i5 = lowestSetBit - i;
            return new BigDecimal(i5 > 0 ? Multiplication.multiplyByFivePow(bigInteger, i5) : bigInteger.shiftLeft(-i5), safeLongToInt);
        }
        throw new ArithmeticException("Non-terminating decimal expansion; no exact representable decimal result");
    }

    public BigDecimal divide(BigDecimal bigDecimal, int i) {
        return divide(bigDecimal, this.scale, RoundingMode.valueOf(i));
    }

    public BigDecimal divide(BigDecimal bigDecimal, int i, int i2) {
        return divide(bigDecimal, i, RoundingMode.valueOf(i2));
    }

    public BigDecimal divide(BigDecimal bigDecimal, int i, RoundingMode roundingMode) {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        if (roundingMode == null) {
            throw new NullPointerException("roundingMode == null");
        }
        if (bigDecimal.isZero()) {
            throw new ArithmeticException("Division by zero");
        }
        long j = (this.scale - bigDecimal.scale) - i;
        if (bitLength(j) > 32) {
            throw new ArithmeticException("Unable to perform divisor / dividend scaling: the difference in scale is too big (" + j + ")");
        }
        if (this.bitLength < 64 && bigDecimal.bitLength < 64) {
            if (j == 0) {
                return dividePrimitiveLongs(this.smallValue, bigDecimal.smallValue, i, roundingMode);
            }
            if (j > 0) {
                if (j < MathUtils.LONG_POWERS_OF_TEN.length && bigDecimal.bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int) j] < 64) {
                    return dividePrimitiveLongs(this.smallValue, bigDecimal.smallValue * MathUtils.LONG_POWERS_OF_TEN[(int) j], i, roundingMode);
                }
            } else if ((-j) < MathUtils.LONG_POWERS_OF_TEN.length && this.bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int) (-j)] < 64) {
                return dividePrimitiveLongs(this.smallValue * MathUtils.LONG_POWERS_OF_TEN[(int) (-j)], bigDecimal.smallValue, i, roundingMode);
            }
        }
        BigInteger unscaledValue = getUnscaledValue();
        BigInteger unscaledValue2 = bigDecimal.getUnscaledValue();
        if (j > 0) {
            bigInteger2 = Multiplication.multiplyByTenPow(unscaledValue2, (int) j);
            bigInteger = unscaledValue;
        } else {
            bigInteger = unscaledValue;
            bigInteger2 = unscaledValue2;
            if (j < 0) {
                bigInteger = Multiplication.multiplyByTenPow(unscaledValue, (int) (-j));
                bigInteger2 = unscaledValue2;
            }
        }
        return divideBigIntegers(bigInteger, bigInteger2, i, roundingMode);
    }

    public BigDecimal divide(BigDecimal bigDecimal, MathContext mathContext) {
        BigInteger bigInteger;
        long j;
        long precision = ((mathContext.getPrecision() + 2) + bigDecimal.approxPrecision()) - approxPrecision();
        long j2 = this.scale - bigDecimal.scale;
        int i = 1;
        int length = TEN_POW.length;
        BigInteger[] bigIntegerArr = {getUnscaledValue()};
        if (mathContext.getPrecision() == 0 || isZero() || bigDecimal.isZero()) {
            return divide(bigDecimal);
        }
        long j3 = j2;
        if (precision > 0) {
            bigIntegerArr[0] = getUnscaledValue().multiply(Multiplication.powerOf10(precision));
            j3 = j2 + precision;
        }
        BigInteger[] divideAndRemainder = bigIntegerArr[0].divideAndRemainder(bigDecimal.getUnscaledValue());
        BigInteger bigInteger2 = divideAndRemainder[0];
        BigInteger bigInteger3 = bigInteger2;
        long j4 = j3;
        if (divideAndRemainder[1].signum() == 0) {
            while (true) {
                bigInteger = bigInteger3;
                j = j4;
                if (bigInteger3.testBit(0)) {
                    break;
                }
                BigInteger[] divideAndRemainder2 = bigInteger3.divideAndRemainder(TEN_POW[i]);
                if (divideAndRemainder2[1].signum() != 0 || j4 - i < j2) {
                    bigInteger = bigInteger3;
                    j = j4;
                    if (i == 1) {
                        break;
                    }
                    i = 1;
                } else {
                    j4 -= i;
                    int i2 = i;
                    if (i < length - 1) {
                        i2 = i + 1;
                    }
                    bigInteger3 = divideAndRemainder2[0];
                    i = i2;
                }
            }
        } else {
            bigInteger = bigInteger2.multiply(BigInteger.TEN).add(BigInteger.valueOf(divideAndRemainder[0].signum() * (divideAndRemainder[1].shiftLeftOneBit().compareTo(bigDecimal.getUnscaledValue()) + 5)));
            j = j3 + 1;
        }
        return new BigDecimal(bigInteger, safeLongToInt(j), mathContext);
    }

    public BigDecimal divide(BigDecimal bigDecimal, RoundingMode roundingMode) {
        return divide(bigDecimal, this.scale, roundingMode);
    }

    public BigDecimal[] divideAndRemainder(BigDecimal bigDecimal) {
        BigDecimal[] bigDecimalArr = {divideToIntegralValue(bigDecimal), subtract(bigDecimalArr[0].multiply(bigDecimal))};
        return bigDecimalArr;
    }

    public BigDecimal[] divideAndRemainder(BigDecimal bigDecimal, MathContext mathContext) {
        BigDecimal[] bigDecimalArr = {divideToIntegralValue(bigDecimal, mathContext), subtract(bigDecimalArr[0].multiply(bigDecimal))};
        return bigDecimalArr;
    }

    public BigDecimal divideToIntegralValue(BigDecimal bigDecimal) {
        BigInteger bigInteger;
        getUnscaledValue();
        long j = this.scale - bigDecimal.scale;
        long j2 = 0;
        int i = 1;
        int length = TEN_POW.length;
        if (bigDecimal.isZero()) {
            throw new ArithmeticException("Division by zero");
        }
        if (bigDecimal.approxPrecision() + j > approxPrecision() + 1 || isZero()) {
            bigInteger = BigInteger.ZERO;
            j2 = j;
        } else if (j == 0) {
            bigInteger = getUnscaledValue().divide(bigDecimal.getUnscaledValue());
            j2 = j;
        } else if (j > 0) {
            BigInteger powerOf10 = Multiplication.powerOf10(j);
            bigInteger = getUnscaledValue().divide(bigDecimal.getUnscaledValue().multiply(powerOf10)).multiply(powerOf10);
            j2 = j;
        } else {
            bigInteger = getUnscaledValue().multiply(Multiplication.powerOf10(-j)).divide(bigDecimal.getUnscaledValue());
            while (!bigInteger.testBit(0)) {
                BigInteger[] divideAndRemainder = bigInteger.divideAndRemainder(TEN_POW[i]);
                if (divideAndRemainder[1].signum() == 0 && j2 - i >= j) {
                    j2 -= i;
                    int i2 = i;
                    if (i < length - 1) {
                        i2 = i + 1;
                    }
                    bigInteger = divideAndRemainder[0];
                    i = i2;
                } else if (i == 1) {
                    break;
                } else {
                    i = 1;
                }
            }
        }
        return bigInteger.signum() == 0 ? zeroScaledBy(j2) : new BigDecimal(bigInteger, safeLongToInt(j2));
    }

    public BigDecimal divideToIntegralValue(BigDecimal bigDecimal, MathContext mathContext) {
        int precision = mathContext.getPrecision();
        int precision2 = precision() - bigDecimal.precision();
        int length = TEN_POW.length;
        long j = this.scale - bigDecimal.scale;
        long j2 = j;
        long j3 = (precision2 - j) + 1;
        BigInteger[] bigIntegerArr = new BigInteger[2];
        if (precision == 0 || isZero() || bigDecimal.isZero()) {
            return divideToIntegralValue(bigDecimal);
        }
        if (j3 <= 0) {
            bigIntegerArr[0] = BigInteger.ZERO;
        } else if (j == 0) {
            bigIntegerArr[0] = getUnscaledValue().divide(bigDecimal.getUnscaledValue());
        } else if (j > 0) {
            bigIntegerArr[0] = getUnscaledValue().divide(bigDecimal.getUnscaledValue().multiply(Multiplication.powerOf10(j)));
            j2 = Math.min(j, Math.max((precision - j3) + 1, 0L));
            bigIntegerArr[0] = bigIntegerArr[0].multiply(Multiplication.powerOf10(j2));
        } else {
            long min = Math.min(-j, Math.max(precision - precision2, 0L));
            BigInteger[] divideAndRemainder = getUnscaledValue().multiply(Multiplication.powerOf10(min)).divideAndRemainder(bigDecimal.getUnscaledValue());
            long j4 = j2 + min;
            long j5 = -j4;
            bigIntegerArr = divideAndRemainder;
            j2 = j4;
            if (divideAndRemainder[1].signum() != 0) {
                bigIntegerArr = divideAndRemainder;
                j2 = j4;
                if (j5 > 0) {
                    long precision3 = (new BigDecimal(divideAndRemainder[1]).precision() + j5) - bigDecimal.precision();
                    long j6 = precision3;
                    if (precision3 == 0) {
                        divideAndRemainder[1] = divideAndRemainder[1].multiply(Multiplication.powerOf10(j5)).divide(bigDecimal.getUnscaledValue());
                        j6 = Math.abs(divideAndRemainder[1].signum());
                    }
                    bigIntegerArr = divideAndRemainder;
                    j2 = j4;
                    if (j6 > 0) {
                        throw new ArithmeticException("Division impossible");
                    }
                }
            }
        }
        if (bigIntegerArr[0].signum() == 0) {
            return zeroScaledBy(j);
        }
        BigInteger bigInteger = bigIntegerArr[0];
        BigDecimal bigDecimal2 = new BigDecimal(bigIntegerArr[0]);
        long precision4 = bigDecimal2.precision();
        int i = 1;
        while (true) {
            int i2 = i;
            if (bigInteger.testBit(0)) {
                break;
            }
            BigInteger[] divideAndRemainder2 = bigInteger.divideAndRemainder(TEN_POW[i2]);
            if (divideAndRemainder2[1].signum() == 0 && (precision4 - i2 >= precision || j2 - i2 >= j)) {
                precision4 -= i2;
                j2 -= i2;
                int i3 = i2;
                if (i2 < length - 1) {
                    i3 = i2 + 1;
                }
                bigInteger = divideAndRemainder2[0];
                i = i3;
            } else if (i2 == 1) {
                break;
            } else {
                i = 1;
            }
        }
        if (precision4 > precision) {
            throw new ArithmeticException("Division impossible");
        }
        bigDecimal2.scale = safeLongToInt(j2);
        bigDecimal2.setUnscaledValue(bigInteger);
        return bigDecimal2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a5, code lost:
        if ((3 & r0) == 3) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01cd, code lost:
        if (r0 < r0) goto L42;
     */
    @Override // java.lang.Number
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double doubleValue() {
        /*
            Method dump skipped, instructions count: 501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.math.BigDecimal.doubleValue():double");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) obj;
            if (bigDecimal.scale == this.scale) {
                return this.bitLength < 64 ? bigDecimal.smallValue == this.smallValue : this.intVal.equals(bigDecimal.intVal);
            }
            return false;
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        float signum = signum();
        long j = this.bitLength - ((long) (this.scale / LOG10_2));
        return (j < -149 || signum == 0.0f) ? signum * 0.0f : j > 129 ? signum * Float.POSITIVE_INFINITY : (float) doubleValue();
    }

    public int hashCode() {
        if (this.hashCode != 0) {
            return this.hashCode;
        }
        if (this.bitLength >= 64) {
            this.hashCode = (this.intVal.hashCode() * 17) + this.scale;
            return this.hashCode;
        }
        this.hashCode = (int) (this.smallValue & (-1));
        this.hashCode = (this.hashCode * 33) + ((int) ((this.smallValue >> 32) & (-1)));
        this.hashCode = (this.hashCode * 17) + this.scale;
        return this.hashCode;
    }

    @Override // java.lang.Number
    public int intValue() {
        if (this.scale <= -32 || this.scale > approxPrecision()) {
            return 0;
        }
        return toBigInteger().intValue();
    }

    public int intValueExact() {
        return (int) valueExact(32);
    }

    @Override // java.lang.Number
    public long longValue() {
        if (this.scale <= -64 || this.scale > approxPrecision()) {
            return 0L;
        }
        return toBigInteger().longValue();
    }

    public long longValueExact() {
        return valueExact(64);
    }

    public BigDecimal max(BigDecimal bigDecimal) {
        return compareTo(bigDecimal) >= 0 ? this : bigDecimal;
    }

    public BigDecimal min(BigDecimal bigDecimal) {
        return compareTo(bigDecimal) <= 0 ? this : bigDecimal;
    }

    public BigDecimal movePointLeft(int i) {
        return movePoint(this.scale + i);
    }

    public BigDecimal movePointRight(int i) {
        return movePoint(this.scale - i);
    }

    public BigDecimal multiply(BigDecimal bigDecimal) {
        long j = this.scale + bigDecimal.scale;
        return (isZero() || bigDecimal.isZero()) ? zeroScaledBy(j) : this.bitLength + bigDecimal.bitLength < 64 ? valueOf(this.smallValue * bigDecimal.smallValue, safeLongToInt(j)) : new BigDecimal(getUnscaledValue().multiply(bigDecimal.getUnscaledValue()), safeLongToInt(j));
    }

    public BigDecimal multiply(BigDecimal bigDecimal, MathContext mathContext) {
        BigDecimal multiply = multiply(bigDecimal);
        multiply.inplaceRound(mathContext);
        return multiply;
    }

    public BigDecimal negate() {
        return (this.bitLength < 63 || (this.bitLength == 63 && this.smallValue != Long.MIN_VALUE)) ? valueOf(-this.smallValue, this.scale) : new BigDecimal(getUnscaledValue().negate(), this.scale);
    }

    public BigDecimal negate(MathContext mathContext) {
        BigDecimal negate = negate();
        negate.inplaceRound(mathContext);
        return negate;
    }

    public BigDecimal plus() {
        return this;
    }

    public BigDecimal plus(MathContext mathContext) {
        return round(mathContext);
    }

    public BigDecimal pow(int i) {
        if (i == 0) {
            return ONE;
        }
        if (i < 0 || i > 999999999) {
            throw new ArithmeticException("Invalid operation");
        }
        long j = this.scale * i;
        return isZero() ? zeroScaledBy(j) : new BigDecimal(getUnscaledValue().pow(i), safeLongToInt(j));
    }

    public BigDecimal pow(int i, MathContext mathContext) {
        int abs = Math.abs(i);
        int precision = mathContext.getPrecision();
        int log10 = ((int) Math.log10(abs)) + 1;
        MathContext mathContext2 = mathContext;
        if (i == 0 || (isZero() && i > 0)) {
            return pow(i);
        }
        if (abs > 999999999 || ((precision == 0 && i < 0) || (precision > 0 && log10 > precision))) {
            throw new ArithmeticException("Invalid operation");
        }
        if (precision > 0) {
            mathContext2 = new MathContext(precision + log10 + 1, mathContext.getRoundingMode());
        }
        BigDecimal round = round(mathContext2);
        int highestOneBit = Integer.highestOneBit(abs);
        while (true) {
            int i2 = highestOneBit >> 1;
            if (i2 <= 0) {
                break;
            }
            BigDecimal multiply = round.multiply(round, mathContext2);
            round = multiply;
            if ((abs & i2) == i2) {
                round = multiply.multiply(this, mathContext2);
            }
            highestOneBit = i2;
        }
        BigDecimal bigDecimal = round;
        if (i < 0) {
            bigDecimal = ONE.divide(round, mathContext2);
        }
        bigDecimal.inplaceRound(mathContext);
        return bigDecimal;
    }

    public int precision() {
        if (this.precision != 0) {
            return this.precision;
        }
        if (this.bitLength == 0) {
            this.precision = 1;
        } else if (this.bitLength < 64) {
            this.precision = decimalDigitsInLong(this.smallValue);
        } else {
            int i = ((int) ((this.bitLength - 1) * LOG10_2)) + 1;
            int i2 = i;
            if (getUnscaledValue().divide(Multiplication.powerOf10(i)).signum() != 0) {
                i2 = i + 1;
            }
            this.precision = i2;
        }
        return this.precision;
    }

    public BigDecimal remainder(BigDecimal bigDecimal) {
        return divideAndRemainder(bigDecimal)[1];
    }

    public BigDecimal remainder(BigDecimal bigDecimal, MathContext mathContext) {
        return divideAndRemainder(bigDecimal, mathContext)[1];
    }

    public BigDecimal round(MathContext mathContext) {
        BigDecimal bigDecimal = new BigDecimal(getUnscaledValue(), this.scale);
        bigDecimal.inplaceRound(mathContext);
        return bigDecimal;
    }

    public int scale() {
        return this.scale;
    }

    public BigDecimal scaleByPowerOfTen(int i) {
        long j = this.scale - i;
        return this.bitLength < 64 ? this.smallValue == 0 ? zeroScaledBy(j) : valueOf(this.smallValue, safeLongToInt(j)) : new BigDecimal(getUnscaledValue(), safeLongToInt(j));
    }

    public BigDecimal setScale(int i) {
        return setScale(i, RoundingMode.UNNECESSARY);
    }

    public BigDecimal setScale(int i, int i2) {
        return setScale(i, RoundingMode.valueOf(i2));
    }

    public BigDecimal setScale(int i, RoundingMode roundingMode) {
        if (roundingMode == null) {
            throw new NullPointerException("roundingMode == null");
        }
        long j = i - this.scale;
        return j == 0 ? this : j > 0 ? (j >= ((long) MathUtils.LONG_POWERS_OF_TEN.length) || this.bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int) j] >= 64) ? new BigDecimal(Multiplication.multiplyByTenPow(getUnscaledValue(), (int) j), i) : valueOf(this.smallValue * MathUtils.LONG_POWERS_OF_TEN[(int) j], i) : (this.bitLength >= 64 || (-j) >= ((long) MathUtils.LONG_POWERS_OF_TEN.length)) ? divideBigIntegers(getUnscaledValue(), Multiplication.powerOf10(-j), i, roundingMode) : dividePrimitiveLongs(this.smallValue, MathUtils.LONG_POWERS_OF_TEN[(int) (-j)], i, roundingMode);
    }

    public short shortValueExact() {
        return (short) valueExact(16);
    }

    public int signum() {
        return this.bitLength < 64 ? Long.signum(this.smallValue) : getUnscaledValue().signum();
    }

    public BigDecimal stripTrailingZeros() {
        int i = 1;
        int length = TEN_POW.length;
        long j = this.scale;
        if (isZero()) {
            return this;
        }
        BigInteger unscaledValue = getUnscaledValue();
        while (!unscaledValue.testBit(0)) {
            BigInteger[] divideAndRemainder = unscaledValue.divideAndRemainder(TEN_POW[i]);
            if (divideAndRemainder[1].signum() == 0) {
                j -= i;
                int i2 = i;
                if (i < length - 1) {
                    i2 = i + 1;
                }
                unscaledValue = divideAndRemainder[0];
                i = i2;
            } else if (i == 1) {
                break;
            } else {
                i = 1;
            }
        }
        return new BigDecimal(unscaledValue, safeLongToInt(j));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r8.isZero() == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.math.BigDecimal subtract(java.math.BigDecimal r8) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.math.BigDecimal.subtract(java.math.BigDecimal):java.math.BigDecimal");
    }

    public BigDecimal subtract(BigDecimal bigDecimal, MathContext mathContext) {
        long j = bigDecimal.scale;
        long j2 = this.scale;
        if (bigDecimal.isZero() || isZero() || mathContext.getPrecision() == 0) {
            return subtract(bigDecimal).round(mathContext);
        }
        if (bigDecimal.approxPrecision() >= (j - j2) - 1 || mathContext.getPrecision() >= approxPrecision()) {
            return subtract(bigDecimal).round(mathContext);
        }
        int signum = signum();
        return new BigDecimal(signum != bigDecimal.signum() ? Multiplication.multiplyByPositiveInt(getUnscaledValue(), 10).add(BigInteger.valueOf(signum)) : Multiplication.multiplyByPositiveInt(getUnscaledValue().subtract(BigInteger.valueOf(signum)), 10).add(BigInteger.valueOf(signum * 9)), this.scale + 1).round(mathContext);
    }

    public BigInteger toBigInteger() {
        return (this.scale == 0 || isZero()) ? getUnscaledValue() : this.scale < 0 ? getUnscaledValue().multiply(Multiplication.powerOf10(-this.scale)) : getUnscaledValue().divide(Multiplication.powerOf10(this.scale));
    }

    public BigInteger toBigIntegerExact() {
        if (this.scale == 0 || isZero()) {
            return getUnscaledValue();
        }
        if (this.scale < 0) {
            return getUnscaledValue().multiply(Multiplication.powerOf10(-this.scale));
        }
        if (this.scale > approxPrecision() || this.scale > getUnscaledValue().getLowestSetBit()) {
            throw new ArithmeticException("Rounding necessary");
        }
        BigInteger[] divideAndRemainder = getUnscaledValue().divideAndRemainder(Multiplication.powerOf10(this.scale));
        if (divideAndRemainder[1].signum() != 0) {
            throw new ArithmeticException("Rounding necessary");
        }
        return divideAndRemainder[0];
    }

    public String toEngineeringString() {
        long j;
        int i;
        String bigInteger = getUnscaledValue().toString();
        if (this.scale == 0) {
            return bigInteger;
        }
        int i2 = getUnscaledValue().signum() < 0 ? 2 : 1;
        int length = bigInteger.length();
        long j2 = ((-this.scale) + length) - i2;
        StringBuilder sb = new StringBuilder(bigInteger);
        if (this.scale <= 0 || j2 < -6) {
            int i3 = length - i2;
            int i4 = (int) (j2 % 3);
            int i5 = i2;
            int i6 = length;
            long j3 = j2;
            if (i4 != 0) {
                if (getUnscaledValue().signum() == 0) {
                    int i7 = i4 < 0 ? -i4 : 3 - i4;
                    j = j2 + i7;
                    i = i7;
                } else {
                    int i8 = i4;
                    if (i4 < 0) {
                        i8 = i4 + 3;
                    }
                    j = j2 - i8;
                    i2 += i8;
                    i = i8;
                }
                i5 = i2;
                i6 = length;
                j3 = j;
                if (i3 < 3) {
                    i6 = length;
                    int i9 = i - i3;
                    while (i9 > 0) {
                        sb.insert(i6, '0');
                        i9--;
                        i6++;
                    }
                    j3 = j;
                    i5 = i2;
                }
            }
            int i10 = i6;
            if (i6 - i5 >= 1) {
                sb.insert(i5, '.');
                i10 = i6 + 1;
            }
            if (j3 != 0) {
                sb.insert(i10, 'E');
                int i11 = i10;
                if (j3 > 0) {
                    i11 = i10 + 1;
                    sb.insert(i11, '+');
                }
                sb.insert(i11 + 1, Long.toString(j3));
            }
        } else if (j2 >= 0) {
            sb.insert(length - this.scale, '.');
        } else {
            sb.insert(i2 - 1, "0.");
            sb.insert(i2 + 1, CH_ZEROS, 0, (-((int) j2)) - 1);
        }
        return sb.toString();
    }

    public String toPlainString() {
        int i;
        String bigInteger = getUnscaledValue().toString();
        if (this.scale == 0 || (isZero() && this.scale < 0)) {
            return bigInteger;
        }
        int i2 = signum() < 0 ? 1 : 0;
        int i3 = this.scale;
        StringBuilder sb = new StringBuilder(bigInteger.length() + 1 + Math.abs(this.scale));
        if (i2 == 1) {
            sb.append('-');
        }
        if (this.scale > 0) {
            int length = i3 - (bigInteger.length() - i2);
            if (length >= 0) {
                sb.append("0.");
                while (length > CH_ZEROS.length) {
                    sb.append(CH_ZEROS);
                    length -= CH_ZEROS.length;
                }
                sb.append(CH_ZEROS, 0, length);
                sb.append(bigInteger.substring(i2));
            } else {
                int i4 = i2 - length;
                sb.append(bigInteger.substring(i2, i4));
                sb.append('.');
                sb.append(bigInteger.substring(i4));
            }
        } else {
            sb.append(bigInteger.substring(i2));
            int i5 = i3;
            while (true) {
                i = i5;
                if (i >= (-CH_ZEROS.length)) {
                    break;
                }
                sb.append(CH_ZEROS);
                i5 = i + CH_ZEROS.length;
            }
            sb.append(CH_ZEROS, 0, -i);
        }
        return sb.toString();
    }

    public String toString() {
        String str;
        if (this.toStringImage != null) {
            str = this.toStringImage;
        } else if (this.bitLength < 32) {
            this.toStringImage = Conversion.toDecimalScaledString(this.smallValue, this.scale);
            return this.toStringImage;
        } else {
            String bigInteger = getUnscaledValue().toString();
            str = bigInteger;
            if (this.scale != 0) {
                int i = getUnscaledValue().signum() < 0 ? 2 : 1;
                int length = bigInteger.length();
                long j = ((-this.scale) + length) - i;
                StringBuilder sb = new StringBuilder();
                sb.append(bigInteger);
                if (this.scale <= 0 || j < -6) {
                    int i2 = length;
                    if (length - i >= 1) {
                        sb.insert(i, '.');
                        i2 = length + 1;
                    }
                    sb.insert(i2, 'E');
                    int i3 = i2;
                    if (j > 0) {
                        i3 = i2 + 1;
                        sb.insert(i3, '+');
                    }
                    sb.insert(i3 + 1, Long.toString(j));
                } else if (j >= 0) {
                    sb.insert(length - this.scale, '.');
                } else {
                    sb.insert(i - 1, "0.");
                    sb.insert(i + 1, CH_ZEROS, 0, (-((int) j)) - 1);
                }
                this.toStringImage = sb.toString();
                return this.toStringImage;
            }
        }
        return str;
    }

    public BigDecimal ulp() {
        return valueOf(1L, this.scale);
    }

    public BigInteger unscaledValue() {
        return getUnscaledValue();
    }
}
