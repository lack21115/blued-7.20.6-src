package com.anythink.expressad.exoplayer.h;

import com.anythink.expressad.exoplayer.ae;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/ab.class */
public final class ab extends com.anythink.expressad.exoplayer.ae {
    private static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final long f7405c;
    private final long d;
    private final long e;
    private final long f;
    private final long g;
    private final long h;
    private final boolean i;
    private final boolean j;
    private final Object k;

    private ab(long j, long j2, boolean z, boolean z2, Object obj) {
        this.f7405c = com.anythink.expressad.exoplayer.b.b;
        this.d = com.anythink.expressad.exoplayer.b.b;
        this.e = j;
        this.f = j2;
        this.g = 0L;
        this.h = 0L;
        this.i = z;
        this.j = z2;
        this.k = obj;
    }

    private ab(long j, long j2, boolean z, boolean z2, Object obj, byte b2) {
        this(j, j2, z, z2, obj);
    }

    private ab(long j, boolean z, boolean z2) {
        this(j, z, z2, null);
    }

    public ab(long j, boolean z, boolean z2, Object obj) {
        this(j, j, z, z2, obj, (byte) 0);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int a(Object obj) {
        return b.equals(obj) ? 0 : -1;
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final ae.a a(int i, ae.a aVar, boolean z) {
        com.anythink.expressad.exoplayer.k.a.a(i, 1);
        return aVar.a(null, z ? b : null, this.e, -this.g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0059, code lost:
        if (r0 > r0) goto L10;
     */
    @Override // com.anythink.expressad.exoplayer.ae
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.anythink.expressad.exoplayer.ae.b a(int r16, com.anythink.expressad.exoplayer.ae.b r17, boolean r18, long r19) {
        /*
            r15 = this;
            r0 = r16
            r1 = 1
            int r0 = com.anythink.expressad.exoplayer.k.a.a(r0, r1)
            r0 = r18
            if (r0 == 0) goto L13
            r0 = r15
            java.lang.Object r0 = r0.k
            r27 = r0
            goto L16
        L13:
            r0 = 0
            r27 = r0
        L16:
            r0 = r15
            long r0 = r0.h
            r23 = r0
            r0 = r23
            r21 = r0
            r0 = r15
            boolean r0 = r0.j
            if (r0 == 0) goto L5f
            r0 = r23
            r21 = r0
            r0 = r19
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L5f
            r0 = r15
            long r0 = r0.f
            r25 = r0
            r0 = r25
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L49
        L41:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r21 = r0
            goto L5f
        L49:
            r0 = r23
            r1 = r19
            long r0 = r0 + r1
            r19 = r0
            r0 = r19
            r21 = r0
            r0 = r19
            r1 = r25
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L5f
            goto L41
        L5f:
            r0 = r17
            r1 = r27
            r2 = r15
            long r2 = r2.f7405c
            r3 = r15
            long r3 = r3.d
            r4 = r15
            boolean r4 = r4.i
            r5 = r15
            boolean r5 = r5.j
            r6 = r21
            r7 = r15
            long r7 = r7.f
            r8 = r15
            long r8 = r8.g
            com.anythink.expressad.exoplayer.ae$b r0 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.ab.a(int, com.anythink.expressad.exoplayer.ae$b, boolean, long):com.anythink.expressad.exoplayer.ae$b");
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int b() {
        return 1;
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int c() {
        return 1;
    }
}
