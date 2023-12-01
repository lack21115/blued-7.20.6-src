package com.opos.exoplayer.core;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/ab.class */
final class ab {

    /* renamed from: a  reason: collision with root package name */
    public final com.opos.exoplayer.core.e.d f11369a;
    public final Object b;

    /* renamed from: c  reason: collision with root package name */
    public final com.opos.exoplayer.core.e.i[] f11370c;
    public final boolean[] d;
    public long e;
    public boolean f;
    public boolean g;
    public ac h;
    public ab i;
    public com.opos.exoplayer.core.g.i j;
    private final t[] k;
    private final com.opos.exoplayer.core.g.h l;
    private final com.opos.exoplayer.core.e.e m;
    private com.opos.exoplayer.core.g.i n;

    public ab(t[] tVarArr, long j, com.opos.exoplayer.core.g.h hVar, com.opos.exoplayer.core.h.b bVar, com.opos.exoplayer.core.e.e eVar, Object obj, ac acVar) {
        this.k = tVarArr;
        this.e = j - acVar.b;
        this.l = hVar;
        this.m = eVar;
        this.b = com.opos.exoplayer.core.i.a.a(obj);
        this.h = acVar;
        this.f11370c = new com.opos.exoplayer.core.e.i[tVarArr.length];
        this.d = new boolean[tVarArr.length];
        com.opos.exoplayer.core.e.d a2 = eVar.a(acVar.f11371a, bVar);
        com.opos.exoplayer.core.e.a aVar = a2;
        if (acVar.f11372c != Long.MIN_VALUE) {
            com.opos.exoplayer.core.e.a aVar2 = new com.opos.exoplayer.core.e.a(a2, true);
            aVar2.a(0L, acVar.f11372c);
            aVar = aVar2;
        }
        this.f11369a = aVar;
    }

    private void a(com.opos.exoplayer.core.g.i iVar) {
        com.opos.exoplayer.core.g.i iVar2 = this.n;
        if (iVar2 != null) {
            c(iVar2);
        }
        this.n = iVar;
        if (iVar != null) {
            b(iVar);
        }
    }

    private void a(com.opos.exoplayer.core.e.i[] iVarArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            t[] tVarArr = this.k;
            if (i2 >= tVarArr.length) {
                return;
            }
            if (tVarArr[i2].a() == 5) {
                iVarArr[i2] = null;
            }
            i = i2 + 1;
        }
    }

    private void b(com.opos.exoplayer.core.g.i iVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iVar.b.length) {
                return;
            }
            boolean z = iVar.b[i2];
            com.opos.exoplayer.core.g.f a2 = iVar.f11751c.a(i2);
            if (z && a2 != null) {
                a2.a();
            }
            i = i2 + 1;
        }
    }

    private void b(com.opos.exoplayer.core.e.i[] iVarArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            t[] tVarArr = this.k;
            if (i2 >= tVarArr.length) {
                return;
            }
            if (tVarArr[i2].a() == 5 && this.j.b[i2]) {
                iVarArr[i2] = new com.opos.exoplayer.core.e.b();
            }
            i = i2 + 1;
        }
    }

    private void c(com.opos.exoplayer.core.g.i iVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iVar.b.length) {
                return;
            }
            boolean z = iVar.b[i2];
            com.opos.exoplayer.core.g.f a2 = iVar.f11751c.a(i2);
            if (z && a2 != null) {
                a2.c();
            }
            i = i2 + 1;
        }
    }

    public long a() {
        return this.e;
    }

    public long a(long j) {
        return a() + j;
    }

    public long a(long j, boolean z) {
        return a(j, z, new boolean[this.k.length]);
    }

    public long a(long j, boolean z, boolean[] zArr) {
        com.opos.exoplayer.core.g.g gVar = this.j.f11751c;
        int i = 0;
        while (true) {
            int i2 = i;
            boolean z2 = true;
            if (i2 >= gVar.f11747a) {
                break;
            }
            boolean[] zArr2 = this.d;
            if (z || !this.j.a(this.n, i2)) {
                z2 = false;
            }
            zArr2[i2] = z2;
            i = i2 + 1;
        }
        a(this.f11370c);
        a(this.j);
        long a2 = this.f11369a.a(gVar.a(), this.d, this.f11370c, zArr, j);
        b(this.f11370c);
        this.g = false;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            com.opos.exoplayer.core.e.i[] iVarArr = this.f11370c;
            if (i4 >= iVarArr.length) {
                return a2;
            }
            if (iVarArr[i4] != null) {
                com.opos.exoplayer.core.i.a.b(this.j.b[i4]);
                if (this.k[i4].a() != 5) {
                    this.g = true;
                }
            } else {
                com.opos.exoplayer.core.i.a.b(gVar.a(i4) == null);
            }
            i3 = i4 + 1;
        }
    }

    public long a(boolean z) {
        if (this.f) {
            long d = this.f11369a.d();
            long j = d;
            if (d == Long.MIN_VALUE) {
                j = d;
                if (z) {
                    j = this.h.e;
                }
            }
            return j;
        }
        return this.h.b;
    }

    public com.opos.exoplayer.core.g.i a(float f) {
        this.f = true;
        b(f);
        long a2 = a(this.h.b, false);
        this.e += this.h.b - a2;
        this.h = this.h.a(a2);
        return this.j;
    }

    public long b(long j) {
        return j - a();
    }

    public boolean b() {
        if (this.f) {
            return !this.g || this.f11369a.d() == Long.MIN_VALUE;
        }
        return false;
    }

    public boolean b(float f) {
        com.opos.exoplayer.core.g.f[] a2;
        com.opos.exoplayer.core.g.i a3 = this.l.a(this.k, this.f11369a.b());
        if (a3.a(this.n)) {
            return false;
        }
        this.j = a3;
        for (com.opos.exoplayer.core.g.f fVar : a3.f11751c.a()) {
            if (fVar != null) {
                fVar.a(f);
            }
        }
        return true;
    }

    public long c() {
        if (this.f) {
            return this.f11369a.e();
        }
        return 0L;
    }

    public void c(long j) {
        if (this.f) {
            this.f11369a.a(b(j));
        }
    }

    public void d() {
        com.opos.exoplayer.core.e.e eVar;
        com.opos.exoplayer.core.e.d dVar;
        a((com.opos.exoplayer.core.g.i) null);
        try {
            if (this.h.f11372c != Long.MIN_VALUE) {
                eVar = this.m;
                dVar = ((com.opos.exoplayer.core.e.a) this.f11369a).f11586a;
            } else {
                eVar = this.m;
                dVar = this.f11369a;
            }
            eVar.a(dVar);
        } catch (RuntimeException e) {
            com.opos.cmn.an.f.a.d("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public void d(long j) {
        this.f11369a.c(b(j));
    }
}
