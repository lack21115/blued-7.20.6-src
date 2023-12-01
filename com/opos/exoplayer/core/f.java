package com.opos.exoplayer.core;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f.class */
final class f implements com.opos.exoplayer.core.i.i {

    /* renamed from: a  reason: collision with root package name */
    private final com.opos.exoplayer.core.i.r f11635a;
    private final a b;

    /* renamed from: c  reason: collision with root package name */
    private s f11636c;
    private com.opos.exoplayer.core.i.i d;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f$a.class */
    public interface a {
        void a(p pVar);
    }

    public f(a aVar, com.opos.exoplayer.core.i.b bVar) {
        this.b = aVar;
        this.f11635a = new com.opos.exoplayer.core.i.r(bVar);
    }

    private void f() {
        this.f11635a.a(this.d.d());
        p e = this.d.e();
        if (e.equals(this.f11635a.e())) {
            return;
        }
        this.f11635a.a(e);
        this.b.a(e);
    }

    private boolean g() {
        s sVar = this.f11636c;
        if (sVar == null || sVar.u()) {
            return false;
        }
        return this.f11636c.t() || !this.f11636c.g();
    }

    @Override // com.opos.exoplayer.core.i.i
    public p a(p pVar) {
        com.opos.exoplayer.core.i.i iVar = this.d;
        p pVar2 = pVar;
        if (iVar != null) {
            pVar2 = iVar.a(pVar);
        }
        this.f11635a.a(pVar2);
        this.b.a(pVar2);
        return pVar2;
    }

    public void a() {
        this.f11635a.a();
    }

    public void a(long j) {
        this.f11635a.a(j);
    }

    public void a(s sVar) {
        com.opos.exoplayer.core.i.i iVar;
        com.opos.exoplayer.core.i.i c2 = sVar.c();
        if (c2 == null || c2 == (iVar = this.d)) {
            return;
        }
        if (iVar != null) {
            throw h.a(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.d = c2;
        this.f11636c = sVar;
        c2.a(this.f11635a.e());
        f();
    }

    public void b() {
        this.f11635a.b();
    }

    public void b(s sVar) {
        if (sVar == this.f11636c) {
            this.d = null;
            this.f11636c = null;
        }
    }

    public long c() {
        if (g()) {
            f();
            return this.d.d();
        }
        return this.f11635a.d();
    }

    @Override // com.opos.exoplayer.core.i.i
    public long d() {
        return g() ? this.d.d() : this.f11635a.d();
    }

    @Override // com.opos.exoplayer.core.i.i
    public p e() {
        com.opos.exoplayer.core.i.i iVar = this.d;
        return iVar != null ? iVar.e() : this.f11635a.e();
    }
}
