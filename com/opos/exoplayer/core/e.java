package com.opos.exoplayer.core;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e.class */
public class e implements n {

    /* renamed from: a  reason: collision with root package name */
    private final com.opos.exoplayer.core.h.j f25272a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f25273c;
    private final long d;
    private final long e;
    private final int f;
    private final boolean g;
    private final com.opos.exoplayer.core.i.p h;
    private int i;
    private boolean j;

    public e() {
        this(new com.opos.exoplayer.core.h.j(true, 65536));
    }

    public e(com.opos.exoplayer.core.h.j jVar) {
        this(jVar, 15000, 30000, 2500, 5000, -1, true);
    }

    public e(com.opos.exoplayer.core.h.j jVar, int i, int i2, int i3, int i4, int i5, boolean z) {
        this(jVar, i, i2, i3, i4, i5, z, null);
    }

    public e(com.opos.exoplayer.core.h.j jVar, int i, int i2, int i3, int i4, int i5, boolean z, com.opos.exoplayer.core.i.p pVar) {
        this.f25272a = jVar;
        this.b = i * 1000;
        this.f25273c = i2 * 1000;
        this.d = i3 * 1000;
        this.e = i4 * 1000;
        this.f = i5;
        this.g = z;
        this.h = pVar;
    }

    private void a(boolean z) {
        this.i = 0;
        com.opos.exoplayer.core.i.p pVar = this.h;
        if (pVar != null && this.j) {
            pVar.b(0);
        }
        this.j = false;
        if (z) {
            this.f25272a.d();
        }
    }

    protected int a(s[] sVarArr, com.opos.exoplayer.core.g.g gVar) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= sVarArr.length) {
                return i3;
            }
            int i4 = i3;
            if (gVar.a(i) != null) {
                i4 = com.opos.exoplayer.core.i.u.e(sVarArr[i].a()) + i3;
            }
            i++;
            i2 = i4;
        }
    }

    @Override // com.opos.exoplayer.core.n
    public void a() {
        a(false);
    }

    @Override // com.opos.exoplayer.core.n
    public void a(s[] sVarArr, com.opos.exoplayer.core.e.m mVar, com.opos.exoplayer.core.g.g gVar) {
        int i = this.f;
        int i2 = i;
        if (i == -1) {
            i2 = a(sVarArr, gVar);
        }
        this.i = i2;
        this.f25272a.a(i2);
    }

    @Override // com.opos.exoplayer.core.n
    public boolean a(long j, float f) {
        boolean z;
        boolean z2;
        boolean z3 = this.f25272a.e() >= this.i;
        boolean z4 = this.j;
        if (this.g) {
            z = true;
            if (j >= this.b) {
                if (j <= this.f25273c && z4 && !z3) {
                    z = true;
                }
                z = false;
            }
        } else {
            if (!z3) {
                z = true;
                if (j >= this.b) {
                    if (j <= this.f25273c && z4) {
                        z = true;
                    }
                }
            }
            z = false;
        }
        this.j = z;
        com.opos.exoplayer.core.i.p pVar = this.h;
        if (pVar != null && (z2 = this.j) != z4) {
            if (z2) {
                pVar.a(0);
            } else {
                pVar.b(0);
            }
        }
        return this.j;
    }

    @Override // com.opos.exoplayer.core.n
    public boolean a(long j, float f, boolean z) {
        long b = com.opos.exoplayer.core.i.u.b(j, f);
        long j2 = z ? this.e : this.d;
        if (j2 <= 0 || b >= j2) {
            return true;
        }
        return !this.g && this.f25272a.e() >= this.i;
    }

    @Override // com.opos.exoplayer.core.n
    public void b() {
        a(true);
    }

    @Override // com.opos.exoplayer.core.n
    public void c() {
        a(true);
    }

    @Override // com.opos.exoplayer.core.n
    public com.opos.exoplayer.core.h.b d() {
        return this.f25272a;
    }

    @Override // com.opos.exoplayer.core.n
    public long e() {
        return 0L;
    }

    @Override // com.opos.exoplayer.core.n
    public boolean f() {
        return false;
    }
}
