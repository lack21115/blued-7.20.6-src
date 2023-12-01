package com.anythink.expressad.exoplayer.b;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.anythink.expressad.exoplayer.b.g;
import com.anythink.expressad.exoplayer.b.h;
import com.anythink.expressad.exoplayer.k.ad;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.v;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/r.class */
public abstract class r extends com.anythink.expressad.exoplayer.a implements com.anythink.expressad.exoplayer.k.n {
    private static final int n = 0;
    private static final int o = 1;
    private static final int p = 2;
    private com.anythink.expressad.exoplayer.c.g<com.anythink.expressad.exoplayer.c.e, ? extends com.anythink.expressad.exoplayer.c.h, ? extends e> A;
    private com.anythink.expressad.exoplayer.c.e B;
    private com.anythink.expressad.exoplayer.c.h C;
    private com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> D;
    private com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> E;
    private int F;
    private boolean G;
    private boolean H;
    private long I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private final com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.i> q;
    private final boolean r;
    private final g.a s;
    private final h t;
    private final com.anythink.expressad.exoplayer.n u;
    private final com.anythink.expressad.exoplayer.c.e v;
    private com.anythink.expressad.exoplayer.c.d w;
    private com.anythink.expressad.exoplayer.m x;
    private int y;
    private int z;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/r$a.class */
    final class a implements h.c {
        private a() {
        }

        /* synthetic */ a(r rVar, byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a() {
            r.b(r.this);
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a(int i) {
            r.this.s.a(i);
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a(int i, long j, long j2) {
            r.this.s.a(i, j, j2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/r$b.class */
    @interface b {
    }

    public r() {
        this((Handler) null, (g) null, new f[0]);
    }

    private r(Handler handler, g gVar, c cVar) {
        this(handler, gVar, cVar, null, new f[0]);
    }

    private r(Handler handler, g gVar, c cVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.i> gVar2, f... fVarArr) {
        this(handler, gVar, gVar2, new l(cVar, fVarArr));
    }

    private r(Handler handler, g gVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.i> gVar2, h hVar) {
        super(1);
        this.q = gVar2;
        this.r = false;
        this.s = new g.a(handler, gVar);
        this.t = hVar;
        hVar.a(new a(this, (byte) 0));
        this.u = new com.anythink.expressad.exoplayer.n();
        this.v = com.anythink.expressad.exoplayer.c.e.e();
        this.F = 0;
        this.H = true;
    }

    private r(Handler handler, g gVar, f... fVarArr) {
        this(handler, gVar, null, null, fVarArr);
    }

    private static void A() {
    }

    private com.anythink.expressad.exoplayer.m B() {
        return com.anythink.expressad.exoplayer.m.a((String) null, "audio/raw", (String) null, -1, this.x.u, this.x.v, 2, (List<byte[]>) null, (com.anythink.expressad.exoplayer.d.e) null, (String) null);
    }

    private boolean C() {
        if (this.C == null) {
            com.anythink.expressad.exoplayer.c.h c2 = this.A.c();
            this.C = c2;
            if (c2 == null) {
                return false;
            }
            this.w.f += this.C.b;
        }
        if (this.C.c()) {
            if (this.F == 2) {
                H();
                G();
                this.H = true;
                return false;
            }
            this.C.e();
            this.C = null;
            E();
            return false;
        }
        if (this.H) {
            com.anythink.expressad.exoplayer.m a2 = com.anythink.expressad.exoplayer.m.a((String) null, "audio/raw", (String) null, -1, this.x.u, this.x.v, 2, (List<byte[]>) null, (com.anythink.expressad.exoplayer.d.e) null, (String) null);
            this.t.a(a2.w, a2.u, a2.v, null, this.y, this.z);
            this.H = false;
        }
        if (this.t.a(this.C.f4393c, this.C.f4389a)) {
            this.w.e++;
            this.C.e();
            this.C = null;
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0101 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean D() {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.b.r.D():boolean");
    }

    private void E() {
        this.M = true;
        try {
            this.t.c();
        } catch (h.d e) {
            throw com.anythink.expressad.exoplayer.g.a(e, s());
        }
    }

    private void F() {
        this.N = false;
        if (this.F != 0) {
            H();
            G();
            return;
        }
        this.B = null;
        com.anythink.expressad.exoplayer.c.h hVar = this.C;
        if (hVar != null) {
            hVar.e();
            this.C = null;
        }
        this.A.d();
        this.G = false;
    }

    private void G() {
        if (this.A != null) {
            return;
        }
        com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> fVar = this.E;
        this.D = fVar;
        if (fVar != null && fVar.g() == null && this.D.f() == null) {
            return;
        }
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ad.a("createAudioDecoder");
            this.A = x();
            ad.a();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            this.s.a(this.A.a(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
            this.w.f4385a++;
        } catch (e e) {
            throw com.anythink.expressad.exoplayer.g.a(e, s());
        }
    }

    private void H() {
        com.anythink.expressad.exoplayer.c.g<com.anythink.expressad.exoplayer.c.e, ? extends com.anythink.expressad.exoplayer.c.h, ? extends e> gVar = this.A;
        if (gVar == null) {
            return;
        }
        this.B = null;
        this.C = null;
        gVar.e();
        this.A = null;
        this.w.b++;
        this.F = 0;
        this.G = false;
    }

    private void I() {
        long a2 = this.t.a(v());
        if (a2 != Long.MIN_VALUE) {
            if (!this.K) {
                a2 = Math.max(this.I, a2);
            }
            this.I = a2;
            this.K = false;
        }
    }

    private void a(com.anythink.expressad.exoplayer.c.e eVar) {
        if (!this.J || eVar.b()) {
            return;
        }
        if (Math.abs(eVar.f - this.I) > 500000) {
            this.I = eVar.f;
        }
        this.J = false;
    }

    private void b(com.anythink.expressad.exoplayer.m mVar) {
        com.anythink.expressad.exoplayer.m mVar2 = this.x;
        this.x = mVar;
        if (!af.a(mVar.k, mVar2 == null ? null : mVar2.k)) {
            if (this.x.k != null) {
                com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.i> gVar = this.q;
                if (gVar == null) {
                    throw com.anythink.expressad.exoplayer.g.a(new IllegalStateException("Media requires a DrmSessionManager"), s());
                }
                com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> a2 = gVar.a(Looper.myLooper(), this.x.k);
                this.E = a2;
                if (a2 == this.D) {
                    this.q.a(a2);
                }
            } else {
                this.E = null;
            }
        }
        if (this.G) {
            this.F = 1;
        } else {
            H();
            G();
            this.H = true;
        }
        this.y = mVar.x;
        this.z = mVar.y;
        this.s.a(mVar);
    }

    private boolean b(int i) {
        return this.t.a(i);
    }

    static /* synthetic */ boolean b(r rVar) {
        rVar.K = true;
        return true;
    }

    private boolean b(boolean z) {
        if (this.D != null) {
            if (z || !this.r) {
                int e = this.D.e();
                if (e != 1) {
                    return e != 4;
                }
                throw com.anythink.expressad.exoplayer.g.a(this.D.f(), s());
            }
            return false;
        }
        return false;
    }

    private static void y() {
    }

    private static void z() {
    }

    @Override // com.anythink.expressad.exoplayer.z
    public final int a(com.anythink.expressad.exoplayer.m mVar) {
        int w = w();
        if (w <= 2) {
            return w;
        }
        return w | (af.f4793a >= 21 ? 32 : 0) | 8;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final v a(v vVar) {
        return this.t.a(vVar);
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.x.b
    public final void a(int i, Object obj) {
        if (i == 2) {
            this.t.a(((Float) obj).floatValue());
        } else if (i != 3) {
            super.a(i, obj);
        } else {
            this.t.a((com.anythink.expressad.exoplayer.b.b) obj);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x019e, code lost:
        if (r0 == null) goto L93;
     */
    /* JADX WARN: Removed duplicated region for block: B:87:0x027e A[Catch: d -> 0x02ef, b -> 0x02f4, a -> 0x02f9, e | a | b | d -> 0x02fe, TRY_ENTER, TryCatch #3 {e | a | b | d -> 0x02fe, blocks: (B:20:0x0075, B:22:0x007c, B:24:0x0082, B:26:0x0099, B:42:0x016d, B:44:0x0174, B:46:0x017c, B:49:0x0186, B:51:0x018d, B:54:0x01a4, B:56:0x01ac, B:57:0x01cc, B:64:0x01f3, B:100:0x02eb, B:65:0x0201, B:67:0x020b, B:68:0x0223, B:72:0x0238, B:75:0x0242, B:84:0x0271, B:87:0x027e, B:89:0x0292, B:91:0x029a, B:93:0x02ae, B:95:0x02b8, B:97:0x02bd, B:81:0x025f, B:82:0x026f, B:61:0x01da, B:28:0x00b2, B:30:0x00bb, B:32:0x00c3, B:33:0x00d3, B:34:0x00e6, B:36:0x00ed, B:38:0x0130, B:40:0x0149), top: B:124:0x0075 }] */
    @Override // com.anythink.expressad.exoplayer.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(long r12, long r14) {
        /*
            Method dump skipped, instructions count: 818
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.b.r.a(long, long):void");
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void a(long j, boolean z) {
        this.t.i();
        this.I = j;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = false;
        if (this.A != null) {
            this.N = false;
            if (this.F != 0) {
                H();
                G();
                return;
            }
            this.B = null;
            com.anythink.expressad.exoplayer.c.h hVar = this.C;
            if (hVar != null) {
                hVar.e();
                this.C = null;
            }
            this.A.d();
            this.G = false;
        }
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void a(boolean z) {
        com.anythink.expressad.exoplayer.c.d dVar = new com.anythink.expressad.exoplayer.c.d();
        this.w = dVar;
        this.s.a(dVar);
        int i = r().b;
        if (i != 0) {
            this.t.c(i);
        } else {
            this.t.g();
        }
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.y
    public final com.anythink.expressad.exoplayer.k.n c() {
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final long d() {
        if (a_() == 2) {
            I();
        }
        return this.I;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final v e() {
        return this.t.f();
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void n() {
        this.t.a();
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void o() {
        I();
        this.t.h();
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void p() {
        this.x = null;
        this.H = true;
        this.N = false;
        try {
            H();
            this.t.j();
            try {
                if (this.D != null) {
                    this.q.a(this.D);
                }
                try {
                    if (this.E != null && this.E != this.D) {
                        this.q.a(this.E);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.E != null && this.E != this.D) {
                        this.q.a(this.E);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.D != null) {
                    this.q.a(this.D);
                }
                try {
                    if (this.E != null && this.E != this.D) {
                        this.q.a(this.E);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.E != null && this.E != this.D) {
                        this.q.a(this.E);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean u() {
        if (this.t.e()) {
            return true;
        }
        if (this.x == null || this.N) {
            return false;
        }
        return t() || this.C != null;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean v() {
        return this.M && this.t.d();
    }

    protected abstract int w();

    protected abstract com.anythink.expressad.exoplayer.c.g<com.anythink.expressad.exoplayer.c.e, ? extends com.anythink.expressad.exoplayer.c.h, ? extends e> x();
}
