package com.anythink.expressad.exoplayer.h;

import com.anythink.expressad.exoplayer.h.r;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/d.class */
public final class d implements r, r.a {

    /* renamed from: a  reason: collision with root package name */
    public final r f4600a;
    long b;

    /* renamed from: c  reason: collision with root package name */
    long f4601c;
    private r.a d;
    private a[] e = new a[0];
    private long f;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/d$a.class */
    final class a implements y {

        /* renamed from: a  reason: collision with root package name */
        public final y f4602a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4603c;

        public a(y yVar) {
            this.f4602a = yVar;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(long j) {
            if (d.this.f()) {
                return -3;
            }
            return this.f4602a.a(j);
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z) {
            if (d.this.f()) {
                return -3;
            }
            if (this.f4603c) {
                eVar.a(4);
                return -4;
            }
            int a2 = this.f4602a.a(nVar, eVar, z);
            if (a2 == -5) {
                com.anythink.expressad.exoplayer.m mVar = nVar.f4882a;
                if (mVar.x == 0 && mVar.y == 0) {
                    return -5;
                }
                int i = 0;
                int i2 = d.this.b != 0 ? 0 : mVar.x;
                if (d.this.f4601c == Long.MIN_VALUE) {
                    i = mVar.y;
                }
                nVar.f4882a = mVar.a(i2, i);
                return -5;
            } else if (d.this.f4601c == Long.MIN_VALUE || ((a2 != -4 || eVar.f < d.this.f4601c) && !(a2 == -3 && d.this.d() == Long.MIN_VALUE))) {
                return a2;
            } else {
                eVar.a();
                eVar.a(4);
                this.f4603c = true;
                return -4;
            }
        }

        public final void a() {
            this.f4603c = false;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final boolean b() {
            return !d.this.f() && this.f4602a.b();
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final void c() {
            this.f4602a.c();
        }
    }

    public d(r rVar, boolean z, long j, long j2) {
        this.f4600a = rVar;
        this.f = z ? j : -9223372036854775807L;
        this.b = j;
        this.f4601c = j2;
    }

    private static boolean a(long j, com.anythink.expressad.exoplayer.i.f[] fVarArr) {
        if (j == 0) {
            return false;
        }
        int length = fVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            com.anythink.expressad.exoplayer.i.f fVar = fVarArr[i2];
            if (fVar != null && !com.anythink.expressad.exoplayer.k.o.a(fVar.h().h)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private com.anythink.expressad.exoplayer.ac b(long j, com.anythink.expressad.exoplayer.ac acVar) {
        long a2 = com.anythink.expressad.exoplayer.k.af.a(acVar.f, j - this.b);
        long j2 = acVar.g;
        long j3 = this.f4601c;
        long a3 = com.anythink.expressad.exoplayer.k.af.a(j2, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        return (a2 == acVar.f && a3 == acVar.g) ? acVar : new com.anythink.expressad.exoplayer.ac(a2, a3);
    }

    private void g() {
        this.d.a((r.a) this);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(long j, com.anythink.expressad.exoplayer.ac acVar) {
        long j2 = this.b;
        if (j == j2) {
            return j2;
        }
        long a2 = com.anythink.expressad.exoplayer.k.af.a(acVar.f, j - this.b);
        long j3 = acVar.g;
        long j4 = this.f4601c;
        long a3 = com.anythink.expressad.exoplayer.k.af.a(j3, j4 == Long.MIN_VALUE ? Long.MAX_VALUE : j4 - j);
        if (a2 != acVar.f || a3 != acVar.g) {
            acVar = new com.anythink.expressad.exoplayer.ac(a2, a3);
        }
        return this.f4600a.a(j, acVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017c A[SYNTHETIC] */
    @Override // com.anythink.expressad.exoplayer.h.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a(com.anythink.expressad.exoplayer.i.f[] r9, boolean[] r10, com.anythink.expressad.exoplayer.h.y[] r11, boolean[] r12, long r13) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.d.a(com.anythink.expressad.exoplayer.i.f[], boolean[], com.anythink.expressad.exoplayer.h.y[], boolean[], long):long");
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a() {
        this.f4600a.a();
    }

    public final void a(long j, long j2) {
        this.b = j;
        this.f4601c = j2;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(long j, boolean z) {
        this.f4600a.a(j, z);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(r.a aVar, long j) {
        this.d = aVar;
        this.f4600a.a(this, j);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.anythink.expressad.exoplayer.h.r.a
    public final void a(r rVar) {
        this.d.a((r) this);
    }

    @Override // com.anythink.expressad.exoplayer.h.z.a
    public final /* bridge */ /* synthetic */ void a(r rVar) {
        this.d.a((r.a) this);
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final void a_(long j) {
        this.f4600a.a_(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
        if (r0 <= r0) goto L22;
     */
    @Override // com.anythink.expressad.exoplayer.h.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long b(long r6) {
        /*
            r5 = this;
            r0 = r5
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.f = r1
            r0 = r5
            com.anythink.expressad.exoplayer.h.d$a[] r0 = r0.e
            r14 = r0
            r0 = r14
            int r0 = r0.length
            r9 = r0
            r0 = 0
            r13 = r0
            r0 = 0
            r8 = r0
        L17:
            r0 = r8
            r1 = r9
            if (r0 >= r1) goto L34
            r0 = r14
            r1 = r8
            r0 = r0[r1]
            r15 = r0
            r0 = r15
            if (r0 == 0) goto L2d
            r0 = r15
            r0.a()
        L2d:
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto L17
        L34:
            r0 = r5
            com.anythink.expressad.exoplayer.h.r r0 = r0.f4600a
            r1 = r6
            long r0 = r0.b(r1)
            r10 = r0
            r0 = r10
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L6d
            r0 = r13
            r12 = r0
            r0 = r10
            r1 = r5
            long r1 = r1.b
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L70
            r0 = r5
            long r0 = r0.f4601c
            r6 = r0
            r0 = r6
            r1 = -9223372036854775808
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L6d
            r0 = r13
            r12 = r0
            r0 = r10
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L70
        L6d:
            r0 = 1
            r12 = r0
        L70:
            r0 = r12
            com.anythink.expressad.exoplayer.k.a.b(r0)
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.d.b(long):long");
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final af b() {
        return this.f4600a.b();
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long c() {
        if (f()) {
            long j = this.f;
            this.f = com.anythink.expressad.exoplayer.b.b;
            long c2 = c();
            return c2 != com.anythink.expressad.exoplayer.b.b ? c2 : j;
        }
        long c3 = this.f4600a.c();
        if (c3 == com.anythink.expressad.exoplayer.b.b) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        com.anythink.expressad.exoplayer.k.a.b(c3 >= this.b);
        long j2 = this.f4601c;
        boolean z = true;
        if (j2 != Long.MIN_VALUE) {
            z = c3 <= j2;
        }
        com.anythink.expressad.exoplayer.k.a.b(z);
        return c3;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j) {
        return this.f4600a.c(j);
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long d() {
        long d = this.f4600a.d();
        if (d != Long.MIN_VALUE) {
            long j = this.f4601c;
            if (j == Long.MIN_VALUE || d < j) {
                return d;
            }
            return Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long e() {
        long e = this.f4600a.e();
        if (e != Long.MIN_VALUE) {
            long j = this.f4601c;
            if (j == Long.MIN_VALUE || e < j) {
                return e;
            }
            return Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    final boolean f() {
        return this.f != com.anythink.expressad.exoplayer.b.b;
    }
}
