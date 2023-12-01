package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/ar.class */
public class ar {
    private static final String b = ar.class.getName();

    /* renamed from: a  reason: collision with root package name */
    static bq f6477a = bq.a();

    public static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e) {
            f6477a.b(b, Log.getStackTraceString(e));
            return null;
        }
    }

    public static Class<?> a(String str, ClassLoader classLoader) {
        if (classLoader != null) {
            try {
                return classLoader.loadClass(str);
            } catch (Exception e) {
                f6477a.a(b, Log.getStackTraceString(e));
                return null;
            }
        }
        return null;
    }

    public static ClassLoader a(Context context) {
        return an.a(bw.a(context), context.getFilesDir().getAbsolutePath(), (String) null, ar.class.getClassLoader());
    }

    public static Object a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            if (a(cls, str, clsArr)) {
                return b(cls, str, clsArr).invoke(obj, objArr);
            }
            return null;
        } catch (Exception e) {
            f6477a.b(b, Log.getStackTraceString(e));
            return null;
        }
    }

    public static Object a(Class cls, String str) {
        Field b2 = b((Class<?>) cls, str);
        if (b2 != null) {
            b2.setAccessible(true);
            try {
                return b2.get(cls);
            } catch (Exception e) {
                f6477a.b(b, Log.getStackTraceString(e));
                return null;
            }
        }
        return null;
    }

    public static Object a(ClassLoader classLoader, String str, String str2) {
        try {
            return a((Class) Class.forName(str, true, classLoader), str2);
        } catch (Exception e) {
            f6477a.b(b, Log.getStackTraceString(e));
            return null;
        }
    }

    public static Object a(Object obj, String str) {
        Field b2 = b(obj, str);
        if (b2 != null) {
            b2.setAccessible(true);
            try {
                return b2.get(obj);
            } catch (Exception e) {
                f6477a.b(b, Log.getStackTraceString(e));
                return null;
            }
        }
        return null;
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            return a(obj.getClass(), obj, str, clsArr, objArr);
        } catch (Exception e) {
            f6477a.b(b, Log.getStackTraceString(e));
            return null;
        }
    }

    public static Object a(Object obj, String str, Object... objArr) {
        try {
            return a(obj.getClass(), obj, str, a(objArr), objArr);
        } catch (Exception e) {
            f6477a.b(b, Log.getStackTraceString(e));
            return null;
        }
    }

    public static Object a(String str, ClassLoader classLoader, String str2, Class[] clsArr, Object[] objArr) {
        try {
            Class<?> a2 = a(str, classLoader);
            if (a2 != null) {
                Method declaredMethod = a2.getDeclaredMethod(str2, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, objArr);
            }
            return null;
        } catch (Exception e) {
            f6477a.b(b, Log.getStackTraceString(e));
            return null;
        }
    }

    public static Object a(String str, ClassLoader classLoader, InvocationHandler invocationHandler) {
        Class<?> a2 = a(str, classLoader);
        if (a2 != null) {
            return Proxy.newProxyInstance(a2.getClassLoader(), new Class[]{a2}, invocationHandler);
        }
        return null;
    }

    public static Object a(String str, ClassLoader classLoader, Class<?>[] clsArr, Object... objArr) {
        try {
            Class<?> a2 = a(str, classLoader);
            if (a2 != null) {
                return a2.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
            return null;
        } catch (Exception e) {
            f6477a.b(b, Log.getStackTraceString(e));
            return null;
        }
    }

    public static Object a(String str, Object obj, ClassLoader classLoader, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> a2 = a(str, classLoader);
            if (a2 == null || (declaredMethod = a2.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e) {
            f6477a.b(b, Log.getStackTraceString(e));
            return null;
        }
    }

    public static Object a(String str, Object obj, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> a2 = a(str);
            if (a2 == null || (declaredMethod = a2.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e) {
            f6477a.b(b, Log.getStackTraceString(e));
            return null;
        }
    }

    public static Object a(String str, InvocationHandler invocationHandler) {
        Class<?> a2 = a(str);
        if (a2 != null) {
            return Proxy.newProxyInstance(a2.getClassLoader(), new Class[]{a2}, invocationHandler);
        }
        return null;
    }

    public static Object a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Class<?> a2 = a(str);
            if (a2 != null) {
                return a2.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
            return null;
        } catch (Exception e) {
            f6477a.b(b, Log.getStackTraceString(e));
            return null;
        }
    }

    public static boolean a(Class<?> cls, String str, Class<?>... clsArr) {
        boolean z = false;
        try {
            if (cls.getDeclaredMethod(str, clsArr) != null) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            f6477a.b(b, Log.getStackTraceString(e));
            return false;
        }
    }

    public static Class<?>[] a(Object... objArr) {
        try {
            int length = objArr.length;
            Class<?>[] clsArr = new Class[length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return clsArr;
                }
                clsArr[i2] = objArr[i2].getClass();
                i = i2 + 1;
            }
        } catch (Exception e) {
            f6477a.b(b, Log.getStackTraceString(e));
            return null;
        }
    }

    public static Field b(Class<?> cls, String str) {
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception e) {
                f6477a.b(b, Log.getStackTraceString(e));
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static Field b(Object obj, String str) {
        Class<?> cls = obj.getClass();
        while (true) {
            Class<?> cls2 = cls;
            if (cls2 == Object.class) {
                return null;
            }
            try {
                return cls2.getDeclaredField(str);
            } catch (Exception e) {
                f6477a.b(b, Log.getStackTraceString(e));
                cls = cls2.getSuperclass();
            }
        }
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod;
            }
            return null;
        } catch (Exception e) {
            f6477a.b(b, Log.getStackTraceString(e));
            return null;
        }
    }
}
