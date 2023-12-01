package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bi.class */
class bi extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg.b.c f27948a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(bg.b.c cVar, int i) {
        super(i);
        this.f27948a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo9052a() {
        return "clear peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo8693a() {
        if (this.f27948a.f27944a == this.f27948a.f970a.f957a) {
            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + this.f27948a.f970a.g);
            this.f27948a.f970a.f957a = null;
        }
    }
}
