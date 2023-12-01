package com.tencent.tmsbeacon.base.util;

import android.util.Log;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/util/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f39527a = true;
    private static BeaconLogger b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f39528c = false;

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

    public static void a(BeaconLogger beaconLogger) {
        b = beaconLogger;
    }

    public static void a(String str, int i, String str2, Object... objArr) {
        if (c()) {
            BeaconLogger beaconLogger = b;
            if (beaconLogger == null) {
                Log.d("beacon", c(str + " step: " + i + ". " + str2, objArr));
                return;
            }
            beaconLogger.d("beacon", c(str + " step: " + i + ". " + str2, objArr));
        }
    }

    public static void a(String str, String str2, Object... objArr) {
        if (c()) {
            BeaconLogger beaconLogger = b;
            if (beaconLogger == null) {
                Log.d("beacon", c(str + " " + str2, objArr));
                return;
            }
            beaconLogger.d("beacon", c(str + " " + str2, objArr));
        }
    }

    public static void a(String str, Object... objArr) {
        if (c()) {
            BeaconLogger beaconLogger = b;
            if (beaconLogger == null) {
                Log.d("beacon", c(str, objArr));
            } else {
                beaconLogger.d("beacon", c(str, objArr));
            }
        }
    }

    public static void a(Throwable th) {
        if (th == null || !c()) {
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
                f39528c = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean a() {
        boolean z;
        synchronized (c.class) {
            try {
                z = f39528c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public static void b(String str, Object... objArr) {
        if (c()) {
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
                f39527a = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean b() {
        boolean z;
        synchronized (c.class) {
            try {
                z = f39527a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public static String c(String str, Object... objArr) {
        String e = e();
        if (str == null) {
            return e + "msg is null";
        } else if (objArr == null || objArr.length == 0) {
            return e + str;
        } else {
            return e + String.format(Locale.US, str, objArr);
        }
    }

    private static boolean c() {
        return a();
    }

    private static StackTraceElement d() {
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

    public static void d(String str, Object... objArr) {
        if (c()) {
            BeaconLogger beaconLogger = b;
            if (beaconLogger == null) {
                Log.i("beacon", c(str, objArr));
            } else {
                beaconLogger.i("beacon", c(str, objArr));
            }
        }
    }

    private static String e() {
        StackTraceElement d;
        if (!b() || (d = d()) == null) {
            return "";
        }
        String fileName = d.getFileName();
        String str = fileName != null ? fileName : "";
        String methodName = d.getMethodName();
        String str2 = methodName;
        if (methodName.contains("$")) {
            str2 = methodName.substring(methodName.indexOf("$") + 1, methodName.lastIndexOf("$") - 2);
        }
        return "(" + str + ":" + d.getLineNumber() + ")" + str2 + " ";
    }

    public static void e(String str, Object... objArr) {
        if (c()) {
            BeaconLogger beaconLogger = b;
            if (beaconLogger == null) {
                Log.w("beacon", c(str, objArr));
            } else {
                beaconLogger.w("beacon", c(str, objArr));
            }
        }
    }
}
