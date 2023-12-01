package com.kwad.sdk.api.loader;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/t.class */
public final class t {
    public static void a(Context context, String str, long j) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putLong(str, j).commit();
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, String str, boolean z) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean(str, z).commit();
        } catch (Throwable th) {
        }
    }

    private static long b(Context context, String str, long j) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getLong(str, 0L);
        } catch (Throwable th) {
            return 0L;
        }
    }

    public static boolean b(Context context, String str, boolean z) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getBoolean(str, false);
        } catch (Throwable th) {
            return false;
        }
    }

    public static void c(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putString(str, str2).commit();
        } catch (Throwable th) {
        }
    }

    public static String d(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable th) {
            return str2;
        }
    }

    public static String getString(Context context, String str) {
        return d(context, str, "");
    }

    public static long s(Context context, String str) {
        return b(context, str, 0L);
    }
}
