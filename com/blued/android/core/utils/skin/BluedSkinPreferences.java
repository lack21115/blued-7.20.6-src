package com.blued.android.core.utils.skin;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.blued.android.core.AppInfo;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/skin/BluedSkinPreferences.class */
public class BluedSkinPreferences {
    private static SharedPreferences a;

    public static void a(boolean z) {
        c().edit().putBoolean("skin_auto_system", z).commit();
    }

    public static boolean a() {
        return c().getBoolean("skin_auto_system", true);
    }

    public static void b(boolean z) {
        c().edit().putBoolean("skin_dark_mode_status", z).commit();
    }

    public static boolean b() {
        return c().getBoolean("skin_dark_mode_status", false);
    }

    private static SharedPreferences c() {
        if (a == null) {
            a = PreferenceManager.getDefaultSharedPreferences(AppInfo.d());
        }
        return a;
    }
}
