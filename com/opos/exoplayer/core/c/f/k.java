package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.drm.DrmInitData;
import java.util.Collections;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/k.class */
public final class k implements h {

    /* renamed from: a  reason: collision with root package name */
    private final w f25206a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.exoplayer.core.c.n f25207c;
    private a d;
    private boolean e;
    private long l;
    private long m;
    private final boolean[] f = new boolean[3];
    private final v g = new v(32, 128);
    private final v h = new v(33, 128);
    private final v i = new v(34, 128);
    private final v j = new v(39, 128);
    private final v k = new v(40, 128);
    private final com.opos.exoplayer.core.i.m n = new com.opos.exoplayer.core.i.m();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/k$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final com.opos.exoplayer.core.c.n f25208a;
        private long b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f25209c;
        private int d;
        private long e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private long k;
        private long l;
        private boolean m;

        public a(com.opos.exoplayer.core.c.n nVar) {
            this.f25208a = nVar;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        private void a(int i) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        public void a() {
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public void a(long j, int i) {
            if (this.j && this.g) {
                this.m = this.f25209c;
                this.j = false;
            } else if (this.h || this.g) {
                if (this.i) {
                    a(((int) (j - this.b)) + i);
                }
                this.k = this.b;
                this.l = this.e;
                this.i = true;
                this.m = this.f25209c;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
            if (r8 <= 9) goto L23;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(long r5, int r7, int r8, long r9) {
            /*
                r4 = this;
                r0 = 0
                r12 = r0
                r0 = r4
                r1 = 0
                r0.g = r1
                r0 = r4
                r1 = 0
                r0.h = r1
                r0 = r4
                r1 = r9
                r0.e = r1
                r0 = r4
                r1 = 0
                r0.d = r1
                r0 = r4
                r1 = r5
                r0.b = r1
                r0 = r8
                r1 = 32
                if (r0 < r1) goto L52
                r0 = r4
                boolean r0 = r0.j
                if (r0 != 0) goto L3c
                r0 = r4
                boolean r0 = r0.i
                if (r0 == 0) goto L3c
                r0 = r4
                r1 = r7
                r0.a(r1)
                r0 = r4
                r1 = 0
                r0.i = r1
            L3c:
                r0 = r8
                r1 = 34
                if (r0 > r1) goto L52
                r0 = r4
                r1 = r4
                boolean r1 = r1.j
                r2 = 1
                r1 = r1 ^ r2
                r0.h = r1
                r0 = r4
                r1 = 1
                r0.j = r1
            L52:
                r0 = r8
                r1 = 16
                if (r0 < r1) goto L66
                r0 = r8
                r1 = 21
                if (r0 > r1) goto L66
                r0 = 1
                r11 = r0
                goto L69
            L66:
                r0 = 0
                r11 = r0
            L69:
                r0 = r4
                r1 = r11
                r0.f25209c = r1
                r0 = r11
                if (r0 != 0) goto L7f
                r0 = r12
                r11 = r0
                r0 = r8
                r1 = 9
                if (r0 > r1) goto L82
            L7f:
                r0 = 1
                r11 = r0
            L82:
                r0 = r4
                r1 = r11
                r0.f = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.k.a.a(long, int, int, long):void");
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.f) {
                int i3 = this.d;
                int i4 = (i + 2) - i3;
                if (i4 >= i2) {
                    this.d = i3 + (i2 - i);
                    return;
                }
                this.g = (bArr[i4] & 128) != 0;
                this.f = false;
            }
        }
    }

    public k(w wVar) {
        this.f25206a = wVar;
    }

    private static Format a(String str, v vVar, v vVar2, v vVar3) {
        float f;
        byte[] bArr = new byte[vVar.b + vVar2.b + vVar3.b];
        System.arraycopy((Object) vVar.f25237a, 0, (Object) bArr, 0, vVar.b);
        System.arraycopy((Object) vVar2.f25237a, 0, (Object) bArr, vVar.b, vVar2.b);
        System.arraycopy((Object) vVar3.f25237a, 0, (Object) bArr, vVar.b + vVar2.b, vVar3.b);
        com.opos.exoplayer.core.i.n nVar = new com.opos.exoplayer.core.i.n(vVar2.f25237a, 0, vVar2.b);
        nVar.a(44);
        int c2 = nVar.c(3);
        nVar.a();
        nVar.a(88);
        nVar.a(8);
        int i = 0;
        for (int i2 = 0; i2 < c2; i2++) {
            int i3 = i;
            if (nVar.b()) {
                i3 = i + 89;
            }
            i = i3;
            if (nVar.b()) {
                i = i3 + 8;
            }
        }
        nVar.a(i);
        if (c2 > 0) {
            nVar.a((8 - c2) * 2);
        }
        nVar.d();
        int d = nVar.d();
        if (d == 3) {
            nVar.a();
        }
        int d2 = nVar.d();
        int d3 = nVar.d();
        int i4 = d2;
        int i5 = d3;
        if (nVar.b()) {
            int d4 = nVar.d();
            int d5 = nVar.d();
            int d6 = nVar.d();
            int d7 = nVar.d();
            i4 = d2 - (((d == 1 || d == 2) ? 2 : 1) * (d4 + d5));
            i5 = d3 - ((d == 1 ? 2 : 1) * (d6 + d7));
        }
        nVar.d();
        nVar.d();
        int d8 = nVar.d();
        int i6 = nVar.b() ? 0 : c2;
        while (true) {
            int i7 = i6;
            nVar.d();
            nVar.d();
            nVar.d();
            if (i7 > c2) {
                break;
            }
            i6 = i7 + 1;
        }
        nVar.d();
        nVar.d();
        nVar.d();
        if (nVar.b() && nVar.b()) {
            a(nVar);
        }
        nVar.a(2);
        if (nVar.b()) {
            nVar.a(8);
            nVar.d();
            nVar.d();
            nVar.a();
        }
        b(nVar);
        if (nVar.b()) {
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= nVar.d()) {
                    break;
                }
                nVar.a(d8 + 4 + 1);
                i8 = i9 + 1;
            }
        }
        nVar.a(2);
        if (nVar.b() && nVar.b()) {
            int c3 = nVar.c(8);
            if (c3 == 255) {
                int c4 = nVar.c(16);
                int c5 = nVar.c(16);
                if (c4 != 0 && c5 != 0) {
                    f = c4 / c5;
                }
            } else if (c3 < com.opos.exoplayer.core.i.k.b.length) {
                f = com.opos.exoplayer.core.i.k.b[c3];
            } else {
                com.opos.cmn.an.f.a.c("H265Reader", "Unexpected aspect_ratio_idc value: " + c3);
            }
            return Format.a(str, "video/hevc", (String) null, -1, -1, i4, i5, -1.0f, Collections.singletonList(bArr), -1, f, (DrmInitData) null);
        }
        f = 1.0f;
        return Format.a(str, "video/hevc", (String) null, -1, -1, i4, i5, -1.0f, Collections.singletonList(bArr), -1, f, (DrmInitData) null);
    }

    private void a(long j, int i, int i2, long j2) {
        if (this.e) {
            this.d.a(j, i, i2, j2);
        } else {
            this.g.a(i2);
            this.h.a(i2);
            this.i.a(i2);
        }
        this.j.a(i2);
        this.k.a(i2);
    }

    private static void a(com.opos.exoplayer.core.i.n nVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 4) {
                return;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < 6) {
                    if (nVar.b()) {
                        int min = Math.min(64, 1 << ((i2 << 1) + 4));
                        if (i2 > 1) {
                            nVar.e();
                        }
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= min) {
                                break;
                            }
                            nVar.e();
                            i5 = i6 + 1;
                        }
                    } else {
                        nVar.d();
                    }
                    int i7 = 1;
                    if (i2 == 3) {
                        i7 = 3;
                    }
                    i3 = i4 + i7;
                }
            }
            i = i2 + 1;
        }
    }

    private void a(byte[] bArr, int i, int i2) {
        if (this.e) {
            this.d.a(bArr, i, i2);
        } else {
            this.g.a(bArr, i, i2);
            this.h.a(bArr, i, i2);
            this.i.a(bArr, i, i2);
        }
        this.j.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    private void b(long j, int i, int i2, long j2) {
        if (this.e) {
            this.d.a(j, i);
        } else {
            this.g.b(i2);
            this.h.b(i2);
            this.i.b(i2);
            if (this.g.b() && this.h.b() && this.i.b()) {
                this.f25207c.a(a(this.b, this.g, this.h, this.i));
                this.e = true;
            }
        }
        if (this.j.b(i2)) {
            this.n.a(this.j.f25237a, com.opos.exoplayer.core.i.k.a(this.j.f25237a, this.j.b));
            this.n.d(5);
            this.f25206a.a(j2, this.n);
        }
        if (this.k.b(i2)) {
            this.n.a(this.k.f25237a, com.opos.exoplayer.core.i.k.a(this.k.f25237a, this.k.b));
            this.n.d(5);
            this.f25206a.a(j2, this.n);
        }
    }

    private static void b(com.opos.exoplayer.core.i.n nVar) {
        int i;
        int d = nVar.d();
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= d) {
                return;
            }
            if (i2 != 0) {
                z = nVar.b();
            }
            if (z) {
                nVar.a();
                nVar.d();
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    i = i4;
                    if (i6 <= i4) {
                        if (nVar.b()) {
                            nVar.a();
                        }
                        i5 = i6 + 1;
                    }
                }
            } else {
                int d2 = nVar.d();
                int d3 = nVar.d();
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 >= d2) {
                        break;
                    }
                    nVar.d();
                    nVar.a();
                    i7 = i8 + 1;
                }
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 >= d3) {
                        break;
                    }
                    nVar.d();
                    nVar.a();
                    i9 = i10 + 1;
                }
                i = d2 + d3;
            }
            i2++;
            i3 = i;
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        com.opos.exoplayer.core.i.k.a(this.f);
        this.g.a();
        this.h.a();
        this.i.a();
        this.j.a();
        this.k.a();
        this.d.a();
        this.l = 0L;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j, boolean z) {
        this.m = j;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.b = dVar.c();
        com.opos.exoplayer.core.c.n a2 = gVar.a(dVar.b(), 2);
        this.f25207c = a2;
        this.d = new a(a2);
        this.f25206a.a(gVar, dVar);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        while (mVar.b() > 0) {
            int d = mVar.d();
            int c2 = mVar.c();
            byte[] bArr = mVar.f25496a;
            this.l += mVar.b();
            this.f25207c.a(mVar, mVar.b());
            while (d < c2) {
                int a2 = com.opos.exoplayer.core.i.k.a(bArr, d, c2, this.f);
                if (a2 == c2) {
                    a(bArr, d, c2);
                    return;
                }
                int c3 = com.opos.exoplayer.core.i.k.c(bArr, a2);
                int i = a2 - d;
                if (i > 0) {
                    a(bArr, d, a2);
                }
                int i2 = c2 - a2;
                long j = this.l - i2;
                b(j, i2, i < 0 ? -i : 0, this.m);
                a(j, i2, c3, this.m);
                d = a2 + 3;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
