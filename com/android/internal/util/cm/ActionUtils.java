package com.android.internal.util.cm;

import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.android.internal.R;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/ActionUtils.class */
public class ActionUtils {
    private static final boolean DEBUG = false;
    private static final String SYSTEMUI_PACKAGE = "com.android.systemui";
    private static final String TAG = ActionUtils.class.getSimpleName();

    private static ActivityManager.RecentTaskInfo getLastTask(Context context, int i) throws RemoteException {
        String resolveCurrentLauncherPackage = resolveCurrentLauncherPackage(context, i);
        List<ActivityManager.RecentTaskInfo> recentTasks = ActivityManagerNative.getDefault().getRecentTasks(5, 2, i);
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 >= recentTasks.size()) {
                return null;
            }
            ActivityManager.RecentTaskInfo recentTaskInfo = recentTasks.get(i3);
            if (recentTaskInfo.origActivity != null) {
                recentTaskInfo.baseIntent.setComponent(recentTaskInfo.origActivity);
            }
            String packageName = recentTaskInfo.baseIntent.getComponent().getPackageName();
            if (!packageName.equals(resolveCurrentLauncherPackage) && !packageName.equals("com.android.systemui")) {
                return recentTasks.get(i3);
            }
            i2 = i3 + 1;
        }
    }

    public static boolean killForegroundApp(Context context, int i) {
        try {
            return killForegroundAppInternal(context, i);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not kill foreground app");
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0058, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean killForegroundAppInternal(android.content.Context r4, int r5) throws android.os.RemoteException {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.util.cm.ActionUtils.killForegroundAppInternal(android.content.Context, int):boolean");
    }

    private static String resolveCurrentLauncherPackage(Context context, int i) {
        return context.getPackageManager().resolveActivityAsUser(new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME), 0, i).activityInfo.packageName;
    }

    public static boolean switchToLastApp(Context context, int i) {
        try {
            return switchToLastAppInternal(context, i);
        } catch (RemoteException e) {
            Log.e(TAG, "Could not switch to last app");
            return false;
        }
    }

    private static boolean switchToLastAppInternal(Context context, int i) throws RemoteException {
        ActivityManager.RecentTaskInfo lastTask = getLastTask(context, i);
        if (lastTask == null || lastTask.id < 0) {
            return false;
        }
        lastTask.baseIntent.getComponent().getPackageName();
        ActivityManagerNative.getDefault().moveTaskToFront(lastTask.id, 2, ActivityOptions.makeCustomAnimation(context, R.anim.last_app_in, R.anim.last_app_out).toBundle());
        return true;
    }
}
