package com.huawei.openalliance.ad.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/al.class */
public abstract class al {
    public static final int Code = -2;
    private static final String V = "PermissionUtil";

    private static int Code(Context context, String str, String str2, int i, int i2) {
        try {
            if (-1 == context.checkPermission(str, i, i2)) {
                return -1;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null || applicationInfo.targetSdkVersion <= 23) {
                String str3 = null;
                if (Build.VERSION.SDK_INT >= 23) {
                    str3 = AppOpsManager.permissionToOp(str);
                }
                if (str3 == null) {
                    return 0;
                }
                String str4 = str2;
                if (TextUtils.isEmpty(str2)) {
                    String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
                    if (aa.Code(packagesForUid)) {
                        return -1;
                    }
                    str4 = packagesForUid[0];
                }
                return (Build.VERSION.SDK_INT >= 23 ? ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str3, str4) : 1) != 0 ? -2 : 0;
            }
            return 0;
        } catch (Throwable th) {
            ge.I(V, "validatePermission " + th.getClass().getSimpleName());
            return -1;
        }
    }

    public static boolean Code(Context context, String str) {
        boolean z = false;
        if (context == null || TextUtils.isEmpty(str)) {
            ge.V(V, "hasPermission Invalid Input Param");
            return false;
        }
        if (Code(context, str, context.getPackageName(), Process.myPid(), Process.myUid()) == 0) {
            z = true;
        }
        return z;
    }
}
