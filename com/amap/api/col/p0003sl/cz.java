package com.amap.api.col.p0003sl;

import com.autonavi.base.ae.gmap.style.StyleItem;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.amap.api.col.3sl.cz  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cz.class */
public final class cz {
    private Map<Integer, StyleItem> a = new ConcurrentHashMap();
    private Object b = null;
    private StyleItem[] c;

    public final Map<Integer, StyleItem> a() {
        return this.a;
    }

    public final StyleItem[] b() {
        Map<Integer, StyleItem> map = this.a;
        if (map == null || map.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StyleItem styleItem : this.a.values()) {
            if (styleItem.isValid()) {
                arrayList.add(styleItem);
            }
        }
        int size = arrayList.size();
        if (size > 0) {
            StyleItem[] styleItemArr = (StyleItem[]) arrayList.toArray(new StyleItem[size]);
            this.c = styleItemArr;
            return styleItemArr;
        }
        return null;
    }

    public final StyleItem[] c() {
        return this.c;
    }

    public final Object d() {
        return this.b;
    }
}
