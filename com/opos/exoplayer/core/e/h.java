package com.opos.exoplayer.core.e;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.e.g;
import java.io.EOFException;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/h.class */
public final class h implements com.opos.exoplayer.core.c.n {

    /* renamed from: a  reason: collision with root package name */
    private final com.opos.exoplayer.core.h.b f25304a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final g f25305c = new g();
    private final g.a d = new g.a();
    private final com.opos.exoplayer.core.i.m e = new com.opos.exoplayer.core.i.m(32);
    private b f;
    private b g;
    private b h;
    private Format i;
    private boolean j;
    private Format k;
    private long l;
    private long m;
    private boolean n;
    private a o;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/h$a.class */
    public interface a {
        void a(Format format);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/h$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f25306a;
        public final long b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f25307c;
        public com.opos.exoplayer.core.h.a d;
        public b e;

        public b(long j, int i) {
            this.f25306a = j;
            this.b = i + j;
        }

        public int a(long j) {
            return ((int) (j - this.f25306a)) + this.d.b;
        }

        public b a() {
            this.d = null;
            b bVar = this.e;
            this.e = null;
            return bVar;
        }

        public void a(com.opos.exoplayer.core.h.a aVar, b bVar) {
            this.d = aVar;
            this.e = bVar;
            this.f25307c = true;
        }
    }

    public h(com.opos.exoplayer.core.h.b bVar) {
        this.f25304a = bVar;
        this.b = bVar.c();
        b bVar2 = new b(0L, this.b);
        this.f = bVar2;
        this.g = bVar2;
        this.h = bVar2;
    }

    private int a(int i) {
        if (!this.h.f25307c) {
            this.h.a(this.f25304a.a(), new b(this.h.b, this.b));
        }
        return Math.min(i, (int) (this.h.b - this.m));
    }

    private static Format a(Format format, long j) {
        if (format == null) {
            return null;
        }
        Format format2 = format;
        if (j != 0) {
            format2 = format;
            if (format.w != Long.MAX_VALUE) {
                format2 = format.a(format.w + j);
            }
        }
        return format2;
    }

    private void a(long j) {
        while (j >= this.g.b) {
            this.g = this.g.e;
        }
    }

    private void a(long j, ByteBuffer byteBuffer, int i) {
        a(j);
        while (i > 0) {
            int min = Math.min(i, (int) (this.g.b - j));
            byteBuffer.put(this.g.d.f25441a, this.g.a(j), min);
            int i2 = i - min;
            long j2 = j + min;
            j = j2;
            i = i2;
            if (j2 == this.g.b) {
                this.g = this.g.e;
                j = j2;
                i = i2;
            }
        }
    }

    private void a(long j, byte[] bArr, int i) {
        a(j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.g.b - j));
            System.arraycopy((Object) this.g.d.f25441a, this.g.a(j), (Object) bArr, i - i2, min);
            int i3 = i2 - min;
            long j2 = j + min;
            i2 = i3;
            j = j2;
            if (j2 == this.g.b) {
                this.g = this.g.e;
                i2 = i3;
                j = j2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00bf, code lost:
        if (r0.length < r14) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00df, code lost:
        if (r0.length < r14) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.opos.exoplayer.core.b.e r11, com.opos.exoplayer.core.e.g.a r12) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.e.h.a(com.opos.exoplayer.core.b.e, com.opos.exoplayer.core.e.g$a):void");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private void a(b bVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void b(int i) {
        long j = this.m + i;
        this.m = j;
        if (j == this.h.b) {
            this.h = this.h.e;
        }
    }

    private void b(long j) {
        if (j == -1) {
            return;
        }
        while (j >= this.f.b) {
            this.f25304a.a(this.f.d);
            this.f = this.f.a();
        }
        if (this.g.f25306a < this.f.f25306a) {
            this.g = this.f;
        }
    }

    @Override // com.opos.exoplayer.core.c.n
    public int a(com.opos.exoplayer.core.c.f fVar, int i, boolean z) {
        int a2 = fVar.a(this.h.d.f25441a, this.h.a(this.m), a(i));
        if (a2 != -1) {
            b(a2);
            return a2;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public int a(com.opos.exoplayer.core.l lVar, com.opos.exoplayer.core.b.e eVar, boolean z, boolean z2, long j) {
        int a2 = this.f25305c.a(lVar, eVar, z, z2, this.i, this.d);
        if (a2 == -5) {
            this.i = lVar.f25515a;
            return -5;
        } else if (a2 != -4) {
            if (a2 == -3) {
                return -3;
            }
            throw new IllegalStateException();
        } else if (eVar.c()) {
            return -4;
        } else {
            if (eVar.f25074c < j) {
                eVar.b(Integer.MIN_VALUE);
            }
            if (eVar.g()) {
                a(eVar, this.d);
            }
            eVar.e(this.d.f25302a);
            a(this.d.b, eVar.b, this.d.f25302a);
            return -4;
        }
    }

    public void a() {
        a(false);
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(long j, int i, int i2, int i3, n.a aVar) {
        if (this.j) {
            a(this.k);
        }
        if (this.n) {
            if ((i & 1) == 0 || !this.f25305c.b(j)) {
                return;
            }
            this.n = false;
        }
        this.f25305c.a(j + this.l, i, (this.m - i2) - i3, i2, aVar);
    }

    public void a(long j, boolean z, boolean z2) {
        b(this.f25305c.b(j, z, z2));
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(Format format) {
        Format a2 = a(format, this.l);
        boolean a3 = this.f25305c.a(a2);
        this.k = format;
        this.j = false;
        a aVar = this.o;
        if (aVar == null || !a3) {
            return;
        }
        aVar.a(a2);
    }

    public void a(a aVar) {
        this.o = aVar;
    }

    @Override // com.opos.exoplayer.core.c.n
    public void a(com.opos.exoplayer.core.i.m mVar, int i) {
        while (i > 0) {
            int a2 = a(i);
            mVar.a(this.h.d.f25441a, this.h.a(this.m), a2);
            i -= a2;
            b(a2);
        }
    }

    public void a(boolean z) {
        this.f25305c.a(z);
        a(this.f);
        b bVar = new b(0L, this.b);
        this.f = bVar;
        this.g = bVar;
        this.h = bVar;
        this.m = 0L;
        this.f25304a.b();
    }

    public int b() {
        return this.f25305c.a();
    }

    public int b(long j, boolean z, boolean z2) {
        return this.f25305c.a(j, z, z2);
    }

    public boolean c() {
        return this.f25305c.c();
    }

    public int d() {
        return this.f25305c.b();
    }

    public Format e() {
        return this.f25305c.d();
    }

    public long f() {
        return this.f25305c.e();
    }

    public void g() {
        this.f25305c.f();
        this.g = this.f;
    }

    public void h() {
        b(this.f25305c.h());
    }

    public int i() {
        return this.f25305c.g();
    }
}
