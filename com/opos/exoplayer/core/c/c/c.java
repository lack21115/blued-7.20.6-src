package com.opos.exoplayer.core.c.c;

import com.opos.exoplayer.core.c.c.a;
import com.opos.exoplayer.core.c.j;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/c/c.class */
final class c implements a.InterfaceC0480a {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f11419a;
    private final long[] b;

    /* renamed from: c  reason: collision with root package name */
    private final long f11420c;

    private c(long[] jArr, long[] jArr2, long j) {
        this.f11419a = jArr;
        this.b = jArr2;
        this.f11420c = j;
    }

    public static c a(long j, long j2, j jVar, m mVar) {
        int g;
        mVar.d(10);
        int o = mVar.o();
        if (o <= 0) {
            return null;
        }
        int i = jVar.d;
        long d = u.d(o, (i >= 32000 ? 1152 : 576) * 1000000, i);
        int h = mVar.h();
        int h2 = mVar.h();
        int h3 = mVar.h();
        mVar.d(2);
        long j3 = jVar.f11560c;
        long[] jArr = new long[h];
        long[] jArr2 = new long[h];
        long j4 = j2;
        for (int i2 = 0; i2 < h; i2++) {
            jArr[i2] = (i2 * d) / h;
            jArr2[i2] = Math.max(j4, j2 + j3);
            if (h3 == 1) {
                g = mVar.g();
            } else if (h3 == 2) {
                g = mVar.h();
            } else if (h3 == 3) {
                g = mVar.k();
            } else if (h3 != 4) {
                return null;
            } else {
                g = mVar.u();
            }
            j4 += g * h2;
        }
        if (j != -1 && j != j4) {
            com.opos.cmn.an.f.a.c("VbriSeeker", "VBRI data size mismatch: " + j + ", " + j4);
        }
        return new c(jArr, jArr2, d);
    }

    @Override // com.opos.exoplayer.core.c.c.a.InterfaceC0480a
    public long a(long j) {
        return this.f11419a[u.a(this.b, j, true, true)];
    }

    @Override // com.opos.exoplayer.core.c.l
    public boolean a() {
        return true;
    }

    @Override // com.opos.exoplayer.core.c.l
    public long b() {
        return this.f11420c;
    }

    @Override // com.opos.exoplayer.core.c.l
    public l.a b(long j) {
        int a2 = u.a(this.f11419a, j, true, true);
        com.opos.exoplayer.core.c.m mVar = new com.opos.exoplayer.core.c.m(this.f11419a[a2], this.b[a2]);
        if (mVar.b < j) {
            long[] jArr = this.f11419a;
            if (a2 != jArr.length - 1) {
                int i = a2 + 1;
                return new l.a(mVar, new com.opos.exoplayer.core.c.m(jArr[i], this.b[i]));
            }
        }
        return new l.a(mVar);
    }
}
