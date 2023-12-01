package com.tencent.thumbplayer.utils;

import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/k.class */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static Method f39439a;
    private static Method b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f39440c;

    static {
        try {
            f39439a = Class.class.getDeclaredMethod("forName", String.class);
            b = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            f39440c = Class.class.getDeclaredMethod("getDeclaredField", String.class);
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
                method = (Method) b.invoke((Class) f39439a.invoke(null, str), str2, clsArr);
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
        return (f39439a == null || b == null || f39440c == null) ? false : true;
    }
}
