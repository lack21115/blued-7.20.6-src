package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gf;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.XMPushService;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/aa.class */
final class aa extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ic f41592a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f953a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(int i, XMPushService xMPushService, ic icVar) {
        super(i);
        this.f953a = xMPushService;
        this.f41592a = icVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final String mo12102a() {
        return "send ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final void mo11743a() {
        try {
            Map<String, String> map = null;
            if (com.xiaomi.push.j.m12048a((Context) this.f953a)) {
                try {
                    map = ag.a((Context) this.f953a, this.f41592a);
                } catch (Throwable th) {
                    map = null;
                }
            }
            ah.a(this.f953a, y.a(this.f953a, this.f41592a, map));
        } catch (gf e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f953a.a(10, e);
        }
    }
}
