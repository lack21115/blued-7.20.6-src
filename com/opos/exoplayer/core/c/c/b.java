package com.opos.exoplayer.core.c.c;

import com.opos.exoplayer.core.c.c.a;
import com.opos.exoplayer.core.c.j;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.m;
import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/c/b.class */
final class b implements a.InterfaceC0650a {

    /* renamed from: a  reason: collision with root package name */
    private final long f25105a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final long f25106c;
    private final int d;
    private final long e;

    public b(long j, long j2, j jVar) {
        long a2;
        this.f25105a = j2;
        this.b = jVar.f25248c;
        this.d = jVar.f;
        if (j == -1) {
            this.f25106c = -1L;
            a2 = -9223372036854775807L;
        } else {
            this.f25106c = j - j2;
            a2 = a(j);
        }
        this.e = a2;
    }

    @Override // com.opos.exoplayer.core.c.c.a.InterfaceC0650a
    public long a(long j) {
        return ((Math.max(0L, j - this.f25105a) * 1000000) * 8) / this.d;
    }

    @Override // com.opos.exoplayer.core.c.l
    public boolean a() {
        return this.f25106c != -1;
    }

    @Override // com.opos.exoplayer.core.c.l
    public long b() {
        return this.e;
    }

    @Override // com.opos.exoplayer.core.c.l
    public l.a b(long j) {
        long j2 = this.f25106c;
        if (j2 == -1) {
            return new l.a(new m(0L, this.f25105a));
        }
        long j3 = (this.d * j) / 8000000;
        int i = this.b;
        long a2 = u.a((j3 / i) * i, 0L, j2 - i);
        long j4 = this.f25105a + a2;
        long a3 = a(j4);
        m mVar = new m(a3, j4);
        if (a3 < j) {
            long j5 = this.f25106c;
            int i2 = this.b;
            if (a2 != j5 - i2) {
                long j6 = i2 + j4;
                return new l.a(mVar, new m(a(j6), j6));
            }
        }
        return new l.a(mVar);
    }
}
