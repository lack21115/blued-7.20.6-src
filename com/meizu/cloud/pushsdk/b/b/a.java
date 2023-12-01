package com.meizu.cloud.pushsdk.b.b;

import java.util.HashMap;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, Class<?>> f10355a = new HashMap<>();
    private Class<?> b;

    /* renamed from: c  reason: collision with root package name */
    private String f10356c;
    private Object d;

    private a(Object obj) {
        this.d = obj;
    }

    private a(String str) {
        this.f10356c = str;
    }

    public static a a(Object obj) {
        return new a(obj);
    }

    public static a a(String str) {
        return new a(str);
    }

    public b a(Class<?>... clsArr) {
        return new b(this, clsArr);
    }

    public c a(String str, Class<?>... clsArr) {
        return new c(this, str, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> a() throws ClassNotFoundException {
        Class<?> cls = this.b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.d;
        if (obj != null) {
            return obj.getClass();
        }
        Class<?> cls2 = f10355a.get(this.f10356c);
        Class<?> cls3 = cls2;
        if (cls2 == null) {
            cls3 = Class.forName(this.f10356c);
            f10355a.put(this.f10356c, cls3);
        }
        return cls3;
    }
}
