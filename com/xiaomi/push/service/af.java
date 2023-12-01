package com.xiaomi.push.service;

import com.xiaomi.push.Cif;
import com.xiaomi.push.gf;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.hx;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/af.class */
final class af extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ic f27906a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Cif f913a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f914a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(int i, Cif cif, ic icVar, XMPushService xMPushService) {
        super(i);
        this.f913a = cif;
        this.f27906a = icVar;
        this.f914a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final String mo9052a() {
        return "send ack message for clear push message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final void mo8693a() {
        try {
            hx hxVar = new hx();
            hxVar.c(hq.CancelPushMessageACK.f536a);
            hxVar.a(this.f913a.m8913a());
            hxVar.a(this.f913a.a());
            hxVar.b(this.f913a.b());
            hxVar.e(this.f913a.c());
            hxVar.a(0L);
            hxVar.d("success clear push message.");
            ah.a(this.f914a, ah.b(this.f27906a.b(), this.f27906a.m8896a(), hxVar, hg.Notification));
        } catch (gf e) {
            com.xiaomi.channel.commonutils.logger.b.d("clear push message. ".concat(String.valueOf(e)));
            this.f914a.a(10, e);
        }
    }
}
