package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.a.a;
import com.opos.exoplayer.core.c.f.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/b.class */
public final class b implements h {

    /* renamed from: a  reason: collision with root package name */
    private final com.opos.exoplayer.core.i.l f11497a;
    private final com.opos.exoplayer.core.i.m b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11498c;
    private String d;
    private com.opos.exoplayer.core.c.n e;
    private int f;
    private int g;
    private boolean h;
    private long i;
    private Format j;
    private int k;
    private long l;

    public b() {
        this(null);
    }

    public b(String str) {
        com.opos.exoplayer.core.i.l lVar = new com.opos.exoplayer.core.i.l(new byte[128]);
        this.f11497a = lVar;
        this.b = new com.opos.exoplayer.core.i.m(lVar.f11806a);
        this.f = 0;
        this.f11498c = str;
    }

    private boolean a(com.opos.exoplayer.core.i.m mVar, byte[] bArr, int i) {
        int min = Math.min(mVar.b(), i - this.g);
        mVar.a(bArr, this.g, min);
        int i2 = min + this.g;
        this.g = i2;
        return i2 == i;
    }

    private boolean b(com.opos.exoplayer.core.i.m mVar) {
        while (true) {
            boolean z = true;
            if (mVar.b() <= 0) {
                return false;
            }
            if (this.h) {
                int g = mVar.g();
                if (g == 119) {
                    this.h = false;
                    return true;
                }
                if (g == 11) {
                    this.h = z;
                }
                z = false;
                this.h = z;
            } else {
                if (mVar.g() == 11) {
                    this.h = z;
                }
                z = false;
                this.h = z;
            }
        }
    }

    private void c() {
        this.f11497a.a(0);
        a.C0478a a2 = com.opos.exoplayer.core.a.a.a(this.f11497a);
        if (this.j == null || a2.d != this.j.r || a2.f11319c != this.j.s || a2.f11318a != this.j.f) {
            Format a3 = Format.a(this.d, a2.f11318a, null, -1, -1, a2.d, a2.f11319c, null, null, 0, this.f11498c);
            this.j = a3;
            this.e.a(a3);
        }
        this.k = a2.e;
        this.i = (a2.f * 1000000) / this.j.s;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        this.f = 0;
        this.g = 0;
        this.h = false;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j, boolean z) {
        this.l = j;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.d = dVar.c();
        this.e = gVar.a(dVar.b(), 1);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        while (mVar.b() > 0) {
            int i = this.f;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min(mVar.b(), this.k - this.g);
                        this.e.a(mVar, min);
                        int i2 = min + this.g;
                        this.g = i2;
                        int i3 = this.k;
                        if (i2 == i3) {
                            this.e.a(this.l, 1, i3, 0, null);
                            this.l += this.i;
                            this.f = 0;
                        }
                    }
                } else if (a(mVar, this.b.f11808a, 128)) {
                    c();
                    this.b.c(0);
                    this.e.a(this.b, 128);
                    this.f = 2;
                }
            } else if (b(mVar)) {
                this.f = 1;
                this.b.f11808a[0] = (byte) 11;
                this.b.f11808a[1] = (byte) 119;
                this.g = 2;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
