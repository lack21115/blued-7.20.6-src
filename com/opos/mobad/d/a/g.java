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
    private NotificationManager f25964a;
    private e b;

    /* renamed from: c  reason: collision with root package name */
    private Context f25965c;

    public g(Context context, e eVar) {
        this.f25965c = context;
        this.f25964a = (NotificationManager) context.getSystemService("notification");
        this.b = eVar;
    }

    private Notification a(int i, e eVar, c.a aVar) {
        NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(this.f25965c).setSmallIcon(eVar.f25959a).setAutoCancel(false).setOnlyAlertOnce(true).setSmallIcon(eVar.f25959a).setContentTitle(aVar.f25953a);
        a(i, contentTitle, aVar);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(eVar.f25960c, eVar.d, eVar.e);
            notificationChannel.enableVibration(false);
            notificationChannel.setLockscreenVisibility(-1);
            notificationChannel.setSound(null, null);
            notificationChannel.setShowBadge(false);
            if (Build.VERSION.SDK_INT >= 29) {
                notificationChannel.setImportance(2);
            }
            contentTitle.setChannelId(eVar.f25960c);
            this.f25964a.createNotificationChannel(notificationChannel);
        }
        return contentTitle.build();
    }

    private void a(int i, NotificationCompat.Builder builder, c.a aVar) {
        Resources resources;
        int i2;
        StringBuilder sb = new StringBuilder();
        int i3 = (Build.VERSION.SDK_INT >= 23 ? 67108864 : 0) | 134217728;
        PendingIntent activity = aVar.f25954c == 105 ? PendingIntent.getActivity(this.f25965c, i, aVar.e, i3) : PendingIntent.getService(this.f25965c, i, aVar.e, i3);
        PendingIntent service = PendingIntent.getService(this.f25965c, i, aVar.g, i3);
        switch (aVar.f25954c) {
            case 102:
                sb.append(this.f25965c.getResources().getString(R.string.download_status_new_downloading_txt));
                sb.append(" ");
                sb.append(String.format("%s", Integer.valueOf(aVar.d)));
                sb.append("%");
                builder.setContentIntent(activity);
                builder.setOngoing(true);
                builder.setProgress(100, aVar.d, false);
                break;
            case 103:
                sb.append(this.f25965c.getResources().getString(R.string.download_status_new_pause_txt));
                sb.append(" ");
                sb.append(String.format("%s", Integer.valueOf(aVar.d)));
                sb.append("%");
                builder.setContentIntent(activity);
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
            case 105:
                resources = this.f25965c.getResources();
                i2 = R.string.download_status_new_complete_txt;
                sb.append(resources.getString(i2));
                builder.setContentIntent(activity);
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
            case 106:
                resources = this.f25965c.getResources();
                i2 = R.string.download_status_new_fail_txt;
                sb.append(resources.getString(i2));
                builder.setContentIntent(activity);
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
            case 107:
                sb.append(this.f25965c.getResources().getString(R.string.download_status_waiting_txt));
                builder.setDeleteIntent(service);
                builder.setOngoing(false);
                break;
        }
        builder.setContentText(sb);
    }

    @Override // com.opos.mobad.d.a.c
    public void a() {
        this.f25964a.cancelAll();
    }

    @Override // com.opos.mobad.d.a.c
    public void a(int i) {
        this.f25964a.cancel(i);
    }

    @Override // com.opos.mobad.d.a.c
    public void a(int i, c.a aVar) {
        this.f25964a.notify(i, a(i, this.b, aVar));
    }
}
