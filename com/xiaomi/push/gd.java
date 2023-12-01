package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gd.class */
class gd extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ gb f41433a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Exception f506a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gd(gb gbVar, int i, int i2, Exception exc) {
        super(i);
        this.f41433a = gbVar;
        this.b = i2;
        this.f506a = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo12102a() {
        return "shutdown the connection. " + this.b + ", " + this.f506a;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo11743a() {
        this.f41433a.b.a(this.b, this.f506a);
    }
}
