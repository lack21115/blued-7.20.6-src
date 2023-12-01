package com.alibaba.mtl.log.e;

import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/b.class */
public class b {
    private static String ae = "";
    private static String b;

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(packageName)) {
                    if (runningAppProcessInfo.importance == 400) {
                        return false;
                    }
                    if (powerManager.isScreenOn()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String getAppkey() {
        return b;
    }

    public static String j() {
        if (com.alibaba.mtl.log.a.getContext() == null) {
            return "";
        }
        try {
            String string = com.alibaba.mtl.log.a.getContext().getSharedPreferences("UTCommon", 0).getString("_lun", "");
            return TextUtils.isEmpty(string) ? "" : new String(c.decode(string.getBytes(), 2), "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    public static String k() {
        if (com.alibaba.mtl.log.a.getContext() == null) {
            return "";
        }
        try {
            String string = com.alibaba.mtl.log.a.getContext().getSharedPreferences("UTCommon", 0).getString("_luid", "");
            return TextUtils.isEmpty(string) ? "" : new String(c.decode(string.getBytes(), 2), "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    public static String l() {
        return ae;
    }

    public static String m() {
        return "";
    }

    public static String n() {
        return "";
    }

    public static void n(String str) {
        i.a("AppInfoUtil", "[setChannle]", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf("@");
        if (indexOf == -1) {
            ae = str;
        } else {
            ae = str.substring(0, indexOf);
        }
    }

    public static void o(String str) {
        i.a("AppInfoUtil", "set Appkey:", str);
        b = str;
    }
}
