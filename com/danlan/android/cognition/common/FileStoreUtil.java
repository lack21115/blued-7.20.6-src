package com.danlan.android.cognition.common;

import android.content.Context;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/common/FileStoreUtil.class */
public class FileStoreUtil {
    public static String getDataFromSharePref(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, "");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void setDataToSharePref(Context context, String str, String str2, String str3) {
        try {
            context.getSharedPreferences(str, 0).edit().putString(str2, str3).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
