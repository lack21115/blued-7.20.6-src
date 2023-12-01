package com.android.internal.util;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/GrowingArrayUtils.class */
public final class GrowingArrayUtils {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !GrowingArrayUtils.class.desiredAssertionStatus();
    }

    private GrowingArrayUtils() {
    }

    public static int[] append(int[] iArr, int i, int i2) {
        if ($assertionsDisabled || i <= iArr.length) {
            int[] iArr2 = iArr;
            if (i + 1 > iArr.length) {
                iArr2 = ArrayUtils.newUnpaddedIntArray(growSize(i));
                System.arraycopy(iArr, 0, iArr2, 0, i);
            }
            iArr2[i] = i2;
            return iArr2;
        }
        throw new AssertionError();
    }

    public static long[] append(long[] jArr, int i, long j) {
        if ($assertionsDisabled || i <= jArr.length) {
            long[] jArr2 = jArr;
            if (i + 1 > jArr.length) {
                jArr2 = ArrayUtils.newUnpaddedLongArray(growSize(i));
                System.arraycopy(jArr, 0, jArr2, 0, i);
            }
            jArr2[i] = j;
            return jArr2;
        }
        throw new AssertionError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Object[]] */
    public static <T> T[] append(T[] tArr, int i, T t) {
        if ($assertionsDisabled || i <= tArr.length) {
            T[] tArr2 = tArr;
            if (i + 1 > tArr.length) {
                tArr2 = ArrayUtils.newUnpaddedArray(tArr.getClass().getComponentType(), growSize(i));
                System.arraycopy(tArr, 0, tArr2, 0, i);
            }
            tArr2[i] = t;
            return tArr2;
        }
        throw new AssertionError();
    }

    public static boolean[] append(boolean[] zArr, int i, boolean z) {
        if ($assertionsDisabled || i <= zArr.length) {
            boolean[] zArr2 = zArr;
            if (i + 1 > zArr.length) {
                zArr2 = ArrayUtils.newUnpaddedBooleanArray(growSize(i));
                System.arraycopy(zArr, 0, zArr2, 0, i);
            }
            zArr2[i] = z;
            return zArr2;
        }
        throw new AssertionError();
    }

    public static int growSize(int i) {
        if (i <= 4) {
            return 8;
        }
        return i * 2;
    }

    public static int[] insert(int[] iArr, int i, int i2, int i3) {
        if ($assertionsDisabled || i <= iArr.length) {
            if (i + 1 <= iArr.length) {
                System.arraycopy(iArr, i2, iArr, i2 + 1, i - i2);
                iArr[i2] = i3;
                return iArr;
            }
            int[] newUnpaddedIntArray = ArrayUtils.newUnpaddedIntArray(growSize(i));
            System.arraycopy(iArr, 0, newUnpaddedIntArray, 0, i2);
            newUnpaddedIntArray[i2] = i3;
            System.arraycopy(iArr, i2, newUnpaddedIntArray, i2 + 1, iArr.length - i2);
            return newUnpaddedIntArray;
        }
        throw new AssertionError();
    }

    public static long[] insert(long[] jArr, int i, int i2, long j) {
        if ($assertionsDisabled || i <= jArr.length) {
            if (i + 1 <= jArr.length) {
                System.arraycopy(jArr, i2, jArr, i2 + 1, i - i2);
                jArr[i2] = j;
                return jArr;
            }
            long[] newUnpaddedLongArray = ArrayUtils.newUnpaddedLongArray(growSize(i));
            System.arraycopy(jArr, 0, newUnpaddedLongArray, 0, i2);
            newUnpaddedLongArray[i2] = j;
            System.arraycopy(jArr, i2, newUnpaddedLongArray, i2 + 1, jArr.length - i2);
            return newUnpaddedLongArray;
        }
        throw new AssertionError();
    }

    public static <T> T[] insert(T[] tArr, int i, int i2, T t) {
        if ($assertionsDisabled || i <= tArr.length) {
            if (i + 1 <= tArr.length) {
                System.arraycopy(tArr, i2, tArr, i2 + 1, i - i2);
                tArr[i2] = t;
                return tArr;
            }
            T[] tArr2 = (T[]) ArrayUtils.newUnpaddedArray(tArr.getClass().getComponentType(), growSize(i));
            System.arraycopy(tArr, 0, tArr2, 0, i2);
            tArr2[i2] = t;
            System.arraycopy(tArr, i2, tArr2, i2 + 1, tArr.length - i2);
            return tArr2;
        }
        throw new AssertionError();
    }

    public static boolean[] insert(boolean[] zArr, int i, int i2, boolean z) {
        if ($assertionsDisabled || i <= zArr.length) {
            if (i + 1 <= zArr.length) {
                System.arraycopy(zArr, i2, zArr, i2 + 1, i - i2);
                zArr[i2] = z;
                return zArr;
            }
            boolean[] newUnpaddedBooleanArray = ArrayUtils.newUnpaddedBooleanArray(growSize(i));
            System.arraycopy(zArr, 0, newUnpaddedBooleanArray, 0, i2);
            newUnpaddedBooleanArray[i2] = z;
            System.arraycopy(zArr, i2, newUnpaddedBooleanArray, i2 + 1, zArr.length - i2);
            return newUnpaddedBooleanArray;
        }
        throw new AssertionError();
    }
}
