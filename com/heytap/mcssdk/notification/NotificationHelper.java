package com.heytap.mcssdk.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import com.heytap.mcssdk.manage.NotificatonChannelManager;
import com.heytap.msp.push.notification.PushNotification;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/notification/NotificationHelper.class */
public class NotificationHelper {
    public static Notification createDefaultGroupNotification(Context context, String str, PushNotification.Builder builder) {
        Notification.Builder builder2 = new Notification.Builder(context);
        if (Build.VERSION.SDK_INT >= 26) {
            builder2.setChannelId(NotificatonChannelManager.DEFAULT_NOTIFICATION_CHANNEL_ID);
        }
        if (Build.VERSION.SDK_INT >= 20) {
            builder2.setGroup(str);
            builder2.setGroupSummary(true);
        }
        if (setGroupIcon(builder2, builder)) {
            return builder2.build();
        }
        return null;
    }

    public static StatusBarNotification[] getActiveNotifications(NotificationManager notificationManager, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return notificationManager.getActiveNotifications();
        }
        return null;
    }

    public static NotificationManager getNotificationManager(Context context) {
        NotificationManager notificationManager = null;
        if (context != null) {
            try {
                notificationManager = (NotificationManager) context.getSystemService("notification");
            } catch (Throwable th) {
                return null;
            }
        }
        return notificationManager;
    }

    public static boolean isExistNotificationsByPkgAndId(NotificationManager notificationManager, String str, int i) {
        StatusBarNotification[] activeNotifications = getActiveNotifications(notificationManager, str);
        if (activeNotifications == null || activeNotifications.length == 0) {
            return false;
        }
        int length = activeNotifications.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            if (activeNotifications[i3].getId() == i) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    private static boolean setGroupIcon(Notification.Builder builder, PushNotification.Builder builder2) {
        int iconRes = builder2.getIconRes();
        int iconLevel = builder2.getIconLevel();
        Icon icon = builder2.getIcon();
        if (icon != null && Build.VERSION.SDK_INT >= 23) {
            builder.setSmallIcon(icon);
            return true;
        } else if (iconRes != 0 && iconLevel != 0) {
            builder.setSmallIcon(iconRes, iconLevel);
            return true;
        } else if (iconRes != 0) {
            builder.setSmallIcon(iconRes);
            return true;
        } else {
            return false;
        }
    }
}
