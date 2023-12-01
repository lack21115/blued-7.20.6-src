package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/cr.class */
class cr extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f27984a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cr(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f27984a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m9039g;
        super.onChange(z);
        m9039g = this.f27984a.m9039g();
        com.xiaomi.channel.commonutils.logger.b.m8344a("SuperPowerMode:".concat(String.valueOf(m9039g)));
        this.f27984a.e();
        if (!m9039g) {
            this.f27984a.a(true);
            return;
        }
        XMPushService xMPushService = this.f27984a;
        xMPushService.a(new XMPushService.g(24, null));
    }
}
