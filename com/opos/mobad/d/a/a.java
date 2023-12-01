package com.opos.mobad.d.a;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.opos.mobad.d.a.c;
import java.util.HashSet;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/a/a.class */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private NotificationManager f25948a;
    private NotificationCompat.Builder b;

    /* renamed from: c  reason: collision with root package name */
    private Notification f25949c;
    private Notification d;
    private RemoteViews e;
    private Context f;
    private f g;
    private HashSet<Integer> h = new HashSet<>();

    public a(Context context, e eVar) {
        this.f = context;
        this.f25948a = (NotificationManager) context.getSystemService("notification");
        this.f25949c = a(eVar, eVar.b, true, false);
        this.d = Build.VERSION.SDK_INT >= 23 ? a(eVar, true, false, true) : a(eVar, false, true, true);
        this.g = new f(this.f);
    }

    private Notification a(e eVar, boolean z, boolean z2, boolean z3) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.f);
        this.b = builder;
        builder.setSmallIcon(eVar.f25959a);
        this.b.setAutoCancel(z);
        this.b.setOngoing(z2);
        this.b.setOnlyAlertOnce(true);
        this.b.setContentTitle(z3 ? "应用下载完成" : "应用下载");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(eVar.f25960c, eVar.d, eVar.e);
            notificationChannel.enableVibration(false);
            notificationChannel.setLockscreenVisibility(-1);
            notificationChannel.setSound(null, null);
            notificationChannel.setShowBadge(false);
            if (Build.VERSION.SDK_INT >= 29) {
                notificationChannel.setImportance(2);
            }
            this.b.setChannelId(eVar.f25960c);
            this.f25948a.createNotificationChannel(notificationChannel);
        }
        return this.b.build();
    }

    private void a(int i, PendingIntent pendingIntent) {
        com.opos.cmn.an.f.a.b("DownloadNotification", "show showNotificationCancelable:" + i + ",intent:" + pendingIntent);
        if (pendingIntent != null) {
            this.d.deleteIntent = pendingIntent;
        }
        this.d.contentView = this.e;
        this.f25948a.notify(i, this.d);
    }

    private void b(int i) {
        this.f25949c.contentView = this.e;
        this.f25948a.notify(i, this.f25949c);
    }

    @Override // com.opos.mobad.d.a.c
    public void a() {
        com.opos.cmn.an.f.a.b("DownloadNotification", "onCancelAllNotification");
        HashSet<Integer> hashSet = this.h;
        if (hashSet != null) {
            hashSet.clear();
        }
        NotificationManager notificationManager = this.f25948a;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        this.g.a();
    }

    @Override // com.opos.mobad.d.a.c
    public void a(int i) {
        com.opos.cmn.an.f.a.b("DownloadNotification", "onCancelNotification");
        HashSet<Integer> hashSet = this.h;
        if (hashSet != null) {
            hashSet.remove(Integer.valueOf(i));
        }
        NotificationManager notificationManager = this.f25948a;
        if (notificationManager != null) {
            notificationManager.cancel(i);
        }
        f fVar = this.g;
        if (fVar != null) {
            fVar.a(i);
        }
    }

    @Override // com.opos.mobad.d.a.c
    public void a(int i, c.a aVar) {
        if (aVar.f25954c == 105) {
            a(aVar.f25953a, aVar.b, aVar.f25954c, aVar.e, aVar.f, aVar.g, i, aVar.d);
        } else {
            a(aVar.f25953a, aVar.b, aVar.f25954c, aVar.e, aVar.f, i, aVar.d);
        }
    }

    public void a(String str, String str2, int i, Intent intent, Intent intent2, int i2, int i3) {
        com.opos.cmn.an.f.a.b("DownloadNotification", "onShowNotification download appName:" + str + ",process:" + str2 + ",statusCode:" + i);
        RemoteViews a2 = this.g.a(str, str2, i, i3, i2);
        int i4 = Build.VERSION.SDK_INT >= 23 ? 67108864 : 0;
        if (this.h.contains(Integer.valueOf(i2))) {
            int i5 = i4 | 134217728;
            a2.setOnClickPendingIntent(com.opos.mobad.service.e.a(this.f, "dl_ctrl_bt", "id"), PendingIntent.getService(this.f, i2, intent, i5));
            a2.setOnClickPendingIntent(com.opos.mobad.service.e.a(this.f, "dl_delete_bt", "id"), PendingIntent.getService(this.f, i2, intent2, i5));
        } else {
            int i6 = i4 | 268435456;
            a2.setOnClickPendingIntent(com.opos.mobad.service.e.a(this.f, "dl_ctrl_bt", "id"), PendingIntent.getService(this.f, i2, intent, i6));
            a2.setOnClickPendingIntent(com.opos.mobad.service.e.a(this.f, "dl_delete_bt", "id"), PendingIntent.getService(this.f, i2, intent2, i6));
            this.h.add(Integer.valueOf(i2));
            com.opos.cmn.an.f.a.b("DownloadNotification", "onShowNotification add download list");
        }
        this.e = a2;
        b(i2);
    }

    public void a(String str, String str2, int i, Intent intent, Intent intent2, Intent intent3, int i2, int i3) {
        PendingIntent service;
        com.opos.cmn.an.f.a.b("DownloadNotification", "onShowNotification download appName:" + str + ",process:" + str2 + ",statusCode:" + i);
        RemoteViews a2 = this.g.a(str, str2, i, i3, i2);
        int i4 = Build.VERSION.SDK_INT >= 23 ? 67108864 : 0;
        if (this.h.contains(Integer.valueOf(i2))) {
            int i5 = i4 | 134217728;
            a2.setOnClickPendingIntent(com.opos.mobad.service.e.a(this.f, "dl_ctrl_bt", "id"), PendingIntent.getActivity(this.f, i2, intent, i5));
            a2.setOnClickPendingIntent(com.opos.mobad.service.e.a(this.f, "dl_delete_bt", "id"), PendingIntent.getService(this.f, i2, intent2, i5));
            service = PendingIntent.getService(this.f, i2, intent3, i5);
        } else {
            int i6 = i4 | 268435456;
            a2.setOnClickPendingIntent(com.opos.mobad.service.e.a(this.f, "dl_ctrl_bt", "id"), PendingIntent.getActivity(this.f, i2, intent, i6));
            a2.setOnClickPendingIntent(com.opos.mobad.service.e.a(this.f, "dl_delete_bt", "id"), PendingIntent.getService(this.f, i2, intent2, i6));
            service = PendingIntent.getService(this.f, i2, intent3, i6);
            this.h.add(Integer.valueOf(i2));
            com.opos.cmn.an.f.a.b("DownloadNotification", "onShowNotification add download list");
        }
        this.e = a2;
        a(i2, service);
    }
}
