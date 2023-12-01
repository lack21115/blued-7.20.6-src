package com.anythink.expressad.exoplayer;

import android.util.Log;
import com.anythink.expressad.exoplayer.h.af;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/q.class */
final class q {
    private static final String l = "MediaPeriodHolder";

    /* renamed from: a  reason: collision with root package name */
    public final com.anythink.expressad.exoplayer.h.r f4885a;
    public final Object b;

    /* renamed from: c  reason: collision with root package name */
    public final com.anythink.expressad.exoplayer.h.y[] f4886c;
    public final boolean[] d;
    public long e;
    public boolean f;
    public boolean g;
    public r h;
    public q i;
    public af j;
    public com.anythink.expressad.exoplayer.i.i k;
    private final z[] m;
    private final com.anythink.expressad.exoplayer.i.h n;
    private final com.anythink.expressad.exoplayer.h.s o;
    private com.anythink.expressad.exoplayer.i.i p;

    public q(z[] zVarArr, long j, com.anythink.expressad.exoplayer.i.h hVar, com.anythink.expressad.exoplayer.j.b bVar, com.anythink.expressad.exoplayer.h.s sVar, Object obj, r rVar) {
        this.m = zVarArr;
        this.e = j - rVar.b;
        this.n = hVar;
        this.o = sVar;
        this.b = com.anythink.expressad.exoplayer.k.a.a(obj);
        this.h = rVar;
        this.f4886c = new com.anythink.expressad.exoplayer.h.y[zVarArr.length];
        this.d = new boolean[zVarArr.length];
        com.anythink.expressad.exoplayer.h.r a2 = sVar.a(rVar.f4887a, bVar);
        this.f4885a = rVar.f4888c != Long.MIN_VALUE ? new com.anythink.expressad.exoplayer.h.d(a2, true, 0L, rVar.f4888c) : a2;
    }

    private void a(com.anythink.expressad.exoplayer.i.i iVar) {
        com.anythink.expressad.exoplayer.i.i iVar2 = this.p;
        if (iVar2 != null) {
            c(iVar2);
        }
        this.p = iVar;
        if (iVar != null) {
            b(iVar);
        }
    }

    private void a(com.anythink.expressad.exoplayer.h.y[] yVarArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            z[] zVarArr = this.m;
            if (i2 >= zVarArr.length) {
                return;
            }
            if (zVarArr[i2].a() == 5) {
                yVarArr[i2] = null;
            }
            i = i2 + 1;
        }
    }

    private void b(float f) {
        this.f = true;
        this.j = this.f4885a.b();
        a(f);
        long b = b(this.h.b);
        this.e += this.h.b - b;
        r rVar = this.h;
        this.h = new r(rVar.f4887a, b, rVar.f4888c, rVar.d, rVar.e, rVar.f, rVar.g);
    }

    private static void b(com.anythink.expressad.exoplayer.i.i iVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iVar.f4708a) {
                return;
            }
            boolean a2 = iVar.a(i2);
            com.anythink.expressad.exoplayer.i.f a3 = iVar.f4709c.a(i2);
            if (a2 && a3 != null) {
                a3.a();
            }
            i = i2 + 1;
        }
    }

    private void b(com.anythink.expressad.exoplayer.h.y[] yVarArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            z[] zVarArr = this.m;
            if (i2 >= zVarArr.length) {
                return;
            }
            if (zVarArr[i2].a() == 5 && this.k.a(i2)) {
                yVarArr[i2] = new com.anythink.expressad.exoplayer.h.m();
            }
            i = i2 + 1;
        }
    }

    private long c(long j) {
        return j + this.e;
    }

    private static void c(com.anythink.expressad.exoplayer.i.i iVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iVar.f4708a) {
                return;
            }
            iVar.a(i2);
            iVar.f4709c.a(i2);
            i = i2 + 1;
        }
    }

    private long d() {
        return this.e;
    }

    private long d(long j) {
        return j - this.e;
    }

    private long e() {
        return this.h.e;
    }

    private void e(long j) {
        if (this.f) {
            this.f4885a.a_(j - this.e);
        }
    }

    public final long a(long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            boolean z2 = true;
            if (i2 >= this.k.f4708a) {
                break;
            }
            boolean[] zArr2 = this.d;
            if (z || !this.k.a(this.p, i2)) {
                z2 = false;
            }
            zArr2[i2] = z2;
            i = i2 + 1;
        }
        a(this.f4886c);
        a(this.k);
        com.anythink.expressad.exoplayer.i.g gVar = this.k.f4709c;
        long a2 = this.f4885a.a(gVar.a(), this.d, this.f4886c, zArr, j);
        b(this.f4886c);
        this.g = false;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            com.anythink.expressad.exoplayer.h.y[] yVarArr = this.f4886c;
            if (i4 >= yVarArr.length) {
                return a2;
            }
            if (yVarArr[i4] != null) {
                com.anythink.expressad.exoplayer.k.a.b(this.k.a(i4));
                if (this.m[i4].a() != 5) {
                    this.g = true;
                }
            } else {
                com.anythink.expressad.exoplayer.k.a.b(gVar.a(i4) == null);
            }
            i3 = i4 + 1;
        }
    }

    public final long a(boolean z) {
        if (this.f) {
            long d = this.f4885a.d();
            long j = d;
            if (d == Long.MIN_VALUE) {
                j = d;
                if (z) {
                    j = this.h.e;
                }
            }
            return j;
        }
        return this.h.b;
    }

    public final void a(long j) {
        this.f4885a.c(j - this.e);
    }

    public final boolean a() {
        if (this.f) {
            return !this.g || this.f4885a.d() == Long.MIN_VALUE;
        }
        return false;
    }

    public final boolean a(float f) {
        com.anythink.expressad.exoplayer.i.f[] a2;
        com.anythink.expressad.exoplayer.i.i a3 = this.n.a(this.m, this.j);
        if (a3.a(this.p)) {
            return false;
        }
        this.k = a3;
        for (com.anythink.expressad.exoplayer.i.f fVar : a3.f4709c.a()) {
            if (fVar != null) {
                fVar.a(f);
            }
        }
        return true;
    }

    public final long b() {
        if (this.f) {
            return this.f4885a.e();
        }
        return 0L;
    }

    public final long b(long j) {
        return a(j, false, new boolean[this.m.length]);
    }

    public final void c() {
        a((com.anythink.expressad.exoplayer.i.i) null);
        try {
            if (this.h.f4888c != Long.MIN_VALUE) {
                this.o.a(((com.anythink.expressad.exoplayer.h.d) this.f4885a).f4600a);
            } else {
                this.o.a(this.f4885a);
            }
        } catch (RuntimeException e) {
            Log.e(l, "Period release failed.", e);
        }
    }
}
