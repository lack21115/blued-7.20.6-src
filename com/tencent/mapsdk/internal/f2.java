package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.k2;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f2.class */
public abstract class f2 implements h2 {
    private String e;
    private j2 g;
    private final Set<a> f = new LinkedHashSet();
    private final q2 h = new q2();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/f2$a.class */
    public static class a<S extends l2> {

        /* renamed from: a  reason: collision with root package name */
        public String f37427a;
        public Class<S> b;

        /* renamed from: c  reason: collision with root package name */
        public Method f37428c;
        public Map<String, String> d;
        public S e;

        public a(String str, Class cls, Method method) {
            this.f37427a = str;
            this.b = cls;
            this.f37428c = method;
        }
    }

    private a b(String str) {
        for (a aVar : this.f) {
            if (aVar.f37427a.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    private a c(Class cls) {
        for (a aVar : this.f) {
            if (aVar.b.equals(cls)) {
                return aVar;
            }
        }
        return null;
    }

    private <S extends l2> S e(Class<S> cls) {
        for (a aVar : this.f) {
            if (aVar.b == cls) {
                Method method = aVar.f37428c;
                if (method != null) {
                    try {
                        method.setAccessible(true);
                        Object invoke = method.invoke(this, aVar.b);
                        if (invoke == null || invoke.getClass() != cls) {
                            return null;
                        }
                        S s = (S) invoke;
                        s.a(aVar.d);
                        aVar.e = s;
                        return s;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return null;
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.k2
    public k2.a a(String str) {
        return c(str);
    }

    public void a(j2 j2Var) {
        if (this.g == j2Var || j2Var == null) {
            return;
        }
        this.g = j2Var;
        List<Class<? extends p>> b = j2Var.b();
        if (b != null) {
            for (Class<? extends p> cls : b) {
                a(cls);
            }
        }
        Map<String, Class<? extends k2.a>> a2 = this.g.a();
        if (a2 != null) {
            this.f.clear();
            for (Map.Entry<String, Class<? extends k2.a>> entry : a2.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> d = this.g.d();
        if (d == null || d.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry2 : d.entrySet()) {
            a(entry2.getKey(), entry2.getValue());
        }
    }

    @Override // com.tencent.mapsdk.internal.k2
    public <T extends p> void a(Class<T> cls) {
        o.a(cls);
    }

    @Override // com.tencent.mapsdk.internal.k2
    public <T extends k2.a> void a(String str, Class<T> cls) {
        try {
            this.f.add(new a(str, cls, f2.class.getDeclaredMethod("b", Class.class)));
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
    }

    public void a(String str, String str2) {
        for (a aVar : this.f) {
            if (aVar.d == null) {
                aVar.d = new HashMap();
            }
            aVar.d.put(str, str2);
            S s = aVar.e;
            if (s != 0) {
                s.a(aVar.d);
            }
        }
    }

    public abstract <S extends l2> S b(Class<S> cls);

    @Override // com.tencent.mapsdk.internal.h2
    public String b() {
        return this.e;
    }

    @Override // com.tencent.mapsdk.internal.k2
    public j2 c() {
        return this.g;
    }

    public <S extends l2> S c(String str) {
        a b = b(str);
        if (b != null) {
            S s = b.e;
            return s != null ? s : (S) e(b.b);
        }
        return null;
    }

    public <S extends l2> S d(Class<S> cls) {
        a c2 = c(cls);
        if (c2 != null) {
            S s = c2.e;
            return s != null ? s : (S) e(c2.b);
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.i2
    /* renamed from: d */
    public q2 a() {
        return this.h;
    }

    public void d(String str) {
        this.e = str;
    }
}
