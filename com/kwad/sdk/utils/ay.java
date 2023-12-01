package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ay.class */
public final class ay {
    private static String TAG = "plugin.signature";

    private static Signature[] cM(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            String str = TAG;
            com.kwad.sdk.core.d.b.w(str, "Can not get signature, error = " + e.getLocalizedMessage());
            com.kwad.sdk.core.d.b.w(TAG, e);
            return null;
        }
    }

    public static String cN(Context context) {
        try {
            Signature[] cM = cM(context);
            return (cM == null || cM.length <= 0) ? "" : ad.l(cM[0].toByteArray());
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.w(TAG, e);
            return "";
        }
    }
}
