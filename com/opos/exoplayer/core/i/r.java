package com.opos.exoplayer.core.i;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/r.class */
public final class r implements i {

    /* renamed from: a  reason: collision with root package name */
    private final b f25506a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private long f25507c;
    private long d;
    private com.opos.exoplayer.core.p e = com.opos.exoplayer.core.p.f25554a;

    public r(b bVar) {
        this.f25506a = bVar;
    }

    @Override // com.opos.exoplayer.core.i.i
    public com.opos.exoplayer.core.p a(com.opos.exoplayer.core.p pVar) {
        if (this.b) {
            a(d());
        }
        this.e = pVar;
        return pVar;
    }

    public void a() {
        if (this.b) {
            return;
        }
        this.d = this.f25506a.a();
        this.b = true;
    }

    public void a(long j) {
        this.f25507c = j;
        if (this.b) {
            this.d = this.f25506a.a();
        }
    }

    public void b() {
        if (this.b) {
            a(d());
            this.b = false;
        }
    }

    @Override // com.opos.exoplayer.core.i.i
    public long d() {
        long j = this.f25507c;
        long j2 = j;
        if (this.b) {
            long a2 = this.f25506a.a() - this.d;
            j2 = j + (this.e.b == 1.0f ? com.opos.exoplayer.core.b.b(a2) : this.e.a(a2));
        }
        return j2;
    }

    @Override // com.opos.exoplayer.core.i.i
    public com.opos.exoplayer.core.p e() {
        return this.e;
    }
}
