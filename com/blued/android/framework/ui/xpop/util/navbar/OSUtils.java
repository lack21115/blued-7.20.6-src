package com.blued.android.framework.ui.xpop.util.navbar;

import android.text.TextUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/util/navbar/OSUtils.class */
public class OSUtils {
    private static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static boolean a() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name", ""));
    }

    public static boolean b() {
        return !TextUtils.isEmpty(a("ro.build.version.emui", ""));
    }

    public static String c() {
        return b() ? a("ro.build.version.emui", "") : "";
    }

    public static boolean d() {
        String c = c();
        return "EmotionUI 3".equals(c) || c.contains("EmotionUI_3.1");
    }

    public static boolean e() {
        return c().contains("EmotionUI_3.0");
    }

    public static boolean f() {
        return e() || d();
    }
}
