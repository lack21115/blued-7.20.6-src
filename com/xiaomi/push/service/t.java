package com.xiaomi.push.service;

import android.content.Context;
import android.media.TtmlUtils;
import android.os.Build;
import android.provider.UserDictionary;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.push.s;
import com.xiaomi.push.service.bg;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/t.class */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public final int f28010a;

    /* renamed from: a  reason: collision with other field name */
    public final String f1033a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f28011c;
    public final String d;
    public final String e;
    public final String f;

    public t(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f1033a = str;
        this.b = str2;
        this.f28011c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.f28010a = i;
    }

    private static String a(Context context) {
        boolean equals = "com.xiaomi.xmsf".equals(context);
        String str = null;
        if (!equals) {
            str = com.xiaomi.push.j.b();
        } else if (TextUtils.isEmpty(null)) {
            String m8995a = com.xiaomi.push.j.m8995a("ro.miui.region");
            str = m8995a;
            if (TextUtils.isEmpty(m8995a)) {
                return com.xiaomi.push.j.m8995a("ro.product.locale.region");
            }
        }
        return str;
    }

    public static boolean a() {
        try {
            return com.xiaomi.push.r.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m9159a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    private static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public bg.b a(XMPushService xMPushService) {
        bg.b bVar = new bg.b(xMPushService);
        a(bVar, xMPushService, xMPushService.m9047b(), "c");
        return bVar;
    }

    public bg.b a(bg.b bVar, Context context, j jVar, String str) {
        bVar.f963a = context.getPackageName();
        bVar.f966b = this.f1033a;
        bVar.h = this.f28011c;
        bVar.f27941c = this.b;
        bVar.g = "5";
        bVar.d = "XMPUSH-PASS";
        bVar.f965a = false;
        s.a aVar = new s.a();
        aVar.a(HiAnalyticsConstant.BI_KEY_SDK_VER, 48).a("cpvn", "5_1_0-C").a("cpvc", 50010).a(com.anythink.expressad.foundation.g.a.bD, a.a(context).b()).a(TtmlUtils.TAG_REGION, a.a(context).a()).a("miui_vn", com.xiaomi.push.j.c()).a("miui_vc", Integer.valueOf(com.xiaomi.push.j.a(context))).a("xmsf_vc", Integer.valueOf(com.xiaomi.push.g.a(context, "com.xiaomi.xmsf"))).a("android_ver", Integer.valueOf(Build.VERSION.SDK_INT)).a("n_belong_to_app", Boolean.valueOf(ax.m9083a(context))).a("systemui_vc", Integer.valueOf(com.xiaomi.push.g.a(context)));
        String a2 = a(context);
        if (!TextUtils.isEmpty(a2)) {
            aVar.a("latest_country_code", a2);
        }
        String d = com.xiaomi.push.j.d();
        if (!TextUtils.isEmpty(d)) {
            aVar.a("device_ch", d);
        }
        String e = com.xiaomi.push.j.e();
        if (!TextUtils.isEmpty(e)) {
            aVar.a("device_mfr", e);
        }
        bVar.e = aVar.toString();
        String str2 = b(context) ? "1000271" : this.d;
        s.a aVar2 = new s.a();
        aVar2.a("appid", str2).a(UserDictionary.Words.LOCALE, Locale.getDefault().toString()).a("sync", 1);
        if (m9159a(context)) {
            aVar2.a("ab", str);
        }
        bVar.f = aVar2.toString();
        bVar.f962a = jVar;
        return bVar;
    }
}
