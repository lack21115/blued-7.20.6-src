package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fv;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/cu.class */
public class cu extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f27987a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f1003a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f1004a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu(XMPushService xMPushService, int i, int i2, String str, byte[] bArr) {
        super(i);
        this.f27987a = xMPushService;
        this.b = i2;
        this.f1003a = str;
        this.f1004a = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo9052a() {
        return "clear account cache.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo8693a() {
        fv fvVar;
        u.m9162a((Context) this.f27987a);
        bg.a().m9103a("5");
        com.xiaomi.push.aa.a(this.b);
        fvVar = this.f27987a.f875a;
        fvVar.c(fv.a());
        com.xiaomi.channel.commonutils.logger.b.m8344a("clear account and start registration. " + this.f1003a);
        this.f27987a.a(this.f1004a, this.f1003a);
    }
}
