package com.tencent.beacon.base.util;

import android.util.Log;
import java.util.Locale;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/util/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f21306a = true;
    private static BeaconLogger b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f21307c = false;

    private c() {
    }

    private static int a(StackTraceElement[] stackTraceElementArr, Class cls) {
        int i = 5;
        while (true) {
            int i2 = i;
            if (i2 >= stackTraceElementArr.length) {
                return -1;
            }
            String className = stackTraceElementArr[i2].getClassName();
            if (!(cls.equals(Log.class) && i2 < stackTraceElementArr.length - 1 && stackTraceElementArr[i2 + 1].getClassName().equals(Log.class.getName())) && className.equals(cls.getName())) {
                return i2 + 1;
            }
            i = i2 + 1;
        }
    }

    public static BeaconLogger a() {
        return b;
    }

    public static void a(BeaconLogger beaconLogger) {
        b = beaconLogger;
    }

    public static void a(String str, int i, String str2, Object... objArr) {
        if (d()) {
            BeaconLogger beaconLogger = b;
            if (beaconLogger == null) {
                Log.d("beacon", c(str + " step: " + i + ". " + str2, objArr));
                return;
            }
            beaconLogger.d("beacon", c(str + " step: " + i + ". " + str2, objArr));
        }
    }

    public static void a(String str, String str2, Object... objArr) {
        if (d()) {
            BeaconLogger beaconLogger = b;
            if (beaconLogger == null) {
                Log.d("beacon", c(str + " " + str2, objArr));
                return;
            }
            beaconLogger.d("beacon", c(str + " " + str2, objArr));
        }
    }

    public static void a(String str, Object... objArr) {
        if (d()) {
            BeaconLogger beaconLogger = b;
            if (beaconLogger == null) {
                Log.d("beacon", c(str, objArr));
            } else {
                beaconLogger.d("beacon", c(str, objArr));
            }
        }
    }

    public static void a(Throwable th) {
        if (th == null || !d()) {
            return;
        }
        BeaconLogger beaconLogger = b;
        if (beaconLogger == null) {
            th.printStackTrace();
        } else {
            beaconLogger.printStackTrace(th);
        }
    }

    public static void a(boolean z) {
        synchronized (c.class) {
            try {
                Log.i("beacon", "beacon logAble: " + z);
                f21307c = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(String str, Object... objArr) {
        if (d()) {
            BeaconLogger beaconLogger = b;
            if (beaconLogger == null) {
                Log.e("beacon", c(str, objArr));
            } else {
                beaconLogger.e("beacon", c(str, objArr));
            }
        }
    }

    public static void b(boolean z) {
        synchronized (c.class) {
            try {
                f21306a = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean b() {
        boolean z;
        synchronized (c.class) {
            try {
                z = f21307c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public static String c(String str, Object... objArr) {
        String f = f();
        if (str == null) {
            return f + "msg is null";
        } else if (objArr == null || objArr.length == 0) {
            return f + str;
        } else {
            return f + String.format(Locale.US, str, objArr);
        }
    }

    public static boolean c() {
        boolean z;
        synchronized (c.class) {
            try {
                z = f21306a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public static void d(String str, Object... objArr) {
        if (d()) {
            BeaconLogger beaconLogger = b;
            if (beaconLogger == null) {
                Log.i("beacon", c(str, objArr));
            } else {
                beaconLogger.i("beacon", c(str, objArr));
            }
        }
    }

    private static boolean d() {
        return b();
    }

    private static StackTraceElement e() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int a2 = a(stackTrace, c.class);
        int i = a2;
        if (a2 == -1) {
            int a3 = a(stackTrace, Log.class);
            i = a3;
            if (a3 == -1) {
                return null;
            }
        }
        return stackTrace[i];
    }

    public static void e(String str, Object... objArr) {
        if (d()) {
            BeaconLogger beaconLogger = b;
            if (beaconLogger == null) {
                Log.w("beacon", c(str, objArr));
            } else {
                beaconLogger.w("beacon", c(str, objArr));
            }
        }
    }

    private static String f() {
        StackTraceElement e;
        if (!c() || (e = e()) == null) {
            return "";
        }
        String fileName = e.getFileName();
        String str = fileName != null ? fileName : "";
        String methodName = e.getMethodName();
        String str2 = methodName;
        if (methodName.contains("$")) {
            str2 = methodName.substring(methodName.indexOf("$") + 1, methodName.lastIndexOf("$") - 2);
        }
        return "(" + str + ":" + e.getLineNumber() + ")" + str2 + " ";
    }
}
