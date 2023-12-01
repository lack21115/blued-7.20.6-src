package com.anythink.expressad.exoplayer;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/a.class */
public abstract class a implements y, z {
    private final int n;
    private aa o;
    private int p;
    private int q;
    private com.anythink.expressad.exoplayer.h.y r;
    private m[] s;
    private long t;
    private boolean u = true;
    private boolean v;

    public a(int i) {
        this.n = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(com.anythink.expressad.exoplayer.d.g<?> gVar, com.anythink.expressad.exoplayer.d.e eVar) {
        if (eVar == null) {
            return true;
        }
        if (gVar == null) {
            return false;
        }
        return gVar.a(eVar);
    }

    @Override // com.anythink.expressad.exoplayer.y, com.anythink.expressad.exoplayer.z
    public final int a() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z) {
        int a2 = this.r.a(nVar, eVar, z);
        if (a2 == -4) {
            if (eVar.c()) {
                this.u = true;
                return this.v ? -4 : -3;
            }
            eVar.f += this.t;
            return a2;
        }
        if (a2 == -5) {
            m mVar = nVar.f7721a;
            if (mVar.l != Long.MAX_VALUE) {
                nVar.f7721a = mVar.a(mVar.l + this.t);
            }
        }
        return a2;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(int i) {
        this.p = i;
    }

    @Override // com.anythink.expressad.exoplayer.x.b
    public void a(int i, Object obj) {
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(long j) {
        this.v = false;
        this.u = false;
        a(j, false);
    }

    protected void a(long j, boolean z) {
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(aa aaVar, m[] mVarArr, com.anythink.expressad.exoplayer.h.y yVar, long j, boolean z, long j2) {
        com.anythink.expressad.exoplayer.k.a.b(this.q == 0);
        this.o = aaVar;
        this.q = 1;
        a(z);
        a(mVarArr, yVar, j2);
        a(j, z);
    }

    protected void a(boolean z) {
    }

    public void a(m[] mVarArr, long j) {
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(m[] mVarArr, com.anythink.expressad.exoplayer.h.y yVar, long j) {
        com.anythink.expressad.exoplayer.k.a.b(!this.v);
        this.r = yVar;
        this.u = false;
        this.s = mVarArr;
        this.t = j;
        a(mVarArr, j);
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final int a_() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int b(long j) {
        return this.r.a(j - this.t);
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final z b() {
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void b_() {
        boolean z = true;
        if (this.q != 1) {
            z = false;
        }
        com.anythink.expressad.exoplayer.k.a.b(z);
        this.q = 2;
        n();
    }

    @Override // com.anythink.expressad.exoplayer.y
    public com.anythink.expressad.exoplayer.k.n c() {
        return null;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final com.anythink.expressad.exoplayer.h.y f() {
        return this.r;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean g() {
        return this.u;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void h() {
        this.v = true;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean i() {
        return this.v;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void j() {
        this.r.c();
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void k() {
        com.anythink.expressad.exoplayer.k.a.b(this.q == 2);
        this.q = 1;
        o();
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void l() {
        boolean z = true;
        if (this.q != 1) {
            z = false;
        }
        com.anythink.expressad.exoplayer.k.a.b(z);
        this.q = 0;
        this.r = null;
        this.s = null;
        this.v = false;
        p();
    }

    @Override // com.anythink.expressad.exoplayer.z
    public int m() {
        return 0;
    }

    protected void n() {
    }

    protected void o() {
    }

    protected void p() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final m[] q() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final aa r() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int s() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean t() {
        return this.u ? this.v : this.r.b();
    }
}
