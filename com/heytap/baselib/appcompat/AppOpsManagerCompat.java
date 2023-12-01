package com.heytap.baselib.appcompat;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/baselib/appcompat/AppOpsManagerCompat.class */
class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    AppOpsManagerCompat() {
    }

    public static final int noteProxyOpNoThrow(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str, str2);
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String permissionToOp(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp(str);
        }
        return null;
    }

    public int noteOp(Context context, String str, int i, String str2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return ((AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE)).noteOp(str, i, str2);
        }
        return 1;
    }

    public int noteOpNoThrow(Context context, String str, int i, String str2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return ((AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE)).noteOpNoThrow(str, i, str2);
        }
        return 1;
    }

    public final int noteProxyOp(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
        }
        return 1;
    }
}
