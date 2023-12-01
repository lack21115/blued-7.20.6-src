package com.bytedance.pangle.util;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/util/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f7894a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String b;

    public static boolean a() {
        boolean z = false;
        try {
            if ((Zeus.getAppApplication().getApplicationInfo().flags & 2) != 0) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean a(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        String packageName = context.getPackageName();
        return (TextUtils.isEmpty(packageName) || (runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1)) == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || !packageName.equals(componentName.getPackageName())) ? false : true;
    }

    public static String b(Context context) {
        if (b == null) {
            String[] a2 = c.a(new File(context.getApplicationInfo().sourceDir));
            String str = a2[0];
            b = str;
            if (TextUtils.isEmpty(str)) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, "getHostIdentity failed. Reason: " + a2[2]);
            }
        }
        return b;
    }
}
