package io.github.inflationx.viewpump.internal;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
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

    public static final Method getAccessibleMethod(Class<?> cls, String str) {
        Intrinsics.d(cls, "receiver$0");
        Intrinsics.d(str, "methodName");
        Method[] methods = cls.getMethods();
        int length = methods.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            Method method = methods[i2];
            Intrinsics.b(method, "method");
            if (Intrinsics.a(method.getName(), str)) {
                method.setAccessible(true);
                return method;
            }
            i = i2 + 1;
        }
    }

    public static final void invokeMethod(Method method, Object obj, Object... objArr) {
        Intrinsics.d(obj, TypedValues.AttributesType.S_TARGET);
        Intrinsics.d(objArr, ProcessBridgeProvider.KEY_ARGS);
        if (method == null) {
            return;
        }
        try {
            method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            Log.d(TAG, "Can't access method using reflection", e);
        } catch (InvocationTargetException e2) {
            Log.d(TAG, "Can't invoke method using reflection", e2);
        }
    }

    public static final void setValueQuietly(Field field, Object obj, Object obj2) {
        Intrinsics.d(field, "receiver$0");
        Intrinsics.d(obj, "obj");
        Intrinsics.d(obj2, "value");
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e) {
        }
    }
}
