package com.sina.weibo.sdk.cmd;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.SDKNotification;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/cmd/AppInvokeCmdExecutor.class */
public class AppInvokeCmdExecutor implements CmdExecutor<AppInvokeCmd> {
    private static final int NOTIFICATION_ID = 2;
    private static final int SHOW_NOTICIATION = 1;
    private Context mContext;
    private NotificationHandler mHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/cmd/AppInvokeCmdExecutor$NotificationHandler.class */
    public class NotificationHandler extends Handler {
        public NotificationHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            AppInvokeCmdExecutor.showNotification(AppInvokeCmdExecutor.this.mContext, (AppInvokeCmd) message.obj);
        }
    }

    public AppInvokeCmdExecutor(Context context) {
        this.mContext = context.getApplicationContext();
        this.mHandler = new NotificationHandler(this.mContext.getMainLooper());
    }

    private static PendingIntent buildInvokePendingIntent(Context context, AppInvokeCmd appInvokeCmd) {
        List<ResolveInfo> queryIntentActivities;
        String scheme = appInvokeCmd.getScheme();
        String url = appInvokeCmd.getUrl();
        Intent buildOpenSchemeIntent = buildOpenSchemeIntent(scheme, appInvokeCmd.getAppPackage());
        if (buildOpenSchemeIntent == null || (queryIntentActivities = context.getPackageManager().queryIntentActivities(buildOpenSchemeIntent, 65536)) == null || queryIntentActivities.isEmpty()) {
            buildOpenSchemeIntent = null;
        }
        Intent intent = buildOpenSchemeIntent;
        if (buildOpenSchemeIntent == null) {
            intent = buildOpenUrlIntent(url);
        }
        if (intent != null) {
            intent.setFlags(268435456);
            return PendingIntent.getActivity(context, 0, intent, 134217728);
        }
        return null;
    }

    private static Intent buildOpenSchemeIntent(String str, String str2) {
        if (TextUtils.isEmpty(str) || !Uri.parse(str).isHierarchical()) {
            return null;
        }
        Uri parse = Uri.parse(str);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(parse);
        intent.setPackage(str2);
        return intent;
    }

    private static Intent buildOpenUrlIntent(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https")) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            return intent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showNotification(Context context, AppInvokeCmd appInvokeCmd) {
        SDKNotification.SDKNotificationBuilder.buildUpon().setNotificationContent(appInvokeCmd.getNotificationText()).setNotificationPendingIntent(buildInvokePendingIntent(context, appInvokeCmd)).setNotificationTitle(appInvokeCmd.getNotificationTitle()).setTickerText(appInvokeCmd.getNotificationText()).build(context).show(2);
    }

    @Override // com.sina.weibo.sdk.cmd.CmdExecutor
    public boolean doExecutor(AppInvokeCmd appInvokeCmd) {
        if (appInvokeCmd == null || TextUtils.isEmpty(appInvokeCmd.getNotificationText()) || TextUtils.isEmpty(appInvokeCmd.getScheme())) {
            return false;
        }
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = appInvokeCmd;
        this.mHandler.sendMessageDelayed(obtainMessage, appInvokeCmd.getNotificationDelay());
        return true;
    }
}
