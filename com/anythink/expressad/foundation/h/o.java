package com.anythink.expressad.foundation.h;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/o.class */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f5125a = true;
    public static boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f5126c = true;
    public static boolean d = true;
    public static boolean e = true;
    public static boolean f = false;
    public static boolean g = true;
    public static boolean h = false;
    private static final String i = "anythink_";

    static {
        if (com.anythink.expressad.a.f4103a) {
            return;
        }
        f5125a = false;
        b = false;
        f5126c = false;
        d = false;
        e = false;
        f = false;
        g = false;
        h = false;
    }

    private o() {
    }

    private static String a(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            str2 = i.concat(String.valueOf(str));
        }
        return str2;
    }

    private static void a(Context context, String str) {
        if (f) {
            Toast.makeText(context, str, 1).show();
        }
    }

    public static void a(String str, String str2) {
        if (!b || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(a(str), str2);
    }

    public static void a(String str, String str2, Throwable th) {
        if (!b || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.d(a(str), str2, th);
    }

    private static void a(String str, Throwable th) {
        if (!d || th == null) {
            return;
        }
        Log.w(a(str), th);
    }

    public static void b(String str, String str2) {
        if (!f5126c || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(a(str), str2);
    }

    public static void b(String str, String str2, Throwable th) {
        if (!e || str2 == null) {
            return;
        }
        Log.e(a(str), str2, th);
    }

    public static void c(String str, String str2) {
        if (!d || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(a(str), str2);
    }

    private static void c(String str, String str2, Throwable th) {
        if (!f5125a || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.v(a(str), str2, th);
    }

    public static void d(String str, String str2) {
        if (!e || str2 == null) {
            return;
        }
        Log.e(a(str), str2);
    }

    private static void d(String str, String str2, Throwable th) {
        if (!f5126c || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(a(str), str2, th);
    }

    private static void e(String str, String str2) {
        if (!f5125a || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.v(a(str), str2);
    }

    private static void e(String str, String str2, Throwable th) {
        if (!d || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.w(a(str), str2, th);
    }
}
