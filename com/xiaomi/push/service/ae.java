package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gf;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ae.class */
final class ae extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ic f27905a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f911a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f912a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(int i, XMPushService xMPushService, ic icVar, String str, String str2) {
        super(i);
        this.f911a = xMPushService;
        this.f27905a = icVar;
        this.f912a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final String mo9052a() {
        return "send wrong message ack for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final void mo8693a() {
        try {
            ic a2 = y.a((Context) this.f911a, this.f27905a);
            a2.f660a.a("error", this.f912a);
            a2.f660a.a("reason", this.b);
            ah.a(this.f911a, a2);
        } catch (gf e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f911a.a(10, e);
        }
    }
}
