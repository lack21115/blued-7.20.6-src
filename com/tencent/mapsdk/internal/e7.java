package com.tencent.mapsdk.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/e7.class */
public class e7 {
    public static <T> Class<? extends T> a(String str, Class<T> cls, ClassLoader classLoader) {
        try {
            Class<? extends T> cls2 = (Class<? extends T>) Class.forName(str, false, classLoader);
            if (cls.isAssignableFrom(cls2)) {
                return cls2;
            }
            return null;
        } catch (ClassNotFoundException e) {
            na.b(e.getMessage(), e);
            return null;
        }
    }

    public static Class a(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException e) {
            na.b(e.getMessage(), e);
            return null;
        }
    }

    public static <T> T a(Class<T> cls, Object... objArr) {
        if (cls == null || cls.isEnum() || cls.isInterface() || cls.isAnnotation() || cls.isArray()) {
            return null;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= declaredConstructors.length) {
                try {
                    return cls.newInstance();
                } catch (IllegalAccessException e) {
                    na.b(e.getMessage(), e);
                    return null;
                } catch (InstantiationException e2) {
                    na.b(e2.getMessage(), e2);
                    return null;
                }
            }
            if (a(declaredConstructors[i2].getParameterTypes(), objArr)) {
                try {
                    declaredConstructors[i2].setAccessible(true);
                    return (T) declaredConstructors[i2].newInstance(objArr);
                } catch (IllegalAccessException e3) {
                    na.b(e3.getMessage(), e3);
                } catch (InstantiationException e4) {
                    na.b(e4.getMessage(), e4);
                } catch (InvocationTargetException e5) {
                    na.b(e5.getMessage(), e5);
                }
            }
            i = i2 + 1;
        }
    }

    public static Object a(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (obj instanceof Class) {
            cls = (Class) obj;
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return Modifier.isStatic(declaredField.getModifiers()) ? declaredField.get(cls) : declaredField.get(obj);
        } catch (IllegalAccessException e) {
            na.b(e.getMessage(), e);
            return null;
        } catch (NoSuchFieldException e2) {
            na.b(e2.getMessage(), e2);
            return null;
        }
    }

    public static Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method a2 = a((Class) obj.getClass(), str, clsArr);
            if (a2 != null) {
                a2.setAccessible(true);
                return a2.invoke(obj, objArr);
            }
            return null;
        } catch (IllegalAccessException e) {
            na.b(e.getMessage(), e);
            return null;
        } catch (InvocationTargetException e2) {
            na.b(e2.getMessage(), e2);
            return null;
        }
    }

    public static Object a(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                try {
                    break;
                } catch (IllegalAccessException e) {
                    na.b(e.getMessage(), e);
                    return null;
                } catch (InvocationTargetException e2) {
                    na.b(e2.getMessage(), e2);
                    return null;
                }
            }
            clsArr[i2] = objArr[i2].getClass();
            i = i2 + 1;
        }
        Method a2 = a((Class) obj.getClass(), str, clsArr);
        if (a2 != null) {
            a2.setAccessible(true);
            return a2.invoke(obj, objArr);
        }
        return null;
    }

    public static Method a(Class cls, String str, Class[] clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            if (cls.getSuperclass() != Object.class) {
                return a(cls.getSuperclass(), str, clsArr);
            }
            na.b(e.getMessage(), e);
            return null;
        }
    }

    public static void a(Object obj, String str, Object obj2) {
        if (obj == null) {
            return;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (IllegalAccessException e) {
            na.b(e.getMessage(), e);
        } catch (NoSuchFieldException e2) {
            na.b(e2.getMessage(), e2);
        }
    }

    private static boolean a(Class<?>[] clsArr, Object[] objArr) {
        int i;
        int i2;
        boolean z = false;
        if (clsArr.length != objArr.length) {
            return false;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = i4;
            if (i3 >= clsArr.length) {
                break;
            }
            if (clsArr[i3] != objArr[i3].getClass()) {
                i2 = i;
                if (!clsArr[i3].isAssignableFrom(objArr[i3].getClass())) {
                    i3++;
                    i4 = i2;
                }
            }
            i2 = i + 1;
            i3++;
            i4 = i2;
        }
        if (i == clsArr.length) {
            z = true;
        }
        return z;
    }
}
