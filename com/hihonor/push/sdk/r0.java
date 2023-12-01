package com.hihonor.push.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/r0.class */
public class r0 {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f22323a;

    public r0(Context context, String str) {
        if (context == null) {
            throw new NullPointerException("context is null!");
        }
        Context context2 = context;
        if (Build.VERSION.SDK_INT >= 24) {
            context2 = context.createDeviceProtectedStorageContext();
            SharedPreferences sharedPreferences = context2.getSharedPreferences("move_to_de_records", 0);
            if (!sharedPreferences.getBoolean(str, false) && context2.moveSharedPreferencesFrom(context, str)) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean(str, true);
                edit.apply();
            }
        }
        this.f22323a = context2.getSharedPreferences(str, 0);
    }

    public boolean a(String str) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f22323a;
        if (sharedPreferences == null || !sharedPreferences.contains(str) || (edit = this.f22323a.edit()) == null) {
            return false;
        }
        return edit.remove(str).commit();
    }

    public boolean a(String str, String str2) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f22323a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.putString(str, str2).commit();
    }
}
