package com.anythink.expressad.atsignalcommon.b;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/b/b.class */
public class b {

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/b/b$a.class */
    interface a {
    }

    /* renamed from: com.anythink.expressad.atsignalcommon.b.b$b  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/b/b$b.class */
    public static abstract class AbstractC0114b<T> implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private T f7059a;

        private T a() {
            return this.f7059a;
        }

        final void a(T t) {
            this.f7059a = t;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            try {
                return method.invoke(this.f7059a, objArr);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvocationTargetException e3) {
                throw e3.getTargetException();
            }
        }
    }

    private b() {
    }

    public static <T> T a(Object obj, AbstractC0114b<T> abstractC0114b, Class<?>... clsArr) {
        abstractC0114b.a(obj);
        return (T) Proxy.newProxyInstance(b.class.getClassLoader(), clsArr, abstractC0114b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T a(Object obj, Class<T> cls, AbstractC0114b<T> abstractC0114b) {
        if (obj instanceof a) {
            return obj;
        }
        abstractC0114b.a(obj);
        return (T) Proxy.newProxyInstance(b.class.getClassLoader(), new Class[]{cls, a.class}, abstractC0114b);
    }
}
