package c.t.m.g;

import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/z6.class */
public class z6 {

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f4077a;
    public final Method b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f4078c;

    public z6(Class<?> cls, Method method, Object obj, boolean z) {
        this.f4077a = cls;
        this.b = method;
        this.f4078c = obj;
    }

    public Method a() {
        return this.b;
    }

    public boolean a(Object obj) {
        return obj.getClass().equals(this.f4077a);
    }

    public Object b() {
        return this.f4078c;
    }
}
