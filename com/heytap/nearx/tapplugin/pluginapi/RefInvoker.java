package com.heytap.nearx.tapplugin.pluginapi;

import android.text.TextUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/nearx/tapplugin/pluginapi/RefInvoker.class */
public class RefInvoker {
    private static final String TAG = "RefInvoker";

    private static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                setAccessible(declaredMethod, true);
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static Object invokeMethod(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            return getMethod(obj.getClass(), str, clsArr).invoke(obj, objArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object invokeMethodAndThrowsException(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        if (obj != null) {
            if (TextUtils.isEmpty(str)) {
                throw new NullPointerException("invokeMethodAndThrowsException, but methodName is null");
            }
            Method method = getMethod(obj.getClass(), str, clsArr);
            if (method != null) {
                return method.invoke(obj, objArr);
            }
            throw new NoSuchMethodException(obj.getClass().getName() + "." + str + " " + Arrays.toString(clsArr));
        }
        throw new NullPointerException("invokeMethodAndThrowsException, but target object is null");
    }

    private static void setAccessible(AccessibleObject accessibleObject, boolean z) {
        if (accessibleObject.isAccessible() != z) {
            accessibleObject.setAccessible(z);
        }
    }
}
