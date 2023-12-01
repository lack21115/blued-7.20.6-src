package com.xiaomi.push.service;

import com.xiaomi.push.fj;
import com.xiaomi.push.gf;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/c.class */
public class c extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    private XMPushService f27968a;

    /* renamed from: a  reason: collision with other field name */
    private fj[] f993a;

    public c(XMPushService xMPushService, fj[] fjVarArr) {
        super(4);
        this.f27968a = null;
        this.f27968a = xMPushService;
        this.f993a = fjVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo9052a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo8693a() {
        try {
            if (this.f993a != null) {
                this.f27968a.a(this.f993a);
            }
        } catch (gf e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f27968a.a(10, e);
        }
    }
}
