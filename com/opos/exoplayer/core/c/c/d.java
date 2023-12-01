package com.opos.exoplayer.core.c.c;

import com.opos.exoplayer.core.c.c.a;
import com.opos.exoplayer.core.c.j;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/c/d.class */
final class d implements a.InterfaceC0480a {

    /* renamed from: a  reason: collision with root package name */
    private final long f11421a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final long f11422c;
    private final long d;
    private final long[] e;

    private d(long j, int i, long j2) {
        this(j, i, j2, -1L, null);
    }

    private d(long j, int i, long j2, long j3, long[] jArr) {
        this.f11421a = j;
        this.b = i;
        this.f11422c = j2;
        this.d = j3;
        this.e = jArr;
    }

    private long a(int i) {
        return (this.f11422c * i) / 100;
    }

    public static d a(long j, long j2, j jVar, m mVar) {
        int u;
        int i = jVar.g;
        int i2 = jVar.d;
        int o = mVar.o();
        if ((o & 1) != 1 || (u = mVar.u()) == 0) {
            return null;
        }
        long d = u.d(u, i * 1000000, i2);
        if ((o & 6) != 6) {
            return new d(j2, jVar.f11560c, d);
        }
        long u2 = mVar.u();
        long[] jArr = new long[100];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 100) {
                break;
            }
            jArr[i4] = mVar.g();
            i3 = i4 + 1;
        }
        if (j != -1) {
            long j3 = j2 + u2;
            if (j != j3) {
                com.opos.cmn.an.f.a.c("XingSeeker", "XING data size mismatch: " + j + ", " + j3);
            }
        }
        return new d(j2, jVar.f11560c, d, u2, jArr);
    }

    @Override // com.opos.exoplayer.core.c.c.a.InterfaceC0480a
    public long a(long j) {
        long j2 = j - this.f11421a;
        if (!a() || j2 <= this.b) {
            return 0L;
        }
        double d = (j2 * 256.0d) / this.d;
        int a2 = u.a(this.e, (long) d, true, true);
        long a3 = a(a2);
        long j3 = this.e[a2];
        int i = a2 + 1;
        long a4 = a(i);
        long j4 = a2 == 99 ? 256L : this.e[i];
        return Math.round((j3 == j4 ? 0.0d : (d - j3) / (j4 - j3)) * (a4 - a3)) + a3;
    }

    @Override // com.opos.exoplayer.core.c.l
    public boolean a() {
        return this.e != null;
    }

    @Override // com.opos.exoplayer.core.c.l
    public long b() {
        return this.f11422c;
    }

    @Override // com.opos.exoplayer.core.c.l
    public l.a b(long j) {
        long[] jArr;
        if (a()) {
            long a2 = u.a(j, 0L, this.f11422c);
            double d = (a2 * 100.0d) / this.f11422c;
            double d2 = 0.0d;
            if (d > 0.0d) {
                if (d >= 100.0d) {
                    d2 = 256.0d;
                } else {
                    int i = (int) d;
                    double d3 = this.e[i];
                    d2 = d3 + (((i == 99 ? 256.0d : jArr[i + 1]) - d3) * (d - i));
                }
            }
            return new l.a(new com.opos.exoplayer.core.c.m(a2, u.a(Math.round((d2 / 256.0d) * this.d), this.b, this.d - 1) + this.f11421a));
        }
        return new l.a(new com.opos.exoplayer.core.c.m(0L, this.f11421a + this.b));
    }
}
