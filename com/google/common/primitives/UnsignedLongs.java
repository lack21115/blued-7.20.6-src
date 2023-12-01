package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/primitives/UnsignedLongs.class */
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/primitives/UnsignedLongs$LexicographicalComparator.class */
    enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= min) {
                    return jArr.length - jArr2.length;
                }
                if (jArr[i2] != jArr2[i2]) {
                    return UnsignedLongs.compare(jArr[i2], jArr2[i2]);
                }
                i = i2 + 1;
            }
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/common/primitives/UnsignedLongs$ParseOverflowDetection.class */
    public static final class ParseOverflowDetection {
        static final long[] maxValueDivs = new long[37];
        static final int[] maxValueMods = new int[37];
        static final int[] maxSafeDigits = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            int i = 2;
            while (true) {
                int i2 = i;
                if (i2 > 36) {
                    return;
                }
                long j = i2;
                maxValueDivs[i2] = UnsignedLongs.divide(-1L, j);
                maxValueMods[i2] = (int) UnsignedLongs.remainder(-1L, j);
                maxSafeDigits[i2] = bigInteger.toString(i2).length() - 1;
                i = i2 + 1;
            }
        }

        private ParseOverflowDetection() {
        }

        static boolean overflowInParse(long j, int i, int i2) {
            boolean z = true;
            if (j >= 0) {
                long[] jArr = maxValueDivs;
                if (j < jArr[i2]) {
                    return false;
                }
                if (j > jArr[i2] || i > maxValueMods[i2]) {
                    return true;
                }
                z = false;
            }
            return z;
        }
    }

    private UnsignedLongs() {
    }

    public static int compare(long j, long j2) {
        return Longs.compare(flip(j), flip(j2));
    }

    public static long decode(String str) {
        ParseRequest fromString = ParseRequest.fromString(str);
        try {
            return parseUnsignedLong(fromString.rawValue, fromString.radix);
        } catch (NumberFormatException e) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    public static long divide(long j, long j2) {
        if (j2 < 0) {
            return compare(j, j2) < 0 ? 0L : 1L;
        } else if (j >= 0) {
            return j / j2;
        } else {
            int i = 1;
            long j3 = ((j >>> 1) / j2) << 1;
            if (compare(j - (j3 * j2), j2) < 0) {
                i = 0;
            }
            return j3 + i;
        }
    }

    private static long flip(long j) {
        return j ^ Long.MIN_VALUE;
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 5);
        sb.append(toString(jArr[0]));
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= jArr.length) {
                return sb.toString();
            }
            sb.append(str);
            sb.append(toString(jArr[i2]));
            i = i2 + 1;
        }
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long max(long... jArr) {
        int i = 1;
        Preconditions.checkArgument(jArr.length > 0);
        long flip = flip(jArr[0]);
        while (true) {
            long j = flip;
            if (i >= jArr.length) {
                return flip(j);
            }
            long flip2 = flip(jArr[i]);
            long j2 = j;
            if (flip2 > j) {
                j2 = flip2;
            }
            i++;
            flip = j2;
        }
    }

    public static long min(long... jArr) {
        int i = 1;
        Preconditions.checkArgument(jArr.length > 0);
        long flip = flip(jArr[0]);
        while (true) {
            long j = flip;
            if (i >= jArr.length) {
                return flip(j);
            }
            long flip2 = flip(jArr[i]);
            long j2 = j;
            if (flip2 < j) {
                j2 = flip2;
            }
            i++;
            flip = j2;
        }
    }

    public static long parseUnsignedLong(String str) {
        return parseUnsignedLong(str, 10);
    }

    public static long parseUnsignedLong(String str, int i) {
        Preconditions.checkNotNull(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (i < 2 || i > 36) {
            throw new NumberFormatException("illegal radix: " + i);
        }
        int i2 = ParseOverflowDetection.maxSafeDigits[i];
        long j = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= str.length()) {
                return j;
            }
            int digit = Character.digit(str.charAt(i4), i);
            if (digit == -1) {
                throw new NumberFormatException(str);
            }
            if (i4 > i2 - 1 && ParseOverflowDetection.overflowInParse(j, digit, i)) {
                throw new NumberFormatException("Too large for unsigned long: " + str);
            }
            j = (j * i) + digit;
            i3 = i4 + 1;
        }
    }

    public static long remainder(long j, long j2) {
        if (j2 < 0) {
            return compare(j, j2) < 0 ? j : j - j2;
        } else if (j >= 0) {
            return j % j2;
        } else {
            long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
            if (compare(j3, j2) < 0) {
                j2 = 0;
            }
            return j3 - j2;
        }
    }

    public static void sort(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sort(jArr, 0, jArr.length);
    }

    public static void sort(long[] jArr, int i, int i2) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i, i2, jArr.length);
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                break;
            }
            jArr[i4] = flip(jArr[i4]);
            i3 = i4 + 1;
        }
        Arrays.sort(jArr, i, i2);
        while (i < i2) {
            jArr[i] = flip(jArr[i]);
            i++;
        }
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr, int i, int i2) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i, i2, jArr.length);
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                break;
            }
            jArr[i4] = Long.MAX_VALUE ^ jArr[i4];
            i3 = i4 + 1;
        }
        Arrays.sort(jArr, i, i2);
        while (i < i2) {
            jArr[i] = jArr[i] ^ Long.MAX_VALUE;
            i++;
        }
    }

    public static String toString(long j) {
        return toString(j, 10);
    }

    public static String toString(long j, int i) {
        int i2;
        long j2;
        Preconditions.checkArgument(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i);
        int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i3 == 0) {
            return "0";
        }
        if (i3 > 0) {
            return Long.toString(j, i);
        }
        char[] cArr = new char[64];
        int i4 = i - 1;
        if ((i & i4) != 0) {
            long divide = (i & 1) == 0 ? (j >>> 1) / (i >>> 1) : divide(j, i);
            long j3 = i;
            int i5 = 63;
            cArr[63] = Character.forDigit((int) (j - (divide * j3)), i);
            while (true) {
                i2 = i5;
                if (divide <= 0) {
                    break;
                }
                i5--;
                cArr[i5] = Character.forDigit((int) (divide % j3), i);
                divide /= j3;
            }
        } else {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            int i6 = 64;
            do {
                i2 = i6 - 1;
                cArr[i2] = Character.forDigit(((int) j) & i4, i);
                j2 = j >>> numberOfTrailingZeros;
                i6 = i2;
                j = j2;
            } while (j2 != 0);
        }
        return new String(cArr, i2, 64 - i2);
    }
}
