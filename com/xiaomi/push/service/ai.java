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
    final /* synthetic */ XMPushService f41599a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ t f963a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(String str, long j, XMPushService xMPushService, t tVar) {
        super(str, j);
        this.f41599a = xMPushService;
        this.f963a = tVar;
    }

    @Override // com.xiaomi.push.service.bx.a
    final void a(bx bxVar) {
        com.xiaomi.push.ay a2 = com.xiaomi.push.ay.a(this.f41599a);
        String a3 = bxVar.a("MSAID", "msaid");
        String mo11508a = a2.mo11508a();
        if (TextUtils.isEmpty(mo11508a) || TextUtils.equals(a3, mo11508a)) {
            return;
        }
        bxVar.a("MSAID", "msaid", mo11508a);
        Cif cif = new Cif();
        cif.b(this.f963a.d);
        cif.c(hq.ClientInfoUpdate.f583a);
        cif.a(bd.a());
        cif.a(new HashMap());
        a2.a(cif.m11964a());
        byte[] a4 = iq.a(ah.a(this.f41599a.getPackageName(), this.f963a.d, cif, hg.Notification));
        XMPushService xMPushService = this.f41599a;
        xMPushService.a(xMPushService.getPackageName(), a4, true);
    }
}
