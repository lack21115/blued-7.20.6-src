package com.opos.exoplayer.core.e;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/g.class */
final class g {
    private int i;
    private int j;
    private int k;
    private int l;
    private Format q;
    private int r;

    /* renamed from: a  reason: collision with root package name */
    private int f25300a = 1000;
    private int[] b = new int[1000];

    /* renamed from: c  reason: collision with root package name */
    private long[] f25301c = new long[1000];
    private long[] f = new long[1000];
    private int[] e = new int[1000];
    private int[] d = new int[1000];
    private n.a[] g = new n.a[1000];
    private Format[] h = new Format[1000];
    private long m = Long.MIN_VALUE;
    private long n = Long.MIN_VALUE;
    private boolean p = true;
    private boolean o = true;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/g$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f25302a;
        public long b;

        /* renamed from: c  reason: collision with root package name */
        public n.a f25303c;
    }

    private int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        int i4 = i;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= i2 || this.f[i4] > j) {
                break;
            }
            if (!z || (this.e[i4] & 1) != 0) {
                i3 = i6;
            }
            int i7 = i4 + 1;
            i4 = i7;
            if (i7 == this.f25300a) {
                i4 = 0;
            }
            i5 = i6 + 1;
        }
        return i3;
    }

    private long b(int i) {
        int i2;
        this.m = Math.max(this.m, c(i));
        this.i -= i;
        this.j += i;
        int i3 = this.k + i;
        this.k = i3;
        int i4 = this.f25300a;
        if (i3 >= i4) {
            this.k = i3 - i4;
        }
        int i5 = this.l - i;
        this.l = i5;
        if (i5 < 0) {
            this.l = 0;
        }
        if (this.i == 0) {
            int i6 = this.k;
            int i7 = i6;
            if (i6 == 0) {
                i7 = this.f25300a;
            }
            return this.d[i2] + this.f25301c[i7 - 1];
        }
        return this.f25301c[this.k];
    }

    private long c(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int d = d(i - 1);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return j;
            }
            j = Math.max(j, this.f[d]);
            if ((this.e[d] & 1) != 0) {
                return j;
            }
            int i4 = d - 1;
            d = i4;
            if (i4 == -1) {
                d = this.f25300a - 1;
            }
            i2 = i3 + 1;
        }
    }

    private int d(int i) {
        int i2 = this.k + i;
        int i3 = this.f25300a;
        return i2 < i3 ? i2 : i2 - i3;
    }

    public int a() {
        return this.j + this.i;
    }

    public int a(long j, boolean z, boolean z2) {
        int i;
        synchronized (this) {
            int d = d(this.l);
            i = -1;
            if (c()) {
                i = -1;
                if (j >= this.f[d]) {
                    if (j <= this.n || z2) {
                        int a2 = a(d, this.i - this.l, j, z);
                        i = -1;
                        if (a2 != -1) {
                            this.l += a2;
                            i = a2;
                        }
                    } else {
                        i = -1;
                    }
                }
            }
        }
        return i;
    }

    public int a(com.opos.exoplayer.core.l lVar, com.opos.exoplayer.core.b.e eVar, boolean z, boolean z2, Format format, a aVar) {
        int i;
        Format format2;
        synchronized (this) {
            i = -5;
            if (c()) {
                int d = d(this.l);
                if (!z && this.h[d] == format) {
                    if (eVar.f()) {
                        i = -3;
                    } else {
                        eVar.f25074c = this.f[d];
                        eVar.a_(this.e[d]);
                        aVar.f25302a = this.d[d];
                        aVar.b = this.f25301c[d];
                        aVar.f25303c = this.g[d];
                        this.l++;
                        i = -4;
                    }
                }
                format2 = this.h[d];
                lVar.f25515a = format2;
            } else if (z2) {
                eVar.a_(4);
                i = -4;
            } else {
                if (this.q != null && (z || this.q != format)) {
                    format2 = this.q;
                    lVar.f25515a = format2;
                }
                i = -3;
            }
        }
        return i;
    }

    public long a(int i) {
        int a2 = a() - i;
        com.opos.exoplayer.core.i.a.a(a2 >= 0 && a2 <= this.i - this.l);
        int i2 = this.i - a2;
        this.i = i2;
        this.n = Math.max(this.m, c(i2));
        int i3 = this.i;
        if (i3 == 0) {
            return 0L;
        }
        int d = d(i3 - 1);
        return this.d[d] + this.f25301c[d];
    }

    public void a(long j) {
        synchronized (this) {
            this.n = Math.max(this.n, j);
        }
    }

    public void a(long j, int i, long j2, int i2, n.a aVar) {
        synchronized (this) {
            if (this.o) {
                if ((i & 1) != 0) {
                    this.o = false;
                }
            }
            com.opos.exoplayer.core.i.a.b(!this.p);
            a(j);
            int d = d(this.i);
            this.f[d] = j;
            this.f25301c[d] = j2;
            this.d[d] = i2;
            this.e[d] = i;
            this.g[d] = aVar;
            this.h[d] = this.q;
            this.b[d] = this.r;
            int i3 = this.i + 1;
            this.i = i3;
            if (i3 == this.f25300a) {
                int i4 = this.f25300a + 1000;
                int[] iArr = new int[i4];
                long[] jArr = new long[i4];
                long[] jArr2 = new long[i4];
                int[] iArr2 = new int[i4];
                int[] iArr3 = new int[i4];
                n.a[] aVarArr = new n.a[i4];
                Format[] formatArr = new Format[i4];
                int i5 = this.f25300a - this.k;
                System.arraycopy((Object) this.f25301c, this.k, (Object) jArr, 0, i5);
                System.arraycopy((Object) this.f, this.k, (Object) jArr2, 0, i5);
                System.arraycopy((Object) this.e, this.k, (Object) iArr2, 0, i5);
                System.arraycopy((Object) this.d, this.k, (Object) iArr3, 0, i5);
                System.arraycopy(this.g, this.k, aVarArr, 0, i5);
                System.arraycopy(this.h, this.k, formatArr, 0, i5);
                System.arraycopy((Object) this.b, this.k, (Object) iArr, 0, i5);
                int i6 = this.k;
                System.arraycopy((Object) this.f25301c, 0, (Object) jArr, i5, i6);
                System.arraycopy((Object) this.f, 0, (Object) jArr2, i5, i6);
                System.arraycopy((Object) this.e, 0, (Object) iArr2, i5, i6);
                System.arraycopy((Object) this.d, 0, (Object) iArr3, i5, i6);
                System.arraycopy(this.g, 0, aVarArr, i5, i6);
                System.arraycopy(this.h, 0, formatArr, i5, i6);
                System.arraycopy((Object) this.b, 0, (Object) iArr, i5, i6);
                this.f25301c = jArr;
                this.f = jArr2;
                this.e = iArr2;
                this.d = iArr3;
                this.g = aVarArr;
                this.h = formatArr;
                this.b = iArr;
                this.k = 0;
                this.i = this.f25300a;
                this.f25300a = i4;
            }
        }
    }

    public void a(boolean z) {
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.o = true;
        this.m = Long.MIN_VALUE;
        this.n = Long.MIN_VALUE;
        if (z) {
            this.q = null;
            this.p = true;
        }
    }

    public boolean a(Format format) {
        boolean z;
        synchronized (this) {
            z = true;
            if (format == null) {
                this.p = true;
            } else {
                this.p = false;
                if (!u.a(format, this.q)) {
                    this.q = format;
                }
            }
            z = false;
        }
        return z;
    }

    public int b() {
        return this.j + this.l;
    }

    public long b(long j, boolean z, boolean z2) {
        long j2;
        synchronized (this) {
            j2 = -1;
            if (this.i != 0) {
                if (j < this.f[this.k]) {
                    j2 = -1;
                } else {
                    int a2 = a(this.k, (!z2 || this.l == this.i) ? this.i : this.l + 1, j, z);
                    j2 = a2 == -1 ? -1L : b(a2);
                }
            }
        }
        return j2;
    }

    public boolean b(long j) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.i == 0) {
                if (j > this.m) {
                    z = true;
                }
            } else if (Math.max(this.m, c(this.l)) < j) {
                int i = this.i;
                int d = d(this.i - 1);
                while (i > this.l && this.f[d] >= j) {
                    int i2 = i - 1;
                    int i3 = d - 1;
                    i = i2;
                    d = i3;
                    if (i3 == -1) {
                        d = this.f25300a - 1;
                        i = i2;
                    }
                }
                a(this.j + i);
                z = true;
            }
        }
        return z;
    }

    public boolean c() {
        boolean z;
        synchronized (this) {
            z = this.l != this.i;
        }
        return z;
    }

    public Format d() {
        Format format;
        synchronized (this) {
            format = this.p ? null : this.q;
        }
        return format;
    }

    public long e() {
        long j;
        synchronized (this) {
            j = this.n;
        }
        return j;
    }

    public void f() {
        synchronized (this) {
            this.l = 0;
        }
    }

    public int g() {
        int i;
        int i2;
        synchronized (this) {
            i = this.i;
            i2 = this.l;
            this.l = this.i;
        }
        return i - i2;
    }

    public long h() {
        long b;
        synchronized (this) {
            b = this.i == 0 ? -1L : b(this.i);
        }
        return b;
    }
}
