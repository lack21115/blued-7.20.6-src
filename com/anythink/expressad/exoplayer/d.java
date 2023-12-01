package com.anythink.expressad.exoplayer;

import com.anythink.expressad.exoplayer.k.af;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d.class */
public final class d implements p {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7233a = 15000;
    public static final int b = 50000;

    /* renamed from: c  reason: collision with root package name */
    public static final int f7234c = 2500;
    public static final int d = 5000;
    public static final int e = -1;
    public static final boolean f = true;
    private final com.anythink.expressad.exoplayer.j.l g;
    private final long h;
    private final long i;
    private final long j;
    private final long k;
    private final int l;
    private final boolean m;
    private final com.anythink.expressad.exoplayer.k.v n;
    private int o;
    private boolean p;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private com.anythink.expressad.exoplayer.j.l f7235a = null;
        private int b = 15000;

        /* renamed from: c  reason: collision with root package name */
        private int f7236c = 50000;
        private int d = 2500;
        private int e = 5000;
        private int f = -1;
        private boolean g = true;
        private com.anythink.expressad.exoplayer.k.v h = null;

        private a a(int i) {
            this.f = i;
            return this;
        }

        private a a(int i, int i2, int i3, int i4) {
            this.b = i;
            this.f7236c = i2;
            this.d = i3;
            this.e = i4;
            return this;
        }

        private a a(com.anythink.expressad.exoplayer.j.l lVar) {
            this.f7235a = lVar;
            return this;
        }

        private a a(com.anythink.expressad.exoplayer.k.v vVar) {
            this.h = vVar;
            return this;
        }

        private a a(boolean z) {
            this.g = z;
            return this;
        }

        private d a() {
            if (this.f7235a == null) {
                this.f7235a = new com.anythink.expressad.exoplayer.j.l((byte) 0);
            }
            return new d(this.f7235a, this.b, this.f7236c, this.d, this.e, this.f, this.g, this.h);
        }
    }

    public d() {
        this(new com.anythink.expressad.exoplayer.j.l((byte) 0));
    }

    @Deprecated
    private d(com.anythink.expressad.exoplayer.j.l lVar) {
        this(lVar, (byte) 0);
    }

    @Deprecated
    private d(com.anythink.expressad.exoplayer.j.l lVar, byte b2) {
        this(lVar, 15000, 50000, 2500, 5000, -1, true, null);
    }

    @Deprecated
    public d(com.anythink.expressad.exoplayer.j.l lVar, int i, int i2, int i3, int i4, int i5, boolean z, com.anythink.expressad.exoplayer.k.v vVar) {
        a(i3, 0, "bufferForPlaybackMs", "0");
        a(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        a(i, i3, "minBufferMs", "bufferForPlaybackMs");
        a(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        a(i2, i, "maxBufferMs", "minBufferMs");
        this.g = lVar;
        this.h = i * 1000;
        this.i = i2 * 1000;
        this.j = i3 * 1000;
        this.k = i4 * 1000;
        this.l = i5;
        this.m = z;
        this.n = vVar;
    }

    private static void a(int i, int i2, String str, String str2) {
        boolean z = i >= i2;
        com.anythink.expressad.exoplayer.k.a.a(z, str + " cannot be less than " + str2);
    }

    private void a(boolean z) {
        this.o = 0;
        com.anythink.expressad.exoplayer.k.v vVar = this.n;
        if (vVar != null && this.p) {
            vVar.c();
        }
        this.p = false;
        if (z) {
            this.g.e();
        }
    }

    private static int b(y[] yVarArr, com.anythink.expressad.exoplayer.i.g gVar) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= yVarArr.length) {
                return i3;
            }
            int i4 = i3;
            if (gVar.a(i) != null) {
                i4 = i3 + af.g(yVarArr[i].a());
            }
            i++;
            i2 = i4;
        }
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final void a() {
        a(false);
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final void a(y[] yVarArr, com.anythink.expressad.exoplayer.i.g gVar) {
        int i = this.l;
        int i2 = i;
        if (i == -1) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                i2 = i4;
                if (i3 >= yVarArr.length) {
                    break;
                }
                int i5 = i2;
                if (gVar.a(i3) != null) {
                    i5 = i2 + af.g(yVarArr[i3].a());
                }
                i3++;
                i4 = i5;
            }
        }
        this.o = i2;
        this.g.a(i2);
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final boolean a(long j, float f2) {
        boolean z;
        boolean z2 = this.g.c() >= this.o;
        boolean z3 = this.p;
        long j2 = this.h;
        long j3 = j2;
        if (f2 > 1.0f) {
            j3 = Math.min(af.a(j2, f2), this.i);
        }
        if (j < j3) {
            boolean z4 = true;
            if (!this.m) {
                z4 = !z2;
            }
            this.p = z4;
        } else if (j > this.i || z2) {
            this.p = false;
        }
        com.anythink.expressad.exoplayer.k.v vVar = this.n;
        if (vVar != null && (z = this.p) != z3) {
            if (z) {
                vVar.a();
            } else {
                vVar.c();
            }
        }
        return this.p;
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final boolean a(long j, float f2, boolean z) {
        long b2 = af.b(j, f2);
        long j2 = z ? this.k : this.j;
        if (j2 <= 0 || b2 >= j2) {
            return true;
        }
        return !this.m && this.g.c() >= this.o;
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final void b() {
        a(true);
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final void c() {
        a(true);
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final com.anythink.expressad.exoplayer.j.b d() {
        return this.g;
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final long e() {
        return 0L;
    }

    @Override // com.anythink.expressad.exoplayer.p
    public final boolean f() {
        return false;
    }
}
