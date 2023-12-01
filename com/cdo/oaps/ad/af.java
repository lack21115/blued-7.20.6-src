package com.cdo.oaps.ad;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.cdo.oaps.ad.Launcher;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/af.class */
public class af {

    /* renamed from: a  reason: collision with root package name */
    public static final int f21516a = 5100;
    public static final int b = 4600;

    /* renamed from: c  reason: collision with root package name */
    public static final int f21517c = 4550;
    public static final int d = 390;
    public static final String e = "com.heytap.market";
    public static final String[] f = {"/dt", Launcher.Path.DETAIL_DOWN, "/search", Launcher.Path.SEARCH_DOWN, "/home"};
    public static final String[] g = {"/dt", Launcher.Path.DETAIL_DOWN, "/search", Launcher.Path.SEARCH_DOWN, "/home", Launcher.Path.PREDOWN};
    public static final String[] h = {"/dt", Launcher.Path.DETAIL_DOWN, "/search", Launcher.Path.SEARCH_DOWN, "/home", Launcher.Path.PREDOWN, "/web"};

    public static int a(Context context) {
        int i;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(a.b(), 0);
            i = 0;
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
        } catch (Exception e2) {
            i = 0;
            if (e2 instanceof PackageManager.NameNotFoundException) {
                try {
                    PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(e, 0);
                    i = 0;
                    if (packageInfo2 != null) {
                        i = packageInfo2.versionCode;
                    }
                } catch (Exception e3) {
                    return 0;
                }
            }
        }
        return i;
    }

    public static int a(Context context, String str) {
        int i = 0;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                i = packageInfo.versionCode;
            }
            return i;
        } catch (PackageManager.NameNotFoundException e2) {
            return 0;
        }
    }

    public static boolean a(Context context, int i) {
        int a2 = a(context);
        return a2 != 0 && a2 >= i;
    }

    public static boolean a(Context context, String str, int i) {
        int a2 = a(context, str);
        return a2 != 0 && a2 >= i;
    }

    public static String b(Context context) {
        if (b(context, e)) {
            return e;
        }
        if (b(context, a.b())) {
            return a.b();
        }
        return null;
    }

    public static boolean b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 8192) != null;
        } catch (Exception e2) {
            return false;
        }
    }
}
