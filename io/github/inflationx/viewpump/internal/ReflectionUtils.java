package io.github.inflationx.viewpump.internal;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* renamed from: io.github.inflationx.viewpump.internal.-ReflectionUtils  reason: invalid class name */
/* loaded from: source-8829756-dex2jar.jar:io/github/inflationx/viewpump/internal/-ReflectionUtils.class */
public final class ReflectionUtils {
    private static final String TAG = "ReflectionUtils";

    public static final Method getAccessibleMethod(Class<?> receiver$0, String methodName) {
        Intrinsics.d(receiver$0, "receiver$0");
        Intrinsics.d(methodName, "methodName");
        Method[] methods = receiver$0.getMethods();
        int length = methods.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            Method method = methods[i2];
            Intrinsics.b(method, "method");
            if (Intrinsics.a((Object) method.getName(), (Object) methodName)) {
                method.setAccessible(true);
                return method;
            }
            i = i2 + 1;
        }
    }

    public static final void invokeMethod(Method method, Object target, Object... args) {
        Intrinsics.d(target, "target");
        Intrinsics.d(args, "args");
        if (method == null) {
            return;
        }
        try {
            method.invoke(target, Arrays.copyOf(args, args.length));
        } catch (IllegalAccessException e) {
            Log.d(TAG, "Can't access method using reflection", e);
        } catch (InvocationTargetException e2) {
            Log.d(TAG, "Can't invoke method using reflection", e2);
        }
    }

    public static final void setValueQuietly(Field receiver$0, Object obj, Object value) {
        Intrinsics.d(receiver$0, "receiver$0");
        Intrinsics.d(obj, "obj");
        Intrinsics.d(value, "value");
        try {
            receiver$0.set(obj, value);
        } catch (IllegalAccessException e) {
        }
    }
}
