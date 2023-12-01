package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fb.class */
class fb extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fa f41398a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fb(fa faVar, int i) {
        super(i);
        this.f41398a = faVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo12102a() {
        return "Handling bind stats";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a  reason: collision with other method in class */
    public void mo11743a() {
        this.f41398a.c();
    }
}
