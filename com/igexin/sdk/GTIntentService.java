package com.igexin.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.getui.gtc.base.GtcProvider;
import com.igexin.c.a.c.a.c;
import com.igexin.c.a.c.a.e;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/GTIntentService.class */
public class GTIntentService extends Service {
    private static final int REMOTE_CLINET_RECEIVED = 2;
    private static final int REMOTE_MSG_RECEIVED = 1;
    public final String TAG = getClass().getName();
    private final Messenger client = new Messenger(new a());

    /* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/GTIntentService$a.class */
    final class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            if (message.what == 1) {
                if (message.obj instanceof Intent) {
                    GTIntentService gTIntentService = GTIntentService.this;
                    gTIntentService.processOnHandleIntent(gTIntentService, (Intent) message.obj);
                } else {
                    e.a(GTIntentService.this.TAG, "receive bad msg");
                }
            }
            super.handleMessage(message);
        }
    }

    public void areNotificationsEnabled(Context context, boolean z) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        c.a().a("onBind ".concat(String.valueOf(this)));
        return this.client.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            GtcProvider.setContext(getApplicationContext());
        } catch (Throwable th) {
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    public void onNotificationMessageArrived(Context context, GTNotificationMessage gTNotificationMessage) {
    }

    public void onNotificationMessageClicked(Context context, GTNotificationMessage gTNotificationMessage) {
    }

    public void onReceiveClientId(Context context, String str) {
    }

    public void onReceiveCommandResult(Context context, GTCmdMessage gTCmdMessage) {
    }

    public void onReceiveDeviceToken(Context context, String str) {
    }

    public void onReceiveMessageData(Context context, GTTransmitMessage gTTransmitMessage) {
    }

    public void onReceiveOnlineState(Context context, boolean z) {
    }

    public void onReceiveServicePid(Context context, int i) {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            processOnHandleIntent(this, intent);
            return 2;
        }
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        com.igexin.c.a.c.a.b(this.TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    public void processOnHandleIntent(Context context, Intent intent) {
        if (intent == null || context == null) {
            e.a(this.TAG, "onHandleIntent() context or intent is null");
            return;
        }
        try {
            Bundle extras = intent.getExtras();
            if (extras != null && extras.get("action") != null && (extras.get("action") instanceof Integer)) {
                int i = extras.getInt("action");
                com.igexin.c.a.c.a.b(this.TAG, "onHandleIntent() action = ".concat(String.valueOf(i)));
                Context applicationContext = context.getApplicationContext();
                if (i == 10001) {
                    onReceiveMessageData(applicationContext, (GTTransmitMessage) intent.getSerializableExtra(PushConsts.KEY_MESSAGE_DATA));
                    c.a().a("onHandleIntent() = received msg data ");
                    return;
                } else if (i == 10002) {
                    onReceiveClientId(applicationContext, extras.getString(PushConsts.KEY_CLIENT_ID));
                    c.a().a("onHandleIntent() = received client id ");
                    return;
                } else if (i == 10007) {
                    onReceiveOnlineState(applicationContext, extras.getBoolean(PushConsts.KEY_ONLINE_STATE));
                    return;
                } else if (i == 10008) {
                    onReceiveServicePid(applicationContext, extras.getInt("pid"));
                    c.a().a("onHandleIntent() = get sdk service pid ");
                    return;
                } else {
                    switch (i) {
                        case 10010:
                            onReceiveCommandResult(applicationContext, (GTCmdMessage) intent.getSerializableExtra(PushConsts.KEY_CMD_MSG));
                            c a2 = c.a();
                            a2.a("onHandleIntent() = " + intent.getSerializableExtra(PushConsts.KEY_CMD_MSG).getClass().getSimpleName());
                            return;
                        case 10011:
                            onNotificationMessageArrived(applicationContext, (GTNotificationMessage) intent.getSerializableExtra("notification_arrived"));
                            c.a().a("onHandleIntent() = notification arrived ");
                            return;
                        case 10012:
                            onNotificationMessageClicked(applicationContext, (GTNotificationMessage) intent.getSerializableExtra(PushConsts.KEY_NOTIFICATION_CLICKED));
                            c.a().a("onHandleIntent() notification clicked ");
                            return;
                        case 10013:
                            onReceiveDeviceToken(applicationContext, extras.getString(PushConsts.KEY_DEVICE_TOKEN));
                            c.a().a("onHandleIntent() = received device token ");
                            return;
                        case PushConsts.ACTION_NOTIFICATION_ENABLE /* 10014 */:
                            areNotificationsEnabled(applicationContext, com.igexin.push.f.c.b(applicationContext));
                            c.a().a("onHandleIntent() areNotificationsEnabled");
                            return;
                        default:
                            return;
                    }
                }
            }
            com.igexin.c.a.c.a.b(this.TAG, "onHandleIntent, receive intent error");
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }
}
