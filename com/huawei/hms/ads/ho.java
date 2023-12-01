package com.huawei.hms.ads;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ho.class */
public abstract class ho {
    private static final String I = "BaseNotification";
    private static final String Z = "hwpps";
    protected Context Code;
    NotificationManager V;

    /* JADX INFO: Access modifiers changed from: protected */
    public ho(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.Code = applicationContext;
        this.V = (NotificationManager) applicationContext.getSystemService("notification");
    }

    private String F() {
        return "hwpps";
    }

    private Notification.Builder V() {
        Notification.Builder builder = new Notification.Builder(this.Code);
        builder.setContentTitle(Z());
        builder.setContentText(C());
        builder.setWhen(System.currentTimeMillis());
        builder.setShowWhen(true);
        builder.setContentIntent(S());
        builder.setAutoCancel(true);
        ApplicationInfo applicationInfo = this.Code.getApplicationInfo();
        if (applicationInfo != null) {
            builder.setSmallIcon(applicationInfo.icon);
        }
        return builder;
    }

    protected String B() {
        return I;
    }

    abstract String C();

    abstract int Code();

    abstract void Code(Notification.Builder builder);

    public void I() {
        Notification.Builder V = V();
        Code(V);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(F(), B(), 3);
            notificationChannel.setShowBadge(false);
            notificationChannel.enableLights(false);
            V.setChannelId(F());
            this.V.createNotificationChannel(notificationChannel);
        }
        this.V.notify(Code(), V.build());
    }

    abstract PendingIntent S();

    abstract String Z();
}
