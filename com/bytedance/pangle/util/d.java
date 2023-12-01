package com.bytedance.pangle.util;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/util/d.class */
public final class d {
    public static <T> boolean a(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    private static <T> boolean a(T[] tArr, T t) {
        int i;
        if (tArr != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= tArr.length) {
                    break;
                }
                i = i3;
                if (tArr[i3] != t) {
                    if (tArr[i3] != null && tArr[i3].equals(t)) {
                        i = i3;
                        break;
                    }
                    i2 = i3 + 1;
                } else {
                    break;
                }
            }
        }
        i = -1;
        return i != -1;
    }

    public static <T> boolean a(T[] tArr, T[] tArr2) {
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
            if (!a(tArr, tArr2[i2])) {
                return false;
            }
            i = i2 + 1;
        }
    }
}
