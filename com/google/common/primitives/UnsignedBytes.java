package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.Comparator;
import sun.misc.Unsafe;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/primitives/UnsignedBytes.class */
public final class UnsignedBytes {
    public static final byte MAX_POWER_OF_TWO = Byte.MIN_VALUE;
    public static final byte MAX_VALUE = -1;
    private static final int UNSIGNED_MASK = 255;

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/primitives/UnsignedBytes$LexicographicalComparatorHolder.class */
    static class LexicographicalComparatorHolder {
        static final String UNSAFE_COMPARATOR_NAME = LexicographicalComparatorHolder.class.getName() + "$UnsafeComparator";
        static final Comparator<byte[]> BEST_COMPARATOR = getBestComparator();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8110460-dex2jar.jar:com/google/common/primitives/UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator.class */
        public enum PureJavaComparator implements Comparator<byte[]> {
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
                    int compare = UnsignedBytes.compare(bArr[i2], bArr2[i2]);
                    if (compare != 0) {
                        return compare;
                    }
                    i = i2 + 1;
                }
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }
        }

        /* loaded from: source-8110460-dex2jar.jar:com/google/common/primitives/UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.class */
        enum UnsafeComparator implements Comparator<byte[]> {
            INSTANCE;
            
            static final boolean BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
            static final int BYTE_ARRAY_BASE_OFFSET;
            static final Unsafe theUnsafe;

            static {
                Unsafe unsafe = getUnsafe();
                theUnsafe = unsafe;
                BYTE_ARRAY_BASE_OFFSET = unsafe.arrayBaseOffset(byte[].class);
                if (!"64".equals(System.getProperty("sun.arch.data.model")) || BYTE_ARRAY_BASE_OFFSET % 8 != 0 || theUnsafe.arrayIndexScale(byte[].class) != 1) {
                    throw new Error();
                }
            }

            private static Unsafe getUnsafe() {
                try {
                    return Unsafe.getUnsafe();
                } catch (SecurityException e) {
                    try {
                        return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.UnsafeComparator.1
                            @Override // java.security.PrivilegedExceptionAction
                            public Unsafe run() throws Exception {
                                Field[] declaredFields = Unsafe.class.getDeclaredFields();
                                int length = declaredFields.length;
                                int i = 0;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= length) {
                                        throw new NoSuchFieldError("the Unsafe");
                                    }
                                    Field field = declaredFields[i2];
                                    field.setAccessible(true);
                                    Object obj = field.get(null);
                                    if (Unsafe.class.isInstance(obj)) {
                                        return (Unsafe) Unsafe.class.cast(obj);
                                    }
                                    i = i2 + 1;
                                }
                            }
                        });
                    } catch (PrivilegedActionException e2) {
                        throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                    }
                }
            }

            @Override // java.util.Comparator
            public int compare(byte[] bArr, byte[] bArr2) {
                int min = Math.min(bArr.length, bArr2.length);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= (min & (-8))) {
                        for (int i3 = i2; i3 < min; i3++) {
                            int compare = UnsignedBytes.compare(bArr[i3], bArr2[i3]);
                            if (compare != 0) {
                                return compare;
                            }
                        }
                        return bArr.length - bArr2.length;
                    }
                    long j = i2;
                    long j2 = theUnsafe.getLong(bArr, BYTE_ARRAY_BASE_OFFSET + j);
                    long j3 = theUnsafe.getLong(bArr2, BYTE_ARRAY_BASE_OFFSET + j);
                    if (j2 != j3) {
                        if (BIG_ENDIAN) {
                            return UnsignedLongs.compare(j2, j3);
                        }
                        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j2 ^ j3) & (-8);
                        return ((int) ((j2 >>> numberOfTrailingZeros) & 255)) - ((int) ((j3 >>> numberOfTrailingZeros) & 255));
                    }
                    i = i2 + 8;
                }
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }
        }

        LexicographicalComparatorHolder() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        static Comparator<byte[]> getBestComparator() {
            try {
                return (Comparator) Class.forName(UNSAFE_COMPARATOR_NAME).getEnumConstants()[0];
            } catch (Throwable th) {
                return UnsignedBytes.lexicographicalComparatorJavaImpl();
            }
        }
    }

    private UnsignedBytes() {
    }

    public static byte checkedCast(long j) {
        Preconditions.checkArgument((j >> 8) == 0, "out of range: %s", j);
        return (byte) j;
    }

    public static int compare(byte b, byte b2) {
        return toInt(b) - toInt(b2);
    }

    private static byte flip(byte b) {
        return (byte) (b ^ 128);
    }

    public static String join(String str, byte... bArr) {
        Preconditions.checkNotNull(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * (str.length() + 3));
        sb.append(toInt(bArr[0]));
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            sb.append(str);
            sb.append(toString(bArr[i2]));
            i = i2 + 1;
        }
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparatorHolder.BEST_COMPARATOR;
    }

    static Comparator<byte[]> lexicographicalComparatorJavaImpl() {
        return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }

    public static byte max(byte... bArr) {
        int i = 1;
        Preconditions.checkArgument(bArr.length > 0);
        int i2 = toInt(bArr[0]);
        while (true) {
            int i3 = i2;
            if (i >= bArr.length) {
                return (byte) i3;
            }
            int i4 = toInt(bArr[i]);
            int i5 = i3;
            if (i4 > i3) {
                i5 = i4;
            }
            i++;
            i2 = i5;
        }
    }

    public static byte min(byte... bArr) {
        int i = 1;
        Preconditions.checkArgument(bArr.length > 0);
        int i2 = toInt(bArr[0]);
        while (true) {
            int i3 = i2;
            if (i >= bArr.length) {
                return (byte) i3;
            }
            int i4 = toInt(bArr[i]);
            int i5 = i3;
            if (i4 < i3) {
                i5 = i4;
            }
            i++;
            i2 = i5;
        }
    }

    public static byte parseUnsignedByte(String str) {
        return parseUnsignedByte(str, 10);
    }

    public static byte parseUnsignedByte(String str, int i) {
        int parseInt = Integer.parseInt((String) Preconditions.checkNotNull(str), i);
        if ((parseInt >> 8) == 0) {
            return (byte) parseInt;
        }
        throw new NumberFormatException("out of range: " + parseInt);
    }

    public static byte saturatedCast(long j) {
        if (j > toInt((byte) -1)) {
            return (byte) -1;
        }
        if (j < 0) {
            return (byte) 0;
        }
        return (byte) j;
    }

    public static void sort(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sort(bArr, 0, bArr.length);
    }

    public static void sort(byte[] bArr, int i, int i2) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i, i2, bArr.length);
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                break;
            }
            bArr[i4] = flip(bArr[i4]);
            i3 = i4 + 1;
        }
        Arrays.sort(bArr, i, i2);
        while (i < i2) {
            bArr[i] = flip(bArr[i]);
            i++;
        }
    }

    public static void sortDescending(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sortDescending(bArr, 0, bArr.length);
    }

    public static void sortDescending(byte[] bArr, int i, int i2) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i, i2, bArr.length);
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                break;
            }
            bArr[i4] = (byte) (bArr[i4] ^ Byte.MAX_VALUE);
            i3 = i4 + 1;
        }
        Arrays.sort(bArr, i, i2);
        while (i < i2) {
            bArr[i] = (byte) (bArr[i] ^ Byte.MAX_VALUE);
            i++;
        }
    }

    public static int toInt(byte b) {
        return b & 255;
    }

    public static String toString(byte b) {
        return toString(b, 10);
    }

    public static String toString(byte b, int i) {
        Preconditions.checkArgument(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i);
        return Integer.toString(toInt(b), i);
    }
}
