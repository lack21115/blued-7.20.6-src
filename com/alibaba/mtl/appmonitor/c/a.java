package com.alibaba.mtl.appmonitor.c;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/c/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f4462a = new a();
    private Map<Class<? extends b>, c<? extends b>> m = new HashMap();

    private a() {
    }

    public static a a() {
        return f4462a;
    }

    private <T extends b> c<T> a(Class<T> cls) {
        c<? extends b> cVar;
        synchronized (this) {
            c<? extends b> cVar2 = this.m.get(cls);
            cVar = cVar2;
            if (cVar2 == null) {
                cVar = new c<>();
                this.m.put(cls, cVar);
            }
        }
        return (c<T>) cVar;
    }

    public <T extends b> T a(Class<T> cls, Object... objArr) {
        T a2 = a(cls).a();
        T t = a2;
        if (a2 == null) {
            try {
                t = cls.newInstance();
            } catch (Exception e) {
                com.alibaba.mtl.appmonitor.b.b.m2144a((Throwable) e);
                t = a2;
            }
        }
        if (t != null) {
            t.fill(objArr);
        }
        return t;
    }

    public <T extends b> void a(T t) {
        if (t == null || (t instanceof e) || (t instanceof d)) {
            return;
        }
        a(t.getClass()).a(t);
    }
}
