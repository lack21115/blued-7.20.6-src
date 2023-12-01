package com.blued.android.module.live.base.utils;

import com.blued.android.module.common.utils.BluedSharedPreferences;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/utils/LiveBasePreferences.class */
public class LiveBasePreferences {
    public static BluedSharedPreferences a;

    public static BluedSharedPreferences a() {
        if (a == null) {
            a = BluedSharedPreferences.a();
        }
        return a;
    }

    public static String a(String str) {
        return a().a("pay_token", str);
    }

    public static void b(String str) {
        a().c().a("pay_token", str).a();
    }

    public static boolean b() {
        return a().a("first_charge", false);
    }

    public static String c() {
        return a().a("LIVE_MUSIC_SEARCH_HISTORY", "");
    }

    public static void c(String str) {
        a().c().a("LIVE_MUSIC_SEARCH_HISTORY", str).b();
    }
}
