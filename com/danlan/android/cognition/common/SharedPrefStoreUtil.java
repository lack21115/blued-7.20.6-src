package com.danlan.android.cognition.common;

import android.content.Context;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/common/SharedPrefStoreUtil.class */
public class SharedPrefStoreUtil {
    public static String getDataFromSharePref(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static void setDataToSharePref(Context context, String str, String str2, String str3) {
        context.getSharedPreferences(str, 0).edit().putString(str2, str3).apply();
    }
}
