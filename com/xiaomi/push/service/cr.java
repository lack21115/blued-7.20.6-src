package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/cr.class */
class cr extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f41675a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cr(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f41675a = xMPushService;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        boolean m12089g;
        super.onChange(z);
        m12089g = this.f41675a.m12089g();
        com.xiaomi.channel.commonutils.logger.b.m11394a("SuperPowerMode:".concat(String.valueOf(m12089g)));
        this.f41675a.e();
        if (!m12089g) {
            this.f41675a.a(true);
            return;
        }
        XMPushService xMPushService = this.f41675a;
        xMPushService.a(new XMPushService.g(24, null));
    }
}
