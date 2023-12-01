package com.tencent.thumbplayer.utils;

import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/k.class */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static Method f25748a;
    private static Method b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f25749c;

    static {
        try {
            f25748a = Class.class.getDeclaredMethod("forName", String.class);
            b = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            f25749c = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (Throwable th) {
            TPLogUtil.e("TPPrimaryReflectUtil", th.getMessage());
        }
    }

    public static Object a(Object obj, String str, String str2, Class[] clsArr, Object... objArr) {
        try {
            Method a2 = a(str, str2, clsArr);
            if (a2 != null) {
                return a2.invoke(obj, objArr);
            }
            return null;
        } catch (Throwable th) {
            TPLogUtil.e("TPPrimaryReflectUtil", th.getMessage());
            return null;
        }
    }

    private static Method a(String str, String str2, Class[] clsArr) {
        Method method;
        Method method2 = null;
        if (a()) {
            try {
                method = (Method) b.invoke((Class) f25748a.invoke(null, str), str2, clsArr);
                try {
                    method.setAccessible(true);
                    return method;
                } catch (Throwable th) {
                    th = th;
                    TPLogUtil.e("TPPrimaryReflectUtil", th.getMessage());
                    method2 = method;
                    return method2;
                }
            } catch (Throwable th2) {
                th = th2;
                method = null;
            }
        }
        return method2;
    }

    private static boolean a() {
        return (f25748a == null || b == null || f25749c == null) ? false : true;
    }
}
