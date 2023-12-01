package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/f.class */
public final class f implements h {
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private String f11505c;
    private com.opos.exoplayer.core.c.n d;
    private int f;
    private int g;
    private long h;
    private Format i;
    private int j;
    private long k;

    /* renamed from: a  reason: collision with root package name */
    private final com.opos.exoplayer.core.i.m f11504a = new com.opos.exoplayer.core.i.m(new byte[18]);
    private int e = 0;

    public f(String str) {
        this.b = str;
    }

    private boolean a(com.opos.exoplayer.core.i.m mVar, byte[] bArr, int i) {
        int min = Math.min(mVar.b(), i - this.f);
        mVar.a(bArr, this.f, min);
        int i2 = min + this.f;
        this.f = i2;
        return i2 == i;
    }

    private boolean b(com.opos.exoplayer.core.i.m mVar) {
        while (mVar.b() > 0) {
            int i = this.g << 8;
            this.g = i;
            int g = i | mVar.g();
            this.g = g;
            if (com.opos.exoplayer.core.a.h.a(g)) {
                this.f11504a.f11808a[0] = (byte) ((this.g >> 24) & 255);
                this.f11504a.f11808a[1] = (byte) ((this.g >> 16) & 255);
                this.f11504a.f11808a[2] = (byte) ((this.g >> 8) & 255);
                this.f11504a.f11808a[3] = (byte) (this.g & 255);
                this.f = 4;
                this.g = 0;
                return true;
            }
        }
        return false;
    }

    private void c() {
        byte[] bArr = this.f11504a.f11808a;
        if (this.i == null) {
            Format a2 = com.opos.exoplayer.core.a.h.a(bArr, this.f11505c, this.b, null);
            this.i = a2;
            this.d.a(a2);
        }
        this.j = com.opos.exoplayer.core.a.h.b(bArr);
        this.h = (int) ((com.opos.exoplayer.core.a.h.a(bArr) * 1000000) / this.i.s);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        this.e = 0;
        this.f = 0;
        this.g = 0;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j, boolean z) {
        this.k = j;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.f11505c = dVar.c();
        this.d = gVar.a(dVar.b(), 1);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        while (mVar.b() > 0) {
            int i = this.e;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min(mVar.b(), this.j - this.f);
                        this.d.a(mVar, min);
                        int i2 = min + this.f;
                        this.f = i2;
                        int i3 = this.j;
                        if (i2 == i3) {
                            this.d.a(this.k, 1, i3, 0, null);
                            this.k += this.h;
                            this.e = 0;
                        }
                    }
                } else if (a(mVar, this.f11504a.f11808a, 18)) {
                    c();
                    this.f11504a.c(0);
                    this.d.a(this.f11504a, 18);
                    this.e = 2;
                }
            } else if (b(mVar)) {
                this.e = 1;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
