package com.kwad.sdk.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/s.class */
public final class s {
    private static final Map<Class<?>, Class<?>> azL;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/s$a.class */
    public static final class a<T> {
        public final Class<? extends T> azM;
        public final T obj;
    }

    static {
        HashMap hashMap = new HashMap();
        azL = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        azL.put(Byte.class, Byte.TYPE);
        azL.put(Character.class, Character.TYPE);
        azL.put(Short.class, Short.TYPE);
        azL.put(Integer.class, Integer.TYPE);
        azL.put(Float.class, Float.TYPE);
        azL.put(Long.class, Long.TYPE);
        azL.put(Double.class, Double.TYPE);
        Map<Class<?>, Class<?>> map = azL;
        Class<Boolean> cls = Boolean.TYPE;
        map.put(cls, cls);
        Map<Class<?>, Class<?>> map2 = azL;
        Class<Byte> cls2 = Byte.TYPE;
        map2.put(cls2, cls2);
        Map<Class<?>, Class<?>> map3 = azL;
        Class<Character> cls3 = Character.TYPE;
        map3.put(cls3, cls3);
        Map<Class<?>, Class<?>> map4 = azL;
        Class<Short> cls4 = Short.TYPE;
        map4.put(cls4, cls4);
        Map<Class<?>, Class<?>> map5 = azL;
        Class<Integer> cls5 = Integer.TYPE;
        map5.put(cls5, cls5);
        Map<Class<?>, Class<?>> map6 = azL;
        Class<Float> cls6 = Float.TYPE;
        map6.put(cls6, cls6);
        Map<Class<?>, Class<?>> map7 = azL;
        Class<Long> cls7 = Long.TYPE;
        map7.put(cls7, cls7);
        Map<Class<?>, Class<?>> map8 = azL;
        Class<Double> cls8 = Double.TYPE;
        map8.put(cls8, cls8);
    }

    public static Class<?> a(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException e) {
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return null;
        }
    }

    public static <T> T a(Class<?> cls, Object... objArr) {
        try {
            return (T) b(cls, objArr);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    public static <T> T a(Object obj, String str, Object... objArr) {
        try {
            return (T) c(obj, str, objArr);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        try {
            return (T) c(Class.forName(str), str2, objArr);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    public static Object a(Field field, Object obj) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            return field.get(obj);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    private static Method a(Method[] methodArr, String str, Class<?>[] clsArr) {
        ao.eK(str);
        int length = methodArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            Method method = methodArr[i2];
            if (method.getName().equals(str) && a(method.getParameterTypes(), clsArr, false)) {
                return method;
            }
            i = i2 + 1;
        }
    }

    public static void a(Class<?> cls, String str, Object obj) {
        try {
            b(cls, str, obj);
        } catch (Throwable th) {
            l(th);
        }
    }

    public static void a(Object obj, String str, Object obj2) {
        try {
            b(obj, str, obj2);
        } catch (Throwable th) {
            l(th);
        }
    }

    public static void a(Field field, Object obj, Object obj2) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        } else if (clsArr2 == null) {
            return clsArr.length == 0;
        } else if (clsArr.length != clsArr2.length) {
            return false;
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= clsArr.length) {
                    return true;
                }
                if ((!z || (clsArr[i2] != null && clsArr2[i2] != null)) && !clsArr[i2].isAssignableFrom(clsArr2[i2]) && (!azL.containsKey(clsArr[i2]) || !azL.get(clsArr[i2]).equals(azL.get(clsArr2[i2])))) {
                    return false;
                }
                i = i2 + 1;
            }
        }
    }

    public static <T> T aa(String str, String str2) {
        try {
            return (T) ab(str, str2);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    private static <T> T ab(String str, String str2) {
        return (T) d(Class.forName(str), str2);
    }

    public static <T> T b(Class<?> cls, String str, Object... objArr) {
        try {
            return (T) c(cls, str, objArr);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    private static <T> T b(Class<?> cls, Object... objArr) {
        return (T) cls.getConstructor(c(objArr)).newInstance(d(objArr));
    }

    public static <T> T b(Object obj, String str, Object... objArr) {
        try {
            return (T) d(obj, str, objArr);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    private static Method b(Method[] methodArr, String str, Class<?>[] clsArr) {
        ao.eK(str);
        int length = methodArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            Method method = methodArr[i2];
            if (method.getName().equals(str) && b(method.getParameterTypes(), clsArr)) {
                return method;
            }
            i = i2 + 1;
        }
    }

    private static void b(Class<?> cls, String str, Object obj) {
        Class<? super Object> cls2 = cls;
        Field field = null;
        while (field == null) {
            try {
                field = cls2.getDeclaredField(str);
            } catch (NoSuchFieldException e) {
                cls2 = cls2.getSuperclass();
            }
            if (cls2 == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        field.set(null, obj);
    }

    public static void b(Object obj, String str, Object obj2) {
        Class<? super Object> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        field.set(obj, obj2);
    }

    private static boolean b(Class<?>[] clsArr, Class<?>[] clsArr2) {
        return a(clsArr, clsArr2, true);
    }

    public static <T> T c(Class<?> cls, String str) {
        try {
            return (T) d(cls, str);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    public static <T> T c(Class<?> cls, String str, Object... objArr) {
        return (T) c(cls, str, c(objArr)).invoke(null, d(objArr));
    }

    public static <T> T c(Object obj, String str, Object... objArr) {
        return (T) c(obj.getClass(), str, c(objArr)).invoke(obj, d(objArr));
    }

    public static <T> T c(String str, Object... objArr) {
        try {
            return (T) f(str, objArr);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    private static Method c(Class<?> cls, String str, Class<?>... clsArr) {
        while (true) {
            Method a2 = a(cls.getDeclaredMethods(), str, clsArr);
            if (a2 != null) {
                a2.setAccessible(true);
                return a2;
            } else if (cls.getSuperclass() == null) {
                throw new NoSuchMethodException();
            } else {
                cls = cls.getSuperclass();
            }
        }
    }

    private static Class<?>[] c(Object... objArr) {
        Class<?>[] clsArr = null;
        if (objArr != null) {
            clsArr = null;
            if (objArr.length > 0) {
                Class<?>[] clsArr2 = new Class[objArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= objArr.length) {
                        break;
                    }
                    Object obj = objArr[i2];
                    clsArr2[i2] = (obj == null || !(obj instanceof a)) ? obj == null ? null : obj.getClass() : ((a) obj).azM;
                    i = i2 + 1;
                }
                clsArr = clsArr2;
            }
        }
        return clsArr;
    }

    private static <T> T d(Class<?> cls, String str) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return (T) declaredField.get(null);
    }

    public static <T> T d(Object obj, String str) {
        try {
            return (T) e(obj, str);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    private static <T> T d(Object obj, String str, Object... objArr) {
        return (T) e(obj.getClass(), str, c(objArr)).invoke(obj, d(objArr));
    }

    private static Object[] d(Object... objArr) {
        Object[] objArr2;
        if (objArr != null && objArr.length > 0) {
            Object[] objArr3 = new Object[objArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                objArr2 = objArr3;
                if (i2 >= objArr.length) {
                    break;
                }
                Object obj = objArr[i2];
                if (obj == null || !(obj instanceof a)) {
                    objArr3[i2] = obj;
                } else {
                    objArr3[i2] = ((a) obj).obj;
                }
                i = i2 + 1;
            }
        } else {
            objArr2 = null;
        }
        return objArr2;
    }

    public static <T> T e(Object obj, String str) {
        Class<? super Object> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                field = declaredField;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    private static Method e(Class<?> cls, String str, Class<?>... clsArr) {
        while (true) {
            Method b = b(cls.getDeclaredMethods(), str, clsArr);
            if (b != null) {
                b.setAccessible(true);
                return b;
            } else if (cls.getSuperclass() == null) {
                throw new NoSuchMethodException();
            } else {
                cls = cls.getSuperclass();
            }
        }
    }

    public static <T> T eA(String str) {
        try {
            return (T) j(Class.forName(str));
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    public static boolean ez(String str) {
        try {
            return Class.forName(str) != null;
        } catch (ClassNotFoundException e) {
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return false;
        }
    }

    private static <T> T f(String str, Object... objArr) {
        return (T) b(Class.forName(str), d(objArr));
    }

    public static <T> T i(Class<?> cls) {
        try {
            return (T) j(cls);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    private static <T> T j(Class<?> cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors == null || declaredConstructors.length == 0) {
            throw new IllegalArgumentException("Can't get even one available constructor for " + cls);
        }
        Constructor<?> constructor = declaredConstructors[0];
        constructor.setAccessible(true);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        if (parameterTypes == null || parameterTypes.length == 0) {
            return (T) constructor.newInstance(new Object[0]);
        }
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            objArr[i] = k(parameterTypes[i]);
        }
        return (T) constructor.newInstance(objArr);
    }

    private static Object k(Class<?> cls) {
        if (Integer.TYPE.equals(cls) || Integer.class.equals(cls) || Byte.TYPE.equals(cls) || Byte.class.equals(cls) || Short.TYPE.equals(cls) || Short.class.equals(cls) || Long.TYPE.equals(cls) || Long.class.equals(cls) || Double.TYPE.equals(cls) || Double.class.equals(cls) || Float.TYPE.equals(cls) || Float.class.equals(cls)) {
            return 0;
        }
        return (Boolean.TYPE.equals(cls) || Boolean.class.equals(cls)) ? Boolean.FALSE : (Character.TYPE.equals(cls) || Character.class.equals(cls)) ? (char) 0 : null;
    }

    private static void l(Throwable th) {
        if (!com.kwad.a.a.bI.booleanValue()) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        } else if (!(th instanceof RuntimeException)) {
            throw new RuntimeException(th);
        } else {
            throw ((RuntimeException) th);
        }
    }
}
