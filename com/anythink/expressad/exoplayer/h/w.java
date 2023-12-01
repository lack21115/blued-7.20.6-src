package com.anythink.expressad.exoplayer.h;

import com.anythink.expressad.exoplayer.e.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/w.class */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7513a = 1000;
    private int j;
    private int k;
    private int l;
    private int m;
    private com.anythink.expressad.exoplayer.m r;
    private int s;
    private int b = 1000;

    /* renamed from: c  reason: collision with root package name */
    private int[] f7514c = new int[1000];
    private long[] d = new long[1000];
    private long[] g = new long[1000];
    private int[] f = new int[1000];
    private int[] e = new int[1000];
    private m.a[] h = new m.a[1000];
    private com.anythink.expressad.exoplayer.m[] i = new com.anythink.expressad.exoplayer.m[1000];
    private long n = Long.MIN_VALUE;
    private long o = Long.MIN_VALUE;
    private boolean q = true;
    private boolean p = true;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/w$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f7515a;
        public long b;

        /* renamed from: c  reason: collision with root package name */
        public m.a f7516c;
    }

    private int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        int i4 = i;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= i2 || this.g[i4] > j) {
                break;
            }
            if (!z || (this.f[i4] & 1) != 0) {
                i3 = i6;
            }
            int i7 = i4 + 1;
            i4 = i7;
            if (i7 == this.b) {
                i4 = 0;
            }
            i5 = i6 + 1;
        }
        return i3;
    }

    private void b(long j) {
        synchronized (this) {
            this.o = Math.max(this.o, j);
        }
    }

    private long d(int i) {
        int i2;
        this.n = Math.max(this.n, e(i));
        this.j -= i;
        this.k += i;
        int i3 = this.l + i;
        this.l = i3;
        int i4 = this.b;
        if (i3 >= i4) {
            this.l = i3 - i4;
        }
        int i5 = this.m - i;
        this.m = i5;
        if (i5 < 0) {
            this.m = 0;
        }
        if (this.j == 0) {
            int i6 = this.l;
            int i7 = i6;
            if (i6 == 0) {
                i7 = this.b;
            }
            return this.d[i7 - 1] + this.e[i2];
        }
        return this.d[this.l];
    }

    private long e(int i) {
        long j;
        long j2 = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int f = f(i - 1);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            j = j2;
            if (i3 >= i) {
                break;
            }
            j2 = Math.max(j2, this.g[f]);
            j = j2;
            if ((this.f[f] & 1) != 0) {
                break;
            }
            int i4 = f - 1;
            f = i4;
            if (i4 == -1) {
                f = this.b - 1;
            }
            i2 = i3 + 1;
        }
        return j;
    }

    private int f(int i) {
        int i2 = this.l + i;
        int i3 = this.b;
        return i2 < i3 ? i2 : i2 - i3;
    }

    public final int a(long j, boolean z) {
        synchronized (this) {
            int f = f(this.m);
            if (!f() || j < this.g[f] || (j > this.o && !z)) {
                return -1;
            }
            int a2 = a(f, this.j - this.m, j, true);
            if (a2 == -1) {
                return -1;
            }
            this.m += a2;
            return a2;
        }
    }

    public final int a(com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z, boolean z2, com.anythink.expressad.exoplayer.m mVar, a aVar) {
        synchronized (this) {
            if (!f()) {
                if (z2) {
                    eVar.a(4);
                    return -4;
                } else if (this.r == null || (!z && this.r == mVar)) {
                    return -3;
                } else {
                    nVar.f7721a = this.r;
                    return -5;
                }
            }
            int f = f(this.m);
            if (!z && this.i[f] == mVar) {
                if (eVar.f()) {
                    return -3;
                }
                eVar.f = this.g[f];
                eVar.a(this.f[f]);
                aVar.f7515a = this.e[f];
                aVar.b = this.d[f];
                aVar.f7516c = this.h[f];
                this.m++;
                return -4;
            }
            nVar.f7721a = this.i[f];
            return -5;
        }
    }

    public final long a(int i) {
        int b = b() - i;
        com.anythink.expressad.exoplayer.k.a.a(b >= 0 && b <= this.j - this.m);
        int i2 = this.j - b;
        this.j = i2;
        this.o = Math.max(this.n, e(i2));
        int i3 = this.j;
        if (i3 == 0) {
            return 0L;
        }
        int f = f(i3 - 1);
        return this.d[f] + this.e[f];
    }

    public final long a(long j, boolean z, boolean z2) {
        synchronized (this) {
            if (this.j != 0 && j >= this.g[this.l]) {
                int a2 = a(this.l, (!z2 || this.m == this.j) ? this.j : this.m + 1, j, z);
                if (a2 == -1) {
                    return -1L;
                }
                return d(a2);
            }
            return -1L;
        }
    }

    public final void a() {
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.p = true;
        this.n = Long.MIN_VALUE;
        this.o = Long.MIN_VALUE;
    }

    public final void a(long j, int i, long j2, int i2, m.a aVar) {
        synchronized (this) {
            if (this.p) {
                if ((i & 1) == 0) {
                    return;
                }
                this.p = false;
            }
            com.anythink.expressad.exoplayer.k.a.b(!this.q);
            b(j);
            int f = f(this.j);
            this.g[f] = j;
            this.d[f] = j2;
            this.e[f] = i2;
            this.f[f] = i;
            this.h[f] = aVar;
            this.i[f] = this.r;
            this.f7514c[f] = this.s;
            int i3 = this.j + 1;
            this.j = i3;
            if (i3 == this.b) {
                int i4 = this.b + 1000;
                int[] iArr = new int[i4];
                long[] jArr = new long[i4];
                long[] jArr2 = new long[i4];
                int[] iArr2 = new int[i4];
                int[] iArr3 = new int[i4];
                m.a[] aVarArr = new m.a[i4];
                com.anythink.expressad.exoplayer.m[] mVarArr = new com.anythink.expressad.exoplayer.m[i4];
                int i5 = this.b - this.l;
                System.arraycopy((Object) this.d, this.l, (Object) jArr, 0, i5);
                System.arraycopy((Object) this.g, this.l, (Object) jArr2, 0, i5);
                System.arraycopy((Object) this.f, this.l, (Object) iArr2, 0, i5);
                System.arraycopy((Object) this.e, this.l, (Object) iArr3, 0, i5);
                System.arraycopy(this.h, this.l, aVarArr, 0, i5);
                System.arraycopy(this.i, this.l, mVarArr, 0, i5);
                System.arraycopy((Object) this.f7514c, this.l, (Object) iArr, 0, i5);
                int i6 = this.l;
                System.arraycopy((Object) this.d, 0, (Object) jArr, i5, i6);
                System.arraycopy((Object) this.g, 0, (Object) jArr2, i5, i6);
                System.arraycopy((Object) this.f, 0, (Object) iArr2, i5, i6);
                System.arraycopy((Object) this.e, 0, (Object) iArr3, i5, i6);
                System.arraycopy(this.h, 0, aVarArr, i5, i6);
                System.arraycopy(this.i, 0, mVarArr, i5, i6);
                System.arraycopy((Object) this.f7514c, 0, (Object) iArr, i5, i6);
                this.d = jArr;
                this.g = jArr2;
                this.f = iArr2;
                this.e = iArr3;
                this.h = aVarArr;
                this.i = mVarArr;
                this.f7514c = iArr;
                this.l = 0;
                this.j = this.b;
                this.b = i4;
            }
        }
    }

    public final boolean a(long j) {
        synchronized (this) {
            if (this.j == 0) {
                return j > this.n;
            } else if (Math.max(this.n, e(this.m)) >= j) {
                return false;
            } else {
                int i = this.j;
                int f = f(this.j - 1);
                while (i > this.m && this.g[f] >= j) {
                    int i2 = i - 1;
                    int i3 = f - 1;
                    i = i2;
                    f = i3;
                    if (i3 == -1) {
                        f = this.b - 1;
                        i = i2;
                    }
                }
                a(this.k + i);
                return true;
            }
        }
    }

    public final boolean a(com.anythink.expressad.exoplayer.m mVar) {
        synchronized (this) {
            if (mVar == null) {
                this.q = true;
                return false;
            }
            this.q = false;
            if (com.anythink.expressad.exoplayer.k.af.a(mVar, this.r)) {
                return false;
            }
            this.r = mVar;
            return true;
        }
    }

    public final int b() {
        return this.k + this.j;
    }

    public final void b(int i) {
        this.s = i;
    }

    public final int c() {
        return this.k;
    }

    public final boolean c(int i) {
        synchronized (this) {
            if (this.k > i || i > this.k + this.j) {
                return false;
            }
            this.m = i - this.k;
            return true;
        }
    }

    public final int d() {
        return this.k + this.m;
    }

    public final int e() {
        return f() ? this.f7514c[f(this.m)] : this.s;
    }

    public final boolean f() {
        boolean z;
        synchronized (this) {
            z = this.m != this.j;
        }
        return z;
    }

    public final com.anythink.expressad.exoplayer.m g() {
        synchronized (this) {
            if (this.q) {
                return null;
            }
            return this.r;
        }
    }

    public final long h() {
        long j;
        synchronized (this) {
            j = this.o;
        }
        return j;
    }

    public final long i() {
        synchronized (this) {
            if (this.j == 0) {
                return Long.MIN_VALUE;
            }
            return this.g[this.l];
        }
    }

    public final void j() {
        synchronized (this) {
            this.m = 0;
        }
    }

    public final int k() {
        int i;
        int i2;
        synchronized (this) {
            i = this.j;
            i2 = this.m;
            this.m = this.j;
        }
        return i - i2;
    }

    public final long l() {
        synchronized (this) {
            if (this.m == 0) {
                return -1L;
            }
            return d(this.m);
        }
    }

    public final long m() {
        synchronized (this) {
            if (this.j == 0) {
                return -1L;
            }
            return d(this.j);
        }
    }
}
