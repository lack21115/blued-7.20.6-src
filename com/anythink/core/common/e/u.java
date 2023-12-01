package com.anythink.core.common.e;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/u.class */
public final class u extends k {
    protected int n;

    private void P(int i) {
        this.n = i;
    }

    public static u c(String str) {
        u uVar = new u();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                uVar.q(jSONObject.optInt("f_t"));
                uVar.r(jSONObject.optInt("v_c"));
                uVar.s(jSONObject.optInt("s_b_t"));
                uVar.u(jSONObject.optInt("e_c_a"));
                uVar.v(jSONObject.optInt("v_m"));
                uVar.w(jSONObject.optInt("s_c_t"));
                uVar.l(jSONObject.optInt("m_t"));
                uVar.c(jSONObject.optLong("o_c_t"));
                uVar.m(jSONObject.optInt("ak_cfm"));
                uVar.b(jSONObject.optLong("ctdown_time"));
                uVar.n(jSONObject.optInt("sk_able"));
                uVar.o(jSONObject.optInt("orient"));
                uVar.a(jSONObject.optString("size"));
                uVar.p(jSONObject.optInt("cl_btn"));
                uVar.x(jSONObject.optInt("ec_r"));
                uVar.y(jSONObject.optInt("ec_s_t"));
                uVar.z(jSONObject.optInt("ec_l_t"));
                uVar.b(jSONObject.optString("inter_type"));
                uVar.n = jSONObject.optInt("spl_type");
                uVar.a(jSONObject.optLong("or_t"));
                uVar.e(jSONObject.optInt("rv_fail_reward"));
                uVar.f(jSONObject.optInt("cl_sz"));
                uVar.i(jSONObject.optInt("si_fit"));
                if (jSONObject.has("at_cl_sw")) {
                    uVar.A(jSONObject.optInt("at_cl_sw"));
                }
                if (jSONObject.has("at_ct_ti")) {
                    uVar.B(jSONObject.optInt("at_ct_ti"));
                }
                if (jSONObject.has("int_cl_sw")) {
                    uVar.C(jSONObject.optInt("int_cl_sw"));
                }
                if (jSONObject.has("int_cl_ti")) {
                    uVar.D(jSONObject.optInt("int_cl_ti"));
                }
                if (jSONObject.has("sh_ec")) {
                    uVar.E(jSONObject.optInt("sh_ec"));
                }
                if (jSONObject.has("ipua")) {
                    uVar.c(jSONObject.optInt("ipua"));
                }
                if (jSONObject.has("clua")) {
                    uVar.d(jSONObject.optInt("clua"));
                }
                if (jSONObject.has("ap_arpt")) {
                    uVar.F(jSONObject.optInt("ap_arpt"));
                }
                if (jSONObject.has("ap_pasbl")) {
                    uVar.G(jSONObject.optInt("ap_pasbl"));
                }
                if (jSONObject.has("shk_sw")) {
                    uVar.H(jSONObject.optInt("shk_sw"));
                }
                if (jSONObject.has("shk_strength_and")) {
                    uVar.I(jSONObject.optInt("shk_strength_and"));
                }
                if (jSONObject.has("shk_time")) {
                    uVar.d(jSONObject.optLong("shk_time"));
                }
                if (jSONObject.has("click_cache_time")) {
                    uVar.J(jSONObject.optInt("click_cache_time"));
                } else {
                    uVar.J(3600000);
                }
                if (jSONObject.has("click_nt_sw")) {
                    uVar.K(jSONObject.optInt("click_nt_sw"));
                } else {
                    uVar.K(1);
                }
                if (jSONObject.has("ft_cl_sz")) {
                    uVar.g(jSONObject.optInt("ft_cl_sz"));
                } else {
                    uVar.g(1);
                }
                if (jSONObject.has("sh_cl_itp")) {
                    uVar.h(jSONObject.optInt("sh_cl_itp"));
                } else {
                    uVar.h(2);
                }
                uVar.L(jSONObject.optInt("shm_t", -1));
                if (jSONObject.has("ready_rate")) {
                    uVar.M(jSONObject.optInt("ready_rate"));
                } else {
                    uVar.M(100);
                }
                if (jSONObject.has("rsdl_rate")) {
                    uVar.N(jSONObject.optInt("rsdl_rate"));
                } else {
                    uVar.N(0);
                }
                if (jSONObject.has("video_ctn_type")) {
                    uVar.O(jSONObject.optInt("video_ctn_type"));
                    return uVar;
                }
                uVar.O(2);
                return uVar;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return uVar;
    }

    public final int X() {
        return this.n;
    }
}
