package com.blued.android.framework.utils;

import java.lang.reflect.Field;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/ReflectionUtils.class */
public class ReflectionUtils {
    public static Field a(Object obj, String str) {
        Class<?> cls = obj.getClass();
        while (true) {
            Class<?> cls2 = cls;
            if (cls2 == Object.class) {
                return null;
            }
            try {
                return cls2.getDeclaredField(str);
            } catch (Exception e) {
                e.printStackTrace();
                cls = cls2.getSuperclass();
            }
        }
    }

    public static void a(Object obj, String str, Object obj2) {
        Field a2 = a(obj, str);
        if (a2 != null) {
            try {
                a2.setAccessible(true);
                a2.set(obj, obj2);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
    }
}
