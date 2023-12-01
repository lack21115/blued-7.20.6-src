package com.huawei.openalliance.ad.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/ak.class */
public class ak {
    private static final String Code = "PackageNameUtil";

    public static String Code(Context context) {
        if (context.getPackageManager() == null) {
            ge.I(Code, "pm is null");
            return "";
        }
        return Code(context, Binder.getCallingUid(), Binder.getCallingPid());
    }

    private static String Code(Context context, int i) {
        String[] strArr;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() <= 0) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == i && (strArr = runningAppProcessInfo.pkgList) != null && strArr.length > 0) {
                return strArr[0];
            }
        }
        return null;
    }

    private static String Code(Context context, int i, int i2) {
        PackageManager packageManager;
        String str;
        String str2 = "";
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            String nameForUid = packageManager.getNameForUid(i);
            String str3 = nameForUid;
            if (!TextUtils.isEmpty(nameForUid)) {
                str3 = nameForUid;
                if (nameForUid.contains(":")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("pkg=");
                    sb.append(nameForUid);
                    ge.V(Code, sb.toString());
                    str3 = Code(context, i2);
                }
            }
            str = str3;
            if (TextUtils.isEmpty(str3)) {
                String str4 = str3;
                String[] packagesForUid = packageManager.getPackagesForUid(i);
                str = str3;
                str2 = str3;
                if (!aa.Code(packagesForUid)) {
                    return packagesForUid[0];
                }
            }
        } catch (Throwable th) {
            ge.I(Code, "get name for uid error");
            str = str2;
        }
        return str;
    }
}
