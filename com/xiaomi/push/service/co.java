package com.xiaomi.push.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/co.class */
class co extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f27981a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(XMPushService xMPushService) {
        this.f27981a = xMPushService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message != null) {
            try {
                int i = message.what;
                if (i == 17) {
                    if (message.obj != null) {
                        this.f27981a.onStart((Intent) message.obj, 1);
                    }
                } else if (i != 18) {
                } else {
                    Message obtain = Message.obtain((Handler) null, 0);
                    obtain.what = 18;
                    Bundle bundle = new Bundle();
                    bundle.putString("xmsf_region", a.a(this.f27981a.getApplicationContext()).a());
                    obtain.setData(bundle);
                    message.replyTo.send(obtain);
                }
            } catch (Throwable th) {
            }
        }
    }
}
