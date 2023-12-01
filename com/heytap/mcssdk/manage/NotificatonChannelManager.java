package com.heytap.mcssdk.manage;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.heytap.mcssdk.utils.SharedPreferenceManager;
import com.heytap.mcssdk.utils.ThreadUtil;
import com.igexin.oppo.R;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/manage/NotificatonChannelManager.class */
public class NotificatonChannelManager {
    private static final int DEFAULT_CHANNEL_IMPORTANCE = 3;
    public static final String DEFAULT_NOTIFICATION_CHANNEL_ID = "Heytap PUSH";
    private static final String DEFAULT_NOTIFICATION_CHANNEL_NAME = "System Default Channel";

    /* JADX INFO: Access modifiers changed from: private */
    public boolean createChannel(Context context, String str, String str2, int i) {
        NotificationManager notificationManager;
        if (context == null || (notificationManager = (NotificationManager) context.getSystemService("notification")) == null) {
            return false;
        }
        notificationManager.createNotificationChannel(new NotificationChannel(str, str2, i));
        return true;
    }

    public void createDefaultChannel(final Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        ThreadUtil.executeOnBackground(new Runnable() { // from class: com.heytap.mcssdk.manage.NotificatonChannelManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (SharedPreferenceManager.getInstance().hasDefaultChannelCreated()) {
                    return;
                }
                String string = context.getString(R.string.system_default_channel);
                String str = string;
                if (TextUtils.isEmpty(string)) {
                    str = NotificatonChannelManager.DEFAULT_NOTIFICATION_CHANNEL_NAME;
                }
                SharedPreferenceManager.getInstance().setHasDefaultChannelCreated(NotificatonChannelManager.this.createChannel(context, NotificatonChannelManager.DEFAULT_NOTIFICATION_CHANNEL_ID, str, 3));
            }
        });
    }
}
