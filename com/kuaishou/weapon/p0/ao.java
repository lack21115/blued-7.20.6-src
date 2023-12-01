package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/ao.class */
public class ao {
    private boolean a(String str) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        if (systemClassLoader != null) {
            try {
                systemClassLoader.loadClass(str).newInstance();
                return true;
            } catch (ClassNotFoundException e) {
                return false;
            } catch (IllegalAccessException | InstantiationException e2) {
                return true;
            }
        }
        return true;
    }

    public boolean a() {
        try {
            Field declaredField = ClassLoader.getSystemClassLoader().loadClass(an.b).getDeclaredField("disableHooks");
            declaredField.setAccessible(true);
            declaredField.set(null, Boolean.TRUE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean b() {
        try {
            throw new Exception("");
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                if (stackTrace[i2].getClassName().contains(an.b)) {
                    return true;
                }
                i = i2 + 1;
            }
        }
    }

    public boolean c() {
        return a(an.f23726c);
    }

    public boolean d() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        if (systemClassLoader != null) {
            try {
                systemClassLoader.loadClass(an.f23725a).newInstance();
            } catch (ClassNotFoundException e) {
                return false;
            } catch (IllegalAccessException | InstantiationException e2) {
                return true;
            }
        }
        if (systemClassLoader != null) {
            try {
                systemClassLoader.loadClass(an.b).newInstance();
                return true;
            } catch (ClassNotFoundException e3) {
                return false;
            } catch (IllegalAccessException | InstantiationException e4) {
                return true;
            }
        }
        return true;
    }

    public String e() {
        try {
            return System.getProperty("vxp");
        } catch (Exception e) {
            return null;
        }
    }

    public boolean f() {
        try {
            String str = System.getenv("CLASSPATH");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.contains("XposedBridge");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean g() {
        try {
            return Modifier.isNative(Throwable.class.getDeclaredMethod("getStackTrace", new Class[0]).getModifiers());
        } catch (NoSuchMethodException e) {
            return false;
        }
    }
}
