package com.xiaomi.push.service;

import com.xiaomi.push.fj;
import com.xiaomi.push.gf;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/c.class */
public class c extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    private XMPushService f41659a;

    /* renamed from: a  reason: collision with other field name */
    private fj[] f1040a;

    public c(XMPushService xMPushService, fj[] fjVarArr) {
        super(4);
        this.f41659a = null;
        this.f41659a = xMPushService;
        this.f1040a = fjVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo12102a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo11743a() {
        try {
            if (this.f1040a != null) {
                this.f41659a.a(this.f1040a);
            }
        } catch (gf e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f41659a.a(10, e);
        }
    }
}
