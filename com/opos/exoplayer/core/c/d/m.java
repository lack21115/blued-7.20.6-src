package com.opos.exoplayer.core.c.d;

import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/m.class */
final class m {

    /* renamed from: a  reason: collision with root package name */
    public final int f25150a;
    public final long[] b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f25151c;
    public final int d;
    public final long[] e;
    public final int[] f;
    public final long g;

    public m(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        com.opos.exoplayer.core.i.a.a(iArr.length == jArr2.length);
        com.opos.exoplayer.core.i.a.a(jArr.length == jArr2.length);
        com.opos.exoplayer.core.i.a.a(iArr2.length == jArr2.length);
        this.b = jArr;
        this.f25151c = iArr;
        this.d = i;
        this.e = jArr2;
        this.f = iArr2;
        this.g = j;
        this.f25150a = jArr.length;
    }

    public int a(long j) {
        int a2 = u.a(this.e, j, true, false);
        while (true) {
            int i = a2;
            if (i < 0) {
                return -1;
            }
            if ((this.f[i] & 1) != 0) {
                return i;
            }
            a2 = i - 1;
        }
    }

    public int b(long j) {
        int b = u.b(this.e, j, true, false);
        while (true) {
            int i = b;
            if (i >= this.e.length) {
                return -1;
            }
            if ((this.f[i] & 1) != 0) {
                return i;
            }
            b = i + 1;
        }
    }
}
