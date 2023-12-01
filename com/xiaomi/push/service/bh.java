package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bh.class */
public class bh implements bg.b.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg.b f27947a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg.b bVar) {
        this.f27947a = bVar;
    }

    @Override // com.xiaomi.push.service.bg.b.a
    public void a(bg.c cVar, bg.c cVar2, int i) {
        XMPushService.c cVar3;
        XMPushService.c cVar4;
        if (cVar2 == bg.c.binding) {
            XMPushService xMPushService = this.f27947a.f959a;
            cVar4 = this.f27947a.f958a;
            xMPushService.a(cVar4, 60000L);
            return;
        }
        XMPushService xMPushService2 = this.f27947a.f959a;
        cVar3 = this.f27947a.f958a;
        xMPushService2.b(cVar3);
    }
}
