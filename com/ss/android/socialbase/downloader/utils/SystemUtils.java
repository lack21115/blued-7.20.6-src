package com.ss.android.socialbase.downloader.utils;

import android.content.Context;
import android.content.pm.ServiceInfo;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/utils/SystemUtils.class */
public class SystemUtils {
    public static boolean checkServiceExists(Context context, String str, String str2) {
        try {
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
            int length = serviceInfoArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                ServiceInfo serviceInfo = serviceInfoArr[i2];
                if (serviceInfo.exported && serviceInfo.enabled && serviceInfo.permission == null && serviceInfo.name.equals(str2)) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
