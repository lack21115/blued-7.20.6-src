package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.c.f.u;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/i.class */
public final class i implements h {

    /* renamed from: c  reason: collision with root package name */
    private static final double[] f25196c = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a  reason: collision with root package name */
    private String f25197a;
    private com.opos.exoplayer.core.c.n b;
    private boolean d;
    private long e;
    private final boolean[] f = new boolean[4];
    private final a g = new a(128);
    private long h;
    private boolean i;
    private long j;
    private long k;
    private long l;
    private boolean m;
    private boolean n;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/i$a.class */
    static final class a {
        private static final byte[] d = {0, 0, 1};

        /* renamed from: a  reason: collision with root package name */
        public int f25198a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f25199c;
        private boolean e;

        public a(int i) {
            this.f25199c = new byte[i];
        }

        public void a() {
            this.e = false;
            this.f25198a = 0;
            this.b = 0;
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.e) {
                int i3 = i2 - i;
                byte[] bArr2 = this.f25199c;
                int length = bArr2.length;
                int i4 = this.f25198a;
                if (length < i4 + i3) {
                    this.f25199c = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy((Object) bArr, i, (Object) this.f25199c, this.f25198a, i3);
                this.f25198a = i3 + this.f25198a;
            }
        }

        public boolean a(int i, int i2) {
            if (this.e) {
                int i3 = this.f25198a - i2;
                this.f25198a = i3;
                if (this.b != 0 || i != 181) {
                    this.e = false;
                    return true;
                }
                this.b = i3;
            } else if (i == 179) {
                this.e = true;
            }
            byte[] bArr = d;
            a(bArr, 0, bArr.length);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.util.Pair<com.opos.exoplayer.core.Format, java.lang.Long> a(com.opos.exoplayer.core.c.f.i.a r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.i.a(com.opos.exoplayer.core.c.f.i$a, java.lang.String):android.util.Pair");
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a() {
        com.opos.exoplayer.core.i.k.a(this.f);
        this.g.a();
        this.h = 0L;
        this.i = false;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(long j, boolean z) {
        this.j = j;
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        dVar.a();
        this.f25197a = dVar.c();
        this.b = gVar.a(dVar.b(), 2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.opos.exoplayer.core.c.f.h
    public void a(com.opos.exoplayer.core.i.m mVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.opos.exoplayer.core.c.f.h
    public void b() {
    }
}
