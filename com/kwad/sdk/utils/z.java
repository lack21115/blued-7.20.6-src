package com.kwad.sdk.utils;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/z.class */
public final class z {
    public static <T> List<List<T>> d(List<T> list, int i) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return arrayList;
            }
            int i4 = i3 + 200;
            arrayList.add(list.subList(i3, i4 > list.size() ? list.size() : i4));
            i2 = i4;
        }
    }
}
