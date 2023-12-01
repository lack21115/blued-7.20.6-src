package com.soft.blued.push.getui;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.das.authority.SystemAuthorityProtos;
import com.blued.track.trackUtils.EventTrackUtils;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushManager;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/push/getui/GetuiIntentService.class */
public class GetuiIntentService extends GTIntentService {

    /* renamed from: a  reason: collision with root package name */
    private boolean f29743a = false;
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private boolean f29744c = false;
    private String d = "";
    private final Runnable e = new Runnable() { // from class: com.soft.blued.push.getui.GetuiIntentService.1
        @Override // java.lang.Runnable
        public void run() {
            GetuiIntentService.this.a();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        boolean areNotificationsEnabled = PushManager.getInstance().areNotificationsEnabled(getApplicationContext());
        String str = this.TAG;
        Log.v(str, "reportData -> clientId = " + this.b + ", token=" + this.d + ", enable=" + areNotificationsEnabled);
        EventTrackUtils.a(SystemAuthorityProtos.SystemAuthorityProto.newBuilder().setEvent(SystemAuthorityProtos.Event.APP_GETUI_PUSH).setClientId(EventTrackUtils.a(this.b)).setToken(EventTrackUtils.a(this.d)).setIsOpen(areNotificationsEnabled).build());
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onNotificationMessageArrived(Context context, GTNotificationMessage gTNotificationMessage) {
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onNotificationMessageClicked(Context context, GTNotificationMessage gTNotificationMessage) {
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveClientId(Context context, String str) {
        String str2 = this.TAG;
        Log.v(str2, "onReceiveClientId -> clientId = " + str);
        this.b = str;
        if (!TextUtils.isEmpty(str)) {
            com.soft.blued.push.PushManager.a().a(str);
        }
        if (!this.f29743a) {
            if (this.f29744c) {
                a();
            } else {
                AppInfo.n().postDelayed(this.e, 15000L);
            }
        }
        this.f29743a = true;
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveCommandResult(Context context, GTCmdMessage gTCmdMessage) {
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveDeviceToken(Context context, String str) {
        String str2 = this.TAG;
        Log.v(str2, "onReceiveDeviceToken -> token = " + str);
        this.d = str;
        if (!this.f29744c && this.f29743a) {
            AppInfo.n().removeCallbacks(this.e);
            a();
        }
        this.f29744c = true;
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveMessageData(Context context, GTTransmitMessage gTTransmitMessage) {
        String str = new String(gTTransmitMessage.getPayload());
        String str2 = this.TAG;
        Log.d(str2, "receiver payload = " + str);
        gTTransmitMessage.getTaskId();
        gTTransmitMessage.getMessageId();
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveOnlineState(Context context, boolean z) {
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveServicePid(Context context, int i) {
    }
}
