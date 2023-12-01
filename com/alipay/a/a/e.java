package com.alipay.a.a;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/a/a/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    static List<i> f4505a;

    static {
        ArrayList arrayList = new ArrayList();
        f4505a = arrayList;
        arrayList.add(new l());
        f4505a.add(new d());
        f4505a.add(new c());
        f4505a.add(new h());
        f4505a.add(new k());
        f4505a.add(new b());
        f4505a.add(new a());
        f4505a.add(new g());
    }

    public static final <T> T a(Object obj, Type type) {
        T t;
        for (i iVar : f4505a) {
            if (iVar.a(com.alipay.a.b.a.a(type)) && (t = (T) iVar.a(obj, type)) != null) {
                return t;
            }
        }
        return null;
    }

    public static final Object a(String str, Type type) {
        Object bVar;
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("[") && trim.endsWith("]")) {
            bVar = new org.json.alipay.a(trim);
        } else if (!trim.startsWith("{") || !trim.endsWith(com.alipay.sdk.util.i.d)) {
            return a((Object) trim, type);
        } else {
            bVar = new org.json.alipay.b(trim);
        }
        return a(bVar, type);
    }
}
