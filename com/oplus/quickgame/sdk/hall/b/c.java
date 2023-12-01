package com.oplus.quickgame.sdk.hall.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.oplus.quickgame.sdk.hall.Constant;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/hall/b/c.class */
public class c {
    public static boolean a(Context context) {
        return a(context, Constant.Pkg.HALL_PKG);
    }

    private static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean a(Context context, Map<String, Object> map) {
        com.oplus.quickgame.sdk.hall.c.b b = com.oplus.quickgame.sdk.hall.c.b.b(map);
        int b2 = b(context, Constant.Pkg.HALL_PKG);
        if (b2 < 2100) {
            return false;
        }
        if (!b.c().equals(Constant.Path.PRO_MODE) || b2 >= 2400) {
            return !(b.c().equals(Constant.Path.RECOMMEND) || b.c().equals(Constant.Path.RECOMMEND)) || b2 >= 2800;
        }
        return false;
    }

    private static int b(Context context, String str) {
        int i = 0;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                i = packageInfo.versionCode;
            }
            return i;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }

    public static boolean b(Context context) {
        return a(context, Constant.Pkg.RPK_HALL_PKG);
    }
}
