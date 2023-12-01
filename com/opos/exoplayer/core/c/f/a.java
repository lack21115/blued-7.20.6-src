package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.c.l;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/a.class */
public final class a implements com.opos.exoplayer.core.c.e {

    /* renamed from: a  reason: collision with root package name */
    public static final com.opos.exoplayer.core.c.h f25183a = new com.opos.exoplayer.core.c.h() { // from class: com.opos.exoplayer.core.c.f.a.1
        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new a()};
        }
    };
    private static final int b = com.opos.exoplayer.core.i.u.f("ID3");

    /* renamed from: c  reason: collision with root package name */
    private final long f25184c;
    private final b d;
    private final com.opos.exoplayer.core.i.m e;
    private boolean f;

    public a() {
        this(0L);
    }

    public a(long j) {
        this.f25184c = j;
        this.d = new b();
        this.e = new com.opos.exoplayer.core.i.m(2786);
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        int a2 = fVar.a(this.e.f25496a, 0, 2786);
        if (a2 == -1) {
            return -1;
        }
        this.e.c(0);
        this.e.b(a2);
        if (!this.f) {
            this.d.a(this.f25184c, true);
            this.f = true;
        }
        this.d.a(this.e);
        return 0;
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        this.f = false;
        this.d.a();
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.d.a(gVar, new u.d(0, 1));
        gVar.a();
        gVar.a(new l.b(com.anythink.expressad.exoplayer.b.b));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x006c, code lost:
        if ((r8 - r7) < 8192) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x006f, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x005c, code lost:
        r6.a();
        r8 = r8 + 1;
     */
    @Override // com.opos.exoplayer.core.c.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.opos.exoplayer.core.c.f r6) {
        /*
            r5 = this;
            com.opos.exoplayer.core.i.m r0 = new com.opos.exoplayer.core.i.m
            r1 = r0
            r2 = 10
            r1.<init>(r2)
            r11 = r0
            r0 = 0
            r7 = r0
        Ld:
            r0 = r6
            r1 = r11
            byte[] r1 = r1.f25496a
            r2 = 0
            r3 = 10
            r0.c(r1, r2, r3)
            r0 = r11
            r1 = 0
            r0.c(r1)
            r0 = r11
            int r0 = r0.k()
            int r1 = com.opos.exoplayer.core.c.f.a.b
            if (r0 == r1) goto La8
            r0 = r6
            r0.a()
            r0 = r6
            r1 = r7
            r0.c(r1)
            r0 = r7
            r8 = r0
        L3b:
            r0 = 0
            r9 = r0
        L3e:
            r0 = r6
            r1 = r11
            byte[] r1 = r1.f25496a
            r2 = 0
            r3 = 5
            r0.c(r1, r2, r3)
            r0 = r11
            r1 = 0
            r0.c(r1)
            r0 = r11
            int r0 = r0.h()
            r1 = 2935(0xb77, float:4.113E-42)
            if (r0 == r1) goto L7b
            r0 = r6
            r0.a()
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            r0 = r8
            r1 = r7
            int r0 = r0 - r1
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r0 < r1) goto L71
            r0 = 0
            return r0
        L71:
            r0 = r6
            r1 = r8
            r0.c(r1)
            goto L3b
        L7b:
            r0 = r9
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            r0 = r9
            r1 = 4
            if (r0 < r1) goto L89
            r0 = 1
            return r0
        L89:
            r0 = r11
            byte[] r0 = r0.f25496a
            int r0 = com.opos.exoplayer.core.a.a.a(r0)
            r10 = r0
            r0 = r10
            r1 = -1
            if (r0 == r1) goto La6
            r0 = r6
            r1 = r10
            r2 = 5
            int r1 = r1 - r2
            r0.c(r1)
            goto L3e
        La6:
            r0 = 0
            return r0
        La8:
            r0 = r11
            r1 = 3
            r0.d(r1)
            r0 = r11
            int r0 = r0.t()
            r8 = r0
            r0 = r7
            r1 = r8
            r2 = 10
            int r1 = r1 + r2
            int r0 = r0 + r1
            r7 = r0
            r0 = r6
            r1 = r8
            r0.c(r1)
            goto Ld
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.a.a(com.opos.exoplayer.core.c.f):boolean");
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
