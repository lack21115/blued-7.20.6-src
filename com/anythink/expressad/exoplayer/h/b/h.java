package com.anythink.expressad.exoplayer.h.b;

import com.anythink.expressad.exoplayer.j.k;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.m;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/b/h.class */
public final class h extends a {
    private final int k;
    private final long l;
    private final d m;
    private volatile int n;
    private volatile boolean o;
    private volatile boolean p;

    private h(com.anythink.expressad.exoplayer.j.h hVar, k kVar, m mVar, int i, Object obj, long j, long j2, long j3, long j4, int i2, long j5, d dVar) {
        super(hVar, kVar, mVar, i, obj, j, j2, j3, j4);
        this.k = i2;
        this.l = j5;
        this.m = dVar;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.c
    public final void a() {
        this.o = true;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.c
    public final void b() {
        k a2 = this.b.a(this.n);
        try {
            com.anythink.expressad.exoplayer.e.b bVar = new com.anythink.expressad.exoplayer.e.b(this.i, a2.e, this.i.a(a2));
            if (this.n == 0) {
                b c2 = c();
                c2.a(this.l);
                this.m.a(c2, this.f7422a == com.anythink.expressad.exoplayer.b.b ? 0L : this.f7422a - this.l);
            }
            com.anythink.expressad.exoplayer.e.e eVar = this.m.f7426a;
            boolean z = false;
            int i = 0;
            while (i == 0 && !this.o) {
                i = eVar.a(bVar, (com.anythink.expressad.exoplayer.e.j) null);
            }
            if (i != 1) {
                z = true;
            }
            com.anythink.expressad.exoplayer.k.a.b(z);
            this.n = (int) (bVar.c() - this.b.e);
            af.a(this.i);
            this.p = true;
        } catch (Throwable th) {
            af.a(this.i);
            throw th;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.b.c
    public final long d() {
        return this.n;
    }

    @Override // com.anythink.expressad.exoplayer.h.b.i
    public final long e() {
        return this.j + this.k;
    }

    @Override // com.anythink.expressad.exoplayer.h.b.i
    public final boolean f() {
        return this.p;
    }
}
