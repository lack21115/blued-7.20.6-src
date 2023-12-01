package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.hk;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ao.class */
public class ao {

    /* renamed from: a  reason: collision with root package name */
    private static int f27918a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static long f932a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static Boolean f933a;

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
        hashMap.put("chid", String.valueOf(anVar.f27916a));
        hashMap.put(com.umeng.ccg.a.f, String.valueOf(anVar.f929a));
        hashMap.put("wifi", String.valueOf(anVar.f931b));
        hashMap.put("rx_msg", String.valueOf(anVar.f928a));
        hashMap.put("enqueue", String.valueOf(anVar.f930b));
        hashMap.put(com.anythink.expressad.foundation.d.l.d, String.valueOf(anVar.b));
        hashMap.put("run", String.valueOf(anVar.f27917c));
        hashMap.put("send", String.valueOf(anVar.d));
        hkVar.a(hashMap);
        ca.a(context, hkVar);
    }

    private static boolean a() {
        int a2 = com.xiaomi.push.ad.a();
        return a2 >= 8 && a2 <= 24 && (((a2 - 8) + 1) * 3) - f27918a > 0;
    }

    private static boolean a(Context context) {
        String m9161a = u.m9161a(context);
        return !TextUtils.isEmpty(m9161a) && m9161a.length() >= 3 && com.xiaomi.push.s.a(m9161a.substring(m9161a.length() - 3), 1) <= 0;
    }

    public static boolean a(Context context, String str, an anVar) {
        String str2;
        String str3;
        if (context == null || anVar == null) {
            return false;
        }
        if (f933a == null) {
            f933a = Boolean.valueOf(a(context));
        }
        if (f933a.booleanValue()) {
            long b = com.xiaomi.push.ad.b();
            if (b - f932a >= 1) {
                f27918a = 0;
                f932a = b;
            }
            if (a()) {
                if (!str.equals("coord_down")) {
                    if (str.equals("coord_up")) {
                        str2 = "coord_up";
                        str3 = "category_coord_up";
                    }
                    f27918a++;
                    return true;
                }
                str3 = "category_coord_down";
                str2 = "coord_down";
                a(context, str3, str2, anVar);
                f27918a++;
                return true;
            }
            return false;
        }
        return false;
    }
}
