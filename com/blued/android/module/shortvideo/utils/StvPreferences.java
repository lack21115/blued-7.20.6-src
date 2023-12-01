package com.blued.android.module.shortvideo.utils;

import android.content.SharedPreferences;
import com.blued.android.core.AppInfo;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvPreferences.class */
public class StvPreferences {
    private static StvPreferences a;
    private SharedPreferences b = AppInfo.d().getSharedPreferences("stv_preferences_name", 0);

    private StvPreferences() {
    }

    public static StvPreferences a() {
        if (a == null) {
            synchronized (StvPreferences.class) {
                try {
                    if (a == null) {
                        a = new StvPreferences();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public SharedPreferences b() {
        return this.b;
    }
}
