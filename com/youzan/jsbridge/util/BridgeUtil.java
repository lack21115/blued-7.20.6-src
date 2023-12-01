package com.youzan.jsbridge.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/util/BridgeUtil.class */
public class BridgeUtil {
    public static boolean sShouldInjectJs = false;

    public static String getDataPath(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            return packageManager.getPackageInfo(packageName, 0).applicationInfo.dataDir;
        } catch (Exception e) {
            Logger.e("Error Package name not found ");
            return packageName;
        }
    }

    public static void setShouldInjectJs(boolean z) {
        sShouldInjectJs = z;
    }

    public static boolean shouldInjectJs() {
        return sShouldInjectJs || Build.VERSION.SDK_INT < 17;
    }
}
