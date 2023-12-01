package com.tramini.plugin.a.g;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/g/i.class */
public final class i {
    public static int a(Context context, String str, String str2) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, 2);
        } catch (Error | Exception e) {
            return 2;
        }
    }

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
}
