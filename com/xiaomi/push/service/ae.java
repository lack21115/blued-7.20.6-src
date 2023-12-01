package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gf;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ae.class */
final class ae extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ic f41596a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f958a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f959a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(int i, XMPushService xMPushService, ic icVar, String str, String str2) {
        super(i);
        this.f958a = xMPushService;
        this.f41596a = icVar;
        this.f959a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final String mo12102a() {
        return "send wrong message ack for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final void mo11743a() {
        try {
            ic a2 = y.a((Context) this.f958a, this.f41596a);
            a2.f707a.a("error", this.f959a);
            a2.f707a.a("reason", this.b);
            ah.a(this.f958a, a2);
        } catch (gf e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f958a.a(10, e);
        }
    }
}
