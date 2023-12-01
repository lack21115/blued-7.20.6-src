package com.kwad.sdk.api.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.kwad.sdk.api.core.KsAdSdkApi;

@KsAdSdkApi
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/push/KsNotificationCompat.class */
public class KsNotificationCompat {

    @KsAdSdkApi
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/push/KsNotificationCompat$Builder.class */
    public static final class Builder {
        private NotificationCompat.Builder mBuilder;

        @KsAdSdkApi
        public Builder(Context context) {
            this(context, null);
        }

        public Builder(Context context, String str) {
            try {
                this.mBuilder = new NotificationCompat.Builder(context, str);
            } catch (Throwable th) {
                this.mBuilder = new NotificationCompat.Builder(context);
            }
        }

        @KsAdSdkApi
        public final Builder addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.mBuilder.addAction(i, charSequence, pendingIntent);
            return this;
        }

        @KsAdSdkApi
        public final Builder addExtras(Bundle bundle) {
            this.mBuilder.addExtras(bundle);
            return this;
        }

        @KsAdSdkApi
        public final Builder addPerson(String str) {
            this.mBuilder.addPerson(str);
            return this;
        }

        @KsAdSdkApi
        public final Notification build() {
            return this.mBuilder.build();
        }

        @KsAdSdkApi
        public final Bundle getExtras() {
            return this.mBuilder.getExtras();
        }

        @KsAdSdkApi
        public final Notification getNotification() {
            return build();
        }

        @KsAdSdkApi
        public final Builder setAutoCancel(boolean z) {
            this.mBuilder.setAutoCancel(z);
            return this;
        }

        @KsAdSdkApi
        public final Builder setBadgeIconType(int i) {
            this.mBuilder.setBadgeIconType(i);
            return this;
        }

        @KsAdSdkApi
        public final Builder setCategory(String str) {
            this.mBuilder.setCategory(str);
            return this;
        }

        @KsAdSdkApi
        public final Builder setChannelId(String str) {
            this.mBuilder.setChannelId(str);
            return this;
        }

        @KsAdSdkApi
        public final Builder setColor(int i) {
            this.mBuilder.setColor(i);
            return this;
        }

        @KsAdSdkApi
        public final Builder setColorized(boolean z) {
            this.mBuilder.setColorized(z);
            return this;
        }

        @KsAdSdkApi
        public final Builder setContent(RemoteViews remoteViews) {
            this.mBuilder.setContent(remoteViews);
            return this;
        }

        @KsAdSdkApi
        public final Builder setContentInfo(CharSequence charSequence) {
            this.mBuilder.setContentInfo(charSequence);
            return this;
        }

        @KsAdSdkApi
        public final Builder setContentIntent(PendingIntent pendingIntent) {
            this.mBuilder.setContentIntent(pendingIntent);
            return this;
        }

        @KsAdSdkApi
        public final Builder setContentText(CharSequence charSequence) {
            this.mBuilder.setContentText(charSequence);
            return this;
        }

        @KsAdSdkApi
        public final Builder setContentTitle(CharSequence charSequence) {
            this.mBuilder.setContentTitle(charSequence);
            return this;
        }

        @KsAdSdkApi
        public final Builder setCustomBigContentView(RemoteViews remoteViews) {
            this.mBuilder.setCustomBigContentView(remoteViews);
            return this;
        }

        @KsAdSdkApi
        public final Builder setCustomContentView(RemoteViews remoteViews) {
            this.mBuilder.setCustomContentView(remoteViews);
            return this;
        }

        @KsAdSdkApi
        public final Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
            this.mBuilder.setCustomHeadsUpContentView(remoteViews);
            return this;
        }

        @KsAdSdkApi
        public final Builder setDefaults(int i) {
            this.mBuilder.setDefaults(i);
            return this;
        }

        @KsAdSdkApi
        public final Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.mBuilder.setDeleteIntent(pendingIntent);
            return this;
        }

        @KsAdSdkApi
        public final Builder setExtras(Bundle bundle) {
            this.mBuilder.setExtras(bundle);
            return this;
        }

        @KsAdSdkApi
        public final Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            this.mBuilder.setFullScreenIntent(pendingIntent, z);
            return this;
        }

        @KsAdSdkApi
        public final Builder setGroup(String str) {
            this.mBuilder.setGroup(str);
            return this;
        }

        @KsAdSdkApi
        public final Builder setGroupAlertBehavior(int i) {
            this.mBuilder.setGroupAlertBehavior(i);
            return this;
        }

        @KsAdSdkApi
        public final Builder setGroupSummary(boolean z) {
            this.mBuilder.setGroupSummary(z);
            return this;
        }

        @KsAdSdkApi
        public final Builder setLargeIcon(Bitmap bitmap) {
            this.mBuilder.setLargeIcon(bitmap);
            return this;
        }

        @KsAdSdkApi
        public final Builder setLights(int i, int i2, int i3) {
            this.mBuilder.setLights(i, i2, i3);
            return this;
        }

        @KsAdSdkApi
        public final Builder setLocalOnly(boolean z) {
            this.mBuilder.setLocalOnly(z);
            return this;
        }

        @KsAdSdkApi
        public final Builder setNumber(int i) {
            this.mBuilder.setNumber(i);
            return this;
        }

        @KsAdSdkApi
        public final Builder setOngoing(boolean z) {
            this.mBuilder.setOngoing(z);
            return this;
        }

        @KsAdSdkApi
        public final Builder setOnlyAlertOnce(boolean z) {
            this.mBuilder.setOnlyAlertOnce(z);
            return this;
        }

        @KsAdSdkApi
        public final Builder setPriority(int i) {
            this.mBuilder.setPriority(i);
            return this;
        }

        @KsAdSdkApi
        public final Builder setProgress(int i, int i2, boolean z) {
            this.mBuilder.setProgress(i, i2, z);
            return this;
        }

        @KsAdSdkApi
        public final Builder setPublicVersion(Notification notification) {
            this.mBuilder.setPublicVersion(notification);
            return this;
        }

        @KsAdSdkApi
        public final Builder setRemoteInputHistory(CharSequence[] charSequenceArr) {
            this.mBuilder.setRemoteInputHistory(charSequenceArr);
            return this;
        }

        @KsAdSdkApi
        public final Builder setShortcutId(String str) {
            this.mBuilder.setShortcutId(str);
            return this;
        }

        @KsAdSdkApi
        public final Builder setShowWhen(boolean z) {
            this.mBuilder.setShowWhen(z);
            return this;
        }

        @KsAdSdkApi
        public final Builder setSmallIcon(int i) {
            this.mBuilder.setSmallIcon(i);
            return this;
        }

        @KsAdSdkApi
        public final Builder setSmallIcon(int i, int i2) {
            this.mBuilder.setSmallIcon(i, i2);
            return this;
        }

        @KsAdSdkApi
        public final Builder setSortKey(String str) {
            this.mBuilder.setSortKey(str);
            return this;
        }

        @KsAdSdkApi
        public final Builder setSound(Uri uri) {
            this.mBuilder.setSound(uri);
            return this;
        }

        @KsAdSdkApi
        public final Builder setSound(Uri uri, int i) {
            this.mBuilder.setSound(uri, i);
            return this;
        }

        @KsAdSdkApi
        public final Builder setSubText(CharSequence charSequence) {
            this.mBuilder.setSubText(charSequence);
            return this;
        }

        @KsAdSdkApi
        public final Builder setTicker(CharSequence charSequence) {
            this.mBuilder.setTicker(charSequence);
            return this;
        }

        @KsAdSdkApi
        public final Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            this.mBuilder.setTicker(charSequence, remoteViews);
            return this;
        }

        @KsAdSdkApi
        public final Builder setTimeoutAfter(long j) {
            this.mBuilder.setTimeoutAfter(j);
            return this;
        }

        @KsAdSdkApi
        public final Builder setUsesChronometer(boolean z) {
            this.mBuilder.setUsesChronometer(z);
            return this;
        }

        @KsAdSdkApi
        public final Builder setVibrate(long[] jArr) {
            this.mBuilder.setVibrate(jArr);
            return this;
        }

        @KsAdSdkApi
        public final Builder setVisibility(int i) {
            this.mBuilder.setVisibility(i);
            return this;
        }

        @KsAdSdkApi
        public final Builder setWhen(long j) {
            this.mBuilder.setWhen(j);
            return this;
        }
    }
}
