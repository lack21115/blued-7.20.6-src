package com.opos.exoplayer.core.c.a;

import com.opos.exoplayer.core.c.f;
import com.opos.exoplayer.core.c.g;
import com.opos.exoplayer.core.c.h;
import com.opos.exoplayer.core.c.k;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/a/a.class */
public final class a implements com.opos.exoplayer.core.c.e {

    /* renamed from: a  reason: collision with root package name */
    public static final h f11393a = new h() { // from class: com.opos.exoplayer.core.c.a.a.1
        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new a()};
        }
    };
    private static final int b = u.f("FLV");
    private g h;
    private int k;
    private int l;
    private int m;
    private long n;
    private boolean o;
    private c p;
    private e q;

    /* renamed from: c  reason: collision with root package name */
    private final m f11394c = new m(4);
    private final m d = new m(9);
    private final m e = new m(11);
    private final m f = new m();
    private final d g = new d();
    private int i = 1;
    private long j = com.anythink.expressad.exoplayer.b.b;

    private void a() {
        if (!this.o) {
            this.h.a(new l.b(com.anythink.expressad.exoplayer.b.b));
            this.o = true;
        }
        if (this.j == com.anythink.expressad.exoplayer.b.b) {
            this.j = this.g.a() == com.anythink.expressad.exoplayer.b.b ? -this.n : 0L;
        }
    }

    private boolean b(f fVar) {
        boolean z = false;
        if (fVar.a(this.d.f11808a, 0, 9, true)) {
            this.d.c(0);
            this.d.d(4);
            int g = this.d.g();
            boolean z2 = (g & 4) != 0;
            if ((g & 1) != 0) {
                z = true;
            }
            if (z2 && this.p == null) {
                this.p = new c(this.h.a(8, 1));
            }
            if (z && this.q == null) {
                this.q = new e(this.h.a(9, 2));
            }
            this.h.a();
            this.k = (this.d.o() - 9) + 4;
            this.i = 2;
            return true;
        }
        return false;
    }

    private void c(f fVar) {
        fVar.b(this.k);
        this.k = 0;
        this.i = 3;
    }

    private boolean d(f fVar) {
        if (fVar.a(this.e.f11808a, 0, 11, true)) {
            this.e.c(0);
            this.l = this.e.g();
            this.m = this.e.k();
            this.n = this.e.k();
            this.n = ((this.e.g() << 24) | this.n) * 1000;
            this.e.d(3);
            this.i = 4;
            return true;
        }
        return false;
    }

    private boolean e(f fVar) {
        boolean z;
        if (this.l == 8 && this.p != null) {
            a();
            this.p.a(f(fVar), this.j + this.n);
            z = true;
        } else if (this.l == 9 && this.q != null) {
            a();
            this.q.a(f(fVar), this.j + this.n);
            z = true;
        } else if (this.l != 18 || this.o) {
            fVar.b(this.m);
            z = false;
        } else {
            this.g.a(f(fVar), this.n);
            long a2 = this.g.a();
            z = true;
            if (a2 != com.anythink.expressad.exoplayer.b.b) {
                this.h.a(new l.b(a2));
                this.o = true;
                z = true;
            }
        }
        this.k = 4;
        this.i = 2;
        return z;
    }

    private m f(f fVar) {
        if (this.m > this.f.e()) {
            m mVar = this.f;
            mVar.a(new byte[Math.max(mVar.e() * 2, this.m)], 0);
        } else {
            this.f.c(0);
        }
        this.f.b(this.m);
        fVar.b(this.f.f11808a, 0, this.m);
        return this.f;
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(f fVar, k kVar) {
        while (true) {
            int i = this.i;
            if (i != 1) {
                if (i == 2) {
                    c(fVar);
                } else if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException();
                    }
                    if (e(fVar)) {
                        return 0;
                    }
                } else if (!d(fVar)) {
                    return -1;
                }
            } else if (!b(fVar)) {
                return -1;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        this.i = 1;
        this.j = com.anythink.expressad.exoplayer.b.b;
        this.k = 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(g gVar) {
        this.h = gVar;
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(f fVar) {
        fVar.c(this.f11394c.f11808a, 0, 3);
        this.f11394c.c(0);
        if (this.f11394c.k() != b) {
            return false;
        }
        fVar.c(this.f11394c.f11808a, 0, 2);
        this.f11394c.c(0);
        boolean z = false;
        if ((this.f11394c.h() & 250) == 0) {
            fVar.c(this.f11394c.f11808a, 0, 4);
            this.f11394c.c(0);
            int o = this.f11394c.o();
            fVar.a();
            fVar.c(o);
            fVar.c(this.f11394c.f11808a, 0, 4);
            this.f11394c.c(0);
            z = false;
            if (this.f11394c.o() == 0) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
