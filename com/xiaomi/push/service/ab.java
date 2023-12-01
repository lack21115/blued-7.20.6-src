package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gf;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ab.class */
final class ab extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ic f27902a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f907a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(int i, XMPushService xMPushService, ic icVar) {
        super(i);
        this.f907a = xMPushService;
        this.f27902a = icVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final String mo9052a() {
        return "send ack message for obsleted message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final void mo8693a() {
        try {
            ic a2 = y.a((Context) this.f907a, this.f27902a);
            a2.m8895a().a("message_obsleted", "1");
            ah.a(this.f907a, a2);
        } catch (gf e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f907a.a(10, e);
        }
    }
}
