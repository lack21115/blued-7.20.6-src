package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fv;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/cu.class */
public class cu extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f41678a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f1050a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f1051a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu(XMPushService xMPushService, int i, int i2, String str, byte[] bArr) {
        super(i);
        this.f41678a = xMPushService;
        this.b = i2;
        this.f1050a = str;
        this.f1051a = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo12102a() {
        return "clear account cache.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo11743a() {
        fv fvVar;
        u.m12212a((Context) this.f41678a);
        bg.a().m12153a("5");
        com.xiaomi.push.aa.a(this.b);
        fvVar = this.f41678a.f922a;
        fvVar.c(fv.a());
        com.xiaomi.channel.commonutils.logger.b.m11394a("clear account and start registration. " + this.f1050a);
        this.f41678a.a(this.f1051a, this.f1050a);
    }
}
