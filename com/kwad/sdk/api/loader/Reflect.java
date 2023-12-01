package com.kwad.sdk.api.loader;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/Reflect.class */
public final class Reflect {
    private final Class<?> aah;
    private final Object aai;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/Reflect$ReflectException.class */
    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = -6213149635297151442L;

        public ReflectException() {
        }

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, Throwable th) {
            super(str, th);
        }

        public ReflectException(Throwable th) {
            super(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/Reflect$a.class */
    public static final class a {
        private static final Method aaj;
        private static final Method aak;
        private static final Method aal;
        private static final Method aam;
        private static final Method aan;
        private static final Method aao;
        private static final Method aap;
        private static final Method aaq;
        private static final Method aar;
        private static final Method aas;
        private static final Method aat;
        private static final Method aau;
        private static final Method aav;
        private static final Method aaw;

        static {
            try {
                aaj = Class.class.getDeclaredMethod("forName", String.class);
                aak = Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
                aal = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                aam = Class.class.getDeclaredMethod("getDeclaredFields", new Class[0]);
                aan = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                aao = Class.class.getDeclaredMethod("getDeclaredMethods", new Class[0]);
                aap = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
                aaq = Class.class.getDeclaredMethod("getDeclaredConstructors", new Class[0]);
                aar = Class.class.getDeclaredMethod("getField", String.class);
                aas = Class.class.getDeclaredMethod("getFields", new Class[0]);
                aat = Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
                aau = Class.class.getDeclaredMethod("getMethods", new Class[0]);
                aav = Class.class.getDeclaredMethod("getConstructor", Class[].class);
                aaw = Class.class.getDeclaredMethod("getConstructors", new Class[0]);
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        }

        static Constructor a(Class cls, Class<?>... clsArr) {
            try {
                return (Constructor) aap.invoke(cls, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        static Field a(Class cls, String str) {
            try {
                return (Field) aal.invoke(cls, str);
            } catch (Exception e) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e);
                throw noSuchFieldException;
            }
        }

        static Field b(Class cls, String str) {
            try {
                return (Field) aar.invoke(cls, str);
            } catch (Exception e) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e);
                throw noSuchFieldException;
            }
        }

        static Method c(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) aan.invoke(cls, str, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        static Method[] c(Class cls) {
            try {
                return (Method[]) aao.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        static Method d(Class cls, String str, Class<?>... clsArr) {
            try {
                return (Method) aat.invoke(cls, str, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        static Method[] d(Class cls) {
            try {
                return (Method[]) aau.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        static Constructor[] e(Class cls) {
            try {
                return (Constructor[]) aaq.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        static Class forName(String str) {
            try {
                return (Class) aaj.invoke(null, str);
            } catch (Exception e) {
                ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                classNotFoundException.initCause(e);
                throw classNotFoundException;
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/Reflect$b.class */
    static class b {
        private b() {
        }
    }

    private Reflect(Class<?> cls) {
        this(cls, cls);
    }

    private Reflect(Class<?> cls, Object obj) {
        this.aah = cls;
        this.aai = obj;
    }

    public static Reflect a(Class<?> cls) {
        return new Reflect(cls);
    }

    private static Reflect a(Class<?> cls, Object obj) {
        return new Reflect(cls, obj);
    }

    private static Reflect a(Constructor<?> constructor, Object... objArr) {
        try {
            return a(constructor.getDeclaringClass(), ((Constructor) a(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static Reflect a(Method method, Object obj, Object... objArr) {
        try {
            a(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return c(obj);
            }
            return c(method.invoke(obj, objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private Reflect a(Object... objArr) {
        return a(b(objArr), objArr);
    }

    private static <T extends AccessibleObject> T a(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    private Method a(String str, Class<?>[] clsArr) {
        Class<? super Object> type = type();
        try {
            return a.d(type, str, clsArr);
        } catch (NoSuchMethodException e) {
            do {
                try {
                    return a.c(type, str, clsArr);
                } catch (NoSuchMethodException e2) {
                    type = type.getSuperclass();
                    if (type == null) {
                        throw new NoSuchMethodException();
                    }
                }
            } while (type == null);
            throw new NoSuchMethodException();
        }
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= clsArr2.length) {
                return true;
            }
            if (clsArr2[i2] != b.class && !b(clsArr[i2]).isAssignableFrom(b(clsArr2[i2]))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private Reflect b(String str, Object... objArr) {
        return a(str, b(objArr), objArr);
    }

    private static Class<?> b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        Class<?> cls2 = cls;
        if (cls.isPrimitive()) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            if (Short.TYPE == cls) {
                return Short.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            cls2 = cls;
            if (Void.TYPE == cls) {
                cls2 = Void.class;
            }
        }
        return cls2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
        r10 = r10.getSuperclass();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.reflect.Method b(java.lang.String r6, java.lang.Class<?>[] r7) {
        /*
            r5 = this;
            r0 = r5
            java.lang.Class r0 = r0.type()
            r11 = r0
            r0 = r11
            java.lang.reflect.Method[] r0 = com.kwad.sdk.api.loader.Reflect.a.d(r0)
            r12 = r0
            r0 = r12
            int r0 = r0.length
            r9 = r0
            r0 = 0
            r8 = r0
        L14:
            r0 = r11
            r10 = r0
            r0 = r8
            r1 = r9
            if (r0 >= r1) goto L39
            r0 = r12
            r1 = r8
            r0 = r0[r1]
            r10 = r0
            r0 = r5
            r1 = r10
            r2 = r6
            r3 = r7
            boolean r0 = r0.a(r1, r2, r3)
            if (r0 == 0) goto L32
            r0 = r10
            return r0
        L32:
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto L14
        L39:
            r0 = r10
            java.lang.reflect.Method[] r0 = com.kwad.sdk.api.loader.Reflect.a.c(r0)
            r11 = r0
            r0 = r11
            int r0 = r0.length
            r9 = r0
            r0 = 0
            r8 = r0
        L47:
            r0 = r8
            r1 = r9
            if (r0 >= r1) goto L68
            r0 = r11
            r1 = r8
            r0 = r0[r1]
            r12 = r0
            r0 = r5
            r1 = r12
            r2 = r6
            r3 = r7
            boolean r0 = r0.a(r1, r2, r3)
            if (r0 == 0) goto L61
            r0 = r12
            return r0
        L61:
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto L47
        L68:
            r0 = r10
            java.lang.Class r0 = r0.getSuperclass()
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L77
            goto L39
        L77:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "No similar method "
            r1.<init>(r2)
            r10 = r0
            r0 = r10
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r1 = " with params "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r7
            java.lang.String r1 = java.util.Arrays.toString(r1)
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r1 = " could be found on type "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r5
            java.lang.Class r1 = r1.type()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r1 = "."
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.NoSuchMethodException r0 = new java.lang.NoSuchMethodException
            r1 = r0
            r2 = r10
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.Reflect.b(java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    private static Class<?>[] b(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? b.class : obj.getClass();
        }
        return clsArr;
    }

    public static Reflect bf(String str) {
        return a(forName(str));
    }

    private Reflect bg(String str) {
        try {
            Field bh = bh(str);
            return a(bh.getType(), bh.get(this.aai));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private Field bh(String str) {
        Class<? super Object> type = type();
        try {
            return (Field) a(a.b(type, str));
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) a(a.a(type, str));
                } catch (NoSuchFieldException e2) {
                    type = type.getSuperclass();
                    if (type != null) {
                        throw new ReflectException(e);
                    }
                }
            } while (type != null);
            throw new ReflectException(e);
        }
    }

    public static Reflect c(Object obj) {
        return new Reflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    private static Object d(Object obj) {
        Object obj2 = obj;
        if (obj instanceof Reflect) {
            obj2 = ((Reflect) obj).get();
        }
        return obj2;
    }

    private static Class<?> forName(String str) {
        try {
            return a.forName(str);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private Class<?> type() {
        return this.aah;
    }

    public final Reflect a(String str, Object obj) {
        try {
            Field bh = bh(str);
            if ((bh.getModifiers() & 16) == 16) {
                try {
                    Field a2 = a.a(Field.class, "modifiers");
                    a2.setAccessible(true);
                    a2.setInt(bh, bh.getModifiers() & (-17));
                } catch (NoSuchFieldException e) {
                }
            }
            bh.set(this.aai, d(obj));
            return this;
        } catch (Exception e2) {
            throw new ReflectException(e2);
        }
    }

    public final Reflect a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return a(a(str, clsArr), this.aai, objArr);
        } catch (NoSuchMethodException e) {
            try {
                return a(b(str, clsArr), this.aai, objArr);
            } catch (NoSuchMethodException e2) {
                throw new ReflectException(e2);
            }
        }
    }

    public final Reflect a(Class<?>[] clsArr, Object... objArr) {
        try {
            return a(a.a(type(), clsArr), objArr);
        } catch (NoSuchMethodException e) {
            Constructor[] e2 = a.e(type());
            int length = e2.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    throw new ReflectException(e);
                }
                Constructor constructor = e2[i2];
                if (a(constructor.getParameterTypes(), clsArr)) {
                    return a(constructor, objArr);
                }
                i = i2 + 1;
            }
        }
    }

    public final Reflect bi(String str) {
        return b(str, new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Reflect) {
            return this.aai.equals(((Reflect) obj).get());
        }
        return false;
    }

    public final <T> T get() {
        return (T) this.aai;
    }

    public final <T> T get(String str) {
        return (T) bg(str).get();
    }

    public final int hashCode() {
        return this.aai.hashCode();
    }

    public final String toString() {
        return String.valueOf(this.aai);
    }

    public final Reflect tv() {
        return a(new Object[0]);
    }
}
