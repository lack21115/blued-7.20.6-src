package com.anythink.core.common.a;

import android.text.TextUtils;
import com.anythink.basead.b.a;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ab;
import com.anythink.core.common.e.ac;
import com.anythink.core.common.e.k;
import com.anythink.core.common.l;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/a/c.class */
public final class c {
    public static com.anythink.core.common.e.g a(String str, JSONObject jSONObject, int i) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(g.c.d);
            if (optJSONObject == null) {
                optJSONObject = jSONObject;
                if (!jSONObject.has("seatbid")) {
                    return null;
                }
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONArray("seatbid").optJSONObject(0);
            com.anythink.core.common.e.g gVar = new com.anythink.core.common.e.g();
            gVar.b(str);
            gVar.j(optJSONObject2.optString(l.ad));
            gVar.k(optJSONObject2.optString("c_id"));
            gVar.w(optJSONObject2.optString(a.C0030a.A));
            gVar.l(optJSONObject2.optString("title"));
            gVar.m(optJSONObject2.optString(a.C0030a.f));
            gVar.f(optJSONObject2.optInt("rating"));
            gVar.n(optJSONObject2.optString("icon_u"));
            gVar.p(optJSONObject2.optString("full_u"));
            gVar.d(optJSONObject2.optInt("unit_type"));
            gVar.q(optJSONObject2.optString("tp_logo_u"));
            gVar.r(optJSONObject2.optString(a.C0030a.k));
            gVar.s(optJSONObject2.optString("video_u"));
            gVar.d(optJSONObject2.optInt("video_l"));
            gVar.J(optJSONObject2.optString("video_r"));
            gVar.K(optJSONObject2.optString("ec_u"));
            gVar.t(optJSONObject2.optString("store_u"));
            gVar.e(optJSONObject2.optInt("link_type"));
            gVar.v(optJSONObject2.optString("click_u"));
            gVar.u(optJSONObject2.optString("deeplink"));
            gVar.j(optJSONObject2.optInt("crt_type", 1));
            gVar.L(optJSONObject2.optString("img_list"));
            gVar.M(optJSONObject2.optString("banner_xhtml"));
            gVar.c(optJSONObject2.optInt("offer_firm_id"));
            gVar.i(optJSONObject2.optString("jump_url"));
            try {
                String optString = optJSONObject2.optString("sdk_resp");
                if (!TextUtils.isEmpty(optString)) {
                    gVar.a(new JSONObject(optString).optString("data"));
                }
            } catch (Throwable th) {
            }
            gVar.N(optJSONObject2.optString(ATAdConst.KEY.APP_NAME));
            gVar.y(optJSONObject2.optString("publisher"));
            gVar.z(optJSONObject2.optString("app_version"));
            gVar.A(optJSONObject2.optString("privacy"));
            gVar.B(optJSONObject2.optString("permission"));
            gVar.h(optJSONObject2.optString("mtr_ver"));
            gVar.k(optJSONObject2.optInt("o_im_cap_sw", 2));
            gVar.l(optJSONObject2.optInt("o_cl_cap_sw", 2));
            gVar.m(optJSONObject2.optInt("c_im_cap_sw", 2));
            gVar.n(optJSONObject2.optInt("c_cl_cap_sw", 2));
            gVar.a(optJSONObject2.optLong("expire", 0L));
            if (i == 67) {
                gVar.a(2);
            } else {
                gVar.a(1);
            }
            gVar.a((k) ab.c(optJSONObject2.optString("ctrl")));
            gVar.a(ac.a(optJSONObject2.optString("tk")));
            try {
                JSONObject jSONObject2 = new JSONObject(optJSONObject2.optString("nw_info"));
                gVar.E(jSONObject2.optString("app_id"));
                gVar.F(jSONObject2.optString("app_key"));
                gVar.G(jSONObject2.optString("unit_id"));
            } catch (Throwable th2) {
            }
            gVar.H(optJSONObject2.optString("dsp_id", ""));
            gVar.I(optJSONObject2.optString("dsp_oid", ""));
            gVar.h(optJSONObject2.optInt("fca", -1));
            gVar.i(optJSONObject2.optInt("install_sw", -1));
            gVar.C(optJSONObject2.optString("wv_ctrl"));
            gVar.b(optJSONObject2.optInt("adp_type"));
            gVar.e(optJSONObject2.optString("offer_html"));
            gVar.f(optJSONObject2.optString("offer_url"));
            gVar.c(optJSONObject2.optString("wx_username"));
            gVar.d(optJSONObject2.optString("wx_path"));
            return gVar;
        } catch (Throwable th3) {
            return null;
        }
    }
}
