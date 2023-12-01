package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/n.class */
public final class n implements h {

    /* renamed from: a  reason: collision with root package name */
    private final com.opos.exoplayer.core.i.m f11526a;
    private final com.opos.exoplayer.core.c.j b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11527c;
    private String d;
    private com.opos.exoplayer.core.c.n e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private int k;
    private long l;

    public n() {
        this(null);
    }

    public n(String str) {
        this.f = 0;
        com.opos.exoplayer.core.i.m mVar = new com.opos.exoplayer.core.i.m(4);
        this.f11526a = mVar;
        mVar.f11808a[0] = (byte) (-1);
        this.b = new com.opos.exoplayer.core.c.j();
        this.f11527c = str;
    }

    private void b(com.opos.exoplayer.core.i.m mVar) {
        byte[] bArr = mVar.f11808a;
        int c2 = mVar.c();
        for (int d = mVar.d(); d < c2; d++) {
            boolean z = (bArr[d] & 255) == 255;
            boolean z2 = this.i && (bArr[d] & 224) == 224;
            this.i = z;
            if (z2) {
                mVar.c(d + 1);
                this.i = false;
                this.f11526a.f11808a[1] = bArr[d];
                this.g = 2;
                this.f = 1;
                return;
            }
        }
        mVar.c(c2);
    }

    private void c(com.opos.exoplayer.core.i.m mVar) {
        int min = Math.min(mVar.b(), 4 - this.g);
        mVar.a(this.f11526a.f11808a, this.g, min);
        int i = min + this.g;
        this.g = i;
        if (i < 4) {
            return;
        }
        this.f11526a.c(0);
        if (!com.opos.exoplayer.core.c.j.a(this.f11526a.o(), this.b)) {
            this.g = 0;
            this.f = 1;
            return;
        }
        this.k = this.b.f11560c;
        if (!this.h) {
            this.j = (this.b.g * 1000000) / this.b.d;
            this.e.a(Format.a(this.d, this.b.b, null, -1, 4096, this.b.e, this.b.d, null, null, 0, this.f11527c));
            this.h = true;
        }
        this.f11526a.c(0);
        this.e.a(this.f11526a, 4);
        this.f = 2;
    }

    private void d(com.opos.exoplayer.core.i.m mVar) {
        int min = Math.min(mVar.b(), this.k - this.g);
        this.e.a(mVar, min);
        int i = min + this.g;
        this.g = i;
        int i2 = this.k;
        if (i < i2) {
            return;
        }
        this.e.a(this.l, 1, i2, 0, null);
        this.l += this.j;
        this.g = 0;
        this.f = 0;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        this.f = 0;
        this.g = 0;
        this.i = false;
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
            if (i == 0) {
                b(mVar);
            } else if (i == 1) {
                c(mVar);
            } else if (i == 2) {
                d(mVar);
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
