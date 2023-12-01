package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fa.class */
public class fa implements bg.b.a {

    /* renamed from: a  reason: collision with root package name */
    private int f41397a;

    /* renamed from: a  reason: collision with other field name */
    private fu f430a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f431a;

    /* renamed from: a  reason: collision with other field name */
    private bg.b f432a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f434a = false;

    /* renamed from: a  reason: collision with other field name */
    private bg.c f433a = bg.c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fa(XMPushService xMPushService, bg.b bVar) {
        this.f431a = xMPushService;
        this.f432a = bVar;
    }

    private void b() {
        this.f432a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00ca -> B:28:0x00be). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.fa.c():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f432a.a(this);
        this.f430a = this.f431a.m12092a();
    }

    @Override // com.xiaomi.push.service.bg.b.a
    public void a(bg.c cVar, bg.c cVar2, int i) {
        if (!this.f434a && cVar == bg.c.binding) {
            this.f433a = cVar2;
            this.f41397a = i;
            this.f434a = true;
        }
        this.f431a.a(new fb(this, 4));
    }
}
