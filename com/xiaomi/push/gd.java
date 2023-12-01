package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gd.class */
class gd extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ gb f27742a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Exception f459a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gd(gb gbVar, int i, int i2, Exception exc) {
        super(i);
        this.f27742a = gbVar;
        this.b = i2;
        this.f459a = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo9052a() {
        return "shutdown the connection. " + this.b + ", " + this.f459a;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo8693a() {
        this.f27742a.b.a(this.b, this.f459a);
    }
}
