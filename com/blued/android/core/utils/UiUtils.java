package com.blued.android.core.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.PowerManager;
import com.blued.android.core.AppMethods;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/UiUtils.class */
public class UiUtils {
    public static boolean a(Activity activity) {
        return AppMethods.c(17) ? b(activity) : (activity == null || activity.isFinishing()) ? false : true;
    }

    public static boolean a(Context context) {
        ComponentName componentName;
        if (((PowerManager) context.getSystemService("power")).isScreenOn()) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses == null || activityManager == null) {
                    return false;
                }
                String packageName = context.getPackageName();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                        try {
                            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                            if (!runningTasks.isEmpty() && (componentName = runningTasks.get(0).topActivity) != null && componentName.getPackageName().equals(packageName)) {
                                return true;
                            }
                        } catch (Exception e) {
                        }
                    }
                }
                return false;
            } catch (Exception e2) {
                return false;
            }
        }
        return false;
    }

    private static boolean b(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }
}
