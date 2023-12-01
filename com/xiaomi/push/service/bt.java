package com.xiaomi.push.service;

import com.xiaomi.push.fj;
import com.xiaomi.push.gf;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bt.class */
public class bt extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    private fj f41651a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f1026a;

    public bt(XMPushService xMPushService, fj fjVar) {
        super(4);
        this.f1026a = null;
        this.f1026a = xMPushService;
        this.f41651a = fjVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo12102a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo11743a() {
        try {
            if (this.f41651a != null) {
                this.f1026a.a(this.f41651a);
                if (this.f41651a.f450a != null) {
                    this.f41651a.f450a.d = System.currentTimeMillis();
                    ao.a(this.f1026a, "coord_up", this.f41651a.f450a);
                }
            }
        } catch (gf e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f1026a.a(10, e);
        }
    }
}
