package com.tencent.tinker.android.dex.util;

import android.widget.ExpandableListView;
import java.util.Comparator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/util/CompareUtils.class */
public final class CompareUtils {
    private CompareUtils() {
    }

    public static <T extends Comparable<T>> int aArrCompare(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return 0;
            }
            int compareTo = tArr[i2].compareTo(tArr2[i2]);
            if (compareTo != 0) {
                return compareTo;
            }
            i = i2 + 1;
        }
    }

    public static <T> int aArrCompare(T[] tArr, T[] tArr2, Comparator<T> comparator) {
        int length = tArr.length;
        int length2 = tArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return 0;
            }
            int compare = comparator.compare(tArr[i2], tArr2[i2]);
            if (compare != 0) {
                return compare;
            }
            i = i2 + 1;
        }
    }

    public static int sArrCompare(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return 0;
            }
            int sCompare = sCompare(bArr[i2], bArr2[i2]);
            if (sCompare != 0) {
                return sCompare;
            }
            i = i2 + 1;
        }
    }

    public static int sArrCompare(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int length2 = iArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return 0;
            }
            int sCompare = sCompare(iArr[i2], iArr2[i2]);
            if (sCompare != 0) {
                return sCompare;
            }
            i = i2 + 1;
        }
    }

    public static int sArrCompare(long[] jArr, long[] jArr2) {
        int length = jArr.length;
        int length2 = jArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return 0;
            }
            int sCompare = sCompare(jArr[i2], jArr2[i2]);
            if (sCompare != 0) {
                return sCompare;
            }
            i = i2 + 1;
        }
    }

    public static int sArrCompare(short[] sArr, short[] sArr2) {
        int length = sArr.length;
        int length2 = sArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return 0;
            }
            int sCompare = sCompare(sArr[i2], sArr2[i2]);
            if (sCompare != 0) {
                return sCompare;
            }
            i = i2 + 1;
        }
    }

    public static int sCompare(byte b, byte b2) {
        if (b == b2) {
            return 0;
        }
        return b < b2 ? -1 : 1;
    }

    public static int sCompare(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return i < i2 ? -1 : 1;
    }

    public static int sCompare(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        return i < 0 ? -1 : 1;
    }

    public static int sCompare(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        return s < s2 ? -1 : 1;
    }

    public static int uArrCompare(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return 0;
            }
            int uCompare = uCompare(bArr[i2], bArr2[i2]);
            if (uCompare != 0) {
                return uCompare;
            }
            i = i2 + 1;
        }
    }

    public static int uArrCompare(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int length2 = iArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return 0;
            }
            int uCompare = uCompare(iArr[i2], iArr2[i2]);
            if (uCompare != 0) {
                return uCompare;
            }
            i = i2 + 1;
        }
    }

    public static int uArrCompare(short[] sArr, short[] sArr2) {
        int length = sArr.length;
        int length2 = sArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return 0;
            }
            int uCompare = uCompare(sArr[i2], sArr2[i2]);
            if (uCompare != 0) {
                return uCompare;
            }
            i = i2 + 1;
        }
    }

    public static int uCompare(byte b, byte b2) {
        if (b == b2) {
            return 0;
        }
        return (b & 255) < (b2 & 255) ? -1 : 1;
    }

    public static int uCompare(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return (((long) i) & ExpandableListView.PACKED_POSITION_VALUE_NULL) < (((long) i2) & ExpandableListView.PACKED_POSITION_VALUE_NULL) ? -1 : 1;
    }

    public static int uCompare(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        return (s & 65535) < (s2 & 65535) ? -1 : 1;
    }
}
