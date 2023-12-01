package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/primitives/UnsignedInts.class */
public final class UnsignedInts {
    static final long INT_MASK = 4294967295L;

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/primitives/UnsignedInts$LexicographicalComparator.class */
    enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= min) {
                    return iArr.length - iArr2.length;
                }
                if (iArr[i2] != iArr2[i2]) {
                    return UnsignedInts.compare(iArr[i2], iArr2[i2]);
                }
                i = i2 + 1;
            }
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }
    }

    private UnsignedInts() {
    }

    public static int checkedCast(long j) {
        Preconditions.checkArgument((j >> 32) == 0, "out of range: %s", j);
        return (int) j;
    }

    public static int compare(int i, int i2) {
        return Ints.compare(flip(i), flip(i2));
    }

    public static int decode(String str) {
        ParseRequest fromString = ParseRequest.fromString(str);
        try {
            return parseUnsignedInt(fromString.rawValue, fromString.radix);
        } catch (NumberFormatException e) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    public static int divide(int i, int i2) {
        return (int) (toLong(i) / toLong(i2));
    }

    static int flip(int i) {
        return i ^ Integer.MIN_VALUE;
    }

    public static String join(String str, int... iArr) {
        Preconditions.checkNotNull(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 5);
        sb.append(toString(iArr[0]));
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                return sb.toString();
            }
            sb.append(str);
            sb.append(toString(iArr[i2]));
            i = i2 + 1;
        }
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static int max(int... iArr) {
        int i = 1;
        Preconditions.checkArgument(iArr.length > 0);
        int flip = flip(iArr[0]);
        while (true) {
            int i2 = flip;
            if (i >= iArr.length) {
                return flip(i2);
            }
            int flip2 = flip(iArr[i]);
            int i3 = i2;
            if (flip2 > i2) {
                i3 = flip2;
            }
            i++;
            flip = i3;
        }
    }

    public static int min(int... iArr) {
        int i = 1;
        Preconditions.checkArgument(iArr.length > 0);
        int flip = flip(iArr[0]);
        while (true) {
            int i2 = flip;
            if (i >= iArr.length) {
                return flip(i2);
            }
            int flip2 = flip(iArr[i]);
            int i3 = i2;
            if (flip2 < i2) {
                i3 = flip2;
            }
            i++;
            flip = i3;
        }
    }

    public static int parseUnsignedInt(String str) {
        return parseUnsignedInt(str, 10);
    }

    public static int parseUnsignedInt(String str, int i) {
        Preconditions.checkNotNull(str);
        long parseLong = Long.parseLong(str, i);
        if ((INT_MASK & parseLong) == parseLong) {
            return (int) parseLong;
        }
        throw new NumberFormatException("Input " + str + " in base " + i + " is not in the range of an unsigned integer");
    }

    public static int remainder(int i, int i2) {
        return (int) (toLong(i) % toLong(i2));
    }

    public static int saturatedCast(long j) {
        if (j <= 0) {
            return 0;
        }
        if (j >= 4294967296L) {
            return -1;
        }
        return (int) j;
    }

    public static void sort(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sort(iArr, 0, iArr.length);
    }

    public static void sort(int[] iArr, int i, int i2) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i, i2, iArr.length);
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                break;
            }
            iArr[i4] = flip(iArr[i4]);
            i3 = i4 + 1;
        }
        Arrays.sort(iArr, i, i2);
        while (i < i2) {
            iArr[i] = flip(iArr[i]);
            i++;
        }
    }

    public static void sortDescending(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sortDescending(iArr, 0, iArr.length);
    }

    public static void sortDescending(int[] iArr, int i, int i2) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i, i2, iArr.length);
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                break;
            }
            iArr[i4] = Integer.MAX_VALUE ^ iArr[i4];
            i3 = i4 + 1;
        }
        Arrays.sort(iArr, i, i2);
        while (i < i2) {
            iArr[i] = iArr[i] ^ Integer.MAX_VALUE;
            i++;
        }
    }

    public static long toLong(int i) {
        return i & INT_MASK;
    }

    public static String toString(int i) {
        return toString(i, 10);
    }

    public static String toString(int i, int i2) {
        return Long.toString(i & INT_MASK, i2);
    }
}
