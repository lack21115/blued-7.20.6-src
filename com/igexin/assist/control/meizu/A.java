package com.igexin.assist.control.meizu;

import java.util.HashMap;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/control/meizu/A.class */
public class A {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, Class<?>> f23183a = new HashMap<>();
    private Class<?> b;

    /* renamed from: c  reason: collision with root package name */
    private String f23184c;
    private Object d;

    private A(Object obj) {
        this.d = obj;
    }

    private A(String str) {
        this.f23184c = str;
    }

    public static A a(String str) {
        return new A(str);
    }

    public c a(String str, Class<?>... clsArr) {
        return new c(this, str, clsArr);
    }

    public Class<?> a() throws ClassNotFoundException {
        Class<?> cls = this.b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.d;
        if (obj != null) {
            return obj.getClass();
        }
        Class<?> cls2 = f23183a.get(this.f23184c);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(this.f23184c);
        f23183a.put(this.f23184c, cls3);
        return cls3;
    }
}
