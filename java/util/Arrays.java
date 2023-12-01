package java.util;

import com.igexin.push.core.b;
import java.io.Serializable;
import java.lang.reflect.Array;

/* loaded from: source-2895416-dex2jar.jar:java/util/Arrays.class */
public class Arrays {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/Arrays$ArrayList.class */
    public static class ArrayList<E> extends AbstractList<E> implements List<E>, Serializable, RandomAccess {
        private static final long serialVersionUID = -2764017481108945198L;

        /* renamed from: a  reason: collision with root package name */
        private final E[] f42262a;

        ArrayList(E[] eArr) {
            if (eArr == null) {
                throw new NullPointerException("storage == null");
            }
            this.f42262a = eArr;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj != null) {
                E[] eArr = this.f42262a;
                int length = eArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return false;
                    }
                    if (obj.equals(eArr[i2])) {
                        return true;
                    }
                    i = i2 + 1;
                }
            } else {
                E[] eArr2 = this.f42262a;
                int length2 = eArr2.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length2) {
                        return false;
                    }
                    if (eArr2[i4] == null) {
                        return true;
                    }
                    i3 = i4 + 1;
                }
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            try {
                return this.f42262a[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw java.util.ArrayList.throwIndexOutOfBoundsException(i, this.f42262a.length);
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.f42262a.length) {
                        return -1;
                    }
                    if (obj.equals(this.f42262a[i2])) {
                        return i2;
                    }
                    i = i2 + 1;
                }
            } else {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= this.f42262a.length) {
                        return -1;
                    }
                    if (this.f42262a[i4] == null) {
                        return i4;
                    }
                    i3 = i4 + 1;
                }
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj != null) {
                int length = this.f42262a.length;
                while (true) {
                    int i = length - 1;
                    if (i < 0) {
                        return -1;
                    }
                    if (obj.equals(this.f42262a[i])) {
                        return i;
                    }
                    length = i;
                }
            } else {
                int length2 = this.f42262a.length;
                while (true) {
                    int i2 = length2 - 1;
                    if (i2 < 0) {
                        return -1;
                    }
                    if (this.f42262a[i2] == null) {
                        return i2;
                    }
                    length2 = i2;
                }
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int i, E e) {
            E e2 = this.f42262a[i];
            this.f42262a[i] = e;
            return e2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f42262a.length;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return (Object[]) this.f42262a.clone();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object[]] */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            int size = size();
            T[] tArr2 = tArr;
            if (size > tArr.length) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
            }
            System.arraycopy(this.f42262a, 0, tArr2, 0, size);
            if (size < tArr2.length) {
                tArr2[size] = null;
            }
            return tArr2;
        }
    }

    private Arrays() {
    }

    @SafeVarargs
    public static <T> List<T> asList(T... tArr) {
        return new ArrayList(tArr);
    }

    public static int binarySearch(byte[] bArr, byte b) {
        return binarySearch(bArr, 0, bArr.length, b);
    }

    public static int binarySearch(byte[] bArr, int i, int i2, byte b) {
        int i3;
        checkBinarySearchBounds(i, i2, bArr.length);
        int i4 = i2 - 1;
        while (true) {
            if (i > i4) {
                i3 = i ^ (-1);
                break;
            }
            int i5 = (i + i4) >>> 1;
            byte b2 = bArr[i5];
            if (b2 >= b) {
                i3 = i5;
                if (b2 <= b) {
                    break;
                }
                i4 = i5 - 1;
            } else {
                i = i5 + 1;
            }
        }
        return i3;
    }

    public static int binarySearch(char[] cArr, char c2) {
        return binarySearch(cArr, 0, cArr.length, c2);
    }

    public static int binarySearch(char[] cArr, int i, int i2, char c2) {
        int i3;
        checkBinarySearchBounds(i, i2, cArr.length);
        int i4 = i2 - 1;
        while (true) {
            if (i > i4) {
                i3 = i ^ (-1);
                break;
            }
            int i5 = (i + i4) >>> 1;
            char c3 = cArr[i5];
            if (c3 >= c2) {
                i3 = i5;
                if (c3 <= c2) {
                    break;
                }
                i4 = i5 - 1;
            } else {
                i = i5 + 1;
            }
        }
        return i3;
    }

    public static int binarySearch(double[] dArr, double d) {
        return binarySearch(dArr, 0, dArr.length, d);
    }

    public static int binarySearch(double[] dArr, int i, int i2, double d) {
        checkBinarySearchBounds(i, i2, dArr.length);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            double d2 = dArr[i4];
            if (d2 < d) {
                i = i4 + 1;
            } else if (d2 <= d) {
                if (d2 == 0.0d || d2 != d) {
                    long doubleToLongBits = Double.doubleToLongBits(d2);
                    long doubleToLongBits2 = Double.doubleToLongBits(d);
                    if (doubleToLongBits < doubleToLongBits2) {
                        i = i4 + 1;
                    } else if (doubleToLongBits > doubleToLongBits2) {
                        i3 = i4 - 1;
                    }
                }
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i ^ (-1);
    }

    public static int binarySearch(float[] fArr, float f) {
        return binarySearch(fArr, 0, fArr.length, f);
    }

    public static int binarySearch(float[] fArr, int i, int i2, float f) {
        checkBinarySearchBounds(i, i2, fArr.length);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            float f2 = fArr[i4];
            if (f2 < f) {
                i = i4 + 1;
            } else if (f2 <= f) {
                if (f2 == 0.0f || f2 != f) {
                    int floatToIntBits = Float.floatToIntBits(f2);
                    int floatToIntBits2 = Float.floatToIntBits(f);
                    if (floatToIntBits < floatToIntBits2) {
                        i = i4 + 1;
                    } else if (floatToIntBits > floatToIntBits2) {
                        i3 = i4 - 1;
                    }
                }
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i ^ (-1);
    }

    public static int binarySearch(int[] iArr, int i) {
        return binarySearch(iArr, 0, iArr.length, i);
    }

    public static int binarySearch(int[] iArr, int i, int i2, int i3) {
        int i4;
        checkBinarySearchBounds(i, i2, iArr.length);
        int i5 = i2 - 1;
        while (true) {
            if (i > i5) {
                i4 = i ^ (-1);
                break;
            }
            int i6 = (i + i5) >>> 1;
            int i7 = iArr[i6];
            if (i7 >= i3) {
                i4 = i6;
                if (i7 <= i3) {
                    break;
                }
                i5 = i6 - 1;
            } else {
                i = i6 + 1;
            }
        }
        return i4;
    }

    public static int binarySearch(long[] jArr, int i, int i2, long j) {
        int i3;
        checkBinarySearchBounds(i, i2, jArr.length);
        int i4 = i2 - 1;
        while (true) {
            if (i > i4) {
                i3 = i ^ (-1);
                break;
            }
            int i5 = (i + i4) >>> 1;
            long j2 = jArr[i5];
            if (j2 >= j) {
                i3 = i5;
                if (j2 <= j) {
                    break;
                }
                i4 = i5 - 1;
            } else {
                i = i5 + 1;
            }
        }
        return i3;
    }

    public static int binarySearch(long[] jArr, long j) {
        return binarySearch(jArr, 0, jArr.length, j);
    }

    public static int binarySearch(Object[] objArr, int i, int i2, Object obj) {
        int i3;
        checkBinarySearchBounds(i, i2, objArr.length);
        int i4 = i2 - 1;
        while (true) {
            if (i > i4) {
                i3 = i ^ (-1);
                break;
            }
            int i5 = (i + i4) >>> 1;
            int compareTo = ((Comparable) objArr[i5]).compareTo(obj);
            if (compareTo >= 0) {
                i3 = i5;
                if (compareTo <= 0) {
                    break;
                }
                i4 = i5 - 1;
            } else {
                i = i5 + 1;
            }
        }
        return i3;
    }

    public static <T> int binarySearch(T[] tArr, int i, int i2, T t, Comparator<? super T> comparator) {
        int i3;
        if (comparator != null) {
            checkBinarySearchBounds(i, i2, tArr.length);
            int i4 = i2 - 1;
            while (i <= i4) {
                int i5 = (i + i4) >>> 1;
                int compare = comparator.compare(tArr[i5], t);
                if (compare < 0) {
                    i = i5 + 1;
                } else {
                    i3 = i5;
                    if (compare > 0) {
                        i4 = i5 - 1;
                    }
                }
            }
            return i ^ (-1);
        }
        i3 = binarySearch(tArr, i, i2, t);
        return i3;
    }

    public static int binarySearch(Object[] objArr, Object obj) {
        return binarySearch(objArr, 0, objArr.length, obj);
    }

    public static <T> int binarySearch(T[] tArr, T t, Comparator<? super T> comparator) {
        return binarySearch(tArr, 0, tArr.length, t, comparator);
    }

    public static int binarySearch(short[] sArr, int i, int i2, short s) {
        int i3;
        checkBinarySearchBounds(i, i2, sArr.length);
        int i4 = i2 - 1;
        while (true) {
            if (i > i4) {
                i3 = i ^ (-1);
                break;
            }
            int i5 = (i + i4) >>> 1;
            short s2 = sArr[i5];
            if (s2 >= s) {
                i3 = i5;
                if (s2 <= s) {
                    break;
                }
                i4 = i5 - 1;
            } else {
                i = i5 + 1;
            }
        }
        return i3;
    }

    public static int binarySearch(short[] sArr, short s) {
        return binarySearch(sArr, 0, sArr.length, s);
    }

    private static void checkBinarySearchBounds(int i, int i2, int i3) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        if (i < 0 || i2 > i3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void checkOffsetAndCount(int i, int i2, int i3) {
        if ((i2 | i3) < 0 || i2 > i || i - i2 < i3) {
            throw new ArrayIndexOutOfBoundsException(i, i2, i3);
        }
    }

    public static void checkStartAndEnd(int i, int i2, int i3) {
        if (i2 < 0 || i3 > i) {
            throw new ArrayIndexOutOfBoundsException("start < 0 || end > len. start=" + i2 + ", end=" + i3 + ", len=" + i);
        }
        if (i2 > i3) {
            throw new IllegalArgumentException("start > end: " + i2 + " > " + i3);
        }
    }

    public static byte[] copyOf(byte[] bArr, int i) {
        if (i < 0) {
            throw new NegativeArraySizeException(Integer.toString(i));
        }
        return copyOfRange(bArr, 0, i);
    }

    public static char[] copyOf(char[] cArr, int i) {
        if (i < 0) {
            throw new NegativeArraySizeException(Integer.toString(i));
        }
        return copyOfRange(cArr, 0, i);
    }

    public static double[] copyOf(double[] dArr, int i) {
        if (i < 0) {
            throw new NegativeArraySizeException(Integer.toString(i));
        }
        return copyOfRange(dArr, 0, i);
    }

    public static float[] copyOf(float[] fArr, int i) {
        if (i < 0) {
            throw new NegativeArraySizeException(Integer.toString(i));
        }
        return copyOfRange(fArr, 0, i);
    }

    public static int[] copyOf(int[] iArr, int i) {
        if (i < 0) {
            throw new NegativeArraySizeException(Integer.toString(i));
        }
        return copyOfRange(iArr, 0, i);
    }

    public static long[] copyOf(long[] jArr, int i) {
        if (i < 0) {
            throw new NegativeArraySizeException(Integer.toString(i));
        }
        return copyOfRange(jArr, 0, i);
    }

    public static <T> T[] copyOf(T[] tArr, int i) {
        if (tArr == null) {
            throw new NullPointerException("original == null");
        }
        if (i < 0) {
            throw new NegativeArraySizeException(Integer.toString(i));
        }
        return (T[]) copyOfRange(tArr, 0, i);
    }

    public static <T, U> T[] copyOf(U[] uArr, int i, Class<? extends T[]> cls) {
        if (i < 0) {
            throw new NegativeArraySizeException(Integer.toString(i));
        }
        return (T[]) copyOfRange(uArr, 0, i, cls);
    }

    public static short[] copyOf(short[] sArr, int i) {
        if (i < 0) {
            throw new NegativeArraySizeException(Integer.toString(i));
        }
        return copyOfRange(sArr, 0, i);
    }

    public static boolean[] copyOf(boolean[] zArr, int i) {
        if (i < 0) {
            throw new NegativeArraySizeException(Integer.toString(i));
        }
        return copyOfRange(zArr, 0, i);
    }

    public static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = bArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, min);
        return bArr2;
    }

    public static char[] copyOfRange(char[] cArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = cArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        char[] cArr2 = new char[i3];
        System.arraycopy(cArr, i, cArr2, 0, min);
        return cArr2;
    }

    public static double[] copyOfRange(double[] dArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = dArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        double[] dArr2 = new double[i3];
        System.arraycopy(dArr, i, dArr2, 0, min);
        return dArr2;
    }

    public static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, min);
        return fArr2;
    }

    public static int[] copyOfRange(int[] iArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = iArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        int[] iArr2 = new int[i3];
        System.arraycopy(iArr, i, iArr2, 0, min);
        return iArr2;
    }

    public static long[] copyOfRange(long[] jArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = jArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        long[] jArr2 = new long[i3];
        System.arraycopy(jArr, i, jArr2, 0, min);
        return jArr2;
    }

    public static <T> T[] copyOfRange(T[] tArr, int i, int i2) {
        int length = tArr.length;
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3));
        System.arraycopy(tArr, i, tArr2, 0, min);
        return tArr2;
    }

    public static <T, U> T[] copyOfRange(U[] uArr, int i, int i2, Class<? extends T[]> cls) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = uArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        T[] tArr = (T[]) ((Object[]) Array.newInstance(cls.getComponentType(), i3));
        System.arraycopy(uArr, i, tArr, 0, min);
        return tArr;
    }

    public static short[] copyOfRange(short[] sArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = sArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        short[] sArr2 = new short[i3];
        System.arraycopy(sArr, i, sArr2, 0, min);
        return sArr2;
    }

    public static boolean[] copyOfRange(boolean[] zArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = zArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        boolean[] zArr2 = new boolean[i3];
        System.arraycopy(zArr, i, zArr2, 0, min);
        return zArr2;
    }

    public static boolean deepEquals(Object[] objArr, Object[] objArr2) {
        if (objArr == objArr2) {
            return true;
        }
        if (objArr == null || objArr2 == null || objArr.length != objArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return true;
            }
            if (!deepEqualsElements(objArr[i2], objArr2[i2])) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private static boolean deepEqualsElements(Object obj, Object obj2) {
        boolean z;
        if (obj == obj2) {
            z = true;
        } else {
            z = false;
            if (obj != null) {
                z = false;
                if (obj2 != null) {
                    Class<?> componentType = obj.getClass().getComponentType();
                    z = false;
                    if (componentType == obj2.getClass().getComponentType()) {
                        return componentType == null ? obj.equals(obj2) : obj instanceof Object[] ? deepEquals((Object[]) obj, (Object[]) obj2) : componentType == Integer.TYPE ? equals((int[]) obj, (int[]) obj2) : componentType == Character.TYPE ? equals((char[]) obj, (char[]) obj2) : componentType == Boolean.TYPE ? equals((boolean[]) obj, (boolean[]) obj2) : componentType == Byte.TYPE ? equals((byte[]) obj, (byte[]) obj2) : componentType == Long.TYPE ? equals((long[]) obj, (long[]) obj2) : componentType == Float.TYPE ? equals((float[]) obj, (float[]) obj2) : componentType == Double.TYPE ? equals((double[]) obj, (double[]) obj2) : equals((short[]) obj, (short[]) obj2);
                    }
                }
            }
        }
        return z;
    }

    public static int deepHashCode(Object[] objArr) {
        int i;
        if (objArr != null) {
            int i2 = 1;
            int length = objArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i = i2;
                if (i4 >= length) {
                    break;
                }
                i2 = (i2 * 31) + deepHashCodeElement(objArr[i4]);
                i3 = i4 + 1;
            }
        } else {
            i = 0;
        }
        return i;
    }

    private static int deepHashCodeElement(Object obj) {
        if (obj == null) {
            return 0;
        }
        Class<?> componentType = obj.getClass().getComponentType();
        return componentType == null ? obj.hashCode() : obj instanceof Object[] ? deepHashCode((Object[]) obj) : componentType == Integer.TYPE ? hashCode((int[]) obj) : componentType == Character.TYPE ? hashCode((char[]) obj) : componentType == Boolean.TYPE ? hashCode((boolean[]) obj) : componentType == Byte.TYPE ? hashCode((byte[]) obj) : componentType == Long.TYPE ? hashCode((long[]) obj) : componentType == Float.TYPE ? hashCode((float[]) obj) : componentType == Double.TYPE ? hashCode((double[]) obj) : hashCode((short[]) obj);
    }

    public static String deepToString(Object[] objArr) {
        if (objArr == null) {
            return b.l;
        }
        StringBuilder sb = new StringBuilder(objArr.length * 9);
        deepToStringImpl(objArr, new Object[]{objArr}, sb);
        return sb.toString();
    }

    private static void deepToStringImpl(Object[] objArr, Object[] objArr2, StringBuilder sb) {
        if (objArr == null) {
            sb.append(b.l);
            return;
        }
        sb.append('[');
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                sb.append(']');
                return;
            }
            if (i2 != 0) {
                sb.append(", ");
            }
            Object obj = objArr[i2];
            if (obj == null) {
                sb.append(b.l);
            } else {
                Class<?> cls = obj.getClass();
                if (cls.isArray()) {
                    Class<?> componentType = cls.getComponentType();
                    if (componentType.isPrimitive()) {
                        if (Boolean.TYPE.equals(componentType)) {
                            sb.append(toString((boolean[]) obj));
                        } else if (Byte.TYPE.equals(componentType)) {
                            sb.append(toString((byte[]) obj));
                        } else if (Character.TYPE.equals(componentType)) {
                            sb.append(toString((char[]) obj));
                        } else if (Double.TYPE.equals(componentType)) {
                            sb.append(toString((double[]) obj));
                        } else if (Float.TYPE.equals(componentType)) {
                            sb.append(toString((float[]) obj));
                        } else if (Integer.TYPE.equals(componentType)) {
                            sb.append(toString((int[]) obj));
                        } else if (Long.TYPE.equals(componentType)) {
                            sb.append(toString((long[]) obj));
                        } else if (!Short.TYPE.equals(componentType)) {
                            throw new AssertionError();
                        } else {
                            sb.append(toString((short[]) obj));
                        }
                    } else if (deepToStringImplContains(objArr2, obj)) {
                        sb.append("[...]");
                    } else {
                        Object[] objArr3 = (Object[]) obj;
                        Object[] objArr4 = new Object[objArr2.length + 1];
                        System.arraycopy(objArr2, 0, objArr4, 0, objArr2.length);
                        objArr4[objArr2.length] = objArr3;
                        deepToStringImpl(objArr3, objArr4, sb);
                    }
                } else {
                    sb.append(objArr[i2]);
                }
            }
            i = i2 + 1;
        }
    }

    private static boolean deepToStringImplContains(Object[] objArr, Object obj) {
        if (objArr == null || objArr.length == 0) {
            return false;
        }
        int length = objArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (objArr[i2] == obj) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean equals(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean equals(char[] cArr, char[] cArr2) {
        if (cArr == cArr2) {
            return true;
        }
        if (cArr == null || cArr2 == null || cArr.length != cArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= cArr.length) {
                return true;
            }
            if (cArr[i2] != cArr2[i2]) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean equals(double[] dArr, double[] dArr2) {
        if (dArr == dArr2) {
            return true;
        }
        if (dArr == null || dArr2 == null || dArr.length != dArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dArr.length) {
                return true;
            }
            if (Double.doubleToLongBits(dArr[i2]) != Double.doubleToLongBits(dArr2[i2])) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean equals(float[] fArr, float[] fArr2) {
        if (fArr == fArr2) {
            return true;
        }
        if (fArr == null || fArr2 == null || fArr.length != fArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fArr.length) {
                return true;
            }
            if (Float.floatToIntBits(fArr[i2]) != Float.floatToIntBits(fArr2[i2])) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean equals(int[] iArr, int[] iArr2) {
        if (iArr == iArr2) {
            return true;
        }
        if (iArr == null || iArr2 == null || iArr.length != iArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                return true;
            }
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean equals(long[] jArr, long[] jArr2) {
        if (jArr == jArr2) {
            return true;
        }
        if (jArr == null || jArr2 == null || jArr.length != jArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jArr.length) {
                return true;
            }
            if (jArr[i2] != jArr2[i2]) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        if (objArr == objArr2) {
            return true;
        }
        if (objArr == null || objArr2 == null || objArr.length != objArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return true;
            }
            Object obj = objArr[i2];
            Object obj2 = objArr2[i2];
            if (obj == null) {
                if (obj2 != null) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean equals(short[] sArr, short[] sArr2) {
        if (sArr == sArr2) {
            return true;
        }
        if (sArr == null || sArr2 == null || sArr.length != sArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sArr.length) {
                return true;
            }
            if (sArr[i2] != sArr2[i2]) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean equals(boolean[] zArr, boolean[] zArr2) {
        if (zArr == zArr2) {
            return true;
        }
        if (zArr == null || zArr2 == null || zArr.length != zArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= zArr.length) {
                return true;
            }
            if (zArr[i2] != zArr2[i2]) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static void fill(byte[] bArr, byte b) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return;
            }
            bArr[i2] = b;
            i = i2 + 1;
        }
    }

    public static void fill(byte[] bArr, int i, int i2, byte b) {
        checkStartAndEnd(bArr.length, i, i2);
        while (i < i2) {
            bArr[i] = b;
            i++;
        }
    }

    public static void fill(char[] cArr, char c2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= cArr.length) {
                return;
            }
            cArr[i2] = c2;
            i = i2 + 1;
        }
    }

    public static void fill(char[] cArr, int i, int i2, char c2) {
        checkStartAndEnd(cArr.length, i, i2);
        while (i < i2) {
            cArr[i] = c2;
            i++;
        }
    }

    public static void fill(double[] dArr, double d) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dArr.length) {
                return;
            }
            dArr[i2] = d;
            i = i2 + 1;
        }
    }

    public static void fill(double[] dArr, int i, int i2, double d) {
        checkStartAndEnd(dArr.length, i, i2);
        while (i < i2) {
            dArr[i] = d;
            i++;
        }
    }

    public static void fill(float[] fArr, float f) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fArr.length) {
                return;
            }
            fArr[i2] = f;
            i = i2 + 1;
        }
    }

    public static void fill(float[] fArr, int i, int i2, float f) {
        checkStartAndEnd(fArr.length, i, i2);
        while (i < i2) {
            fArr[i] = f;
            i++;
        }
    }

    public static void fill(int[] iArr, int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length) {
                return;
            }
            iArr[i3] = i;
            i2 = i3 + 1;
        }
    }

    public static void fill(int[] iArr, int i, int i2, int i3) {
        checkStartAndEnd(iArr.length, i, i2);
        while (i < i2) {
            iArr[i] = i3;
            i++;
        }
    }

    public static void fill(long[] jArr, int i, int i2, long j) {
        checkStartAndEnd(jArr.length, i, i2);
        while (i < i2) {
            jArr[i] = j;
            i++;
        }
    }

    public static void fill(long[] jArr, long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jArr.length) {
                return;
            }
            jArr[i2] = j;
            i = i2 + 1;
        }
    }

    public static void fill(Object[] objArr, int i, int i2, Object obj) {
        checkStartAndEnd(objArr.length, i, i2);
        while (i < i2) {
            objArr[i] = obj;
            i++;
        }
    }

    public static void fill(Object[] objArr, Object obj) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return;
            }
            objArr[i2] = obj;
            i = i2 + 1;
        }
    }

    public static void fill(short[] sArr, int i, int i2, short s) {
        checkStartAndEnd(sArr.length, i, i2);
        while (i < i2) {
            sArr[i] = s;
            i++;
        }
    }

    public static void fill(short[] sArr, short s) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sArr.length) {
                return;
            }
            sArr[i2] = s;
            i = i2 + 1;
        }
    }

    public static void fill(boolean[] zArr, int i, int i2, boolean z) {
        checkStartAndEnd(zArr.length, i, i2);
        while (i < i2) {
            zArr[i] = z;
            i++;
        }
    }

    public static void fill(boolean[] zArr, boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= zArr.length) {
                return;
            }
            zArr[i2] = z;
            i = i2 + 1;
        }
    }

    public static int hashCode(byte[] bArr) {
        int i;
        if (bArr != null) {
            int i2 = 1;
            int length = bArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i = i2;
                if (i4 >= length) {
                    break;
                }
                i2 = (i2 * 31) + bArr[i4];
                i3 = i4 + 1;
            }
        } else {
            i = 0;
        }
        return i;
    }

    public static int hashCode(char[] cArr) {
        int i;
        if (cArr != null) {
            int i2 = 1;
            int length = cArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i = i2;
                if (i4 >= length) {
                    break;
                }
                i2 = (i2 * 31) + cArr[i4];
                i3 = i4 + 1;
            }
        } else {
            i = 0;
        }
        return i;
    }

    public static int hashCode(double[] dArr) {
        int i;
        if (dArr != null) {
            int i2 = 1;
            int length = dArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i = i2;
                if (i4 >= length) {
                    break;
                }
                long doubleToLongBits = Double.doubleToLongBits(dArr[i4]);
                i2 = (i2 * 31) + ((int) ((doubleToLongBits >>> 32) ^ doubleToLongBits));
                i3 = i4 + 1;
            }
        } else {
            i = 0;
        }
        return i;
    }

    public static int hashCode(float[] fArr) {
        int i;
        if (fArr != null) {
            int i2 = 1;
            int length = fArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i = i2;
                if (i4 >= length) {
                    break;
                }
                i2 = (i2 * 31) + Float.floatToIntBits(fArr[i4]);
                i3 = i4 + 1;
            }
        } else {
            i = 0;
        }
        return i;
    }

    public static int hashCode(int[] iArr) {
        int i;
        if (iArr != null) {
            int i2 = 1;
            int length = iArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i = i2;
                if (i4 >= length) {
                    break;
                }
                i2 = (i2 * 31) + iArr[i4];
                i3 = i4 + 1;
            }
        } else {
            i = 0;
        }
        return i;
    }

    public static int hashCode(long[] jArr) {
        int i;
        if (jArr != null) {
            int i2 = 1;
            int length = jArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i = i2;
                if (i4 >= length) {
                    break;
                }
                long j = jArr[i4];
                i2 = (i2 * 31) + ((int) ((j >>> 32) ^ j));
                i3 = i4 + 1;
            }
        } else {
            i = 0;
        }
        return i;
    }

    public static int hashCode(Object[] objArr) {
        int i;
        if (objArr != null) {
            int i2 = 1;
            int length = objArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i = i2;
                if (i4 >= length) {
                    break;
                }
                Object obj = objArr[i4];
                i2 = (i2 * 31) + (obj == null ? 0 : obj.hashCode());
                i3 = i4 + 1;
            }
        } else {
            i = 0;
        }
        return i;
    }

    public static int hashCode(short[] sArr) {
        int i;
        if (sArr != null) {
            int i2 = 1;
            int length = sArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i = i2;
                if (i4 >= length) {
                    break;
                }
                i2 = (i2 * 31) + sArr[i4];
                i3 = i4 + 1;
            }
        } else {
            i = 0;
        }
        return i;
    }

    public static int hashCode(boolean[] zArr) {
        int i;
        if (zArr != null) {
            int i2 = 1;
            int length = zArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                i = i2;
                if (i4 >= length) {
                    break;
                }
                i2 = (i2 * 31) + (zArr[i4] ? 1231 : 1237);
                i3 = i4 + 1;
            }
        } else {
            i = 0;
        }
        return i;
    }

    public static void sort(byte[] bArr) {
        DualPivotQuicksort.sort(bArr);
    }

    public static void sort(byte[] bArr, int i, int i2) {
        DualPivotQuicksort.sort(bArr, i, i2);
    }

    public static void sort(char[] cArr) {
        DualPivotQuicksort.sort(cArr);
    }

    public static void sort(char[] cArr, int i, int i2) {
        DualPivotQuicksort.sort(cArr, i, i2);
    }

    public static void sort(double[] dArr) {
        DualPivotQuicksort.sort(dArr);
    }

    public static void sort(double[] dArr, int i, int i2) {
        DualPivotQuicksort.sort(dArr, i, i2);
    }

    public static void sort(float[] fArr) {
        DualPivotQuicksort.sort(fArr);
    }

    public static void sort(float[] fArr, int i, int i2) {
        DualPivotQuicksort.sort(fArr, i, i2);
    }

    public static void sort(int[] iArr) {
        DualPivotQuicksort.sort(iArr);
    }

    public static void sort(int[] iArr, int i, int i2) {
        DualPivotQuicksort.sort(iArr, i, i2);
    }

    public static void sort(long[] jArr) {
        DualPivotQuicksort.sort(jArr);
    }

    public static void sort(long[] jArr, int i, int i2) {
        DualPivotQuicksort.sort(jArr, i, i2);
    }

    public static void sort(Object[] objArr) {
        ComparableTimSort.sort(objArr);
    }

    public static void sort(Object[] objArr, int i, int i2) {
        ComparableTimSort.sort(objArr, i, i2);
    }

    public static <T> void sort(T[] tArr, int i, int i2, Comparator<? super T> comparator) {
        TimSort.sort(tArr, i, i2, comparator);
    }

    public static <T> void sort(T[] tArr, Comparator<? super T> comparator) {
        TimSort.sort(tArr, comparator);
    }

    public static void sort(short[] sArr) {
        DualPivotQuicksort.sort(sArr);
    }

    public static void sort(short[] sArr, int i, int i2) {
        DualPivotQuicksort.sort(sArr, i, i2);
    }

    public static String toString(byte[] bArr) {
        if (bArr == null) {
            return b.l;
        }
        if (bArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 6);
        sb.append('[');
        sb.append((int) bArr[0]);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append((int) bArr[i2]);
            i = i2 + 1;
        }
    }

    public static String toString(char[] cArr) {
        if (cArr == null) {
            return b.l;
        }
        if (cArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(cArr.length * 3);
        sb.append('[');
        sb.append(cArr[0]);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= cArr.length) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(cArr[i2]);
            i = i2 + 1;
        }
    }

    public static String toString(double[] dArr) {
        if (dArr == null) {
            return b.l;
        }
        if (dArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(dArr.length * 7);
        sb.append('[');
        sb.append(dArr[0]);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= dArr.length) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(dArr[i2]);
            i = i2 + 1;
        }
    }

    public static String toString(float[] fArr) {
        if (fArr == null) {
            return b.l;
        }
        if (fArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(fArr.length * 7);
        sb.append('[');
        sb.append(fArr[0]);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= fArr.length) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(fArr[i2]);
            i = i2 + 1;
        }
    }

    public static String toString(int[] iArr) {
        if (iArr == null) {
            return b.l;
        }
        if (iArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 6);
        sb.append('[');
        sb.append(iArr[0]);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(iArr[i2]);
            i = i2 + 1;
        }
    }

    public static String toString(long[] jArr) {
        if (jArr == null) {
            return b.l;
        }
        if (jArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 6);
        sb.append('[');
        sb.append(jArr[0]);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= jArr.length) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(jArr[i2]);
            i = i2 + 1;
        }
    }

    public static String toString(Object[] objArr) {
        if (objArr == null) {
            return b.l;
        }
        if (objArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(objArr.length * 7);
        sb.append('[');
        sb.append(objArr[0]);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(objArr[i2]);
            i = i2 + 1;
        }
    }

    public static String toString(short[] sArr) {
        if (sArr == null) {
            return b.l;
        }
        if (sArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(sArr.length * 6);
        sb.append('[');
        sb.append((int) sArr[0]);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= sArr.length) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append((int) sArr[i2]);
            i = i2 + 1;
        }
    }

    public static String toString(boolean[] zArr) {
        if (zArr == null) {
            return b.l;
        }
        if (zArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(zArr.length * 7);
        sb.append('[');
        sb.append(zArr[0]);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= zArr.length) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(zArr[i2]);
            i = i2 + 1;
        }
    }
}
