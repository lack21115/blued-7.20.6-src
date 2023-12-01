package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ap.class */
public final class ap {
    private static String aAi = "";
    private static volatile Boolean aAj;

    private static String DO() {
        return Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
    }

    private static String DP() {
        try {
            Object b = s.b(Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()), "currentProcessName", new Object[0]);
            return b instanceof String ? (String) b : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static String cj(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    public static String getProcessName(Context context) {
        if (TextUtils.isEmpty(aAi)) {
            String DO = DO();
            aAi = DO;
            if (TextUtils.isEmpty(DO)) {
                String DP = DP();
                aAi = DP;
                if (TextUtils.isEmpty(DP)) {
                    String cj = cj(context);
                    aAi = cj;
                    return cj;
                }
                return aAi;
            }
            return aAi;
        }
        return aAi;
    }

    public static boolean isInMainProcess(Context context) {
        if (aAj == null) {
            String processName = getProcessName(context);
            aAj = Boolean.valueOf(!TextUtils.isEmpty(processName) && processName.equals(context.getPackageName()));
        }
        return aAj.booleanValue();
    }
}
