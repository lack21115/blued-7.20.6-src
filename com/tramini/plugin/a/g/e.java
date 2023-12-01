package com.tramini.plugin.a.g;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/g/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f26855a = "";
    private static String b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f26856c = "";
    private static String d = "";
    private static int e;
    private static String f;

    private e() {
    }

    public static String a() {
        if (com.tramini.plugin.a.a.c.a().a("os_vc")) {
            return "";
        }
        if (TextUtils.isEmpty(b)) {
            b = String.valueOf(Build.VERSION.SDK_INT);
        }
        return b;
    }

    public static String a(Context context) {
        if (com.tramini.plugin.a.a.c.a().a("app_vc")) {
            return "";
        }
        if (e != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(e);
            return sb.toString();
        }
        try {
            e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e);
            return sb2.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String b() {
        if (com.tramini.plugin.a.a.c.a().a("os_vn")) {
            return "";
        }
        if (TextUtils.isEmpty(f26855a)) {
            f26855a = Build.VERSION.RELEASE;
        }
        return f26855a;
    }

    public static String b(Context context) {
        if (com.tramini.plugin.a.a.c.a().a("app_vn")) {
            return "";
        }
        try {
            if (TextUtils.isEmpty(d)) {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                d = str;
                return str;
            }
            return d;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String c(Context context) {
        if (com.tramini.plugin.a.a.c.a().a("package_name")) {
            return "";
        }
        try {
            if (TextUtils.isEmpty(f26856c)) {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                f26856c = str;
                return str;
            }
            return f26856c;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String d(Context context) {
        if (com.tramini.plugin.a.a.c.a().a("android_id")) {
            return "";
        }
        try {
            if (f == null) {
                String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                f = string;
                if (string == null) {
                    f = "";
                }
            }
        } catch (Exception e2) {
            f = "";
        }
        return f;
    }
}
