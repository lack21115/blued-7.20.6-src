package android.hardware.camera2.utils;

import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/ListUtils.class */
public class ListUtils {
    private ListUtils() {
        throw new AssertionError();
    }

    public static <T> boolean listContains(List<T> list, T t) {
        if (list == null) {
            return false;
        }
        return list.contains(t);
    }

    public static <T> boolean listElementsEqualTo(List<T> list, T t) {
        boolean z = true;
        if (list == null) {
            return false;
        }
        if (list.size() != 1 || !list.contains(t)) {
            z = false;
        }
        return z;
    }

    public static <T> T listSelectFirstFrom(List<T> list, T[] tArr) {
        T t;
        if (list == null) {
            t = null;
        } else {
            int length = tArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return null;
                }
                T t2 = tArr[i2];
                t = t2;
                if (list.contains(t2)) {
                    break;
                }
                i = i2 + 1;
            }
        }
        return t;
    }

    public static <T> String listToString(List<T> list) {
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int size = list.size();
        int i = 0;
        for (T t : list) {
            sb.append(t);
            if (i != size - 1) {
                sb.append(',');
            }
            i++;
        }
        sb.append(']');
        return sb.toString();
    }
}
