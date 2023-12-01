package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.dw;
import com.xiaomi.push.eb;
import com.xiaomi.push.ef;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.iq;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bm.class */
public class bm implements ef {
    @Override // com.xiaomi.push.ef
    public void a(Context context, HashMap<String, String> hashMap) {
        Cif cif = new Cif();
        cif.b(eb.a(context).m11711a());
        cif.d(eb.a(context).b());
        cif.c(hq.AwakeAppResponse.f583a);
        cif.a(bd.a());
        cif.f725a = hashMap;
        byte[] a2 = iq.a(ah.a(cif.c(), cif.b(), cif, hg.Notification));
        if (!(context instanceof XMPushService)) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("MoleInfo : context is not correct in pushLayer " + cif.m11963a());
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m11394a("MoleInfo : send data directly in pushLayer " + cif.m11963a());
        ((XMPushService) context).a(context.getPackageName(), a2, true);
    }

    @Override // com.xiaomi.push.ef
    public void b(Context context, HashMap<String, String> hashMap) {
        he a2 = he.a(context);
        if (a2 != null) {
            a2.a("category_awake_app", "wake_up_app", 1L, dw.a(hashMap));
        }
    }

    @Override // com.xiaomi.push.ef
    public void c(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.channel.commonutils.logger.b.m11394a("MoleInfo：\u3000" + dw.b(hashMap));
    }
}
