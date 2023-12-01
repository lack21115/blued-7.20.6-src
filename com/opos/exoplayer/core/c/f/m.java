package com.opos.exoplayer.core.c.f;

import android.util.Pair;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import java.util.Collections;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/m.class */
public final class m implements h {

    /* renamed from: a  reason: collision with root package name */
    private final String f11524a;
    private final com.opos.exoplayer.core.i.m b;

    /* renamed from: c  reason: collision with root package name */
    private final com.opos.exoplayer.core.i.l f11525c;
    private com.opos.exoplayer.core.c.n d;
    private Format e;
    private String f;
    private int g;
    private int h;
    private int i;
    private int j;
    private long k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private int t;

    public m(String str) {
        this.f11524a = str;
        com.opos.exoplayer.core.i.m mVar = new com.opos.exoplayer.core.i.m(1024);
        this.b = mVar;
        this.f11525c = new com.opos.exoplayer.core.i.l(mVar.f11808a);
    }

    private void a(int i) {
        this.b.a(i);
        this.f11525c.a(this.b.f11808a);
    }

    private void a(com.opos.exoplayer.core.i.l lVar) {
        if (!lVar.e()) {
            this.l = true;
            b(lVar);
        } else if (!this.l) {
            return;
        }
        if (this.m != 0) {
            throw new com.opos.exoplayer.core.o();
        }
        if (this.n != 0) {
            throw new com.opos.exoplayer.core.o();
        }
        a(lVar, e(lVar));
        if (this.p) {
            lVar.b((int) this.q);
        }
    }

    private void a(com.opos.exoplayer.core.i.l lVar, int i) {
        int b = lVar.b();
        if ((b & 7) == 0) {
            this.b.c(b >> 3);
        } else {
            lVar.a(this.b.f11808a, 0, i * 8);
            this.b.c(0);
        }
        this.d.a(this.b, i);
        this.d.a(this.k, 1, i, 0, null);
        this.k += this.s;
    }

    private void b(com.opos.exoplayer.core.i.l lVar) {
        boolean e;
        int c2 = lVar.c(1);
        int c3 = c2 == 1 ? lVar.c(1) : 0;
        this.m = c3;
        if (c3 != 0) {
            throw new com.opos.exoplayer.core.o();
        }
        if (c2 == 1) {
            f(lVar);
        }
        if (!lVar.e()) {
            throw new com.opos.exoplayer.core.o();
        }
        this.n = lVar.c(6);
        int c4 = lVar.c(4);
        int c5 = lVar.c(3);
        if (c4 != 0 || c5 != 0) {
            throw new com.opos.exoplayer.core.o();
        }
        if (c2 == 0) {
            int b = lVar.b();
            int d = d(lVar);
            lVar.a(b);
            byte[] bArr = new byte[(d + 7) / 8];
            lVar.a(bArr, 0, d);
            Format a2 = Format.a(this.f, "audio/mp4a-latm", null, -1, -1, this.t, this.r, Collections.singletonList(bArr), null, 0, this.f11524a);
            if (!a2.equals(this.e)) {
                this.e = a2;
                this.s = 1024000000 / a2.s;
                this.d.a(a2);
            }
        } else {
            lVar.b(((int) f(lVar)) - d(lVar));
        }
        c(lVar);
        boolean e2 = lVar.e();
        this.p = e2;
        this.q = 0L;
        if (e2) {
            if (c2 == 1) {
                this.q = f(lVar);
            } else {
                do {
                    e = lVar.e();
                    this.q = (this.q << 8) + lVar.c(8);
                } while (e);
            }
        }
        if (lVar.e()) {
            lVar.b(8);
        }
    }

    private void c(com.opos.exoplayer.core.i.l lVar) {
        int i;
        int c2 = lVar.c(3);
        this.o = c2;
        if (c2 == 0) {
            i = 8;
        } else if (c2 != 1) {
            if (c2 == 3 || c2 == 4 || c2 == 5) {
                lVar.b(6);
                return;
            } else if (c2 == 6 || c2 == 7) {
                lVar.b(1);
                return;
            } else {
                return;
            }
        } else {
            i = 9;
        }
        lVar.b(i);
    }

    private int d(com.opos.exoplayer.core.i.l lVar) {
        int a2 = lVar.a();
        Pair<Integer, Integer> a3 = com.opos.exoplayer.core.i.c.a(lVar, true);
        this.r = a3.first.intValue();
        this.t = a3.second.intValue();
        return a2 - lVar.a();
    }

    private int e(com.opos.exoplayer.core.i.l lVar) {
        int c2;
        int i;
        if (this.o == 0) {
            int i2 = 0;
            do {
                c2 = lVar.c(8);
                i = i2 + c2;
                i2 = i;
            } while (c2 == 255);
            return i;
        }
        throw new com.opos.exoplayer.core.o();
    }

    private static long f(com.opos.exoplayer.core.i.l lVar) {
        return lVar.c((lVar.c(2) + 1) * 8);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        this.g = 0;
        this.l = false;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j, boolean z) {
        this.k = j;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.d = gVar.a(dVar.b(), 1);
        this.f = dVar.c();
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        while (mVar.b() > 0) {
            int i = this.g;
            if (i != 0) {
                if (i == 1) {
                    int g = mVar.g();
                    if ((g & 224) == 224) {
                        this.j = g;
                        this.g = 2;
                    } else if (g != 86) {
                        this.g = 0;
                    }
                } else if (i == 2) {
                    int g2 = ((this.j & (-225)) << 8) | mVar.g();
                    this.i = g2;
                    if (g2 > this.b.f11808a.length) {
                        a(this.i);
                    }
                    this.h = 0;
                    this.g = 3;
                } else if (i == 3) {
                    int min = Math.min(mVar.b(), this.i - this.h);
                    mVar.a(this.f11525c.f11806a, this.h, min);
                    int i2 = min + this.h;
                    this.h = i2;
                    if (i2 == this.i) {
                        this.f11525c.a(0);
                        a(this.f11525c);
                        this.g = 0;
                    }
                }
            } else if (mVar.g() == 86) {
                this.g = 1;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
