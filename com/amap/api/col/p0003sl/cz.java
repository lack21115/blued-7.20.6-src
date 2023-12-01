package com.amap.api.col.p0003sl;

import com.autonavi.base.ae.gmap.style.StyleItem;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.amap.api.col.3sl.cz  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cz.class */
public final class cz {

    /* renamed from: a  reason: collision with root package name */
    private Map<Integer, StyleItem> f4834a = new ConcurrentHashMap();
    private Object b = null;

    /* renamed from: c  reason: collision with root package name */
    private StyleItem[] f4835c;

    public final Map<Integer, StyleItem> a() {
        return this.f4834a;
    }

    public final StyleItem[] b() {
        Map<Integer, StyleItem> map = this.f4834a;
        if (map == null || map.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StyleItem styleItem : this.f4834a.values()) {
            if (styleItem.isValid()) {
                arrayList.add(styleItem);
            }
        }
        int size = arrayList.size();
        if (size > 0) {
            StyleItem[] styleItemArr = (StyleItem[]) arrayList.toArray(new StyleItem[size]);
            this.f4835c = styleItemArr;
            return styleItemArr;
        }
        return null;
    }

    public final StyleItem[] c() {
        return this.f4835c;
    }

    public final Object d() {
        return this.b;
    }
}
