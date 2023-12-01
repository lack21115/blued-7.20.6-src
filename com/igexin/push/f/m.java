package com.igexin.push.f;

import java.lang.reflect.Method;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/f/m.class */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23660a = 5;

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) throws Exception {
        Method method;
        while (true) {
            Method[] declaredMethods = cls.getDeclaredMethods();
            if (str == null) {
                throw new NullPointerException("Method name must not be null.");
            }
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i2];
                if (method.getName().equals(str) && a(method.getParameterTypes(), clsArr)) {
                    break;
                }
                i = i2 + 1;
            }
            if (method != null) {
                method.setAccessible(true);
                return method;
            } else if (cls.getSuperclass() == null) {
                throw new NoSuchMethodException();
            } else {
                cls = cls.getSuperclass();
            }
        }
    }

    private static Method a(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str == null) {
            throw new NullPointerException("Method name must not be null.");
        }
        int length = methodArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            Method method = methodArr[i2];
            if (method.getName().equals(str) && a(method.getParameterTypes(), clsArr)) {
                return method;
            }
            i = i2 + 1;
        }
    }

    public static boolean a(Class cls, Class cls2, int i) {
        while (cls != null && cls2 != null && i > 0) {
            if (cls == cls2) {
                return true;
            }
            if (cls.getSuperclass() == null) {
                return false;
            }
            cls = cls.getSuperclass();
            i--;
        }
        return false;
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
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
                if (clsArr2[i2] != null && !clsArr[i2].isAssignableFrom(clsArr2[i2])) {
                    return false;
                }
                i = i2 + 1;
            }
        }
    }
}
