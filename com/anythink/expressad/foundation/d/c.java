package com.anythink.expressad.foundation.d;

import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import com.anythink.basead.b.a;
import com.anythink.expressad.a.c;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.foundation.h.x;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/d/c.class */
public class c extends h implements com.anythink.expressad.e.b, Serializable {
    public static final int A = -2;
    public static final int B = 1;
    public static final String C = "id";
    public static final String D = "unitId";
    public static final String E = "title";
    public static final String F = "desc";
    public static final String G = "package_name";
    public static final String H = "icon_url";
    public static final String I = "image_url";
    public static final String J = "image_size";
    public static final String K = "app_size";
    public static final String L = "impression_url";
    public static final String M = "click_url";
    public static final String N = "wtick";
    public static final String O = "deep_link";
    public static final String P = "user_activation";
    public static final String Q = "notice_url";
    public static final String R = "template";
    public static final String S = "ad_source_id";
    public static final String T = "fca";
    public static final String U = "fcb";
    public static final String V = "click_mode";
    public static final String W = "landing_type";
    public static final String X = "link_type";
    public static final String Y = "rating";
    public static final String Z = "number_rating";

    /* renamed from: a  reason: collision with root package name */
    public static final String f7765a = c.class.getSimpleName();
    public static final String aA = "vctn_t";
    public static final String aB = "vck_t";
    public static final String aC = "rs_ignc_r";
    public static final int aD = 1;
    public static final int aE = 2;
    public static final String aF = "rw_pl";
    public static final String aG = "jm_pd";
    public static final String aI = "oc_type";
    public static final String aJ = "oc_time";
    public static final String aK = "t_list";
    public static final String aL = "adchoice";
    public static final String aM = "omid";
    public static final String aN = "ia_icon";
    public static final String aO = "ia_rst";
    public static final String aP = "ia_url";
    public static final String aQ = "ia_ori";
    public static final String aR = "ad_type";
    public static final String aS = "ia_ext1";
    public static final String aT = "ia_ext2";
    public static final String aU = "is_download_zip";
    public static final String aV = "ia_cache";
    public static final String aW = "imp_ua";
    public static final String aX = "c_ua";
    public static final int aY = 1;
    public static final int aZ = 1;
    public static final String aa = "ctatext";
    public static final String ab = "c_ct";
    public static final String ac = "video_url";
    public static final String ad = "video_length";
    public static final String ae = "video_size";
    public static final String af = "video_resolution";
    public static final String ag = "watch_mile";
    public static final String ah = "endcard_click_result";
    public static final String ai = "ctype";
    public static final String aj = "adv_imp";
    public static final String ak = "t_imp";
    public static final String al = "sec";
    public static final String am = "url";
    public static final String an = "guidelines";
    public static final String ao = "offer_type";
    public static final String ap = "reward_amount";
    public static final String aq = "reward_name";

    /* renamed from: ar  reason: collision with root package name */
    public static final String f7766ar = "md5_file";
    public static final String as = "c_toi";
    public static final int at = 2;
    public static final String au = "5";
    public static final String av = "rtins_type";
    public static final String aw = "ad_url_list";
    public static final String ax = "retarget_offer";
    public static final String ay = "flb";
    public static final String az = "flb_skiptime";
    public static final String b = "ad_tpl_url";
    public static final int bA = 9;
    public static final int bB = 12;
    public static final String bC = "video_end_type";
    public static final int bD = 1;
    public static final int bE = 2;
    public static final int bF = 3;
    public static final int bG = 4;
    public static final int bH = 5;
    public static final int bI = 100;
    public static final int bJ = 2;
    public static final String bL = "ready_rate";
    public static final String bM = "tmp_ids";
    public static final String bN = "ext_data";
    public static final String bO = "endcard_url";
    public static final String bP = "playable_ads_without_video";
    public static final int bQ = 1;
    public static final int bR = 2;
    public static final String bS = "impression";
    public static final String bT = "start";
    public static final String bU = "first_quartile";
    public static final String bV = "midpoint";
    public static final String bW = "third_quartile";
    public static final String bX = "complete";
    public static final String bY = "mute";
    public static final String bZ = "unmute";
    public static final String ba = "iex";
    public static final String bb = "ts";
    public static final String bc = "nv_t2";
    public static final String bd = "impression_t2";
    public static final String be = "gif_url";
    public static final String bf = "dropout_track";
    public static final String bg = "plycmpt_track";
    public static final String bh = "aks";
    public static final String bi = "k";
    public static final String bj = "q";
    public static final String bk = "r";
    public static final String bl = "al";
    public static final String bm = "mp";
    public static final String bn = "pv_urls";
    public static final int bo = 3;
    public static final int bp = 4;
    public static final int bq = 1;
    public static final int br = 2;
    public static final int bs = 3;
    public static final int bt = 1;
    public static final int bu = 2;
    public static final int bv = 1;
    public static final int bw = 2;
    public static final int bx = 3;
    public static final int by = 4;
    public static final int bz = 8;

    /* renamed from: c  reason: collision with root package name */
    public static final String f7767c = "ad_html";
    public static final String ca = "click";
    public static final String cb = "pause";
    public static final String cc = "resume";
    public static final String cd = "error";
    public static final String ce = "endcard";
    public static final String cf = "close";
    public static final String cg = "video_click";
    public static final String ch = "endcard_show";
    public static final String ci = "play_percentage";
    public static final String cj = "ad_tracking";
    public static final String ck = "rv";
    public static final int cl = -1;
    public static final int cm = 1;

    /* renamed from: cn  reason: collision with root package name */
    public static final int f7768cn = 0;
    public static final String d = "cmpt=1";
    private static final long dP = 1;
    public static final String e = "tp_offer";
    private static final int eS = 100;
    public static final String f = "fac";
    public static final String g = "at_cd_rate";
    public static final String h = "plct";
    public static final String i = "plctb";
    public static final String j = "banner_url";
    public static final String k = "banner_html";
    public static final String l = "creative_id";
    public static final String m = "mraid";
    public static final String n = "mraid_src";
    public static final String o = "timestamp";
    public static final String p = "hb";
    public static final String q = "maitve";
    public static final String r = "maitve_src";
    public static final String s = "vcn";
    public static final String t = "token_r";
    public static final String u = "encrypt_p";
    public static final String v = "view_com_time";
    public static final String w = "adspace_t";
    public static final String x = "cbd";
    public static final String y = "vst";
    public static final int z = -2;
    public p aH;
    private List<String> cZ;
    private String dA;
    private int dB;
    private String dC;
    private int dD;
    private int dE;
    private String dF;
    private String dG;
    private int dH;
    private String dI;
    private a dJ;
    private int dL;
    private String dM;
    private String dR;
    private long da;
    private int dd;
    private boolean dl;
    private int du;
    private int dv;
    private int dw;
    private int dx;
    private int dy;
    private int dz;
    private int eA;
    private String eB;
    private int eC;
    private String eD;
    private HashMap<String, String> eE;
    private String eF;
    private String eG;
    private String eH;
    private String eI;
    private String eJ;
    private boolean eK;
    private String eM;
    private boolean eN;
    private boolean eO;
    private int eQ;
    private String eT;
    private String eV;
    private String eW;
    private int eX;
    private String eY;
    private int eb;
    private int ec;
    private int ed;
    private String ee;
    private String ef;
    private String eg;
    private String eh;
    private int ei;
    private boolean ej;
    private boolean el;
    private int em;
    private int eo;
    private String ep;
    private int eq;
    private int er;
    private String es;
    private int et;
    private int eu;
    private int ev;
    private String ew;
    private int ex;
    private String ey;
    private String ez;
    private String fA;
    private int fC;
    private String fb;
    private n fd;
    private String fe;
    private String ff;
    private int fg;
    private long fh;
    private String fi;
    private String fj;
    private int fk;
    private String fl;
    private int fm;
    private b fn;
    private C0143c fo;
    private c.b fp;
    private int fs;
    private ArrayList<Integer> fu;
    private int cV = 1;
    private String cW = "";
    private String cX = "";
    private boolean cY = false;
    private int db = 0;
    private int dc = 0;

    /* renamed from: de  reason: collision with root package name */
    private int f7769de = -2;
    private int df = -2;
    private long dg = 0;
    private long dh = 0;
    private String di = "";
    private String dj = "";
    private long dk = 0;
    private int dm = 0;
    private int dn = 0;

    /* renamed from: do  reason: not valid java name */
    private String f47do = "";
    private boolean dp = false;
    private int dq = 0;
    private boolean dr = false;
    private int ds = 0;
    private int dt = -1;
    private int dK = 0;
    private int dN = 1;
    private int dO = 1;
    private int dQ = 6;
    private int dS = -1;
    private String dT = "";
    private String dU = "";
    private String dV = "";
    private int dW = 0;
    private String dX = "";
    private boolean dY = false;
    private String dZ = "";
    private String ea = "";
    private boolean ek = false;
    private String en = "";
    private String eL = "";
    private int eP = 2;
    public String bK = "";
    private int eR = -1;
    private int eU = 1;
    private int eZ = 0;
    private int fa = 2;
    private int fc = 1;
    private boolean fq = false;
    private String fr = null;
    private String ft = "";
    private int fv = 2;
    private int fw = 1;
    private int fx = -1;
    private boolean fy = false;
    private boolean fz = false;
    private int fB = 0;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/d/c$a.class */
    public static final class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public static final String f7770a = "ad_logo_link";
        public static final String b = "adchoice_link";

        /* renamed from: c  reason: collision with root package name */
        public static final String f7771c = "adchoice_icon";
        public static final String d = "adchoice_size";
        public static final String e = "platform_name";
        public static final String f = "platform_logo";
        public static final String g = "adv_name";
        public static final String h = "adv_logo";
        private String i = "";
        private String j = "";
        private String k = "";
        private String l = "";
        private String m = "";
        private String n = "";
        private String o = "";
        private String p = "";
        private int q = 0;
        private int r = 0;
        private String s = "";

        public static a a(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return a(new JSONObject(str));
            } catch (Exception e2) {
                if (com.anythink.expressad.a.f6941a) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            } catch (Throwable th) {
                if (com.anythink.expressad.a.f6941a) {
                    th.printStackTrace();
                    return null;
                }
                return null;
            }
        }

        private static a a(JSONObject jSONObject) {
            a aVar;
            a aVar2;
            a aVar3;
            a aVar4;
            try {
                aVar4 = new a();
            } catch (Exception e2) {
                e = e2;
                aVar2 = null;
            } catch (Throwable th) {
                th = th;
                aVar = null;
            }
            try {
                aVar4.k = jSONObject.optString("adchoice_icon");
                aVar4.j = jSONObject.optString("adchoice_link");
                String optString = jSONObject.optString("adchoice_size");
                aVar4.l = optString;
                aVar4.i = jSONObject.optString(f7770a);
                aVar4.p = jSONObject.optString(h);
                aVar4.o = jSONObject.optString(g);
                aVar4.n = jSONObject.optString("platform_logo");
                aVar4.m = jSONObject.optString("platform_name");
                aVar4.r = k(optString);
                aVar4.q = l(optString);
                aVar4.s = jSONObject.toString();
                return aVar4;
            } catch (Exception e3) {
                e = e3;
                aVar2 = aVar4;
                aVar3 = aVar2;
                if (com.anythink.expressad.a.f6941a) {
                    e.printStackTrace();
                    aVar3 = aVar2;
                }
                return aVar3;
            } catch (Throwable th2) {
                th = th2;
                aVar = aVar4;
                aVar3 = aVar;
                if (com.anythink.expressad.a.f6941a) {
                    th.printStackTrace();
                    aVar3 = aVar;
                }
                return aVar3;
            }
        }

        private void a(int i) {
            this.q = i;
        }

        private void b(int i) {
            this.r = i;
        }

        private void b(String str) {
            this.s = str;
        }

        private void c(String str) {
            this.i = str;
        }

        private void d(String str) {
            this.j = str;
        }

        private int e() {
            return this.q;
        }

        private void e(String str) {
            this.k = str;
        }

        private int f() {
            return this.r;
        }

        private void f(String str) {
            this.l = str;
        }

        private String g() {
            return this.i;
        }

        private void g(String str) {
            this.m = str;
        }

        private String h() {
            return this.m;
        }

        private void h(String str) {
            this.n = str;
        }

        private String i() {
            return this.n;
        }

        private void i(String str) {
            this.o = str;
        }

        private String j() {
            return this.o;
        }

        private void j(String str) {
            this.p = str;
        }

        private static int k(String str) {
            String[] split;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                if (!str.contains("x") || (split = str.split("x")) == null || split.length <= 1) {
                    return 0;
                }
                return Integer.parseInt(split[1]);
            } catch (NumberFormatException | Exception e2) {
                return 0;
            }
        }

        private String k() {
            return this.p;
        }

        private static int l(String str) {
            String[] split;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                if (!str.contains("x") || (split = str.split("x")) == null || split.length <= 0) {
                    return 0;
                }
                return Integer.parseInt(split[0]);
            } catch (NumberFormatException | Exception e2) {
                return 0;
            }
        }

        private boolean l() {
            return (TextUtils.isEmpty(this.j) || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.k)) ? false : true;
        }

        public final String a() {
            return this.s;
        }

        public final String b() {
            return this.j;
        }

        public final String c() {
            return this.k;
        }

        public final String d() {
            return this.l;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/d/c$b.class */
    public static final class b implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public boolean f7772a = false;
        public boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7773c = false;
        public boolean d = false;
        public boolean e = false;
        public boolean f = false;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;
        public Map<Integer, String> l;
    }

    /* renamed from: com.anythink.expressad.foundation.d.c$c  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/d/c$c.class */
    public static final class C0143c implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public static final String f7774a = "video_template";
        public static final String b = "template_url";

        /* renamed from: c  reason: collision with root package name */
        public static final String f7775c = "orientation";
        public static final String d = "paused_url";
        public static final String e = "image";
        private static final int f = 1;
        private String g;
        private int h;
        private int i;
        private String j;
        private String k;
        private List<a> l;

        /* renamed from: com.anythink.expressad.foundation.d.c$c$a */
        /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/d/c$c$a.class */
        public static final class a implements Serializable {

            /* renamed from: a  reason: collision with root package name */
            public String f7776a;
            public List<String> b = new ArrayList();
        }

        private C0143c(String str) {
            this.g = str;
        }

        public static C0143c a(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    if (w.b(jSONObject.toString())) {
                        C0143c c0143c = new C0143c(jSONObject.toString());
                        c0143c.h = jSONObject.optInt(f7774a, 1);
                        c0143c.a(jSONObject.optString("template_url"));
                        c0143c.i = jSONObject.optInt("orientation");
                        c0143c.j = jSONObject.optString(d);
                        JSONObject optJSONObject = jSONObject.optJSONObject("image");
                        if (optJSONObject != null) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<String> keys = optJSONObject.keys();
                            while (keys != null && keys.hasNext()) {
                                String next = keys.next();
                                List<String> a2 = t.a(optJSONObject.optJSONArray(next));
                                if (a2 != null && a2.size() > 0) {
                                    a aVar = new a();
                                    aVar.f7776a = next;
                                    aVar.b.addAll(a2);
                                    arrayList.add(aVar);
                                }
                            }
                            c0143c.l = arrayList;
                        }
                        return c0143c;
                    }
                    return null;
                } catch (Throwable th) {
                    return null;
                }
            }
            return null;
        }

        private void a(int i) {
            this.h = i;
        }

        private void a(List<a> list) {
            this.l = list;
        }

        private void b(int i) {
            this.i = i;
        }

        private void b(String str) {
            this.g = str;
        }

        private void c(String str) {
            this.j = str;
        }

        private static C0143c d(String str) {
            try {
                if (w.b(str)) {
                    return a(new JSONObject(str));
                }
                return null;
            } catch (Throwable th) {
                return null;
            }
        }

        public final String a() {
            return this.g;
        }

        public final void a(String str) {
            this.k = x.c(str);
        }

        public final int b() {
            return this.h;
        }

        public final int c() {
            return this.i;
        }

        public final String d() {
            return this.j;
        }

        public final String e() {
            return this.k;
        }

        public final List<a> f() {
            return this.l;
        }
    }

    private void A(int i2) {
        this.dH = i2;
    }

    private void B(int i2) {
        this.dz = i2;
    }

    private void C(int i2) {
        this.dx = i2;
    }

    private void C(String str) {
        this.dM = str;
    }

    private void D(int i2) {
        this.dy = i2;
    }

    private void D(String str) {
        this.dI = str;
    }

    private void E(int i2) {
        this.dw = i2;
    }

    private void E(String str) {
        this.dR = str;
    }

    private void F(int i2) {
        this.dQ = i2;
    }

    private void F(String str) {
        this.eF = str;
    }

    private void G(int i2) {
        this.eQ = i2;
    }

    private void G(String str) {
        this.eG = str;
    }

    private void H(int i2) {
        this.dN = i2;
    }

    private void H(String str) {
        this.eH = str;
    }

    private void I(int i2) {
        this.dO = i2;
    }

    private void I(String str) {
        this.eI = str;
    }

    private void J(int i2) {
        this.eP = i2;
    }

    private void J(String str) {
        this.eJ = str;
    }

    private void K(int i2) {
        this.fc = i2;
    }

    private void K(String str) {
        this.eL = str;
    }

    private void L(int i2) {
        this.fg = i2;
    }

    private void L(String str) {
        this.bK = str;
    }

    private void M(int i2) {
        this.fm = i2;
    }

    private void M(String str) {
        this.fe = str;
    }

    private void N(int i2) {
        this.eC = i2;
    }

    private void N(String str) {
        this.eD = str;
    }

    private void O(int i2) {
        this.ex = i2;
    }

    private void O(String str) {
        this.fi = str;
    }

    private void P(int i2) {
        this.eA = i2;
    }

    private void P(String str) {
        this.fj = str;
    }

    private void Q(int i2) {
        this.eu = i2;
    }

    private void Q(String str) {
        this.ew = str;
    }

    private void R(int i2) {
        this.er = i2;
    }

    private void R(String str) {
        this.eB = str;
    }

    private void S(int i2) {
        this.et = i2;
    }

    private void S(String str) {
        this.es = str;
    }

    private void T(int i2) {
        this.eo = i2;
    }

    private void T(String str) {
        this.en = str;
    }

    private void U(int i2) {
        this.eq = i2;
    }

    private void U(String str) {
        this.ep = str;
    }

    private void V(int i2) {
        this.em = i2;
    }

    private void V(String str) {
        this.eg = str;
    }

    private void W(int i2) {
        this.ei = i2;
    }

    private void W(String str) {
        this.eh = str;
    }

    private void X(int i2) {
        this.fa = i2;
    }

    private void X(String str) {
        this.ee = str;
    }

    private void Y(int i2) {
        this.ec = i2;
    }

    private void Y(String str) {
        this.ef = str;
    }

    private void Z(int i2) {
        this.ed = i2;
    }

    private void Z(String str) {
        this.dX = str;
    }

    public static c a(JSONObject jSONObject) {
        c cVar = new c();
        cVar.v(jSONObject.optString("campaignid"));
        cVar.w(jSONObject.optString("packageName"));
        cVar.x(jSONObject.optString("title"));
        cVar.o(jSONObject.optString(a.C0070a.k));
        cVar.y(jSONObject.optString("desc"));
        cVar.dT = jSONObject.optString(L);
        cVar.A(jSONObject.optString("image_url"));
        cVar.dg = jSONObject.optLong("plct");
        cVar.dh = jSONObject.optLong("plctb");
        cVar.cX = jSONObject.optString(f7767c);
        cVar.a(jSONObject.optString(b));
        cVar.d(jSONObject.optString(j));
        cVar.dj = jSONObject.optString(k);
        cVar.dk = jSONObject.optInt("creative_id");
        return cVar;
    }

    private static c a(JSONObject jSONObject, String str, String str2, String str3, boolean z2, d dVar) {
        return a(jSONObject, str, str2, str3, z2, dVar, "");
    }

    public static c a(JSONObject jSONObject, String str, String str2, String str3, boolean z2, d dVar, String str4) {
        c cVar;
        ArrayList arrayList;
        JSONObject c2 = c(jSONObject);
        if (c2 == null) {
            return null;
        }
        try {
            c cVar2 = new c();
            try {
                String optString = c2.optString(bh);
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    Iterator<String> keys = jSONObject2.keys();
                    HashMap<String, String> hashMap = new HashMap<>();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.optString(next));
                    }
                    cVar2.eE = hashMap;
                }
                if (!TextUtils.isEmpty(str4)) {
                    cVar2.eL = str4;
                    cVar2.eK = true;
                }
                try {
                    cVar2.eR = c2.optInt("ready_rate", -1);
                    JSONObject optJSONObject = c2.optJSONObject(bN);
                    if (optJSONObject != null) {
                        cVar2.eT = optJSONObject.toString();
                    }
                    cVar2.eX = c2.optInt(d.G);
                    cVar2.r(c2.optString(d.F));
                    cVar2.eU = c2.optInt(d.E);
                    new JSONArray();
                    JSONArray optJSONArray = c2.optJSONArray("pv_urls");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        ArrayList arrayList2 = new ArrayList(optJSONArray.length());
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            arrayList = arrayList2;
                            if (i3 >= optJSONArray.length()) {
                                break;
                            }
                            arrayList2.add(optJSONArray.optString(i3));
                            i2 = i3 + 1;
                        }
                    } else {
                        arrayList = null;
                    }
                    cVar2.cZ = arrayList;
                    JSONObject optJSONObject2 = c2.optJSONObject(d.H);
                    if (optJSONObject2 != null) {
                        cVar2.eY = optJSONObject2.toString();
                    }
                } catch (Exception e2) {
                }
                cVar2.v(c2.optString("id"));
                cVar2.x(c2.optString("title"));
                cVar2.ff = c2.optString("unitId", "");
                cVar2.y(c2.optString("desc"));
                cVar2.w(c2.optString("package_name"));
                cVar2.ev = c2.optInt(av);
                cVar2.z(c2.optString("icon_url"));
                cVar2.A(c2.optString("image_url"));
                cVar2.B(c2.optString(K));
                cVar2.ea = c2.optString(J);
                cVar2.dT = a(dVar, cVar2, c2.optString(L));
                cVar2.dV = a(dVar, cVar2, c2.optString("click_url"));
                cVar2.aH = p.a(c2.optString(aF));
                cVar2.dW = c2.optInt(N);
                cVar2.dX = a(dVar, cVar2, c2.optString(O));
                cVar2.dY = c2.optBoolean(P, false);
                cVar2.dU = a(dVar, cVar2, c2.optString("notice_url"));
                cVar2.eb = c2.optInt("template");
                cVar2.p(c2.optInt("ad_source_id", 1));
                cVar2.ec = c2.optInt(T);
                cVar2.ed = c2.optInt(U);
                cVar2.eQ = c2.optInt(ah);
                if (!TextUtils.isEmpty(c2.optString(Y))) {
                    cVar2.a(Double.parseDouble(c2.optString(Y, "0")));
                }
                if (!TextUtils.isEmpty(c2.optString(Z))) {
                    cVar2.o(c2.optInt(Z, 333333));
                }
                cVar2.ee = c2.optString("click_mode");
                cVar2.ef = c2.optString("landing_type");
                cVar2.eu = c2.optInt("link_type", 4);
                cVar2.ei = c2.optInt(ab);
                cVar2.o(c2.optString(aa));
                cVar2.eD = c2.optString(aw);
                cVar2.fm = c2.optInt(ax, 2);
                String optString2 = c2.optString("video_url");
                if (!TextUtils.isEmpty(optString2)) {
                    if (z2) {
                        cVar2.en = optString2;
                    } else {
                        cVar2.en = com.anythink.expressad.foundation.h.j.b(optString2);
                    }
                }
                cVar2.ds = c2.optInt(v);
                cVar2.q(c2.optInt("video_length"));
                cVar2.eo = c2.optInt("video_size");
                cVar2.ep = c2.optString(af);
                cVar2.eq = c2.optInt(ag);
                cVar2.a(System.currentTimeMillis());
                cVar2.dZ = a(dVar, cVar2, str);
                cVar2.er = c2.optInt("ctype");
                cVar2.es = c2.optString(aj);
                cVar2.et = c2.optInt(ak);
                cVar2.ey = str2;
                cVar2.n(str3);
                cVar2.ew = c2.optString(an);
                cVar2.ex = c2.optInt("offer_type");
                cVar2.eB = c2.optString("reward_name");
                cVar2.eA = c2.optInt("reward_amount");
                try {
                    if (c2.has(cj)) {
                        String a2 = a(dVar, cVar2, c2.optString(cj));
                        if (!TextUtils.isEmpty(a2)) {
                            cVar2.fe = a2;
                            cVar2.fd = ad(a2);
                        }
                    }
                } catch (Exception e3) {
                }
                cVar2.eP = c2.optInt(bC, 2);
                if (a(cVar2, c2.optString("endcard_url"))) {
                    return null;
                }
                cVar2.fc = c2.optInt(bP, 1);
                if (c2.has(f7766ar)) {
                    cVar2.bK = c2.optString(f7766ar);
                }
                if (c2.has(bc)) {
                    cVar2.dQ = c2.optInt(bc);
                }
                if (c2.has(be)) {
                    cVar2.dR = c2.optString(be);
                }
                cVar2.a(C0143c.a(c2.optJSONObject(ck)));
                cVar2.fa = c2.optInt(as, 2);
                cVar2.dN = c2.optInt(aW, 1);
                cVar2.dO = c2.optInt(aX, 1);
                cVar2.dw = c2.optInt(aG);
                cVar2.dA = c2.optString("ia_icon");
                cVar2.dB = c2.optInt("ia_rst");
                cVar2.dC = c2.optString("ia_url");
                cVar2.dD = c2.optInt("ia_ori");
                cVar2.dE = dVar.d();
                cVar2.db = c2.optInt(e);
                cVar2.dc = c2.optInt(f);
                cVar2.dF = c2.optString(aS);
                cVar2.dG = c2.optString(aT);
                cVar2.dH = c2.optInt(aU);
                cVar2.dI = c2.optString(aV);
                cVar2.dL = c2.optInt(aJ);
                cVar2.dK = c2.optInt(aI);
                cVar2.dM = c2.optString(aK);
                cVar2.dJ = a.a(c2.optString(aL, ""));
                cVar2.dg = c2.optLong("plct");
                cVar2.dh = c2.optLong("plctb");
                cVar2.dk = c2.optLong("creative_id");
                String optString3 = c2.optString("cam_tpl_url");
                Uri parse = Uri.parse(optString3);
                if (TextUtils.isEmpty(parse.getPath()) || !(parse.getPath().endsWith(".zip") || parse.getPath().endsWith(".ZIP"))) {
                    cVar2.d(optString3);
                } else {
                    cVar2.a(optString3);
                }
                cVar2.dj = c2.optString("cam_html");
                cVar2.cX = c2.optString("cam_html");
                String optString4 = c2.optString(m);
                if (!TextUtils.isEmpty(optString4)) {
                    cVar2.eN = true;
                    cVar2.eM = optString4;
                } else if (TextUtils.isEmpty(cVar2.cX) || cVar2.cX.contains("<MBTPLMARK>")) {
                    cVar2.eN = false;
                } else {
                    cVar2.eN = true;
                }
                JSONArray optJSONArray2 = c2.optJSONArray(aM);
                if (optJSONArray2 != null) {
                    cVar2.fr = optJSONArray2.toString();
                } else if (TextUtils.isEmpty(c2.optString(aM))) {
                    cVar2.fr = null;
                } else {
                    cVar2.fr = c2.optString(aM);
                }
                cVar2.fk = c2.optInt(q);
                cVar2.fl = c2.optString(r);
                cVar2.du = c2.optInt(ay);
                cVar2.f7769de = c2.optInt(x, -2);
                cVar2.df = c2.optInt(y, -2);
                cVar2.dd = c2.optInt("adspace_t", 1);
                cVar2.dv = c2.optInt(az);
                cVar = b(c2, cVar2);
                try {
                    try {
                        cVar.dT = t.a(com.anythink.core.common.b.n.a().g(), cVar.ba(), cVar.dT);
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        return cVar;
                    }
                } catch (Exception e5) {
                    com.anythink.expressad.foundation.h.o.d("campaign", e5.getMessage());
                }
                cVar.ag(c2.optInt(aB, 2));
                cVar.ah(c2.optInt(aA, 1));
                JSONArray optJSONArray3 = c2.optJSONArray(aC);
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    ArrayList<Integer> arrayList3 = new ArrayList<>();
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= optJSONArray3.length()) {
                            break;
                        }
                        arrayList3.add(Integer.valueOf(optJSONArray3.optInt(i5)));
                        i4 = i5 + 1;
                    }
                    if (arrayList3.size() > 0) {
                        cVar.fu = arrayList3;
                    }
                }
                cVar.fC = c2.optInt(g, 0);
                return cVar;
            } catch (Exception e6) {
                e = e6;
                cVar = cVar2;
            }
        } catch (Exception e7) {
            e = e7;
            cVar = null;
        }
    }

    private static n a(JSONObject jSONObject, n nVar) {
        nVar.a(a(jSONObject.optJSONArray(h.cK)));
        nVar.b(a(jSONObject.optJSONArray(h.cL)));
        nVar.c(a(jSONObject.optJSONArray(h.cM)));
        return nVar;
    }

    public static JSONObject a(c cVar) {
        C0143c c0143c;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", cVar.aZ());
        jSONObject.put(ay, cVar.du);
        jSONObject.put(az, cVar.dv);
        jSONObject.put("adspace_t", cVar.dd);
        jSONObject.put(y, cVar.df);
        jSONObject.put(x, cVar.f7769de);
        if (!TextUtils.isEmpty(cVar.ff)) {
            jSONObject.put("unitId", cVar.ff);
        }
        if (!TextUtils.isEmpty(cVar.eT)) {
            try {
                jSONObject.put(bN, new JSONObject(cVar.eT));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(cVar.eY)) {
            try {
                jSONObject.put(d.H, new JSONObject(cVar.eY));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        List<String> list = cVar.cZ;
        if (list != null && list.size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String str : cVar.cZ) {
                    jSONArray.put(str);
                }
                jSONObject.put("pv_urls", jSONArray);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(cVar.eV)) {
            jSONObject.put(d.G, cVar.eX);
            jSONObject.put(d.F, cVar.eV);
            jSONObject.put(d.E, cVar.eU);
        }
        jSONObject.put("ready_rate", cVar.eR);
        jSONObject.put("title", cVar.bb());
        jSONObject.put("desc", cVar.bc());
        jSONObject.put("package_name", cVar.ba());
        jSONObject.put(av, cVar.ev);
        jSONObject.put("icon_url", cVar.bd());
        jSONObject.put("image_url", cVar.be());
        jSONObject.put(K, cVar.bh());
        jSONObject.put(J, cVar.ea);
        jSONObject.put(L, cVar.dT);
        jSONObject.put("click_url", cVar.dV);
        p pVar = cVar.aH;
        if (pVar != null) {
            jSONObject.put(aF, pVar.c());
        }
        jSONObject.put(N, cVar.dW);
        jSONObject.put(O, cVar.dX);
        jSONObject.put(P, cVar.dY);
        jSONObject.put("notice_url", cVar.dU);
        jSONObject.put("template", cVar.eb);
        jSONObject.put("ad_source_id", cVar.bf());
        jSONObject.put(T, cVar.ec);
        jSONObject.put(U, cVar.ed);
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.aX());
        jSONObject.put(Y, sb.toString());
        jSONObject.put(Z, cVar.aY());
        jSONObject.put("click_mode", cVar.ee);
        jSONObject.put("landing_type", cVar.ef);
        jSONObject.put("link_type", cVar.eu);
        jSONObject.put(ab, cVar.ei);
        jSONObject.put(aa, cVar.cU);
        jSONObject.put(ah, cVar.eQ);
        jSONObject.put(ax, cVar.fm);
        jSONObject.put("video_url", cVar.en);
        jSONObject.put("video_length", cVar.bi());
        jSONObject.put("video_size", cVar.eo);
        jSONObject.put(af, cVar.ep);
        jSONObject.put(ag, cVar.eq);
        jSONObject.put(aw, cVar.eD);
        jSONObject.put(d.g, cVar.dZ);
        jSONObject.put("ctype", cVar.er);
        jSONObject.put(ak, cVar.et);
        jSONObject.put(aj, cVar.es);
        jSONObject.put(d.f, cVar.ey);
        jSONObject.put(d.k, cVar.ez);
        jSONObject.put(an, cVar.ew);
        jSONObject.put("offer_type", cVar.ex);
        jSONObject.put("reward_amount", cVar.eA);
        jSONObject.put("reward_name", cVar.eB);
        jSONObject.put(be, cVar.dR);
        if (w.b(cVar.fe)) {
            jSONObject.put(cj, new JSONObject(cVar.fe));
        }
        jSONObject.put(bC, cVar.eP);
        jSONObject.put("endcard_url", cVar.I());
        jSONObject.put(bP, cVar.fc);
        if (cVar != null && (c0143c = cVar.fo) != null && w.b(c0143c.a())) {
            jSONObject.put(ck, new JSONObject(cVar.fo.a()));
        }
        jSONObject.put(f7766ar, cVar.bK);
        jSONObject.put(as, cVar.fa);
        jSONObject.put(aX, cVar.dO);
        jSONObject.put(aW, cVar.dN);
        jSONObject.put(aG, cVar.dw);
        jSONObject.put("ia_icon", cVar.dA);
        jSONObject.put("ia_rst", cVar.dB);
        jSONObject.put("ia_url", cVar.dC);
        jSONObject.put("ia_ori", cVar.dD);
        jSONObject.put("ad_type", cVar.dE);
        jSONObject.put(aS, cVar.dF);
        jSONObject.put(aT, cVar.dG);
        jSONObject.put(aU, cVar.dH);
        jSONObject.put(aV, cVar.dI);
        jSONObject.put(aI, cVar.dK);
        jSONObject.put(aJ, cVar.dL);
        jSONObject.put(aK, cVar.dM);
        a aVar = cVar.dJ;
        if (aVar != null) {
            jSONObject.put(aL, new JSONObject(aVar.a()));
        }
        jSONObject.put("plct", cVar.dg);
        jSONObject.put("plctb", cVar.dh);
        jSONObject.put(aM, cVar.fr);
        jSONObject.put("creative_id", cVar.dk);
        jSONObject.put("cam_html", cVar.dj);
        String str2 = cVar.di;
        if (str2 == null) {
            str2 = cVar.cW;
        }
        jSONObject.put("cam_tpl_url", str2);
        jSONObject.put(m, cVar.eM);
        jSONObject.put(n, cVar.eM);
        jSONObject.put("timestamp", cVar.bg());
        jSONObject.put("hb", cVar.eK);
        jSONObject.put(q, cVar.fk);
        jSONObject.put(r, cVar.fl);
        int i2 = cVar.dm;
        if (i2 <= 0) {
            i2 = 1;
        }
        jSONObject.put("vcn", i2);
        int i3 = cVar.dn;
        if (i3 != 1) {
            i3 = 0;
        }
        jSONObject.put("token_r", i3);
        jSONObject.put("encrypt_p", cVar.f47do);
        jSONObject.put(v, cVar.ds);
        jSONObject.put(aC, cVar.fu);
        jSONObject.put(aB, cVar.fv);
        jSONObject.put(aA, cVar.fw);
        jSONObject.put(e, cVar.db);
        jSONObject.put(f, cVar.dc);
        try {
            jSONObject.put("misk_spt", com.anythink.core.common.p.a().c());
            com.anythink.core.common.p.a();
            jSONObject.put("misk_spt_det", com.anythink.core.common.p.b());
        } catch (JSONException e5) {
        }
        jSONObject.put(g, cVar.fC);
        if (cVar == null) {
            return jSONObject;
        }
        jSONObject.put(h.cw, cVar.aW());
        jSONObject.put(h.cx, cVar.aV());
        jSONObject.put(h.cA, cVar.aU());
        jSONObject.put("ttc_type", cVar.aT());
        jSONObject.put(h.cC, cVar.aS());
        jSONObject.put(h.cD, cVar.aN());
        jSONObject.put(h.cE, com.anythink.expressad.foundation.h.j.a(cVar.aO()));
        jSONObject.put(h.cF, cVar.aP());
        jSONObject.put(h.cp, cVar.aI());
        jSONObject.put(h.cq, cVar.aH());
        if (cVar.aG() != null) {
            jSONObject.put(h.cr, cVar.aG().g());
        }
        jSONObject.put(h.cG, cVar.aQ());
        jSONObject.put(h.cH, cVar.aR());
        jSONObject.put(bc, cVar.dQ);
        jSONObject.put(h.ct, cVar.aK());
        jSONObject.put(h.cs, cVar.aJ());
        jSONObject.put(h.cu, cVar.aL());
        jSONObject.put(h.cv, cVar.aM());
        return jSONObject;
    }

    public static JSONObject a(c cVar, boolean z2, boolean z3) {
        JSONObject a2 = a(cVar);
        a2.put("isReady", z2);
        a2.put("expired", z3);
        return a2;
    }

    private void a(a aVar) {
        this.dJ = aVar;
    }

    private void a(b bVar) {
        this.fn = bVar;
    }

    private void a(C0143c c0143c) {
        this.fo = c0143c;
        if (c0143c == null || TextUtils.isEmpty(c0143c.e())) {
            return;
        }
        if (TextUtils.isEmpty(this.eV) && c0143c.e().contains(d)) {
            this.eW = c0143c.e();
        }
        boolean e2 = t.e(c0143c.e());
        int g2 = t.g(c0143c.e());
        if (e2) {
            this.dp = true;
            v(g2);
        }
    }

    private void a(n nVar) {
        this.fd = nVar;
    }

    private void a(p pVar) {
        this.aH = pVar;
    }

    private void a(ArrayList<Integer> arrayList) {
        this.fu = arrayList;
    }

    private void a(HashMap<String, String> hashMap) {
        this.eE = hashMap;
    }

    private static boolean a(c cVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.anythink.expressad.foundation.b.a.b().h() == 2 && "1".equals(Uri.parse(str).getQueryParameter("dpwgl"))) {
            return true;
        }
        cVar.k(str);
        return false;
    }

    private static String[] a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        String[] strArr = new String[jSONArray.length()];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= jSONArray.length()) {
                return strArr;
            }
            strArr[i3] = jSONArray.optString(i3);
            i2 = i3 + 1;
        }
    }

    private void aa(int i2) {
        this.dS = i2;
    }

    private void aa(String str) {
        this.dT = str;
    }

    private void ab(int i2) {
        this.dW = i2;
    }

    private void ab(String str) {
        this.dZ = str;
    }

    private void ac(int i2) {
        this.eb = i2;
    }

    private void ac(String str) {
        this.ea = str;
    }

    private static n ad(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            n nVar = new n();
            nVar.r(a(jSONObject.optJSONArray(bS)));
            nVar.g(a(jSONObject.optJSONArray("start")));
            nVar.h(a(jSONObject.optJSONArray(bU)));
            nVar.i(a(jSONObject.optJSONArray("midpoint")));
            nVar.j(a(jSONObject.optJSONArray(bW)));
            nVar.k(a(jSONObject.optJSONArray("complete")));
            nVar.a(b(jSONObject.optJSONArray(ci)));
            nVar.l(a(jSONObject.optJSONArray("mute")));
            nVar.m(a(jSONObject.optJSONArray("unmute")));
            nVar.n(a(jSONObject.optJSONArray("click")));
            nVar.o(a(jSONObject.optJSONArray(cb)));
            nVar.p(a(jSONObject.optJSONArray("resume")));
            nVar.q(a(jSONObject.optJSONArray("error")));
            nVar.s(a(jSONObject.optJSONArray(ce)));
            nVar.u(a(jSONObject.optJSONArray("close")));
            nVar.t(a(jSONObject.optJSONArray(ch)));
            nVar.v(a(jSONObject.optJSONArray(cg)));
            nVar.f(a(jSONObject.optJSONArray(bd)));
            nVar.d(a(jSONObject.optJSONArray(bf)));
            nVar.e(a(jSONObject.optJSONArray(bg)));
            nVar.a(a(jSONObject.optJSONArray(h.cK)));
            nVar.b(a(jSONObject.optJSONArray(h.cL)));
            nVar.c(a(jSONObject.optJSONArray(h.cM)));
            return nVar;
        } catch (JSONException e2) {
            return null;
        }
    }

    private void ad(int i2) {
        this.eR = i2;
    }

    private static Map<Integer, String> ae(String str) {
        HashMap hashMap;
        HashMap hashMap2 = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                hashMap2 = null;
                if (jSONArray.length() > 0) {
                    hashMap = new HashMap();
                    int i2 = 0;
                    while (true) {
                        try {
                            int i3 = i2;
                            if (i3 >= jSONArray.length()) {
                                return hashMap;
                            }
                            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                            hashMap.put(Integer.valueOf(optJSONObject.optInt(al)), optJSONObject.optString("url"));
                            i2 = i3 + 1;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            hashMap2 = hashMap;
                            return hashMap2;
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
                hashMap = null;
            }
        }
        return hashMap2;
    }

    private void ae(int i2) {
        this.cV = i2;
    }

    private void af(int i2) {
        this.fk = i2;
    }

    private void af(String str) {
        this.eT = str;
    }

    private void ag(int i2) {
        if (i2 > 2 || i2 <= 0) {
            this.fv = 2;
        } else {
            this.fv = i2;
        }
    }

    private void ag(String str) {
        this.eW = str;
    }

    private void ah(int i2) {
        if (i2 > 2 || i2 <= 0) {
            this.fw = 1;
        } else {
            this.fw = i2;
        }
    }

    private void ah(String str) {
        this.fl = str;
    }

    private void ai(int i2) {
        this.fx = i2;
    }

    private void ai(String str) {
        this.fr = str;
    }

    private void aj(int i2) {
        this.fC = i2;
    }

    private void aj(String str) {
        this.ft = str;
    }

    private void ak(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split(",");
        if (split.length <= 0) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int length = split.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                this.fu = arrayList;
                return;
            } else {
                arrayList.add(Integer.valueOf(Integer.parseInt(split[i3])));
                i2 = i3 + 1;
            }
        }
    }

    public static c b(JSONObject jSONObject) {
        c cVar;
        ArrayList arrayList;
        c cVar2 = null;
        if (jSONObject != null) {
            cVar2 = null;
            try {
                cVar = new c();
            } catch (Exception e2) {
                e = e2;
            }
            try {
                cVar.v(jSONObject.optString("id"));
                cVar.x(jSONObject.optString("title"));
                cVar.y(jSONObject.optString("desc"));
                cVar.w(jSONObject.optString("package_name"));
                cVar.ev = jSONObject.optInt(av);
                cVar.z(jSONObject.optString("icon_url"));
                cVar.A(jSONObject.optString("image_url"));
                cVar.B(jSONObject.optString(K));
                cVar.ea = jSONObject.optString(J);
                cVar.dT = jSONObject.optString(L);
                cVar.dV = jSONObject.optString("click_url");
                cVar.aH = p.a(jSONObject.optString(aF));
                cVar.dW = jSONObject.optInt(N);
                cVar.dX = jSONObject.optString(O);
                cVar.dY = jSONObject.optBoolean(P, false);
                cVar.dU = jSONObject.optString("notice_url");
                cVar.eb = jSONObject.optInt("template");
                cVar.p(jSONObject.optInt("ad_source_id", 1));
                cVar.ec = jSONObject.optInt(T);
                cVar.ed = jSONObject.optInt(U);
                cVar.eQ = jSONObject.optInt(ah);
                if (!TextUtils.isEmpty(jSONObject.optString(Y))) {
                    cVar.a(Double.parseDouble(jSONObject.optString(Y, "0")));
                }
                if (!TextUtils.isEmpty(jSONObject.optString(Z))) {
                    cVar.o(jSONObject.optInt(Z, 333333));
                }
                cVar.ee = jSONObject.optString("click_mode");
                cVar.ef = jSONObject.optString("landing_type");
                cVar.eu = jSONObject.optInt("link_type", 4);
                cVar.ei = jSONObject.optInt(ab);
                cVar.o(jSONObject.optString(aa));
                cVar.eD = jSONObject.optString(aw);
                cVar.fm = jSONObject.optInt(ax, 2);
                cVar.en = jSONObject.optString("video_url");
                cVar.q(jSONObject.optInt("video_length"));
                cVar.eo = jSONObject.optInt("video_size");
                cVar.ep = jSONObject.optString(af);
                cVar.eq = jSONObject.optInt(ag);
                cVar.a(System.currentTimeMillis());
                cVar.er = jSONObject.optInt("ctype");
                cVar.es = jSONObject.optString(aj);
                cVar.et = jSONObject.optInt(ak);
                cVar.ey = jSONObject.optString(d.f);
                cVar.n(jSONObject.optString(d.k));
                cVar.ew = jSONObject.optString(an);
                cVar.ex = jSONObject.optInt("offer_type");
                cVar.eB = jSONObject.optString("reward_name");
                cVar.eA = jSONObject.optInt("reward_amount");
                try {
                    String optString = jSONObject.optString(cj);
                    if (!TextUtils.isEmpty(optString)) {
                        cVar.fe = optString;
                        cVar.fd = ad(optString);
                    }
                } catch (Exception e3) {
                }
                try {
                    cVar.eR = jSONObject.optInt("ready_rate", -1);
                    JSONObject optJSONObject = jSONObject.optJSONObject(bN);
                    if (optJSONObject != null) {
                        cVar.eT = optJSONObject.toString();
                    }
                    cVar.eX = jSONObject.optInt(d.G);
                    cVar.r(jSONObject.optString(d.F));
                    cVar.eU = jSONObject.optInt(d.E);
                    new JSONArray();
                    JSONArray optJSONArray = jSONObject.optJSONArray("pv_urls");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        ArrayList arrayList2 = new ArrayList(optJSONArray.length());
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            arrayList = arrayList2;
                            if (i3 >= optJSONArray.length()) {
                                break;
                            }
                            arrayList2.add(optJSONArray.optString(i3));
                            i2 = i3 + 1;
                        }
                    } else {
                        arrayList = null;
                    }
                    cVar.cZ = arrayList;
                    JSONObject optJSONObject2 = jSONObject.optJSONObject(d.H);
                    if (optJSONObject2 != null) {
                        cVar.eY = optJSONObject2.toString();
                    }
                } catch (Exception e4) {
                }
                cVar.eP = jSONObject.optInt(bC, 2);
                if (a(cVar, jSONObject.optString("endcard_url"))) {
                    return null;
                }
                cVar.fc = jSONObject.optInt(bP, 1);
                if (jSONObject.has(f7766ar)) {
                    cVar.bK = jSONObject.optString(f7766ar);
                }
                if (jSONObject.has(bc)) {
                    cVar.dQ = jSONObject.optInt(bc);
                }
                if (jSONObject.has(be)) {
                    cVar.dR = jSONObject.optString(be);
                }
                cVar.a(C0143c.a(jSONObject.optJSONObject(ck)));
                cVar.fa = jSONObject.optInt(as, 2);
                cVar.dN = jSONObject.optInt(aW, 1);
                cVar.dO = jSONObject.optInt(aX, 1);
                cVar.dw = jSONObject.optInt(aG);
                cVar.dA = jSONObject.optString("ia_icon");
                cVar.dB = jSONObject.optInt("ia_rst");
                cVar.dC = jSONObject.optString("ia_url");
                cVar.dD = jSONObject.optInt("ia_ori");
                cVar.dE = jSONObject.optInt("ad_type");
                cVar.db = jSONObject.optInt(e);
                cVar.dc = jSONObject.optInt(f);
                cVar.dF = jSONObject.optString(aS);
                cVar.dG = jSONObject.optString(aT);
                cVar.dH = jSONObject.optInt(aU);
                cVar.dI = jSONObject.optString(aV);
                cVar.dL = jSONObject.optInt(aJ);
                cVar.dK = jSONObject.optInt(aI);
                cVar.dM = jSONObject.optString(aK);
                cVar.dJ = a.a(jSONObject.optString(aL, ""));
                cVar.dg = jSONObject.optLong("plct");
                cVar.dh = jSONObject.optLong("plctb");
                JSONArray optJSONArray2 = jSONObject.optJSONArray(aM);
                if (optJSONArray2 != null) {
                    cVar.fr = optJSONArray2.toString();
                } else if (TextUtils.isEmpty(jSONObject.optString(aM))) {
                    cVar.fr = null;
                } else {
                    cVar.fr = jSONObject.optString(aM);
                }
                cVar.dk = jSONObject.optInt("creative_id");
                String optString2 = jSONObject.optString("cam_tpl_url");
                Uri parse = Uri.parse(optString2);
                if (TextUtils.isEmpty(parse.getPath()) || !(parse.getPath().endsWith(".zip") || parse.getPath().endsWith(".ZIP"))) {
                    cVar.d(optString2);
                } else {
                    cVar.a(optString2);
                }
                cVar.dj = jSONObject.optString("cam_html");
                cVar.cX = jSONObject.optString("cam_html");
                cVar.ff = jSONObject.optString("unitId");
                String optString3 = jSONObject.optString(m);
                String str = optString3;
                if (TextUtils.isEmpty(optString3)) {
                    str = jSONObject.optString(n);
                }
                if (!TextUtils.isEmpty(str)) {
                    cVar.eN = true;
                    cVar.eM = str;
                } else if (TextUtils.isEmpty(cVar.cX) || cVar.cX.contains("<MBTPLMARK>")) {
                    cVar.eN = false;
                } else {
                    cVar.eN = true;
                }
                try {
                    String optString4 = jSONObject.optString(d.g);
                    if (!TextUtils.isEmpty(optString4)) {
                        cVar.dZ = optString4;
                        Uri parse2 = Uri.parse(optString4);
                        if (parse2 != null) {
                            cVar.eg = parse2.getQueryParameter("k");
                        }
                    }
                    String optString5 = jSONObject.optString("notice_url");
                    if (!TextUtils.isEmpty(optString5)) {
                        cVar.dU = optString5;
                        Uri parse3 = Uri.parse(optString5);
                        if (parse3 != null) {
                            cVar.eh = parse3.getQueryParameter("k");
                        }
                    }
                } catch (Exception e5) {
                }
                cVar.eK = jSONObject.optBoolean("hb", false);
                cVar.fk = jSONObject.optInt(q);
                cVar.fl = jSONObject.optString(r);
                cVar.du = jSONObject.optInt(ay);
                cVar.dv = jSONObject.optInt(az);
                cVar.f7769de = jSONObject.optInt(x, -2);
                cVar.df = jSONObject.optInt(y, -2);
                cVar.dd = jSONObject.optInt("adspace_t", 1);
                c a2 = a(jSONObject, cVar);
                a2.dm = jSONObject.optInt("vcn");
                a2.dn = jSONObject.optInt("token_r");
                a2.f47do = jSONObject.optString("encrypt_p");
                a2.ds = jSONObject.optInt(v);
                a2.ag(jSONObject.optInt(aB, 2));
                a2.ah(jSONObject.optInt(aA, 1));
                JSONArray optJSONArray3 = jSONObject.optJSONArray(aC);
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    ArrayList<Integer> arrayList3 = new ArrayList<>();
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= optJSONArray3.length()) {
                            break;
                        }
                        arrayList3.add(Integer.valueOf(optJSONArray3.optInt(i5)));
                        i4 = i5 + 1;
                    }
                    if (arrayList3.size() > 0) {
                        a2.fu = arrayList3;
                    }
                }
                cVar2 = a2;
                a2.fC = jSONObject.optInt(g, 0);
                return a2;
            } catch (Exception e6) {
                e = e6;
                cVar2 = cVar;
                e.printStackTrace();
                return cVar2;
            }
        }
        return cVar2;
    }

    private static List<Map<Integer, String>> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i2 = 0;
            while (true) {
                try {
                    int i3 = i2;
                    if (i3 >= jSONArray.length()) {
                        break;
                    }
                    String string = jSONArray.getString(i3);
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject(string);
                        HashMap hashMap = new HashMap();
                        hashMap.put(Integer.valueOf(jSONObject.getInt(TextToSpeech.Engine.KEY_PARAM_RATE)), jSONObject.getString("url"));
                        arrayList.add(hashMap);
                    }
                    i2 = i3 + 1;
                } catch (Throwable th) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public static JSONArray b(List<c> list) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (list != null) {
            jSONArray2 = null;
            try {
                if (list.size() > 0) {
                    JSONArray jSONArray3 = new JSONArray();
                    try {
                        for (c cVar : list) {
                            jSONArray3.put(a(cVar));
                        }
                        return jSONArray3;
                    } catch (Exception e2) {
                        jSONArray = jSONArray3;
                        e = e2;
                        e.printStackTrace();
                        jSONArray2 = jSONArray;
                        return jSONArray2;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                jSONArray = null;
            }
        }
        return jSONArray2;
    }

    private void b(long j2) {
        this.dg = j2;
    }

    private int bA() {
        return this.dD;
    }

    private int bB() {
        return this.dz;
    }

    private int bC() {
        return this.dw;
    }

    private int bD() {
        return this.dx;
    }

    private int bE() {
        return this.dy;
    }

    private int bF() {
        return this.ev;
    }

    private String bG() {
        return this.eF;
    }

    private String bH() {
        return this.eG;
    }

    private String bI() {
        return this.eH;
    }

    private String bJ() {
        return this.eI;
    }

    private String bK() {
        return this.eJ;
    }

    private String bL() {
        return this.bK;
    }

    private String bM() {
        return this.fe;
    }

    private String bN() {
        return this.eD;
    }

    private String bO() {
        return this.fi;
    }

    private String bP() {
        return this.fj;
    }

    private int bQ() {
        return this.fg;
    }

    private long bR() {
        return this.fh;
    }

    private b bS() {
        return this.fn;
    }

    private int bT() {
        return this.eC;
    }

    private String bU() {
        return this.ew;
    }

    private String bV() {
        return this.ey;
    }

    private int bW() {
        return this.eA;
    }

    private String bX() {
        return this.eB;
    }

    private int bY() {
        return this.er;
    }

    private String bZ() {
        return this.es;
    }

    private int bj() {
        return this.cV;
    }

    private String bk() {
        return this.f47do;
    }

    private int bl() {
        int i2 = this.dn;
        if (i2 == 1) {
            return i2;
        }
        return 0;
    }

    private int bm() {
        int i2 = this.dm;
        if (i2 > 0) {
            return i2;
        }
        return 1;
    }

    private void bn() {
        this.dp = true;
    }

    private long bo() {
        return this.dh;
    }

    private p bp() {
        return this.aH;
    }

    private int bq() {
        return this.dK;
    }

    private int br() {
        return this.dL;
    }

    private String bs() {
        return this.dM;
    }

    private String bt() {
        return this.dI;
    }

    private int bu() {
        return this.dH;
    }

    private String bv() {
        return this.dF;
    }

    private String bw() {
        return this.dG;
    }

    private String bx() {
        return this.dA;
    }

    private int by() {
        return this.dB;
    }

    private String bz() {
        return this.dC;
    }

    private static JSONObject c(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            if (jSONObject.has(bM)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(bM);
                jSONObject2 = jSONObject;
                if (optJSONArray != null) {
                    jSONObject2 = jSONObject;
                    if (optJSONArray.length() > 0) {
                        jSONObject.remove(bM);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            jSONObject2 = jSONObject;
                            if (i3 >= optJSONArray.length()) {
                                break;
                            }
                            JSONObject a2 = com.anythink.expressad.foundation.c.a.a.a().a(optJSONArray.getString(i3));
                            if (a2 != null) {
                                Iterator<String> keys = a2.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    jSONObject.put(next, a2.opt(next));
                                }
                            }
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    private void c(long j2) {
        this.dh = j2;
    }

    private int ca() {
        return this.et;
    }

    private int cb() {
        return this.eq;
    }

    private int cc() {
        return this.em;
    }

    private boolean cd() {
        return this.ek;
    }

    private int ce() {
        return this.ei;
    }

    private int cf() {
        return this.ec;
    }

    private int cg() {
        return this.ed;
    }

    private int ch() {
        return this.dS;
    }

    private boolean ci() {
        return this.dY;
    }

    private int cj() {
        return this.eb;
    }

    private String ck() {
        return this.ea;
    }

    private String cl() {
        return this.eT;
    }

    private String cm() {
        return this.eY;
    }

    private int cn() {
        return this.fk;
    }

    private String co() {
        return this.fl;
    }

    private String cp() {
        return this.fr;
    }

    private String cq() {
        return this.ft;
    }

    private long cr() {
        return this.da;
    }

    private String cs() {
        ArrayList<Integer> arrayList = this.fu;
        if (arrayList == null || arrayList.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<Integer> it = this.fu.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 1, sb.length());
            }
            return !TextUtils.isEmpty(sb) ? sb.toString() : "";
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.d(f7765a, th.getMessage());
            return "";
        }
    }

    private int ct() {
        return this.fv;
    }

    private int cu() {
        return this.fx;
    }

    private boolean cv() {
        return this.fz;
    }

    private int cw() {
        return this.fC;
    }

    private void d(long j2) {
        this.dk = j2;
    }

    private void d(boolean z2) {
        this.eK = z2;
    }

    private void e(long j2) {
        this.fh = j2;
    }

    private void e(boolean z2) {
        this.ek = z2;
    }

    private void f(boolean z2) {
        this.dY = z2;
    }

    private boolean f(long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        return this.dg > 0 ? bg() + (this.dg * 1000) >= currentTimeMillis : bg() + j2 >= currentTimeMillis;
    }

    private void g(long j2) {
        this.da = j2;
    }

    private void g(boolean z2) {
        this.fy = z2;
    }

    private void h(boolean z2) {
        this.fz = z2;
    }

    private void r(int i2) {
        this.db = i2;
    }

    private void s(int i2) {
        this.dc = i2;
    }

    private void t(int i2) {
        this.dd = i2;
    }

    private void u(int i2) {
        this.f7769de = i2;
    }

    private void v(int i2) {
        this.dq = t.a(i2);
    }

    private void w(int i2) {
        this.du = i2;
    }

    private void x(int i2) {
        this.dv = i2;
    }

    private void y(int i2) {
        this.dK = i2;
    }

    private void z(int i2) {
        this.dL = i2;
    }

    public final boolean A() {
        return this.eK;
    }

    public final String B() {
        return this.eL;
    }

    public final int C() {
        return this.eQ;
    }

    public final int D() {
        return this.dN;
    }

    public final int E() {
        return this.dO;
    }

    public final int F() {
        return this.eP;
    }

    public final String G() {
        return this.eM;
    }

    public final boolean H() {
        return this.eN;
    }

    public final String I() {
        if (TextUtils.isEmpty(this.fb)) {
            return this.fb;
        }
        return this.fb + "&n_logo=0";
    }

    public final int J() {
        return this.fc;
    }

    public final String K() {
        return this.ff;
    }

    public final n L() {
        return this.fd;
    }

    public final C0143c M() {
        return this.fo;
    }

    public final int N() {
        return this.fm;
    }

    public final int O() {
        return this.ex;
    }

    public final String P() {
        return this.ez;
    }

    public final int Q() {
        return this.eu;
    }

    public final Map<Integer, String> R() {
        return ae(this.es);
    }

    public final String S() {
        return this.en;
    }

    public final int T() {
        return this.eo;
    }

    public final String U() {
        return this.ep;
    }

    public final boolean V() {
        return this.ej;
    }

    public final boolean W() {
        return this.el;
    }

    public final void X() {
        this.el = true;
    }

    public final int Y() {
        return this.fa;
    }

    public final String Z() {
        try {
            if (TextUtils.isEmpty(this.eg)) {
                if (TextUtils.isEmpty(this.dZ)) {
                    return null;
                }
                Uri parse = Uri.parse(this.dZ);
                if (parse != null) {
                    String queryParameter = parse.getQueryParameter("k");
                    this.eg = queryParameter;
                    this.eg = queryParameter;
                }
                return this.eg;
            }
            return this.eg;
        } catch (Exception e2) {
            return null;
        }
    }

    public final int a() {
        return this.db;
    }

    public final void a(int i2) {
        this.df = i2;
    }

    @Override // com.anythink.expressad.foundation.d.h
    public final void a(c.b bVar) {
        this.fp = bVar;
    }

    public final void a(String str) {
        this.cW = str;
        boolean e2 = t.e(str);
        int g2 = t.g(str);
        if (e2) {
            this.dp = true;
            v(g2);
        }
    }

    public final void a(List<String> list) {
        this.cZ = list;
    }

    public final void a(boolean z2) {
        this.dl = z2;
    }

    public final boolean a(long j2, long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.dg <= 0 ? bg() + j2 >= currentTimeMillis : bg() + (this.dg * 1000) >= currentTimeMillis) {
            return false;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        return this.dh > 0 ? bg() + (this.dh * 1000) >= currentTimeMillis2 : bg() + j3 >= currentTimeMillis2;
    }

    public final boolean aA() {
        return super.b(this);
    }

    public final ArrayList<Integer> aB() {
        return this.fu;
    }

    public final int aC() {
        return this.fw;
    }

    public final boolean aD() {
        return this.fy;
    }

    public final String aE() {
        return this.fA;
    }

    public final int aF() {
        return this.fB;
    }

    public final String aa() {
        try {
            if (TextUtils.isEmpty(this.eh)) {
                if (TextUtils.isEmpty(this.dU)) {
                    return "";
                }
                Uri parse = Uri.parse(this.dU);
                if (parse != null) {
                    String queryParameter = parse.getQueryParameter("k");
                    this.eh = queryParameter;
                    this.eh = queryParameter;
                }
                return this.eh;
            }
            return this.eh;
        } catch (Exception e2) {
            return "";
        }
    }

    public final String ab() {
        return this.ee;
    }

    public final String ac() {
        return this.ef;
    }

    public final String ad() {
        return this.dV;
    }

    public final int ae() {
        return this.dW;
    }

    public final String af() {
        return this.dX;
    }

    public final String ag() {
        return this.dT;
    }

    public final String ah() {
        return this.dU;
    }

    public final String ai() {
        return this.dZ;
    }

    @Override // com.anythink.expressad.foundation.d.h
    public final c.b aj() {
        return this.fp;
    }

    public final String ak() {
        if (TextUtils.isEmpty(this.dU)) {
            return "";
        }
        try {
            URL url = new URL(this.dU);
            return url.getProtocol() + "://" + url.getHost();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final List<String> al() {
        String str = this.eD;
        ArrayList arrayList = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList2 = new ArrayList();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    arrayList = arrayList2;
                    try {
                        if (i3 >= jSONArray.length()) {
                            break;
                        }
                        arrayList2.add(jSONArray.optString(i3));
                        i2 = i3 + 1;
                    } catch (Exception e2) {
                        arrayList = arrayList2;
                        e = e2;
                        e.printStackTrace();
                        return arrayList;
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            arrayList = null;
        }
        return arrayList;
    }

    public final boolean am() {
        return this.eO;
    }

    public final void an() {
        this.eO = true;
    }

    public final int ao() {
        return this.eR;
    }

    public final int ap() {
        return this.eU;
    }

    public final String aq() {
        return this.eV;
    }

    public final String ar() {
        return this.eW;
    }

    public final int as() {
        return this.eX;
    }

    public final boolean at() {
        return this.cY;
    }

    public final void au() {
        this.cY = true;
    }

    public final int av() {
        return this.eZ;
    }

    public final boolean aw() {
        return this.fq;
    }

    public final void ax() {
        this.fq = true;
    }

    public final boolean ay() {
        return (TextUtils.isEmpty(this.fr) || TextUtils.isEmpty(com.anythink.expressad.a.w)) ? false : true;
    }

    public final int az() {
        return this.fs;
    }

    public final int b() {
        return this.dc;
    }

    public final void b(int i2) {
        this.ds = i2;
    }

    public final void b(String str) {
        this.cX = str;
    }

    public final void b(boolean z2) {
        this.eN = z2;
    }

    public final String c() {
        return this.cW;
    }

    public final void c(int i2) {
        this.dn = i2;
    }

    public final void c(String str) {
        this.f47do = str;
    }

    public final void c(boolean z2) {
        this.ej = z2;
    }

    public final String d() {
        return this.cX;
    }

    public final void d(int i2) {
        this.dm = i2;
    }

    public final void d(String str) {
        this.di = x.c(str);
    }

    public final List<String> e() {
        return this.cZ;
    }

    public final void e(int i2) {
        this.dt = i2;
    }

    public final void e(String str) {
        this.dj = str;
    }

    public final int f() {
        return this.dd;
    }

    public final void f(int i2) {
        this.dE = i2;
    }

    public final void f(String str) {
        this.dF = str;
    }

    public final int g() {
        return this.f7769de;
    }

    public final void g(int i2) {
        this.dB = i2;
    }

    public final void g(String str) {
        this.dG = str;
    }

    public final int h() {
        return this.df;
    }

    public final void h(int i2) {
        this.dD = i2;
    }

    public final void h(String str) {
        this.dA = str;
    }

    public final int i() {
        return this.ds;
    }

    public final void i(int i2) {
        this.ev = i2;
    }

    public final void i(String str) {
        this.dC = str;
    }

    public final void j(int i2) {
        this.eU = i2;
    }

    public final void j(String str) {
        this.eM = str;
    }

    public final boolean j() {
        return this.dp;
    }

    public final int k() {
        return this.dq;
    }

    public final void k(int i2) {
        this.eX = i2;
    }

    public final void k(String str) {
        C0143c c0143c;
        this.fb = str;
        if (TextUtils.isEmpty(this.eV) && (((c0143c = this.fo) == null || TextUtils.isEmpty(c0143c.k)) && !TextUtils.isEmpty(str) && str.contains(d))) {
            this.eW = str;
        }
        this.fz = t.d(str);
    }

    public final void l(int i2) {
        this.eZ = i2;
    }

    public final void l(String str) {
        this.ff = str;
    }

    public final boolean l() {
        return this.dr;
    }

    public final void m() {
        this.dr = true;
    }

    public final void m(int i2) {
        this.fs = i2;
    }

    public final void m(String str) {
        this.ey = str;
    }

    public final int n() {
        return this.dt;
    }

    public final void n(int i2) {
        this.fB = i2;
    }

    public final void n(String str) {
        this.ez = x.c(str);
    }

    public final long o() {
        return this.dg;
    }

    @Override // com.anythink.expressad.out.j
    public final void o(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = this.eu != 2 ? "Learn more" : "Install";
        }
        super.o(str2);
    }

    public final String p() {
        return this.di;
    }

    public final void p(String str) {
        this.dV = str;
    }

    public final String q() {
        return this.dj;
    }

    public final void q(String str) {
        this.dU = str;
    }

    public final long r() {
        return this.dk;
    }

    public final void r(String str) {
        this.eV = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.eW = str;
        boolean e2 = t.e(str);
        int g2 = t.g(str);
        if (e2) {
            this.dp = true;
            v(g2);
        }
        this.fy = t.d(str);
    }

    public final void s(String str) {
        this.eY = str;
    }

    public final boolean s() {
        return this.dl;
    }

    public final int t() {
        return this.du;
    }

    public final void t(String str) {
        this.fA = str;
    }

    public final int u() {
        return this.dv;
    }

    public final a v() {
        return this.dJ;
    }

    public final int w() {
        return this.dE;
    }

    public final int x() {
        return this.dQ;
    }

    public final String y() {
        return this.dR;
    }

    public final HashMap<String, String> z() {
        return this.eE;
    }
}
