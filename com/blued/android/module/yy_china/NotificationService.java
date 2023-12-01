package com.blued.android.module.yy_china;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.model.YYUserInfo;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/NotificationService.class */
public class NotificationService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static int f16102a;
    private int b = 1;

    private String a(String str, String str2) {
        NotificationChannel notificationChannel = new NotificationChannel(str, str2, 0);
        notificationChannel.setLightColor(Color.BLUE);
        notificationChannel.setLockscreenVisibility(0);
        ((NotificationManager) getSystemService("notification")).createNotificationChannel(notificationChannel);
        return str;
    }

    private void a() {
        LiveLogUtils.a("NotificationService --> showNotification .... ");
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, NotificationService.class), 0);
        if (Build.VERSION.SDK_INT < 26) {
            Notification build = new Notification.Builder(this).setSmallIcon(R.drawable.ic_launcher).setTicker("正在通话").setContentTitle(getText(R.string.notification_live_start)).setContentTitle("正在运行").setContentIntent(activity).build();
            LiveLogUtils.a("NotificationServiceSDK_INT < O 显示通知 ...");
            startForeground(this.b, build);
            LiveLogUtils.a("NotificationServiceSDK_INT < O 显示通知 ...1");
            return;
        }
        Notification build2 = new Notification.Builder(this, a("com.soft.blued", "Blued Background Service")).setSmallIcon(R.drawable.ic_launcher).setTicker("正在通话").setContentTitle(getText(R.string.notification_live_start)).setContentTitle("正在运行").setContentIntent(activity).build();
        LiveLogUtils.a("NotificationService --> SDK_INT >= O 显示通知 ...");
        startForeground(R.string.notification_live_start, build2);
        LiveLogUtils.a("NotificationService --> SDK_INT >= O 显示通知 ...1");
        int i = f16102a;
        if (i == 0) {
            f16102a = 1;
        } else if (i == -1) {
            stopSelf();
        }
    }

    public static void a(Context context) {
        LiveLogUtils.a("NotificationService --> stopBluedService .... ");
        if (Build.VERSION.SDK_INT < 26) {
            context.stopService(new Intent(context, NotificationService.class));
        } else if (f16102a == 1) {
            context.stopService(new Intent(context, NotificationService.class));
        } else {
            f16102a = -1;
        }
    }

    public static void a(Context context, YYUserInfo yYUserInfo) {
        if (yYUserInfo == null || !TextUtils.equals(yYUserInfo.is_mic, "1")) {
            return;
        }
        LiveLogUtils.a("NotificationService --> startBluedService .... ");
        Intent intent = new Intent(context, NotificationService.class);
        if (Build.VERSION.SDK_INT < 26) {
            context.startService(intent);
            return;
        }
        f16102a = 0;
        try {
            context.startForegroundService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        LiveLogUtils.a("NotificationService --> onCreate .... ");
        try {
            a();
        } catch (Exception e) {
            LiveLogUtils.a("NotificationService --> exception ---> " + e.getMessage());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        LiveLogUtils.a("NotificationService --> onDestroy .... ");
        stopForeground(true);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
