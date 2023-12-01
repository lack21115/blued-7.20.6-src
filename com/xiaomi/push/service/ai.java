package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.iq;
import com.xiaomi.push.service.bx;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ai.class */
public final class ai extends bx.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f27908a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ t f916a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(String str, long j, XMPushService xMPushService, t tVar) {
        super(str, j);
        this.f27908a = xMPushService;
        this.f916a = tVar;
    }

    @Override // com.xiaomi.push.service.bx.a
    final void a(bx bxVar) {
        com.xiaomi.push.ay a2 = com.xiaomi.push.ay.a(this.f27908a);
        String a3 = bxVar.a("MSAID", "msaid");
        String mo8458a = a2.mo8458a();
        if (TextUtils.isEmpty(mo8458a) || TextUtils.equals(a3, mo8458a)) {
            return;
        }
        bxVar.a("MSAID", "msaid", mo8458a);
        Cif cif = new Cif();
        cif.b(this.f916a.d);
        cif.c(hq.ClientInfoUpdate.f536a);
        cif.a(bd.a());
        cif.a(new HashMap());
        a2.a(cif.m8914a());
        byte[] a4 = iq.a(ah.a(this.f27908a.getPackageName(), this.f916a.d, cif, hg.Notification));
        XMPushService xMPushService = this.f27908a;
        xMPushService.a(xMPushService.getPackageName(), a4, true);
    }
}
