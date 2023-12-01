package com.opos.exoplayer.core.c.f;

import android.util.SparseArray;
import com.opos.exoplayer.core.c.l;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/p.class */
public final class p implements com.opos.exoplayer.core.c.e {

    /* renamed from: a  reason: collision with root package name */
    public static final com.opos.exoplayer.core.c.h f25218a = new com.opos.exoplayer.core.c.h() { // from class: com.opos.exoplayer.core.c.f.p.1
        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new p()};
        }
    };
    private final com.opos.exoplayer.core.i.s b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<a> f25219c;
    private final com.opos.exoplayer.core.i.m d;
    private boolean e;
    private boolean f;
    private boolean g;
    private com.opos.exoplayer.core.c.g h;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/p$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final h f25220a;
        private final com.opos.exoplayer.core.i.s b;

        /* renamed from: c  reason: collision with root package name */
        private final com.opos.exoplayer.core.i.l f25221c = new com.opos.exoplayer.core.i.l(new byte[64]);
        private boolean d;
        private boolean e;
        private boolean f;
        private int g;
        private long h;

        public a(h hVar, com.opos.exoplayer.core.i.s sVar) {
            this.f25220a = hVar;
            this.b = sVar;
        }

        private void b() {
            this.f25221c.b(8);
            this.d = this.f25221c.e();
            this.e = this.f25221c.e();
            this.f25221c.b(6);
            this.g = this.f25221c.c(8);
        }

        private void c() {
            this.h = 0L;
            if (this.d) {
                this.f25221c.b(4);
                long c2 = this.f25221c.c(3);
                this.f25221c.b(1);
                long c3 = this.f25221c.c(15) << 15;
                this.f25221c.b(1);
                long c4 = this.f25221c.c(15);
                this.f25221c.b(1);
                if (!this.f && this.e) {
                    this.f25221c.b(4);
                    long c5 = this.f25221c.c(3);
                    this.f25221c.b(1);
                    long c6 = this.f25221c.c(15) << 15;
                    this.f25221c.b(1);
                    long c7 = this.f25221c.c(15);
                    this.f25221c.b(1);
                    this.b.b((c5 << 30) | c6 | c7);
                    this.f = true;
                }
                this.h = this.b.b((c2 << 30) | c3 | c4);
            }
        }

        public void a() {
            this.f = false;
            this.f25220a.a();
        }

        public void a(com.opos.exoplayer.core.i.m mVar) {
            mVar.a(this.f25221c.f25494a, 0, 3);
            this.f25221c.a(0);
            b();
            mVar.a(this.f25221c.f25494a, 0, this.g);
            this.f25221c.a(0);
            c();
            this.f25220a.a(this.h, true);
            this.f25220a.a(mVar);
            this.f25220a.b();
        }
    }

    public p() {
        this(new com.opos.exoplayer.core.i.s(0L));
    }

    public p(com.opos.exoplayer.core.i.s sVar) {
        this.b = sVar;
        this.d = new com.opos.exoplayer.core.i.m(4096);
        this.f25219c = new SparseArray<>();
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0182, code lost:
        if (r7.c() > 1048576) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0136  */
    @Override // com.opos.exoplayer.core.c.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(com.opos.exoplayer.core.c.f r7, com.opos.exoplayer.core.c.k r8) {
        /*
            Method dump skipped, instructions count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.p.a(com.opos.exoplayer.core.c.f, com.opos.exoplayer.core.c.k):int");
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        this.b.d();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f25219c.size()) {
                return;
            }
            this.f25219c.valueAt(i2).a();
            i = i2 + 1;
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.h = gVar;
        gVar.a(new l.b(com.anythink.expressad.exoplayer.b.b));
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        byte[] bArr = new byte[14];
        fVar.c(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255))) {
            return false;
        }
        boolean z = false;
        if ((bArr[4] & 196) == 68) {
            z = false;
            if ((bArr[6] & 4) == 4) {
                z = false;
                if ((bArr[8] & 4) == 4) {
                    z = false;
                    if ((bArr[9] & 1) == 1) {
                        z = false;
                        if ((bArr[12] & 3) == 3) {
                            fVar.c(bArr[13] & 7);
                            fVar.c(bArr, 0, 3);
                            z = false;
                            if (1 == (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
                                z = true;
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
