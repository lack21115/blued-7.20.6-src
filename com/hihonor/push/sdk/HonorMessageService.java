package com.hihonor.push.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.push.sdk.common.data.DownMsgType;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/HonorMessageService.class */
public abstract class HonorMessageService extends Service {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f22273c = 0;

    /* renamed from: a  reason: collision with root package name */
    public final a f22274a;
    public final Messenger b;

    /* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/HonorMessageService$a.class */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.i("HonorMessageService", "handle message for broadcast.");
            Bundle data = message.getData();
            if (data != null) {
                Intent intent = new Intent();
                intent.putExtras(data);
                HonorMessageService honorMessageService = HonorMessageService.this;
                int i = HonorMessageService.f22273c;
                honorMessageService.a(intent);
            }
        }
    }

    public HonorMessageService() {
        a aVar = new a(Looper.getMainLooper());
        this.f22274a = aVar;
        this.b = new Messenger(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j0 j0Var) {
        if (!j0Var.e()) {
            j0Var.b();
            return;
        }
        HonorPushDataMsg honorPushDataMsg = (HonorPushDataMsg) j0Var.c();
        if (honorPushDataMsg == null) {
            Log.i("HonorMessageService", "parse remote data failed.");
            return;
        }
        Log.i("HonorMessageService", "onMessageReceived. msgId is " + honorPushDataMsg.getMsgId());
        onMessageReceived(honorPushDataMsg);
    }

    public final void a(Intent intent) {
        try {
            if (TextUtils.equals(intent.getStringExtra("event_type"), DownMsgType.RECEIVE_TOKEN)) {
                String stringExtra = intent.getStringExtra("push_token");
                Context a2 = d.e.a();
                c cVar = c.b;
                if (!TextUtils.equals(stringExtra, cVar.b(a2))) {
                    cVar.a(a2, stringExtra);
                }
                Log.i("HonorMessageService", "onNewToken");
                onNewToken(stringExtra);
            } else {
                b(intent);
            }
            Log.i("HonorMessageService", "dispatch message end.");
        } catch (Exception e) {
            new StringBuilder("dispatch message error. ").append(e.getMessage());
        }
    }

    public final void b(Intent intent) {
        Log.i("HonorMessageService", "parse remote data start.");
        j0 a2 = com.hihonor.push.sdk.a.a(new a0(intent));
        u uVar = new u() { // from class: com.hihonor.push.sdk.-$$Lambda$HonorMessageService$FKWJ-vla_iJJyXbsq9bKrTzSJY8
            @Override // com.hihonor.push.sdk.u
            public final void a(j0 j0Var) {
                HonorMessageService.this.a(j0Var);
            }
        };
        a2.getClass();
        a2.a(new d0(y.f22325c.f22326a, uVar));
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.b.getBinder();
    }

    public void onMessageReceived(HonorPushDataMsg honorPushDataMsg) {
    }

    public void onNewToken(String str) {
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        Log.i("HonorMessageService", "handle message for service.");
        a(intent);
        return 2;
    }
}
