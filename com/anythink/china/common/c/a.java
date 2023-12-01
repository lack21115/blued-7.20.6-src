package com.anythink.china.common.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/c/a.class */
public final class a {
    public static String a(Context context, File file) {
        if (context == null || file == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1).packageName;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private static void b(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean b(Context context, File file) {
        if (context == null || file == null) {
            return false;
        }
        String a = a(context, file);
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        return a(context, a);
    }
}
