package com.blued.android.module.external_sense_library.utils;

import android.content.SharedPreferences;
import com.blued.android.core.AppInfo;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/SPUtils.class */
public class SPUtils {
    private SharedPreferences a;
    private SharedPreferences.Editor b;

    public SPUtils(String str) {
        SharedPreferences sharedPreferences = AppInfo.d().getSharedPreferences(str, 0);
        this.a = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        this.b = edit;
        edit.apply();
    }

    public void a(String str, String str2) {
        this.b.putString(str, str2).apply();
    }

    public String b(String str, String str2) {
        return this.a.getString(str, str2);
    }
}
