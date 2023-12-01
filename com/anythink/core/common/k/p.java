package com.anythink.core.common.k;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/p.class */
public final class p {
    public static Long a(Context context, String str, String str2, Long l) {
        if (context == null) {
            return 0L;
        }
        try {
            return Long.valueOf(context.getSharedPreferences(str, 0).getLong(str2, l.longValue()));
        } catch (Error | Exception e) {
            return l;
        }
    }

    public static Map<String, ?> a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getAll();
        } catch (Error | Exception e) {
            return null;
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            context.getSharedPreferences(str, 0).edit().remove(str2).apply();
        } catch (Error | Exception e) {
        }
    }

    public static void a(Context context, String str, String str2, int i) {
        if (context == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putInt(str2, i);
            edit.apply();
        } catch (Error | Exception e) {
        }
    }

    public static void a(Context context, String str, String str2, long j) {
        if (context == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putLong(str2, j);
            edit.apply();
        } catch (Error | Exception e) {
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, String.valueOf(str3));
            edit.apply();
        } catch (Error | Exception e) {
        }
    }

    private static void a(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putBoolean(str2, z);
            edit.apply();
        } catch (Exception e) {
        }
    }

    public static int b(Context context, String str, String str2, int i) {
        if (context == null) {
            return i;
        }
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (Error | Exception e) {
            return i;
        }
    }

    public static String b(Context context, String str, String str2, String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Error | Exception e) {
            return str3;
        }
    }

    private static void b(Context context, String str) {
        if (context == null) {
            return;
        }
        try {
            context.getSharedPreferences(str, 0).edit().clear().apply();
        } catch (Error | Exception e) {
        }
    }

    private static boolean b(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return z;
        }
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z);
        } catch (Exception e) {
            return z;
        }
    }
}
