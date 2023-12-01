package com.heytap.nearx.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/nearx/a/a/a/b.class */
public final class b {
    public static IllegalStateException a(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        String str = "";
        int i = 0;
        while (i < length) {
            String str2 = str;
            if (objArr[i] == null) {
                if (sb.length() > 0) {
                    str = "s";
                }
                sb.append("\n  ");
                sb.append(objArr[i + 1]);
                str2 = str;
            }
            i += 2;
            str = str2;
        }
        throw new IllegalStateException("Required field" + str + " not set:" + ((Object) sb));
    }

    public static <T> List<T> a() {
        return new c(Collections.emptyList());
    }

    public static <T> List<T> a(String str, List<T> list) {
        if (list != null) {
            return (list == Collections.emptyList() || (list instanceof a)) ? new c(list) : new ArrayList(list);
        }
        throw new NullPointerException(str + " == null");
    }

    public static void a(List<?> list) {
        if (list == null) {
            throw new NullPointerException("list == null");
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == null) {
                throw new NullPointerException("Element at index " + i + " is null");
            }
        }
    }

    public static <T> List<T> b(String str, List<T> list) {
        if (list == null) {
            throw new NullPointerException(str + " == null");
        }
        List<T> list2 = list;
        if (list instanceof c) {
            list2 = ((c) list).f8648a;
        }
        if (list2 != Collections.emptyList() && !(list2 instanceof a)) {
            a aVar = new a(list2);
            if (aVar.contains(null)) {
                throw new IllegalArgumentException(str + ".contains(null)");
            }
            return aVar;
        }
        return list2;
    }
}
