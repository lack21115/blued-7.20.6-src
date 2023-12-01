package com.xiaomi.push.service;

import com.xiaomi.push.dv;
import com.xiaomi.push.fv;
import com.xiaomi.push.fy;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/cp.class */
class cp extends fv {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f27982a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp(XMPushService xMPushService, Map map, int i, String str, fy fyVar) {
        super(map, i, str, fyVar);
        this.f27982a = xMPushService;
    }

    @Override // com.xiaomi.push.fv
    /* renamed from: a */
    public byte[] mo8744a() {
        try {
            dv.b bVar = new dv.b();
            bVar.a(bv.a().m9121a());
            return bVar.a();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("getOBBString err: " + e.toString());
            return null;
        }
    }
}
