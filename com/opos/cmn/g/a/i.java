package com.opos.cmn.g.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/g/a/i.class */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24965a = i.class.getSimpleName();

    public static String a(Context context) {
        SharedPreferences g = g(context);
        return g != null ? g.getString("ouid", "") : "";
    }

    public static void a(Context context, String str) {
        SharedPreferences g;
        if (TextUtils.isEmpty(str) || (g = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g.edit();
        edit.putString("ouid", str);
        edit.apply();
    }

    public static void a(Context context, boolean z) {
        SharedPreferences g = g(context);
        if (g != null) {
            SharedPreferences.Editor edit = g.edit();
            edit.putBoolean("ouid_status", z);
            edit.apply();
        }
    }

    public static String b(Context context) {
        SharedPreferences g = g(context);
        return g != null ? g.getString("duid", "") : "";
    }

    public static void b(Context context, String str) {
        SharedPreferences g;
        if (TextUtils.isEmpty(str) || (g = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g.edit();
        edit.putString("duid", str);
        edit.apply();
    }

    public static void b(Context context, boolean z) {
        SharedPreferences g = g(context);
        if (g != null) {
            SharedPreferences.Editor edit = g.edit();
            edit.putBoolean("gaid_status", z);
            edit.apply();
        }
    }

    public static String c(Context context) {
        SharedPreferences g = g(context);
        return g != null ? g.getString(TPDownloadProxyEnum.USER_GUID, "") : "";
    }

    public static void c(Context context, String str) {
        SharedPreferences g;
        if (TextUtils.isEmpty(str) || (g = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g.edit();
        edit.putString(TPDownloadProxyEnum.USER_GUID, str);
        edit.apply();
    }

    public static String d(Context context) {
        SharedPreferences g = g(context);
        return g != null ? g.getString("gaid", "") : "";
    }

    public static void d(Context context, String str) {
        SharedPreferences g;
        if (TextUtils.isEmpty(str) || (g = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g.edit();
        edit.putString("gaid", str);
        edit.apply();
    }

    public static void e(Context context, String str) {
        SharedPreferences g;
        if (TextUtils.isEmpty(str) || (g = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor edit = g.edit();
        edit.putString("localId", str);
        edit.apply();
    }

    public static boolean e(Context context) {
        SharedPreferences g = g(context);
        boolean z = false;
        if (g != null) {
            z = g.getBoolean("ouid_status", false);
        }
        return z;
    }

    public static String f(Context context) {
        SharedPreferences g = g(context);
        return g != null ? g.getString("localId", "") : "";
    }

    private static final SharedPreferences g(Context context) {
        return context.getSharedPreferences("com.opos.cmn.third.id.prefs", 0);
    }
}
