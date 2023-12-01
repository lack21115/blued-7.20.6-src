package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.dw;
import com.xiaomi.push.eb;
import com.xiaomi.push.ef;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.ht;
import com.xiaomi.push.service.bd;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/c.class */
public class c implements ef {
    @Override // com.xiaomi.push.ef
    public void a(Context context, HashMap<String, String> hashMap) {
        Cif cif = new Cif();
        cif.b(eb.a(context).m8661a());
        cif.d(eb.a(context).b());
        cif.c(hq.AwakeAppResponse.f536a);
        cif.a(bd.a());
        cif.f678a = hashMap;
        ao.a(context).a((ao) cif, hg.Notification, true, (ht) null, true);
        com.xiaomi.channel.commonutils.logger.b.m8344a("MoleInfo：\u3000send data in app layer");
    }

    @Override // com.xiaomi.push.ef
    public void b(Context context, HashMap<String, String> hashMap) {
        MiTinyDataClient.upload("category_awake_app", "wake_up_app", 1L, dw.a(hashMap));
        com.xiaomi.channel.commonutils.logger.b.m8344a("MoleInfo：\u3000send data in app layer");
    }

    @Override // com.xiaomi.push.ef
    public void c(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.channel.commonutils.logger.b.m8344a("MoleInfo：\u3000" + dw.b(hashMap));
        String str = hashMap.get("event_type");
        String str2 = hashMap.get("awake_info");
        if ("1007".equals(str)) {
            o.a(context, str2);
        }
    }
}
