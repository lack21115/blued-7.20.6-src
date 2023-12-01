package com.xiaomi.push.service;

import com.xiaomi.push.fj;
import com.xiaomi.push.gf;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bt.class */
public class bt extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    private fj f27960a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f979a;

    public bt(XMPushService xMPushService, fj fjVar) {
        super(4);
        this.f979a = null;
        this.f979a = xMPushService;
        this.f27960a = fjVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo9052a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo8693a() {
        try {
            if (this.f27960a != null) {
                this.f979a.a(this.f27960a);
                if (this.f27960a.f403a != null) {
                    this.f27960a.f403a.d = System.currentTimeMillis();
                    ao.a(this.f979a, "coord_up", this.f27960a.f403a);
                }
            }
        } catch (gf e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f979a.a(10, e);
        }
    }
}
