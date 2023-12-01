package com.blued.android.framework.ui.xpop.util.navbar;

import android.text.TextUtils;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/util/navbar/OSUtils.class */
public class OSUtils {
    private static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static boolean a() {
        return !TextUtils.isEmpty(a(XmSystemUtils.KEY_VERSION_MIUI, ""));
    }

    public static boolean b() {
        return !TextUtils.isEmpty(a("ro.build.version.emui", ""));
    }

    public static String c() {
        return b() ? a("ro.build.version.emui", "") : "";
    }

    public static boolean d() {
        String c2 = c();
        return "EmotionUI 3".equals(c2) || c2.contains("EmotionUI_3.1");
    }

    public static boolean e() {
        return c().contains("EmotionUI_3.0");
    }

    public static boolean f() {
        return e() || d();
    }
}
