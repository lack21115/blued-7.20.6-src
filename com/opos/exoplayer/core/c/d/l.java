package com.opos.exoplayer.core.c.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/l.class */
final class l {

    /* renamed from: a  reason: collision with root package name */
    public i f25148a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public long f25149c;
    public long d;
    public int e;
    public int f;
    public long[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public long[] k;
    public boolean[] l;
    public boolean m;
    public boolean[] n;
    public f o;
    public int p;
    public com.opos.exoplayer.core.i.m q;
    public boolean r;
    public long s;

    public void a() {
        this.e = 0;
        this.s = 0L;
        this.m = false;
        this.r = false;
        this.o = null;
    }

    public void a(int i) {
        com.opos.exoplayer.core.i.m mVar = this.q;
        if (mVar == null || mVar.c() < i) {
            this.q = new com.opos.exoplayer.core.i.m(i);
        }
        this.p = i;
        this.m = true;
        this.r = true;
    }

    public void a(int i, int i2) {
        this.e = i;
        this.f = i2;
        int[] iArr = this.h;
        if (iArr == null || iArr.length < i) {
            this.g = new long[i];
            this.h = new int[i];
        }
        int[] iArr2 = this.i;
        if (iArr2 == null || iArr2.length < i2) {
            int i3 = (i2 * 125) / 100;
            this.i = new int[i3];
            this.j = new int[i3];
            this.k = new long[i3];
            this.l = new boolean[i3];
            this.n = new boolean[i3];
        }
    }

    public void a(com.opos.exoplayer.core.c.f fVar) {
        fVar.b(this.q.f25496a, 0, this.p);
        this.q.c(0);
        this.r = false;
    }

    public void a(com.opos.exoplayer.core.i.m mVar) {
        mVar.a(this.q.f25496a, 0, this.p);
        this.q.c(0);
        this.r = false;
    }

    public long b(int i) {
        return this.k[i] + this.j[i];
    }
}
