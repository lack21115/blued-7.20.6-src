package com.kuaishou.weapon.p0;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/dd.class */
public class dd {
    public static void a(Context context, int i, String str, String str2) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent(str);
            intent.setData(Uri.parse(str2));
            intent.setPackage(context.getPackageName());
            int i2 = 134217728;
            if (context.getApplicationInfo().targetSdkVersion >= 31) {
                i2 = 201326592;
            }
            alarmManager.cancel(PendingIntent.getBroadcast(context, i, intent, i2));
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, String str, int i, long j, String str2) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent(str);
            intent.setData(Uri.parse(str2));
            intent.setPackage(context.getPackageName());
            int i2 = 134217728;
            if (context.getApplicationInfo().targetSdkVersion >= 31) {
                i2 = 201326592;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context, i, intent, i2);
            try {
                alarmManager.cancel(broadcast);
            } catch (Throwable th) {
            }
            alarmManager.set(1, System.currentTimeMillis() + j, broadcast);
        } catch (Throwable th2) {
        }
    }
}
