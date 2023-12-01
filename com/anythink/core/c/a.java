package com.anythink.core.c;

import android.text.TextUtils;
import com.anythink.core.common.e.n;
import com.anythink.core.common.e.v;
import com.cdo.oaps.ad.OapsKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/c/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6411a = a.class.getSimpleName();
    private Map A;
    private String B;
    private String C;
    private String D;
    private String E;
    private ConcurrentHashMap<String, v> F;
    private int G;
    private int H;
    private Map<String, String> I;
    private Map<String, String> J;
    private Map<String, String> K;
    private Map<String, Map<String, String>> L;
    private Map<String, Map<String, String>> M;
    private int N;
    private String O;
    private int P;
    private String Q;
    private int R;
    private String S;
    private String T;
    private String U;
    private c V;
    private n W;
    private int X;
    private int Y;
    private String Z;
    private String aa;
    private String ab;
    private String ac;
    private String ad;
    private String ae;
    private String af;
    private String ag;
    private int ah;
    private String ai;
    private String aj;
    private String ak;
    private int al;
    private int am;
    private int an;
    private int ao;
    private String ap;
    private String aq;
    protected boolean b;

    /* renamed from: c  reason: collision with root package name */
    Map<String, Object> f6412c;
    private long d;
    private String e;
    private long f;
    private int g;
    private int h;
    private String i;
    private String j;
    private int k;
    private long l;
    private String m;
    private String n;
    private String o;
    private int p;
    private long q;
    private int[] r;
    private String s;
    private int t;
    private long u;
    private String v;
    private String w;
    private long x;
    private long y;
    private int z;

    /* renamed from: com.anythink.core.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/c/a$a.class */
    static final class C0093a {
        private static String A = "t_c";
        private static String B = "data_level";
        private static String C = "psid_hl";
        private static String D = "la_sw";
        private static String E = "da_rt_keys_ft";
        private static String F = "tk_no_t_ft";
        private static String G = "da_not_keys_ft";
        private static String H = "abtest_id";
        private static String I = "crash_sw";
        private static String J = "crash_list";
        private static String K = "tcp_domain";
        private static String L = "tcp_port";
        private static String M = "tcp_tk_da_type";
        private static String N = "tcp_rate";
        private static String O = "sy_id";
        private static String P = "adx";
        private static String Q = "req_addr";
        private static String R = "bid_addr";
        private static String S = "tk_addr";
        private static String T = "ol_req_addr";
        private static String U = "ofm_data";
        private static String V = "ccpa_sw";
        private static String W = "coppa_sw";
        private static String X = "tk_no_nt_t";
        private static String Y = "da_no_nt_k";
        private static String Z = "s2s_addr";

        /* renamed from: a  reason: collision with root package name */
        public static String f6413a = "pil";
        private static String aa = "cn_gdpr_nu";
        private static String ab = "cn_s2s_addr";
        private static String ac = "cn_req_addr";
        private static String ad = "cn_bid_addr";
        private static String ae = "cn_tk_addr";
        private static String af = "cn_ol_req_addr";
        private static String ag = "cn_tk_address";
        private static String ah = "cn_da_address";
        private static String ai = "cn_tcp_domain";
        private static String aj = "cn_tcp_port";
        private static String ak = "oid";
        private static String al = "rak";
        private static String am = "show_delay_url";
        private static String an = "show_delay_text";
        private static String ao = "store_wakup";
        private static String ap = "mdna_capi_sw";
        private static String aq = "mdna_s_sw";

        /* renamed from: ar  reason: collision with root package name */
        private static String f6414ar = "mdna_c_sw";
        private static String as = "admob_m_sw";
        public static String b = "tk_rt_sp_ft";

        /* renamed from: c  reason: collision with root package name */
        public static String f6415c = "da_rt_sp_ft";
        public static String d = "lrqf_interval";
        private static String e = "scet";
        private static String f = "req_ver";
        private static String g = "gdpr_sdcs";
        private static String h = "gdpr_so";
        private static String i = "gdpr_nu";
        private static String j = "gdpr_a";
        private static String k = "gdpr_ia";
        private static String l = "pl_n";
        private static String m = "upid";
        private static String n = "logger";
        private static String o = "tk_address";
        private static String p = "tk_max_amount";
        private static String q = "tk_interval";
        private static String r = "da_address";
        private static String s = "da_max_amount";
        private static String t = "da_interval";
        private static String u = "n_psid_tm";
        private static String v = "c_a";
        private static String w = "tk_firm";
        private static String x = "n_l";
        private static String y = "preinit";
        private static String z = "nw_eu_def";

        C0093a() {
        }
    }

    private void A(String str) {
        this.j = str;
    }

    private void B(String str) {
        this.n = str;
    }

    private void C(String str) {
        this.Z = str;
    }

    private void D(String str) {
        this.aa = str;
    }

    private void a(c cVar) {
        this.V = cVar;
    }

    private void a(n nVar) {
        this.W = nVar;
    }

    private void a(Map map) {
        this.A = map;
    }

    private void a(ConcurrentHashMap<String, v> concurrentHashMap) {
        this.F = concurrentHashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
        if (r0.a() != 2) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean am() {
        /*
            com.anythink.core.common.b.n r0 = com.anythink.core.common.b.n.a()
            android.content.Context r0 = r0.g()
            com.anythink.core.c.b r0 = com.anythink.core.c.b.a(r0)
            com.anythink.core.common.b.n r1 = com.anythink.core.common.b.n.a()
            java.lang.String r1 = r1.p()
            com.anythink.core.c.a r0 = r0.b(r1)
            r5 = r0
            r0 = 0
            r4 = r0
            r0 = r5
            if (r0 == 0) goto L26
            r0 = r5
            int r0 = r0.z
            r1 = 1
            if (r0 != r1) goto L26
            r0 = 1
            r3 = r0
            goto L28
        L26:
            r0 = 0
            r3 = r0
        L28:
            com.anythink.core.common.b.n r0 = com.anythink.core.common.b.n.a()
            android.content.Context r0 = r0.g()
            com.anythink.core.common.b.p r0 = com.anythink.core.common.b.p.a(r0)
            r6 = r0
            r0 = r5
            boolean r0 = r0.b
            if (r0 == 0) goto L44
            r0 = r6
            int r0 = r0.a()
            r1 = 2
            if (r0 == r1) goto L5d
            goto L5b
        L44:
            r0 = r6
            int r0 = r0.a()
            r1 = 2
            if (r0 != r1) goto L5b
            r0 = r5
            int r0 = r0.k
            if (r0 != 0) goto L55
            r0 = 0
            return r0
        L55:
            r0 = r3
            if (r0 == 0) goto L5b
            r0 = 0
            return r0
        L5b:
            r0 = 1
            r4 = r0
        L5d:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.c.a.am():boolean");
    }

    private String an() {
        return this.U;
    }

    private ConcurrentHashMap<String, v> ao() {
        return this.F;
    }

    private String ap() {
        return this.B;
    }

    private String aq() {
        return this.ac;
    }

    private String ar() {
        return this.ad;
    }

    private String as() {
        return this.ae;
    }

    private String at() {
        return this.af;
    }

    private String au() {
        return this.ag;
    }

    private int av() {
        return this.ah;
    }

    private String aw() {
        return this.e;
    }

    private String ax() {
        return this.j;
    }

    private String ay() {
        return this.n;
    }

    private Map<String, Object> az() {
        return this.f6412c;
    }

    private void b(int i) {
        this.X = i;
    }

    private void b(Map<String, String> map) {
        this.I = map;
    }

    private void c(int i) {
        this.Y = i;
    }

    private void c(Map<String, String> map) {
        this.J = map;
    }

    private void d(int i) {
        this.P = i;
    }

    private void d(Map<String, String> map) {
        this.K = map;
    }

    private void e(int i) {
        this.R = i;
    }

    private void e(Map<String, Object> map) {
        this.f6412c = map;
    }

    public static a f(String str) {
        JSONObject jSONObject;
        Iterator<String> keys;
        HashMap hashMap;
        if (str == null || "".equals(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.isNull(C0093a.f)) {
                aVar.e = "unkown";
            } else {
                aVar.e = jSONObject2.optString(C0093a.f);
            }
            if (jSONObject2.isNull(C0093a.e)) {
                aVar.d = 7200000L;
            } else {
                aVar.d = jSONObject2.optLong(C0093a.e);
            }
            if (jSONObject2.isNull(C0093a.g)) {
                aVar.g = 0;
            } else {
                aVar.g = jSONObject2.optInt(C0093a.g);
            }
            if (jSONObject2.isNull(C0093a.h)) {
                aVar.h = 0;
            } else {
                aVar.h = jSONObject2.optInt(C0093a.h);
            }
            if (jSONObject2.isNull(C0093a.i)) {
                aVar.i = "";
            } else {
                aVar.i = jSONObject2.optString(C0093a.i);
            }
            if (jSONObject2.isNull(C0093a.j)) {
                aVar.j = "[\"AT\",\"BE\",\"BG\",\"HR\",\"CY\",\"CZ\",\"DK\",\"EE\",\"FI\",\"FR\",\"DE\",\"GR\",\"HU\",\"IS\",\"IE\",\"IT\",\"LV\",\"LI\",\"LT\",\"LU\",\"MT\",\"NL\",\"NO\",\"PL\",\"PT\",\"RO\",\"SK\",\"SI\",\"ES\",\"SE\",\"GB\",\"UK\"]";
            } else {
                aVar.j = jSONObject2.optString(C0093a.j);
            }
            if (jSONObject2.isNull(C0093a.k)) {
                aVar.k = 0;
            } else {
                aVar.k = jSONObject2.optInt(C0093a.k);
            }
            if (jSONObject2.isNull(C0093a.l)) {
                aVar.l = 5000L;
            } else {
                aVar.l = jSONObject2.optLong(C0093a.l);
            }
            if (!jSONObject2.isNull(C0093a.n)) {
                JSONObject optJSONObject = jSONObject2.optJSONObject(C0093a.n);
                aVar.n = optJSONObject.toString();
                aVar.o = optJSONObject.optString(C0093a.o);
                aVar.p = optJSONObject.optInt(C0093a.p);
                aVar.q = optJSONObject.optLong(C0093a.q);
                aVar.s = optJSONObject.optString(C0093a.r);
                aVar.t = optJSONObject.optInt(C0093a.s);
                aVar.u = optJSONObject.optLong(C0093a.t);
                ConcurrentHashMap<String, v> concurrentHashMap = new ConcurrentHashMap<>();
                try {
                    if (!optJSONObject.isNull(C0093a.w)) {
                        JSONObject jSONObject3 = new JSONObject(optJSONObject.optString(C0093a.w));
                        Iterator<String> keys2 = jSONObject3.keys();
                        while (keys2.hasNext()) {
                            String next = keys2.next();
                            v vVar = new v();
                            JSONObject optJSONObject2 = jSONObject3.optJSONObject(next);
                            vVar.f6678a = optJSONObject2.optInt("tk_fi_re_sw");
                            vVar.b = optJSONObject2.optInt("tk_im_sw");
                            vVar.f6679c = optJSONObject2.optInt("tk_sh_sw");
                            vVar.d = optJSONObject2.optInt("tk_ck_sw");
                            vVar.e = optJSONObject2.optString("pg_m_li");
                            concurrentHashMap.put(next, vVar);
                        }
                    }
                } catch (Exception e) {
                }
                aVar.F = concurrentHashMap;
                if (optJSONObject.isNull(C0093a.E)) {
                    aVar.I = null;
                } else {
                    JSONObject jSONObject4 = new JSONObject(optJSONObject.optString(C0093a.E));
                    Iterator<String> keys3 = jSONObject4.keys();
                    HashMap hashMap2 = new HashMap();
                    while (keys3.hasNext()) {
                        String next2 = keys3.next();
                        hashMap2.put(next2, jSONObject4.optString(next2));
                    }
                    aVar.I = hashMap2;
                }
                if (optJSONObject.isNull(C0093a.G)) {
                    aVar.K = null;
                } else {
                    JSONObject jSONObject5 = new JSONObject(optJSONObject.optString(C0093a.G));
                    Iterator<String> keys4 = jSONObject5.keys();
                    HashMap hashMap3 = new HashMap();
                    while (keys4.hasNext()) {
                        String next3 = keys4.next();
                        hashMap3.put(next3, jSONObject5.optString(next3));
                    }
                    aVar.K = hashMap3;
                }
                if (optJSONObject.isNull(C0093a.F)) {
                    aVar.J = null;
                } else {
                    JSONObject jSONObject6 = new JSONObject(optJSONObject.optString(C0093a.F));
                    Iterator<String> keys5 = jSONObject6.keys();
                    HashMap hashMap4 = new HashMap();
                    while (keys5.hasNext()) {
                        String next4 = keys5.next();
                        hashMap4.put(next4, jSONObject6.optString(next4));
                    }
                    aVar.J = hashMap4;
                }
                aVar.Q = optJSONObject.optString(C0093a.K);
                aVar.R = optJSONObject.optInt(C0093a.L);
                aVar.P = optJSONObject.optInt(C0093a.M);
                aVar.S = optJSONObject.optString(C0093a.N);
                if (optJSONObject.isNull(C0093a.X)) {
                    aVar.Z = null;
                } else {
                    aVar.Z = optJSONObject.optString(C0093a.X);
                }
                if (optJSONObject.isNull(C0093a.Y)) {
                    aVar.aa = null;
                } else {
                    aVar.aa = optJSONObject.optString(C0093a.Y);
                }
                if (!optJSONObject.isNull(C0093a.ag)) {
                    aVar.ae = optJSONObject.optString(C0093a.ag);
                }
                if (!optJSONObject.isNull(C0093a.ah)) {
                    aVar.af = optJSONObject.optString(C0093a.ah);
                }
                if (!optJSONObject.isNull(C0093a.ai)) {
                    aVar.ag = optJSONObject.optString(C0093a.ai);
                }
                if (!optJSONObject.isNull(C0093a.aj)) {
                    aVar.ah = optJSONObject.optInt(C0093a.aj);
                }
                if (optJSONObject.isNull(C0093a.b)) {
                    aVar.L = null;
                } else {
                    try {
                        jSONObject = new JSONObject(optJSONObject.optString(C0093a.b));
                        keys = jSONObject.keys();
                        hashMap = new HashMap();
                    } catch (Throwable th) {
                    }
                    while (true) {
                        if (!keys.hasNext()) {
                            break;
                        }
                        String next5 = keys.next();
                        HashMap hashMap5 = new HashMap();
                        JSONObject jSONObject7 = new JSONObject(jSONObject.optString(next5));
                        JSONArray optJSONArray = jSONObject7.optJSONArray(OapsKey.KEY_IDS);
                        String optString = jSONObject7.optString("formats");
                        if (optJSONArray.length() > 0 && !TextUtils.isEmpty(optString)) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                try {
                                    hashMap5.put(optJSONArray.optString(i), optString);
                                } catch (Throwable th2) {
                                }
                            }
                        }
                        hashMap.put(next5, hashMap5);
                        aVar.L = null;
                    }
                    aVar.L = hashMap;
                }
                if (optJSONObject.isNull(C0093a.f6415c)) {
                    aVar.M = null;
                } else {
                    JSONObject jSONObject8 = new JSONObject(optJSONObject.optString(C0093a.f6415c));
                    Iterator<String> keys6 = jSONObject8.keys();
                    HashMap hashMap6 = new HashMap();
                    while (keys6.hasNext()) {
                        String next6 = keys6.next();
                        HashMap hashMap7 = new HashMap();
                        JSONObject jSONObject9 = new JSONObject(jSONObject8.optString(next6));
                        JSONArray optJSONArray2 = jSONObject9.optJSONArray(OapsKey.KEY_IDS);
                        String optString2 = jSONObject9.optString("formats");
                        if (optJSONArray2.length() > 0 && !TextUtils.isEmpty(optString2)) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 < optJSONArray2.length()) {
                                    hashMap7.put(optJSONArray2.optString(i3), optString2);
                                    i2 = i3 + 1;
                                }
                            }
                        }
                        hashMap6.put(next6, hashMap7);
                    }
                    aVar.M = hashMap6;
                }
            }
            if (!jSONObject2.isNull(C0093a.u)) {
                aVar.x = jSONObject2.optLong(C0093a.u);
            }
            if (!jSONObject2.isNull(C0093a.v)) {
                aVar.y = jSONObject2.optLong(C0093a.v);
            }
            if (!jSONObject2.isNull(C0093a.x)) {
                JSONObject jSONObject10 = new JSONObject(jSONObject2.optString(C0093a.x));
                Iterator<String> keys7 = jSONObject10.keys();
                HashMap hashMap8 = new HashMap();
                while (keys7.hasNext()) {
                    String next7 = keys7.next();
                    hashMap8.put(next7, jSONObject10.optString(next7));
                }
                aVar.A = hashMap8;
            }
            if (!jSONObject2.isNull(C0093a.A)) {
                aVar.C = jSONObject2.optString(C0093a.A);
            }
            if (!jSONObject2.isNull(C0093a.z)) {
                aVar.z = jSONObject2.optInt(C0093a.z);
            }
            if (!jSONObject2.isNull(C0093a.B)) {
                aVar.D = jSONObject2.optString(C0093a.B);
            }
            if (jSONObject2.isNull(C0093a.C)) {
                aVar.G = 60000;
            } else {
                aVar.G = jSONObject2.optInt(C0093a.C);
            }
            if (jSONObject2.isNull(C0093a.D)) {
                aVar.H = 0;
            } else {
                aVar.H = jSONObject2.optInt(C0093a.D);
            }
            if (jSONObject2.isNull(C0093a.H)) {
                aVar.E = "";
            } else {
                aVar.E = jSONObject2.optString(C0093a.H);
            }
            if (jSONObject2.isNull(C0093a.I)) {
                aVar.N = 1;
            } else {
                aVar.N = jSONObject2.optInt(C0093a.I);
            }
            if (jSONObject2.isNull(C0093a.J)) {
                aVar.O = "";
            } else {
                aVar.O = jSONObject2.optString(C0093a.J);
            }
            if (jSONObject2.isNull(C0093a.O)) {
                aVar.T = "";
            } else {
                aVar.T = jSONObject2.optString(C0093a.O);
            }
            if (jSONObject2.isNull(C0093a.P)) {
                aVar.W = null;
            } else {
                n nVar = new n();
                JSONObject optJSONObject3 = jSONObject2.optJSONObject(C0093a.P);
                nVar.b(optJSONObject3.optString(C0093a.Q));
                nVar.c(optJSONObject3.optString(C0093a.R));
                nVar.d(optJSONObject3.optString(C0093a.S));
                nVar.a(optJSONObject3.optString(C0093a.T));
                if (!jSONObject2.isNull(C0093a.ac)) {
                    nVar.e(optJSONObject3.optString(C0093a.ac));
                }
                if (!jSONObject2.isNull(C0093a.ad)) {
                    nVar.f(optJSONObject3.optString(C0093a.ad));
                }
                if (!jSONObject2.isNull(C0093a.ae)) {
                    nVar.g(optJSONObject3.optString(C0093a.ae));
                }
                if (!jSONObject2.isNull(C0093a.af)) {
                    nVar.h(optJSONObject3.optString(C0093a.af));
                }
                aVar.W = nVar;
            }
            aVar.V = c.a(jSONObject2.optString(C0093a.U));
            if (jSONObject2.isNull("custom")) {
                aVar.f6412c = null;
            } else {
                try {
                    JSONObject jSONObject11 = new JSONObject(jSONObject2.optString("custom"));
                    HashMap hashMap9 = new HashMap();
                    Iterator<String> keys8 = jSONObject11.keys();
                    while (keys8.hasNext()) {
                        String next8 = keys8.next();
                        hashMap9.put(next8, jSONObject11.opt(next8));
                    }
                    aVar.f6412c = hashMap9;
                } catch (Throwable th3) {
                }
            }
            aVar.X = jSONObject2.optInt(C0093a.V);
            aVar.Y = jSONObject2.optInt(C0093a.W);
            aVar.ab = jSONObject2.optString(C0093a.Z);
            if (!jSONObject2.isNull(C0093a.aa)) {
                aVar.ac = jSONObject2.optString(C0093a.aa);
            }
            if (!jSONObject2.isNull(C0093a.ab)) {
                aVar.ad = jSONObject2.optString(C0093a.ab);
            }
            if (!jSONObject2.isNull(C0093a.am)) {
                aVar.ai = jSONObject2.optString(C0093a.am);
            }
            if (!jSONObject2.isNull(C0093a.an)) {
                aVar.aj = jSONObject2.optString(C0093a.an);
            }
            if (jSONObject2.isNull(C0093a.ao)) {
                aVar.ak = "1";
            } else {
                aVar.ak = jSONObject2.optString(C0093a.ao);
            }
            if (!jSONObject2.isNull(C0093a.ap)) {
                aVar.al = jSONObject2.optInt(C0093a.ap);
            }
            if (!jSONObject2.isNull(C0093a.aq)) {
                aVar.an = jSONObject2.optInt(C0093a.aq);
            }
            if (!jSONObject2.isNull(C0093a.f6414ar)) {
                aVar.am = jSONObject2.optInt(C0093a.f6414ar);
            }
            if (jSONObject2.isNull(C0093a.as)) {
                aVar.ao = 1;
            } else {
                aVar.ao = jSONObject2.optInt(C0093a.as);
            }
            if (!jSONObject2.isNull(C0093a.f6413a)) {
                aVar.ap = jSONObject2.optString(C0093a.f6413a);
            }
            if (!jSONObject2.isNull(C0093a.d)) {
                aVar.aq = jSONObject2.optString(C0093a.d);
            }
            return aVar;
        } catch (Exception e2) {
            return aVar;
        }
    }

    private void f(int i) {
        this.z = i;
    }

    private void f(Map<String, Map<String, String>> map) {
        this.L = map;
    }

    private void g(int i) {
        this.ah = i;
    }

    private void g(String str) {
        this.aq = str;
    }

    private void g(Map<String, Map<String, String>> map) {
        this.M = map;
    }

    private void h(int i) {
        this.g = i;
    }

    private void h(String str) {
        this.ap = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x007b, code lost:
        if (r0.a() != 2) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(java.util.Map<java.lang.String, java.lang.Object> r4) {
        /*
            com.anythink.core.common.b.n r0 = com.anythink.core.common.b.n.a()
            android.content.Context r0 = r0.g()
            com.anythink.core.c.b r0 = com.anythink.core.c.b.a(r0)
            com.anythink.core.common.b.n r1 = com.anythink.core.common.b.n.a()
            java.lang.String r1 = r1.p()
            com.anythink.core.c.a r0 = r0.b(r1)
            r8 = r0
            r0 = 0
            r7 = r0
            r0 = r8
            if (r0 == 0) goto L29
            r0 = r8
            int r0 = r0.k
            r1 = 1
            if (r0 != r1) goto L29
            r0 = 1
            r6 = r0
            goto L2b
        L29:
            r0 = 0
            r6 = r0
        L2b:
            r0 = r8
            if (r0 == 0) goto L3e
            r0 = r8
            int r0 = r0.z
            r1 = 1
            if (r0 != r1) goto L3e
            r0 = 1
            r5 = r0
            goto L40
        L3e:
            r0 = 0
            r5 = r0
        L40:
            com.anythink.core.common.b.n r0 = com.anythink.core.common.b.n.a()
            android.content.Context r0 = r0.g()
            com.anythink.core.common.b.p r0 = com.anythink.core.common.b.p.a(r0)
            r9 = r0
            r0 = r4
            java.lang.String r1 = "gdpr_consent"
            r2 = r9
            boolean r2 = r2.c()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r4
            java.lang.String r1 = "is_eu"
            r2 = r6
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r8
            boolean r0 = r0.b
            if (r0 == 0) goto L81
            r0 = r7
            r6 = r0
            r0 = r9
            int r0 = r0.a()
            r1 = 2
            if (r0 == r1) goto La2
            goto La0
        L81:
            r0 = r9
            int r0 = r0.a()
            r1 = 2
            if (r0 != r1) goto La0
            r0 = r8
            int r0 = r0.k
            if (r0 != 0) goto L97
            r0 = r7
            r6 = r0
            goto La2
        L97:
            r0 = r5
            if (r0 == 0) goto La0
            r0 = r7
            r6 = r0
            goto La2
        La0:
            r0 = 1
            r6 = r0
        La2:
            r0 = r4
            java.lang.String r1 = "need_set_gdpr"
            r2 = r6
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.Object r0 = r0.put(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.c.a.h(java.util.Map):void");
    }

    private void i(int i) {
        this.h = i;
    }

    private void i(String str) {
        this.ak = str;
    }

    private void j(int i) {
        this.k = i;
    }

    private void j(String str) {
        this.aj = str;
    }

    private void k(String str) {
        this.ai = str;
    }

    private void l(String str) {
        this.ab = str;
    }

    private void m(String str) {
        this.T = str;
    }

    private void n(String str) {
        this.U = str;
    }

    private void o(String str) {
        this.S = str;
    }

    private void p(String str) {
        this.Q = str;
    }

    private void q(String str) {
        this.E = str;
    }

    private void r(String str) {
        this.D = str;
    }

    private void s(String str) {
        this.C = str;
    }

    private void t(String str) {
        this.B = str;
    }

    private void u(String str) {
        this.ac = str;
    }

    private void v(String str) {
        this.ad = str;
    }

    private void w(String str) {
        this.ae = str;
    }

    private void x(String str) {
        this.af = str;
    }

    private void y(String str) {
        this.ag = str;
    }

    private void z(String str) {
        this.i = str;
    }

    public final String A() {
        return this.E;
    }

    public final int B() {
        return this.G;
    }

    public final void C() {
        this.G = 30000;
    }

    public final int D() {
        return this.H;
    }

    public final void E() {
        this.H = 0;
    }

    public final String F() {
        return this.D;
    }

    public final boolean G() {
        return this.b;
    }

    public final String H() {
        return this.C;
    }

    public final int I() {
        return this.z;
    }

    public final long J() {
        return this.y;
    }

    public final void K() {
        this.y = 51200L;
    }

    public final long L() {
        return this.f;
    }

    public final Map<String, String> M() {
        return this.A;
    }

    public final long N() {
        return this.x;
    }

    public final void O() {
        this.x = 30000L;
    }

    public final long P() {
        return this.d;
    }

    public final void Q() {
        this.d = 7200000L;
    }

    public final int R() {
        return this.g;
    }

    public final int S() {
        return this.h;
    }

    public final String T() {
        return this.i;
    }

    public final int U() {
        return this.k;
    }

    public final long V() {
        return this.l;
    }

    public final void W() {
        this.l = 5000L;
    }

    public final String X() {
        return this.o;
    }

    public final int Y() {
        return this.p;
    }

    public final void Z() {
        this.p = 1;
    }

    public final c a() {
        return this.V;
    }

    public final Map<String, String> a(int i) {
        Map<String, Map<String, String>> map = this.L;
        if (map != null) {
            return map.get(String.valueOf(i));
        }
        return null;
    }

    public final void a(long j) {
        this.f = j;
    }

    public final void a(String str) {
        this.O = str;
    }

    public final long aa() {
        return this.q;
    }

    public final void ab() {
        this.q = 0L;
    }

    public final String ac() {
        return this.s;
    }

    public final int ad() {
        return this.t;
    }

    public final void ae() {
        this.t = 1;
    }

    public final long af() {
        return this.u;
    }

    public final void ag() {
        this.u = 0L;
    }

    public final Map<String, String> ah() {
        return this.I;
    }

    public final Map<String, String> ai() {
        return this.J;
    }

    public final Map<String, String> aj() {
        return this.K;
    }

    public final String ak() {
        return this.Z;
    }

    public final String al() {
        return this.aa;
    }

    public final String b() {
        return this.aq;
    }

    public final void b(String str) {
        this.e = str;
    }

    public final String c() {
        return this.ap;
    }

    public final void c(String str) {
        this.o = str;
    }

    public final int d() {
        return this.al;
    }

    public final void d(String str) {
        this.s = str;
    }

    public final Map<String, String> e(String str) {
        Map<String, Map<String, String>> map = this.M;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public final void e() {
        this.al = 0;
    }

    public final int f() {
        return this.am;
    }

    public final void g() {
        this.am = 0;
    }

    public final int h() {
        return this.an;
    }

    public final void i() {
        this.an = 0;
    }

    public final int j() {
        return this.ao;
    }

    public final void k() {
        this.ao = 1;
    }

    public final String l() {
        return this.ak;
    }

    public final String m() {
        return this.aj;
    }

    public final String n() {
        return this.ai;
    }

    public final String o() {
        return this.ab;
    }

    public final int p() {
        return this.X;
    }

    public final int q() {
        return this.Y;
    }

    public final n r() {
        return this.W;
    }

    public final String s() {
        return this.T;
    }

    public final String t() {
        return this.S;
    }

    public final int u() {
        return this.P;
    }

    public final String v() {
        return this.Q;
    }

    public final int w() {
        return this.R;
    }

    public final int x() {
        return this.N;
    }

    public final void y() {
        this.N = 1;
    }

    public final String z() {
        return this.O;
    }
}
