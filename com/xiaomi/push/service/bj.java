package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bj.class */
class bj extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg.b.c f27949a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj(bg.b.c cVar, int i) {
        super(i);
        this.f27949a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo9052a() {
        return "check peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo8693a() {
        if (bg.a().a(this.f27949a.f970a.g, this.f27949a.f970a.f966b).f957a == null) {
            bg.b.this.f959a.a(this.f27949a.f970a.g, this.f27949a.f970a.f966b, 2, null, null);
        }
    }
}
