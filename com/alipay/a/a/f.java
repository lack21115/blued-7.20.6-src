package com.alipay.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/a/a/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static List<j> f4506a;

    static {
        ArrayList arrayList = new ArrayList();
        f4506a = arrayList;
        arrayList.add(new l());
        f4506a.add(new d());
        f4506a.add(new c());
        f4506a.add(new h());
        f4506a.add(new b());
        f4506a.add(new a());
        f4506a.add(new g());
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object b = b(obj);
        if (com.alipay.a.b.a.a(b.getClass())) {
            return org.json.alipay.b.c(b.toString());
        }
        if (Collection.class.isAssignableFrom(b.getClass())) {
            return new org.json.alipay.a((Collection) ((List) b)).toString();
        }
        if (Map.class.isAssignableFrom(b.getClass())) {
            return new org.json.alipay.b((Map) b).toString();
        }
        throw new IllegalArgumentException("Unsupported Class : " + b.getClass());
    }

    public static Object b(Object obj) {
        Object a2;
        if (obj == null) {
            return null;
        }
        for (j jVar : f4506a) {
            if (jVar.a(obj.getClass()) && (a2 = jVar.a(obj)) != null) {
                return a2;
            }
        }
        throw new IllegalArgumentException("Unsupported Class : " + obj.getClass());
    }
}
