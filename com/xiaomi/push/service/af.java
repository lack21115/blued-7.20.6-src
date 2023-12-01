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
    final /* synthetic */ ic f41597a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Cif f960a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f961a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(int i, Cif cif, ic icVar, XMPushService xMPushService) {
        super(i);
        this.f960a = cif;
        this.f41597a = icVar;
        this.f961a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final String mo12102a() {
        return "send ack message for clear push message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final void mo11743a() {
        try {
            hx hxVar = new hx();
            hxVar.c(hq.CancelPushMessageACK.f583a);
            hxVar.a(this.f960a.m11963a());
            hxVar.a(this.f960a.a());
            hxVar.b(this.f960a.b());
            hxVar.e(this.f960a.c());
            hxVar.a(0L);
            hxVar.d("success clear push message.");
            ah.a(this.f961a, ah.b(this.f41597a.b(), this.f41597a.m11946a(), hxVar, hg.Notification));
        } catch (gf e) {
            com.xiaomi.channel.commonutils.logger.b.d("clear push message. ".concat(String.valueOf(e)));
            this.f961a.a(10, e);
        }
    }
}
