package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/br.class */
public class br {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6516a = "PackageUtils";

    public static boolean a(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            boolean z = false;
            if (applicationInfo != null) {
                z = false;
                if (str.equals(applicationInfo.packageName)) {
                    z = true;
                }
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        boolean z = false;
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(268435456);
                z = false;
                if (packageManager.queryIntentActivities(intent, 65536).size() > 0) {
                    z = true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return z;
    }
}
