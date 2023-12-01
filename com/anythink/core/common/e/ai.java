package com.anythink.core.common.e;

import com.anythink.core.api.ATAdConst;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/ai.class */
public class ai implements Comparable<ai> {
    private String A;
    private int B;
    private long C;
    private long D;
    private long E;
    private long F;
    private int G;
    private String H;
    private long I;
    private long J;
    private long K;
    private long L;
    private int M;
    private int N;
    private int O;
    private int P;
    private String Q;
    private long R;
    private long S;
    private double T;
    private int U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private int Z;

    /* renamed from: a  reason: collision with root package name */
    int f6634a;
    private m aa;
    private int ab;
    private int ac;
    private String ad;
    private int ae;
    private int af;

    /* renamed from: c  reason: collision with root package name */
    int f6635c;
    int d;
    String e;
    int f;
    int g;
    double h;
    int i;
    double j;
    String k;
    boolean l;
    private int m;
    private String n;
    private int o;
    private int p;
    private String q;
    private String r;
    private String s;
    private long t;
    private String u;
    private int v;
    private int w;
    private double x;
    private int y;
    private String z;
    int b = 0;
    private int ag = -1;
    private ATAdConst.CURRENCY ah = ATAdConst.CURRENCY.USD;

    private void B(int i) {
        this.ab = i;
    }

    private int a(ai aiVar) {
        return com.anythink.core.common.k.g.a(this) > com.anythink.core.common.k.g.a(aiVar) ? -1 : 1;
    }

    private void a(m mVar) {
        this.aa = mVar;
    }

    private long ak() {
        return this.I;
    }

    private void l(String str) {
        this.ad = str;
    }

    public final long A() {
        return this.J;
    }

    public final void A(int i) {
        this.i = i;
    }

    public final long B() {
        return this.K;
    }

    public final int C() {
        return this.M;
    }

    public final int D() {
        return this.N;
    }

    public final int E() {
        return this.O;
    }

    public final int F() {
        return this.P;
    }

    public final String G() {
        return this.Q;
    }

    public final long H() {
        return this.R;
    }

    public final long I() {
        return this.S;
    }

    public final double J() {
        return this.T;
    }

    public final int K() {
        return this.U;
    }

    public final int L() {
        return this.V;
    }

    public final boolean M() {
        return this.W == 2;
    }

    public final m N() {
        return this.aa;
    }

    public final int O() {
        return this.ab;
    }

    public final int P() {
        return this.ac;
    }

    public final void Q() {
        this.ac = 1;
    }

    public final String R() {
        return this.ad;
    }

    public final int S() {
        return this.af;
    }

    public final int T() {
        int i = this.b;
        int i2 = i;
        if (i <= 0) {
            i2 = 1;
        }
        return i2;
    }

    public final int U() {
        return this.f6635c;
    }

    public final int V() {
        return this.d;
    }

    public final String W() {
        return this.e;
    }

    public final int X() {
        return this.f6634a;
    }

    public final int Y() {
        return this.ag;
    }

    public final int Z() {
        m mVar = this.aa;
        return (mVar == null || mVar.n == 0) ? this.f : this.aa.n;
    }

    public final double a(com.anythink.core.c.d dVar) {
        double d = this.h;
        if (d > 0.0d) {
            return d;
        }
        if (dVar != null) {
            double as = dVar.as();
            if (as > 0.0d) {
                return as;
            }
        }
        double d2 = this.h;
        if (d2 > 0.0d) {
            return d2;
        }
        return 0.0d;
    }

    public final int a() {
        return this.Y;
    }

    public final void a(double d) {
        this.x = d;
    }

    public final void a(int i) {
        this.m = i;
    }

    public final void a(long j) {
        this.D = j;
    }

    public final void a(ATAdConst.CURRENCY currency) {
        this.ah = currency;
    }

    public final void a(ai aiVar, int i, int i2, int i3) {
        synchronized (this) {
            if (aiVar.H.equals(this.H)) {
                this.x = aiVar.x;
                this.j = aiVar.j;
                this.B = i2;
                this.z = aiVar.z;
                this.ad = aiVar.ad;
                this.Y = 0;
                if (i == 0) {
                    this.ab = aiVar.ab;
                } else {
                    this.ab = i;
                }
                this.A = aiVar.A;
                this.aa = aiVar.aa;
                this.ac = i3;
            }
        }
    }

    public final void a(m mVar, int i, int i2, int i3) {
        this.B = i2;
        this.x = mVar.getPrice();
        this.j = mVar.getSortPrice();
        this.z = mVar.token;
        this.ad = mVar.m;
        this.Y = 0;
        this.ab = i;
        this.aa = mVar;
        this.ac = i3;
        if (i3 == 1) {
            this.A = "";
        }
    }

    public final void a(String str) {
        this.n = str;
    }

    public final boolean aa() {
        return this.m == 1 && this.Z == 1;
    }

    public final String ab() {
        return "networkFirmId: " + this.m + ", adSourceId: " + this.H + ", content: " + this.q + ", price: " + this.x + ", sortPrice: " + this.j;
    }

    public final int ac() {
        return this.ae;
    }

    public final ATAdConst.CURRENCY ad() {
        return this.ah;
    }

    public final int ae() {
        return this.g;
    }

    public final int af() {
        return this.i;
    }

    public final double ag() {
        return this.j;
    }

    public final String ah() {
        return this.k;
    }

    public final boolean ai() {
        return this.l;
    }

    public final void aj() {
        this.l = true;
    }

    public final void b() {
        this.Y = -1;
    }

    public final void b(double d) {
        this.T = d;
    }

    public final void b(int i) {
        this.o = i;
    }

    public final void b(long j) {
        this.L = j;
    }

    public final void b(String str) {
        this.q = str;
    }

    public final int c() {
        return this.m;
    }

    public final void c(double d) {
        this.h = d;
    }

    public final void c(int i) {
        this.p = i;
    }

    public final void c(long j) {
        this.E = j;
    }

    public final void c(String str) {
        this.r = str;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(ai aiVar) {
        return com.anythink.core.common.k.g.a(this) > com.anythink.core.common.k.g.a(aiVar) ? -1 : 1;
    }

    public final String d() {
        return this.n;
    }

    public final void d(double d) {
        this.j = d;
    }

    public final void d(int i) {
        this.y = i;
    }

    public final void d(long j) {
        this.F = j;
    }

    public final void d(String str) {
        this.s = str;
    }

    public final int e() {
        return this.o;
    }

    public final void e(int i) {
        this.Z = i;
    }

    public final void e(long j) {
        this.t = j;
    }

    public final void e(String str) {
        this.H = str;
    }

    public final int f() {
        return this.p;
    }

    public final void f(int i) {
        this.X = i;
    }

    public final void f(long j) {
        this.I = j;
    }

    public final void f(String str) {
        this.u = str;
    }

    public final String g() {
        return this.q;
    }

    public final void g(int i) {
        this.B = i;
    }

    public final void g(long j) {
        this.J = j;
    }

    public final void g(String str) {
        this.z = str;
    }

    public final String h() {
        return this.r;
    }

    public final void h(int i) {
        this.G = i;
    }

    public final void h(long j) {
        this.K = j;
    }

    public final void h(String str) {
        this.A = str;
    }

    public final int i() {
        return this.y;
    }

    public final void i(int i) {
        this.v = i;
    }

    public final void i(long j) {
        this.R = j;
    }

    public final void i(String str) {
        this.Q = str;
    }

    public final void j(int i) {
        this.w = i;
    }

    public final void j(long j) {
        this.S = j;
    }

    public final void j(String str) {
        this.e = str;
    }

    public final boolean j() {
        return this.y == 1;
    }

    public final long k() {
        return this.D;
    }

    public final void k(int i) {
        this.M = i;
    }

    public final void k(String str) {
        this.k = str;
    }

    public final int l() {
        return this.Z;
    }

    public final void l(int i) {
        this.N = i;
    }

    public final int m() {
        return this.X;
    }

    public final void m(int i) {
        this.O = i;
    }

    public final long n() {
        return this.L;
    }

    public final void n(int i) {
        this.P = i;
    }

    public final int o() {
        return this.B;
    }

    public final void o(int i) {
        this.U = i;
    }

    public final long p() {
        return this.E;
    }

    public final void p(int i) {
        this.V = i;
    }

    public final long q() {
        return this.F;
    }

    public final void q(int i) {
        this.W = i;
    }

    public final int r() {
        return this.G;
    }

    public final void r(int i) {
        this.af = i;
    }

    public final long s() {
        return this.t;
    }

    public final void s(int i) {
        this.b = i;
    }

    public final String t() {
        return this.H;
    }

    public final void t(int i) {
        this.f6635c = i;
    }

    public final String u() {
        return this.u;
    }

    public final void u(int i) {
        this.d = i;
    }

    public final int v() {
        return this.v;
    }

    public final void v(int i) {
        this.f6634a = i;
    }

    public final int w() {
        return this.w;
    }

    public final void w(int i) {
        this.ag = i;
    }

    public final double x() {
        return this.x;
    }

    public final void x(int i) {
        this.f = i;
    }

    public final String y() {
        return this.z;
    }

    public final void y(int i) {
        this.ae = i;
    }

    public final String z() {
        return this.A;
    }

    public final void z(int i) {
        this.g = i;
    }
}
