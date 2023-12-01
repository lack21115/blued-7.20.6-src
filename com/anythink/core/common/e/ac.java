package com.anythink.core.common.e;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/ac.class */
public final class ac implements Serializable {
    String[] A;
    String[] B;
    String[] C;
    String[] D;
    String[] E;
    Map<Integer, String[]> F;
    String[] G;
    String[] H;
    String I;
    String J;
    String K;
    String L;
    String M;
    String N;
    String O;
    String P;
    String Q;
    String R;
    String S;
    String T;
    String U;
    String V;
    String W;
    String X;
    String Y;
    String Z;

    /* renamed from: a  reason: collision with root package name */
    String f6618a;
    String aa;
    String ab;
    String ac;
    String ad;
    String ae;
    String af;
    String ag;
    String ah;
    String ai;
    String aj;
    String ak;
    String al;
    String am;
    String an;
    String[] ao;
    String ap;
    String[] b;

    /* renamed from: c  reason: collision with root package name */
    String[] f6619c;
    String[] d;
    String[] e;
    String[] f;
    String[] g;
    String[] h;
    String[] i;
    String[] j;
    String[] k;
    String[] l;
    String[] m;
    String[] n;
    String[] o;
    String[] p;
    String[] q;
    String[] r;
    String[] s;
    String[] t;
    String[] u;
    String[] v;
    String[] w;
    String[] x;
    String[] y;
    String[] z;

    public static final ac a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            ac acVar = new ac();
            acVar.f6618a = jSONObject.optString("ks");
            acVar.b = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("nurl"));
            acVar.f6619c = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("imp"));
            acVar.d = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("click"));
            acVar.e = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vstart"));
            acVar.f = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("v25"));
            acVar.g = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("v50"));
            acVar.h = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("v75"));
            acVar.i = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("v100"));
            acVar.j = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vpaused"));
            acVar.k = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vclick"));
            acVar.l = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vmute"));
            acVar.m = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vunmute"));
            acVar.n = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("ec_show"));
            acVar.o = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("ec_close"));
            acVar.p = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("apk_dl_star"));
            acVar.q = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("apk_dl_end"));
            acVar.r = com.anythink.core.common.k.h.a(jSONObject.optJSONArray(com.anythink.expressad.foundation.d.h.cM));
            acVar.s = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vresumed"));
            acVar.t = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vskip"));
            acVar.u = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vfail"));
            acVar.v = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("apk_start_install"));
            acVar.w = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("dp_start"));
            acVar.x = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("dp_succ"));
            acVar.y = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("app_install"));
            acVar.z = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("app_uninstall"));
            acVar.A = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("app_unknow"));
            acVar.C = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("dp_inst_fail"));
            acVar.B = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("dp_uninst_fail"));
            acVar.D = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vd_succ"));
            acVar.E = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vrewarded"));
            JSONArray optJSONArray = jSONObject.optJSONArray("v_p_tracking");
            if (optJSONArray != null) {
                acVar.F = new HashMap();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    int optInt = optJSONObject.optInt("play_sec");
                    acVar.F.put(Integer.valueOf(optInt), com.anythink.core.common.k.h.a(optJSONObject.optJSONArray("list")));
                    i = i2 + 1;
                }
            }
            acVar.G = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("load_success"));
            acVar.H = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("load_fail"));
            acVar.I = jSONObject.optString("tp_nurl");
            acVar.J = jSONObject.optString("tp_imp");
            acVar.K = jSONObject.optString("tp_click");
            acVar.L = jSONObject.optString("tp_vstart");
            acVar.M = jSONObject.optString("tp_v25");
            acVar.N = jSONObject.optString("tp_v50");
            acVar.O = jSONObject.optString("tp_v75");
            acVar.P = jSONObject.optString("tp_v100");
            acVar.Q = jSONObject.optString("tp_vpaused");
            acVar.R = jSONObject.optString("tp_vclick");
            acVar.S = jSONObject.optString("tp_vmute");
            acVar.T = jSONObject.optString("tp_vunmute");
            acVar.U = jSONObject.optString("tp_ec_show");
            acVar.V = jSONObject.optString("tp_ec_close");
            acVar.W = jSONObject.optString("tp_apk_dl_star");
            acVar.X = jSONObject.optString("tp_apk_dl_end");
            acVar.Y = jSONObject.optString("tp_apk_install");
            acVar.Z = jSONObject.optString("tp_vresumed");
            acVar.aa = jSONObject.optString("tp_vskip");
            acVar.ab = jSONObject.optString("tp_vfail");
            acVar.ac = jSONObject.optString("tp_apk_start_install");
            acVar.ad = jSONObject.optString("tp_dp_start");
            acVar.ae = jSONObject.optString("tp_dp_succ");
            acVar.af = jSONObject.optString("tp_app_install");
            acVar.ag = jSONObject.optString("tp_app_uninstall");
            acVar.ah = jSONObject.optString("tp_app_unknow");
            acVar.aj = jSONObject.optString("tp_dp_inst_fail");
            acVar.ai = jSONObject.optString("tp_dp_uninst_fail");
            acVar.ak = jSONObject.optString("tp_vd_succ");
            acVar.al = jSONObject.optString("tp_vrewarded");
            acVar.am = jSONObject.optString("tp_load_success");
            acVar.an = jSONObject.optString("tp_load_fail");
            acVar.ao = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vready"));
            acVar.ap = jSONObject.optString("tp_ready");
            return acVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final String A() {
        return this.J;
    }

    public final String B() {
        return this.K;
    }

    public final String C() {
        return this.L;
    }

    public final String D() {
        return this.M;
    }

    public final String E() {
        return this.N;
    }

    public final String F() {
        return this.O;
    }

    public final String G() {
        return this.P;
    }

    public final String H() {
        return this.Q;
    }

    public final String I() {
        return this.R;
    }

    public final String J() {
        return this.S;
    }

    public final String K() {
        return this.T;
    }

    public final String L() {
        return this.U;
    }

    public final String M() {
        return this.V;
    }

    public final String N() {
        return this.W;
    }

    public final String O() {
        return this.X;
    }

    public final String P() {
        return this.Y;
    }

    public final String[] Q() {
        return this.s;
    }

    public final String[] R() {
        return this.t;
    }

    public final String[] S() {
        return this.u;
    }

    public final String[] T() {
        return this.v;
    }

    public final String[] U() {
        return this.w;
    }

    public final String[] V() {
        return this.x;
    }

    public final String[] W() {
        return this.y;
    }

    public final String[] X() {
        return this.z;
    }

    public final String[] Y() {
        return this.A;
    }

    public final String Z() {
        return this.Z;
    }

    public final void a(String[] strArr) {
        this.d = strArr;
    }

    public final String[] a() {
        return this.G;
    }

    public final String aa() {
        return this.aa;
    }

    public final String ab() {
        return this.ab;
    }

    public final String ac() {
        return this.ac;
    }

    public final String ad() {
        return this.ad;
    }

    public final String ae() {
        return this.ae;
    }

    public final String af() {
        return this.af;
    }

    public final String ag() {
        return this.ag;
    }

    public final String ah() {
        return this.ah;
    }

    public final String ai() {
        return this.ai;
    }

    public final String aj() {
        return this.aj;
    }

    public final String ak() {
        return this.ak;
    }

    public final String al() {
        return this.al;
    }

    public final String am() {
        return this.am;
    }

    public final String an() {
        return this.an;
    }

    public final String[] ao() {
        return this.ao;
    }

    public final String ap() {
        return this.ap;
    }

    public final void b(String[] strArr) {
        this.p = strArr;
    }

    public final String[] b() {
        return this.H;
    }

    public final String c() {
        return this.f6618a;
    }

    public final void c(String[] strArr) {
        this.q = strArr;
    }

    public final void d(String[] strArr) {
        this.r = strArr;
    }

    public final String[] d() {
        return this.b;
    }

    public final String[] e() {
        return this.f6619c;
    }

    public final String[] f() {
        return this.d;
    }

    public final String[] g() {
        return this.e;
    }

    public final String[] h() {
        return this.f;
    }

    public final String[] i() {
        return this.g;
    }

    public final String[] j() {
        return this.h;
    }

    public final String[] k() {
        return this.i;
    }

    public final String[] l() {
        return this.j;
    }

    public final String[] m() {
        return this.k;
    }

    public final String[] n() {
        return this.l;
    }

    public final String[] o() {
        return this.m;
    }

    public final String[] p() {
        return this.n;
    }

    public final String[] q() {
        return this.o;
    }

    public final String[] r() {
        return this.p;
    }

    public final String[] s() {
        return this.q;
    }

    public final String[] t() {
        return this.r;
    }

    public final String[] u() {
        return this.B;
    }

    public final String[] v() {
        return this.C;
    }

    public final String[] w() {
        return this.D;
    }

    public final String[] x() {
        return this.E;
    }

    public final Map<Integer, String[]> y() {
        return this.F;
    }

    public final String z() {
        return this.I;
    }
}
