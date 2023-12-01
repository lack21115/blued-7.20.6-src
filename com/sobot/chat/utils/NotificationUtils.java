package com.sobot.chat.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import com.anythink.expressad.foundation.h.i;
import com.sobot.chat.api.model.SobotLeaveReplyModel;
import com.sobot.chat.api.model.ZhiChiPushMessage;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/NotificationUtils.class */
public class NotificationUtils {
    private static final String SOBOT_CHANNEL_ID = "sobot_channel_id";
    public static int tmpNotificationId = 1000;

    public static void cancleAllNotification(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            try {
                notificationManager.cancelAll();
            } catch (Exception e) {
            }
        }
    }

    public static void createLeaveReplyNotification(Context context, String str, String str2, String str3, int i, String str4, String str5, SobotLeaveReplyModel sobotLeaveReplyModel) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager == null) {
            return;
        }
        Intent intent = new Intent(ZhiChiConstant.SOBOT_LEAVEREPLEY_NOTIFICATION_CLICK);
        if (sobotLeaveReplyModel != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("sobot_leavereply_model", sobotLeaveReplyModel);
            bundle.putString("sobot_leavereply_companyId", str4);
            bundle.putString("sobot_leavereply_uid", str5);
            intent.putExtras(bundle);
        }
        intent.setPackage(context.getPackageName());
        boolean z = false;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
        int intData = SharedPreferencesUtil.getIntData(context, ZhiChiConstant.SOBOT_NOTIFICATION_SMALL_ICON, ResourceUtils.getIdByName(context, i.f5112c, "sobot_logo_small_icon"));
        ((BitmapDrawable) context.getResources().getDrawable(SharedPreferencesUtil.getIntData(context, ZhiChiConstant.SOBOT_NOTIFICATION_LARGE_ICON, ResourceUtils.getIdByName(context, i.f5112c, "sobot_logo_icon")))).getBitmap();
        Notification.Builder contentIntent = new Notification.Builder(context).setSmallIcon(intData).setTicker(str3).setContentTitle(str).setWhen(sobotLeaveReplyModel.getReplyTime() * 1000).setShowWhen(true).setContentText(Html.fromHtml(str2)).setContentIntent(broadcast);
        if (CommonUtils.getTargetSdkVersion(context) >= 26) {
            z = true;
        }
        if (Build.VERSION.SDK_INT >= 26 && z) {
            notificationManager.createNotificationChannel(new NotificationChannel(SOBOT_CHANNEL_ID, ResourceUtils.getResString(context, "sobot_notification_name"), 3));
            contentIntent.setChannelId(SOBOT_CHANNEL_ID);
        }
        Notification notification = contentIntent.getNotification();
        notification.flags |= 16;
        notification.defaults = 3;
        notificationManager.notify(getNotificationId(), notification);
    }

    public static void createNotification(Context context, String str, String str2, String str3, int i, ZhiChiPushMessage zhiChiPushMessage) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager == null) {
            return;
        }
        Intent intent = new Intent(ZhiChiConstant.SOBOT_NOTIFICATION_CLICK);
        if (zhiChiPushMessage != null) {
            intent.putExtra("sobot_appId", zhiChiPushMessage.getAppId());
        }
        intent.setPackage(context.getPackageName());
        boolean z = false;
        PendingIntent broadcast = Build.VERSION.SDK_INT >= 23 ? PendingIntent.getBroadcast(context, 0, intent, 67108864) : PendingIntent.getBroadcast(context, 0, intent, 134217728);
        int intData = SharedPreferencesUtil.getIntData(context, ZhiChiConstant.SOBOT_NOTIFICATION_SMALL_ICON, ResourceUtils.getIdByName(context, i.f5112c, "sobot_logo_small_icon"));
        ((BitmapDrawable) context.getResources().getDrawable(SharedPreferencesUtil.getIntData(context, ZhiChiConstant.SOBOT_NOTIFICATION_LARGE_ICON, ResourceUtils.getIdByName(context, i.f5112c, "sobot_logo_icon")))).getBitmap();
        Notification.Builder contentIntent = new Notification.Builder(context).setSmallIcon(intData).setTicker(str3).setContentText(HtmlTools.getInstance(context).getHTMLStr(str2)).setContentIntent(broadcast);
        if (CommonUtils.getTargetSdkVersion(context) >= 26) {
            z = true;
        }
        if (Build.VERSION.SDK_INT >= 26 && z) {
            notificationManager.createNotificationChannel(new NotificationChannel(SOBOT_CHANNEL_ID, ResourceUtils.getResString(context, "sobot_notification_name"), 3));
            contentIntent.setChannelId(SOBOT_CHANNEL_ID);
        }
        Notification notification = contentIntent.getNotification();
        notification.flags |= 16;
        notification.defaults = 3;
        notificationManager.notify(i, notification);
    }

    public static final int getNotificationId() {
        if (tmpNotificationId == 1999) {
            tmpNotificationId = 1000;
        }
        int i = tmpNotificationId + 1;
        tmpNotificationId = i;
        return i;
    }
}
