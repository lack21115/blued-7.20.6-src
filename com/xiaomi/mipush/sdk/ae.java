package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ai;
import com.xiaomi.push.hg;
import com.xiaomi.push.hm;
import com.xiaomi.push.hq;
import com.xiaomi.push.ht;
import com.xiaomi.push.hy;
import com.xiaomi.push.iq;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bb;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/ae.class */
public class ae extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f41199a;

    public ae(Context context) {
        this.f41199a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo11550a() {
        return "2";
    }

    @Override // java.lang.Runnable
    public void run() {
        ba a2 = ba.a(this.f41199a);
        hy hyVar = new hy();
        hyVar.a(bb.a(a2, hm.MISC_CONFIG));
        hyVar.b(bb.a(a2, hm.PLUGIN_CONFIG));
        Cif cif = new Cif("-1", false);
        cif.c(hq.DailyCheckClientConfig.f583a);
        cif.a(iq.a(hyVar));
        ao.a(this.f41199a).a((ao) cif, hg.Notification, (ht) null);
    }
}
