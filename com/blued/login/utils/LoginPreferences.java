package com.blued.login.utils;

import com.blued.android.module.common.utils.BluedSharedPreferences;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/utils/LoginPreferences.class */
public class LoginPreferences {

    /* renamed from: a  reason: collision with root package name */
    public static String f6990a = "adress";
    public static String b = "latitude";

    /* renamed from: c  reason: collision with root package name */
    public static String f6991c = "longitude";
    public static String d = "USER_CONSENT_CLAUSE";
    @Deprecated
    private static volatile BluedSharedPreferences e;

    private LoginPreferences() {
    }

    public static String a() {
        return h().a(f6990a, "");
    }

    public static void a(String str) {
        h().c().a("login_out_msg", str).a();
    }

    public static void a(boolean z) {
        h().c().a("login_test", z).a();
    }

    public static String b() {
        return h().a(b, "0");
    }

    public static String c() {
        return h().a(f6991c, "0");
    }

    public static String d() {
        return h().a("login_out_msg", "");
    }

    public static boolean e() {
        return h().a("login_test", true);
    }

    public static boolean f() {
        return h().a(d, false);
    }

    public static void g() {
        h().c().a(d, true).b();
    }

    @Deprecated
    private static BluedSharedPreferences h() {
        BluedSharedPreferences bluedSharedPreferences;
        synchronized (LoginPreferences.class) {
            try {
                if (e == null) {
                    synchronized (LoginPreferences.class) {
                        if (e == null) {
                            e = BluedSharedPreferences.a();
                        }
                    }
                }
                bluedSharedPreferences = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bluedSharedPreferences;
    }
}
