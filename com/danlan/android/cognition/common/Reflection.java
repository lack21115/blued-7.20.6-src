package com.danlan.android.cognition.common;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/common/Reflection.class */
public class Reflection {
    public static Method getMethod1(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method method2 = getMethod2(cls, str, clsArr);
            try {
                method2.setAccessible(true);
                return method2;
            } catch (Throwable th) {
                return method2;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    public static Method getMethod2(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            if (method != null) {
                return method;
            }
        } catch (Throwable th) {
        }
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static boolean isNative(Class<?> cls, String str, Class<?>... clsArr) {
        Method method1 = getMethod1(cls, str, clsArr);
        return method1 != null && Modifier.isNative(method1.getModifiers());
    }
}
