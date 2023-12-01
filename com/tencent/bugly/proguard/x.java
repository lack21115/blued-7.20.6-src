package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/x.class */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static String f35414a = "CrashReport";
    public static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String f35415c = "CrashReportInfo";

    private static boolean a(int i, String str, Object... objArr) {
        String str2;
        if (b) {
            if (str == null) {
                str2 = com.igexin.push.core.b.l;
            } else {
                str2 = str;
                if (objArr != null) {
                    str2 = objArr.length == 0 ? str : String.format(Locale.US, str, objArr);
                }
            }
            if (i == 0) {
                Log.i(f35414a, str2);
                return true;
            } else if (i == 1) {
                Log.d(f35414a, str2);
                return true;
            } else if (i == 2) {
                Log.w(f35414a, str2);
                return true;
            } else if (i == 3) {
                Log.e(f35414a, str2);
                return true;
            } else if (i != 5) {
                return false;
            } else {
                Log.i(f35415c, str2);
                return true;
            }
        }
        return false;
    }

    public static boolean a(Class cls, String str, Object... objArr) {
        return a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean a(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean a(Throwable th) {
        if (b) {
            return a(2, z.a(th), new Object[0]);
        }
        return false;
    }

    public static boolean b(Class cls, String str, Object... objArr) {
        return a(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean b(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean b(Throwable th) {
        if (b) {
            return a(3, z.a(th), new Object[0]);
        }
        return false;
    }

    public static boolean c(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    public static boolean e(String str, Object... objArr) {
        return a(3, str, objArr);
    }
}
