package com.blued.android.module.shortvideo.utils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvGuideUtils.class */
public class StvGuideUtils {
    public static boolean a() {
        return StvPreferences.a().b().getBoolean("show_switchcamera_guide", true);
    }

    public static void b() {
        StvPreferences.a().b().edit().putBoolean("show_switchcamera_guide", false).commit();
    }

    public static boolean c() {
        return StvPreferences.a().b().getBoolean("show_video_auth_guide", true);
    }

    public static void d() {
        StvPreferences.a().b().edit().putBoolean("show_video_auth_guide", false).commit();
    }
}
