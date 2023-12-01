package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.hk;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ao.class */
public class ao {

    /* renamed from: a  reason: collision with root package name */
    private static int f41609a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static long f979a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static Boolean f980a;

    private static void a(Context context, String str, String str2, an anVar) {
        if (context == null || anVar == null) {
            return;
        }
        hk hkVar = new hk();
        hkVar.d(str);
        hkVar.c(str2);
        hkVar.g("com.xiaomi.xmsf");
        hkVar.e("com.xiaomi.xmsf");
        HashMap hashMap = new HashMap();
        hashMap.put("chid", String.valueOf(anVar.f41607a));
        hashMap.put(com.umeng.ccg.a.f, String.valueOf(anVar.f976a));
        hashMap.put("wifi", String.valueOf(anVar.f978b));
        hashMap.put("rx_msg", String.valueOf(anVar.f975a));
        hashMap.put("enqueue", String.valueOf(anVar.f977b));
        hashMap.put(com.anythink.expressad.foundation.d.l.d, String.valueOf(anVar.b));
        hashMap.put("run", String.valueOf(anVar.f41608c));
        hashMap.put("send", String.valueOf(anVar.d));
        hkVar.a(hashMap);
        ca.a(context, hkVar);
    }

    private static boolean a() {
        int a2 = com.xiaomi.push.ad.a();
        return a2 >= 8 && a2 <= 24 && (((a2 - 8) + 1) * 3) - f41609a > 0;
    }

    private static boolean a(Context context) {
        String m12211a = u.m12211a(context);
        return !TextUtils.isEmpty(m12211a) && m12211a.length() >= 3 && com.xiaomi.push.s.a(m12211a.substring(m12211a.length() - 3), 1) <= 0;
    }

    public static boolean a(Context context, String str, an anVar) {
        String str2;
        String str3;
        if (context == null || anVar == null) {
            return false;
        }
        if (f980a == null) {
            f980a = Boolean.valueOf(a(context));
        }
        if (f980a.booleanValue()) {
            long b = com.xiaomi.push.ad.b();
            if (b - f979a >= 1) {
                f41609a = 0;
                f979a = b;
            }
            if (a()) {
                if (!str.equals("coord_down")) {
                    if (str.equals("coord_up")) {
                        str2 = "coord_up";
                        str3 = "category_coord_up";
                    }
                    f41609a++;
                    return true;
                }
                str3 = "category_coord_down";
                str2 = "coord_down";
                a(context, str3, str2, anVar);
                f41609a++;
                return true;
            }
            return false;
        }
        return false;
    }
}
