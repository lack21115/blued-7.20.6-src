package com.xiaomi.push.service;

import com.xiaomi.push.Cif;
import com.xiaomi.push.ai;
import com.xiaomi.push.hg;
import com.xiaomi.push.iq;
import java.lang.ref.WeakReference;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/b.class */
public class b extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private Cif f27933a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<XMPushService> f948a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f949a;

    public b(Cif cif, WeakReference<XMPushService> weakReference, boolean z) {
        this.f949a = false;
        this.f27933a = cif;
        this.f948a = weakReference;
        this.f949a = z;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo8500a() {
        return "22";
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        WeakReference<XMPushService> weakReference = this.f948a;
        if (weakReference == null || this.f27933a == null || (xMPushService = weakReference.get()) == null) {
            return;
        }
        this.f27933a.a(bd.a());
        this.f27933a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.f27933a.m8913a());
        try {
            String c2 = this.f27933a.c();
            xMPushService.a(c2, iq.a(ah.a(c2, this.f27933a.b(), this.f27933a, hg.Notification)), this.f949a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
        }
    }
}
