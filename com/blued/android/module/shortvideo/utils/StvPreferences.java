package com.blued.android.module.shortvideo.utils;

import android.content.SharedPreferences;
import com.blued.android.core.AppInfo;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvPreferences.class */
public class StvPreferences {

    /* renamed from: a  reason: collision with root package name */
    private static StvPreferences f15856a;
    private SharedPreferences b = AppInfo.d().getSharedPreferences("stv_preferences_name", 0);

    private StvPreferences() {
    }

    public static StvPreferences a() {
        if (f15856a == null) {
            synchronized (StvPreferences.class) {
                try {
                    if (f15856a == null) {
                        f15856a = new StvPreferences();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f15856a;
    }

    public SharedPreferences b() {
        return this.b;
    }
}
