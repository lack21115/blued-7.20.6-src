package com.xiaomi.push.service;

import com.xiaomi.push.Cif;
import com.xiaomi.push.ai;
import com.xiaomi.push.hg;
import com.xiaomi.push.iq;
import java.lang.ref.WeakReference;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/b.class */
public class b extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private Cif f41624a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<XMPushService> f995a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f996a;

    public b(Cif cif, WeakReference<XMPushService> weakReference, boolean z) {
        this.f996a = false;
        this.f41624a = cif;
        this.f995a = weakReference;
        this.f996a = z;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo11550a() {
        return "22";
    }

    @Override // java.lang.Runnable
    public void run() {
        XMPushService xMPushService;
        WeakReference<XMPushService> weakReference = this.f995a;
        if (weakReference == null || this.f41624a == null || (xMPushService = weakReference.get()) == null) {
            return;
        }
        this.f41624a.a(bd.a());
        this.f41624a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.f41624a.m11963a());
        try {
            String c2 = this.f41624a.c();
            xMPushService.a(c2, iq.a(ah.a(c2, this.f41624a.b(), this.f41624a, hg.Notification)), this.f996a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
        }
    }
}
