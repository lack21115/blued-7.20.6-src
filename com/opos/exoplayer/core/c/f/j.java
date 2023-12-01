package com.opos.exoplayer.core.c.f;

import android.util.SparseArray;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.k;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/j.class */
public final class j implements h {

    /* renamed from: a  reason: collision with root package name */
    private final w f25200a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f25201c;
    private long g;
    private String i;
    private com.opos.exoplayer.core.c.n j;
    private a k;
    private boolean l;
    private long m;
    private final boolean[] h = new boolean[3];
    private final v d = new v(7, 128);
    private final v e = new v(8, 128);
    private final v f = new v(6, 128);
    private final com.opos.exoplayer.core.i.m n = new com.opos.exoplayer.core.i.m();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/j$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final com.opos.exoplayer.core.c.n f25202a;
        private final boolean b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f25203c;
        private final com.opos.exoplayer.core.i.n f;
        private byte[] g;
        private int h;
        private int i;
        private long j;
        private boolean k;
        private long l;
        private boolean o;
        private long p;
        private long q;
        private boolean r;
        private final SparseArray<k.b> d = new SparseArray<>();
        private final SparseArray<k.a> e = new SparseArray<>();
        private C0654a m = new C0654a();
        private C0654a n = new C0654a();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.opos.exoplayer.core.c.f.j$a$a  reason: collision with other inner class name */
        /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/j$a$a.class */
        public static final class C0654a {

            /* renamed from: a  reason: collision with root package name */
            private boolean f25204a;
            private boolean b;

            /* renamed from: c  reason: collision with root package name */
            private k.b f25205c;
            private int d;
            private int e;
            private int f;
            private int g;
            private boolean h;
            private boolean i;
            private boolean j;
            private boolean k;
            private int l;
            private int m;
            private int n;
            private int o;
            private int p;

            private C0654a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
                if (r3.j == r4.j) goto L17;
             */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x007f, code lost:
                if (r0 != 0) goto L23;
             */
            /* JADX WARN: Code restructure failed: missing block: B:31:0x00b1, code lost:
                if (r3.n == r4.n) goto L31;
             */
            /* JADX WARN: Code restructure failed: missing block: B:39:0x00e5, code lost:
                if (r3.p == r4.p) goto L39;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean a(com.opos.exoplayer.core.c.f.j.a.C0654a r4) {
                /*
                    Method dump skipped, instructions count: 284
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.j.a.C0654a.a(com.opos.exoplayer.core.c.f.j$a$a):boolean");
            }

            public void a() {
                this.b = false;
                this.f25204a = false;
            }

            public void a(int i) {
                this.e = i;
                this.b = true;
            }

            public void a(k.b bVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.f25205c = bVar;
                this.d = i;
                this.e = i2;
                this.f = i3;
                this.g = i4;
                this.h = z;
                this.i = z2;
                this.j = z3;
                this.k = z4;
                this.l = i5;
                this.m = i6;
                this.n = i7;
                this.o = i8;
                this.p = i9;
                this.f25204a = true;
                this.b = true;
            }

            public boolean b() {
                if (this.b) {
                    int i = this.e;
                    return i == 7 || i == 2;
                }
                return false;
            }
        }

        public a(com.opos.exoplayer.core.c.n nVar, boolean z, boolean z2) {
            this.f25202a = nVar;
            this.b = z;
            this.f25203c = z2;
            byte[] bArr = new byte[128];
            this.g = bArr;
            this.f = new com.opos.exoplayer.core.i.n(bArr, 0, 0);
            b();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        private void a(int i) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0082, code lost:
            if (r6.n.b() != false) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(long r7, int r9) {
            /*
                r6 = this;
                r0 = r6
                int r0 = r0.i
                r11 = r0
                r0 = 0
                r10 = r0
                r0 = r11
                r1 = 9
                if (r0 == r1) goto L25
                r0 = r6
                boolean r0 = r0.f25203c
                if (r0 == 0) goto L53
                r0 = r6
                com.opos.exoplayer.core.c.f.j$a$a r0 = r0.n
                r1 = r6
                com.opos.exoplayer.core.c.f.j$a$a r1 = r1.m
                boolean r0 = com.opos.exoplayer.core.c.f.j.a.C0654a.a(r0, r1)
                if (r0 == 0) goto L53
            L25:
                r0 = r6
                boolean r0 = r0.o
                if (r0 == 0) goto L39
                r0 = r6
                r1 = r7
                r2 = r6
                long r2 = r2.j
                long r1 = r1 - r2
                int r1 = (int) r1
                r2 = r9
                int r1 = r1 + r2
                r0.a(r1)
            L39:
                r0 = r6
                r1 = r6
                long r1 = r1.j
                r0.p = r1
                r0 = r6
                r1 = r6
                long r1 = r1.l
                r0.q = r1
                r0 = r6
                r1 = 0
                r0.r = r1
                r0 = r6
                r1 = 1
                r0.o = r1
            L53:
                r0 = r6
                boolean r0 = r0.r
                r12 = r0
                r0 = r6
                int r0 = r0.i
                r11 = r0
                r0 = r11
                r1 = 5
                if (r0 == r1) goto L85
                r0 = r10
                r9 = r0
                r0 = r6
                boolean r0 = r0.b
                if (r0 == 0) goto L87
                r0 = r10
                r9 = r0
                r0 = r11
                r1 = 1
                if (r0 != r1) goto L87
                r0 = r10
                r9 = r0
                r0 = r6
                com.opos.exoplayer.core.c.f.j$a$a r0 = r0.n
                boolean r0 = r0.b()
                if (r0 == 0) goto L87
            L85:
                r0 = 1
                r9 = r0
            L87:
                r0 = r6
                r1 = r12
                r2 = r9
                r1 = r1 | r2
                r0.r = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.j.a.a(long, int):void");
        }

        public void a(long j, int i, long j2) {
            this.i = i;
            this.l = j2;
            this.j = j;
            if (!this.b || i != 1) {
                if (!this.f25203c) {
                    return;
                }
                int i2 = this.i;
                if (i2 != 5 && i2 != 1 && i2 != 2) {
                    return;
                }
            }
            C0654a c0654a = this.m;
            this.m = this.n;
            this.n = c0654a;
            c0654a.a();
            this.h = 0;
            this.k = true;
        }

        public void a(k.a aVar) {
            this.e.append(aVar.f25490a, aVar);
        }

        public void a(k.b bVar) {
            this.d.append(bVar.f25492a, bVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x0185  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x018b  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0193  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x01a9  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x01b4  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x01f4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(byte[] r17, int r18, int r19) {
            /*
                Method dump skipped, instructions count: 628
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.j.a.a(byte[], int, int):void");
        }

        public boolean a() {
            return this.f25203c;
        }

        public void b() {
            this.k = false;
            this.o = false;
            this.n.a();
        }
    }

    public j(w wVar, boolean z, boolean z2) {
        this.f25200a = wVar;
        this.b = z;
        this.f25201c = z2;
    }

    private void a(long j, int i, int i2, long j2) {
        v vVar;
        if (!this.l || this.k.a()) {
            this.d.b(i2);
            this.e.b(i2);
            if (this.l) {
                if (this.d.b()) {
                    this.k.a(com.opos.exoplayer.core.i.k.a(this.d.f25237a, 3, this.d.b));
                    vVar = this.d;
                } else if (this.e.b()) {
                    this.k.a(com.opos.exoplayer.core.i.k.b(this.e.f25237a, 3, this.e.b));
                    vVar = this.e;
                }
            } else if (this.d.b() && this.e.b()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Arrays.copyOf(this.d.f25237a, this.d.b));
                arrayList.add(Arrays.copyOf(this.e.f25237a, this.e.b));
                k.b a2 = com.opos.exoplayer.core.i.k.a(this.d.f25237a, 3, this.d.b);
                k.a b = com.opos.exoplayer.core.i.k.b(this.e.f25237a, 3, this.e.b);
                this.j.a(Format.a(this.i, "video/avc", (String) null, -1, -1, a2.b, a2.f25493c, -1.0f, arrayList, -1, a2.d, (DrmInitData) null));
                this.l = true;
                this.k.a(a2);
                this.k.a(b);
                this.d.a();
                vVar = this.e;
            }
            vVar.a();
        }
        if (this.f.b(i2)) {
            this.n.a(this.f.f25237a, com.opos.exoplayer.core.i.k.a(this.f.f25237a, this.f.b));
            this.n.c(4);
            this.f25200a.a(j2, this.n);
        }
        this.k.a(j, i);
    }

    private void a(long j, int i, long j2) {
        if (!this.l || this.k.a()) {
            this.d.a(i);
            this.e.a(i);
        }
        this.f.a(i);
        this.k.a(j, i, j2);
    }

    private void a(byte[] bArr, int i, int i2) {
        if (!this.l || this.k.a()) {
            this.d.a(bArr, i, i2);
            this.e.a(bArr, i, i2);
        }
        this.f.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        com.opos.exoplayer.core.i.k.a(this.h);
        this.d.a();
        this.e.a();
        this.f.a();
        this.k.b();
        this.g = 0L;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j, boolean z) {
        this.m = j;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.i = dVar.c();
        com.opos.exoplayer.core.c.n a2 = gVar.a(dVar.b(), 2);
        this.j = a2;
        this.k = new a(a2, this.b, this.f25201c);
        this.f25200a.a(gVar, dVar);
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        int d = mVar.d();
        int c2 = mVar.c();
        byte[] bArr = mVar.f25496a;
        this.g += mVar.b();
        this.j.a(mVar, mVar.b());
        while (true) {
            int a2 = com.opos.exoplayer.core.i.k.a(bArr, d, c2, this.h);
            if (a2 == c2) {
                a(bArr, d, c2);
                return;
            }
            int b = com.opos.exoplayer.core.i.k.b(bArr, a2);
            int i = a2 - d;
            if (i > 0) {
                a(bArr, d, a2);
            }
            int i2 = c2 - a2;
            long j = this.g - i2;
            a(j, i2, i < 0 ? -i : 0, this.m);
            a(j, b, this.m);
            d = a2 + 3;
        }
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
