package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.c.f.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/r.class */
public final class r implements u {

    /* renamed from: a  reason: collision with root package name */
    private final q f11534a;
    private final com.opos.exoplayer.core.i.m b = new com.opos.exoplayer.core.i.m(32);

    /* renamed from: c  reason: collision with root package name */
    private int f11535c;
    private int d;
    private boolean e;
    private boolean f;

    public r(q qVar) {
        this.f11534a = qVar;
    }

    @Override // com.opos.exoplayer.core.c.f.u
    public void a() {
        this.f = true;
    }

    @Override // com.opos.exoplayer.core.c.f.u
    public void a(com.opos.exoplayer.core.i.m mVar, boolean z) {
        int g = z ? mVar.g() + mVar.d() : -1;
        if (this.f) {
            if (!z) {
                return;
            }
            this.f = false;
            mVar.c(g);
            this.d = 0;
        }
        while (mVar.b() > 0) {
            int i = this.d;
            boolean z2 = true;
            if (i < 3) {
                if (i == 0) {
                    int g2 = mVar.g();
                    mVar.c(mVar.d() - 1);
                    if (g2 == 255) {
                        this.f = true;
                        return;
                    }
                }
                int min = Math.min(mVar.b(), 3 - this.d);
                mVar.a(this.b.f11808a, this.d, min);
                int i2 = min + this.d;
                this.d = i2;
                if (i2 == 3) {
                    this.b.a(3);
                    this.b.d(1);
                    int g3 = this.b.g();
                    int g4 = this.b.g();
                    if ((g3 & 128) == 0) {
                        z2 = false;
                    }
                    this.e = z2;
                    this.f11535c = (((g3 & 15) << 8) | g4) + 3;
                    if (this.b.e() < this.f11535c) {
                        byte[] bArr = this.b.f11808a;
                        this.b.a(Math.min(4098, Math.max(this.f11535c, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.b.f11808a, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(mVar.b(), this.f11535c - this.d);
                mVar.a(this.b.f11808a, this.d, min2);
                int i3 = min2 + this.d;
                this.d = i3;
                int i4 = this.f11535c;
                if (i3 != i4) {
                    continue;
                } else {
                    if (!this.e) {
                        this.b.a(i4);
                    } else if (com.opos.exoplayer.core.i.u.a(this.b.f11808a, 0, this.f11535c, -1) != 0) {
                        this.f = true;
                        return;
                    } else {
                        this.b.a(this.f11535c - 4);
                    }
                    this.f11534a.a(this.b);
                    this.d = 0;
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.u
    public void a(com.opos.exoplayer.core.i.s sVar, com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        this.f11534a.a(sVar, gVar, dVar);
        this.f = true;
    }
}
