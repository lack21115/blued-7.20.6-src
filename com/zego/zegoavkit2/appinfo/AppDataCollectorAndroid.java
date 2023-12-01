package com.zego.zegoavkit2.appinfo;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/appinfo/AppDataCollectorAndroid.class */
public final class AppDataCollectorAndroid {
    public String getAppName(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).applicationInfo.labelRes);
        } catch (Exception e) {
            return "";
        }
    }

    public int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
        } catch (Exception e) {
            return 0;
        }
    }

    public String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isApkInDebug(Context context) {
        boolean z = false;
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }
}
