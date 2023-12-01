package com.tencent.bugly.idasc.proguard;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/az.class */
public final class az {
    public static ActivityManager.ProcessErrorStateInfo a(ActivityManager activityManager, long j) {
        if (activityManager == null) {
            al.c("get anr state, ActivityManager is null", new Object[0]);
            return null;
        }
        al.c("get anr state, timeout:%d", Long.valueOf(j));
        long j2 = j / 500;
        int i = 0;
        while (true) {
            int i2 = i;
            ActivityManager.ProcessErrorStateInfo a2 = a(activityManager.getProcessesInErrorState());
            if (a2 == null) {
                al.c("found proc state is null", new Object[0]);
            } else if (a2.condition == 2) {
                al.c("found proc state is anr! proc:%s", a2.processName);
                return a2;
            } else if (a2.condition == 1) {
                al.c("found proc state is crashed!", new Object[0]);
                return null;
            }
            int i3 = i2 + 1;
            if (i2 >= j2) {
                return a("Find process anr, but unable to get anr message.");
            }
            al.c("try the %s times:", Integer.valueOf(i3));
            ap.b(500L);
            i = i3;
        }
    }

    private static ActivityManager.ProcessErrorStateInfo a(String str) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = new ActivityManager.ProcessErrorStateInfo();
        processErrorStateInfo.pid = Process.myPid();
        processErrorStateInfo.processName = z.a(Process.myPid());
        processErrorStateInfo.shortMsg = str;
        return processErrorStateInfo;
    }

    private static ActivityManager.ProcessErrorStateInfo a(List<ActivityManager.ProcessErrorStateInfo> list) {
        if (list == null || list.isEmpty()) {
            al.c("error state info list is null", new Object[0]);
            return null;
        }
        int myPid = Process.myPid();
        for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : list) {
            if (processErrorStateInfo.pid == myPid) {
                if (TextUtils.isEmpty(processErrorStateInfo.longMsg)) {
                    return null;
                }
                al.c("found current proc in the error state", new Object[0]);
                return processErrorStateInfo;
            }
        }
        al.c("current proc not in the error state", new Object[0]);
        return null;
    }
}
