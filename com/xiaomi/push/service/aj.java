package com.xiaomi.push.service;

import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.bg;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/aj.class */
public final class aj implements bg.b.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f27909a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(XMPushService xMPushService) {
        this.f27909a = xMPushService;
    }

    @Override // com.xiaomi.push.service.bg.b.a
    public final void a(bg.c cVar, bg.c cVar2, int i) {
        if (cVar2 == bg.c.binded) {
            x.a(this.f27909a, true);
            x.a(this.f27909a);
        } else if (cVar2 == bg.c.unbind) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("onChange unbind");
            x.a(this.f27909a, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
        }
    }
}
