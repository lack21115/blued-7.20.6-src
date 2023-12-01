package com.anythink.core.common.k;

import android.util.Log;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f6807a = false;
    public static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f6808c = false;
    private static boolean d = false;
    private static boolean e = false;
    private static boolean f = false;
    private static boolean g = false;
    private static boolean h = false;

    private e() {
    }

    private static void a(String str, String str2) {
        if (f6808c) {
            Log.v(str, str2);
        }
    }

    private static void a(String str, String str2, Throwable th) {
        if (f6808c) {
            Log.v(str, str2, th);
        }
    }

    private static void a(String str, Throwable th) {
        if (f) {
            Log.w(str, th);
        }
    }

    private static void b(String str, String str2) {
        if (d) {
            Log.d(str, str2);
        }
    }

    private static void b(String str, String str2, Throwable th) {
        if (d) {
            Log.d(str, str2, th);
        }
    }

    private static void c(String str, String str2) {
        if (e) {
            Log.i(str, str2);
        }
    }

    private static void c(String str, String str2, Throwable th) {
        if (e) {
            Log.i(str, str2, th);
        }
    }

    private static void d(String str, String str2) {
        if (f) {
            Log.w(str, str2);
        }
    }

    private static void d(String str, String str2, Throwable th) {
        if (f) {
            Log.w(str, str2, th);
        }
    }

    private static void e(String str, String str2) {
        if (g) {
            Log.e(str, str2);
        }
    }

    private static void e(String str, String str2, Throwable th) {
        if (g) {
            Log.e(str, str2, th);
        }
        if (!h) {
        }
    }
}
