package com.anythink.expressad.videocommon.e;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/e/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5932a = 2;
    private static com.anythink.expressad.foundation.c.c ak;
    public static final int b = 4;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5933c = 5;
    public static final int d = 6;
    public static final int e = 7;
    public static final int f = -2;
    public static final int g = 1;
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 0;
    public static final int l = -1;
    public static final int m = 5;
    public static final int n = 0;
    public static final int o = 2;
    public static final int p = 2;
    public static final int q = -1;
    public static final int r = -2;
    public static final int s = -3;
    public static final int t = 1;
    public static final int u = -1;
    public static final int v = 1;
    public static final int w = 2;
    public static String x;
    private List<com.anythink.expressad.videocommon.c.b> A;
    private long B;
    private ArrayList<Integer> V;
    private int ai;
    private int al;
    private String y;
    private String z;
    private int C = -1;
    private int D = 0;
    private int E = 0;
    private int F = 1;
    private int G = 1;
    private int H = 1;
    private int I = 1;
    private double J = 1.0d;
    private int K = 2;
    private int L = 5;
    private int M = 1;
    private int N = 3;
    private int O = 80;
    private int P = 100;
    private int Q = 0;
    private double R = 1.0d;
    private int S = -1;
    private int T = 2;
    private double U = 1.0d;
    private int W = 3;
    private int X = 1;
    private int Y = 0;
    private int Z = 10;
    private int aa = 60;
    private String ab = "";
    private int ac = 0;
    private int ad = 70;
    private int ae = 0;
    private int af = -1;
    private int ag = -1;
    private int ah = -1;
    private int aj = 20;
    private int am = 0;
    private int an = 1;
    private String ao = "";
    private int ap = 1;
    private String aq = "";

    /* renamed from: ar  reason: collision with root package name */
    private int f5934ar = 1;
    private String as = "Virtual Item";
    private int at = 0;
    private int au = 1;
    private int av = 60;

    public static String J() {
        return x;
    }

    private String W() {
        return this.ab;
    }

    private int X() {
        return this.Z;
    }

    private int Y() {
        return this.aa;
    }

    private ArrayList<Integer> Z() {
        return this.V;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x01f1, code lost:
        if (r0 <= 0) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.expressad.videocommon.e.d a(org.json.JSONObject r6) {
        /*
            Method dump skipped, instructions count: 742
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.videocommon.e.d.a(org.json.JSONObject):com.anythink.expressad.videocommon.e.d");
    }

    private void a(double d2) {
        this.J = d2;
    }

    private void a(long j2) {
        this.B = j2;
    }

    private int aa() {
        return this.ae;
    }

    private int ab() {
        return this.D;
    }

    private int ac() {
        return this.am;
    }

    private int ad() {
        return this.an;
    }

    private String ae() {
        return this.ao;
    }

    private String af() {
        return this.aq;
    }

    private int ag() {
        return this.f5934ar;
    }

    private int ah() {
        return this.N;
    }

    private int ai() {
        return this.O;
    }

    private int aj() {
        return this.G;
    }

    private int ak() {
        return this.I;
    }

    private double al() {
        return this.J;
    }

    private int am() {
        return this.K;
    }

    private int an() {
        return this.F;
    }

    private long ao() {
        return this.B;
    }

    private String ap() {
        return this.y;
    }

    private double aq() {
        return this.R;
    }

    private int ar() {
        return this.W;
    }

    private Queue<Integer> as() {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3 = null;
        try {
        } catch (Exception e2) {
            e = e2;
            linkedList = null;
        }
        if (this.A != null) {
            linkedList3 = null;
            if (this.A.size() > 0) {
                linkedList = new LinkedList();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    linkedList2 = linkedList;
                    try {
                        if (i3 >= this.A.size()) {
                            break;
                        }
                        linkedList.add(Integer.valueOf(this.A.get(i3).a()));
                        i2 = i3 + 1;
                    } catch (Exception e3) {
                        e = e3;
                        linkedList2 = linkedList;
                        if (com.anythink.expressad.a.f4103a) {
                            e.printStackTrace();
                            linkedList2 = linkedList;
                        }
                        linkedList3 = linkedList2;
                        return linkedList3;
                    }
                }
                linkedList3 = linkedList2;
            }
        }
        return linkedList3;
    }

    private int at() {
        return this.at;
    }

    private void b(double d2) {
        this.R = d2;
    }

    private void b(int i2) {
        this.Z = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x028e, code lost:
        if (r0 <= 0) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.expressad.videocommon.e.d c(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 913
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.videocommon.e.d.c(java.lang.String):com.anythink.expressad.videocommon.e.d");
    }

    private void c(double d2) {
        this.U = d2;
    }

    private void c(int i2) {
        this.aa = i2;
    }

    private void d(int i2) {
        this.Y = i2;
    }

    private void d(String str) {
        this.ab = str;
    }

    private void e(int i2) {
        this.C = i2;
    }

    private void e(String str) {
        this.ao = str;
    }

    private void f(int i2) {
        this.D = i2;
    }

    private void f(String str) {
        this.aq = str;
    }

    private void g(int i2) {
        this.am = i2;
    }

    private void g(String str) {
        if (TextUtils.isEmpty(str)) {
            this.as = this.ao;
        } else {
            this.as = str;
        }
    }

    private void h(int i2) {
        this.an = i2;
    }

    private static void h(String str) {
        x = str;
    }

    private void i(int i2) {
        if (i2 <= 0) {
            this.ap = 1;
        } else {
            this.ap = i2;
        }
    }

    private void j(int i2) {
        this.f5934ar = i2;
    }

    private void k(int i2) {
        this.aj = i2;
    }

    private void l(int i2) {
        this.K = i2;
    }

    private int m(int i2) {
        if (this.S == -1) {
            if (i2 == 94) {
                return 2;
            }
            if (i2 == 287) {
                return 3;
            }
        }
        return this.S;
    }

    private void n(int i2) {
        this.T = i2;
    }

    private boolean o(int i2) {
        ArrayList<Integer> arrayList = this.V;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return this.V.contains(Integer.valueOf(i2));
    }

    private void p(int i2) {
        this.S = i2;
    }

    private void q(int i2) {
        this.at = i2;
    }

    private void r(int i2) {
        this.au = i2;
    }

    private void s(int i2) {
        this.av = i2;
    }

    public final int A() {
        return this.H;
    }

    public final void B() {
        this.H = 1;
    }

    public final void C() {
        this.I = 1;
    }

    public final int D() {
        return this.L;
    }

    public final void E() {
        this.L = 1;
    }

    public final int F() {
        return this.M;
    }

    public final void G() {
        this.M = 1;
    }

    public final void H() {
        this.F = 1;
    }

    public final List<com.anythink.expressad.videocommon.c.b> I() {
        return this.A;
    }

    public final int K() {
        return this.T;
    }

    public final double L() {
        return this.U;
    }

    public final int M() {
        return this.X;
    }

    public final void N() {
        this.X = 1;
    }

    public final String O() {
        return this.z;
    }

    public final void P() {
        this.W = 3;
    }

    public final Queue<Integer> Q() {
        Exception e2;
        LinkedList linkedList = null;
        try {
            if (this.A != null) {
                linkedList = null;
                if (this.A.size() > 0) {
                    LinkedList linkedList2 = new LinkedList();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        linkedList = linkedList2;
                        try {
                            if (i3 >= this.A.size()) {
                                break;
                            }
                            linkedList2.add(Integer.valueOf(this.A.get(i3).b()));
                            i2 = i3 + 1;
                        } catch (Exception e3) {
                            e2 = e3;
                            linkedList = linkedList2;
                            e2.printStackTrace();
                            return linkedList;
                        }
                    }
                }
            }
        } catch (Exception e4) {
            linkedList = null;
            e2 = e4;
        }
        return linkedList;
    }

    public final JSONObject R() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("unitId", this.y);
            jSONObject.put(b.g, this.F);
            if (this.A != null && this.A.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.anythink.expressad.videocommon.c.b bVar : this.A) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", bVar.a());
                    jSONObject2.put("timeout", bVar.b());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            jSONObject.put("aqn", this.G);
            jSONObject.put("acn", this.H);
            jSONObject.put("vcn", this.I);
            jSONObject.put("cbp", this.J);
            jSONObject.put("ttc_type", this.K);
            jSONObject.put("offset", this.L);
            jSONObject.put("dlnet", this.M);
            jSONObject.put(b.J, this.N);
            jSONObject.put(b.K, this.O);
            jSONObject.put("ready_rate", this.P);
            jSONObject.put("endscreen_type", this.al);
            jSONObject.put(b.O, this.ae);
            jSONObject.put(b.P, this.af);
            jSONObject.put(b.Q, this.ag);
            jSONObject.put(b.R, this.ah);
            jSONObject.put("orientation", this.ac);
            jSONObject.put(b.S, this.ai);
            jSONObject.put("playclosebtn_tm", this.C);
            jSONObject.put("play_ctdown", this.D);
            jSONObject.put("close_alert", this.E);
            jSONObject.put(b.ac, this.S);
            jSONObject.put(b.aa, this.R);
            jSONObject.put(b.f5927ar, this.T);
            jSONObject.put(b.as, this.U);
            JSONArray jSONArray2 = new JSONArray();
            if (this.V != null) {
                if (this.V.size() > 0) {
                    Iterator<Integer> it = this.V.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put(it.next());
                    }
                }
                jSONObject.put(b.ao, jSONArray2);
            }
            jSONObject.put(b.ap, this.W);
            jSONObject.put("tmorl", this.X);
            jSONObject.put(b.ax, this.Y);
            jSONObject.put("placementid", this.z);
            jSONObject.put("ltafemty", this.Z);
            jSONObject.put("ltorwc", this.aa);
            jSONObject.put("amount_max", this.am);
            jSONObject.put("callback_rule", this.an);
            jSONObject.put("virtual_currency", this.ao);
            jSONObject.put("amount", this.ap);
            jSONObject.put("icon", this.aq);
            jSONObject.put("currency_id", this.f5934ar);
            jSONObject.put("name", this.as);
            jSONObject.put("isDefault", this.at);
            jSONObject.put(b.aN, this.au);
            jSONObject.put(b.aO, this.av);
            return jSONObject;
        } catch (Exception e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    public final int S() {
        return this.ad;
    }

    public final void T() {
        this.ad = 70;
    }

    public final int U() {
        return this.au;
    }

    public final int V() {
        return this.av;
    }

    public final int a() {
        return this.Y;
    }

    public final void a(int i2) {
        this.af = i2;
    }

    public final void a(String str) {
        this.y = str;
    }

    public final void a(ArrayList<Integer> arrayList) {
        this.V = arrayList;
    }

    public final void a(List<com.anythink.expressad.videocommon.c.b> list) {
        this.A = list;
    }

    public final int b() {
        return this.ac;
    }

    public final void b(String str) {
        this.z = str;
    }

    public final void c() {
        this.ac = 0;
    }

    public final void d() {
        this.ae = 0;
    }

    public final int e() {
        return this.af;
    }

    public final int f() {
        return this.ag;
    }

    public final void g() {
        this.ag = 2;
    }

    public final int h() {
        return this.ah;
    }

    public final void i() {
        this.ah = -1;
    }

    public final int j() {
        return this.C;
    }

    public final int k() {
        return this.E;
    }

    public final void l() {
        this.E = 1;
    }

    public final int m() {
        return this.ap;
    }

    public final String n() {
        return this.as;
    }

    public final int o() {
        return this.aj;
    }

    public final int p() {
        return this.ai;
    }

    public final void q() {
        this.ai = 1;
    }

    public final int r() {
        return this.al;
    }

    public final void s() {
        this.al = 2;
    }

    public final void t() {
        this.N = 3;
    }

    public final void u() {
        this.O = 80;
    }

    public final int v() {
        return this.P;
    }

    public final void w() {
        this.P = 100;
    }

    public final int x() {
        return this.Q;
    }

    public final void y() {
        this.Q = 0;
    }

    public final void z() {
        this.G = 1;
    }
}
