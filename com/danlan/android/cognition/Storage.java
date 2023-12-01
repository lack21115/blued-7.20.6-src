package com.danlan.android.cognition;

import android.content.Context;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/Storage.class */
public class Storage {
    public static String getIdFromSharePref(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).getString(str2, "");
    }

    public static void setIdToSharePref(Context context, String str, String str2, String str3) {
        context.getSharedPreferences(str, 0).edit().putString(str2, str3).apply();
    }
}
