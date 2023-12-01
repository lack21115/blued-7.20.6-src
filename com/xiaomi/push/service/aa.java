package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gf;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.XMPushService;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/aa.class */
final class aa extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ic f27901a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f906a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(int i, XMPushService xMPushService, ic icVar) {
        super(i);
        this.f906a = xMPushService;
        this.f27901a = icVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final String mo9052a() {
        return "send ack message for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public final void mo8693a() {
        try {
            Map<String, String> map = null;
            if (com.xiaomi.push.j.m8998a((Context) this.f906a)) {
                try {
                    map = ag.a((Context) this.f906a, this.f27901a);
                } catch (Throwable th) {
                    map = null;
                }
            }
            ah.a(this.f906a, y.a(this.f906a, this.f27901a, map));
        } catch (gf e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f906a.a(10, e);
        }
    }
}
