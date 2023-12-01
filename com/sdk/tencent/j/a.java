package com.sdk.tencent.j;

import android.content.Context;
import android.content.SharedPreferences;
import com.sdk.tencent.f.c;
import com.sdk.tencent.n.b;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/j/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14370a = "com.sdk.tencent.j.a";
    public static final Boolean b = Boolean.valueOf(c.b);

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ZzxCache", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String str2 : sharedPreferences.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public static void a(Context context, String str, Long l) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("ZzxCache", 0).edit();
            edit.putLong(str, l.longValue());
            edit.commit();
        } catch (Exception e) {
            b.a(f14370a, e.getMessage(), b);
        }
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("ZzxCache", 0).edit();
            edit.putString(str, str2);
            return edit.commit();
        } catch (Exception e) {
            b.a(f14370a, e.getMessage(), b);
            return false;
        }
    }

    public static Long b(Context context, String str) {
        long j = 0;
        try {
            j = context.getSharedPreferences("ZzxCache", 0).getLong(str, 0L);
        } catch (Exception e) {
            b.a(f14370a, e.getMessage(), b);
        }
        return Long.valueOf(j);
    }

    public static String c(Context context, String str) {
        try {
            return context.getSharedPreferences("ZzxCache", 0).getString(str, "");
        } catch (Exception e) {
            b.a(f14370a, e.getMessage(), b);
            return "";
        }
    }
}
