package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bi.class */
class bi extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg.b.c f41639a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(bg.b.c cVar, int i) {
        super(i);
        this.f41639a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo12102a() {
        return "clear peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo11743a() {
        if (this.f41639a.f41635a == this.f41639a.f1017a.f1004a) {
            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + this.f41639a.f1017a.g);
            this.f41639a.f1017a.f1004a = null;
        }
    }
}
