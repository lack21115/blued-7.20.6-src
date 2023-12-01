package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gc.class */
class gc extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f41432a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ gb f505a;
    final /* synthetic */ long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gc(gb gbVar, int i, long j, long j2) {
        super(i);
        this.f505a = gbVar;
        this.f41432a = j;
        this.b = j2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo12102a() {
        return "check the ping-pong." + this.b;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo11743a() {
        Thread.yield();
        if (!this.f505a.c() || this.f505a.a(this.f41432a)) {
            return;
        }
        com.xiaomi.push.service.o.a(this.f505a.b).m12194b();
        this.f505a.b.a(22, (Exception) null);
    }
}
