package com.tencent.bugly.idasc.proguard;

import android.util.Log;
import java.util.Locale;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/al.class */
public final class al {

    /* renamed from: a  reason: collision with root package name */
    public static String f21547a = "CrashReportInfo";
    public static String b = "CrashReport";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f21548c = false;

    private static boolean a(int i, String str, Object... objArr) {
        String str2;
        if (f21548c) {
            if (str == null) {
                str2 = com.igexin.push.core.b.l;
            } else {
                str2 = str;
                if (objArr != null) {
                    str2 = objArr.length == 0 ? str : String.format(Locale.US, str, objArr);
                }
            }
            if (i == 0) {
                Log.i(b, str2);
                return true;
            } else if (i == 1) {
                Log.d(b, str2);
                return true;
            } else if (i == 2) {
                Log.w(b, str2);
                return true;
            } else if (i == 3) {
                Log.e(b, str2);
                return true;
            } else if (i != 5) {
                return false;
            } else {
                Log.i(f21547a, str2);
                return true;
            }
        }
        return false;
    }

    private static boolean a(int i, Throwable th) {
        if (f21548c) {
            return a(i, ap.a(th), new Object[0]);
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
        return a(2, th);
    }

    public static boolean b(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean b(Throwable th) {
        return a(3, th);
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
