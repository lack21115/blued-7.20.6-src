package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ct.class */
public class ct implements u.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService.j f41677a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1049a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(XMPushService xMPushService, XMPushService.j jVar) {
        this.f1049a = xMPushService;
        this.f41677a = jVar;
    }

    @Override // com.xiaomi.push.service.u.a
    public void a() {
        this.f1049a.a(this.f41677a);
    }
}
