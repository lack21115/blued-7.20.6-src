package com.opos.exoplayer.core.c.f;

import android.util.Pair;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.drm.DrmInitData;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/d.class */
public final class d implements h {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f11501a = {73, 68, 51};
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final com.opos.exoplayer.core.i.l f11502c;
    private final com.opos.exoplayer.core.i.m d;
    private final String e;
    private String f;
    private com.opos.exoplayer.core.c.n g;
    private com.opos.exoplayer.core.c.n h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private long n;
    private int o;
    private long p;
    private com.opos.exoplayer.core.c.n q;
    private long r;

    public d(boolean z) {
        this(z, null);
    }

    public d(boolean z, String str) {
        this.f11502c = new com.opos.exoplayer.core.i.l(new byte[7]);
        this.d = new com.opos.exoplayer.core.i.m(Arrays.copyOf(f11501a, 10));
        c();
        this.b = z;
        this.e = str;
    }

    private void a(com.opos.exoplayer.core.c.n nVar, long j, int i, int i2) {
        this.i = 3;
        this.j = i;
        this.q = nVar;
        this.r = j;
        this.o = i2;
    }

    private boolean a(com.opos.exoplayer.core.i.m mVar, byte[] bArr, int i) {
        int min = Math.min(mVar.b(), i - this.j);
        mVar.a(bArr, this.j, min);
        int i2 = min + this.j;
        this.j = i2;
        return i2 == i;
    }

    private void b(com.opos.exoplayer.core.i.m mVar) {
        int i;
        byte[] bArr = mVar.f11808a;
        int d = mVar.d();
        int c2 = mVar.c();
        while (d < c2) {
            int i2 = d + 1;
            int i3 = bArr[d] & 255;
            if (this.k != 512 || i3 < 240 || i3 == 255) {
                int i4 = this.k;
                int i5 = i3 | i4;
                if (i5 != 329) {
                    if (i5 == 511) {
                        this.k = 512;
                    } else if (i5 == 836) {
                        i = 1024;
                    } else if (i5 == 1075) {
                        d();
                    } else if (i4 != 256) {
                        this.k = 256;
                        d = i2 - 1;
                    }
                    d = i2;
                } else {
                    i = 768;
                }
                this.k = i;
                d = i2;
            } else {
                boolean z = true;
                if ((i3 & 1) != 0) {
                    z = false;
                }
                this.l = z;
                e();
            }
            mVar.c(i2);
            return;
        }
        mVar.c(d);
    }

    private void c() {
        this.i = 0;
        this.j = 0;
        this.k = 256;
    }

    private void c(com.opos.exoplayer.core.i.m mVar) {
        int min = Math.min(mVar.b(), this.o - this.j);
        this.q.a(mVar, min);
        int i = min + this.j;
        this.j = i;
        int i2 = this.o;
        if (i == i2) {
            this.q.a(this.p, 1, i2, 0, null);
            this.p += this.r;
            c();
        }
    }

    private void d() {
        this.i = 1;
        this.j = f11501a.length;
        this.o = 0;
        this.d.c(0);
    }

    private void e() {
        this.i = 2;
        this.j = 0;
    }

    private void f() {
        this.h.a(this.d, 10);
        this.d.c(6);
        a(this.h, 0L, 10, this.d.t() + 10);
    }

    private void g() {
        this.f11502c.a(0);
        if (this.m) {
            this.f11502c.b(10);
        } else {
            int c2 = this.f11502c.c(2) + 1;
            int i = c2;
            if (c2 != 2) {
                com.opos.cmn.an.f.a.c("AdtsReader", "Detected audio object type: " + c2 + ", but assuming AAC LC.");
                i = 2;
            }
            int c3 = this.f11502c.c(4);
            this.f11502c.b(1);
            byte[] a2 = com.opos.exoplayer.core.i.c.a(i, c3, this.f11502c.c(3));
            Pair<Integer, Integer> a3 = com.opos.exoplayer.core.i.c.a(a2);
            Format a4 = Format.a(this.f, "audio/mp4a-latm", null, -1, -1, a3.second.intValue(), a3.first.intValue(), Collections.singletonList(a2), null, 0, this.e);
            this.n = 1024000000 / a4.s;
            this.g.a(a4);
            this.m = true;
        }
        this.f11502c.b(4);
        int c4 = (this.f11502c.c(13) - 2) - 5;
        int i2 = c4;
        if (this.l) {
            i2 = c4 - 2;
        }
        a(this.g, this.n, 0, i2);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        c();
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j, boolean z) {
        this.p = j;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.f = dVar.c();
        this.g = gVar.a(dVar.b(), 1);
        if (!this.b) {
            this.h = new com.opos.exoplayer.core.c.d();
            return;
        }
        dVar.a();
        com.opos.exoplayer.core.c.n a2 = gVar.a(dVar.b(), 4);
        this.h = a2;
        a2.a(Format.a(dVar.c(), com.anythink.expressad.exoplayer.k.o.V, (String) null, -1, (DrmInitData) null));
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        while (mVar.b() > 0) {
            int i = this.i;
            if (i == 0) {
                b(mVar);
            } else if (i != 1) {
                if (i == 2) {
                    if (a(mVar, this.f11502c.f11806a, this.l ? 7 : 5)) {
                        g();
                    }
                } else if (i == 3) {
                    c(mVar);
                }
            } else if (a(mVar, this.d.f11808a, 10)) {
                f();
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
