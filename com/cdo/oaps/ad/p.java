package com.cdo.oaps.ad;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/p.class */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7926a = 5100;
    public static final int b = 5000;

    /* renamed from: c  reason: collision with root package name */
    public static final int f7927c = 4600;
    public static final int d = 4550;
    public static final int e = 390;
    public static final int f = 6500;
    public static final int g = 6600;
    public static final int h = 2000000;
    public static final int i = 1;
    public static final int j = 7200;
    public static final int k = 8300;

    public static int a(Context context) {
        return a(context, "com.nearme.gamecenter");
    }

    public static int a(Context context, String str) {
        int i2 = 0;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                i2 = packageInfo.versionCode;
            }
            return i2;
        } catch (PackageManager.NameNotFoundException e2) {
            return 0;
        }
    }

    public static boolean a(Context context, int i2) {
        try {
            return context.getPackageManager().getPackageInfo("com.nearme.gamecenter", 0).versionCode >= i2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str, int i2) {
        int a2 = a(context, str);
        return a2 != 0 && a2 >= i2;
    }

    public static boolean a(Context context, Map<String, Object> map) {
        return !"mk".equals(OapsWrapper.wrapper(map).getHost()) || b(context) >= 5320 || TextUtils.isEmpty(BaseWrapper.wrapper(map).getBasePkg());
    }

    public static int b(Context context) {
        int i2;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(a.b(), 0);
            i2 = 0;
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
        } catch (Exception e2) {
            i2 = 0;
            if (e2 instanceof PackageManager.NameNotFoundException) {
                try {
                    PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(af.e, 0);
                    i2 = 0;
                    if (packageInfo2 != null) {
                        i2 = packageInfo2.versionCode;
                    }
                } catch (Exception e3) {
                    return 0;
                }
            }
        }
        return i2;
    }

    public static boolean b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 8192) != null;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean b(Context context, Map<String, Object> map) {
        return !Launcher.Host.GC.equals(OapsWrapper.wrapper(map).getHost()) || a(context, "com.nearme.gamecenter") >= 7300;
    }
}
