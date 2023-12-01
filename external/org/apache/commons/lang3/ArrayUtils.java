package external.org.apache.commons.lang3;

import external.org.apache.commons.lang3.builder.EqualsBuilder;
import external.org.apache.commons.lang3.builder.HashCodeBuilder;
import external.org.apache.commons.lang3.builder.ToStringBuilder;
import external.org.apache.commons.lang3.builder.ToStringStyle;
import external.org.apache.commons.lang3.mutable.MutableInt;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-259656-dex2jar.jar:external/org/apache/commons/lang3/ArrayUtils.class */
public class ArrayUtils {
    public static final int INDEX_NOT_FOUND = -1;
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
    public static final short[] EMPTY_SHORT_ARRAY = new short[0];
    public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
    public static final char[] EMPTY_CHAR_ARRAY = new char[0];
    public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];

    private static Object add(Object obj, int i, Object obj2, Class<?> cls) {
        if (obj == null) {
            if (i != 0) {
                throw new IndexOutOfBoundsException("Index: " + i + ", Length: 0");
            }
            Object newInstance = Array.newInstance(cls, 1);
            Array.set(newInstance, 0, obj2);
            return newInstance;
        }
        int length = Array.getLength(obj);
        if (i > length || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + length);
        }
        Object newInstance2 = Array.newInstance(cls, length + 1);
        System.arraycopy(obj, 0, newInstance2, 0, i);
        Array.set(newInstance2, i, obj2);
        if (i < length) {
            System.arraycopy(obj, i, newInstance2, i + 1, length - i);
        }
        return newInstance2;
    }

    public static byte[] add(byte[] bArr, byte b) {
        byte[] bArr2 = (byte[]) copyArrayGrow1(bArr, Byte.TYPE);
        bArr2[bArr2.length - 1] = b;
        return bArr2;
    }

    public static byte[] add(byte[] bArr, int i, byte b) {
        return (byte[]) add(bArr, i, Byte.valueOf(b), Byte.TYPE);
    }

    public static char[] add(char[] cArr, char c) {
        char[] cArr2 = (char[]) copyArrayGrow1(cArr, Character.TYPE);
        cArr2[cArr2.length - 1] = c;
        return cArr2;
    }

    public static char[] add(char[] cArr, int i, char c) {
        return (char[]) add(cArr, i, Character.valueOf(c), Character.TYPE);
    }

    public static double[] add(double[] dArr, double d) {
        double[] dArr2 = (double[]) copyArrayGrow1(dArr, Double.TYPE);
        dArr2[dArr2.length - 1] = d;
        return dArr2;
    }

    public static double[] add(double[] dArr, int i, double d) {
        return (double[]) add(dArr, i, Double.valueOf(d), Double.TYPE);
    }

    public static float[] add(float[] fArr, float f) {
        float[] fArr2 = (float[]) copyArrayGrow1(fArr, Float.TYPE);
        fArr2[fArr2.length - 1] = f;
        return fArr2;
    }

    public static float[] add(float[] fArr, int i, float f) {
        return (float[]) add(fArr, i, Float.valueOf(f), Float.TYPE);
    }

    public static int[] add(int[] iArr, int i) {
        int[] iArr2 = (int[]) copyArrayGrow1(iArr, Integer.TYPE);
        iArr2[iArr2.length - 1] = i;
        return iArr2;
    }

    public static int[] add(int[] iArr, int i, int i2) {
        return (int[]) add(iArr, i, Integer.valueOf(i2), Integer.TYPE);
    }

    public static long[] add(long[] jArr, int i, long j) {
        return (long[]) add(jArr, i, Long.valueOf(j), Long.TYPE);
    }

    public static long[] add(long[] jArr, long j) {
        long[] jArr2 = (long[]) copyArrayGrow1(jArr, Long.TYPE);
        jArr2[jArr2.length - 1] = j;
        return jArr2;
    }

    public static <T> T[] add(T[] tArr, int i, T t) {
        Class<?> cls;
        if (tArr != null) {
            cls = tArr.getClass().getComponentType();
        } else if (t == null) {
            throw new IllegalArgumentException("Array and element cannot both be null");
        } else {
            cls = t.getClass();
        }
        return (T[]) ((Object[]) add(tArr, i, t, cls));
    }

    public static <T> T[] add(T[] tArr, T t) {
        Class<?> cls;
        if (tArr != null) {
            cls = tArr.getClass();
        } else if (t == null) {
            throw new IllegalArgumentException("Arguments cannot both be null");
        } else {
            cls = t.getClass();
        }
        T[] tArr2 = (T[]) ((Object[]) copyArrayGrow1(tArr, cls));
        tArr2[tArr2.length - 1] = t;
        return tArr2;
    }

    public static short[] add(short[] sArr, int i, short s) {
        return (short[]) add(sArr, i, Short.valueOf(s), Short.TYPE);
    }

    public static short[] add(short[] sArr, short s) {
        short[] sArr2 = (short[]) copyArrayGrow1(sArr, Short.TYPE);
        sArr2[sArr2.length - 1] = s;
        return sArr2;
    }

    public static boolean[] add(boolean[] zArr, int i, boolean z) {
        return (boolean[]) add(zArr, i, Boolean.valueOf(z), Boolean.TYPE);
    }

    public static boolean[] add(boolean[] zArr, boolean z) {
        boolean[] zArr2 = (boolean[]) copyArrayGrow1(zArr, Boolean.TYPE);
        zArr2[zArr2.length - 1] = z;
        return zArr2;
    }

    public static byte[] addAll(byte[] bArr, byte... bArr2) {
        if (bArr == null) {
            return clone(bArr2);
        }
        if (bArr2 == null) {
            return clone(bArr);
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy((Object) bArr, 0, (Object) bArr3, 0, bArr.length);
        System.arraycopy((Object) bArr2, 0, (Object) bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static char[] addAll(char[] cArr, char... cArr2) {
        if (cArr == null) {
            return clone(cArr2);
        }
        if (cArr2 == null) {
            return clone(cArr);
        }
        char[] cArr3 = new char[cArr.length + cArr2.length];
        System.arraycopy((Object) cArr, 0, (Object) cArr3, 0, cArr.length);
        System.arraycopy((Object) cArr2, 0, (Object) cArr3, cArr.length, cArr2.length);
        return cArr3;
    }

    public static double[] addAll(double[] dArr, double... dArr2) {
        if (dArr == null) {
            return clone(dArr2);
        }
        if (dArr2 == null) {
            return clone(dArr);
        }
        double[] dArr3 = new double[dArr.length + dArr2.length];
        System.arraycopy((Object) dArr, 0, (Object) dArr3, 0, dArr.length);
        System.arraycopy((Object) dArr2, 0, (Object) dArr3, dArr.length, dArr2.length);
        return dArr3;
    }

    public static float[] addAll(float[] fArr, float... fArr2) {
        if (fArr == null) {
            return clone(fArr2);
        }
        if (fArr2 == null) {
            return clone(fArr);
        }
        float[] fArr3 = new float[fArr.length + fArr2.length];
        System.arraycopy((Object) fArr, 0, (Object) fArr3, 0, fArr.length);
        System.arraycopy((Object) fArr2, 0, (Object) fArr3, fArr.length, fArr2.length);
        return fArr3;
    }

    public static int[] addAll(int[] iArr, int... iArr2) {
        if (iArr == null) {
            return clone(iArr2);
        }
        if (iArr2 == null) {
            return clone(iArr);
        }
        int[] iArr3 = new int[iArr.length + iArr2.length];
        System.arraycopy((Object) iArr, 0, (Object) iArr3, 0, iArr.length);
        System.arraycopy((Object) iArr2, 0, (Object) iArr3, iArr.length, iArr2.length);
        return iArr3;
    }

    public static long[] addAll(long[] jArr, long... jArr2) {
        if (jArr == null) {
            return clone(jArr2);
        }
        if (jArr2 == null) {
            return clone(jArr);
        }
        long[] jArr3 = new long[jArr.length + jArr2.length];
        System.arraycopy((Object) jArr, 0, (Object) jArr3, 0, jArr.length);
        System.arraycopy((Object) jArr2, 0, (Object) jArr3, jArr.length, jArr2.length);
        return jArr3;
    }

    public static <T> T[] addAll(T[] tArr, T... tArr2) {
        if (tArr == null) {
            return (T[]) clone(tArr2);
        }
        if (tArr2 == null) {
            return (T[]) clone(tArr);
        }
        Class<?> componentType = tArr.getClass().getComponentType();
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(componentType, tArr.length + tArr2.length));
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        try {
            System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
            return tArr3;
        } catch (ArrayStoreException e) {
            Class<?> componentType2 = tArr2.getClass().getComponentType();
            if (componentType.isAssignableFrom(componentType2)) {
                throw e;
            }
            throw new IllegalArgumentException("Cannot store " + componentType2.getName() + " in an array of " + componentType.getName(), e);
        }
    }

    public static short[] addAll(short[] sArr, short... sArr2) {
        if (sArr == null) {
            return clone(sArr2);
        }
        if (sArr2 == null) {
            return clone(sArr);
        }
        short[] sArr3 = new short[sArr.length + sArr2.length];
        System.arraycopy((Object) sArr, 0, (Object) sArr3, 0, sArr.length);
        System.arraycopy((Object) sArr2, 0, (Object) sArr3, sArr.length, sArr2.length);
        return sArr3;
    }

    public static boolean[] addAll(boolean[] zArr, boolean... zArr2) {
        if (zArr == null) {
            return clone(zArr2);
        }
        if (zArr2 == null) {
            return clone(zArr);
        }
        boolean[] zArr3 = new boolean[zArr.length + zArr2.length];
        System.arraycopy((Object) zArr, 0, (Object) zArr3, 0, zArr.length);
        System.arraycopy((Object) zArr2, 0, (Object) zArr3, zArr.length, zArr2.length);
        return zArr3;
    }

    public static byte[] clone(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public static char[] clone(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return (char[]) cArr.clone();
    }

    public static double[] clone(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        return (double[]) dArr.clone();
    }

    public static float[] clone(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        return (float[]) fArr.clone();
    }

    public static int[] clone(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    public static long[] clone(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    public static <T> T[] clone(T[] tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) ((Object[]) tArr.clone());
    }

    public static short[] clone(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return (short[]) sArr.clone();
    }

    public static boolean[] clone(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        return (boolean[]) zArr.clone();
    }

    public static boolean contains(byte[] bArr, byte b) {
        return indexOf(bArr, b) != -1;
    }

    public static boolean contains(char[] cArr, char c) {
        return indexOf(cArr, c) != -1;
    }

    public static boolean contains(double[] dArr, double d) {
        return indexOf(dArr, d) != -1;
    }

    public static boolean contains(double[] dArr, double d, double d2) {
        boolean z = false;
        if (indexOf(dArr, d, 0, d2) != -1) {
            z = true;
        }
        return z;
    }

    public static boolean contains(float[] fArr, float f) {
        return indexOf(fArr, f) != -1;
    }

    public static boolean contains(int[] iArr, int i) {
        return indexOf(iArr, i) != -1;
    }

    public static boolean contains(long[] jArr, long j) {
        return indexOf(jArr, j) != -1;
    }

    public static boolean contains(Object[] objArr, Object obj) {
        return indexOf(objArr, obj) != -1;
    }

    public static boolean contains(short[] sArr, short s) {
        return indexOf(sArr, s) != -1;
    }

    public static boolean contains(boolean[] zArr, boolean z) {
        return indexOf(zArr, z) != -1;
    }

    private static Object copyArrayGrow1(Object obj, Class<?> cls) {
        if (obj != null) {
            int length = Array.getLength(obj);
            Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + 1);
            System.arraycopy(obj, 0, newInstance, 0, length);
            return newInstance;
        }
        return Array.newInstance(cls, 1);
    }

    private static int[] extractIndices(HashSet<Integer> hashSet) {
        int[] iArr = new int[hashSet.size()];
        int i = 0;
        Iterator<Integer> it = hashSet.iterator();
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        return iArr;
    }

    public static int getLength(Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    public static int hashCode(Object obj) {
        return new HashCodeBuilder().append(obj).toHashCode();
    }

    public static int indexOf(byte[] bArr, byte b) {
        return indexOf(bArr, b, 0);
    }

    public static int indexOf(byte[] bArr, byte b, int i) {
        int i2;
        if (bArr == null) {
            i2 = -1;
        } else {
            int i3 = i;
            if (i < 0) {
                i3 = 0;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 >= bArr.length) {
                    return -1;
                }
                i2 = i5;
                if (b == bArr[i5]) {
                    break;
                }
                i4 = i5 + 1;
            }
        }
        return i2;
    }

    public static int indexOf(char[] cArr, char c) {
        return indexOf(cArr, c, 0);
    }

    public static int indexOf(char[] cArr, char c, int i) {
        int i2;
        if (cArr == null) {
            i2 = -1;
        } else {
            int i3 = i;
            if (i < 0) {
                i3 = 0;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 >= cArr.length) {
                    return -1;
                }
                i2 = i5;
                if (c == cArr[i5]) {
                    break;
                }
                i4 = i5 + 1;
            }
        }
        return i2;
    }

    public static int indexOf(double[] dArr, double d) {
        return indexOf(dArr, d, 0);
    }

    public static int indexOf(double[] dArr, double d, double d2) {
        return indexOf(dArr, d, 0, d2);
    }

    public static int indexOf(double[] dArr, double d, int i) {
        int i2;
        if (isEmpty(dArr)) {
            i2 = -1;
        } else {
            int i3 = i;
            if (i < 0) {
                i3 = 0;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 >= dArr.length) {
                    return -1;
                }
                i2 = i5;
                if (d == dArr[i5]) {
                    break;
                }
                i4 = i5 + 1;
            }
        }
        return i2;
    }

    public static int indexOf(double[] dArr, double d, int i, double d2) {
        int i2;
        if (isEmpty(dArr)) {
            i2 = -1;
        } else {
            int i3 = i;
            if (i < 0) {
                i3 = 0;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 >= dArr.length) {
                    return -1;
                }
                if (dArr[i5] >= d - d2) {
                    i2 = i5;
                    if (dArr[i5] <= d + d2) {
                        break;
                    }
                }
                i4 = i5 + 1;
            }
        }
        return i2;
    }

    public static int indexOf(float[] fArr, float f) {
        return indexOf(fArr, f, 0);
    }

    public static int indexOf(float[] fArr, float f, int i) {
        int i2;
        if (isEmpty(fArr)) {
            i2 = -1;
        } else {
            int i3 = i;
            if (i < 0) {
                i3 = 0;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 >= fArr.length) {
                    return -1;
                }
                i2 = i5;
                if (f == fArr[i5]) {
                    break;
                }
                i4 = i5 + 1;
            }
        }
        return i2;
    }

    public static int indexOf(int[] iArr, int i) {
        return indexOf(iArr, i, 0);
    }

    public static int indexOf(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null) {
            i3 = -1;
        } else {
            int i4 = i2;
            if (i2 < 0) {
                i4 = 0;
            }
            int i5 = i4;
            while (true) {
                int i6 = i5;
                if (i6 >= iArr.length) {
                    return -1;
                }
                i3 = i6;
                if (i == iArr[i6]) {
                    break;
                }
                i5 = i6 + 1;
            }
        }
        return i3;
    }

    public static int indexOf(long[] jArr, long j) {
        return indexOf(jArr, j, 0);
    }

    public static int indexOf(long[] jArr, long j, int i) {
        int i2;
        if (jArr == null) {
            i2 = -1;
        } else {
            int i3 = i;
            if (i < 0) {
                i3 = 0;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 >= jArr.length) {
                    return -1;
                }
                i2 = i5;
                if (j == jArr[i5]) {
                    break;
                }
                i4 = i5 + 1;
            }
        }
        return i2;
    }

    public static int indexOf(Object[] objArr, Object obj) {
        return indexOf(objArr, obj, 0);
    }

    public static int indexOf(Object[] objArr, Object obj, int i) {
        int i2;
        if (objArr != null) {
            int i3 = i;
            if (i < 0) {
                i3 = 0;
            }
            if (obj == null) {
                while (i3 < objArr.length) {
                    i2 = i3;
                    if (objArr[i3] != null) {
                        i3++;
                    }
                }
                return -1;
            } else if (objArr.getClass().getComponentType().isInstance(obj)) {
                while (i3 < objArr.length) {
                    i2 = i3;
                    if (!obj.equals(objArr[i3])) {
                        i3++;
                    }
                }
                return -1;
            } else {
                return -1;
            }
        }
        i2 = -1;
        return i2;
    }

    public static int indexOf(short[] sArr, short s) {
        return indexOf(sArr, s, 0);
    }

    public static int indexOf(short[] sArr, short s, int i) {
        int i2;
        if (sArr == null) {
            i2 = -1;
        } else {
            int i3 = i;
            if (i < 0) {
                i3 = 0;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 >= sArr.length) {
                    return -1;
                }
                i2 = i5;
                if (s == sArr[i5]) {
                    break;
                }
                i4 = i5 + 1;
            }
        }
        return i2;
    }

    public static int indexOf(boolean[] zArr, boolean z) {
        return indexOf(zArr, z, 0);
    }

    public static int indexOf(boolean[] zArr, boolean z, int i) {
        int i2;
        if (isEmpty(zArr)) {
            i2 = -1;
        } else {
            int i3 = i;
            if (i < 0) {
                i3 = 0;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 >= zArr.length) {
                    return -1;
                }
                i2 = i5;
                if (z == zArr[i5]) {
                    break;
                }
                i4 = i5 + 1;
            }
        }
        return i2;
    }

    public static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static boolean isEmpty(char[] cArr) {
        return cArr == null || cArr.length == 0;
    }

    public static boolean isEmpty(double[] dArr) {
        return dArr == null || dArr.length == 0;
    }

    public static boolean isEmpty(float[] fArr) {
        return fArr == null || fArr.length == 0;
    }

    public static boolean isEmpty(int[] iArr) {
        return iArr == null || iArr.length == 0;
    }

    public static boolean isEmpty(long[] jArr) {
        return jArr == null || jArr.length == 0;
    }

    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static boolean isEmpty(short[] sArr) {
        return sArr == null || sArr.length == 0;
    }

    public static boolean isEmpty(boolean[] zArr) {
        return zArr == null || zArr.length == 0;
    }

    public static boolean isEquals(Object obj, Object obj2) {
        return new EqualsBuilder().append(obj, obj2).isEquals();
    }

    public static boolean isNotEmpty(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? false : true;
    }

    public static boolean isNotEmpty(char[] cArr) {
        return (cArr == null || cArr.length == 0) ? false : true;
    }

    public static boolean isNotEmpty(double[] dArr) {
        return (dArr == null || dArr.length == 0) ? false : true;
    }

    public static boolean isNotEmpty(float[] fArr) {
        return (fArr == null || fArr.length == 0) ? false : true;
    }

    public static boolean isNotEmpty(int[] iArr) {
        return (iArr == null || iArr.length == 0) ? false : true;
    }

    public static boolean isNotEmpty(long[] jArr) {
        return (jArr == null || jArr.length == 0) ? false : true;
    }

    public static <T> boolean isNotEmpty(T[] tArr) {
        return (tArr == null || tArr.length == 0) ? false : true;
    }

    public static boolean isNotEmpty(short[] sArr) {
        return (sArr == null || sArr.length == 0) ? false : true;
    }

    public static boolean isNotEmpty(boolean[] zArr) {
        return (zArr == null || zArr.length == 0) ? false : true;
    }

    public static boolean isSameLength(byte[] bArr, byte[] bArr2) {
        if (bArr != null || bArr2 == null || bArr2.length <= 0) {
            if (bArr2 != null || bArr == null || bArr.length <= 0) {
                return bArr == null || bArr2 == null || bArr.length == bArr2.length;
            }
            return false;
        }
        return false;
    }

    public static boolean isSameLength(char[] cArr, char[] cArr2) {
        if (cArr != null || cArr2 == null || cArr2.length <= 0) {
            if (cArr2 != null || cArr == null || cArr.length <= 0) {
                return cArr == null || cArr2 == null || cArr.length == cArr2.length;
            }
            return false;
        }
        return false;
    }

    public static boolean isSameLength(double[] dArr, double[] dArr2) {
        if (dArr != null || dArr2 == null || dArr2.length <= 0) {
            if (dArr2 != null || dArr == null || dArr.length <= 0) {
                return dArr == null || dArr2 == null || dArr.length == dArr2.length;
            }
            return false;
        }
        return false;
    }

    public static boolean isSameLength(float[] fArr, float[] fArr2) {
        if (fArr != null || fArr2 == null || fArr2.length <= 0) {
            if (fArr2 != null || fArr == null || fArr.length <= 0) {
                return fArr == null || fArr2 == null || fArr.length == fArr2.length;
            }
            return false;
        }
        return false;
    }

    public static boolean isSameLength(int[] iArr, int[] iArr2) {
        if (iArr != null || iArr2 == null || iArr2.length <= 0) {
            if (iArr2 != null || iArr == null || iArr.length <= 0) {
                return iArr == null || iArr2 == null || iArr.length == iArr2.length;
            }
            return false;
        }
        return false;
    }

    public static boolean isSameLength(long[] jArr, long[] jArr2) {
        if (jArr != null || jArr2 == null || jArr2.length <= 0) {
            if (jArr2 != null || jArr == null || jArr.length <= 0) {
                return jArr == null || jArr2 == null || jArr.length == jArr2.length;
            }
            return false;
        }
        return false;
    }

    public static boolean isSameLength(Object[] objArr, Object[] objArr2) {
        if (objArr != null || objArr2 == null || objArr2.length <= 0) {
            if (objArr2 != null || objArr == null || objArr.length <= 0) {
                return objArr == null || objArr2 == null || objArr.length == objArr2.length;
            }
            return false;
        }
        return false;
    }

    public static boolean isSameLength(short[] sArr, short[] sArr2) {
        if (sArr != null || sArr2 == null || sArr2.length <= 0) {
            if (sArr2 != null || sArr == null || sArr.length <= 0) {
                return sArr == null || sArr2 == null || sArr.length == sArr2.length;
            }
            return false;
        }
        return false;
    }

    public static boolean isSameLength(boolean[] zArr, boolean[] zArr2) {
        if (zArr != null || zArr2 == null || zArr2.length <= 0) {
            if (zArr2 != null || zArr == null || zArr.length <= 0) {
                return zArr == null || zArr2 == null || zArr.length == zArr2.length;
            }
            return false;
        }
        return false;
    }

    public static boolean isSameType(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        return obj.getClass().getName().equals(obj2.getClass().getName());
    }

    public static int lastIndexOf(byte[] bArr, byte b) {
        return lastIndexOf(bArr, b, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(byte[] bArr, byte b, int i) {
        int i2;
        if (bArr == null) {
            i2 = -1;
        } else if (i < 0) {
            return -1;
        } else {
            int i3 = i;
            if (i >= bArr.length) {
                i3 = bArr.length - 1;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 < 0) {
                    return -1;
                }
                i2 = i5;
                if (b == bArr[i5]) {
                    break;
                }
                i4 = i5 - 1;
            }
        }
        return i2;
    }

    public static int lastIndexOf(char[] cArr, char c) {
        return lastIndexOf(cArr, c, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(char[] cArr, char c, int i) {
        int i2;
        if (cArr == null) {
            i2 = -1;
        } else if (i < 0) {
            return -1;
        } else {
            int i3 = i;
            if (i >= cArr.length) {
                i3 = cArr.length - 1;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 < 0) {
                    return -1;
                }
                i2 = i5;
                if (c == cArr[i5]) {
                    break;
                }
                i4 = i5 - 1;
            }
        }
        return i2;
    }

    public static int lastIndexOf(double[] dArr, double d) {
        return lastIndexOf(dArr, d, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(double[] dArr, double d, double d2) {
        return lastIndexOf(dArr, d, Integer.MAX_VALUE, d2);
    }

    public static int lastIndexOf(double[] dArr, double d, int i) {
        int i2;
        if (isEmpty(dArr)) {
            i2 = -1;
        } else if (i < 0) {
            return -1;
        } else {
            int i3 = i;
            if (i >= dArr.length) {
                i3 = dArr.length - 1;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 < 0) {
                    return -1;
                }
                i2 = i5;
                if (d == dArr[i5]) {
                    break;
                }
                i4 = i5 - 1;
            }
        }
        return i2;
    }

    public static int lastIndexOf(double[] dArr, double d, int i, double d2) {
        int i2;
        if (isEmpty(dArr)) {
            i2 = -1;
        } else if (i < 0) {
            return -1;
        } else {
            int i3 = i;
            if (i >= dArr.length) {
                i3 = dArr.length - 1;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 < 0) {
                    return -1;
                }
                if (dArr[i5] >= d - d2) {
                    i2 = i5;
                    if (dArr[i5] <= d + d2) {
                        break;
                    }
                }
                i4 = i5 - 1;
            }
        }
        return i2;
    }

    public static int lastIndexOf(float[] fArr, float f) {
        return lastIndexOf(fArr, f, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(float[] fArr, float f, int i) {
        int i2;
        if (isEmpty(fArr)) {
            i2 = -1;
        } else if (i < 0) {
            return -1;
        } else {
            int i3 = i;
            if (i >= fArr.length) {
                i3 = fArr.length - 1;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 < 0) {
                    return -1;
                }
                i2 = i5;
                if (f == fArr[i5]) {
                    break;
                }
                i4 = i5 - 1;
            }
        }
        return i2;
    }

    public static int lastIndexOf(int[] iArr, int i) {
        return lastIndexOf(iArr, i, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null) {
            i3 = -1;
        } else if (i2 < 0) {
            return -1;
        } else {
            int i4 = i2;
            if (i2 >= iArr.length) {
                i4 = iArr.length - 1;
            }
            int i5 = i4;
            while (true) {
                int i6 = i5;
                if (i6 < 0) {
                    return -1;
                }
                i3 = i6;
                if (i == iArr[i6]) {
                    break;
                }
                i5 = i6 - 1;
            }
        }
        return i3;
    }

    public static int lastIndexOf(long[] jArr, long j) {
        return lastIndexOf(jArr, j, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(long[] jArr, long j, int i) {
        int i2;
        if (jArr == null) {
            i2 = -1;
        } else if (i < 0) {
            return -1;
        } else {
            int i3 = i;
            if (i >= jArr.length) {
                i3 = jArr.length - 1;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 < 0) {
                    return -1;
                }
                i2 = i5;
                if (j == jArr[i5]) {
                    break;
                }
                i4 = i5 - 1;
            }
        }
        return i2;
    }

    public static int lastIndexOf(Object[] objArr, Object obj) {
        return lastIndexOf(objArr, obj, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(Object[] objArr, Object obj, int i) {
        int i2;
        if (objArr != null) {
            if (i < 0) {
                return -1;
            }
            int i3 = i;
            if (i >= objArr.length) {
                i3 = objArr.length - 1;
            }
            if (obj == null) {
                while (i3 >= 0) {
                    i2 = i3;
                    if (objArr[i3] != null) {
                        i3--;
                    }
                }
                return -1;
            } else if (objArr.getClass().getComponentType().isInstance(obj)) {
                while (i3 >= 0) {
                    i2 = i3;
                    if (!obj.equals(objArr[i3])) {
                        i3--;
                    }
                }
                return -1;
            } else {
                return -1;
            }
        }
        i2 = -1;
        return i2;
    }

    public static int lastIndexOf(short[] sArr, short s) {
        return lastIndexOf(sArr, s, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(short[] sArr, short s, int i) {
        int i2;
        if (sArr == null) {
            i2 = -1;
        } else if (i < 0) {
            return -1;
        } else {
            int i3 = i;
            if (i >= sArr.length) {
                i3 = sArr.length - 1;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 < 0) {
                    return -1;
                }
                i2 = i5;
                if (s == sArr[i5]) {
                    break;
                }
                i4 = i5 - 1;
            }
        }
        return i2;
    }

    public static int lastIndexOf(boolean[] zArr, boolean z) {
        return lastIndexOf(zArr, z, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(boolean[] zArr, boolean z, int i) {
        int i2;
        if (isEmpty(zArr)) {
            i2 = -1;
        } else if (i < 0) {
            return -1;
        } else {
            int i3 = i;
            if (i >= zArr.length) {
                i3 = zArr.length - 1;
            }
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 < 0) {
                    return -1;
                }
                i2 = i5;
                if (z == zArr[i5]) {
                    break;
                }
                i4 = i5 - 1;
            }
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] nullToEmpty(byte[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            byte[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_BYTE_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(byte[]):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static char[] nullToEmpty(char[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            char[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_CHAR_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(char[]):char[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static double[] nullToEmpty(double[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            double[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_DOUBLE_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(double[]):double[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static float[] nullToEmpty(float[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            float[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_FLOAT_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(float[]):float[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] nullToEmpty(int[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            int[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_INT_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(int[]):int[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long[] nullToEmpty(long[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            long[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_LONG_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(long[]):long[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Boolean[] nullToEmpty(java.lang.Boolean[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            java.lang.Boolean[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(java.lang.Boolean[]):java.lang.Boolean[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Byte[] nullToEmpty(java.lang.Byte[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            java.lang.Byte[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(java.lang.Byte[]):java.lang.Byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Character[] nullToEmpty(java.lang.Character[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            java.lang.Character[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(java.lang.Character[]):java.lang.Character[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Double[] nullToEmpty(java.lang.Double[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            java.lang.Double[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(java.lang.Double[]):java.lang.Double[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Float[] nullToEmpty(java.lang.Float[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            java.lang.Float[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(java.lang.Float[]):java.lang.Float[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Integer[] nullToEmpty(java.lang.Integer[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            java.lang.Integer[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(java.lang.Integer[]):java.lang.Integer[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Long[] nullToEmpty(java.lang.Long[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            java.lang.Long[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_LONG_OBJECT_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(java.lang.Long[]):java.lang.Long[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object[] nullToEmpty(java.lang.Object[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            java.lang.Object[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_OBJECT_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(java.lang.Object[]):java.lang.Object[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Short[] nullToEmpty(java.lang.Short[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            java.lang.Short[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(java.lang.Short[]):java.lang.Short[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] nullToEmpty(java.lang.String[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            java.lang.String[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_STRING_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(java.lang.String[]):java.lang.String[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static short[] nullToEmpty(short[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            short[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_SHORT_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(short[]):short[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r2.length == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean[] nullToEmpty(boolean[] r2) {
        /*
            r0 = r2
            if (r0 == 0) goto Lb
            r0 = r2
            r3 = r0
            r0 = r2
            int r0 = r0.length
            if (r0 != 0) goto Lf
        Lb:
            boolean[] r0 = external.org.apache.commons.lang3.ArrayUtils.EMPTY_BOOLEAN_ARRAY
            r3 = r0
        Lf:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.org.apache.commons.lang3.ArrayUtils.nullToEmpty(boolean[]):boolean[]");
    }

    private static Object remove(Object obj, int i) {
        int length = getLength(obj);
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + length);
        }
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length - 1);
        System.arraycopy(obj, 0, newInstance, 0, i);
        if (i < length - 1) {
            System.arraycopy(obj, i + 1, newInstance, i, (length - i) - 1);
        }
        return newInstance;
    }

    public static byte[] remove(byte[] bArr, int i) {
        return (byte[]) remove((Object) bArr, i);
    }

    public static char[] remove(char[] cArr, int i) {
        return (char[]) remove((Object) cArr, i);
    }

    public static double[] remove(double[] dArr, int i) {
        return (double[]) remove((Object) dArr, i);
    }

    public static float[] remove(float[] fArr, int i) {
        return (float[]) remove((Object) fArr, i);
    }

    public static int[] remove(int[] iArr, int i) {
        return (int[]) remove((Object) iArr, i);
    }

    public static long[] remove(long[] jArr, int i) {
        return (long[]) remove((Object) jArr, i);
    }

    public static <T> T[] remove(T[] tArr, int i) {
        return (T[]) ((Object[]) remove((Object) tArr, i));
    }

    public static short[] remove(short[] sArr, int i) {
        return (short[]) remove((Object) sArr, i);
    }

    public static boolean[] remove(boolean[] zArr, int i) {
        return (boolean[]) remove((Object) zArr, i);
    }

    private static Object removeAll(Object obj, int... iArr) {
        int i;
        int length = getLength(obj);
        int i2 = 0;
        int i3 = 0;
        if (isNotEmpty(iArr)) {
            Arrays.sort(iArr);
            int length2 = iArr.length;
            int i4 = length;
            while (true) {
                int i5 = length2 - 1;
                i2 = i3;
                if (i5 < 0) {
                    break;
                }
                i = iArr[i5];
                if (i < 0 || i >= length) {
                    break;
                }
                length2 = i5;
                if (i < i4) {
                    i3++;
                    i4 = i;
                    length2 = i5;
                }
            }
            throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + length);
        }
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length - i2);
        if (i2 < length) {
            int i6 = length;
            int i7 = length - i2;
            int length3 = iArr.length - 1;
            while (length3 >= 0) {
                int i8 = iArr[length3];
                int i9 = i7;
                if (i6 - i8 > 1) {
                    int i10 = (i6 - i8) - 1;
                    i9 = i7 - i10;
                    System.arraycopy(obj, i8 + 1, newInstance, i9, i10);
                }
                i6 = i8;
                length3--;
                i7 = i9;
            }
            if (i6 > 0) {
                System.arraycopy(obj, 0, newInstance, 0, i6);
            }
        }
        return newInstance;
    }

    public static byte[] removeAll(byte[] bArr, int... iArr) {
        return (byte[]) removeAll((Object) bArr, clone(iArr));
    }

    public static char[] removeAll(char[] cArr, int... iArr) {
        return (char[]) removeAll((Object) cArr, clone(iArr));
    }

    public static double[] removeAll(double[] dArr, int... iArr) {
        return (double[]) removeAll((Object) dArr, clone(iArr));
    }

    public static float[] removeAll(float[] fArr, int... iArr) {
        return (float[]) removeAll((Object) fArr, clone(iArr));
    }

    public static int[] removeAll(int[] iArr, int... iArr2) {
        return (int[]) removeAll((Object) iArr, clone(iArr2));
    }

    public static long[] removeAll(long[] jArr, int... iArr) {
        return (long[]) removeAll((Object) jArr, clone(iArr));
    }

    public static <T> T[] removeAll(T[] tArr, int... iArr) {
        return (T[]) ((Object[]) removeAll((Object) tArr, clone(iArr)));
    }

    public static short[] removeAll(short[] sArr, int... iArr) {
        return (short[]) removeAll((Object) sArr, clone(iArr));
    }

    public static boolean[] removeAll(boolean[] zArr, int... iArr) {
        return (boolean[]) removeAll((Object) zArr, clone(iArr));
    }

    public static byte[] removeElement(byte[] bArr, byte b) {
        int indexOf = indexOf(bArr, b);
        return indexOf == -1 ? clone(bArr) : remove(bArr, indexOf);
    }

    public static char[] removeElement(char[] cArr, char c) {
        int indexOf = indexOf(cArr, c);
        return indexOf == -1 ? clone(cArr) : remove(cArr, indexOf);
    }

    public static double[] removeElement(double[] dArr, double d) {
        int indexOf = indexOf(dArr, d);
        return indexOf == -1 ? clone(dArr) : remove(dArr, indexOf);
    }

    public static float[] removeElement(float[] fArr, float f) {
        int indexOf = indexOf(fArr, f);
        return indexOf == -1 ? clone(fArr) : remove(fArr, indexOf);
    }

    public static int[] removeElement(int[] iArr, int i) {
        int indexOf = indexOf(iArr, i);
        return indexOf == -1 ? clone(iArr) : remove(iArr, indexOf);
    }

    public static long[] removeElement(long[] jArr, long j) {
        int indexOf = indexOf(jArr, j);
        return indexOf == -1 ? clone(jArr) : remove(jArr, indexOf);
    }

    public static <T> T[] removeElement(T[] tArr, Object obj) {
        int indexOf = indexOf(tArr, obj);
        return indexOf == -1 ? (T[]) clone(tArr) : (T[]) remove((Object[]) tArr, indexOf);
    }

    public static short[] removeElement(short[] sArr, short s) {
        int indexOf = indexOf(sArr, s);
        return indexOf == -1 ? clone(sArr) : remove(sArr, indexOf);
    }

    public static boolean[] removeElement(boolean[] zArr, boolean z) {
        int indexOf = indexOf(zArr, z);
        return indexOf == -1 ? clone(zArr) : remove(zArr, indexOf);
    }

    public static byte[] removeElements(byte[] bArr, byte... bArr2) {
        int indexOf;
        if (isEmpty(bArr) || isEmpty(bArr2)) {
            return clone(bArr);
        }
        HashMap hashMap = new HashMap(bArr2.length);
        int length = bArr2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Byte valueOf = Byte.valueOf(bArr2[i2]);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
            if (mutableInt == null) {
                hashMap.put(valueOf, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
            i = i2 + 1;
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Byte b = (Byte) entry.getKey();
            int i3 = 0;
            int i4 = 0;
            int intValue = ((MutableInt) entry.getValue()).intValue();
            while (i4 < intValue && (indexOf = indexOf(bArr, b.byteValue(), i3)) >= 0) {
                hashSet.add(Integer.valueOf(indexOf));
                i4++;
                i3 = indexOf + 1;
            }
        }
        return removeAll(bArr, extractIndices(hashSet));
    }

    public static char[] removeElements(char[] cArr, char... cArr2) {
        int indexOf;
        if (isEmpty(cArr) || isEmpty(cArr2)) {
            return clone(cArr);
        }
        HashMap hashMap = new HashMap(cArr2.length);
        int length = cArr2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Character valueOf = Character.valueOf(cArr2[i2]);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
            if (mutableInt == null) {
                hashMap.put(valueOf, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
            i = i2 + 1;
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Character ch = (Character) entry.getKey();
            int i3 = 0;
            int i4 = 0;
            int intValue = ((MutableInt) entry.getValue()).intValue();
            while (i4 < intValue && (indexOf = indexOf(cArr, ch.charValue(), i3)) >= 0) {
                hashSet.add(Integer.valueOf(indexOf));
                i4++;
                i3 = indexOf + 1;
            }
        }
        return removeAll(cArr, extractIndices(hashSet));
    }

    public static double[] removeElements(double[] dArr, double... dArr2) {
        int indexOf;
        if (isEmpty(dArr) || isEmpty(dArr2)) {
            return clone(dArr);
        }
        HashMap hashMap = new HashMap(dArr2.length);
        int length = dArr2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Double valueOf = Double.valueOf(dArr2[i2]);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
            if (mutableInt == null) {
                hashMap.put(valueOf, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
            i = i2 + 1;
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Double d = (Double) entry.getKey();
            int i3 = 0;
            int i4 = 0;
            int intValue = ((MutableInt) entry.getValue()).intValue();
            while (i4 < intValue && (indexOf = indexOf(dArr, d.doubleValue(), i3)) >= 0) {
                hashSet.add(Integer.valueOf(indexOf));
                i4++;
                i3 = indexOf + 1;
            }
        }
        return removeAll(dArr, extractIndices(hashSet));
    }

    public static float[] removeElements(float[] fArr, float... fArr2) {
        int indexOf;
        if (isEmpty(fArr) || isEmpty(fArr2)) {
            return clone(fArr);
        }
        HashMap hashMap = new HashMap(fArr2.length);
        int length = fArr2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Float valueOf = Float.valueOf(fArr2[i2]);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
            if (mutableInt == null) {
                hashMap.put(valueOf, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
            i = i2 + 1;
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Float f = (Float) entry.getKey();
            int i3 = 0;
            int i4 = 0;
            int intValue = ((MutableInt) entry.getValue()).intValue();
            while (i4 < intValue && (indexOf = indexOf(fArr, f.floatValue(), i3)) >= 0) {
                hashSet.add(Integer.valueOf(indexOf));
                i4++;
                i3 = indexOf + 1;
            }
        }
        return removeAll(fArr, extractIndices(hashSet));
    }

    public static int[] removeElements(int[] iArr, int... iArr2) {
        int indexOf;
        if (isEmpty(iArr) || isEmpty(iArr2)) {
            return clone(iArr);
        }
        HashMap hashMap = new HashMap(iArr2.length);
        int length = iArr2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Integer valueOf = Integer.valueOf(iArr2[i2]);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
            if (mutableInt == null) {
                hashMap.put(valueOf, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
            i = i2 + 1;
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Integer num = (Integer) entry.getKey();
            int i3 = 0;
            int i4 = 0;
            int intValue = ((MutableInt) entry.getValue()).intValue();
            while (i4 < intValue && (indexOf = indexOf(iArr, num.intValue(), i3)) >= 0) {
                hashSet.add(Integer.valueOf(indexOf));
                i4++;
                i3 = indexOf + 1;
            }
        }
        return removeAll(iArr, extractIndices(hashSet));
    }

    public static long[] removeElements(long[] jArr, long... jArr2) {
        int indexOf;
        if (isEmpty(jArr) || isEmpty(jArr2)) {
            return clone(jArr);
        }
        HashMap hashMap = new HashMap(jArr2.length);
        int length = jArr2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Long valueOf = Long.valueOf(jArr2[i2]);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
            if (mutableInt == null) {
                hashMap.put(valueOf, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
            i = i2 + 1;
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Long l = (Long) entry.getKey();
            int i3 = 0;
            int i4 = 0;
            int intValue = ((MutableInt) entry.getValue()).intValue();
            while (i4 < intValue && (indexOf = indexOf(jArr, l.longValue(), i3)) >= 0) {
                hashSet.add(Integer.valueOf(indexOf));
                i4++;
                i3 = indexOf + 1;
            }
        }
        return removeAll(jArr, extractIndices(hashSet));
    }

    public static <T> T[] removeElements(T[] tArr, T... tArr2) {
        int indexOf;
        if (isEmpty(tArr) || isEmpty(tArr2)) {
            return (T[]) clone(tArr);
        }
        HashMap hashMap = new HashMap(tArr2.length);
        int length = tArr2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            T t = tArr2[i2];
            MutableInt mutableInt = (MutableInt) hashMap.get(t);
            if (mutableInt == null) {
                hashMap.put(t, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
            i = i2 + 1;
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Object key = entry.getKey();
            int i3 = 0;
            int i4 = 0;
            int intValue = ((MutableInt) entry.getValue()).intValue();
            while (i4 < intValue && (indexOf = indexOf(tArr, key, i3)) >= 0) {
                hashSet.add(Integer.valueOf(indexOf));
                i4++;
                i3 = indexOf + 1;
            }
        }
        return (T[]) removeAll((Object[]) tArr, extractIndices(hashSet));
    }

    public static short[] removeElements(short[] sArr, short... sArr2) {
        int indexOf;
        if (isEmpty(sArr) || isEmpty(sArr2)) {
            return clone(sArr);
        }
        HashMap hashMap = new HashMap(sArr2.length);
        int length = sArr2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Short valueOf = Short.valueOf(sArr2[i2]);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
            if (mutableInt == null) {
                hashMap.put(valueOf, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
            i = i2 + 1;
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Short sh = (Short) entry.getKey();
            int i3 = 0;
            int i4 = 0;
            int intValue = ((MutableInt) entry.getValue()).intValue();
            while (i4 < intValue && (indexOf = indexOf(sArr, sh.shortValue(), i3)) >= 0) {
                hashSet.add(Integer.valueOf(indexOf));
                i4++;
                i3 = indexOf + 1;
            }
        }
        return removeAll(sArr, extractIndices(hashSet));
    }

    public static boolean[] removeElements(boolean[] zArr, boolean... zArr2) {
        int indexOf;
        if (isEmpty(zArr) || isEmpty(zArr2)) {
            return clone(zArr);
        }
        HashMap hashMap = new HashMap(zArr2.length);
        int length = zArr2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Boolean valueOf = Boolean.valueOf(zArr2[i2]);
            MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
            if (mutableInt == null) {
                hashMap.put(valueOf, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
            i = i2 + 1;
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : hashMap.entrySet()) {
            Boolean bool = (Boolean) entry.getKey();
            int i3 = 0;
            int i4 = 0;
            int intValue = ((MutableInt) entry.getValue()).intValue();
            while (i4 < intValue && (indexOf = indexOf(zArr, bool.booleanValue(), i3)) >= 0) {
                hashSet.add(Integer.valueOf(indexOf));
                i4++;
                i3 = indexOf + 1;
            }
        }
        return removeAll(zArr, extractIndices(hashSet));
    }

    public static void reverse(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        int length = bArr.length - 1;
        for (int i = 0; length > i; i++) {
            byte b = bArr[length];
            bArr[length] = bArr[i];
            bArr[i] = b;
            length--;
        }
    }

    public static void reverse(char[] cArr) {
        if (cArr == null) {
            return;
        }
        int length = cArr.length - 1;
        for (int i = 0; length > i; i++) {
            char c = cArr[length];
            cArr[length] = cArr[i];
            cArr[i] = c;
            length--;
        }
    }

    public static void reverse(double[] dArr) {
        if (dArr == null) {
            return;
        }
        int length = dArr.length - 1;
        for (int i = 0; length > i; i++) {
            double d = dArr[length];
            dArr[length] = dArr[i];
            dArr[i] = d;
            length--;
        }
    }

    public static void reverse(float[] fArr) {
        if (fArr == null) {
            return;
        }
        int length = fArr.length - 1;
        for (int i = 0; length > i; i++) {
            float f = fArr[length];
            fArr[length] = fArr[i];
            fArr[i] = f;
            length--;
        }
    }

    public static void reverse(int[] iArr) {
        if (iArr == null) {
            return;
        }
        int length = iArr.length - 1;
        for (int i = 0; length > i; i++) {
            int i2 = iArr[length];
            iArr[length] = iArr[i];
            iArr[i] = i2;
            length--;
        }
    }

    public static void reverse(long[] jArr) {
        if (jArr == null) {
            return;
        }
        int length = jArr.length - 1;
        for (int i = 0; length > i; i++) {
            long j = jArr[length];
            jArr[length] = jArr[i];
            jArr[i] = j;
            length--;
        }
    }

    public static void reverse(Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length - 1;
        for (int i = 0; length > i; i++) {
            Object obj = objArr[length];
            objArr[length] = objArr[i];
            objArr[i] = obj;
            length--;
        }
    }

    public static void reverse(short[] sArr) {
        if (sArr == null) {
            return;
        }
        int length = sArr.length - 1;
        for (int i = 0; length > i; i++) {
            short s = sArr[length];
            sArr[length] = sArr[i];
            sArr[i] = s;
            length--;
        }
    }

    public static void reverse(boolean[] zArr) {
        if (zArr == null) {
            return;
        }
        int length = zArr.length - 1;
        for (int i = 0; length > i; i++) {
            boolean z = zArr[length];
            zArr[length] = zArr[i];
            zArr[i] = z;
            length--;
        }
    }

    public static byte[] subarray(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        int i3 = i;
        if (i < 0) {
            i3 = 0;
        }
        int i4 = i2;
        if (i2 > bArr.length) {
            i4 = bArr.length;
        }
        int i5 = i4 - i3;
        if (i5 <= 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[i5];
        System.arraycopy((Object) bArr, i3, (Object) bArr2, 0, i5);
        return bArr2;
    }

    public static char[] subarray(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return null;
        }
        int i3 = i;
        if (i < 0) {
            i3 = 0;
        }
        int i4 = i2;
        if (i2 > cArr.length) {
            i4 = cArr.length;
        }
        int i5 = i4 - i3;
        if (i5 <= 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArr2 = new char[i5];
        System.arraycopy((Object) cArr, i3, (Object) cArr2, 0, i5);
        return cArr2;
    }

    public static double[] subarray(double[] dArr, int i, int i2) {
        if (dArr == null) {
            return null;
        }
        int i3 = i;
        if (i < 0) {
            i3 = 0;
        }
        int i4 = i2;
        if (i2 > dArr.length) {
            i4 = dArr.length;
        }
        int i5 = i4 - i3;
        if (i5 <= 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArr2 = new double[i5];
        System.arraycopy((Object) dArr, i3, (Object) dArr2, 0, i5);
        return dArr2;
    }

    public static float[] subarray(float[] fArr, int i, int i2) {
        if (fArr == null) {
            return null;
        }
        int i3 = i;
        if (i < 0) {
            i3 = 0;
        }
        int i4 = i2;
        if (i2 > fArr.length) {
            i4 = fArr.length;
        }
        int i5 = i4 - i3;
        if (i5 <= 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArr2 = new float[i5];
        System.arraycopy((Object) fArr, i3, (Object) fArr2, 0, i5);
        return fArr2;
    }

    public static int[] subarray(int[] iArr, int i, int i2) {
        if (iArr == null) {
            return null;
        }
        int i3 = i;
        if (i < 0) {
            i3 = 0;
        }
        int i4 = i2;
        if (i2 > iArr.length) {
            i4 = iArr.length;
        }
        int i5 = i4 - i3;
        if (i5 <= 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr2 = new int[i5];
        System.arraycopy((Object) iArr, i3, (Object) iArr2, 0, i5);
        return iArr2;
    }

    public static long[] subarray(long[] jArr, int i, int i2) {
        if (jArr == null) {
            return null;
        }
        int i3 = i;
        if (i < 0) {
            i3 = 0;
        }
        int i4 = i2;
        if (i2 > jArr.length) {
            i4 = jArr.length;
        }
        int i5 = i4 - i3;
        if (i5 <= 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] jArr2 = new long[i5];
        System.arraycopy((Object) jArr, i3, (Object) jArr2, 0, i5);
        return jArr2;
    }

    public static <T> T[] subarray(T[] tArr, int i, int i2) {
        if (tArr == null) {
            return null;
        }
        int i3 = i;
        if (i < 0) {
            i3 = 0;
        }
        int i4 = i2;
        if (i2 > tArr.length) {
            i4 = tArr.length;
        }
        int i5 = i4 - i3;
        Class<?> componentType = tArr.getClass().getComponentType();
        if (i5 <= 0) {
            return (T[]) ((Object[]) Array.newInstance(componentType, 0));
        }
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(componentType, i5));
        System.arraycopy(tArr, i3, tArr2, 0, i5);
        return tArr2;
    }

    public static short[] subarray(short[] sArr, int i, int i2) {
        if (sArr == null) {
            return null;
        }
        int i3 = i;
        if (i < 0) {
            i3 = 0;
        }
        int i4 = i2;
        if (i2 > sArr.length) {
            i4 = sArr.length;
        }
        int i5 = i4 - i3;
        if (i5 <= 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr2 = new short[i5];
        System.arraycopy((Object) sArr, i3, (Object) sArr2, 0, i5);
        return sArr2;
    }

    public static boolean[] subarray(boolean[] zArr, int i, int i2) {
        if (zArr == null) {
            return null;
        }
        int i3 = i;
        if (i < 0) {
            i3 = 0;
        }
        int i4 = i2;
        if (i2 > zArr.length) {
            i4 = zArr.length;
        }
        int i5 = i4 - i3;
        if (i5 <= 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] zArr2 = new boolean[i5];
        System.arraycopy((Object) zArr, i3, (Object) zArr2, 0, i5);
        return zArr2;
    }

    public static <T> T[] toArray(T... tArr) {
        return tArr;
    }

    public static Map<Object, Object> toMap(Object[] objArr) {
        HashMap hashMap;
        if (objArr != null) {
            HashMap hashMap2 = new HashMap((int) (objArr.length * 1.5d));
            int i = 0;
            while (true) {
                int i2 = i;
                hashMap = hashMap2;
                if (i2 >= objArr.length) {
                    break;
                }
                Object obj = objArr[i2];
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    hashMap2.put(entry.getKey(), entry.getValue());
                } else if (!(obj instanceof Object[])) {
                    throw new IllegalArgumentException("Array element " + i2 + ", '" + obj + "', is neither of type Map.Entry nor an Array");
                } else {
                    Object[] objArr2 = (Object[]) obj;
                    if (objArr2.length < 2) {
                        throw new IllegalArgumentException("Array element " + i2 + ", '" + obj + "', has a length less than 2");
                    }
                    hashMap2.put(objArr2[0], objArr2[1]);
                }
                i = i2 + 1;
            }
        } else {
            hashMap = null;
        }
        return hashMap;
    }

    public static Boolean[] toObject(boolean[] zArr) {
        Boolean[] boolArr;
        if (zArr != null) {
            if (zArr.length != 0) {
                Boolean[] boolArr2 = new Boolean[zArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    boolArr = boolArr2;
                    if (i2 >= zArr.length) {
                        break;
                    }
                    boolArr2[i2] = zArr[i2] ? Boolean.TRUE : Boolean.FALSE;
                    i = i2 + 1;
                }
            } else {
                return EMPTY_BOOLEAN_OBJECT_ARRAY;
            }
        } else {
            boolArr = null;
        }
        return boolArr;
    }

    public static Byte[] toObject(byte[] bArr) {
        Byte[] bArr2;
        if (bArr != null) {
            if (bArr.length != 0) {
                Byte[] bArr3 = new Byte[bArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    bArr2 = bArr3;
                    if (i2 >= bArr.length) {
                        break;
                    }
                    bArr3[i2] = Byte.valueOf(bArr[i2]);
                    i = i2 + 1;
                }
            } else {
                return EMPTY_BYTE_OBJECT_ARRAY;
            }
        } else {
            bArr2 = null;
        }
        return bArr2;
    }

    public static Character[] toObject(char[] cArr) {
        Character[] chArr;
        if (cArr != null) {
            if (cArr.length != 0) {
                Character[] chArr2 = new Character[cArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    chArr = chArr2;
                    if (i2 >= cArr.length) {
                        break;
                    }
                    chArr2[i2] = Character.valueOf(cArr[i2]);
                    i = i2 + 1;
                }
            } else {
                return EMPTY_CHARACTER_OBJECT_ARRAY;
            }
        } else {
            chArr = null;
        }
        return chArr;
    }

    public static Double[] toObject(double[] dArr) {
        Double[] dArr2;
        if (dArr != null) {
            if (dArr.length != 0) {
                Double[] dArr3 = new Double[dArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    dArr2 = dArr3;
                    if (i2 >= dArr.length) {
                        break;
                    }
                    dArr3[i2] = Double.valueOf(dArr[i2]);
                    i = i2 + 1;
                }
            } else {
                return EMPTY_DOUBLE_OBJECT_ARRAY;
            }
        } else {
            dArr2 = null;
        }
        return dArr2;
    }

    public static Float[] toObject(float[] fArr) {
        Float[] fArr2;
        if (fArr != null) {
            if (fArr.length != 0) {
                Float[] fArr3 = new Float[fArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    fArr2 = fArr3;
                    if (i2 >= fArr.length) {
                        break;
                    }
                    fArr3[i2] = Float.valueOf(fArr[i2]);
                    i = i2 + 1;
                }
            } else {
                return EMPTY_FLOAT_OBJECT_ARRAY;
            }
        } else {
            fArr2 = null;
        }
        return fArr2;
    }

    public static Integer[] toObject(int[] iArr) {
        Integer[] numArr;
        if (iArr != null) {
            if (iArr.length != 0) {
                Integer[] numArr2 = new Integer[iArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    numArr = numArr2;
                    if (i2 >= iArr.length) {
                        break;
                    }
                    numArr2[i2] = Integer.valueOf(iArr[i2]);
                    i = i2 + 1;
                }
            } else {
                return EMPTY_INTEGER_OBJECT_ARRAY;
            }
        } else {
            numArr = null;
        }
        return numArr;
    }

    public static Long[] toObject(long[] jArr) {
        Long[] lArr;
        if (jArr != null) {
            if (jArr.length != 0) {
                Long[] lArr2 = new Long[jArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    lArr = lArr2;
                    if (i2 >= jArr.length) {
                        break;
                    }
                    lArr2[i2] = Long.valueOf(jArr[i2]);
                    i = i2 + 1;
                }
            } else {
                return EMPTY_LONG_OBJECT_ARRAY;
            }
        } else {
            lArr = null;
        }
        return lArr;
    }

    public static Short[] toObject(short[] sArr) {
        Short[] shArr;
        if (sArr != null) {
            if (sArr.length != 0) {
                Short[] shArr2 = new Short[sArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    shArr = shArr2;
                    if (i2 >= sArr.length) {
                        break;
                    }
                    shArr2[i2] = Short.valueOf(sArr[i2]);
                    i = i2 + 1;
                }
            } else {
                return EMPTY_SHORT_OBJECT_ARRAY;
            }
        } else {
            shArr = null;
        }
        return shArr;
    }

    public static byte[] toPrimitive(Byte[] bArr) {
        byte[] bArr2;
        if (bArr != null) {
            if (bArr.length != 0) {
                byte[] bArr3 = new byte[bArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    bArr2 = bArr3;
                    if (i2 >= bArr.length) {
                        break;
                    }
                    bArr3[i2] = bArr[i2].byteValue();
                    i = i2 + 1;
                }
            } else {
                return EMPTY_BYTE_ARRAY;
            }
        } else {
            bArr2 = null;
        }
        return bArr2;
    }

    public static byte[] toPrimitive(Byte[] bArr, byte b) {
        byte[] bArr2;
        if (bArr != null) {
            if (bArr.length != 0) {
                byte[] bArr3 = new byte[bArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    bArr2 = bArr3;
                    if (i2 >= bArr.length) {
                        break;
                    }
                    Byte b2 = bArr[i2];
                    bArr3[i2] = b2 == null ? b : b2.byteValue();
                    i = i2 + 1;
                }
            } else {
                return EMPTY_BYTE_ARRAY;
            }
        } else {
            bArr2 = null;
        }
        return bArr2;
    }

    public static char[] toPrimitive(Character[] chArr) {
        char[] cArr;
        if (chArr != null) {
            if (chArr.length != 0) {
                char[] cArr2 = new char[chArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    cArr = cArr2;
                    if (i2 >= chArr.length) {
                        break;
                    }
                    cArr2[i2] = chArr[i2].charValue();
                    i = i2 + 1;
                }
            } else {
                return EMPTY_CHAR_ARRAY;
            }
        } else {
            cArr = null;
        }
        return cArr;
    }

    public static char[] toPrimitive(Character[] chArr, char c) {
        char[] cArr;
        if (chArr != null) {
            if (chArr.length != 0) {
                char[] cArr2 = new char[chArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    cArr = cArr2;
                    if (i2 >= chArr.length) {
                        break;
                    }
                    Character ch = chArr[i2];
                    cArr2[i2] = ch == null ? c : ch.charValue();
                    i = i2 + 1;
                }
            } else {
                return EMPTY_CHAR_ARRAY;
            }
        } else {
            cArr = null;
        }
        return cArr;
    }

    public static double[] toPrimitive(Double[] dArr) {
        double[] dArr2;
        if (dArr != null) {
            if (dArr.length != 0) {
                double[] dArr3 = new double[dArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    dArr2 = dArr3;
                    if (i2 >= dArr.length) {
                        break;
                    }
                    dArr3[i2] = dArr[i2].doubleValue();
                    i = i2 + 1;
                }
            } else {
                return EMPTY_DOUBLE_ARRAY;
            }
        } else {
            dArr2 = null;
        }
        return dArr2;
    }

    public static double[] toPrimitive(Double[] dArr, double d) {
        double[] dArr2;
        if (dArr != null) {
            if (dArr.length != 0) {
                double[] dArr3 = new double[dArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    dArr2 = dArr3;
                    if (i2 >= dArr.length) {
                        break;
                    }
                    Double d2 = dArr[i2];
                    dArr3[i2] = d2 == null ? d : d2.doubleValue();
                    i = i2 + 1;
                }
            } else {
                return EMPTY_DOUBLE_ARRAY;
            }
        } else {
            dArr2 = null;
        }
        return dArr2;
    }

    public static float[] toPrimitive(Float[] fArr) {
        float[] fArr2;
        if (fArr != null) {
            if (fArr.length != 0) {
                float[] fArr3 = new float[fArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    fArr2 = fArr3;
                    if (i2 >= fArr.length) {
                        break;
                    }
                    fArr3[i2] = fArr[i2].floatValue();
                    i = i2 + 1;
                }
            } else {
                return EMPTY_FLOAT_ARRAY;
            }
        } else {
            fArr2 = null;
        }
        return fArr2;
    }

    public static float[] toPrimitive(Float[] fArr, float f) {
        float[] fArr2;
        if (fArr != null) {
            if (fArr.length != 0) {
                float[] fArr3 = new float[fArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    fArr2 = fArr3;
                    if (i2 >= fArr.length) {
                        break;
                    }
                    Float f2 = fArr[i2];
                    fArr3[i2] = f2 == null ? f : f2.floatValue();
                    i = i2 + 1;
                }
            } else {
                return EMPTY_FLOAT_ARRAY;
            }
        } else {
            fArr2 = null;
        }
        return fArr2;
    }

    public static int[] toPrimitive(Integer[] numArr) {
        int[] iArr;
        if (numArr != null) {
            if (numArr.length != 0) {
                int[] iArr2 = new int[numArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    iArr = iArr2;
                    if (i2 >= numArr.length) {
                        break;
                    }
                    iArr2[i2] = numArr[i2].intValue();
                    i = i2 + 1;
                }
            } else {
                return EMPTY_INT_ARRAY;
            }
        } else {
            iArr = null;
        }
        return iArr;
    }

    public static int[] toPrimitive(Integer[] numArr, int i) {
        int[] iArr;
        if (numArr != null) {
            if (numArr.length != 0) {
                int[] iArr2 = new int[numArr.length];
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    iArr = iArr2;
                    if (i3 >= numArr.length) {
                        break;
                    }
                    Integer num = numArr[i3];
                    iArr2[i3] = num == null ? i : num.intValue();
                    i2 = i3 + 1;
                }
            } else {
                return EMPTY_INT_ARRAY;
            }
        } else {
            iArr = null;
        }
        return iArr;
    }

    public static long[] toPrimitive(Long[] lArr) {
        long[] jArr;
        if (lArr != null) {
            if (lArr.length != 0) {
                long[] jArr2 = new long[lArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    jArr = jArr2;
                    if (i2 >= lArr.length) {
                        break;
                    }
                    jArr2[i2] = lArr[i2].longValue();
                    i = i2 + 1;
                }
            } else {
                return EMPTY_LONG_ARRAY;
            }
        } else {
            jArr = null;
        }
        return jArr;
    }

    public static long[] toPrimitive(Long[] lArr, long j) {
        long[] jArr;
        if (lArr != null) {
            if (lArr.length != 0) {
                long[] jArr2 = new long[lArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    jArr = jArr2;
                    if (i2 >= lArr.length) {
                        break;
                    }
                    Long l = lArr[i2];
                    jArr2[i2] = l == null ? j : l.longValue();
                    i = i2 + 1;
                }
            } else {
                return EMPTY_LONG_ARRAY;
            }
        } else {
            jArr = null;
        }
        return jArr;
    }

    public static short[] toPrimitive(Short[] shArr) {
        short[] sArr;
        if (shArr != null) {
            if (shArr.length != 0) {
                short[] sArr2 = new short[shArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    sArr = sArr2;
                    if (i2 >= shArr.length) {
                        break;
                    }
                    sArr2[i2] = shArr[i2].shortValue();
                    i = i2 + 1;
                }
            } else {
                return EMPTY_SHORT_ARRAY;
            }
        } else {
            sArr = null;
        }
        return sArr;
    }

    public static short[] toPrimitive(Short[] shArr, short s) {
        short[] sArr;
        if (shArr != null) {
            if (shArr.length != 0) {
                short[] sArr2 = new short[shArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    sArr = sArr2;
                    if (i2 >= shArr.length) {
                        break;
                    }
                    Short sh = shArr[i2];
                    sArr2[i2] = sh == null ? s : sh.shortValue();
                    i = i2 + 1;
                }
            } else {
                return EMPTY_SHORT_ARRAY;
            }
        } else {
            sArr = null;
        }
        return sArr;
    }

    public static boolean[] toPrimitive(Boolean[] boolArr) {
        boolean[] zArr;
        if (boolArr != null) {
            if (boolArr.length != 0) {
                boolean[] zArr2 = new boolean[boolArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    zArr = zArr2;
                    if (i2 >= boolArr.length) {
                        break;
                    }
                    zArr2[i2] = boolArr[i2].booleanValue();
                    i = i2 + 1;
                }
            } else {
                return EMPTY_BOOLEAN_ARRAY;
            }
        } else {
            zArr = null;
        }
        return zArr;
    }

    public static boolean[] toPrimitive(Boolean[] boolArr, boolean z) {
        boolean[] zArr;
        if (boolArr != null) {
            if (boolArr.length != 0) {
                boolean[] zArr2 = new boolean[boolArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    zArr = zArr2;
                    if (i2 >= boolArr.length) {
                        break;
                    }
                    Boolean bool = boolArr[i2];
                    zArr2[i2] = bool == null ? z : bool.booleanValue();
                    i = i2 + 1;
                }
            } else {
                return EMPTY_BOOLEAN_ARRAY;
            }
        } else {
            zArr = null;
        }
        return zArr;
    }

    public static String toString(Object obj) {
        return toString(obj, "{}");
    }

    public static String toString(Object obj, String str) {
        return obj == null ? str : new ToStringBuilder(obj, ToStringStyle.SIMPLE_STYLE).append(obj).toString();
    }
}
