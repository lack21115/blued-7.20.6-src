package com.anythink.core.common.k;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.IExHandler;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/m.class */
public final class m {
    public static final String A = "it_src";

    /* renamed from: a  reason: collision with root package name */
    public static final String f6816a = "platform";
    public static final String b = "os_vn";

    /* renamed from: c  reason: collision with root package name */
    public static final String f6817c = "os_vc";
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

    public static JSONObject a() {
        JSONObject b2 = b();
        JSONObject c2 = c();
        try {
            b2.put("app_id", com.anythink.core.common.b.n.a().p());
            Iterator<String> keys = c2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                b2.put(next, c2.opt(next));
            }
            return b2;
        } catch (JSONException e2) {
            return b2;
        }
    }

    private static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        Context g2 = com.anythink.core.common.b.n.a().g();
        try {
            jSONObject.put("platform", 1);
            jSONObject.put("os_vn", d.e());
            jSONObject.put("os_vc", d.d());
            jSONObject.put("package_name", d.k(g2));
            jSONObject.put("app_vn", d.i(g2));
            jSONObject.put("app_vc", d.h(g2));
            jSONObject.put("brand", d.b());
            jSONObject.put("model", d.a());
            jSONObject.put("screen", d.j(g2));
            jSONObject.put("network_type", String.valueOf(d.m(g2)));
            jSONObject.put("mnc", d.c(g2));
            jSONObject.put("mcc", d.b(g2));
            jSONObject.put("language", d.f(g2));
            jSONObject.put("timezone", d.c());
            jSONObject.put("sdk_ver", g.a());
            jSONObject.put("gp_ver", d.n(g2));
            jSONObject.put("ua", d.i());
            jSONObject.put("orient", d.g(g2));
            jSONObject.put("system", 1);
            if (!TextUtils.isEmpty(com.anythink.core.common.b.n.a().n())) {
                jSONObject.put("channel", com.anythink.core.common.b.n.a().n());
            }
            if (!TextUtils.isEmpty(com.anythink.core.common.b.n.a().o())) {
                jSONObject.put("sub_channel", com.anythink.core.common.b.n.a().o());
            }
            jSONObject.put("upid", com.anythink.core.common.b.n.a().x());
            jSONObject.put("ps_id", com.anythink.core.common.b.n.a().r());
            return jSONObject;
        } catch (Exception e2) {
            return jSONObject;
        }
    }

    private static JSONObject c() {
        String F;
        Context g2 = com.anythink.core.common.b.n.a().g();
        JSONObject jSONObject = new JSONObject();
        com.anythink.core.c.a b2 = com.anythink.core.c.b.a(g2).b(com.anythink.core.common.b.n.a().p());
        if (b2 != null) {
            try {
                F = b2.F();
            } catch (Exception e2) {
                return jSONObject;
            }
        } else {
            F = "";
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(F)) {
            try {
                JSONObject jSONObject2 = new JSONObject(F);
                z2 = true;
                if (!jSONObject2.isNull("a")) {
                    z2 = jSONObject2.optInt("a") == 1;
                }
            } catch (Exception e3) {
                z2 = true;
            }
        }
        jSONObject.put("android_id", z2 ? d.d(g2) : "");
        jSONObject.put("gaid", d.f());
        IExHandler b3 = com.anythink.core.common.b.n.a().b();
        if (b3 != null) {
            b3.fillRequestData(jSONObject, b2);
            jSONObject.put("is_cn_sdk", "1");
        } else {
            jSONObject.put("is_cn_sdk", "0");
        }
        String l2 = d.l(g2);
        jSONObject.put("it_src", TextUtils.isEmpty(l2) ? "" : l2);
        return jSONObject;
    }
}
