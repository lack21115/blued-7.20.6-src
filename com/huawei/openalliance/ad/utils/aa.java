package com.huawei.openalliance.ad.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/aa.class */
public abstract class aa {
    public static String Code(List<String> list, String str) {
        if (Code(list)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : list) {
            sb.append(str2);
            sb.append(str);
        }
        return sb.toString();
    }

    public static Set<String> Code(List<String> list, boolean z) {
        if (Code(list)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        if (z) {
            for (String str : list) {
                hashSet.add(str.toUpperCase(Locale.ENGLISH));
            }
        } else {
            hashSet.addAll(list);
        }
        return hashSet;
    }

    public static <T> boolean Code(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean Code(int[] iArr) {
        return iArr == null || iArr.length == 0;
    }

    public static <T> boolean Code(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }
}
