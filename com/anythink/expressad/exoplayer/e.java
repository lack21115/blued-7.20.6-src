package com.anythink.expressad.exoplayer;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e.class */
final class e implements com.anythink.expressad.exoplayer.k.n {

    /* renamed from: a  reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.k.z f4430a;
    private final a b;

    /* renamed from: c  reason: collision with root package name */
    private y f4431c;
    private com.anythink.expressad.exoplayer.k.n d;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e$a.class */
    public interface a {
        void a(v vVar);
    }

    public e(a aVar, com.anythink.expressad.exoplayer.k.c cVar) {
        this.b = aVar;
        this.f4430a = new com.anythink.expressad.exoplayer.k.z(cVar);
    }

    private void f() {
        this.f4430a.a(this.d.d());
        v e = this.d.e();
        if (e.equals(this.f4430a.e())) {
            return;
        }
        this.f4430a.a(e);
        this.b.a(e);
    }

    private boolean g() {
        y yVar = this.f4431c;
        if (yVar == null || yVar.v()) {
            return false;
        }
        return this.f4431c.u() || !this.f4431c.g();
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final v a(v vVar) {
        com.anythink.expressad.exoplayer.k.n nVar = this.d;
        v vVar2 = vVar;
        if (nVar != null) {
            vVar2 = nVar.a(vVar);
        }
        this.f4430a.a(vVar2);
        this.b.a(vVar2);
        return vVar2;
    }

    public final void a() {
        this.f4430a.a();
    }

    public final void a(long j) {
        this.f4430a.a(j);
    }

    public final void a(y yVar) {
        com.anythink.expressad.exoplayer.k.n nVar;
        com.anythink.expressad.exoplayer.k.n c2 = yVar.c();
        if (c2 == null || c2 == (nVar = this.d)) {
            return;
        }
        if (nVar != null) {
            throw g.a(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.d = c2;
        this.f4431c = yVar;
        c2.a(this.f4430a.e());
        f();
    }

    public final void b() {
        this.f4430a.b();
    }

    public final void b(y yVar) {
        if (yVar == this.f4431c) {
            this.d = null;
            this.f4431c = null;
        }
    }

    public final long c() {
        if (g()) {
            f();
            return this.d.d();
        }
        return this.f4430a.d();
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final long d() {
        return g() ? this.d.d() : this.f4430a.d();
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final v e() {
        com.anythink.expressad.exoplayer.k.n nVar = this.d;
        return nVar != null ? nVar.e() : this.f4430a.e();
    }
}
