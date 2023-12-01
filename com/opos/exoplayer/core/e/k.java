package com.opos.exoplayer.core.e;

import com.opos.exoplayer.core.y;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/k.class */
public final class k extends y {
    private static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final long f25308c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final long h;
    private final boolean i;
    private final boolean j;

    public k(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2) {
        this.f25308c = j;
        this.d = j2;
        this.e = j3;
        this.f = j4;
        this.g = j5;
        this.h = j6;
        this.i = z;
        this.j = z2;
    }

    public k(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this(com.anythink.expressad.exoplayer.b.b, com.anythink.expressad.exoplayer.b.b, j, j2, j3, j4, z, z2);
    }

    public k(long j, boolean z, boolean z2) {
        this(j, j, 0L, 0L, z, z2);
    }

    @Override // com.opos.exoplayer.core.y
    public int a(Object obj) {
        return b.equals(obj) ? 0 : -1;
    }

    @Override // com.opos.exoplayer.core.y
    public y.a a(int i, y.a aVar, boolean z) {
        com.opos.exoplayer.core.i.a.a(i, 0, 1);
        Object obj = z ? b : null;
        return aVar.a(obj, obj, 0, this.e, -this.g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0059, code lost:
        if (r0 > r0) goto L10;
     */
    @Override // com.opos.exoplayer.core.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.opos.exoplayer.core.y.b a(int r18, com.opos.exoplayer.core.y.b r19, boolean r20, long r21) {
        /*
            r17 = this;
            r0 = r18
            r1 = 0
            r2 = 1
            int r0 = com.opos.exoplayer.core.i.a.a(r0, r1, r2)
            r0 = r20
            if (r0 == 0) goto L13
            java.lang.Object r0 = com.opos.exoplayer.core.e.k.b
            r29 = r0
            goto L16
        L13:
            r0 = 0
            r29 = r0
        L16:
            r0 = r17
            long r0 = r0.h
            r25 = r0
            r0 = r25
            r23 = r0
            r0 = r17
            boolean r0 = r0.j
            if (r0 == 0) goto L5f
            r0 = r25
            r23 = r0
            r0 = r21
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L5f
            r0 = r17
            long r0 = r0.f
            r27 = r0
            r0 = r27
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L49
        L41:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r23 = r0
            goto L5f
        L49:
            r0 = r25
            r1 = r21
            long r0 = r0 + r1
            r21 = r0
            r0 = r21
            r23 = r0
            r0 = r21
            r1 = r27
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L5f
            goto L41
        L5f:
            r0 = r19
            r1 = r29
            r2 = r17
            long r2 = r2.f25308c
            r3 = r17
            long r3 = r3.d
            r4 = r17
            boolean r4 = r4.i
            r5 = r17
            boolean r5 = r5.j
            r6 = r23
            r7 = r17
            long r7 = r7.f
            r8 = 0
            r9 = 0
            r10 = r17
            long r10 = r10.g
            com.opos.exoplayer.core.y$b r0 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.e.k.a(int, com.opos.exoplayer.core.y$b, boolean, long):com.opos.exoplayer.core.y$b");
    }

    @Override // com.opos.exoplayer.core.y
    public int b() {
        return 1;
    }

    @Override // com.opos.exoplayer.core.y
    public int c() {
        return 1;
    }
}
