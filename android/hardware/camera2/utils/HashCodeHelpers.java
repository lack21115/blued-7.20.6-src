package android.hardware.camera2.utils;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/HashCodeHelpers.class */
public final class HashCodeHelpers {
    public static int hashCode(int i) {
        return hashCode(new int[]{i});
    }

    public static int hashCode(int i, int i2) {
        return hashCode(new int[]{i, i2});
    }

    public static int hashCode(int i, int i2, int i3) {
        return hashCode(new int[]{i, i2, i3});
    }

    public static int hashCode(int i, int i2, int i3, int i4) {
        return hashCode(new int[]{i, i2, i3, i4});
    }

    public static int hashCode(int i, int i2, int i3, int i4, int i5) {
        return hashCode(new int[]{i, i2, i3, i4, i5});
    }

    public static <T> int hashCode(T t) {
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public static <T> int hashCode(T t, T t2) {
        int hashCode = hashCode(t);
        return ((hashCode << 5) - hashCode) ^ (t2 == null ? 0 : t2.hashCode());
    }

    public static <T> int hashCode(T t, T t2, T t3) {
        int hashCode = hashCode(t, t2);
        return ((hashCode << 5) - hashCode) ^ (t3 == null ? 0 : t3.hashCode());
    }

    public static <T> int hashCode(T t, T t2, T t3, T t4) {
        int hashCode = hashCode(t, t2, t3);
        return ((hashCode << 5) - hashCode) ^ (t4 == null ? 0 : t4.hashCode());
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
                i2 = ((i2 << 5) - i2) ^ Float.floatToIntBits(fArr[i4]);
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
                i2 = ((i2 << 5) - i2) ^ iArr[i4];
                i3 = i4 + 1;
            }
        } else {
            i = 0;
        }
        return i;
    }

    public static <T> int hashCode(T[] tArr) {
        if (tArr == null) {
            return 0;
        }
        int i = 1;
        int length = tArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return i;
            }
            T t = tArr[i3];
            i = ((i << 5) - i) ^ (t == null ? 0 : t.hashCode());
            i2 = i3 + 1;
        }
    }
}
