package com.huawei.hms.push;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.huawei.hms.support.log.HMSLog;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/d.class */
public class d {
    private static int a() {
        return d() ? 603979776 : 536870912;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x008b, code lost:
        r0 = (((r6 - r0) * 30) - (r0.getMinutes() % 30)) * 60000;
        com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "startIndex is:" + r0 + " i is:" + r6 + " delay:" + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00dd, code lost:
        if (r0 < 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00e0, code lost:
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00e6, code lost:
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long a(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.d.a(java.lang.String):long");
    }

    public static Boolean a(Context context, String str, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                int size = queryIntentActivities.size();
                for (int i = 0; i < size; i++) {
                    if (queryIntentActivities.get(i).activityInfo != null && str.equals(queryIntentActivities.get(i).activityInfo.applicationInfo.packageName)) {
                        return Boolean.TRUE;
                    }
                }
            }
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", e.toString(), e);
        }
        return Boolean.FALSE;
    }

    public static String a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
        } catch (PackageManager.NameNotFoundException e) {
            HMSLog.i("PushSelfShowLog", "get the app name of package:" + str + " failed.");
            return null;
        }
    }

    public static void a(Context context, int i) {
        if (context == null) {
            HMSLog.e("PushSelfShowLog", com.anythink.expressad.foundation.g.b.b.f7836a);
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(i);
            }
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", "removeNotifiCationById err:" + e.toString());
        }
    }

    public static void a(Context context, Intent intent) {
        try {
            int intExtra = intent.getIntExtra("selfshow_auto_clear_id", 0);
            HMSLog.d("PushSelfShowLog", "setDelayAlarm(cancel) alarmNotityId " + intExtra);
            if (intExtra == 0) {
                return;
            }
            Intent intent2 = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
            intent2.setPackage(context.getPackageName()).setFlags(32);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            PendingIntent broadcast = PendingIntent.getBroadcast(context, intExtra, intent2, a());
            if (broadcast == null || alarmManager == null) {
                HMSLog.d("PushSelfShowLog", "alarm not exist");
                return;
            }
            HMSLog.d("PushSelfShowLog", "alarm cancel");
            alarmManager.cancel(broadcast);
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", "cancelAlarm err:" + e.toString());
        }
    }

    public static void a(Context context, Intent intent, long j) {
        try {
            HMSLog.d("PushSelfShowLog", "enter setAPDelayAlarm(interval:" + j + "ms.");
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager != null) {
                alarmManager.set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, (int) (System.currentTimeMillis() / 1000), intent, b()));
            }
        } catch (Exception e) {
            HMSLog.w("PushSelfShowLog", "set DelayAlarm error" + e.toString());
        }
    }

    public static boolean a(Context context) {
        return "com.huawei.hwid".equals(context.getPackageName());
    }

    public static int b() {
        return c() ? 67108864 : 134217728;
    }

    public static Intent b(Context context, String str) {
        try {
            return context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Exception e) {
            HMSLog.w("PushSelfShowLog", str + " not have launch activity");
            return null;
        }
    }

    private static boolean c() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean c(Context context, String str) {
        if (context == null || str == null || "".equals(str)) {
            return false;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(str, 8192) == null) {
                return false;
            }
            HMSLog.d("PushSelfShowLog", str + " is installed");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean d() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 33;
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 11;
    }
}
