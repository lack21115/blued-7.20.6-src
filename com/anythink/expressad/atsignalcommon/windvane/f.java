package com.anythink.expressad.atsignalcommon.windvane;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/windvane/f.class */
public class f {

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/windvane/f$a.class */
    interface a {
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/windvane/f$b.class */
    public static abstract class b<T> implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private T f4265a;

        private T a() {
            return this.f4265a;
        }

        final void a(T t) {
            this.f4265a = t;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            return method.invoke(this.f4265a, objArr);
        }
    }

    private f() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T a(Object obj, b<T> bVar, Class<?>... clsArr) {
        if (Proxy.isProxyClass(obj.getClass())) {
            return obj;
        }
        bVar.a(obj);
        return (T) Proxy.newProxyInstance(f.class.getClassLoader(), clsArr, bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T a(Object obj, Class<T> cls, b<T> bVar) {
        if (obj instanceof a) {
            return obj;
        }
        bVar.a(obj);
        return (T) Proxy.newProxyInstance(f.class.getClassLoader(), new Class[]{cls, a.class}, bVar);
    }
}
