package com.anythink.core.common.g;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATPrivacyConfig;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.n;
import com.anythink.core.common.b.p;
import com.anythink.core.common.e.ak;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g/c.class */
public final class c {
    public static final String A = "it_src";
    public static final String B = "lat";
    public static final String C = "lon";
    public static final String D = "inst_wx";
    public static final String E = "mini_sdk";
    public static final String F = "ms_type";
    public static final String G = "device_set";
    public static final String H = "gdpr_cs";
    public static final String I = "abtest_id";
    public static final String J = "first_init_time";
    public static final String K = "days_from_first_init";
    public static final String L = "cs_cl";
    public static final String M = "is_ofm";
    public static final String N = "app_id";
    public static final String O = "api_ver";
    public static final String P = "custom";
    public static final String Q = "rdid";
    public static final String R = "rc";
    public static final String S = "data";
    public static final String T = "tcp_tk_da_type";
    public static final String U = "ofl";
    public static final String V = "tcp_rate";
    public static final String W = "p";
    public static final String X = "p2";
    public static final String Y = "sign";
    public static final String Z = "common";

    /* renamed from: a  reason: collision with root package name */
    public static final String f6721a = "platform";
    public static final int aa = 1;
    public static final int ab = 2;
    public static final int ac = 3;
    public static final String ad = "area_type";
    public static final String ae = "sp_http";
    public static final String af = "os_fw";
    public static final String ag = "is_test";
    public static final String ah = "mdna_oid";
    public static final String ai = "mdna_appkey";
    public static final String aj = "mdna_r";
    public static final String ak = "user_num";
    public static final String al = "cp_device_id";
    public static final String am = "cp_pl_id";
    public static int an = -1;
    public static int ao = -1;
    public static final String ap = "al_it_apil";
    public static final String aq = "wx_data";
    public static final String b = "os_vn";

    /* renamed from: c  reason: collision with root package name */
    public static final String f6722c = "os_vc";
    public static final String d = "package_name";
    public static final String e = "app_vn";
    public static final String f = "app_vc";
    public static final String g = "brand";
    public static final String h = "model";
    public static final String i = "screen";
    public static final String j = "network_type";
    public static final String k = "mnc";
    public static final String l = "mcc";
    public static final String m = "language";
    public static final String n = "timezone";
    public static final String o = "sdk_ver";
    public static final String p = "gp_ver";
    public static final String q = "nw_ver";
    public static final String r = "ua";
    public static final String s = "orient";
    public static final String t = "system";
    public static final String u = "android_id";
    public static final String v = "gaid";
    public static final String w = "channel";
    public static final String x = "sub_channel";
    public static final String y = "upid";
    public static final String z = "ps_id";

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static JSONObject a() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static JSONObject a(int i2) {
        com.anythink.core.common.k.d.q(n.a().g());
        JSONObject jSONObject = new JSONObject();
        Context g2 = n.a().g();
        try {
            jSONObject.put("platform", 1);
            jSONObject.put("os_vn", com.anythink.core.common.k.d.e());
            jSONObject.put("os_vc", com.anythink.core.common.k.d.d());
            jSONObject.put("package_name", com.anythink.core.common.k.d.k(g2));
            jSONObject.put("app_vn", com.anythink.core.common.k.d.i(g2));
            jSONObject.put("app_vc", com.anythink.core.common.k.d.h(g2));
            jSONObject.put("brand", com.anythink.core.common.k.d.b());
            jSONObject.put("model", com.anythink.core.common.k.d.a());
            jSONObject.put("screen", com.anythink.core.common.k.d.j(g2));
            jSONObject.put("network_type", com.anythink.core.common.k.d.m(g2));
            jSONObject.put("mnc", com.anythink.core.common.k.d.c(g2));
            jSONObject.put("mcc", com.anythink.core.common.k.d.b(g2));
            jSONObject.put("language", com.anythink.core.common.k.d.f(g2));
            jSONObject.put("timezone", com.anythink.core.common.k.d.c());
            jSONObject.put("sdk_ver", com.anythink.core.common.k.g.a());
            jSONObject.put("gp_ver", com.anythink.core.common.k.d.n(g2));
            jSONObject.put("ua", com.anythink.core.common.k.d.i());
            jSONObject.put("orient", com.anythink.core.common.k.d.g(g2));
            jSONObject.put("system", 1);
            if (!TextUtils.isEmpty(n.a().n())) {
                jSONObject.put("channel", n.a().n());
            }
            if (!TextUtils.isEmpty(n.a().o())) {
                jSONObject.put("sub_channel", n.a().o());
            }
            jSONObject.put("upid", p.a(g2).b() ? n.a().x() : "");
            jSONObject.put("ps_id", n.a().r());
            com.anythink.core.c.a b2 = com.anythink.core.c.b.a(g2).b(n.a().p());
            if (b2 != null) {
                jSONObject.put(I, TextUtils.isEmpty(b2.A()) ? "" : b2.A());
            }
            jSONObject.put(J, n.a().h());
            jSONObject.put(K, n.a().i());
            StringBuilder sb = new StringBuilder();
            sb.append(n.a().e());
            sb.append(p.a(g2).a());
            jSONObject.put(H, sb.toString());
            if (n.a().j() == 1) {
                jSONObject.put(M, 1);
            }
            if (n.a().H() && com.anythink.core.common.b.i.a().a(b2)) {
                String b3 = com.anythink.core.common.b.i.a().b();
                String c2 = com.anythink.core.common.b.i.a().c();
                String d2 = com.anythink.core.common.b.i.a().d();
                if (TextUtils.isEmpty(b3)) {
                    b3 = "";
                }
                jSONObject.put(ah, b3);
                jSONObject.put(ai, !TextUtils.isEmpty(c2) ? c2 : "");
                jSONObject.put(Q, TextUtils.isEmpty(d2) ? "" : d2);
                jSONObject.put("mdna_r", n.a().K());
            }
            jSONObject.put(ae, n.a().C() ? n.a().D() ? "1" : "3" : n.a().D() ? "2" : "4");
            IExHandler b4 = n.a().b();
            if (b4 != null) {
                b4.fillRequestDeviceData(jSONObject, i2);
            }
            String j2 = com.anythink.core.common.k.d.j();
            if (!TextUtils.isEmpty(j2)) {
                jSONObject.put(af, Integer.parseInt(j2));
            }
            return jSONObject;
        } catch (Exception e2) {
            return jSONObject;
        }
    }

    public static JSONObject a(String str) {
        return a(n.a().d(str));
    }

    public static JSONObject a(Map<String, Object> map) {
        JSONObject jSONObject = null;
        if (map != null) {
            try {
                jSONObject = new JSONObject();
                try {
                    for (String str : map.keySet()) {
                        Object obj = map.get(str);
                        if (obj != null) {
                            try {
                                jSONObject.put(str, obj.toString());
                            } catch (Throwable th) {
                            }
                        }
                    }
                } catch (Throwable th2) {
                }
            } catch (Throwable th3) {
                return null;
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static void a(Context context, JSONObject jSONObject) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static void a(JSONObject jSONObject) {
        try {
            ak L2 = n.a().L();
            JSONObject jSONObject2 = new JSONObject();
            int i2 = 1;
            if (L2.b() != 1) {
                i2 = 0;
            }
            jSONObject2.put("has_sdk", i2);
            jSONObject2.put("sdk_ver", String.valueOf(L2.c()));
            jSONObject2.put("sdk_api_ver", String.valueOf(L2.d()));
            jSONObject2.put("open_app_id", com.anythink.core.common.k.d.l());
            jSONObject.put(aq, jSONObject2);
        } catch (Throwable th) {
        }
    }

    public static JSONObject b() {
        return a(n.a().m());
    }

    private static void b(JSONObject jSONObject) {
        ATPrivacyConfig J2 = n.a().J();
        if (J2 != null) {
            String devGaid = J2.getDevGaid();
            String devImei = J2.getDevImei();
            String devOaid = J2.getDevOaid();
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(devGaid)) {
                jSONObject2.put("set_gaid", devGaid);
            }
            if (!TextUtils.isEmpty(devImei)) {
                jSONObject2.put("set_imei", devImei);
            }
            if (!TextUtils.isEmpty(devOaid)) {
                jSONObject2.put("set_oaid", devOaid);
            }
            jSONObject.put(G, jSONObject2);
        }
    }
}
