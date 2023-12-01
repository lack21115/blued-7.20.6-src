package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/aj.class */
public final class aj {
    public static boolean cf(Context context) {
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return false;
        }
    }

    public static String[] cg(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            if (packageInfo != null) {
                return packageInfo.requestedPermissions;
            }
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return null;
        }
    }
}
