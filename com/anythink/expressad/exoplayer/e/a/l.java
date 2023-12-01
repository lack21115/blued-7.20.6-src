package com.anythink.expressad.exoplayer.e.a;

import com.anythink.expressad.exoplayer.k.s;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/l.class */
final class l {

    /* renamed from: a  reason: collision with root package name */
    public c f7308a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public long f7309c;
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
    public k o;
    public int p;
    public s q;
    public boolean r;
    public long s;

    private void a(com.anythink.expressad.exoplayer.e.f fVar) {
        fVar.b(this.q.f7674a, 0, this.p);
        this.q.c(0);
        this.r = false;
    }

    public final void a() {
        this.e = 0;
        this.s = 0L;
        this.m = false;
        this.r = false;
        this.o = null;
    }

    public final void a(int i) {
        s sVar = this.q;
        if (sVar == null || sVar.b() < i) {
            this.q = new s(i);
        }
        this.p = i;
        this.m = true;
        this.r = true;
    }

    public final void a(int i, int i2) {
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

    public final void a(s sVar) {
        sVar.a(this.q.f7674a, 0, this.p);
        this.q.c(0);
        this.r = false;
    }

    public final long b(int i) {
        return this.k[i] + this.j[i];
    }
}
