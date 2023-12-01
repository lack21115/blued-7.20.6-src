package com.oplus.log.d;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/d/j.class */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f24363a = false;
    private static String b = "ReflectHelp";

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            if (f24363a) {
                String str2 = b;
                Log.w(str2, "reflect:" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    public static Object a(Class cls, String str, Class[] clsArr, Object[] objArr) {
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Method a2 = a(cls, str, clsArr);
            if (a2 != null) {
                a2.setAccessible(true);
                return a2.invoke(null, objArr);
            }
            return null;
        } catch (Throwable th) {
            if (f24363a) {
                String str2 = b;
                Log.w(str2, "reflect:" + th.getMessage());
                return null;
            }
            return null;
        }
    }

    private static Method a(Class cls, String str, Class[] clsArr) {
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (Exception e) {
            try {
                return cls.getMethod(str, clsArr);
            } catch (Exception e2) {
                if (cls.getSuperclass() != null) {
                    return a(cls.getSuperclass(), str, clsArr);
                }
                return null;
            }
        }
    }
}
