package io.github.inflationx.calligraphy3;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/calligraphy3/ReflectionUtils.class */
class ReflectionUtils {
    private static final String TAG = ReflectionUtils.class.getSimpleName();

    ReflectionUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Method getMethod(Class cls, String str) {
        Method[] methods = cls.getMethods();
        int length = methods.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            Method method = methods[i2];
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void invokeMethod(Object obj, Method method, Object... objArr) {
        if (method == null) {
            return;
        }
        try {
            method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            Log.d(TAG, "Can't access method using reflection", e);
        } catch (InvocationTargetException e2) {
            Log.d(TAG, "Can't invoke method using reflection", e2);
        }
    }
}
