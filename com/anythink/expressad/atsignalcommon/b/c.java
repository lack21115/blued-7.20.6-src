package com.anythink.expressad.atsignalcommon.b;

import com.anythink.expressad.atsignalcommon.b.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/b/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static a f4222a;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/b/c$a.class */
    public interface a {
        boolean a();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/b/c$b.class */
    public static abstract class b {

        /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/b/c$b$a.class */
        public static final class a extends Throwable {
            private static final long d = 1;

            /* renamed from: a  reason: collision with root package name */
            private Class<?> f4223a;
            private String b;

            /* renamed from: c  reason: collision with root package name */
            private String f4224c;

            public a(Exception exc) {
                super(exc);
            }

            public a(String str) {
                super(str);
            }

            public final Class<?> a() {
                return this.f4223a;
            }

            public final void a(Class<?> cls) {
                this.f4223a = cls;
            }

            public final void a(String str) {
                this.f4224c = str;
            }

            public final String b() {
                return this.f4224c;
            }

            public final void b(String str) {
                this.b = str;
            }

            public final String c() {
                return this.b;
            }

            @Override // java.lang.Throwable
            public final String toString() {
                if (getCause() != null) {
                    return getClass().getName() + ": " + getCause();
                }
                return super.toString();
            }
        }
    }

    /* renamed from: com.anythink.expressad.atsignalcommon.b.c$c  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/b/c$c.class */
    public static final class C0044c<C> {

        /* renamed from: a  reason: collision with root package name */
        protected Class<C> f4225a;

        public C0044c(Class<C> cls) {
            this.f4225a = cls;
        }

        private d a(Class<?>... clsArr) {
            return new d(this.f4225a, clsArr);
        }

        private e<C, Object> a(String str) {
            return new e<>(this.f4225a, str, 8);
        }

        private Class<C> a() {
            return this.f4225a;
        }

        private e<C, Object> b(String str) {
            return new e<>(this.f4225a, str, 0);
        }

        private f b(String str, Class<?>... clsArr) {
            return new f(this.f4225a, str, clsArr, 8);
        }

        public final f a(String str, Class<?>... clsArr) {
            return new f(this.f4225a, str, clsArr, 0);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/b/c$d.class */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        protected Constructor<?> f4226a;

        d(Class<?> cls, Class<?>[] clsArr) {
            if (cls == null) {
                return;
            }
            try {
                this.f4226a = cls.getDeclaredConstructor(clsArr);
            } catch (NoSuchMethodException e) {
                b.a aVar = new b.a(e);
                aVar.a(cls);
                c.b(aVar);
            }
        }

        private Object a(Object... objArr) {
            this.f4226a.setAccessible(true);
            try {
                return this.f4226a.newInstance(objArr);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/b/c$e.class */
    public static final class e<C, T> {

        /* renamed from: a  reason: collision with root package name */
        private Object f4227a;
        private final Field b;

        e(Class<C> cls, String str, int i) {
            if (cls == null) {
                this.b = null;
                return;
            }
            Field field = null;
            Field field2 = null;
            try {
                try {
                    this.f4227a = null;
                    Field declaredField = cls.getDeclaredField(str);
                    if (i > 0 && (declaredField.getModifiers() & i) != i) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(declaredField);
                        sb.append(" does not match modifiers: ");
                        sb.append(i);
                        c.b(new b.a(sb.toString()));
                    }
                    field = declaredField;
                    field2 = declaredField;
                    declaredField.setAccessible(true);
                    this.b = declaredField;
                } catch (NoSuchFieldException e) {
                    b.a aVar = new b.a(e);
                    Field field3 = field2;
                    aVar.a((Class<?>) cls);
                    Field field4 = field2;
                    aVar.b(str);
                    field = field2;
                    c.b(aVar);
                    this.b = field2;
                }
            } catch (Throwable th) {
                this.b = field;
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private <T2> e<C, T2> a(Class<?> cls) {
            Field field = this.b;
            if (field != null && !cls.isAssignableFrom(field.getType())) {
                c.b(new b.a(new ClassCastException(this.b + " is not of type " + cls)));
            }
            return this;
        }

        private e<C, T> a(String str) {
            try {
                Class<?> cls = Class.forName(str);
                if (this.b != null && !cls.isAssignableFrom(this.b.getType())) {
                    c.b(new b.a(new ClassCastException(this.b + " is not of type " + cls)));
                }
                return this;
            } catch (ClassNotFoundException e) {
                c.b(new b.a(e));
                return this;
            }
        }

        private T a() {
            try {
                return (T) this.b.get(this.f4227a);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }

        private void a(b.AbstractC0043b<?> abstractC0043b) {
            T a2 = a();
            if (a2 == null) {
                throw new IllegalStateException("Cannot mapping null");
            }
            try {
                this.b.set(this.f4227a, com.anythink.expressad.atsignalcommon.b.b.a(a2, abstractC0043b, a2.getClass().getInterfaces()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        private void a(Object obj) {
            try {
                this.b.set(this.f4227a, obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private <T2> e<C, T2> b(Class<T2> cls) {
            Field field = this.b;
            if (field != null && !cls.isAssignableFrom(field.getType())) {
                c.b(new b.a(new ClassCastException(this.b + " is not of type " + cls)));
            }
            return this;
        }

        private e<C, T> b(C c2) {
            this.f4227a = c2;
            return this;
        }

        private Field b() {
            return this.b;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/b/c$f.class */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        protected final Method f4228a;

        f(Class<?> cls, String str, Class<?>[] clsArr, int i) {
            Method method = null;
            Method method2 = null;
            try {
                if (cls == null) {
                    this.f4228a = null;
                    return;
                }
                try {
                    Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    if (i > 0 && (declaredMethod.getModifiers() & i) != i) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(declaredMethod);
                        sb.append(" does not match modifiers: ");
                        sb.append(i);
                        c.b(new b.a(sb.toString()));
                    }
                    method2 = declaredMethod;
                    method = declaredMethod;
                    declaredMethod.setAccessible(true);
                    this.f4228a = declaredMethod;
                } catch (NoSuchMethodException e) {
                    b.a aVar = new b.a(e);
                    Method method3 = method;
                    aVar.a(cls);
                    Method method4 = method;
                    aVar.a(str);
                    Method method5 = method;
                    c.b(aVar);
                    this.f4228a = method;
                }
            } catch (Throwable th) {
                this.f4228a = method2;
                throw th;
            }
        }

        public final Object a(Object obj, Object... objArr) {
            try {
                return this.f4228a.invoke(obj, objArr);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }

        public final Method a() {
            return this.f4228a;
        }
    }

    private c() {
    }

    private static <T> C0044c<T> a(Class<T> cls) {
        return new C0044c<>(cls);
    }

    public static <T> C0044c<T> a(ClassLoader classLoader, String str) {
        try {
            return new C0044c<>(classLoader.loadClass(str));
        } catch (Exception e2) {
            b(new b.a(e2));
            return new C0044c<>(null);
        }
    }

    private static <T> C0044c<T> a(String str) {
        try {
            return new C0044c<>(Class.forName(str));
        } catch (ClassNotFoundException e2) {
            b(new b.a(e2));
            return new C0044c<>(null);
        }
    }

    private static void a(a aVar) {
        f4222a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(b.a aVar) {
        a aVar2 = f4222a;
        if (aVar2 == null || !aVar2.a()) {
            throw aVar;
        }
    }
}
