package com.huawei.hms.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/utils/UIUtil.class */
public class UIUtil {
    public static int a(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
    }

    public static Activity getActiveActivity(Activity activity, Context context) {
        if (isBackground(context)) {
            HMSLog.i("UIUtil", "isBackground" + isBackground(context));
            return null;
        } else if (activity == null) {
            HMSLog.i("UIUtil", "activity is null");
            return ActivityMgr.INST.getCurrentActivity();
        } else {
            Activity activity2 = activity;
            if (activity.isFinishing()) {
                HMSLog.i("UIUtil", "activity isFinishing is " + activity.isFinishing());
                activity2 = ActivityMgr.INST.getCurrentActivity();
            }
            return activity2;
        }
    }

    public static int getDialogThemeId(Activity activity) {
        if (a(activity) == 0 || Build.VERSION.SDK_INT < 16) {
            return (activity != null && (activity.getResources().getConfiguration().uiMode & 48) == 32) ? 2 : 3;
        }
        return 0;
    }

    public static String getProcessName(Context context, int i) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == i) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    public static boolean isActivityFullscreen(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    public static boolean isBackground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return true;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        boolean z = true;
        if (activityManager != null) {
            if (keyguardManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                String processName = getProcessName(context, Process.myPid());
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (TextUtils.equals(next.processName, processName)) {
                        HMSLog.i("UIUtil", "appProcess.importance is " + next.importance);
                        boolean z2 = next.importance == 100;
                        boolean isKeyguardLocked = keyguardManager.isKeyguardLocked();
                        HMSLog.i("UIUtil", "isForground is " + z2 + "***  isLockedState is " + isKeyguardLocked);
                        z = true;
                        if (z2) {
                            if (isKeyguardLocked) {
                                return true;
                            }
                            z = false;
                        }
                    }
                }
            } else {
                return true;
            }
        }
        return z;
    }
}
