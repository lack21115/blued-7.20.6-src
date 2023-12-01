package com.opos.exoplayer.core.c;

import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/a.class */
public final class a implements l {

    /* renamed from: a  reason: collision with root package name */
    public final int f11391a;
    public final int[] b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f11392c;
    public final long[] d;
    public final long[] e;
    private final long f;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.f11392c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        int length = iArr.length;
        this.f11391a = length;
        if (length > 0) {
            this.f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f = 0L;
        }
    }

    public int a(long j) {
        return u.a(this.e, j, true, true);
    }

    @Override // com.opos.exoplayer.core.c.l
    public boolean a() {
        return true;
    }

    @Override // com.opos.exoplayer.core.c.l
    public long b() {
        return this.f;
    }

    @Override // com.opos.exoplayer.core.c.l
    public l.a b(long j) {
        int a2 = a(j);
        m mVar = new m(this.e[a2], this.f11392c[a2]);
        if (mVar.b >= j || a2 == this.f11391a - 1) {
            return new l.a(mVar);
        }
        int i = a2 + 1;
        return new l.a(mVar, new m(this.e[i], this.f11392c[i]));
    }
}
