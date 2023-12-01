package com.anythink.basead.d.b;

import com.anythink.basead.b.a;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ab;
import com.anythink.core.common.e.ac;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.z;
import com.anythink.core.common.l;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/b/b.class */
public final class b {
    public static final String a = "sdk_updatetime";

    public static final z a(j jVar, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(g.c.d);
            if (optJSONObject == null) {
                return null;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONArray("offers").optJSONObject(0);
            z zVar = new z();
            zVar.a(jVar.f);
            zVar.j(optJSONObject2.optString(l.ad));
            zVar.k(optJSONObject2.optString("c_id"));
            zVar.w(optJSONObject2.optString(a.C0030a.A));
            zVar.l(optJSONObject2.optString("title"));
            zVar.m(optJSONObject2.optString(a.C0030a.f));
            zVar.f(optJSONObject2.optInt("rating"));
            zVar.n(optJSONObject2.optString("icon_u"));
            zVar.p(optJSONObject2.optString("full_u"));
            zVar.d(optJSONObject2.optInt("unit_type"));
            zVar.q(optJSONObject2.optString("tp_logo_u"));
            zVar.r(optJSONObject2.optString(a.C0030a.k));
            zVar.s(optJSONObject2.optString("video_u"));
            zVar.d(optJSONObject2.optInt("video_l"));
            zVar.J(optJSONObject2.optString("video_r"));
            zVar.K(optJSONObject2.optString("ec_u"));
            zVar.t(optJSONObject2.optString("store_u"));
            zVar.e(optJSONObject2.optInt("link_type"));
            zVar.v(optJSONObject2.optString("click_u"));
            zVar.u(optJSONObject2.optString("deeplink"));
            zVar.g(optJSONObject2.optInt("r_target"));
            zVar.a(optJSONObject2.optLong("expire"));
            zVar.x(optJSONObject2.optString("ad_logo_title"));
            zVar.j(optJSONObject2.optInt("crt_type", 1));
            zVar.L(optJSONObject2.optString("img_list"));
            zVar.M(optJSONObject2.optString("banner_xhtml"));
            zVar.b(jSONObject.optLong(a));
            zVar.c(optJSONObject2.optInt("offer_firm_id"));
            zVar.i(optJSONObject2.optString("jump_url"));
            zVar.N(optJSONObject2.optString(ATAdConst.KEY.APP_NAME));
            zVar.y(optJSONObject2.optString("publisher"));
            zVar.z(optJSONObject2.optString("app_version"));
            zVar.A(optJSONObject2.optString("privacy"));
            zVar.B(optJSONObject2.optString("permission"));
            zVar.C(optJSONObject2.optString("wv_ctrl"));
            zVar.a((k) ab.c(optJSONObject2.optString("ctrl")));
            zVar.a(ac.a(optJSONObject2.optString("tk")));
            zVar.b(optJSONObject2.optInt("adp_type"));
            zVar.e(optJSONObject2.optString("offer_html"));
            zVar.f(optJSONObject2.optString("offer_url"));
            zVar.c(optJSONObject2.optString("wx_username"));
            zVar.d(optJSONObject2.optString("wx_path"));
            return zVar;
        } catch (Throwable th) {
            return null;
        }
    }
}
