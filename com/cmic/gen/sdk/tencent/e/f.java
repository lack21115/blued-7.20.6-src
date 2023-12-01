package com.cmic.gen.sdk.tencent.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/e/f.class */
public class f {
    public static String a(Context context) {
        String str;
        try {
            PackageManager packageManager = context.getPackageManager();
            String str2 = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(d(context), 0));
            if (str2 != null) {
                return str2;
            }
            try {
                PackageInfo c2 = c(context);
                if (c2 == null) {
                    return null;
                }
                return context.getResources().getString(c2.applicationInfo.labelRes);
            } catch (Exception e) {
                str = str2;
                e = e;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e2) {
            e = e2;
            str = null;
        }
    }

    public static String b(Context context) {
        try {
            PackageInfo c2 = c(context);
            if (c2 != null) {
                return d(context) + "&" + c2.versionName;
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static PackageInfo c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String d(Context context) {
        PackageInfo c2 = c(context);
        return c2 == null ? "" : c2.packageName;
    }
}
