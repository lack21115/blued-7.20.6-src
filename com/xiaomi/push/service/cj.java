package com.xiaomi.push.service;

import com.xiaomi.push.gf;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/cj.class */
public class cj extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f27976a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f1000a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f1001a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cj(XMPushService xMPushService, int i, String str, byte[] bArr) {
        super(i);
        this.f27976a = xMPushService;
        this.f1000a = str;
        this.f1001a = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo9052a() {
        return "send mi push message";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo8693a() {
        try {
            ah.a(this.f27976a, this.f1000a, this.f1001a);
        } catch (gf e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f27976a.a(10, e);
        }
    }
}
