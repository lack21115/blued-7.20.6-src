package com.oplus.instant.router.g;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.analytics.pro.bh;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/instant/router/g/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f10621a;
    private static String b = "com." + b() + ".instant.platform";

    /* renamed from: c  reason: collision with root package name */
    private static String f10622c = "com." + b() + ".instant.platform.tv";

    public static String a() {
        return "1.3.8_cb5042c_211129";
    }

    public static String a(Context context) {
        String str = "-1";
        if (b(context)) {
            int e = e(context);
            int f = f(context);
            int g = g(context);
            str = "-1";
            if (-1 != e) {
                str = "-1";
                if (-1 != f) {
                    if (-1 == g) {
                        return "-1";
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(f);
                    sb.append("/");
                    sb.append(e);
                    sb.append("/");
                    sb.append(g);
                    try {
                        return URLEncoder.encode(sb.toString(), "UTF-8");
                    } catch (UnsupportedEncodingException e2) {
                        str = sb.toString();
                    }
                }
            }
        }
        return str;
    }

    private static boolean a(Context context, int i) {
        return e(context) >= i;
    }

    public static boolean a(Context context, String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return false;
        }
        String queryParameter = parse.getQueryParameter("min");
        if (TextUtils.isEmpty(queryParameter)) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(queryParameter);
            if (parseInt >= 100) {
                return a(context, parseInt);
            }
            return false;
        } catch (NumberFormatException e) {
            d.a("VersionUtil", e);
            return false;
        }
    }

    private static String b() {
        return a.a("bmVhcm1l");
    }

    public static boolean b(Context context) {
        return !TextUtils.isEmpty(d(context));
    }

    public static boolean b(Context context, String str) {
        if (TextUtils.isEmpty(str) || !str.contains("min")) {
            return true;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            return TextUtils.isEmpty(parse.getQueryParameter("min")) || a(context, str);
        }
        return false;
    }

    public static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(d(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            d.a("VersionUtil", e);
            return -1;
        }
    }

    private static boolean c(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 128) != null;
        } catch (Exception e) {
            d.a("VersionUtil", e);
            return false;
        }
    }

    public static String d(Context context) {
        if (TextUtils.isEmpty(f10621a)) {
            f10621a = h(context);
        }
        return f10621a;
    }

    private static int e(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(d(context), 128);
            if (applicationInfo == null || (obj = applicationInfo.metaData.get("platformVersion")) == null || !(obj instanceof Integer)) {
                return -1;
            }
            return ((Integer) obj).intValue();
        } catch (Exception e) {
            d.a("VersionUtil", e);
            return -1;
        }
    }

    private static int f(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(d(context), 128);
            if (applicationInfo == null || (obj = applicationInfo.metaData.get(bh.aj)) == null || !(obj instanceof Integer)) {
                return -1;
            }
            return ((Integer) obj).intValue();
        } catch (Exception e) {
            d.a("VersionUtil", e);
            return -1;
        }
    }

    private static int g(Context context) {
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(d(context), 128);
            if (applicationInfo == null || (obj = applicationInfo.metaData.get("biz_version")) == null || !(obj instanceof Integer)) {
                return -1;
            }
            return ((Integer) obj).intValue();
        } catch (Exception e) {
            d.a("VersionUtil", e);
            return -1;
        }
    }

    private static String h(Context context) {
        return com.oplus.instant.router.a.a() ? c(context, "com.oplus.instant.platform") ? "com.oplus.instant.platform" : c(context, b) ? b : "" : com.oplus.instant.router.a.b() ? c(context, "com.oplus.instant.platform.tv") ? "com.oplus.instant.platform.tv" : c(context, f10622c) ? f10622c : "" : "";
    }
}
