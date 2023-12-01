package com.xiaomi.push.service;

import com.xiaomi.push.gf;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/z.class */
final class z extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ic f28018a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1040a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(int i, XMPushService xMPushService, ic icVar) {
        super(i);
        this.f1040a = xMPushService;
        this.f28018a = icVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final String mo9052a() {
        return "send app absent message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final void mo8693a() {
        try {
            ah.a(this.f1040a, ah.a(this.f28018a.b(), this.f28018a.m8896a()));
        } catch (gf e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f1040a.a(10, e);
        }
    }
}
