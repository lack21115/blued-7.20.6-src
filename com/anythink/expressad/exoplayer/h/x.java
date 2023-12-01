package com.anythink.expressad.exoplayer.h;

import com.anythink.expressad.exoplayer.e.m;
import com.anythink.expressad.exoplayer.h.w;
import java.io.EOFException;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/x.class */
public final class x implements com.anythink.expressad.exoplayer.e.m {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7517a = -1;
    private static final int b = 32;

    /* renamed from: c  reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.j.b f7518c;
    private final int d;
    private final w e = new w();
    private final w.a f = new w.a();
    private final com.anythink.expressad.exoplayer.k.s g = new com.anythink.expressad.exoplayer.k.s(32);
    private a h;
    private a i;
    private a j;
    private com.anythink.expressad.exoplayer.m k;
    private boolean l;
    private com.anythink.expressad.exoplayer.m m;
    private long n;
    private long o;
    private boolean p;
    private b q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/x$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f7519a;
        public final long b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7520c;
        public com.anythink.expressad.exoplayer.j.a d;
        public a e;

        public a(long j, int i) {
            this.f7519a = j;
            this.b = j + i;
        }

        public final int a(long j) {
            return ((int) (j - this.f7519a)) + this.d.b;
        }

        public final a a() {
            this.d = null;
            a aVar = this.e;
            this.e = null;
            return aVar;
        }

        public final void a(com.anythink.expressad.exoplayer.j.a aVar, a aVar2) {
            this.d = aVar;
            this.e = aVar2;
            this.f7520c = true;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/x$b.class */
    public interface b {
        void i();
    }

    public x(com.anythink.expressad.exoplayer.j.b bVar) {
        this.f7518c = bVar;
        this.d = bVar.d();
        a aVar = new a(0L, this.d);
        this.h = aVar;
        this.i = aVar;
        this.j = aVar;
    }

    private static com.anythink.expressad.exoplayer.m a(com.anythink.expressad.exoplayer.m mVar, long j) {
        if (mVar == null) {
            return null;
        }
        com.anythink.expressad.exoplayer.m mVar2 = mVar;
        if (j != 0) {
            mVar2 = mVar;
            if (mVar.l != Long.MAX_VALUE) {
                mVar2 = mVar.a(mVar.l + j);
            }
        }
        return mVar2;
    }

    private void a(long j, ByteBuffer byteBuffer, int i) {
        b(j);
        while (i > 0) {
            int min = Math.min(i, (int) (this.i.b - j));
            byteBuffer.put(this.i.d.f7550a, this.i.a(j), min);
            int i2 = i - min;
            long j2 = j + min;
            j = j2;
            i = i2;
            if (j2 == this.i.b) {
                this.i = this.i.e;
                j = j2;
                i = i2;
            }
        }
    }

    private void a(long j, byte[] bArr, int i) {
        b(j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.i.b - j));
            System.arraycopy((Object) this.i.d.f7550a, this.i.a(j), (Object) bArr, i - i2, min);
            int i3 = i2 - min;
            long j2 = j + min;
            i2 = i3;
            j = j2;
            if (j2 == this.i.b) {
                this.i = this.i.e;
                i2 = i3;
                j = j2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00bf, code lost:
        if (r0.length < r14) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00df, code lost:
        if (r0.length < r14) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.anythink.expressad.exoplayer.c.e r11, com.anythink.expressad.exoplayer.h.w.a r12) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.x.a(com.anythink.expressad.exoplayer.c.e, com.anythink.expressad.exoplayer.h.w$a):void");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private void a(a aVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void b(long j) {
        while (j >= this.i.b) {
            this.i = this.i.e;
        }
    }

    private void c(int i) {
        this.e.b(i);
    }

    private void c(long j) {
        if (j == -1) {
            return;
        }
        while (j >= this.h.b) {
            this.f7518c.a(this.h.d);
            this.h = this.h.a();
        }
        if (this.i.f7519a < this.h.f7519a) {
            this.i = this.h;
        }
    }

    private int d(int i) {
        if (!this.j.f7520c) {
            this.j.a(this.f7518c.a(), new a(this.j.b, this.d));
        }
        return Math.min(i, (int) (this.j.b - this.o));
    }

    private void e(int i) {
        long j = this.o + i;
        this.o = j;
        if (j == this.j.b) {
            this.j = this.j.e;
        }
    }

    private void l() {
        this.e.a();
        a(this.h);
        a aVar = new a(0L, this.d);
        this.h = aVar;
        this.i = aVar;
        this.j = aVar;
        this.o = 0L;
        this.f7518c.b();
    }

    private void m() {
        this.p = true;
    }

    private int n() {
        return this.e.e();
    }

    private void o() {
        c(this.e.l());
    }

    public final int a(long j, boolean z) {
        return this.e.a(j, z);
    }

    @Override // com.anythink.expressad.exoplayer.e.m
    public final int a(com.anythink.expressad.exoplayer.e.f fVar, int i, boolean z) {
        int a2 = fVar.a(this.j.d.f7550a, this.j.a(this.o), d(i));
        if (a2 != -1) {
            e(a2);
            return a2;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x011a, code lost:
        if (r0.length < r18) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0139, code lost:
        if (r0.length < r18) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(com.anythink.expressad.exoplayer.n r11, com.anythink.expressad.exoplayer.c.e r12, boolean r13, boolean r14, long r15) {
        /*
            Method dump skipped, instructions count: 689
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.x.a(com.anythink.expressad.exoplayer.n, com.anythink.expressad.exoplayer.c.e, boolean, boolean, long):int");
    }

    public final void a() {
        this.e.a();
        a(this.h);
        a aVar = new a(0L, this.d);
        this.h = aVar;
        this.i = aVar;
        this.j = aVar;
        this.o = 0L;
        this.f7518c.b();
    }

    public final void a(int i) {
        a aVar;
        long a2 = this.e.a(i);
        this.o = a2;
        if (a2 == 0 || a2 == this.h.f7519a) {
            a(this.h);
            a aVar2 = new a(this.o, this.d);
            this.h = aVar2;
            this.i = aVar2;
            this.j = aVar2;
            return;
        }
        a aVar3 = this.h;
        while (true) {
            aVar = aVar3;
            if (this.o <= aVar.b) {
                break;
            }
            aVar3 = aVar.e;
        }
        a aVar4 = aVar.e;
        a(aVar4);
        aVar.e = new a(aVar.b, this.d);
        this.j = this.o == aVar.b ? aVar.e : aVar;
        if (this.i == aVar4) {
            this.i = aVar.e;
        }
    }

    public final void a(long j) {
        if (this.n != j) {
            this.n = j;
            this.l = true;
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.m
    public final void a(long j, int i, int i2, int i3, m.a aVar) {
        if (this.l) {
            a(this.m);
        }
        if (this.p) {
            if ((i & 1) == 0 || !this.e.a(j)) {
                return;
            }
            this.p = false;
        }
        this.e.a(j + this.n, i, (this.o - i2) - i3, i2, aVar);
    }

    public final void a(long j, boolean z, boolean z2) {
        c(this.e.a(j, z, z2));
    }

    public final void a(b bVar) {
        this.q = bVar;
    }

    @Override // com.anythink.expressad.exoplayer.e.m
    public final void a(com.anythink.expressad.exoplayer.k.s sVar, int i) {
        while (i > 0) {
            int d = d(i);
            sVar.a(this.j.d.f7550a, this.j.a(this.o), d);
            i -= d;
            e(d);
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.m
    public final void a(com.anythink.expressad.exoplayer.m mVar) {
        long j = this.n;
        boolean a2 = this.e.a(mVar == null ? null : (j == 0 || mVar.l == Long.MAX_VALUE) ? mVar : mVar.a(mVar.l + j));
        this.m = mVar;
        this.l = false;
        b bVar = this.q;
        if (bVar == null || !a2) {
            return;
        }
        bVar.i();
    }

    public final int b() {
        return this.e.b();
    }

    public final boolean b(int i) {
        return this.e.c(i);
    }

    public final boolean c() {
        return this.e.f();
    }

    public final int d() {
        return this.e.c();
    }

    public final int e() {
        return this.e.d();
    }

    public final com.anythink.expressad.exoplayer.m f() {
        return this.e.g();
    }

    public final long g() {
        return this.e.h();
    }

    public final long h() {
        return this.e.i();
    }

    public final void i() {
        this.e.j();
        this.i = this.h;
    }

    public final void j() {
        c(this.e.m());
    }

    public final int k() {
        return this.e.k();
    }
}
