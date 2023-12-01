package com.opos.mobad.d.a;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.d.a.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/a/g.class */
public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    private NotificationManager f12276a;
    private e b;

    /* renamed from: c  reason: collision with root package name */
    private Context f12277c;

    public g(Context context, e eVar) {
        this.f12277c = context;
        this.f12276a = (NotificationManager) context.getSystemService("notification");
        this.b = eVar;
    }

    private Notification a(int i, e eVar, c.a aVar) {
        NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(this.f12277c).setSmallIcon(eVar.f12271a).setAutoCancel(false).setOnlyAlertOnce(true).setSmallIcon(eVar.f12271a).setContentTitle(aVar.f12265a);
        a(i, contentTitle, aVar);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(eVar.f12272c, eVar.d, eVar.e);
            notificationChannel.enableVibration(false);
            notificationChannel.setLockscreenVisibility(-1);
            notificationChannel.setSound(null, null);
            notificationChannel.setShowBadge(false);
            if (Build.VERSION.SDK_INT >= 29) {
                notificationChannel.setImportance(2);
            }
            contentTitle.setChannelId(eVar.f12272c);
            this.f12276a.createNotificationChannel(notificationChannel);
        }
        return contentTitle.build();
    }

    private void a(int i, NotificationCompat.Builder builder, c.a aVar) {
        Resources resources;
        int i2;
        StringBuilder sb = new StringBuilder();
        int i3 = (Build.VERSION.SDK_INT >= 23 ? 67108864 : 0) | 134217728;
        PendingIntent activity = aVar.f12266c == 105 ? PendingIntent.getActivity(this.f12277c, i, aVar.e, i3) : PendingIntent.getService(this.f12277c, i, aVar.e, i3);
        PendingIntent service = PendingIntent.getService(this.f12277c, i, aVar.g, i3);
        switch (aVar.f12266c) {
            case 102:
                sb.append(this.f12277c.getResources().getString(R.string.download_status_new_downloading_txt));
                sb.append(" ");
                sb.append(String.format("%s", Integer.valueOf(aVar.d)));
                sb.append("%");
                builder.setContentIntent(activity);
                builder.setOngoing(true);
                builder.setProgress(100, aVar.d, false);
                break;
            case 103:
                sb.append(this.f12277c.getResources().getString(R.string.download_status_new_pause_txt));
                sb.append(" ");
                sb.append(String.format("%s", Integer.valueOf(aVar.d)));
                sb.append("%");
                builder.setContentIntent(activity);
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
            case 105:
                resources = this.f12277c.getResources();
                i2 = R.string.download_status_new_complete_txt;
                sb.append(resources.getString(i2));
                builder.setContentIntent(activity);
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
            case 106:
                resources = this.f12277c.getResources();
                i2 = R.string.download_status_new_fail_txt;
                sb.append(resources.getString(i2));
                builder.setContentIntent(activity);
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
            case 107:
                sb.append(this.f12277c.getResources().getString(R.string.download_status_waiting_txt));
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
        }
        builder.setContentText(sb);
    }

    @Override // com.opos.mobad.d.a.c
    public void a() {
        this.f12276a.cancelAll();
    }

    @Override // com.opos.mobad.d.a.c
    public void a(int i) {
        this.f12276a.cancel(i);
    }

    @Override // com.opos.mobad.d.a.c
    public void a(int i, c.a aVar) {
        this.f12276a.notify(i, a(i, this.b, aVar));
    }
}
