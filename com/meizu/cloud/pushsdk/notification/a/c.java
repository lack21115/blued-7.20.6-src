package com.meizu.cloud.pushsdk.notification.a;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/notification/a/c.class */
public class c extends com.meizu.cloud.pushsdk.notification.a {
    public c(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    public void b(Notification.Builder builder, MessageV3 messageV3) {
        AppIconSetting appIconSetting;
        Bitmap a2;
        String str;
        if ((!MzSystemUtils.isInternational() || MzSystemUtils.isMeizuAndFlyme()) && (appIconSetting = messageV3.getAppIconSetting()) != null) {
            if (appIconSetting.isDefaultLargeIcon()) {
                if (this.b != null && this.b.getLargeIcon() != 0) {
                    a2 = BitmapFactory.decodeResource(this.f24165a.getResources(), this.b.getLargeIcon());
                    str = "set largeIcon by resource id";
                } else if (this.b == null || this.b.getAppLargeIcon() == null) {
                    a2 = a(this.f24165a, messageV3.getUploadDataPackageName());
                    str = "set largeIcon by package default large icon";
                } else {
                    a2 = this.b.getAppLargeIcon();
                    str = "set largeIcon by bitmap provided by user setting";
                }
                DebugLogger.i("AbstractPushNotification", str);
            } else if (Thread.currentThread() == this.f24165a.getMainLooper().getThread()) {
                return;
            } else {
                Bitmap a3 = a(appIconSetting.getLargeIconUrl());
                if (a3 != null) {
                    DebugLogger.i("AbstractPushNotification", "On other Thread down load largeIcon image success");
                    builder.setLargeIcon(a3);
                    return;
                }
                a2 = a(this.f24165a, messageV3.getUploadDataPackageName());
            }
            builder.setLargeIcon(a2);
        }
    }
}
