package com.android.internal.util;

import android.util.ArraySet;
import dalvik.system.VMRuntime;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/ArrayUtils.class */
public class ArrayUtils {
    private static final int CACHE_SIZE = 73;
    private static Object[] sCache = new Object[73];

    private ArrayUtils() {
    }

    public static <T> ArraySet<T> add(ArraySet<T> arraySet, T t) {
        ArraySet<T> arraySet2 = arraySet;
        if (arraySet == null) {
            arraySet2 = new ArraySet<>();
        }
        arraySet2.add(t);
        return arraySet2;
    }

    public static <T> ArrayList<T> add(ArrayList<T> arrayList, T t) {
        ArrayList<T> arrayList2 = arrayList;
        if (arrayList == null) {
            arrayList2 = new ArrayList<>();
        }
        arrayList2.add(t);
        return arrayList2;
    }

    public static <T> T[] appendElement(Class<T> cls, T[] tArr, T t) {
        int i;
        Object[] objArr;
        if (tArr != null) {
            i = tArr.length;
            objArr = (Object[]) Array.newInstance((Class<?>) cls, i + 1);
            System.arraycopy(tArr, 0, objArr, 0, i);
        } else {
            i = 0;
            objArr = (Object[]) Array.newInstance((Class<?>) cls, 1);
        }
        objArr[i] = t;
        return (T[]) objArr;
    }

    public static int[] appendInt(int[] iArr, int i) {
        int[] iArr2;
        if (iArr == null) {
            iArr2 = new int[]{i};
        } else {
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    int[] iArr3 = new int[length + 1];
                    System.arraycopy(iArr, 0, iArr3, 0, length);
                    iArr3[length] = i;
                    return iArr3;
                }
                iArr2 = iArr;
                if (iArr[i3] == i) {
                    break;
                }
                i2 = i3 + 1;
            }
        }
        return iArr2;
    }

    public static long[] appendLong(long[] jArr, long j) {
        long[] jArr2;
        if (jArr == null) {
            jArr2 = new long[]{j};
        } else {
            int length = jArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    long[] jArr3 = new long[length + 1];
                    System.arraycopy(jArr, 0, jArr3, 0, length);
                    jArr3[length] = j;
                    return jArr3;
                }
                jArr2 = jArr;
                if (jArr[i2] == j) {
                    break;
                }
                i = i2 + 1;
            }
        }
        return jArr2;
    }

    public static long[] cloneOrNull(long[] jArr) {
        if (jArr != null) {
            return (long[]) jArr.clone();
        }
        return null;
    }

    public static <T> boolean contains(ArraySet<T> arraySet, T t) {
        if (arraySet != null) {
            return arraySet.contains(t);
        }
        return false;
    }

    public static <T> boolean contains(ArrayList<T> arrayList, T t) {
        if (arrayList != null) {
            return arrayList.contains(t);
        }
        return false;
    }

    public static boolean contains(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            if (iArr[i3] == i) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    public static boolean contains(long[] jArr, long j) {
        if (jArr == null) {
            return false;
        }
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

    public static <T> boolean contains(T[] tArr, T t) {
        return indexOf(tArr, t) != -1;
    }

    public static <T> boolean containsAll(T[] tArr, T[] tArr2) {
        if (tArr2 == null) {
            return true;
        }
        int length = tArr2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!contains(tArr, tArr2[i2])) {
                return false;
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
        if (r0.getClass().getComponentType() != r4) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T[] emptyArray(java.lang.Class<T> r4) {
        /*
            r0 = r4
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            if (r0 != r1) goto Ld
            java.lang.Object[] r0 = libcore.util.EmptyArray.OBJECT
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            return r0
        Ld:
            r0 = r4
            int r0 = r0.hashCode()
            r1 = 2147483647(0x7fffffff, float:NaN)
            r0 = r0 & r1
            r1 = 73
            int r0 = r0 % r1
            r5 = r0
            java.lang.Object[] r0 = com.android.internal.util.ArrayUtils.sCache
            r1 = r5
            r0 = r0[r1]
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L2f
            r0 = r7
            r6 = r0
            r0 = r7
            java.lang.Class r0 = r0.getClass()
            java.lang.Class r0 = r0.getComponentType()
            r1 = r4
            if (r0 == r1) goto L3b
        L2f:
            r0 = r4
            r1 = 0
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r1)
            r6 = r0
            java.lang.Object[] r0 = com.android.internal.util.ArrayUtils.sCache
            r1 = r5
            r2 = r6
            r0[r1] = r2
        L3b:
            r0 = r6
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.util.ArrayUtils.emptyArray(java.lang.Class):java.lang.Object[]");
    }

    public static boolean equals(byte[] bArr, byte[] bArr2, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length < i || bArr2.length < i) {
            return false;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return true;
            }
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
            i2 = i3 + 1;
        }
    }

    public static <T> int indexOf(T[] tArr, T t) {
        int i;
        if (tArr == null) {
            i = -1;
        } else {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= tArr.length) {
                    return -1;
                }
                if (tArr[i3] == null) {
                    i = i3;
                    if (t == null) {
                        break;
                    }
                } else if (t != null && tArr[i3].equals(t)) {
                    return i3;
                }
                i2 = i3 + 1;
            }
        }
        return i;
    }

    public static boolean isEmpty(int[] iArr) {
        return iArr == null || iArr.length == 0;
    }

    public static boolean isEmpty(long[] jArr) {
        return jArr == null || jArr.length == 0;
    }

    public static <T> boolean isEmpty(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static <T> T[] newUnpaddedArray(Class<T> cls, int i) {
        return (T[]) ((Object[]) VMRuntime.getRuntime().newUnpaddedArray(cls, i));
    }

    public static boolean[] newUnpaddedBooleanArray(int i) {
        return (boolean[]) VMRuntime.getRuntime().newUnpaddedArray(Boolean.TYPE, i);
    }

    public static byte[] newUnpaddedByteArray(int i) {
        return (byte[]) VMRuntime.getRuntime().newUnpaddedArray(Byte.TYPE, i);
    }

    public static char[] newUnpaddedCharArray(int i) {
        return (char[]) VMRuntime.getRuntime().newUnpaddedArray(Character.TYPE, i);
    }

    public static float[] newUnpaddedFloatArray(int i) {
        return (float[]) VMRuntime.getRuntime().newUnpaddedArray(Float.TYPE, i);
    }

    public static int[] newUnpaddedIntArray(int i) {
        return (int[]) VMRuntime.getRuntime().newUnpaddedArray(Integer.TYPE, i);
    }

    public static long[] newUnpaddedLongArray(int i) {
        return (long[]) VMRuntime.getRuntime().newUnpaddedArray(Long.TYPE, i);
    }

    public static Object[] newUnpaddedObjectArray(int i) {
        return (Object[]) VMRuntime.getRuntime().newUnpaddedArray(Object.class, i);
    }

    public static <T> ArraySet<T> remove(ArraySet<T> arraySet, T t) {
        ArraySet<T> arraySet2;
        if (arraySet == null) {
            arraySet2 = null;
        } else {
            arraySet.remove(t);
            arraySet2 = arraySet;
            if (arraySet.isEmpty()) {
                return null;
            }
        }
        return arraySet2;
    }

    public static <T> ArrayList<T> remove(ArrayList<T> arrayList, T t) {
        ArrayList<T> arrayList2;
        if (arrayList == null) {
            arrayList2 = null;
        } else {
            arrayList.remove(t);
            arrayList2 = arrayList;
            if (arrayList.isEmpty()) {
                return null;
            }
        }
        return arrayList2;
    }

    public static <T> T[] removeElement(Class<T> cls, T[] tArr, T t) {
        if (tArr != null) {
            int length = tArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                } else if (tArr[i2] == t) {
                    if (length == 1) {
                        return null;
                    }
                    T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, length - 1));
                    System.arraycopy(tArr, 0, tArr2, 0, i2);
                    System.arraycopy(tArr, i2 + 1, tArr2, i2, (length - i2) - 1);
                    return tArr2;
                } else {
                    i = i2 + 1;
                }
            }
        }
        return tArr;
    }

    public static int[] removeInt(int[] iArr, int i) {
        int[] iArr2;
        if (iArr == null) {
            iArr2 = null;
        } else {
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return iArr;
                }
                if (iArr[i3] == i) {
                    int[] iArr3 = new int[length - 1];
                    if (i3 > 0) {
                        System.arraycopy(iArr, 0, iArr3, 0, i3);
                    }
                    iArr2 = iArr3;
                    if (i3 < length - 1) {
                        System.arraycopy(iArr, i3 + 1, iArr3, i3, (length - i3) - 1);
                        return iArr3;
                    }
                } else {
                    i2 = i3 + 1;
                }
            }
        }
        return iArr2;
    }

    public static long[] removeLong(long[] jArr, long j) {
        long[] jArr2;
        if (jArr == null) {
            jArr2 = null;
        } else {
            int length = jArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return jArr;
                }
                if (jArr[i2] == j) {
                    long[] jArr3 = new long[length - 1];
                    if (i2 > 0) {
                        System.arraycopy(jArr, 0, jArr3, 0, i2);
                    }
                    jArr2 = jArr3;
                    if (i2 < length - 1) {
                        System.arraycopy(jArr, i2 + 1, jArr3, i2, (length - i2) - 1);
                        return jArr3;
                    }
                } else {
                    i = i2 + 1;
                }
            }
        }
        return jArr2;
    }

    public static long total(long[] jArr) {
        long j = 0;
        int length = jArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return j;
            }
            j += jArr[i2];
            i = i2 + 1;
        }
    }
}
