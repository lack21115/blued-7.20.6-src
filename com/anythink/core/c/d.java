package com.anythink.core.c;

import android.text.TextUtils;
import com.alipay.sdk.widget.j;
import com.amap.api.services.core.AMapException;
import com.android.internal.telephony.SmsConstants;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATCustomAdapterConfig;
import com.anythink.core.api.ATRewardInfo;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.b.p;
import com.anythink.core.common.c.l;
import com.anythink.core.common.e.ab;
import com.anythink.core.common.e.ag;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.m;
import com.anythink.core.common.e.s;
import com.anythink.core.common.e.u;
import com.anythink.core.common.k.g;
import com.anythink.core.common.k.h;
import com.anythink.core.common.l;
import com.anythink.core.common.v;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/c/d.class */
public class d {
    private String A;
    private ag B;
    private int C;
    private String D;
    private int E;
    private int F;
    private String G;
    private Map<String, Object> H;
    private Map<String, ATRewardInfo> I;
    private ATRewardInfo J;
    private String K;
    private String L;
    private long M;
    private String N;
    private long O;
    private int P;
    private long Q;
    private int R;
    private List<s> S;
    private u T;
    private long U;
    private double V;
    private String W;
    private List<String> X;
    private String Y;
    private String Z;
    private final String a = "Placement";
    private int aA;
    private int aB;
    private int aC;
    private String aD;
    private String aE;
    private String aF;
    private long aG;
    private String aH;
    private String aI;
    private double aJ;
    private int aK;
    private int aL;
    private int aM;
    private int aN;
    private String aa;
    private String ab;
    private long ac;
    private String ad;
    private String ae;
    private String af;
    private double ag;
    private String ah;
    private long ai;
    private List<ai> aj;
    private long ak;
    private long al;
    private long am;
    private int an;
    private int ao;
    private int ap;
    private long aq;
    private JSONObject ar;
    private String as;
    private JSONObject at;
    private int au;
    private String av;
    private String aw;
    private int ax;
    private int ay;
    private List<Integer> az;
    private long b;
    private long c;
    private int d;
    private int e;
    private int f;
    private long g;
    private long h;
    private long i;
    private int j;
    private int k;
    private int l;
    private int m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private List<ai> s;
    private List<ai> t;
    private int u;
    private int v;
    private long w;
    private long x;
    private long y;
    private int z;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/c/d$a.class */
    public static final class a {
        public static final String A = "req_w_time";
        public static final String B = "wf_loadts";
        public static final String C = "req_ug_type";
        public static final String D = "req_ug_numsp";
        public static final String E = "bf_ldf_rf_sw";
        public static final String F = "hb_start_time";
        public static final String G = "dsp_list";
        public static final String H = "bid_floor";
        public static final String I = "max_unit_ids";
        public static final String J = "xdb_list";
        public static final String K = "s2s_bd_max";
        public static final String L = "req_merge";
        public static final String M = "exclude_id_max";
        public static final String N = "install_id_max";
        public static final String O = "install_ids";
        public static final String P = "exclude_ids";
        public static final String Q = "is_test";
        public static final String R = "gsp_rates";
        public static final String S = "mdna_r";
        public static final String T = "adx_ext";
        public static final String U = "wf_id";
        public static final String V = "sysh_mtg_sw";
        public static final String W = "mid_gdt_sw";
        public static final String X = "lm_lrqf_interval_sws";
        public static final String Y = "wf_lscb_type";
        public static final String Z = "reqid_pg_sw";
        public static final String a = "hb_bid_timeout";
        private static final String aA = "s_id";
        private static final String aB = "u_n_f_sw";
        private static final String aC = "m_o";
        private static final String aD = "m_o_s";
        private static final String aE = "m_o_ks";
        private static final String aF = "p_m_o";
        private static final String aG = "callback";
        private static final String aH = "sc_list";
        private static final String aI = "rw_n";
        private static final String aJ = "rw_num";
        private static final String aK = "reward";
        private static final String aL = "currency";
        private static final String aM = "cc";
        private static final String aN = "exch_r";
        private static final String aO = "acct_cy";
        private static final String aa = "ps_id_timeout";
        private static final String ab = "ps_ct";
        private static final String ac = "ps_ct_out";
        private static final String ad = "pucs";
        private static final String ae = "ad_delivery_sw";
        private static final String af = "req_ug_num";
        private static final String ag = "unit_caps_d";
        private static final String ah = "unit_caps_h";
        private static final String ai = "unit_pacing";
        private static final String aj = "wifi_auto_sw";
        private static final String ak = "show_type";
        private static final String al = "refresh";
        private static final String am = "ug_list";
        private static final String an = "ol_list";
        private static final String ao = "gro_id";
        private static final String ap = "hb_list";
        private static final String aq = "s2shb_list";
        private static final String ar = "format";
        private static final String as = "auto_refresh";
        private static final String at = "auto_refresh_time";
        private static final String au = "s_t";
        private static final String av = "l_s_t";
        private static final String aw = "ra";
        private static final String ax = "asid";
        private static final String ay = "tp_ps";
        private static final String az = "t_g_id";
        public static final String b = "addr_bid";
        public static final String c = "load_fail_wtime";
        public static final String d = "load_cap";
        public static final String e = "load_cap_time";
        public static final String f = "cached_offers_num";
        public static final String g = "adx_list";
        public static final String h = "adx_st";
        public static final String i = "ilrd";
        public static final String j = "hb_list";
        public static final String k = "inh_list";
        public static final String l = "fbhb_bid_wtime";
        public static final String m = "burl_nt_firm";
        public static final String n = "wf_bid_addr";
        public static final String o = "ss_data";
        public static final String p = "cn_addr_bid";
        public static final String q = "cn_wf_bid_addr";
        public static final String r = "byuid_wt";
        public static final String s = "addr_bks";
        public static final String t = "addr_subbks";
        public static final String u = "s2sbks_list";
        public static final String v = "exch_rate_c2u";
        public static final String w = "doffer_list";
        public static final String x = "bottom_list";
        public static final String y = "bottom_reqts";
        public static final String z = "cb_w_time";
    }

    private void A(int i) {
        this.ay = i;
    }

    private void A(String str) {
        this.p = str;
    }

    private void B(int i) {
        this.aB = i;
    }

    private void B(String str) {
        this.q = str;
    }

    private void C(String str) {
        this.aa = str;
    }

    private void D(String str) {
        this.ab = str;
    }

    private void E(String str) {
        this.aH = str;
    }

    private void F(String str) {
        this.aI = str;
    }

    private static List<ai> a(String str, int i) {
        ArrayList arrayList;
        ATCustomAdapterConfig b;
        boolean z = (i == 0 || i == 4 || i == 8) ? false : true;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = arrayList2;
        try {
            JSONArray jSONArray = new JSONArray(str);
            boolean z2 = z;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                arrayList = arrayList2;
                arrayList3 = arrayList2;
                if (i3 >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject != null) {
                    ai aiVar = new ai();
                    aiVar.e(i);
                    aiVar.d(z2 ? 1 : 0);
                    if (jSONObject.isNull(l.z)) {
                        aiVar.c("");
                    } else {
                        aiVar.c(jSONObject.optString(l.z));
                    }
                    if (jSONObject.isNull(l.w)) {
                        aiVar.b(-1);
                    } else {
                        aiVar.b(jSONObject.optInt(l.w));
                    }
                    if (jSONObject.isNull(l.x)) {
                        aiVar.c(-1);
                    } else {
                        aiVar.c(jSONObject.optInt(l.x));
                    }
                    if (jSONObject.isNull(l.y)) {
                        aiVar.b("");
                    } else {
                        aiVar.b(jSONObject.optString(l.y));
                    }
                    if (jSONObject.isNull("nw_firm_id")) {
                        aiVar.a(-1);
                    } else {
                        aiVar.a(jSONObject.optInt("nw_firm_id"));
                    }
                    if (jSONObject.isNull(l.v)) {
                        aiVar.a("");
                    } else {
                        aiVar.a(jSONObject.optString(l.v));
                    }
                    if (jSONObject.isNull(l.A)) {
                        aiVar.d(SmsConstants.FORMAT_UNKNOWN);
                    } else {
                        aiVar.d(jSONObject.optString(l.A));
                    }
                    if (jSONObject.isNull(l.t)) {
                        aiVar.c(0L);
                    } else {
                        aiVar.c(jSONObject.optInt(l.t));
                    }
                    if (jSONObject.isNull(l.r)) {
                        aiVar.d(0L);
                    } else {
                        aiVar.d(jSONObject.optInt(l.r));
                    }
                    if (jSONObject.isNull(l.s)) {
                        aiVar.h(1);
                    } else {
                        aiVar.h(jSONObject.optInt(l.s));
                    }
                    if (jSONObject.isNull("pacing")) {
                        aiVar.e(-1L);
                    } else {
                        aiVar.e(jSONObject.optLong("pacing"));
                    }
                    if (jSONObject.isNull("unit_id")) {
                        aiVar.e("");
                    } else {
                        aiVar.e(jSONObject.optString("unit_id"));
                    }
                    if (jSONObject.isNull(l.D)) {
                        aiVar.a(0.0d);
                    } else {
                        aiVar.a(jSONObject.optDouble(l.D, 0.0d));
                    }
                    if (jSONObject.isNull(l.E)) {
                        aiVar.f(2000L);
                    } else {
                        aiVar.f(jSONObject.optInt(l.E));
                    }
                    if (jSONObject.isNull(l.G)) {
                        aiVar.f("");
                    } else {
                        aiVar.f(jSONObject.optString(l.G));
                    }
                    if (jSONObject.isNull(l.H)) {
                        aiVar.i(0);
                    } else {
                        aiVar.i(jSONObject.optInt(l.H));
                    }
                    if (jSONObject.isNull(l.I)) {
                        aiVar.j(AMapException.CODE_AMAP_ROUTE_OUT_OF_SERVICE);
                    } else {
                        aiVar.j(jSONObject.optInt(l.I));
                    }
                    if (jSONObject.isNull("payload")) {
                        aiVar.g("");
                    } else {
                        aiVar.g(jSONObject.optString("payload"));
                    }
                    if (jSONObject.isNull("error")) {
                        aiVar.h("");
                    } else {
                        aiVar.h(jSONObject.optString("error"));
                    }
                    if (jSONObject.isNull(l.J)) {
                        aiVar.g(1800000L);
                    } else {
                        aiVar.g(jSONObject.optLong(l.J));
                    }
                    if (jSONObject.isNull(l.K)) {
                        aiVar.h(-1L);
                    } else {
                        aiVar.h(jSONObject.optLong(l.K));
                    }
                    if (jSONObject.isNull(l.L)) {
                        aiVar.b(1800000L);
                    } else {
                        aiVar.b(jSONObject.optLong(l.L));
                    }
                    if (jSONObject.isNull(l.ai)) {
                        aiVar.g(z2 ? 0 : 1);
                    } else {
                        aiVar.g(jSONObject.optInt(l.ai));
                    }
                    if (jSONObject.isNull(l.M)) {
                        aiVar.k(1);
                    } else {
                        aiVar.k(jSONObject.optInt(l.M));
                    }
                    if (jSONObject.isNull(l.N)) {
                        aiVar.l(1);
                    } else {
                        aiVar.l(jSONObject.optInt(l.N));
                    }
                    if (jSONObject.isNull(l.O)) {
                        aiVar.n(-1);
                    } else {
                        aiVar.n(jSONObject.optInt(l.O));
                    }
                    if (jSONObject.isNull(l.P)) {
                        aiVar.i("publisher_defined");
                    } else {
                        aiVar.i(jSONObject.optString(l.P));
                    }
                    if (jSONObject.isNull(l.Q)) {
                        aiVar.i(0L);
                    } else {
                        aiVar.i(jSONObject.optLong(l.Q));
                    }
                    if (jSONObject.isNull(l.R)) {
                        aiVar.j(0L);
                    } else {
                        aiVar.j(jSONObject.optLong(l.R));
                    }
                    if (jSONObject.isNull(l.S)) {
                        aiVar.b(0.0d);
                    } else {
                        aiVar.b(jSONObject.optDouble(l.S, 0.0d));
                    }
                    if (jSONObject.isNull(l.T)) {
                        aiVar.o(1);
                    } else {
                        aiVar.o(jSONObject.optInt(l.T));
                    }
                    if (jSONObject.isNull(l.U)) {
                        aiVar.p(1);
                    } else {
                        aiVar.p(jSONObject.optInt(l.U));
                    }
                    if (jSONObject.isNull(l.V)) {
                        aiVar.q(2);
                    } else {
                        aiVar.q(jSONObject.optInt(l.V));
                    }
                    if (jSONObject.isNull(l.W)) {
                        aiVar.f(1);
                    } else {
                        aiVar.f(jSONObject.optInt(l.W));
                    }
                    if (jSONObject.isNull(l.Z)) {
                        aiVar.r(2);
                    } else {
                        aiVar.r(jSONObject.optInt(l.Z));
                    }
                    if (jSONObject.isNull(l.X)) {
                        aiVar.t(2);
                    } else {
                        aiVar.t(jSONObject.optInt(l.X));
                    }
                    if (jSONObject.isNull(l.Y)) {
                        aiVar.s(0);
                    } else {
                        aiVar.s(jSONObject.optInt(l.Y));
                    }
                    if (jSONObject.isNull(l.aa)) {
                        aiVar.u(1);
                    } else {
                        aiVar.u(jSONObject.optInt(l.aa));
                    }
                    if (jSONObject.isNull(l.ad)) {
                        aiVar.j("");
                    } else {
                        aiVar.j(jSONObject.optString(l.ad));
                    }
                    if (i == 7) {
                        com.anythink.core.common.d.c.a(n.a().g()).a(aiVar.t(), aiVar.W());
                    }
                    if (jSONObject.isNull(l.ab)) {
                        aiVar.v(2);
                    } else {
                        aiVar.v(jSONObject.optInt(l.ab));
                    }
                    if (jSONObject.isNull("ad_type")) {
                        aiVar.w(-1);
                    } else {
                        aiVar.w(jSONObject.optInt("ad_type", -1));
                    }
                    if (jSONObject.isNull(l.ae)) {
                        aiVar.x(-1);
                    } else {
                        aiVar.x(jSONObject.optInt(l.ae, -1));
                    }
                    if (aiVar.l() != 2) {
                        aiVar.a(ATAdConst.CURRENCY.USD);
                    } else if (aiVar.c() == 22) {
                        aiVar.a(ATAdConst.CURRENCY.RMB_CENT);
                    } else {
                        aiVar.a(ATAdConst.CURRENCY.USD);
                    }
                    if (jSONObject.isNull(l.af)) {
                        aiVar.z(0);
                    } else {
                        aiVar.z(jSONObject.optInt(l.af, 0));
                    }
                    if (jSONObject.isNull("bid_floor")) {
                        aiVar.c(0.0d);
                    } else {
                        aiVar.c(jSONObject.optDouble("bid_floor", 0.0d));
                    }
                    if (aiVar.c() >= 100000 && (b = n.a().b(aiVar.h())) != null) {
                        aiVar.f(b.isRealTimeBidSwitch() ? 2 : 1);
                        aiVar.c(b.getAdCacheTime());
                    }
                    if (jSONObject.isNull(l.al)) {
                        aiVar.A(-1);
                    } else {
                        aiVar.A(jSONObject.optInt(l.al, -1));
                    }
                    if (jSONObject.isNull(l.am)) {
                        aiVar.d(aiVar.x());
                    } else {
                        aiVar.d(jSONObject.optDouble(l.am, aiVar.x()));
                    }
                    if (jSONObject.isNull(l.an)) {
                        aiVar.k("CNY");
                    } else {
                        aiVar.k(jSONObject.optString(l.an, "CNY"));
                    }
                    try {
                        arrayList2.add(aiVar);
                    } catch (Exception e) {
                        return arrayList2;
                    }
                }
                i2 = i3 + 1;
            }
        } catch (Exception e2) {
            arrayList = arrayList3;
        }
        return arrayList;
    }

    public static List<ai> a(String str, String str2) {
        List<ai> a2 = a(str, 0);
        a2.addAll(a(str2, 4));
        Collections.sort(a2);
        return a2;
    }

    private static List<s> a(String str, String str2, long j, u uVar) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                s sVar = new s();
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                sVar.j(optJSONObject.optString("o_id"));
                sVar.k(optJSONObject.optString("c_id"));
                sVar.l(optJSONObject.optString("t"));
                sVar.w(optJSONObject.optString("p_g"));
                sVar.m(optJSONObject.optString("d"));
                sVar.n(optJSONObject.optString("ic_u"));
                sVar.o(optJSONObject.optString("im_u"));
                sVar.p(optJSONObject.optString("f_i_u"));
                sVar.q(optJSONObject.optString("a_c_u"));
                sVar.r(optJSONObject.optString("c_t"));
                sVar.s(optJSONObject.optString("v_u"));
                sVar.e(optJSONObject.optInt("l_t"));
                sVar.t(optJSONObject.optString("p_u"));
                sVar.u(optJSONObject.optString("dl"));
                sVar.v(optJSONObject.optString("c_u"));
                sVar.H(optJSONObject.optString("ip_u"));
                sVar.I(optJSONObject.optString("t_u"));
                sVar.J(optJSONObject.optString("t_u_25"));
                sVar.K(optJSONObject.optString("t_u_50"));
                sVar.L(optJSONObject.optString("t_u_75"));
                sVar.M(optJSONObject.optString("t_u_100"));
                sVar.N(optJSONObject.optString("s_e_c_t_u"));
                sVar.O(optJSONObject.optString("c_t_u"));
                sVar.P(optJSONObject.optString("ip_n_u"));
                sVar.Q(optJSONObject.optString("c_n_u"));
                sVar.R = optJSONObject.optInt("o_a_d_c");
                sVar.S = optJSONObject.optLong("o_a_p");
                sVar.a(j);
                sVar.d(optJSONObject.optInt("unit_type"));
                sVar.a(optJSONObject.optInt("c_m"));
                sVar.b(optJSONObject.optString("ext_h_pic"));
                sVar.E(optJSONObject.optString("ext_big_h_pic"));
                sVar.F(optJSONObject.optString("ext_rect_h_pic"));
                sVar.G(optJSONObject.optString("ext_home_h_pic"));
                sVar.a(str2);
                sVar.y(optJSONObject.optString("pub"));
                sVar.z(optJSONObject.optString("app_vc"));
                sVar.A(optJSONObject.optString("pvc"));
                sVar.B(optJSONObject.optString("pms"));
                sVar.a((k) uVar);
                arrayList.add(sVar);
                i = i2 + 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    public static List<ai> a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        List<ai> a2 = a(str, 1);
        List<ai> a3 = a(str2, 3);
        List<ai> a4 = a(str3, 2);
        List<ai> a5 = a(str4, 5);
        List<ai> a6 = a(str5, 6);
        List<ai> a7 = a(str6, 7);
        List<ai> a8 = a(str7, 3);
        a2.addAll(a3);
        a2.addAll(a4);
        a2.addAll(a5);
        a2.addAll(a6);
        a2.addAll(a7);
        a2.addAll(a8);
        return a2;
    }

    private void a(double d) {
        this.ag = d;
    }

    private void a(int i) {
        this.aA = i;
    }

    private void a(long j) {
        this.aq = j;
    }

    private void a(ATRewardInfo aTRewardInfo) {
        this.J = aTRewardInfo;
    }

    private void a(ag agVar) {
        this.B = agVar;
    }

    private void a(u uVar) {
        this.T = uVar;
    }

    private void a(List<Integer> list) {
        this.az = list;
    }

    private void a(Map<String, ATRewardInfo> map) {
        this.I = map;
    }

    private void a(JSONObject jSONObject) {
        this.at = jSONObject;
    }

    private List<ai> aA() {
        return this.aj;
    }

    private String aB() {
        return this.aF;
    }

    private String aC() {
        return this.N;
    }

    private int aD() {
        return this.e;
    }

    private int aE() {
        return this.j;
    }

    private int aF() {
        return this.k;
    }

    private int aG() {
        return this.l;
    }

    private ag aH() {
        return this.B;
    }

    private long aI() {
        return this.aG;
    }

    private String aJ() {
        return this.aa;
    }

    private long aK() {
        return this.ak;
    }

    private long aL() {
        return this.al;
    }

    private int aM() {
        return this.ay;
    }

    private int aN() {
        return this.aB;
    }

    private JSONObject ay() {
        return this.ar;
    }

    private int az() {
        return this.ao;
    }

    public static d b(String str) {
        long optLong;
        if (str == null) {
            return null;
        }
        try {
            d dVar = new d();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.isNull("ps_ct")) {
                dVar.b = 0L;
            } else {
                dVar.b = jSONObject.optLong("ps_ct");
            }
            if (jSONObject.isNull("ps_ct_out")) {
                dVar.c = 0L;
            } else {
                dVar.c = jSONObject.optLong("ps_ct_out");
            }
            if (jSONObject.isNull("pucs")) {
                dVar.d = 1;
            } else {
                dVar.d = jSONObject.optInt("pucs");
            }
            if (jSONObject.isNull("ad_delivery_sw")) {
                dVar.e = 1;
            } else {
                dVar.e = jSONObject.optInt("ad_delivery_sw");
            }
            if (jSONObject.isNull("req_ug_num")) {
                dVar.f = -1;
            } else {
                dVar.f = jSONObject.optInt("req_ug_num");
            }
            if (jSONObject.isNull("unit_caps_d")) {
                dVar.g = -1L;
            } else {
                dVar.g = jSONObject.optLong("unit_caps_d");
            }
            if (jSONObject.isNull("unit_caps_h")) {
                dVar.h = -1L;
            } else {
                dVar.h = jSONObject.optLong("unit_caps_h");
            }
            if (jSONObject.isNull("unit_pacing")) {
                dVar.i = -1L;
            } else {
                dVar.i = jSONObject.optLong("unit_pacing");
            }
            if (jSONObject.isNull("wifi_auto_sw")) {
                dVar.j = 0;
            } else {
                dVar.j = jSONObject.optInt("wifi_auto_sw");
            }
            if (jSONObject.isNull("show_type")) {
                dVar.k = 0;
            } else {
                dVar.k = jSONObject.optInt("show_type");
            }
            if (jSONObject.isNull(j.l)) {
                dVar.l = 0;
            } else {
                dVar.l = jSONObject.optInt(j.l);
            }
            if (jSONObject.isNull("gro_id")) {
                dVar.m = 0;
            } else {
                dVar.m = jSONObject.optInt("gro_id");
            }
            if (jSONObject.isNull(l.a.b)) {
                dVar.u = 0;
            } else {
                dVar.u = jSONObject.optInt(l.a.b);
            }
            if (jSONObject.isNull("auto_refresh")) {
                dVar.v = 0;
            } else {
                dVar.v = jSONObject.optInt("auto_refresh");
            }
            if (jSONObject.isNull("auto_refresh_time")) {
                dVar.w = 0L;
            } else {
                dVar.w = jSONObject.optLong("auto_refresh_time");
            }
            if (jSONObject.isNull("s_t")) {
                dVar.x = 900000L;
            } else {
                dVar.x = jSONObject.optLong("s_t");
            }
            if (jSONObject.isNull(com.anythink.core.common.l.J)) {
                dVar.y = 1800000L;
            } else {
                dVar.y = jSONObject.optLong(com.anythink.core.common.l.J);
            }
            if (jSONObject.isNull("ra")) {
                dVar.z = -1;
            } else {
                dVar.z = jSONObject.optInt("ra");
            }
            if (jSONObject.isNull("asid")) {
                dVar.A = "";
            } else {
                dVar.A = jSONObject.optString("asid");
            }
            if (jSONObject.isNull("tp_ps")) {
                dVar.B = null;
            } else {
                try {
                    ag agVar = new ag();
                    JSONObject optJSONObject = jSONObject.optJSONObject("tp_ps");
                    agVar.a = optJSONObject.optInt("pucs") == 1;
                    agVar.b = optJSONObject.optLong("apdt");
                    agVar.c = optJSONObject.optInt("aprn");
                    agVar.d = optJSONObject.optInt("puas") == 1;
                    agVar.e = optJSONObject.optLong("cdt");
                    agVar.f = optJSONObject.optInt("ski_swt") == 1;
                    agVar.g = optJSONObject.optInt("aut_swt") == 1;
                    dVar.B = agVar;
                } catch (Exception e) {
                }
            }
            if (jSONObject.isNull("ug_list")) {
                dVar.n = "[]";
            } else {
                dVar.n = jSONObject.optString("ug_list");
            }
            if (jSONObject.isNull("ol_list")) {
                dVar.o = "[]";
            } else {
                dVar.o = jSONObject.optString("ol_list");
            }
            dVar.s = a(dVar.n, dVar.o);
            if (jSONObject.isNull("s2shb_list")) {
                dVar.p = "[]";
            } else {
                dVar.p = jSONObject.optString("s2shb_list");
            }
            if (jSONObject.isNull(a.g)) {
                dVar.aE = "[]";
            } else {
                dVar.aE = jSONObject.optString(a.g);
            }
            if (jSONObject.isNull(a.j)) {
                dVar.q = "[]";
            } else {
                dVar.q = jSONObject.optString(a.j);
            }
            if (jSONObject.isNull(a.k)) {
                dVar.r = "[]";
            } else {
                dVar.r = jSONObject.optString(a.k);
            }
            if (jSONObject.isNull(a.u)) {
                dVar.af = "";
            } else {
                dVar.af = jSONObject.optString(a.u);
            }
            if (jSONObject.isNull(a.w)) {
                dVar.aH = "[]";
            } else {
                dVar.aH = jSONObject.optString(a.w);
            }
            if (jSONObject.isNull("updateTime")) {
                dVar.aG = 0L;
                optLong = 0;
            } else {
                optLong = jSONObject.optLong("updateTime");
                dVar.aG = optLong;
            }
            if (jSONObject.isNull("t_g_id")) {
                dVar.C = -1;
            } else {
                dVar.C = jSONObject.optInt("t_g_id");
            }
            if (jSONObject.isNull("s_id")) {
                dVar.D = "";
            } else {
                dVar.D = jSONObject.optString("s_id");
            }
            if (jSONObject.isNull("u_n_f_sw")) {
                dVar.E = 0;
            } else {
                dVar.E = jSONObject.optInt("u_n_f_sw");
            }
            if (!jSONObject.isNull("m_o_s")) {
                dVar.T = u.c(jSONObject.optString("m_o_s"));
            }
            if (jSONObject.isNull("m_o")) {
                dVar.S = null;
            } else {
                dVar.S = a(jSONObject.optString("m_o"), jSONObject.optString("m_o_ks"), optLong, dVar.T);
            }
            if (jSONObject.isNull("p_m_o")) {
                dVar.F = 0;
            } else {
                dVar.F = jSONObject.optInt("p_m_o");
            }
            if (jSONObject.isNull(com.anythink.core.common.g.j.a)) {
                dVar.H = null;
            } else {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString(com.anythink.core.common.g.j.a));
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject2.opt(next));
                }
                dVar.H = hashMap;
            }
            if (!jSONObject.isNull("callback")) {
                JSONObject jSONObject3 = new JSONObject(jSONObject.optString("callback"));
                if (!jSONObject3.isNull("sc_list")) {
                    JSONObject jSONObject4 = new JSONObject(jSONObject3.optString("sc_list"));
                    HashMap hashMap2 = new HashMap();
                    Iterator<String> keys2 = jSONObject4.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        JSONObject jSONObject5 = new JSONObject(jSONObject4.optString(next2));
                        ATRewardInfo aTRewardInfo = new ATRewardInfo();
                        aTRewardInfo.rewardName = jSONObject5.optString("rw_n");
                        aTRewardInfo.rewardNumber = jSONObject5.optInt("rw_num");
                        hashMap2.put(next2, aTRewardInfo);
                    }
                    dVar.I = hashMap2;
                }
                if (!jSONObject3.isNull("reward")) {
                    JSONObject jSONObject6 = new JSONObject(jSONObject3.optString("reward"));
                    ATRewardInfo aTRewardInfo2 = new ATRewardInfo();
                    if (!jSONObject6.isNull("rw_n")) {
                        aTRewardInfo2.rewardName = jSONObject6.optString("rw_n");
                    }
                    if (!jSONObject6.isNull("rw_num")) {
                        aTRewardInfo2.rewardNumber = jSONObject6.optInt("rw_num");
                    }
                    dVar.J = aTRewardInfo2;
                }
                if (!jSONObject3.isNull("currency")) {
                    dVar.K = jSONObject3.optString("currency");
                }
                if (!jSONObject3.isNull("cc")) {
                    dVar.L = jSONObject3.optString("cc");
                }
                if (!jSONObject3.isNull("exch_r")) {
                    dVar.V = jSONObject3.optDouble("exch_r", 0.0d);
                }
                if (!jSONObject3.isNull("acct_cy")) {
                    dVar.W = jSONObject3.optString("acct_cy");
                }
            }
            if (jSONObject.isNull(a.a)) {
                dVar.M = 10000L;
            } else {
                dVar.M = jSONObject.optLong(a.a);
            }
            if (jSONObject.isNull(a.b)) {
                dVar.N = "";
            } else {
                dVar.N = jSONObject.optString(a.b);
            }
            if (jSONObject.isNull(a.c)) {
                dVar.O = 10000L;
            } else {
                dVar.O = jSONObject.optLong(a.c);
            }
            if (jSONObject.isNull(a.d)) {
                dVar.P = -1;
            } else {
                dVar.P = jSONObject.optInt(a.d);
            }
            if (jSONObject.isNull(a.e)) {
                dVar.Q = 900000L;
            } else {
                dVar.Q = jSONObject.optLong(a.e);
            }
            if (jSONObject.isNull(a.f)) {
                dVar.R = 2;
            } else {
                dVar.R = jSONObject.optInt(a.f);
            }
            if (jSONObject.isNull(a.i)) {
                dVar.aD = null;
            } else {
                dVar.aD = jSONObject.optString(a.i);
            }
            if (jSONObject.isNull(a.h)) {
                dVar.aF = "";
            } else {
                dVar.aF = jSONObject.optString(a.h);
            }
            if (jSONObject.isNull(a.l)) {
                dVar.U = 4000L;
            } else {
                dVar.U = jSONObject.optLong(a.l);
            }
            if (jSONObject.isNull(a.m)) {
                dVar.X = null;
            } else {
                JSONArray optJSONArray = jSONObject.optJSONArray(a.m);
                ArrayList arrayList = new ArrayList(3);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    arrayList.add(optJSONArray.optString(i2));
                    i = i2 + 1;
                }
                dVar.X = arrayList;
            }
            if (jSONObject.isNull(a.n)) {
                dVar.Y = "";
            } else {
                dVar.Y = jSONObject.optString(a.n);
            }
            if (jSONObject.isNull(a.o)) {
                dVar.Z = "";
            } else {
                dVar.Z = jSONObject.optString(a.o);
            }
            if (jSONObject.isNull(a.p)) {
                dVar.aa = "";
            } else {
                dVar.aa = jSONObject.optString(a.p);
            }
            if (jSONObject.isNull(a.q)) {
                dVar.ab = "";
            } else {
                dVar.ab = jSONObject.optString(a.q);
            }
            if (jSONObject.isNull(a.r)) {
                dVar.ac = 500L;
            } else {
                dVar.ac = jSONObject.optLong(a.r);
            }
            if (jSONObject.isNull(a.s)) {
                dVar.ad = "";
            } else {
                dVar.ad = jSONObject.optString(a.s);
            }
            if (jSONObject.isNull(a.t)) {
                dVar.ae = "";
            } else {
                dVar.ae = jSONObject.optString(a.t);
            }
            if (jSONObject.isNull(a.v)) {
                dVar.ag = 0.1614d;
            } else {
                dVar.ag = jSONObject.optDouble(a.v);
            }
            if (jSONObject.isNull(a.x)) {
                dVar.ah = "[]";
            } else {
                String optString = jSONObject.optString(a.x);
                dVar.ah = optString;
                dVar.aj = a(optString, 8);
            }
            if (jSONObject.isNull(a.y)) {
                dVar.ai = 1000L;
            } else {
                dVar.ai = jSONObject.optLong(a.y);
            }
            if (jSONObject.isNull(a.z)) {
                dVar.ak = 0L;
            } else {
                dVar.ak = jSONObject.optLong(a.z);
            }
            if (jSONObject.isNull(a.A)) {
                dVar.al = 2000L;
            } else {
                dVar.al = jSONObject.optLong(a.A);
            }
            if (jSONObject.isNull(a.B)) {
                dVar.am = -1L;
            } else {
                dVar.am = jSONObject.optLong(a.B);
            }
            if (jSONObject.isNull(a.C)) {
                dVar.an = 1;
            } else {
                dVar.an = jSONObject.optInt(a.C);
            }
            if (jSONObject.isNull(a.D)) {
                dVar.ao = 1;
            } else {
                dVar.ao = jSONObject.optInt(a.D);
            }
            if (jSONObject.isNull(a.E)) {
                dVar.ap = 2;
            } else {
                dVar.ap = jSONObject.optInt(a.E);
            }
            if (jSONObject.isNull(a.F)) {
                dVar.aq = 2000L;
            } else {
                dVar.aq = jSONObject.optLong(a.F);
            }
            if (jSONObject.isNull(a.G)) {
                dVar.aI = "[]";
            } else {
                dVar.aI = jSONObject.optString(a.G);
            }
            if (jSONObject.isNull("bid_floor")) {
                dVar.aJ = 0.0d;
            } else {
                dVar.aJ = jSONObject.optDouble("bid_floor");
            }
            if (jSONObject.isNull(a.I)) {
                dVar.ar = null;
            } else {
                dVar.ar = jSONObject.optJSONObject(a.I);
            }
            if (jSONObject.isNull(a.J)) {
                dVar.as = "";
            } else {
                dVar.as = jSONObject.optString(a.J);
            }
            if (jSONObject.isNull(a.K)) {
                dVar.aK = 0;
            } else {
                dVar.aK = jSONObject.optInt(a.K);
            }
            if (jSONObject.isNull(a.L)) {
                dVar.aL = 2;
            } else {
                dVar.aL = jSONObject.optInt(a.L);
            }
            try {
                dVar.t = a(dVar.p, dVar.aE, dVar.q, dVar.r, dVar.af, dVar.aH, dVar.aI);
            } catch (Exception e2) {
            }
            if (jSONObject.isNull(a.M)) {
                dVar.aN = 0;
            } else {
                dVar.aN = jSONObject.optInt(a.M);
            }
            if (jSONObject.isNull(a.N)) {
                dVar.aM = 0;
            } else {
                dVar.aM = jSONObject.optInt(a.N);
            }
            if (jSONObject.isNull("is_test")) {
                dVar.aC = 2;
            } else {
                dVar.aC = jSONObject.optInt("is_test");
            }
            dVar.at = jSONObject.optJSONObject(a.R);
            if (jSONObject.isNull("mdna_r")) {
                dVar.au = 1;
            } else {
                dVar.au = jSONObject.optInt("mdna_r");
            }
            if (jSONObject.isNull(a.T)) {
                dVar.av = "";
            } else {
                dVar.av = jSONObject.optString(a.T);
            }
            if (jSONObject.isNull(a.U)) {
                dVar.aw = "";
            } else {
                dVar.aw = jSONObject.optString(a.U);
            }
            if (jSONObject.isNull(a.V)) {
                dVar.ax = 2;
            } else {
                dVar.ax = jSONObject.optInt(a.V);
            }
            if (jSONObject.isNull(a.W)) {
                dVar.ay = 1;
            } else {
                dVar.ay = jSONObject.optInt(a.W);
            }
            if (jSONObject.isNull(a.X)) {
                dVar.az = new ArrayList(1);
            } else {
                ArrayList arrayList2 = new ArrayList(3);
                JSONArray optJSONArray2 = jSONObject.optJSONArray(a.X);
                if (optJSONArray2 != null) {
                    int length = optJSONArray2.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        arrayList2.add(Integer.valueOf(optJSONArray2.optInt(i3)));
                    }
                }
                dVar.az = arrayList2;
            }
            if (jSONObject.isNull(a.Y)) {
                dVar.aA = 2;
            } else {
                dVar.aA = jSONObject.optInt(a.Y);
            }
            if (jSONObject.isNull(a.Z)) {
                dVar.aB = 1;
                return dVar;
            }
            dVar.aB = jSONObject.optInt(a.Z);
            return dVar;
        } catch (Exception e3) {
            return null;
        }
    }

    private void b(double d) {
        this.V = d;
    }

    private void b(int i) {
        this.au = i;
    }

    private void b(long j) {
        this.am = j;
    }

    private void b(List<ai> list) {
        this.aj = list;
    }

    private void b(Map<String, Object> map) {
        this.H = map;
    }

    private void b(JSONObject jSONObject) {
        this.ar = jSONObject;
    }

    public static List<ai> c(String str) {
        return a(str, 8);
    }

    private void c(double d) {
        this.aJ = d;
    }

    private void c(int i) {
        this.aC = i;
    }

    private void c(long j) {
        this.ai = j;
    }

    private void c(List<String> list) {
        this.X = list;
    }

    public static List<ai> d(String str) {
        List<ai> a2 = a(str, 2);
        for (ai aiVar : a2) {
            aiVar.aj();
        }
        return a2;
    }

    private void d(int i) {
        this.ap = i;
    }

    private void d(long j) {
        this.ac = j;
    }

    private void d(List<s> list) {
        this.S = list;
    }

    private void e(int i) {
        this.an = i;
    }

    private void e(long j) {
        this.U = j;
    }

    private void e(List<ai> list) {
        this.s = list;
    }

    private void f(int i) {
        this.ao = i;
    }

    private void f(long j) {
        this.M = j;
    }

    private void f(String str) {
        this.aw = str;
    }

    private void f(List<ai> list) {
        this.t = list;
    }

    private void g(int i) {
        this.F = i;
    }

    private void g(long j) {
        this.x = j;
    }

    private void g(String str) {
        this.av = str;
    }

    private void h(int i) {
        this.C = i;
    }

    private void h(long j) {
        this.y = j;
    }

    private void h(String str) {
        this.as = str;
    }

    private void i(int i) {
        this.E = i;
    }

    private void i(long j) {
        this.w = j;
    }

    private void i(String str) {
        this.ah = str;
    }

    private void j(int i) {
        this.z = i;
    }

    private void j(long j) {
        this.b = j;
    }

    private void j(String str) {
        this.ad = str;
    }

    private void k(int i) {
        this.v = i;
    }

    private void k(long j) {
        this.c = j;
    }

    private void k(String str) {
        this.ae = str;
    }

    private void l(int i) {
        this.u = i;
    }

    private void l(long j) {
        this.g = j;
    }

    private void l(String str) {
        this.af = str;
    }

    private void m(int i) {
        this.d = i;
    }

    private void m(long j) {
        this.h = j;
    }

    private void m(String str) {
        this.Z = str;
    }

    private void n(int i) {
        this.e = i;
    }

    private void n(long j) {
        this.i = j;
    }

    private void n(String str) {
        this.Y = str;
    }

    private void o(int i) {
        this.f = i;
    }

    private void o(long j) {
        this.aG = j;
    }

    private void o(String str) {
        this.W = str;
    }

    private void p(int i) {
        this.j = i;
    }

    private void p(long j) {
        this.O = j;
    }

    private void p(String str) {
        this.r = str;
    }

    private void q(int i) {
        this.k = i;
    }

    private void q(long j) {
        this.Q = j;
    }

    private void q(String str) {
        this.aD = str;
    }

    private void r(int i) {
        this.l = i;
    }

    private void r(long j) {
        this.ak = j;
    }

    private void r(String str) {
        this.aF = str;
    }

    private void s(int i) {
        this.m = i;
    }

    private void s(long j) {
        this.al = j;
    }

    private void s(String str) {
        this.aE = str;
    }

    private void t(int i) {
        this.P = i;
    }

    private void t(String str) {
        this.N = str;
    }

    private void u(int i) {
        this.R = i;
    }

    private void u(String str) {
        this.K = str;
    }

    private void v(int i) {
        this.aL = i;
    }

    private void v(String str) {
        this.L = str;
    }

    private void w(int i) {
        this.aK = i;
    }

    private void w(String str) {
        this.D = str;
    }

    private void x(int i) {
        this.aM = i;
    }

    private void x(String str) {
        this.A = str;
    }

    private void y(int i) {
        this.aN = i;
    }

    private void y(String str) {
        this.n = str;
    }

    private void z(int i) {
        this.ax = i;
    }

    private void z(String str) {
        this.o = str;
    }

    public final String A() {
        return this.r;
    }

    public final String B() {
        return this.aD;
    }

    public final String C() {
        return this.aE;
    }

    public final u D() {
        return this.T;
    }

    public final List<s> E() {
        return this.S;
    }

    public final List<ai> F() {
        return this.s;
    }

    public final List<ai> G() {
        return this.t;
    }

    public final long H() {
        return this.M;
    }

    public final Map<String, ATRewardInfo> I() {
        return this.I;
    }

    public final String J() {
        return this.K;
    }

    public final String K() {
        return this.L;
    }

    public final ATRewardInfo L() {
        return this.J;
    }

    public final Map<String, Object> M() {
        return this.H;
    }

    public final int N() {
        return this.F;
    }

    public final int O() {
        return this.C;
    }

    public final String P() {
        return this.D;
    }

    public final int Q() {
        return this.E;
    }

    public final long R() {
        return this.x;
    }

    public final long S() {
        return this.y;
    }

    public final int T() {
        return this.z;
    }

    public final String U() {
        return this.A;
    }

    public final int V() {
        return this.v;
    }

    public final long W() {
        return this.w;
    }

    public final int X() {
        return this.u;
    }

    public final long Y() {
        return this.c;
    }

    public final int Z() {
        return this.d;
    }

    public final int a() {
        return this.aA;
    }

    public final Map<String, Object> a(String str, String str2, ai aiVar) {
        m N;
        Map<String, Object> c = h.c(aiVar.g());
        boolean b = g.b();
        com.anythink.core.c.a b2 = b.a(n.a().g()).b(n.a().p());
        if (!TextUtils.isEmpty(aiVar.y())) {
            c.put("payload", aiVar.y());
        }
        if (!TextUtils.isEmpty(aiVar.R())) {
            c.put("custom_inhouse_bid_result", aiVar.R());
        }
        c.put(g.k.c, Boolean.valueOf(b2.p() == 3));
        boolean z = false;
        if (b2.q() == 2) {
            z = false;
            if (b) {
                z = true;
            }
        }
        c.put(g.k.d, Boolean.valueOf(z));
        c.put(g.k.e, Boolean.valueOf(p.a(n.a().g()).c()));
        c.put("ad_type", Integer.valueOf(aiVar.Y()));
        if (this.ay == 1) {
            c.put(g.k.m, str + BridgeUtil.UNDERLINE_STR + this.C + BridgeUtil.UNDERLINE_STR + this.m);
        }
        c.put(g.k.n, v.a().g(str));
        if (aiVar.c() == 28 && (N = aiVar.N()) != null) {
            c.put(g.k.o, Double.valueOf(com.anythink.core.common.k.g.a(aiVar) * N.l));
        }
        String l = com.anythink.core.common.k.d.l();
        if (!TextUtils.isEmpty(l)) {
            c.put(ATAdConst.KEY.WECHAT_APPID, l);
        }
        if (aiVar.c() == 35 || aiVar.l() == 3 || aiVar.l() == 4 || aiVar.l() == 7) {
            com.anythink.core.common.e.j jVar = new com.anythink.core.common.e.j();
            jVar.a = aiVar.y();
            jVar.f = aiVar.c();
            jVar.c = aiVar.t();
            jVar.d = str2;
            jVar.b = str;
            jVar.h = this.C;
            jVar.i = this.m;
            jVar.j = this.u;
            jVar.g = aiVar.d();
            m N2 = aiVar.N();
            jVar.k = N2 != null ? N2.g : "";
            jVar.l = N2 != null ? N2.h : "";
            if (aiVar.c() == 35) {
                jVar.m = this.T;
            } else {
                jVar.m = ab.c(this.aF);
            }
            if (jVar.m != null) {
                jVar.m.q(this.u);
            }
            jVar.n = N2 != null ? N2.f : 0L;
            c.put(g.k.a, jVar);
        }
        if (aiVar.ai()) {
            c.put(g.k.i, this.ar);
        }
        if (aiVar.c() == 50 && this.aB == 1) {
            c.put(g.k.q, str2);
        }
        if (aiVar.c() == 46) {
            ATAdConst.CURRENCY currency = ATAdConst.CURRENCY.RMB;
            if (TextUtils.equals(aiVar.ah(), "USD")) {
                currency = ATAdConst.CURRENCY.USD;
            }
            c.put(g.k.r, currency);
        }
        return c;
    }

    public final boolean a(String str) {
        List<ai> list = this.t;
        if (list == null) {
            return false;
        }
        for (ai aiVar : list) {
            if (TextUtils.equals(str, aiVar.t())) {
                return true;
            }
        }
        return false;
    }

    public final int aa() {
        return this.f;
    }

    public final long ab() {
        return this.g;
    }

    public final long ac() {
        return this.h;
    }

    public final long ad() {
        return this.i;
    }

    public final int ae() {
        return this.m;
    }

    public final String af() {
        return this.n;
    }

    public final String ag() {
        return this.o;
    }

    public final String ah() {
        return this.p;
    }

    public final String ai() {
        return this.q;
    }

    public final long aj() {
        return this.O;
    }

    public final int ak() {
        return this.P;
    }

    public final long al() {
        return this.Q;
    }

    public final int am() {
        return this.R;
    }

    public final String an() {
        return this.ab;
    }

    public final String ao() {
        return this.aH;
    }

    public final String ap() {
        return this.aI;
    }

    public final int aq() {
        return this.aL;
    }

    public final int ar() {
        return this.aK;
    }

    public final double as() {
        return this.aJ;
    }

    public final int at() {
        return this.aM;
    }

    public final int au() {
        return this.aN;
    }

    public final int av() {
        return this.ax;
    }

    public final boolean aw() {
        return this.e == 1;
    }

    public final boolean ax() {
        new StringBuilder("Already cache time -- > ").append(System.currentTimeMillis() - this.aG);
        return System.currentTimeMillis() - this.aG > this.b;
    }

    public final List<Integer> b() {
        return this.az;
    }

    public final String c() {
        return this.aw;
    }

    public final int d() {
        return this.au;
    }

    public final s e(String str) {
        List<s> list = this.S;
        if (list != null) {
            for (s sVar : list) {
                if (sVar.k() == null) {
                    sVar.a((k) this.T);
                }
                if (TextUtils.equals(str, sVar.p()) && !sVar.a(this.T)) {
                    return sVar;
                }
            }
            return null;
        }
        return null;
    }

    public final String e() {
        return this.av;
    }

    public final JSONObject f() {
        return this.at;
    }

    public final String g() {
        return this.as;
    }

    public final int h() {
        return this.aC;
    }

    public final long i() {
        return this.aq;
    }

    public final int j() {
        return this.ap;
    }

    public final int k() {
        return this.an;
    }

    public final int l() {
        int i = this.an;
        if (i != 1) {
            if (i != 2) {
                return 1;
            }
            return this.ao;
        }
        return this.f;
    }

    public final long m() {
        return this.am;
    }

    public final String n() {
        return this.ah;
    }

    public final long o() {
        return this.ai;
    }

    public final double p() {
        return this.ag;
    }

    public final String q() {
        return this.ad;
    }

    public final String r() {
        return this.ae;
    }

    public final String s() {
        return this.af;
    }

    public final long t() {
        return this.ac;
    }

    public final String u() {
        return this.Z;
    }

    public final String v() {
        return this.Y;
    }

    public final List<String> w() {
        return this.X;
    }

    public final double x() {
        return this.V;
    }

    public final String y() {
        return this.W;
    }

    public final long z() {
        return this.U;
    }
}
