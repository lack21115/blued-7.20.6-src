package com.heytap.baselib.appcompat;

import android.content.Context;
import android.os.Binder;
import android.os.Process;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/baselib/appcompat/PermissionChecker.class */
public class PermissionChecker {
    public static final int PERMISSION_DENIED = -1;
    public static final int PERMISSION_DENIED_APP_OP = -2;
    public static final int PERMISSION_GRANTED = 0;

    public static int checkCallingOrSelfPermission(Context context, String str) {
        String packageName = Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null;
        String str2 = packageName;
        if (packageName == null) {
            str2 = "";
        }
        return checkPermission(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
    }

    private static int checkPermission(Context context, String str, int i, int i2, String str2) {
        int i3;
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String permissionToOp = AppOpsManagerCompat.permissionToOp(str);
        if (permissionToOp == null) {
            return 0;
        }
        String str3 = str2;
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            i3 = -1;
            if (packagesForUid != null) {
                i3 = -1;
                if (packagesForUid.length > 0) {
                    str3 = packagesForUid[0];
                }
            }
            return i3;
        }
        if (AppOpsManagerCompat.noteProxyOpNoThrow(context, permissionToOp, str3) != 0) {
            i3 = -2;
            return i3;
        }
        return 0;
    }

    public static int checkSelfPermission(Context context, String str) {
        return checkPermission(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    public final int checkCallingPermission(Context context, String str, String str2) {
        if (Binder.getCallingPid() == Process.myPid()) {
            return -1;
        }
        return checkPermission(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
    }
}
