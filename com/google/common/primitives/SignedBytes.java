package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/primitives/SignedBytes.class */
public final class SignedBytes {
    public static final byte MAX_POWER_OF_TWO = 64;

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/primitives/SignedBytes$LexicographicalComparator.class */
    enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int min = Math.min(bArr.length, bArr2.length);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= min) {
                    return bArr.length - bArr2.length;
                }
                int compare = SignedBytes.compare(bArr[i2], bArr2[i2]);
                if (compare != 0) {
                    return compare;
                }
                i = i2 + 1;
            }
        }

        @Override // java.lang.Enum
        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }
    }

    private SignedBytes() {
    }

    public static byte checkedCast(long j) {
        byte b = (byte) j;
        Preconditions.checkArgument(((long) b) == j, "Out of range: %s", j);
        return b;
    }

    public static int compare(byte b, byte b2) {
        return b - b2;
    }

    public static String join(String str, byte... bArr) {
        Preconditions.checkNotNull(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 5);
        sb.append((int) bArr[0]);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            sb.append(str);
            sb.append((int) bArr[i2]);
            i = i2 + 1;
        }
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static byte max(byte... bArr) {
        int i = 1;
        Preconditions.checkArgument(bArr.length > 0);
        byte b = bArr[0];
        while (true) {
            byte b2 = b;
            if (i >= bArr.length) {
                return b2;
            }
            byte b3 = b2;
            if (bArr[i] > b2) {
                b3 = bArr[i];
            }
            i++;
            b = b3;
        }
    }

    public static byte min(byte... bArr) {
        int i = 1;
        Preconditions.checkArgument(bArr.length > 0);
        byte b = bArr[0];
        while (true) {
            byte b2 = b;
            if (i >= bArr.length) {
                return b2;
            }
            byte b3 = b2;
            if (bArr[i] < b2) {
                b3 = bArr[i];
            }
            i++;
            b = b3;
        }
    }

    public static byte saturatedCast(long j) {
        if (j > 127) {
            return Byte.MAX_VALUE;
        }
        if (j < -128) {
            return Byte.MIN_VALUE;
        }
        return (byte) j;
    }

    public static void sortDescending(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sortDescending(bArr, 0, bArr.length);
    }

    public static void sortDescending(byte[] bArr, int i, int i2) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i, i2, bArr.length);
        Arrays.sort(bArr, i, i2);
        Bytes.reverse(bArr, i, i2);
    }
}
