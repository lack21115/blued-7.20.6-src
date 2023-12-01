package com.opos.exoplayer.core.c.f;

import com.opos.exoplayer.core.c.f.u;
import com.opos.exoplayer.core.c.l;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/f/c.class */
public final class c implements com.opos.exoplayer.core.c.e {

    /* renamed from: a  reason: collision with root package name */
    public static final com.opos.exoplayer.core.c.h f25187a = new com.opos.exoplayer.core.c.h() { // from class: com.opos.exoplayer.core.c.f.c.1
        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new c()};
        }
    };
    private static final int b = com.opos.exoplayer.core.i.u.f("ID3");

    /* renamed from: c  reason: collision with root package name */
    private final long f25188c;
    private final d d;
    private final com.opos.exoplayer.core.i.m e;
    private boolean f;

    public c() {
        this(0L);
    }

    public c(long j) {
        this.f25188c = j;
        this.d = new d(true);
        this.e = new com.opos.exoplayer.core.i.m(200);
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        int a2 = fVar.a(this.e.f25496a, 0, 200);
        if (a2 == -1) {
            return -1;
        }
        this.e.c(0);
        this.e.b(a2);
        if (!this.f) {
            this.d.a(this.f25188c, true);
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

    /* JADX WARN: Code restructure failed: missing block: B:10:0x007f, code lost:
        if ((r8 - r7) < 8192) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0082, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x006f, code lost:
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
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.f.c.a(com.opos.exoplayer.core.c.f):boolean");
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
