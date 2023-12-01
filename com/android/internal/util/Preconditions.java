package com.android.internal.util;

import java.util.Collection;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/Preconditions.class */
public class Preconditions {
    public static float checkArgumentFinite(float f, String str) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException(str + " must not be NaN");
        }
        if (Float.isInfinite(f)) {
            throw new IllegalArgumentException(str + " must not be infinite");
        }
        return f;
    }

    public static float checkArgumentInRange(float f, float f2, float f3, String str) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException(str + " must not be NaN");
        }
        if (f < f2) {
            throw new IllegalArgumentException(String.format("%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f2), Float.valueOf(f3)));
        }
        if (f > f3) {
            throw new IllegalArgumentException(String.format("%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f2), Float.valueOf(f3)));
        }
        return f;
    }

    public static int checkArgumentInRange(int i, int i2, int i3, String str) {
        if (i < i2) {
            throw new IllegalArgumentException(String.format("%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        if (i > i3) {
            throw new IllegalArgumentException(String.format("%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        return i;
    }

    public static int checkArgumentNonnegative(int i, String str) {
        if (i < 0) {
            throw new IllegalArgumentException(str);
        }
        return i;
    }

    public static long checkArgumentNonnegative(long j, String str) {
        if (j < 0) {
            throw new IllegalArgumentException(str);
        }
        return j;
    }

    public static int checkArgumentPositive(int i, String str) {
        if (i <= 0) {
            throw new IllegalArgumentException(str);
        }
        return i;
    }

    public static float[] checkArrayElementsInRange(float[] fArr, float f, float f2, String str) {
        checkNotNull(fArr, str + " must not be null");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fArr.length) {
                return fArr;
            }
            float f3 = fArr[i2];
            if (Float.isNaN(f3)) {
                throw new IllegalArgumentException(str + "[" + i2 + "] must not be NaN");
            }
            if (f3 < f) {
                throw new IllegalArgumentException(String.format("%s[%d] is out of range of [%f, %f] (too low)", str, Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2)));
            }
            if (f3 > f2) {
                throw new IllegalArgumentException(String.format("%s[%d] is out of range of [%f, %f] (too high)", str, Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2)));
            }
            i = i2 + 1;
        }
    }

    public static <T> T[] checkArrayElementsNotNull(T[] tArr, String str) {
        if (tArr == null) {
            throw new NullPointerException(str + " must not be null");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= tArr.length) {
                return tArr;
            }
            if (tArr[i2] == null) {
                throw new NullPointerException(String.format("%s[%d] must not be null", str, Integer.valueOf(i2)));
            }
            i = i2 + 1;
        }
    }

    public static <T> Collection<T> checkCollectionElementsNotNull(Collection<T> collection, String str) {
        if (collection == null) {
            throw new NullPointerException(str + " must not be null");
        }
        long j = 0;
        for (T t : collection) {
            if (t == null) {
                throw new NullPointerException(String.format("%s[%d] must not be null", str, Long.valueOf(j)));
            }
            j++;
        }
        return collection;
    }

    public static <T> Collection<T> checkCollectionNotEmpty(Collection<T> collection, String str) {
        if (collection == null) {
            throw new NullPointerException(str + " must not be null");
        }
        if (collection.isEmpty()) {
            throw new IllegalArgumentException(str + " is empty");
        }
        return collection;
    }

    public static void checkFlagsArgument(int i, int i2) {
        if ((i & i2) != i) {
            throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i) + ", but only 0x" + Integer.toHexString(i2) + " are allowed");
        }
    }

    public static <T> T checkNotNull(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    public static <T> T checkNotNull(T t, Object obj) {
        if (t == null) {
            throw new NullPointerException(String.valueOf(obj));
        }
        return t;
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }
}
