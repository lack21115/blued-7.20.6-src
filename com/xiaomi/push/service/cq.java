package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/cq.class */
class cq implements bg.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f41674a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(XMPushService xMPushService) {
        this.f41674a = xMPushService;
    }

    @Override // com.xiaomi.push.service.bg.a
    public void a() {
        this.f41674a.e();
        if (bg.a().m12148a() <= 0) {
            XMPushService xMPushService = this.f41674a;
            xMPushService.a(new XMPushService.g(12, null));
        }
    }
}
