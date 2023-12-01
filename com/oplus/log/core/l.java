package com.oplus.log.core;

import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/core/l.class */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleDateFormat f10663a = new SimpleDateFormat("yyyy-MM-dd");

    public static long a() {
        try {
            return f10663a.parse(f10663a.format(new Date(System.currentTimeMillis()))).getTime();
        } catch (Exception e) {
            if (com.oplus.log.b.a()) {
                e.printStackTrace();
                return 0L;
            }
            return 0L;
        }
    }

    public static boolean a(String str, Class cls) {
        try {
            ClassLoader classLoader = cls.getClassLoader();
            Class<?> cls2 = Runtime.getRuntime().getClass();
            Class<?>[] clsArr = new Class[2];
            if (Build.VERSION.SDK_INT > 24) {
                clsArr[0] = ClassLoader.class;
                clsArr[1] = String.class;
                Method declaredMethod = cls2.getDeclaredMethod("loadLibrary0", clsArr);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(Runtime.getRuntime(), classLoader, str);
                return true;
            }
            clsArr[0] = String.class;
            clsArr[1] = ClassLoader.class;
            Method declaredMethod2 = cls2.getDeclaredMethod("loadLibrary", clsArr);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(Runtime.getRuntime(), str, classLoader);
            return true;
        } catch (IllegalAccessException e) {
            if (com.oplus.log.b.a()) {
                e.printStackTrace();
                return false;
            }
            return false;
        } catch (NoSuchMethodException e2) {
            if (com.oplus.log.b.a()) {
                e2.printStackTrace();
                return false;
            }
            return false;
        } catch (InvocationTargetException e3) {
            if (com.oplus.log.b.a()) {
                e3.printStackTrace();
                return false;
            }
            return false;
        } catch (Throwable th) {
            if (com.oplus.log.b.a()) {
                th.printStackTrace();
                return false;
            }
            return false;
        }
    }
}
