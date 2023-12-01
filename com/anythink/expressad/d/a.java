package com.anythink.expressad.d;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.d;
import com.anythink.expressad.foundation.h.h;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.cdo.oaps.ad.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/d/a.class */
public final class a {
    private int A;
    private String B;
    private long C;
    private int D;
    private long E;
    private long F;
    private int G;
    private int H;
    private int I;
    private String J;
    private String K;
    private int L;
    private List<com.anythink.expressad.foundation.d.c> M;
    private List<com.anythink.expressad.foundation.d.b> N;
    private int R;
    private LinkedList<String> S;
    private int Y;
    private List<String> Z;
    private int aE;
    private long aG;
    private long aH;
    private int aI;
    private int aJ;
    private long aK;
    private int aM;
    private int aa;
    private int ab;
    private int ac;
    private int ad;
    private String ae;
    private String af;
    private String ao;
    private String b;
    private Map<String, C0117a> be;
    private b bg;
    private String bl;
    private String bm;

    /* renamed from: c  reason: collision with root package name */
    private long f7125c;
    private int d;
    private int f;
    private boolean g;
    private Map<String, String> h;
    private boolean i;
    private long j;
    private List<c> l;
    private boolean m;
    private long n;
    private long o;
    private long p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private long u;
    private List<String> v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* renamed from: a  reason: collision with root package name */
    private int f7123a = 0;
    private long e = 86400;
    private String k = "";
    private boolean O = false;
    private int P = 3;
    private boolean Q = true;
    private int T = 0;
    private int U = 3600;
    private int V = 10;
    private int W = 120;
    private String X = "";
    private int ag = 1;
    private int ah = 1;
    private int ai = 1;
    private int aj = 0;
    private int ak = 1;
    private String al = "";
    private int am = 0;
    private int an = 2;
    private int ap = 86400;
    private String aq = "LdxThdi1WBK\\/WgfPhbxQYkeXHBPwHZKAJ7eXHM==";

    /* renamed from: ar  reason: collision with root package name */
    private String f7124ar = "LdxThdi1WBK\\/WgfPhbxQYkeXHBPwHZKsYFh=";
    private int as = 1;
    private int at = 30;
    private int au = 5;
    private int av = 0;
    private int aw = 0;
    private int ax = 9377;
    private int ay = 0;
    private int az = 0;
    private int aA = 0;
    private int aB = 2;
    private int aC = 10;
    private List<Integer> aD = new ArrayList();
    private int aF = 1;
    private int aL = 3;
    private String aN = "";
    private String aO = "";
    private String aP = "";
    private String aQ = "";
    private String aR = "";
    private int aS = 0;
    private int aT = 21600;
    private int aU = 2;
    private int aV = 0;
    private int aW = 0;
    private int aX = 604800;
    private int aY = 0;
    private String aZ = "";
    private String ba = "";
    private String bb = "";
    private String bc = "";
    private String bd = "";
    private int bf = 0;
    private int bh = 0;
    private String bi = "";
    private int bj = 2;
    private int bk = p.j;
    private int bn = 0;
    private boolean bo = false;
    private int bp = 1;
    private int bq = 0;
    private int br = 0;
    private int bs = 0;
    private int bt = 3;
    private int bu = 600;
    private int bv = 10;

    /* renamed from: com.anythink.expressad.d.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/d/a$a.class */
    public static final class C0117a {

        /* renamed from: a  reason: collision with root package name */
        private List<String> f7126a;
        private List<String> b;

        /* renamed from: c  reason: collision with root package name */
        private List<String> f7127c;
        private List<String> d;

        private List<String> a() {
            return this.f7126a;
        }

        private void a(List<String> list) {
            this.f7126a = list;
        }

        private List<String> b() {
            return this.b;
        }

        private void b(List<String> list) {
            this.b = list;
        }

        private List<String> c() {
            return this.f7127c;
        }

        private void c(List<String> list) {
            this.f7127c = list;
        }

        private List<String> d() {
            return this.d;
        }

        private void d(List<String> list) {
            this.d = list;
        }

        public final void a(JSONObject jSONObject) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("x");
                if (optJSONArray != null) {
                    this.f7126a = h.a(optJSONArray);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("y");
                if (optJSONArray2 != null) {
                    this.b = h.a(optJSONArray2);
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("width");
                if (optJSONArray3 != null) {
                    this.f7127c = h.a(optJSONArray3);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("height");
                if (optJSONArray4 != null) {
                    this.d = h.a(optJSONArray4);
                }
            } catch (Exception e) {
                if (com.anythink.expressad.a.f6941a) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/d/a$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private String f7128a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f7129c;
        private JSONArray d;

        public static b a(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            if (jSONObject == null) {
                jSONObject2 = new JSONObject();
            }
            b bVar = new b();
            Context g = n.a().g();
            bVar.f7128a = jSONObject2.optString("title", g.getString(i.a(g, "anythink_cm_feedback_dialog_title", "string")));
            bVar.b = jSONObject2.optString(com.anythink.expressad.d.a.b.dO, g.getString(i.a(g, "anythink_cm_feedback_dialog_close_close", "string")));
            bVar.f7129c = jSONObject2.optString(com.anythink.expressad.d.a.b.dP, g.getString(i.a(g, "anythink_cm_feedback_dialog_close_submit", "string")));
            JSONArray optJSONArray = jSONObject2.optJSONArray("content");
            bVar.d = optJSONArray;
            if (optJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                bVar.d = jSONArray;
                jSONArray.put(g.getString(i.a(g, "anythink_cm_feedback_dialog_content_stuck", "string")));
                bVar.d.put(g.getString(i.a(g, "anythink_cm_feedback_dialog_content_cnr", "string")));
                bVar.d.put(g.getString(i.a(g, "anythink_cm_feedback_dialog_content_balck_screen", "string")));
                bVar.d.put(g.getString(i.a(g, "anythink_cm_feedback_dialog_content_other", "string")));
            }
            return bVar;
        }

        private void a(String str) {
            this.f7128a = str;
        }

        private void a(JSONArray jSONArray) {
            this.d = jSONArray;
        }

        private void b(String str) {
            this.b = str;
        }

        private void c(String str) {
            this.f7129c = str;
        }

        public final String a() {
            return this.f7128a;
        }

        public final String b() {
            return this.b;
        }

        public final String c() {
            return this.f7129c;
        }

        public final JSONArray d() {
            return this.d;
        }
    }

    private void A(int i) {
        this.t = i;
    }

    private void A(String str) {
        this.bm = str;
    }

    private void B(int i) {
        this.A = i;
    }

    private void C(int i) {
        this.x = i;
    }

    private void D(int i) {
        this.y = i;
    }

    private void E(int i) {
        this.z = i;
    }

    private void F(int i) {
        this.aL = i;
    }

    private void G(int i) {
        this.aI = i;
    }

    private void H(int i) {
        this.aJ = i;
    }

    private void I(int i) {
        this.f = i;
    }

    private void J(int i) {
        this.r = i;
    }

    private void K(int i) {
        this.s = i;
    }

    private void L(int i) {
        this.aY = i;
    }

    private void M(int i) {
        this.aS = i;
    }

    private void N(int i) {
        this.aT = i;
    }

    private void O(int i) {
        this.aU = i;
    }

    private void P(int i) {
        this.aV = i;
    }

    private void Q(int i) {
        this.aW = i;
    }

    private void R(int i) {
        this.aX = i;
    }

    private void S(int i) {
        this.at = i;
    }

    private void T(int i) {
        this.au = i;
    }

    private void U(int i) {
        this.av = i;
    }

    private void V(int i) {
        this.aw = i;
    }

    private void W(int i) {
        this.ax = i;
    }

    private int X() {
        return this.R;
    }

    private void X(int i) {
        this.P = i;
    }

    private List<com.anythink.expressad.foundation.d.b> Y() {
        return this.N;
    }

    private void Y(int i) {
        this.bf = i;
    }

    private String Z() {
        return this.X;
    }

    private void Z(int i) {
        this.bh = i;
    }

    public static String a(Context context, String str) {
        try {
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.foundation.b.a.b().e();
            a b2 = com.anythink.expressad.d.b.b();
            String str2 = "";
            if (b2 != null) {
                if (b2.h != null) {
                    String host = Uri.parse(str).getHost();
                    Iterator<Map.Entry<String, String>> it = b2.h.entrySet().iterator();
                    while (true) {
                        str2 = "";
                        if (!it.hasNext()) {
                            break;
                        }
                        String key = it.next().getKey();
                        if (!TextUtils.isEmpty(host) && host.contains(key)) {
                            String str3 = b2.h.get(key);
                            if (TextUtils.isEmpty(str3)) {
                                return "";
                            }
                            str2 = str3.replace("{gaid}", d.f());
                            if (str2.contains(com.anythink.expressad.d.a.b.I)) {
                                if (d.d(context) != null) {
                                    return str2.replace(com.anythink.expressad.d.a.b.I, d.d(context));
                                }
                            } else if (str2.contains(com.anythink.expressad.d.a.b.H) && d.e(context) != null) {
                                return str2.replace(com.anythink.expressad.d.a.b.H, d.e(context));
                            }
                        }
                    }
                } else {
                    return "";
                }
            }
            return str2;
        } catch (Throwable th) {
            return "";
        }
    }

    private void a(long j) {
        this.E = j;
    }

    private void a(b bVar) {
        this.bg = bVar;
    }

    private void a(LinkedList<String> linkedList) {
        this.S = linkedList;
    }

    private void a(List<com.anythink.expressad.foundation.d.b> list) {
        this.N = list;
    }

    private void a(Map<String, String> map) {
        this.h = map;
    }

    private void a(boolean z) {
        this.g = z;
    }

    private int aA() {
        return this.aE;
    }

    private int aB() {
        return this.Y;
    }

    private List<String> aC() {
        return this.Z;
    }

    private int aD() {
        return this.aa;
    }

    private int aE() {
        return this.ab;
    }

    private int aF() {
        return this.ac;
    }

    private int aG() {
        return this.ad;
    }

    private String aH() {
        return this.ae;
    }

    private int aI() {
        return this.G;
    }

    private int aJ() {
        return this.H;
    }

    private List<com.anythink.expressad.foundation.d.c> aK() {
        return this.M;
    }

    private int aL() {
        return this.I;
    }

    private String aM() {
        return this.J;
    }

    private int aN() {
        return this.D;
    }

    private long aO() {
        return this.E;
    }

    private long aP() {
        return this.F;
    }

    private long aQ() {
        return this.C * 1000;
    }

    private int aR() {
        return this.t;
    }

    private String aS() {
        return this.B;
    }

    private int aT() {
        return this.x;
    }

    private int aU() {
        return this.y;
    }

    private int aV() {
        return this.z;
    }

    private int aW() {
        return this.aL;
    }

    private long aX() {
        return this.aK;
    }

    private int aY() {
        return this.aI;
    }

    private int aZ() {
        return this.aJ;
    }

    private int aa() {
        return this.V;
    }

    private void aa(int i) {
        this.bj = i;
    }

    private LinkedList<String> ab() {
        return this.S;
    }

    private void ab(int i) {
        this.bk = i;
    }

    private int ac() {
        return this.f7123a;
    }

    private void ac(int i) {
        this.bp = i;
    }

    private int ad() {
        return this.T;
    }

    private void ad(int i) {
        this.br = i;
    }

    private int ae() {
        return this.U * 1000;
    }

    private void ae(int i) {
        this.bs = i;
    }

    private int af() {
        return this.aC;
    }

    private void af(int i) {
        this.bt = i;
    }

    private int ag() {
        return this.ay;
    }

    private void ag(int i) {
        this.bu = i;
    }

    private int ah() {
        return this.az;
    }

    private void ah(int i) {
        this.bv = i;
    }

    private int ai() {
        return this.aA;
    }

    private int aj() {
        return this.aB;
    }

    private int ak() {
        return this.as;
    }

    private String al() {
        return this.aq;
    }

    private String am() {
        return this.f7124ar;
    }

    private int an() {
        return this.ap;
    }

    private int ao() {
        return this.an;
    }

    private String ap() {
        return this.ao;
    }

    private int aq() {
        return this.ag;
    }

    private int ar() {
        return this.ah;
    }

    private int as() {
        return this.ai;
    }

    private int at() {
        return this.aj;
    }

    private int au() {
        return this.ak;
    }

    private String av() {
        return this.al;
    }

    private int aw() {
        return this.am;
    }

    private int ax() {
        return this.L;
    }

    private String ay() {
        return this.K;
    }

    private int az() {
        return this.aF;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(81:7|8|(2:10|11)(1:206)|12|13|(2:15|16)(1:205)|17|18|19|20|21|22|23|24|(3:28|(2:29|(2:31|32)(1:33))|34)|35|36|37|(1:39)(1:204)|40|41|42|(1:44)(2:193|(3:197|(2:198|(2:200|201)(1:202))|203))|45|46|(1:192)(2:50|(3:51|52|(3:54|(2:56|57)(1:59)|58)(1:60)))|61|(1:63)|64|65|66|67|(3:69|70|(2:72|(3:73|74|(3:76|(2:78|79)(1:81)|80)(1:82)))(0))(0)|83|(1:85)|87|88|(3:92|(2:93|(2:95|96)(1:97))|98)|99|100|(1:102)|103|104|105|(1:107)|189|109|(34:113|(2:114|(4:116|(5:120|(3:125|126|127)|128|117|118)|131|132)(0))|134|(1:138)|140|141|142|143|144|(2:146|147)(1:185)|148|(1:150)(1:184)|151|152|153|154|155|156|157|(1:159)|160|161|(1:163)|164|165|(1:167)|168|169|(1:171)|172|173|(1:175)|176|177)(0)|133|134|(2:136|138)|140|141|142|143|144|(0)(0)|148|(0)(0)|151|152|153|154|155|156|157|(0)|160|161|(0)|164|165|(0)|168|169|(0)|172|173|(0)|176|177) */
    /* JADX WARN: Can't wrap try/catch for region: R(83:5|6|7|8|(2:10|11)(1:206)|12|13|(2:15|16)(1:205)|17|18|19|20|21|22|23|24|(3:28|(2:29|(2:31|32)(1:33))|34)|35|36|37|(1:39)(1:204)|40|41|42|(1:44)(2:193|(3:197|(2:198|(2:200|201)(1:202))|203))|45|46|(1:192)(2:50|(3:51|52|(3:54|(2:56|57)(1:59)|58)(1:60)))|61|(1:63)|64|65|66|67|(3:69|70|(2:72|(3:73|74|(3:76|(2:78|79)(1:81)|80)(1:82)))(0))(0)|83|(1:85)|87|88|(3:92|(2:93|(2:95|96)(1:97))|98)|99|100|(1:102)|103|104|105|(1:107)|189|109|(34:113|(2:114|(4:116|(5:120|(3:125|126|127)|128|117|118)|131|132)(0))|134|(1:138)|140|141|142|143|144|(2:146|147)(1:185)|148|(1:150)(1:184)|151|152|153|154|155|156|157|(1:159)|160|161|(1:163)|164|165|(1:167)|168|169|(1:171)|172|173|(1:175)|176|177)(0)|133|134|(2:136|138)|140|141|142|143|144|(0)(0)|148|(0)(0)|151|152|153|154|155|156|157|(0)|160|161|(0)|164|165|(0)|168|169|(0)|172|173|(0)|176|177) */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0720, code lost:
        if (r0 < 0) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x085b, code lost:
        r18 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x085d, code lost:
        com.anythink.expressad.foundation.h.o.d("Setting", r18.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0831  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0844  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x08bc A[Catch: Exception -> 0x0943, TRY_ENTER, TryCatch #5 {Exception -> 0x0943, blocks: (B:158:0x0886, B:161:0x08bc, B:165:0x08c6, B:169:0x08d2, B:173:0x08df, B:175:0x08e5, B:178:0x090d), top: B:207:0x0886 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x08c6 A[Catch: Exception -> 0x0943, TRY_ENTER, TryCatch #5 {Exception -> 0x0943, blocks: (B:158:0x0886, B:161:0x08bc, B:165:0x08c6, B:169:0x08d2, B:173:0x08df, B:175:0x08e5, B:178:0x090d), top: B:207:0x0886 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x08d2 A[Catch: Exception -> 0x0943, TRY_ENTER, TryCatch #5 {Exception -> 0x0943, blocks: (B:158:0x0886, B:161:0x08bc, B:165:0x08c6, B:169:0x08d2, B:173:0x08df, B:175:0x08e5, B:178:0x090d), top: B:207:0x0886 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x08df A[Catch: Exception -> 0x0943, TRY_ENTER, TryCatch #5 {Exception -> 0x0943, blocks: (B:158:0x0886, B:161:0x08bc, B:165:0x08c6, B:169:0x08d2, B:173:0x08df, B:175:0x08e5, B:178:0x090d), top: B:207:0x0886 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0907  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0961  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0967  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.expressad.d.a b(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 2416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.d.a.b(java.lang.String):com.anythink.expressad.d.a");
    }

    private void b(long j) {
        this.C = j;
    }

    private void b(List<String> list) {
        this.Z = list;
    }

    private void b(Map<String, C0117a> map) {
        this.be = map;
    }

    private void b(boolean z) {
        this.O = z;
    }

    private int bA() {
        return this.aX;
    }

    private String bB() {
        return this.bc;
    }

    private String bC() {
        return this.bd;
    }

    private Map<String, C0117a> bD() {
        return this.be;
    }

    private boolean bE() {
        return (TextUtils.isEmpty(this.aZ) || TextUtils.isEmpty(this.bb) || TextUtils.isEmpty(this.ba)) ? false : true;
    }

    private int bF() {
        return this.at;
    }

    private int bG() {
        return this.au;
    }

    private int bH() {
        return this.av;
    }

    private int bI() {
        return this.aw;
    }

    private int bJ() {
        return this.ax;
    }

    private boolean bK() {
        return this.O;
    }

    private int bL() {
        return this.P;
    }

    private boolean bM() {
        return this.Q;
    }

    private int bN() {
        return this.bh;
    }

    private String bO() {
        return this.bi;
    }

    private int bP() {
        return this.bj;
    }

    private int bQ() {
        return this.bk;
    }

    private String bR() {
        return this.bm;
    }

    private int bS() {
        return this.bn;
    }

    private boolean bT() {
        return this.bo;
    }

    private int bU() {
        return this.bq;
    }

    private long ba() {
        return this.p;
    }

    private long bb() {
        return this.o;
    }

    private String bc() {
        return this.b;
    }

    private long bd() {
        return this.f7125c;
    }

    private int be() {
        return this.d;
    }

    private long bf() {
        return this.e;
    }

    private int bg() {
        return this.f;
    }

    private List<c> bh() {
        return this.l;
    }

    private String bi() {
        return this.af;
    }

    private String bj() {
        return this.k;
    }

    private long bk() {
        return this.j;
    }

    private Map<String, String> bl() {
        return this.h;
    }

    private boolean bm() {
        return this.g;
    }

    private boolean bn() {
        return this.i;
    }

    private int bo() {
        return this.r;
    }

    private int bp() {
        return this.s;
    }

    private static boolean bq() {
        try {
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.foundation.b.a.b().e();
            a b2 = com.anythink.expressad.d.b.b();
            if (b2 != null) {
                return b2.g;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    private String br() {
        return this.aQ;
    }

    private boolean bs() {
        return (TextUtils.isEmpty(this.aN) || TextUtils.isEmpty(this.aO) || TextUtils.isEmpty(this.aP) || TextUtils.isEmpty(this.aQ)) ? false : true;
    }

    private boolean bt() {
        return (TextUtils.isEmpty(this.aN) || TextUtils.isEmpty(this.aO) || TextUtils.isEmpty(this.aP) || TextUtils.isEmpty(this.aR)) ? false : true;
    }

    private int bu() {
        return this.aY;
    }

    private int bv() {
        return this.aS;
    }

    private int bw() {
        return this.aT;
    }

    private int bx() {
        return this.aU;
    }

    private int by() {
        return this.aV;
    }

    private int bz() {
        return this.aW;
    }

    private void c(long j) {
        this.aG = j;
    }

    private void c(List<com.anythink.expressad.foundation.d.c> list) {
        this.M = list;
    }

    private void c(boolean z) {
        this.Q = z;
    }

    private void d(long j) {
        this.p = j;
    }

    private void d(String str) {
        this.X = str;
    }

    private void d(List<c> list) {
        this.l = list;
    }

    private void e(long j) {
        this.f7125c = j;
    }

    private void e(String str) {
        this.aq = str;
    }

    private void f(long j) {
        this.e = j;
    }

    private void f(String str) {
        this.f7124ar = str;
    }

    private void g(int i) {
        this.V = i;
    }

    private void g(long j) {
        this.j = j;
    }

    private void g(String str) {
        this.ao = str;
    }

    private void h(int i) {
        this.T = i;
    }

    private void h(String str) {
        this.al = str;
    }

    private void i(int i) {
        this.U = i;
    }

    private void i(String str) {
        this.ae = str;
    }

    private void j(int i) {
        this.aD.add(Integer.valueOf(i));
    }

    private void j(String str) {
        this.J = str;
    }

    private void k(String str) {
        this.B = str;
    }

    private boolean k(int i) {
        return this.aD.contains(Integer.valueOf(i));
    }

    private void l(int i) {
        this.as = i;
    }

    private void l(String str) {
        this.b = str;
    }

    private void m(int i) {
        this.ap = i;
    }

    private void m(String str) {
        this.af = str;
    }

    private void n(int i) {
        this.an = i;
    }

    private void n(String str) {
        this.k = str;
    }

    private void o(int i) {
        this.aF = i;
    }

    private void o(String str) {
        this.aN = str;
    }

    private void p(int i) {
        this.aE = i;
    }

    private void p(String str) {
        this.aO = str;
    }

    private void q(int i) {
        this.Y = i;
    }

    private void q(String str) {
        this.aP = str;
    }

    private void r(int i) {
        this.aa = i;
    }

    private void r(String str) {
        this.aQ = str;
    }

    private void s(int i) {
        this.ab = i;
    }

    private void s(String str) {
        this.aR = str;
    }

    private void t(int i) {
        this.ac = i;
    }

    private void t(String str) {
        this.aZ = str;
    }

    private void u(int i) {
        this.ad = i;
    }

    private void u(String str) {
        this.ba = str;
    }

    private void v(int i) {
        this.G = i;
    }

    private void v(String str) {
        this.bb = str;
    }

    private void w(int i) {
        this.H = i;
    }

    private void w(String str) {
        this.bc = str;
    }

    private void x(int i) {
        this.I = i;
    }

    private void x(String str) {
        this.bd = str;
    }

    private static Map<String, C0117a> y(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                C0117a c0117a = new C0117a();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    c0117a.a(optJSONObject);
                }
                hashMap.put(next, c0117a);
            }
            return hashMap;
        } catch (JSONException e) {
            if (com.anythink.expressad.a.f6941a) {
                e.printStackTrace();
                return null;
            }
            return null;
        } catch (Exception e2) {
            if (com.anythink.expressad.a.f6941a) {
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }

    private void y(int i) {
        this.D = i;
    }

    private void z(int i) {
        this.F = i;
    }

    private void z(String str) {
        this.bl = str;
    }

    public final void A() {
        this.d = 1;
    }

    public final void B() {
        this.i = true;
    }

    public final String C() {
        return this.aN;
    }

    public final String D() {
        return this.aO;
    }

    public final String E() {
        return this.aP;
    }

    public final String F() {
        return this.aR;
    }

    public final void G() {
        String language = Locale.getDefault().getLanguage();
        if (!((TextUtils.isEmpty(this.aN) || TextUtils.isEmpty(this.aO) || TextUtils.isEmpty(this.aP) || TextUtils.isEmpty(this.aQ)) ? false : true)) {
            if (TextUtils.isEmpty(language) || !language.equals(com.anythink.expressad.video.dynview.a.a.V)) {
                this.aN = "Confirm to close? ";
                this.aO = "You will not be rewarded after closing the window";
                this.aP = "Close it";
                this.aQ = "Continue";
            } else {
                this.aN = "确认关闭？";
                this.aO = "关闭后您将不会获得任何奖励噢~ ";
                this.aP = "确认关闭";
                this.aQ = "继续观看";
            }
        }
        if ((TextUtils.isEmpty(this.aN) || TextUtils.isEmpty(this.aO) || TextUtils.isEmpty(this.aP) || TextUtils.isEmpty(this.aR)) ? false : true) {
            return;
        }
        if (TextUtils.isEmpty(language) || !language.equals(com.anythink.expressad.video.dynview.a.a.V)) {
            this.aN = "Confirm to close? ";
            this.aO = "You will not be rewarded after closing the window";
            this.aP = "Close it";
            this.aR = "Continue";
            return;
        }
        this.aN = "确认关闭？";
        this.aO = "关闭后您将不会获得任何奖励噢~ ";
        this.aP = "确认关闭";
        this.aR = "继续试玩";
    }

    public final String H() {
        return this.aZ;
    }

    public final String I() {
        return this.ba;
    }

    public final String J() {
        return this.bb;
    }

    public final int K() {
        return this.bf;
    }

    public final b L() {
        return this.bg;
    }

    public final String M() {
        return this.bl;
    }

    public final void N() {
        this.bn = 0;
    }

    public final void O() {
        this.bo = false;
    }

    public final int P() {
        return this.bp;
    }

    public final void Q() {
        this.bq = 1;
    }

    public final String R() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cc", this.b);
            jSONObject.put(com.anythink.expressad.d.a.b.l, this.f7125c);
            jSONObject.put(com.anythink.expressad.d.a.b.m, this.d);
            jSONObject.put(com.anythink.expressad.d.a.b.p, this.f);
            jSONObject.put(com.anythink.expressad.d.a.b.w, this.g);
            jSONObject.put(com.anythink.expressad.d.a.b.o, this.i);
            jSONObject.put("plct", this.n);
            jSONObject.put(com.anythink.expressad.d.a.b.B, this.o);
            jSONObject.put(com.anythink.expressad.d.a.b.C, this.m);
            jSONObject.put(com.anythink.expressad.d.a.b.G, this.q);
            jSONObject.put("plctb", this.u);
            jSONObject.put(com.anythink.expressad.d.a.b.ab, this.aG);
            jSONObject.put(com.anythink.expressad.d.a.b.ac, this.aH);
            jSONObject.put(com.anythink.expressad.d.a.b.af, this.y);
            jSONObject.put(com.anythink.expressad.d.a.b.ag, this.z);
            jSONObject.put(com.anythink.expressad.d.a.b.i, this.J);
            jSONObject.put(com.anythink.expressad.d.a.b.j, this.K);
            jSONObject.put(com.anythink.expressad.d.a.b.k, this.L);
            jSONObject.put(com.anythink.expressad.d.a.b.ai, this.aK);
            jSONObject.put(com.anythink.expressad.d.a.b.aa, this.x);
            jSONObject.put(com.anythink.expressad.d.a.b.aG, this.F);
            jSONObject.put(com.anythink.expressad.d.a.b.aE, this.D);
            jSONObject.put(com.anythink.expressad.d.a.b.aF, this.E);
            jSONObject.put(com.anythink.expressad.d.a.b.ae, this.aJ);
            jSONObject.put(com.anythink.expressad.d.a.b.bn, this.aL);
            jSONObject.put(com.anythink.expressad.d.a.b.bv, this.aF);
            jSONObject.put("iex", this.I);
            jSONObject.put(com.anythink.expressad.d.a.b.ao, this.G);
            jSONObject.put(com.anythink.expressad.d.a.b.ap, this.H);
            jSONObject.put(com.anythink.expressad.d.a.b.at, this.aM);
            jSONObject.put(com.anythink.expressad.d.a.b.al, this.aE);
            jSONObject.put("pf", this.Y);
            jSONObject.put(com.anythink.expressad.d.a.b.aA, this.aa);
            jSONObject.put("pid", this.ae);
            jSONObject.put(com.anythink.expressad.d.a.b.ax, this.ab);
            jSONObject.put("add", this.ac);
            jSONObject.put("delete", this.ad);
            jSONObject.put(com.anythink.expressad.d.a.b.ad, this.aI);
            jSONObject.put(com.anythink.expressad.d.a.b.bE, this.ah);
            jSONObject.put(com.anythink.expressad.d.a.b.bF, this.ag);
            jSONObject.put(com.anythink.expressad.d.a.b.bG, this.ai);
            jSONObject.put("sc", this.aj);
            jSONObject.put(com.anythink.expressad.d.a.b.bI, this.ak);
            jSONObject.put(com.anythink.expressad.d.a.b.bK, this.am);
            jSONObject.put(com.anythink.expressad.d.a.b.bJ, this.al);
            jSONObject.put(com.anythink.expressad.d.a.b.bV, this.an);
            jSONObject.put(com.anythink.expressad.d.a.b.bY, this.ap);
            jSONObject.put(com.anythink.expressad.d.a.b.cO, this.f7123a);
            jSONObject.put(com.anythink.expressad.d.a.b.cT, this.bi);
            jSONObject.put(com.anythink.expressad.d.a.b.di, this.W);
            jSONObject.put(com.anythink.expressad.d.a.b.dg, this.V);
            jSONObject.put(com.anythink.expressad.d.a.b.dw, this.bo);
            jSONObject.put(com.anythink.expressad.d.a.b.dt, this.bn);
            jSONObject.put("isDefault", this.bq);
            return jSONObject.toString();
        } catch (Throwable th) {
            o.d("Setting", th.getMessage());
            return null;
        }
    }

    public final int S() {
        return this.br;
    }

    public final int T() {
        return this.bs;
    }

    public final int U() {
        return this.bt;
    }

    public final int V() {
        return this.bu;
    }

    public final int W() {
        return this.bv;
    }

    public final void a() {
        this.R = 10;
    }

    public final void a(int i) {
        this.W = i;
    }

    public final void a(String str) {
        this.K = str;
    }

    public final int b() {
        return this.W;
    }

    public final void b(int i) {
        if (i > 0) {
            this.aC = i;
        }
    }

    public final void c() {
        this.f7123a = 0;
    }

    public final void c(int i) {
        this.ay = i;
    }

    public final void c(String str) {
        this.bi = str;
    }

    public final void d() {
        this.ag = 1;
    }

    public final void d(int i) {
        this.az = i;
    }

    public final void e() {
        this.ah = 1;
    }

    public final void e(int i) {
        this.aA = i;
    }

    public final void f() {
        this.ai = 1;
    }

    public final void f(int i) {
        this.aB = i;
    }

    public final void g() {
        this.aj = 0;
    }

    public final void h() {
        this.ak = 1;
    }

    public final void i() {
        this.am = -1;
    }

    public final void j() {
        this.L = 1;
    }

    public final int k() {
        return this.A;
    }

    public final long l() {
        if (this.u <= 0) {
            this.u = com.anythink.expressad.d.a.b.Q;
        }
        return this.u;
    }

    public final void m() {
        this.u = com.anythink.expressad.d.a.b.Q;
    }

    public final int n() {
        return this.aM;
    }

    public final void o() {
        this.aM = com.anythink.expressad.d.a.b.bx;
    }

    public final void p() {
        this.aK = com.anythink.expressad.d.a.b.aC;
    }

    public final long q() {
        return this.aG * 1000;
    }

    public final long r() {
        return this.aH * 1000;
    }

    public final void s() {
        this.aH = 10L;
    }

    public final boolean t() {
        return this.q;
    }

    public final String toString() {
        return "cc=" + this.b + " upal=" + this.f7125c + " cfc=" + this.d + " getpf=" + this.e + " uplc=" + this.f + " rurl=" + this.m;
    }

    public final void u() {
        this.q = false;
    }

    public final boolean v() {
        return this.m;
    }

    public final void w() {
        this.m = false;
    }

    public final long x() {
        return this.n;
    }

    public final void y() {
        this.n = com.anythink.expressad.d.a.b.P;
    }

    public final void z() {
        this.o = 0L;
    }
}
