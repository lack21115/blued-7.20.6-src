package com.blued.android.core.utils.swipeback;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/swipeback/SwipeBackUtils.class */
public class SwipeBackUtils {
    private SwipeBackUtils() {
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            c(activity);
        } else {
            b(activity);
        }
    }

    public static void b(Activity activity) {
        try {
            Class<?>[] declaredClasses = Activity.class.getDeclaredClasses();
            int length = declaredClasses.length;
            Class<?> cls = null;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(activity, null);
                    return;
                }
                Class<?> cls2 = declaredClasses[i2];
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
        }
    }

    private static void c(Activity activity) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(activity, new Object[0]);
            Class<?>[] declaredClasses = Activity.class.getDeclaredClasses();
            int length = declaredClasses.length;
            Class<?> cls = null;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
                    declaredMethod2.setAccessible(true);
                    declaredMethod2.invoke(activity, null, invoke);
                    return;
                }
                Class<?> cls2 = declaredClasses[i2];
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
        }
    }
}
