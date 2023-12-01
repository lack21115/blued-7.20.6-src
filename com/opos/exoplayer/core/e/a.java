package com.opos.exoplayer.core.e;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.e.d;
import com.opos.exoplayer.core.w;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/a.class */
public final class a implements d, d.a {

    /* renamed from: a  reason: collision with root package name */
    public final d f25274a;
    long b;

    /* renamed from: c  reason: collision with root package name */
    long f25275c;
    private d.a d;
    private C0657a[] e = new C0657a[0];
    private long f;

    /* renamed from: com.opos.exoplayer.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/a$a.class */
    final class C0657a implements i {

        /* renamed from: a  reason: collision with root package name */
        public final i f25278a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f25279c;

        public C0657a(i iVar) {
            this.f25278a = iVar;
        }

        @Override // com.opos.exoplayer.core.e.i
        public int a(long j) {
            if (a.this.f()) {
                return -3;
            }
            return this.f25278a.a(a.this.b + j);
        }

        @Override // com.opos.exoplayer.core.e.i
        public int a(com.opos.exoplayer.core.l lVar, com.opos.exoplayer.core.b.e eVar, boolean z) {
            int i = -5;
            if (a.this.f()) {
                return -3;
            }
            if (this.f25279c) {
                eVar.a_(4);
                return -4;
            }
            int a2 = this.f25278a.a(lVar, eVar, z);
            if (a2 == -5) {
                Format format = lVar.f25515a;
                if (format.u != -1 || format.v != -1) {
                    int i2 = 0;
                    int i3 = a.this.b != 0 ? 0 : format.u;
                    if (a.this.f25275c == Long.MIN_VALUE) {
                        i2 = format.v;
                    }
                    lVar.f25515a = format.a(i3, i2);
                    return -5;
                }
            } else if (a.this.f25275c != Long.MIN_VALUE && ((a2 == -4 && eVar.f25074c >= a.this.f25275c) || (a2 == -3 && a.this.d() == Long.MIN_VALUE))) {
                eVar.a();
                eVar.a_(4);
                this.f25279c = true;
                return -4;
            } else {
                if (a2 == -4 && !eVar.c()) {
                    eVar.f25074c -= a.this.b;
                }
                i = a2;
            }
            return i;
        }

        public void a() {
            this.f25279c = false;
        }

        @Override // com.opos.exoplayer.core.e.i
        public boolean b() {
            return !a.this.f() && this.f25278a.b();
        }

        @Override // com.opos.exoplayer.core.e.i
        public void c() {
            this.f25278a.c();
        }
    }

    public a(d dVar, boolean z) {
        this.f25274a = dVar;
        this.f = z ? 0L : -9223372036854775807L;
        this.b = com.anythink.expressad.exoplayer.b.b;
        this.f25275c = com.anythink.expressad.exoplayer.b.b;
    }

    private static boolean a(long j, com.opos.exoplayer.core.g.f[] fVarArr) {
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
            com.opos.exoplayer.core.g.f fVar = fVarArr[i2];
            if (fVar != null && !com.opos.exoplayer.core.i.j.a(fVar.f().f)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private w b(long j, w wVar) {
        long min = Math.min(j - this.b, wVar.f);
        long j2 = this.f25275c;
        long min2 = j2 == Long.MIN_VALUE ? wVar.g : Math.min(j2 - j, wVar.g);
        return (min == wVar.f && min2 == wVar.g) ? wVar : new w(min, min2);
    }

    @Override // com.opos.exoplayer.core.e.d
    public long a(long j, w wVar) {
        long j2 = this.b;
        if (j == j2) {
            return 0L;
        }
        long j3 = j2 + j;
        return this.f25274a.a(j3, b(j3, wVar)) - this.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c8, code lost:
        if ((r10.b + r0) > r0) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013b A[SYNTHETIC] */
    @Override // com.opos.exoplayer.core.e.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(com.opos.exoplayer.core.g.f[] r11, boolean[] r12, com.opos.exoplayer.core.e.i[] r13, boolean[] r14, long r15) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.e.a.a(com.opos.exoplayer.core.g.f[], boolean[], com.opos.exoplayer.core.e.i[], boolean[], long):long");
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(long j) {
        this.f25274a.a(this.b + j);
    }

    public void a(long j, long j2) {
        this.b = j;
        this.f25275c = j2;
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(long j, boolean z) {
        this.f25274a.a(this.b + j, z);
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(d.a aVar, long j) {
        this.d = aVar;
        this.f25274a.a(this, this.b + j);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.opos.exoplayer.core.e.d.a
    public void a(d dVar) {
        com.opos.exoplayer.core.i.a.b((this.b == com.anythink.expressad.exoplayer.b.b || this.f25275c == com.anythink.expressad.exoplayer.b.b) ? false : true);
        this.d.a((d) this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0073, code lost:
        if (r0 <= r0) goto L22;
     */
    @Override // com.opos.exoplayer.core.e.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long b(long r6) {
        /*
            r5 = this;
            r0 = r5
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.f = r1
            r0 = r5
            com.opos.exoplayer.core.e.a$a[] r0 = r0.e
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
            long r0 = r0.b
            r1 = r6
            long r0 = r0 + r1
            r10 = r0
            r0 = r5
            com.opos.exoplayer.core.e.d r0 = r0.f25274a
            r1 = r10
            long r0 = r0.b(r1)
            r6 = r0
            r0 = r6
            r1 = r10
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L76
            r0 = r13
            r12 = r0
            r0 = r6
            r1 = r5
            long r1 = r1.b
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L79
            r0 = r5
            long r0 = r0.f25275c
            r10 = r0
            r0 = r10
            r1 = -9223372036854775808
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L76
            r0 = r13
            r12 = r0
            r0 = r6
            r1 = r10
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L79
        L76:
            r0 = 1
            r12 = r0
        L79:
            r0 = r12
            com.opos.exoplayer.core.i.a.b(r0)
            r0 = r6
            r1 = r5
            long r1 = r1.b
            long r0 = r0 - r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.e.a.b(long):long");
    }

    @Override // com.opos.exoplayer.core.e.d
    public m b() {
        return this.f25274a.b();
    }

    @Override // com.opos.exoplayer.core.e.j.a
    /* renamed from: b */
    public void a(d dVar) {
        this.d.a((d.a) this);
    }

    @Override // com.opos.exoplayer.core.e.d
    public long c() {
        if (f()) {
            long j = this.f;
            this.f = com.anythink.expressad.exoplayer.b.b;
            long c2 = c();
            return c2 != com.anythink.expressad.exoplayer.b.b ? c2 : j;
        }
        long c3 = this.f25274a.c();
        if (c3 == com.anythink.expressad.exoplayer.b.b) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        com.opos.exoplayer.core.i.a.b(c3 >= this.b);
        long j2 = this.f25275c;
        boolean z = true;
        if (j2 != Long.MIN_VALUE) {
            z = c3 <= j2;
        }
        com.opos.exoplayer.core.i.a.b(z);
        return c3 - this.b;
    }

    @Override // com.opos.exoplayer.core.e.d
    public boolean c(long j) {
        return this.f25274a.c(this.b + j);
    }

    @Override // com.opos.exoplayer.core.e.d
    public void c_() {
        this.f25274a.c_();
    }

    @Override // com.opos.exoplayer.core.e.d
    public long d() {
        long d = this.f25274a.d();
        long j = Long.MIN_VALUE;
        if (d != Long.MIN_VALUE) {
            long j2 = this.f25275c;
            if (j2 != Long.MIN_VALUE && d >= j2) {
                return Long.MIN_VALUE;
            }
            j = Math.max(0L, d - this.b);
        }
        return j;
    }

    @Override // com.opos.exoplayer.core.e.d
    public long e() {
        long e = this.f25274a.e();
        long j = Long.MIN_VALUE;
        if (e != Long.MIN_VALUE) {
            long j2 = this.f25275c;
            if (j2 != Long.MIN_VALUE && e >= j2) {
                return Long.MIN_VALUE;
            }
            j = e - this.b;
        }
        return j;
    }

    boolean f() {
        return this.f != com.anythink.expressad.exoplayer.b.b;
    }
}
