package com.blued.android.module.common.utils;

import java.lang.reflect.Field;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/ReflectionUtils.class */
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
                cls = cls2.getSuperclass();
            }
        }
    }

    public static void a(Object obj, Object obj2) {
        a(obj, obj2, false);
    }

    public static void a(Object obj, Object obj2, boolean z) {
        if (obj == null || obj2 == null) {
            return;
        }
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        Field[] declaredFields2 = obj2.getClass().getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            String name = declaredFields[i2].getName();
            Object b = b(obj, name);
            int length2 = declaredFields2.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < length2) {
                    String name2 = declaredFields2[i4].getName();
                    if (!name2.toUpperCase().equals(name.toUpperCase())) {
                        i3 = i4 + 1;
                    } else if (!z || b != null) {
                        a(obj2, name2, b);
                    }
                }
            }
            i = i2 + 1;
        }
        Field[] fields = obj.getClass().getFields();
        Field[] fields2 = obj2.getClass().getFields();
        int length3 = fields.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length3) {
                return;
            }
            String name3 = fields[i6].getName();
            Object b2 = b(obj, name3);
            int length4 = fields2.length;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 < length4) {
                    String name4 = fields2[i8].getName();
                    if (!name4.toUpperCase().equals(name3.toUpperCase())) {
                        i7 = i8 + 1;
                    } else if (!z || b2 != null) {
                        a(obj2, name4, b2);
                    }
                }
            }
            i5 = i6 + 1;
        }
    }

    public static void a(Object obj, String str, Object obj2) {
        Field a2 = a(obj, str);
        a2.setAccessible(true);
        try {
            a2.set(obj, obj2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    public static Object b(Object obj, String str) {
        Field a2 = a(obj, str);
        a2.setAccessible(true);
        try {
            return a2.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
