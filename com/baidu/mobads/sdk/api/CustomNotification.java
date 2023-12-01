package com.baidu.mobads.sdk.api;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.proxy.R;
import com.baidu.mobads.sdk.internal.bj;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/CustomNotification.class */
public class CustomNotification {
    private NotificationCompat.Style mStyle = new NotificationCompat.DecoratedCustomViewStyle();

    private void setRemoteViewText(RemoteViews remoteViews, int i, String str) {
        if (remoteViews != null) {
            if (TextUtils.isEmpty(str)) {
                remoteViews.setViewVisibility(i, 8);
                return;
            }
            remoteViews.setTextViewText(i, str);
            remoteViews.setViewVisibility(i, 0);
        }
    }

    public Notification getCustomNotification(Context context, String str, String str2, Bitmap bitmap, String str3, String str4, String str5, boolean z, int i, int i2, String str6, PendingIntent pendingIntent) {
        NotificationCompat.Builder builder;
        if (bj.a(context).a() < 26) {
            builder = new NotificationCompat.Builder(context);
        } else {
            String str7 = str;
            if (TextUtils.isEmpty(str)) {
                str7 = "down";
            }
            try {
                builder = new NotificationCompat.Builder(context, str7);
            } catch (NoSuchMethodError e) {
                builder = new NotificationCompat.Builder(context);
            }
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.mobads_cutom_notification_layout);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R.id.left_icon, bitmap);
        } else {
            remoteViews.setImageViewResource(R.id.left_icon, R.drawable.ic_stat_bd_notif_download);
        }
        setRemoteViewText(remoteViews, R.id.notification_title, str3);
        if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5)) {
            remoteViews.setViewVisibility(R.id.content_layout, 8);
        } else {
            remoteViews.setViewVisibility(R.id.content_layout, 0);
            setRemoteViewText(remoteViews, R.id.content_text, str4);
            setRemoteViewText(remoteViews, R.id.content_status, str5);
        }
        if (i < 0 || i > 100) {
            remoteViews.setViewVisibility(R.id.progress_bar, 8);
        } else {
            remoteViews.setProgressBar(R.id.progress_bar, 100, i, false);
            remoteViews.setViewVisibility(R.id.progress_bar, 0);
        }
        remoteViews.setTextViewText(R.id.btn_action, str6);
        remoteViews.setOnClickPendingIntent(R.id.btn_action, pendingIntent);
        return builder.setSmallIcon(i2).setOngoing(false).setTicker(str2).setAutoCancel(z).setWhen(System.currentTimeMillis()).setCustomContentView(remoteViews).build();
    }
}
