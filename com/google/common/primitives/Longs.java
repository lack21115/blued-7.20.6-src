package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/primitives/Longs.class */
public final class Longs {
    public static final int BYTES = 8;
    public static final long MAX_POWER_OF_TWO = 4611686018427387904L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/common/primitives/Longs$AsciiDigits.class */
    public static final class AsciiDigits {
        private static final byte[] asciiDigits;

        static {
            int i;
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= 10) {
                    break;
                }
                bArr[i3 + 48] = (byte) i3;
                i2 = i3 + 1;
            }
            for (i = 0; i < 26; i++) {
                byte b = (byte) (i + 10);
                bArr[i + 65] = b;
                bArr[i + 97] = b;
            }
            asciiDigits = bArr;
        }

        private AsciiDigits() {
        }

        static int digit(char c2) {
            if (c2 < 128) {
                return asciiDigits[c2];
            }
            return -1;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/primitives/Longs$LexicographicalComparator.class */
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
                int compare = Longs.compare(jArr[i2], jArr2[i2]);
                if (compare != 0) {
                    return compare;
                }
                i = i2 + 1;
            }
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Longs.lexicographicalComparator()";
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/primitives/Longs$LongArrayAsList.class */
    static class LongArrayAsList extends AbstractList<Long> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final long[] array;
        final int end;
        final int start;

        LongArrayAsList(long[] jArr) {
            this(jArr, 0, jArr.length);
        }

        LongArrayAsList(long[] jArr, int i, int i2) {
            this.array = jArr;
            this.start = i;
            this.end = i2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Long) && Longs.indexOf(this.array, ((Long) obj).longValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LongArrayAsList)) {
                return super.equals(obj);
            }
            LongArrayAsList longArrayAsList = (LongArrayAsList) obj;
            int size = size();
            if (longArrayAsList.size() != size) {
                return false;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return true;
                }
                if (this.array[this.start + i2] != longArrayAsList.array[longArrayAsList.start + i2]) {
                    return false;
                }
                i = i2 + 1;
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int i) {
            Preconditions.checkElementIndex(i, size());
            return Long.valueOf(this.array[this.start + i]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.Set
        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + Longs.hashCode(this.array[i2]);
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int indexOf;
            if (!(obj instanceof Long) || (indexOf = Longs.indexOf(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return indexOf - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            if (!(obj instanceof Long) || (lastIndexOf = Longs.lastIndexOf(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return lastIndexOf - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long set(int i, Long l) {
            Preconditions.checkElementIndex(i, size());
            long[] jArr = this.array;
            int i2 = this.start;
            long j = jArr[i2 + i];
            jArr[i2 + i] = ((Long) Preconditions.checkNotNull(l)).longValue();
            return Long.valueOf(j);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            long[] jArr = this.array;
            int i3 = this.start;
            return new LongArrayAsList(jArr, i + i3, i3 + i2);
        }

        long[] toLongArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 10);
            sb.append('[');
            sb.append(this.array[this.start]);
            int i = this.start;
            while (true) {
                i++;
                if (i >= this.end) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.array[i]);
            }
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/primitives/Longs$LongConverter.class */
    static final class LongConverter extends Converter<String, Long> implements Serializable {
        static final LongConverter INSTANCE = new LongConverter();
        private static final long serialVersionUID = 1;

        private LongConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public String doBackward(Long l) {
            return l.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public Long doForward(String str) {
            return Long.decode(str);
        }

        public String toString() {
            return "Longs.stringConverter()";
        }
    }

    private Longs() {
    }

    public static List<Long> asList(long... jArr) {
        return jArr.length == 0 ? Collections.emptyList() : new LongArrayAsList(jArr);
    }

    public static int compare(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public static long[] concat(long[]... jArr) {
        int i = 0;
        for (long[] jArr2 : jArr) {
            i += jArr2.length;
        }
        long[] jArr3 = new long[i];
        int i2 = 0;
        for (long[] jArr4 : jArr) {
            System.arraycopy((Object) jArr4, 0, (Object) jArr3, i2, jArr4.length);
            i2 += jArr4.length;
        }
        return jArr3;
    }

    public static long constrainToRange(long j, long j2, long j3) {
        Preconditions.checkArgument(j2 <= j3, "min (%s) must be less than or equal to max (%s)", j2, j3);
        return Math.min(Math.max(j, j2), j3);
    }

    public static boolean contains(long[] jArr, long j) {
        int length = jArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (jArr[i2] == j) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static long[] ensureCapacity(long[] jArr, int i, int i2) {
        Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        Preconditions.checkArgument(i2 >= 0, "Invalid padding: %s", i2);
        long[] jArr2 = jArr;
        if (jArr.length < i) {
            jArr2 = Arrays.copyOf(jArr, i + i2);
        }
        return jArr2;
    }

    public static long fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 8, "array too small: %s < %s", bArr.length, 8);
        return fromBytes(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]);
    }

    public static long fromBytes(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        return ((b2 & 255) << 48) | ((b & 255) << 56) | ((b3 & 255) << 40) | ((b4 & 255) << 32) | ((b5 & 255) << 24) | ((b6 & 255) << 16) | ((b7 & 255) << 8) | (b8 & 255);
    }

    public static int hashCode(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int indexOf(long[] jArr, long j) {
        return indexOf(jArr, j, 0, jArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(long[] jArr, long j, int i, int i2) {
        while (i < i2) {
            if (jArr[i] == j) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int indexOf(long[] jArr, long[] jArr2) {
        Preconditions.checkNotNull(jArr, "array");
        Preconditions.checkNotNull(jArr2, TypedValues.AttributesType.S_TARGET);
        if (jArr2.length == 0) {
            return 0;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= (jArr.length - jArr2.length) + 1) {
                return -1;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= jArr2.length) {
                    return i2;
                }
                if (jArr[i2 + i4] != jArr2[i4]) {
                    break;
                }
                i3 = i4 + 1;
            }
            i = i2 + 1;
        }
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 10);
        sb.append(jArr[0]);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= jArr.length) {
                return sb.toString();
            }
            sb.append(str);
            sb.append(jArr[i2]);
            i = i2 + 1;
        }
    }

    public static int lastIndexOf(long[] jArr, long j) {
        return lastIndexOf(jArr, j, 0, jArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(long[] jArr, long j, int i, int i2) {
        while (true) {
            i2--;
            if (i2 < i) {
                return -1;
            }
            if (jArr[i2] == j) {
                return i2;
            }
        }
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long max(long... jArr) {
        int i = 1;
        Preconditions.checkArgument(jArr.length > 0);
        long j = jArr[0];
        while (true) {
            long j2 = j;
            if (i >= jArr.length) {
                return j2;
            }
            long j3 = j2;
            if (jArr[i] > j2) {
                j3 = jArr[i];
            }
            i++;
            j = j3;
        }
    }

    public static long min(long... jArr) {
        int i = 1;
        Preconditions.checkArgument(jArr.length > 0);
        long j = jArr[0];
        while (true) {
            long j2 = j;
            if (i >= jArr.length) {
                return j2;
            }
            long j3 = j2;
            if (jArr[i] < j2) {
                j3 = jArr[i];
            }
            i++;
            j = j3;
        }
    }

    public static void reverse(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        reverse(jArr, 0, jArr.length);
    }

    public static void reverse(long[] jArr, int i, int i2) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i, i2, jArr.length);
        while (true) {
            i2--;
            if (i >= i2) {
                return;
            }
            long j = jArr[i];
            jArr[i] = jArr[i2];
            jArr[i2] = j;
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
        Arrays.sort(jArr, i, i2);
        reverse(jArr, i, i2);
    }

    public static Converter<String, Long> stringConverter() {
        return LongConverter.INSTANCE;
    }

    public static long[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof LongArrayAsList) {
            return ((LongArrayAsList) collection).toLongArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        long[] jArr = new long[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return jArr;
            }
            jArr[i2] = ((Number) Preconditions.checkNotNull(array[i2])).longValue();
            i = i2 + 1;
        }
    }

    public static byte[] toByteArray(long j) {
        byte[] bArr = new byte[8];
        int i = 7;
        while (true) {
            int i2 = i;
            if (i2 < 0) {
                return bArr;
            }
            bArr[i2] = (byte) (255 & j);
            j >>= 8;
            i = i2 - 1;
        }
    }

    @NullableDecl
    public static Long tryParse(String str) {
        return tryParse(str, 10);
    }

    @NullableDecl
    public static Long tryParse(String str, int i) {
        if (((String) Preconditions.checkNotNull(str)).isEmpty()) {
            return null;
        }
        if (i < 2 || i > 36) {
            throw new IllegalArgumentException("radix must be between MIN_RADIX and MAX_RADIX but was " + i);
        }
        int i2 = str.charAt(0) == '-' ? 1 : 0;
        if (i2 == str.length()) {
            return null;
        }
        int digit = AsciiDigits.digit(str.charAt(i2));
        if (digit < 0 || digit >= i) {
            return null;
        }
        long j = -digit;
        long j2 = i;
        long j3 = Long.MIN_VALUE / j2;
        for (int i3 = i2 + 1; i3 < str.length(); i3++) {
            int digit2 = AsciiDigits.digit(str.charAt(i3));
            if (digit2 < 0 || digit2 >= i || j < j3) {
                return null;
            }
            long j4 = j * j2;
            long j5 = digit2;
            if (j4 < j5 - Long.MIN_VALUE) {
                return null;
            }
            j = j4 - j5;
        }
        if (i2 != 0) {
            return Long.valueOf(j);
        }
        if (j == Long.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(-j);
    }
}
