package com.xiaomi.push.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hq;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/cg.class */
public class cg implements XMPushService.n {

    /* renamed from: a  reason: collision with root package name */
    private static Context f41664a;

    /* renamed from: a  reason: collision with other field name */
    private static final boolean f1046a = Log.isLoggable("UNDatas", 3);

    /* renamed from: a  reason: collision with other field name */
    private static final Map<Integer, Map<String, List<String>>> f1045a = new HashMap();

    public cg(Context context) {
        f41664a = context;
    }

    private static Cif a(String str, String str2, String str3, String str4) {
        Cif cif = new Cif();
        if (str3 != null) {
            cif.c(str3);
        }
        if (str != null) {
            cif.b(str);
        }
        if (str2 != null) {
            cif.a(str2);
        }
        if (str4 != null) {
            cif.d(str4);
        }
        cif.a(false);
        return cif;
    }

    private static void a(Context context, Cif cif) {
        if (f1046a) {
            com.xiaomi.channel.commonutils.logger.b.b("UNDatas upload message notification:".concat(String.valueOf(cif)));
        }
        com.xiaomi.push.ai.a(context).a(new ch(cif));
    }

    private static void b() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(f1045a);
        if (hashMap.size() > 0) {
            for (Integer num : hashMap.keySet()) {
                Map map = (Map) hashMap.get(num);
                if (map != null && map.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : map.keySet()) {
                        sb.append(str);
                        sb.append(":");
                        List list = (List) map.get(str);
                        if (!com.xiaomi.push.s.a(list)) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 < list.size()) {
                                    if (i2 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append((String) list.get(i2));
                                    i = i2 + 1;
                                }
                            }
                        }
                        sb.append(";");
                    }
                    Cif a2 = a(null, bd.a(), hq.NotificationRemoved.f583a, null);
                    a2.a("removed_reason", String.valueOf(num));
                    a2.a("all_delete_msgId_appId", sb.toString());
                    com.xiaomi.channel.commonutils.logger.b.b("UNDatas upload all removed messages reason: " + num + " allIds: " + sb.toString());
                    a(f41664a, a2);
                }
                f1045a.remove(num);
            }
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* renamed from: a */
    public void mo11843a() {
        if (f1045a.size() > 0) {
            synchronized (f1045a) {
                b();
            }
        }
    }
}
