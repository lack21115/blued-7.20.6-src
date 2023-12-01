package com.google.common.math;

import com.blued.das.live.LiveProtos;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedLongs;
import java.math.RoundingMode;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/math/LongMath.class */
public final class LongMath {
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;
    static final long MAX_SIGNED_POWER_OF_TWO = 4611686018427387904L;
    private static final int SIEVE_30 = -545925251;
    static final byte[] maxLog10ForLeadingZeros = {19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};
    static final long[] powersOf10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};
    static final long[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    static final long[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    static final int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, LiveProtos.Event.LIVE_PK_TIPS_SHOW_VALUE, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
    static final int[] biggestSimpleBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, LiveProtos.Event.LIVE_CUSTOM_MADE_SEAL_PAGE_RECORD_POP_SHOW_VALUE, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    private static final long[][] millerRabinBaseSets = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.math.LongMath$1  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/google/common/math/LongMath$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0065 -> B:41:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0069 -> B:37:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:49:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0071 -> B:43:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0075 -> B:39:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0079 -> B:35:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007d -> B:47:0x0058). Please submit an issue!!! */
        static {
            int[] iArr = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/math/LongMath$MillerRabinTester.class */
    enum MillerRabinTester {
        SMALL { // from class: com.google.common.math.LongMath.MillerRabinTester.1
            @Override // com.google.common.math.LongMath.MillerRabinTester
            long mulMod(long j, long j2, long j3) {
                return (j * j2) % j3;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            long squareMod(long j, long j2) {
                return (j * j) % j2;
            }
        },
        LARGE { // from class: com.google.common.math.LongMath.MillerRabinTester.2
            private long plusMod(long j, long j2, long j3) {
                long j4 = j + j2;
                long j5 = j4;
                if (j >= j3 - j2) {
                    j5 = j4 - j3;
                }
                return j5;
            }

            private long times2ToThe32Mod(long j, long j2) {
                long remainder;
                int i;
                int i2 = 32;
                do {
                    int min = Math.min(i2, Long.numberOfLeadingZeros(j));
                    remainder = UnsignedLongs.remainder(j << min, j2);
                    i = i2 - min;
                    i2 = i;
                    j = remainder;
                } while (i > 0);
                return remainder;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            long mulMod(long j, long j2, long j3) {
                long j4 = j >>> 32;
                long j5 = j2 >>> 32;
                long j6 = j & 4294967295L;
                long j7 = j2 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j4 * j5, j3) + (j4 * j7);
                long j8 = times2ToThe32Mod;
                if (times2ToThe32Mod < 0) {
                    j8 = UnsignedLongs.remainder(times2ToThe32Mod, j3);
                }
                Long.signum(j6);
                return plusMod(times2ToThe32Mod(j8 + (j5 * j6), j3), UnsignedLongs.remainder(j6 * j7, j3), j3);
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            long squareMod(long j, long j2) {
                long j3 = j >>> 32;
                long j4 = j & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j3 * j3, j2);
                long j5 = j3 * j4 * 2;
                long j6 = j5;
                if (j5 < 0) {
                    j6 = UnsignedLongs.remainder(j5, j2);
                }
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + j6, j2), UnsignedLongs.remainder(j4 * j4, j2), j2);
            }
        };

        /* synthetic */ MillerRabinTester(AnonymousClass1 anonymousClass1) {
            this();
        }

        private long powMod(long j, long j2, long j3) {
            long j4 = 1;
            while (true) {
                long j5 = j4;
                if (j2 == 0) {
                    return j5;
                }
                long j6 = j5;
                if ((j2 & 1) != 0) {
                    j6 = mulMod(j5, j, j3);
                }
                j = squareMod(j, j3);
                j2 >>= 1;
                j4 = j6;
            }
        }

        static boolean test(long j, long j2) {
            return (j2 <= LongMath.FLOOR_SQRT_MAX_LONG ? SMALL : LARGE).testWitness(j, j2);
        }

        private boolean testWitness(long j, long j2) {
            long j3 = j2 - 1;
            int numberOfTrailingZeros = Long.numberOfTrailingZeros(j3);
            long j4 = j % j2;
            if (j4 == 0) {
                return true;
            }
            long powMod = powMod(j4, j3 >> numberOfTrailingZeros, j2);
            if (powMod == 1) {
                return true;
            }
            int i = 0;
            while (powMod != j3) {
                i++;
                if (i == numberOfTrailingZeros) {
                    return false;
                }
                powMod = squareMod(powMod, j2);
            }
            return true;
        }

        abstract long mulMod(long j, long j2, long j3);

        abstract long squareMod(long j, long j2);
    }

    private LongMath() {
    }

    public static long binomial(int i, int i2) {
        MathPreconditions.checkNonNegative("n", i);
        MathPreconditions.checkNonNegative("k", i2);
        Preconditions.checkArgument(i2 <= i, "k (%s) > n (%s)", i2, i);
        int i3 = i2;
        if (i2 > (i >> 1)) {
            i3 = i - i2;
        }
        long j = 1;
        if (i3 != 0) {
            if (i3 != 1) {
                long[] jArr = factorials;
                if (i < jArr.length) {
                    return jArr[i] / (jArr[i3] * jArr[i - i3]);
                }
                int[] iArr = biggestBinomials;
                if (i3 >= iArr.length || i > iArr[i3]) {
                    return Long.MAX_VALUE;
                }
                int[] iArr2 = biggestSimpleBinomials;
                if (i3 < iArr2.length && i <= iArr2[i3]) {
                    int i4 = i - 1;
                    long j2 = i;
                    int i5 = i4;
                    for (int i6 = 2; i6 <= i3; i6++) {
                        j2 = (j2 * i5) / i6;
                        i5--;
                    }
                    return j2;
                }
                long j3 = i;
                int log2 = log2(j3, RoundingMode.CEILING);
                int i7 = i - 1;
                int i8 = log2;
                int i9 = 2;
                long j4 = 1;
                while (i9 <= i3) {
                    i8 += log2;
                    if (i8 < 63) {
                        j3 *= i7;
                        j4 *= i9;
                    } else {
                        j = multiplyFraction(j, j3, j4);
                        j3 = i7;
                        j4 = i9;
                        i8 = log2;
                    }
                    i9++;
                    i7--;
                }
                return multiplyFraction(j, j3, j4);
            }
            return i;
        }
        return 1L;
    }

    public static long ceilingPowerOfTwo(long j) {
        MathPreconditions.checkPositive("x", j);
        if (j <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(j - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + j + ") is not representable as a long");
    }

    public static long checkedAdd(long j, long j2) {
        long j3 = j + j2;
        boolean z = true;
        boolean z2 = (j ^ j2) < 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        MathPreconditions.checkNoOverflow(z2 | z, "checkedAdd", j, j2);
        return j3;
    }

    public static long checkedMultiply(long j, long j2) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j) + Long.numberOfLeadingZeros(j) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(j2);
        if (numberOfLeadingZeros > 65) {
            return j * j2;
        }
        MathPreconditions.checkNoOverflow(numberOfLeadingZeros >= 64, "checkedMultiply", j, j2);
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        MathPreconditions.checkNoOverflow((i >= 0) | (j2 != Long.MIN_VALUE), "checkedMultiply", j, j2);
        long j3 = j * j2;
        MathPreconditions.checkNoOverflow(i == 0 || j3 / j == j2, "checkedMultiply", j, j2);
        return j3;
    }

    public static long checkedPow(long j, int i) {
        MathPreconditions.checkNonNegative("exponent", i);
        boolean z = false;
        if ((j >= -2) && (j <= 2)) {
            int i2 = (int) j;
            if (i2 == -2) {
                boolean z2 = false;
                if (i < 64) {
                    z2 = true;
                }
                MathPreconditions.checkNoOverflow(z2, "checkedPow", j, i);
                return (i & 1) == 0 ? 1 << i : (-1) << i;
            } else if (i2 == -1) {
                return (i & 1) == 0 ? 1L : -1L;
            } else if (i2 == 0) {
                return i == 0 ? 1L : 0L;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    if (i < 63) {
                        z = true;
                    }
                    MathPreconditions.checkNoOverflow(z, "checkedPow", j, i);
                    return 1 << i;
                }
                throw new AssertionError();
            } else {
                return 1L;
            }
        }
        long j2 = 1;
        long j3 = j;
        while (true) {
            long j4 = j3;
            if (i == 0) {
                return j2;
            }
            if (i == 1) {
                return checkedMultiply(j2, j4);
            }
            long j5 = j2;
            if ((i & 1) != 0) {
                j5 = checkedMultiply(j2, j4);
            }
            i >>= 1;
            long j6 = j4;
            if (i > 0) {
                MathPreconditions.checkNoOverflow(-3037000499L <= j4 && j4 <= FLOOR_SQRT_MAX_LONG, "checkedPow", j4, i);
                j6 = j4 * j4;
            }
            j2 = j5;
            j3 = j6;
        }
    }

    public static long checkedSubtract(long j, long j2) {
        long j3 = j - j2;
        boolean z = true;
        boolean z2 = (j ^ j2) >= 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        MathPreconditions.checkNoOverflow(z2 | z, "checkedSubtract", j, j2);
        return j3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static long divide(long j, long j2, RoundingMode roundingMode) {
        Preconditions.checkNotNull(roundingMode);
        long j3 = j / j2;
        long j4 = j - (j2 * j3);
        int i = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i == 0) {
            return j3;
        }
        boolean z = true;
        boolean z2 = true;
        int i2 = ((int) ((j ^ j2) >> 63)) | 1;
        boolean z3 = true;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                if (i != 0) {
                    z = false;
                }
                MathPreconditions.checkRoundingUnnecessary(z);
                z3 = false;
                break;
            case 2:
                z3 = false;
                break;
            case 3:
                if (i2 < 0) {
                    z3 = true;
                    break;
                }
                z3 = false;
                break;
            case 4:
                break;
            case 5:
                if (i2 > 0) {
                    z3 = true;
                    break;
                }
                z3 = false;
                break;
            case 6:
            case 7:
            case 8:
                long abs = Math.abs(j4);
                int i3 = ((abs - (Math.abs(j2) - abs)) > 0L ? 1 : ((abs - (Math.abs(j2) - abs)) == 0L ? 0 : -1));
                if (i3 != 0) {
                    if (i3 > 0) {
                        z3 = true;
                        break;
                    }
                    z3 = false;
                    break;
                } else {
                    boolean z4 = roundingMode == RoundingMode.HALF_UP;
                    boolean z5 = roundingMode == RoundingMode.HALF_EVEN;
                    if ((1 & j3) == 0) {
                        z2 = false;
                    }
                    z3 = (z2 & z5) | z4;
                    break;
                }
            default:
                throw new AssertionError();
        }
        long j5 = j3;
        if (z3) {
            j5 = j3 + i2;
        }
        return j5;
    }

    public static long factorial(int i) {
        MathPreconditions.checkNonNegative("n", i);
        long[] jArr = factorials;
        if (i < jArr.length) {
            return jArr[i];
        }
        return Long.MAX_VALUE;
    }

    static boolean fitsInInt(long j) {
        return ((long) ((int) j)) == j;
    }

    public static long floorPowerOfTwo(long j) {
        MathPreconditions.checkPositive("x", j);
        return 1 << (63 - Long.numberOfLeadingZeros(j));
    }

    public static long gcd(long j, long j2) {
        MathPreconditions.checkNonNegative("a", j);
        MathPreconditions.checkNonNegative("b", j2);
        if (j == 0) {
            return j2;
        }
        if (j2 == 0) {
            return j;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        long j3 = j >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j2);
        long j4 = j2 >> numberOfTrailingZeros2;
        long j5 = j3;
        while (true) {
            long j6 = j5;
            if (j6 == j4) {
                return j6 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
            }
            long j7 = j6 - j4;
            long j8 = (j7 >> 63) & j7;
            long j9 = (j7 - j8) - j8;
            j4 += j8;
            j5 = j9 >> Long.numberOfTrailingZeros(j9);
        }
    }

    public static boolean isPowerOfTwo(long j) {
        boolean z = true;
        boolean z2 = j > 0;
        if ((j & (j - 1)) != 0) {
            z = false;
        }
        return z2 & z;
    }

    public static boolean isPrime(long j) {
        int i = (j > 2L ? 1 : (j == 2L ? 0 : -1));
        if (i < 0) {
            MathPreconditions.checkNonNegative("n", j);
            return false;
        } else if (i == 0 || j == 3 || j == 5 || j == 7 || j == 11 || j == 13) {
            return true;
        } else {
            if ((SIEVE_30 & (1 << ((int) (j % 30)))) != 0 || j % 7 == 0 || j % 11 == 0 || j % 13 == 0) {
                return false;
            }
            if (j < 289) {
                return true;
            }
            long[][] jArr = millerRabinBaseSets;
            int length = jArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    throw new AssertionError();
                }
                long[] jArr2 = jArr[i3];
                if (j <= jArr2[0]) {
                    int i4 = 1;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= jArr2.length) {
                            return true;
                        }
                        if (!MillerRabinTester.test(jArr2[i5], j)) {
                            return false;
                        }
                        i4 = i5 + 1;
                    }
                } else {
                    i2 = i3 + 1;
                }
            }
        }
    }

    static int lessThanBranchFree(long j, long j2) {
        return (int) ((j - j2) >>> 63);
    }

    public static int log10(long j, RoundingMode roundingMode) {
        int lessThanBranchFree;
        MathPreconditions.checkPositive("x", j);
        int log10Floor = log10Floor(j);
        long j2 = powersOf10[log10Floor];
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(j == j2);
                return log10Floor;
            case 2:
            case 3:
                return log10Floor;
            case 4:
            case 5:
                lessThanBranchFree = lessThanBranchFree(j2, j);
                return log10Floor + lessThanBranchFree;
            case 6:
            case 7:
            case 8:
                lessThanBranchFree = lessThanBranchFree(halfPowersOf10[log10Floor], j);
                return log10Floor + lessThanBranchFree;
            default:
                throw new AssertionError();
        }
    }

    static int log10Floor(long j) {
        byte b = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(j)];
        return b - lessThanBranchFree(j, powersOf10[b]);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int log2(long j, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", j);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(j));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Long.numberOfLeadingZeros(j);
                return (63 - numberOfLeadingZeros) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> numberOfLeadingZeros, j);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j);
    }

    public static long mean(long j, long j2) {
        return (j & j2) + ((j ^ j2) >> 1);
    }

    public static int mod(long j, int i) {
        return (int) mod(j, i);
    }

    public static long mod(long j, long j2) {
        if (j2 > 0) {
            long j3 = j % j2;
            return j3 >= 0 ? j3 : j3 + j2;
        }
        throw new ArithmeticException("Modulus must be positive");
    }

    static long multiplyFraction(long j, long j2, long j3) {
        if (j == 1) {
            return j2 / j3;
        }
        long gcd = gcd(j, j3);
        return (j / gcd) * (j2 / (j3 / gcd));
    }

    public static long pow(long j, int i) {
        long j2;
        MathPreconditions.checkNonNegative("exponent", i);
        if (-2 > j || j > 2) {
            long j3 = 1;
            while (true) {
                j2 = j3;
                if (i != 0) {
                    if (i == 1) {
                        j2 = j3 * j;
                        break;
                    }
                    j3 *= (i & 1) == 0 ? 1L : j;
                    j *= j;
                    i >>= 1;
                } else {
                    break;
                }
            }
            return j2;
        }
        int i2 = (int) j;
        long j4 = 0;
        if (i2 == -2) {
            if (i < 64) {
                return (i & 1) == 0 ? 1 << i : -(1 << i);
            }
            return 0L;
        } else if (i2 == -1) {
            return (i & 1) == 0 ? 1L : -1L;
        } else if (i2 == 0) {
            return i == 0 ? 1L : 0L;
        } else if (i2 != 1) {
            if (i2 == 2) {
                if (i < 64) {
                    j4 = 1 << i;
                }
                return j4;
            }
            throw new AssertionError();
        } else {
            return 1L;
        }
    }

    public static long saturatedAdd(long j, long j2) {
        long j3 = j + j2;
        boolean z = true;
        boolean z2 = (j2 ^ j) < 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        return z2 | z ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    public static long saturatedMultiply(long j, long j2) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j) + Long.numberOfLeadingZeros(j) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(j2);
        if (numberOfLeadingZeros > 65) {
            return j * j2;
        }
        long j3 = ((j ^ j2) >>> 63) + Long.MAX_VALUE;
        boolean z = true;
        boolean z2 = numberOfLeadingZeros < 64;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        boolean z3 = i < 0;
        if (j2 != Long.MIN_VALUE) {
            z = false;
        }
        if (z2 || (z & z3)) {
            return j3;
        }
        long j4 = j * j2;
        if (i != 0 && j4 / j != j2) {
            return j3;
        }
        return j4;
    }

    public static long saturatedPow(long j, int i) {
        MathPreconditions.checkNonNegative("exponent", i);
        long j2 = 1;
        if ((j >= -2) && (j <= 2)) {
            int i2 = (int) j;
            if (i2 == -2) {
                return i >= 64 ? (i & 1) + Long.MAX_VALUE : (i & 1) == 0 ? 1 << i : (-1) << i;
            } else if (i2 == -1) {
                return (i & 1) == 0 ? 1L : -1L;
            } else if (i2 == 0) {
                return i == 0 ? 1L : 0L;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    if (i >= 63) {
                        return Long.MAX_VALUE;
                    }
                    return 1 << i;
                }
                throw new AssertionError();
            } else {
                return 1L;
            }
        }
        long j3 = i & 1;
        long j4 = j;
        while (true) {
            long j5 = j4;
            if (i == 0) {
                return j2;
            }
            if (i == 1) {
                return saturatedMultiply(j2, j5);
            }
            long j6 = j2;
            if ((i & 1) != 0) {
                j6 = saturatedMultiply(j2, j5);
            }
            int i3 = i >> 1;
            j2 = j6;
            j4 = j5;
            i = i3;
            if (i3 > 0) {
                if ((-3037000499L > j5) || (j5 > FLOOR_SQRT_MAX_LONG)) {
                    return ((j >>> 63) & j3) + Long.MAX_VALUE;
                }
                j4 = j5 * j5;
                j2 = j6;
                i = i3;
            }
        }
    }

    public static long saturatedSubtract(long j, long j2) {
        long j3 = j - j2;
        boolean z = true;
        boolean z2 = (j2 ^ j) >= 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        return z2 | z ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    public static long sqrt(long j, RoundingMode roundingMode) {
        long j2;
        MathPreconditions.checkNonNegative("x", j);
        if (fitsInInt(j)) {
            return IntMath.sqrt((int) j, roundingMode);
        }
        long sqrt = (long) Math.sqrt(j);
        long j3 = sqrt * sqrt;
        boolean z = true;
        int i = 1;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                if (j3 != j) {
                    z = false;
                }
                MathPreconditions.checkRoundingUnnecessary(z);
                return sqrt;
            case 2:
            case 3:
                long j4 = sqrt;
                if (j < j3) {
                    j4 = sqrt - 1;
                }
                return j4;
            case 4:
            case 5:
                long j5 = sqrt;
                if (j > j3) {
                    j5 = sqrt + 1;
                }
                return j5;
            case 6:
            case 7:
            case 8:
                if (j >= j3) {
                    i = 0;
                }
                return (sqrt - i) + lessThanBranchFree((j2 * j2) + j2, j);
            default:
                throw new AssertionError();
        }
    }
}
