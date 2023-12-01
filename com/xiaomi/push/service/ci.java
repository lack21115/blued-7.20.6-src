package com.xiaomi.push.service;

import com.xiaomi.push.fj;
import com.xiaomi.push.fz;
import com.xiaomi.push.gl;
import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ci.class */
class ci implements fz {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f27975a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(XMPushService xMPushService) {
        this.f27975a = xMPushService;
    }

    @Override // com.xiaomi.push.fz
    public void a(fj fjVar) {
        XMPushService xMPushService = this.f27975a;
        xMPushService.a(new XMPushService.d(fjVar));
    }

    @Override // com.xiaomi.push.fz
    public void a(gl glVar) {
        XMPushService xMPushService = this.f27975a;
        xMPushService.a(new XMPushService.m(glVar));
    }
}
