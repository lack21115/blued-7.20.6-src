package com.blued.android.framework.qrcode.camera;

import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/camera/FlashlightManager.class */
final class FlashlightManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9860a = FlashlightManager.class.getSimpleName();
    private static final Object b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f9861c;

    static {
        Object c2 = c();
        b = c2;
        f9861c = a(c2);
        if (b == null) {
            Log.v(f9860a, "This device does supports control of a flashlight");
        } else {
            Log.v(f9860a, "This device does not support control of a flashlight");
        }
    }

    private FlashlightManager() {
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            return null;
        } catch (RuntimeException e2) {
            String str2 = f9860a;
            Log.w(str2, "Unexpected error while finding class " + str, e2);
            return null;
        }
    }

    private static Object a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            String str = f9860a;
            Log.w(str, "Unexpected error while invoking " + method, e);
            return null;
        } catch (RuntimeException e2) {
            String str2 = f9860a;
            Log.w(str2, "Unexpected error while invoking " + method, e2);
            return null;
        } catch (InvocationTargetException e3) {
            String str3 = f9860a;
            Log.w(str3, "Unexpected error while invoking " + method, e3.getCause());
            return null;
        }
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            return null;
        } catch (RuntimeException e2) {
            String str2 = f9860a;
            Log.w(str2, "Unexpected error while finding method " + str, e2);
            return null;
        }
    }

    private static Method a(Object obj) {
        if (obj == null) {
            return null;
        }
        return a(obj.getClass(), "setFlashlightEnabled", Boolean.TYPE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        a(true);
    }

    private static void a(boolean z) {
        Object obj = b;
        if (obj != null) {
            a(f9861c, obj, Boolean.valueOf(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        a(false);
    }

    private static Object c() {
        Method a2;
        Object a3;
        Class<?> a4;
        Method a5;
        Class<?> a6 = a("android.os.ServiceManager");
        if (a6 == null || (a2 = a(a6, "getService", String.class)) == null || (a3 = a(a2, (Object) null, "hardware")) == null || (a4 = a("android.os.IHardwareService$Stub")) == null || (a5 = a(a4, "asInterface", IBinder.class)) == null) {
            return null;
        }
        return a(a5, (Object) null, a3);
    }
}
