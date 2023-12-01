package com.anythink.expressad.exoplayer.k;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/z.class */
public final class z implements n {

    /* renamed from: a  reason: collision with root package name */
    private final c f7687a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private long f7688c;
    private long d;
    private com.anythink.expressad.exoplayer.v e = com.anythink.expressad.exoplayer.v.f7740a;

    public z(c cVar) {
        this.f7687a = cVar;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final com.anythink.expressad.exoplayer.v a(com.anythink.expressad.exoplayer.v vVar) {
        if (this.b) {
            a(d());
        }
        this.e = vVar;
        return vVar;
    }

    public final void a() {
        if (this.b) {
            return;
        }
        this.d = this.f7687a.a();
        this.b = true;
    }

    public final void a(long j) {
        this.f7688c = j;
        if (this.b) {
            this.d = this.f7687a.a();
        }
    }

    public final void b() {
        if (this.b) {
            a(d());
            this.b = false;
        }
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final long d() {
        long j = this.f7688c;
        long j2 = j;
        if (this.b) {
            long a2 = this.f7687a.a() - this.d;
            j2 = j + (this.e.b == 1.0f ? com.anythink.expressad.exoplayer.b.b(a2) : this.e.a(a2));
        }
        return j2;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final com.anythink.expressad.exoplayer.v e() {
        return this.e;
    }
}
