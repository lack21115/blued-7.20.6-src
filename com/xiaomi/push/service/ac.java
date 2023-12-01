package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gf;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ac.class */
final class ac extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ic f41594a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f955a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(int i, XMPushService xMPushService, ic icVar) {
        super(i);
        this.f955a = xMPushService;
        this.f41594a = icVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final String mo12102a() {
        return "send ack message for unrecognized new miui message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final void mo11743a() {
        try {
            ic a2 = y.a((Context) this.f955a, this.f41594a);
            a2.m11945a().a("miui_message_unrecognized", "1");
            ah.a(this.f955a, a2);
        } catch (gf e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f955a.a(10, e);
        }
    }
}
