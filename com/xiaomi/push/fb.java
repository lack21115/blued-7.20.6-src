package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fb.class */
class fb extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fa f27707a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fb(fa faVar, int i) {
        super(i);
        this.f27707a = faVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo9052a() {
        return "Handling bind stats";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void mo8693a() {
        this.f27707a.c();
    }
}
