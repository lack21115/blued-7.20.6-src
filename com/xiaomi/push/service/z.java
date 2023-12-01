package com.xiaomi.push.service;

import com.xiaomi.push.gf;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/z.class */
final class z extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ic f41709a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1087a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(int i, XMPushService xMPushService, ic icVar) {
        super(i);
        this.f1087a = xMPushService;
        this.f41709a = icVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final String mo12102a() {
        return "send app absent message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final void mo11743a() {
        try {
            ah.a(this.f1087a, ah.a(this.f41709a.b(), this.f41709a.m11946a()));
        } catch (gf e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f1087a.a(10, e);
        }
    }
}
