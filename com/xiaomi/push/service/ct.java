package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ct.class */
public class ct implements u.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService.j f27986a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1002a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(XMPushService xMPushService, XMPushService.j jVar) {
        this.f1002a = xMPushService;
        this.f27986a = jVar;
    }

    @Override // com.xiaomi.push.service.u.a
    public void a() {
        this.f1002a.a(this.f27986a);
    }
}
