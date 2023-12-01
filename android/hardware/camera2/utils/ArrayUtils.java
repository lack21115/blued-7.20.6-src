package android.hardware.camera2.utils;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/ArrayUtils.class */
public class ArrayUtils {
    private static final String TAG = "ArrayUtils";
    private static final boolean VERBOSE = Log.isLoggable(TAG, 2);

    private ArrayUtils() {
        throw new AssertionError();
    }

    public static boolean contains(int[] iArr, int i) {
        return getArrayIndex(iArr, i) != -1;
    }

    public static <T> boolean contains(T[] tArr, T t) {
        return getArrayIndex(tArr, t) != -1;
    }

    public static int[] convertStringListToIntArray(List<String> list, String[] strArr, int[] iArr) {
        int[] iArr2;
        if (list != null) {
            List<Integer> convertStringListToIntList = convertStringListToIntList(list, strArr, iArr);
            int[] iArr3 = new int[convertStringListToIntList.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                iArr2 = iArr3;
                if (i2 >= iArr3.length) {
                    break;
                }
                iArr3[i2] = convertStringListToIntList.get(i2).intValue();
                i = i2 + 1;
            }
        } else {
            iArr2 = null;
        }
        return iArr2;
    }

    public static List<Integer> convertStringListToIntList(List<String> list, String[] strArr, int[] iArr) {
        ArrayList arrayList;
        if (list != null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            Iterator<String> it = list.iterator();
            while (true) {
                arrayList = arrayList2;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                int arrayIndex = getArrayIndex(strArr, next);
                if (arrayIndex < 0) {
                    if (VERBOSE) {
                        Log.v(TAG, "Ignoring invalid value " + next);
                    }
                } else if (arrayIndex < iArr.length) {
                    arrayList2.add(Integer.valueOf(iArr[arrayIndex]));
                }
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    public static int getArrayIndex(int[] iArr, int i) {
        int i2;
        if (iArr == null) {
            i2 = -1;
        } else {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= iArr.length) {
                    return -1;
                }
                i2 = i4;
                if (iArr[i4] == i) {
                    break;
                }
                i3 = i4 + 1;
            }
        }
        return i2;
    }

    public static <T> int getArrayIndex(T[] tArr, T t) {
        int i;
        if (tArr == null) {
            i = -1;
        } else {
            int i2 = 0;
            int length = tArr.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    return -1;
                }
                i = i2;
                if (Objects.equals(tArr[i4], t)) {
                    break;
                }
                i2++;
                i3 = i4 + 1;
            }
        }
        return i;
    }

    public static int[] toIntArray(List<Integer> list) {
        int[] iArr;
        if (list != null) {
            int[] iArr2 = new int[list.size()];
            int i = 0;
            Iterator<Integer> it = list.iterator();
            while (true) {
                iArr = iArr2;
                if (!it.hasNext()) {
                    break;
                }
                iArr2[i] = it.next().intValue();
                i++;
            }
        } else {
            iArr = null;
        }
        return iArr;
    }
}
