package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bj.class */
class bj extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg.b.c f41640a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj(bg.b.c cVar, int i) {
        super(i);
        this.f41640a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo12102a() {
        return "check peer job";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo11743a() {
        if (bg.a().a(this.f41640a.f1017a.g, this.f41640a.f1017a.f1013b).f1004a == null) {
            bg.b.this.f1006a.a(this.f41640a.f1017a.g, this.f41640a.f1017a.f1013b, 2, null, null);
        }
    }
}
