package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gf;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ad.class */
final class ad extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ic f41595a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f956a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f957a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(int i, XMPushService xMPushService, ic icVar, String str) {
        super(i);
        this.f956a = xMPushService;
        this.f41595a = icVar;
        this.f957a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final String mo12102a() {
        return "send app absent ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final void mo11743a() {
        try {
            ic a2 = y.a((Context) this.f956a, this.f41595a);
            a2.m11945a().a("absent_target_package", this.f957a);
            ah.a(this.f956a, a2);
        } catch (gf e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f956a.a(10, e);
        }
    }
}
