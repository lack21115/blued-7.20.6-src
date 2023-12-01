package com.tencent.tinker.android.dex.util;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dex/util/HashCodeHelper.class */
public final class HashCodeHelper {
    private HashCodeHelper() {
        throw new UnsupportedOperationException();
    }

    public static int hash(Object... objArr) {
        int hashCode;
        int i;
        if (objArr == null || objArr.length == 0) {
            return 0;
        }
        int length = objArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= length) {
                return i4;
            }
            Object obj = objArr[i2];
            if (obj == null) {
                i = i4;
            } else {
                if (obj instanceof Number) {
                    hashCode = obj.hashCode();
                } else if (obj instanceof boolean[]) {
                    hashCode = Arrays.hashCode((boolean[]) obj);
                } else if (obj instanceof byte[]) {
                    hashCode = Arrays.hashCode((byte[]) obj);
                } else if (obj instanceof char[]) {
                    hashCode = Arrays.hashCode((char[]) obj);
                } else if (obj instanceof short[]) {
                    hashCode = Arrays.hashCode((short[]) obj);
                } else if (obj instanceof int[]) {
                    hashCode = Arrays.hashCode((int[]) obj);
                } else if (obj instanceof long[]) {
                    hashCode = Arrays.hashCode((long[]) obj);
                } else if (obj instanceof float[]) {
                    hashCode = Arrays.hashCode((float[]) obj);
                } else if (obj instanceof double[]) {
                    hashCode = Arrays.hashCode((double[]) obj);
                } else if (obj instanceof Object[]) {
                    hashCode = Arrays.hashCode((Object[]) obj);
                } else if (obj.getClass().isArray()) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        i = i4;
                        if (i6 < Array.getLength(obj)) {
                            i4 += hash(Array.get(obj, i6));
                            i5 = i6 + 1;
                        }
                    }
                } else {
                    hashCode = obj.hashCode();
                }
                i = i4 + hashCode;
            }
            i2++;
            i3 = i;
        }
    }
}
