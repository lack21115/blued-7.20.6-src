package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.dv;
import com.xiaomi.push.service.bg;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fi.class */
class fi {
    public static void a(bg.b bVar, String str, fu fuVar) {
        String a2;
        dv.c cVar = new dv.c();
        if (!TextUtils.isEmpty(bVar.f27941c)) {
            cVar.a(bVar.f27941c);
        }
        if (!TextUtils.isEmpty(bVar.e)) {
            cVar.d(bVar.e);
        }
        if (!TextUtils.isEmpty(bVar.f)) {
            cVar.e(bVar.f);
        }
        cVar.b(bVar.f965a ? "1" : "0");
        if (TextUtils.isEmpty(bVar.d)) {
            cVar.c("XIAOMI-SASL");
        } else {
            cVar.c(bVar.d);
        }
        fj fjVar = new fj();
        fjVar.c(bVar.f966b);
        fjVar.a(Integer.parseInt(bVar.g));
        fjVar.b(bVar.f963a);
        fjVar.a("BIND", (String) null);
        fjVar.a(fjVar.e());
        com.xiaomi.channel.commonutils.logger.b.m8344a("[Slim]: bind id=" + fjVar.e());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.f27941c);
        hashMap.put("chid", bVar.g);
        hashMap.put("from", bVar.f966b);
        hashMap.put("id", fjVar.e());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f965a) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (TextUtils.isEmpty(bVar.e)) {
            hashMap.put("client_attrs", "");
        } else {
            hashMap.put("client_attrs", bVar.e);
        }
        if (TextUtils.isEmpty(bVar.f)) {
            hashMap.put("cloud_attrs", "");
        } else {
            hashMap.put("cloud_attrs", bVar.f);
        }
        if (bVar.d.equals("XIAOMI-PASS") || bVar.d.equals("XMPUSH-PASS")) {
            a2 = bl.a(bVar.d, null, hashMap, bVar.h);
        } else {
            bVar.d.equals("XIAOMI-SASL");
            a2 = null;
        }
        cVar.f(a2);
        fjVar.a(cVar.a(), (String) null);
        fuVar.b(fjVar);
    }

    public static void a(String str, String str2, fu fuVar) {
        fj fjVar = new fj();
        fjVar.c(str2);
        fjVar.a(Integer.parseInt(str));
        fjVar.a("UBND", (String) null);
        fuVar.b(fjVar);
    }
}
