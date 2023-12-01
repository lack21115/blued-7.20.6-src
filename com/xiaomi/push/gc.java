package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gc.class */
class gc extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f27741a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ gb f458a;
    final /* synthetic */ long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gc(gb gbVar, int i, long j, long j2) {
        super(i);
        this.f458a = gbVar;
        this.f27741a = j;
        this.b = j2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo9052a() {
        return "check the ping-pong." + this.b;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo8693a() {
        Thread.yield();
        if (!this.f458a.c() || this.f458a.a(this.f27741a)) {
            return;
        }
        com.xiaomi.push.service.o.a(this.f458a.b).m9144b();
        this.f458a.b.a(22, (Exception) null);
    }
}
