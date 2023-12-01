package com.sina.weibo.sdk.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.anythink.expressad.foundation.h.i;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/utils/SDKNotification.class */
public class SDKNotification {
    private Context mContext;
    private Notification mNotification;

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/utils/SDKNotification$SDKNotificationBuilder.class */
    public static class SDKNotificationBuilder {
        private String mNotificationContent;
        private PendingIntent mNotificationPendingIntent;
        private String mNotificationTitle;
        private Uri mSoundUri;
        private String mTickerText;
        private long[] mVibrate;

        public static SDKNotificationBuilder buildUpon() {
            return new SDKNotificationBuilder();
        }

        private static int getNotificationIcon(Context context) {
            int resourceId = getResourceId(context, "com_sina_weibo_sdk_weibo_logo", i.f7952c);
            if (resourceId > 0) {
                return resourceId;
            }
            return 17301659;
        }

        private static int getResourceId(Context context, String str, String str2) {
            String packageName = context.getApplicationContext().getPackageName();
            try {
                return context.getPackageManager().getResourcesForApplication(packageName).getIdentifier(str, str2, packageName);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return 0;
            }
        }

        public SDKNotification build(Context context) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            builder.setAutoCancel(true);
            builder.setContentIntent(this.mNotificationPendingIntent);
            builder.setTicker(this.mTickerText);
            builder.setSmallIcon(getNotificationIcon(context));
            builder.setWhen(System.currentTimeMillis());
            Uri uri = this.mSoundUri;
            if (uri != null) {
                builder.setSound(uri);
            }
            long[] jArr = this.mVibrate;
            if (jArr != null) {
                builder.setVibrate(jArr);
            }
            builder.setLargeIcon(((BitmapDrawable) ResourceManager.getDrawable(context, "weibosdk_notification_icon.png")).getBitmap());
            builder.setContentTitle(this.mNotificationTitle);
            builder.setContentText(this.mNotificationContent);
            return new SDKNotification(context, builder.build(), null);
        }

        public SDKNotificationBuilder setNotificationContent(String str) {
            this.mNotificationContent = str;
            return this;
        }

        public SDKNotificationBuilder setNotificationPendingIntent(PendingIntent pendingIntent) {
            this.mNotificationPendingIntent = pendingIntent;
            return this;
        }

        public SDKNotificationBuilder setNotificationTitle(String str) {
            this.mNotificationTitle = str;
            return this;
        }

        public SDKNotificationBuilder setSoundUri(Uri uri) {
            this.mSoundUri = uri;
            return this;
        }

        public SDKNotificationBuilder setTickerText(String str) {
            this.mTickerText = str;
            return this;
        }

        public SDKNotificationBuilder setVibrate(long[] jArr) {
            this.mVibrate = jArr;
            return this;
        }
    }

    private SDKNotification(Context context, Notification notification) {
        this.mContext = context.getApplicationContext();
        this.mNotification = notification;
    }

    /* synthetic */ SDKNotification(Context context, Notification notification, SDKNotification sDKNotification) {
        this(context, notification);
    }

    public void show(int i) {
        if (this.mNotification != null) {
            ((NotificationManager) this.mContext.getSystemService("notification")).notify(i, this.mNotification);
        }
    }
}
