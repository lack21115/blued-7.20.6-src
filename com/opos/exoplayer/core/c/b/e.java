package com.opos.exoplayer.core.c.b;

import com.opos.exoplayer.core.i.m;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/b/e.class */
final class e {

    /* renamed from: a  reason: collision with root package name */
    private final m f11410a = new m(8);
    private int b;

    private long b(com.opos.exoplayer.core.c.f fVar) {
        int i;
        int i2 = 0;
        fVar.c(this.f11410a.f11808a, 0, 1);
        int i3 = this.f11410a.f11808a[0] & 255;
        if (i3 == 0) {
            return Long.MIN_VALUE;
        }
        int i4 = 128;
        int i5 = 0;
        while (true) {
            i = i5;
            if ((i3 & i4) != 0) {
                break;
            }
            i4 >>= 1;
            i5 = i + 1;
        }
        int i6 = i3 & i4;
        fVar.c(this.f11410a.f11808a, 1, i);
        while (i2 < i) {
            i2++;
            i6 = (this.f11410a.f11808a[i2] & 255) + (i6 << 8);
        }
        this.b += i + 1;
        return i6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ce, code lost:
        if ((r0 + r0) < r0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.opos.exoplayer.core.c.f r7) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.b.e.a(com.opos.exoplayer.core.c.f):boolean");
    }
}
