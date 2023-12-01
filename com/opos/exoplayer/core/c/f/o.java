package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.c.f.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/o.class */
public final class o implements u {

    /* renamed from: a  reason: collision with root package name */
    private final h f25216a;
    private final com.opos.exoplayer.core.i.l b = new com.opos.exoplayer.core.i.l(new byte[10]);

    /* renamed from: c  reason: collision with root package name */
    private int f25217c = 0;
    private int d;
    private com.opos.exoplayer.core.i.s e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private long l;

    public o(h hVar) {
        this.f25216a = hVar;
    }

    private void a(int i) {
        this.f25217c = i;
        this.d = 0;
    }

    private boolean a(com.opos.exoplayer.core.i.m mVar, byte[] bArr, int i) {
        int min = Math.min(mVar.b(), i - this.d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            mVar.d(min);
        } else {
            mVar.a(bArr, this.d, min);
        }
        int i2 = min + this.d;
        this.d = i2;
        return i2 == i;
    }

    private boolean b() {
        this.b.a(0);
        int c2 = this.b.c(24);
        if (c2 != 1) {
            com.opos.cmn.an.f.a.c("PesReader", "Unexpected start code prefix: " + c2);
            this.j = -1;
            return false;
        }
        this.b.b(8);
        int c3 = this.b.c(16);
        this.b.b(5);
        this.k = this.b.e();
        this.b.b(2);
        this.f = this.b.e();
        this.g = this.b.e();
        this.b.b(6);
        int c4 = this.b.c(8);
        this.i = c4;
        if (c3 == 0) {
            this.j = -1;
            return true;
        }
        this.j = ((c3 + 6) - 9) - c4;
        return true;
    }

    private void c() {
        this.b.a(0);
        this.l = com.anythink.expressad.exoplayer.b.b;
        if (this.f) {
            this.b.b(4);
            long c2 = this.b.c(3);
            this.b.b(1);
            long c3 = this.b.c(15) << 15;
            this.b.b(1);
            long c4 = this.b.c(15);
            this.b.b(1);
            if (!this.h && this.g) {
                this.b.b(4);
                long c5 = this.b.c(3);
                this.b.b(1);
                long c6 = this.b.c(15) << 15;
                this.b.b(1);
                long c7 = this.b.c(15);
                this.b.b(1);
                this.e.b((c5 << 30) | c6 | c7);
                this.h = true;
            }
            this.l = this.e.b((c2 << 30) | c3 | c4);
        }
    }

    @Override // com.opos.exoplayer.core.c.f.u
    public final void a() {
        this.f25217c = 0;
        this.d = 0;
        this.h = false;
        this.f25216a.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00d8 -> B:36:0x00db). Please submit an issue!!! */
    @Override // com.opos.exoplayer.core.c.f.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.opos.exoplayer.core.i.m r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.o.a(com.opos.exoplayer.core.i.m, boolean):void");
    }

    @Override // com.opos.exoplayer.core.c.f.u
    public void a(com.opos.exoplayer.core.i.s sVar, com.opos.exoplayer.core.c.g gVar, u.d dVar) {
        this.e = sVar;
        this.f25216a.a(gVar, dVar);
    }
}
