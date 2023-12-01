package com.opos.exoplayer.core.e;

import android.net.Uri;
import android.os.Handler;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.e.d;
import com.opos.exoplayer.core.e.f;
import com.opos.exoplayer.core.e.h;
import com.opos.exoplayer.core.h.r;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.w;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/o.class */
final class o implements com.opos.exoplayer.core.c.g, com.opos.exoplayer.core.e.d, h.a, r.a<a>, r.c {
    private boolean[] A;
    private boolean[] B;
    private boolean[] C;
    private boolean D;
    private long F;
    private boolean H;
    private int I;
    private boolean J;
    private boolean K;

    /* renamed from: a  reason: collision with root package name */
    private final Uri f25314a;
    private final com.opos.exoplayer.core.h.g b;

    /* renamed from: c  reason: collision with root package name */
    private final int f25315c;
    private final f.a d;
    private final c e;
    private final com.opos.exoplayer.core.h.b f;
    private final String g;
    private final long h;
    private final b j;
    private d.a o;
    private com.opos.exoplayer.core.c.l p;
    private boolean s;
    private boolean t;
    private int u;
    private boolean v;
    private boolean w;
    private int x;
    private m y;
    private final r i = new r("Loader:ExtractorMediaPeriod");
    private final com.opos.exoplayer.core.i.e k = new com.opos.exoplayer.core.i.e();
    private final Runnable l = new Runnable() { // from class: com.opos.exoplayer.core.e.o.1
        @Override // java.lang.Runnable
        public void run() {
            o.this.j();
        }
    };
    private final Runnable m = new Runnable() { // from class: com.opos.exoplayer.core.e.o.2
        @Override // java.lang.Runnable
        public void run() {
            if (o.this.K) {
                return;
            }
            o.this.o.a((d.a) o.this);
        }
    };
    private final Handler n = new Handler();
    private int[] r = new int[0];
    private h[] q = new h[0];
    private long G = com.anythink.expressad.exoplayer.b.b;
    private long E = -1;
    private long z = com.anythink.expressad.exoplayer.b.b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/o$a.class */
    public final class a implements r.b {
        private final Uri b;

        /* renamed from: c  reason: collision with root package name */
        private final com.opos.exoplayer.core.h.g f25319c;
        private final b d;
        private final com.opos.exoplayer.core.i.e e;
        private volatile boolean g;
        private long i;
        private com.opos.exoplayer.core.h.i j;
        private long l;
        private final com.opos.exoplayer.core.c.k f = new com.opos.exoplayer.core.c.k();
        private boolean h = true;
        private long k = -1;

        public a(Uri uri, com.opos.exoplayer.core.h.g gVar, b bVar, com.opos.exoplayer.core.i.e eVar) {
            this.b = (Uri) com.opos.exoplayer.core.i.a.a(uri);
            this.f25319c = (com.opos.exoplayer.core.h.g) com.opos.exoplayer.core.i.a.a(gVar);
            this.d = (b) com.opos.exoplayer.core.i.a.a(bVar);
            this.e = eVar;
        }

        @Override // com.opos.exoplayer.core.h.r.b
        public void a() {
            this.g = true;
        }

        public void a(long j, long j2) {
            this.f.f25249a = j;
            this.i = j2;
            this.h = true;
        }

        @Override // com.opos.exoplayer.core.h.r.b
        public boolean b() {
            return this.g;
        }

        @Override // com.opos.exoplayer.core.h.r.b
        public void c() {
            com.opos.exoplayer.core.c.b bVar;
            int i;
            int i2 = 0;
            while (i2 == 0 && !this.g) {
                try {
                    long j = this.f.f25249a;
                    com.opos.exoplayer.core.h.i iVar = new com.opos.exoplayer.core.h.i(this.b, j, -1L, o.this.g);
                    this.j = iVar;
                    long a2 = this.f25319c.a(iVar);
                    this.k = a2;
                    if (a2 != -1) {
                        this.k = a2 + j;
                    }
                    bVar = new com.opos.exoplayer.core.c.b(this.f25319c, j, this.k);
                    int i3 = i2;
                    try {
                        com.opos.exoplayer.core.c.e a3 = this.d.a(bVar, this.f25319c.a());
                        int i4 = i2;
                        long j2 = j;
                        if (this.h) {
                            int i5 = i2;
                            a3.a(j, this.i);
                            int i6 = i2;
                            this.h = false;
                            j2 = j;
                            i4 = i2;
                        }
                        while (i4 == 0 && !this.g) {
                            int i7 = i4;
                            this.e.c();
                            int i8 = i4;
                            int a4 = a3.a(bVar, this.f);
                            i4 = a4;
                            if (bVar.c() > o.this.h + j2) {
                                j2 = bVar.c();
                                this.e.b();
                                o.this.n.post(o.this.m);
                                i4 = a4;
                            }
                        }
                        if (i4 == 1) {
                            i = 0;
                        } else {
                            this.f.f25249a = bVar.c();
                            this.l = this.f.f25249a - this.j.f25450c;
                            i = i4;
                        }
                        i2 = i;
                        u.a(this.f25319c);
                    } catch (Throwable th) {
                        th = th;
                        i2 = i3;
                        if (i2 != 1 && bVar != null) {
                            this.f.f25249a = bVar.c();
                            this.l = this.f.f25249a - this.j.f25450c;
                        }
                        u.a(this.f25319c);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bVar = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/o$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final com.opos.exoplayer.core.c.e[] f25320a;
        private final com.opos.exoplayer.core.c.g b;

        /* renamed from: c  reason: collision with root package name */
        private com.opos.exoplayer.core.c.e f25321c;

        public b(com.opos.exoplayer.core.c.e[] eVarArr, com.opos.exoplayer.core.c.g gVar) {
            this.f25320a = eVarArr;
            this.b = gVar;
        }

        public com.opos.exoplayer.core.c.e a(com.opos.exoplayer.core.c.f fVar, Uri uri) {
            com.opos.exoplayer.core.c.e eVar = this.f25321c;
            if (eVar != null) {
                return eVar;
            }
            com.opos.exoplayer.core.c.e[] eVarArr = this.f25320a;
            int length = eVarArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                com.opos.exoplayer.core.c.e eVar2 = eVarArr[i2];
                try {
                } catch (EOFException e) {
                } catch (Throwable th) {
                    fVar.a();
                    throw th;
                }
                if (eVar2.a(fVar)) {
                    this.f25321c = eVar2;
                    fVar.a();
                    break;
                }
                continue;
                fVar.a();
                i = i2 + 1;
            }
            com.opos.exoplayer.core.c.e eVar3 = this.f25321c;
            if (eVar3 != null) {
                eVar3.a(this.b);
                return this.f25321c;
            }
            throw new n("None of the available extractors (" + u.a(this.f25320a) + ") could read the stream.", uri);
        }

        public void a() {
            com.opos.exoplayer.core.c.e eVar = this.f25321c;
            if (eVar != null) {
                eVar.c();
                this.f25321c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/o$c.class */
    public interface c {
        void a(long j, boolean z);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/o$d.class */
    final class d implements i {
        private final int b;

        public d(int i) {
            this.b = i;
        }

        @Override // com.opos.exoplayer.core.e.i
        public int a(long j) {
            return o.this.a(this.b, j);
        }

        @Override // com.opos.exoplayer.core.e.i
        public int a(com.opos.exoplayer.core.l lVar, com.opos.exoplayer.core.b.e eVar, boolean z) {
            return o.this.a(this.b, lVar, eVar, z);
        }

        @Override // com.opos.exoplayer.core.e.i
        public boolean b() {
            return o.this.a(this.b);
        }

        @Override // com.opos.exoplayer.core.e.i
        public void c() {
            o.this.h();
        }
    }

    public o(Uri uri, com.opos.exoplayer.core.h.g gVar, com.opos.exoplayer.core.c.e[] eVarArr, int i, f.a aVar, c cVar, com.opos.exoplayer.core.h.b bVar, String str, int i2) {
        this.f25314a = uri;
        this.b = gVar;
        this.f25315c = i;
        this.d = aVar;
        this.e = cVar;
        this.f = bVar;
        this.g = str;
        this.h = i2;
        this.j = new b(eVarArr, this);
        this.u = i == -1 ? 3 : i;
    }

    private void a(a aVar) {
        if (this.E == -1) {
            this.E = aVar.k;
        }
    }

    private boolean a(a aVar, int i) {
        com.opos.exoplayer.core.c.l lVar;
        if (this.E != -1 || ((lVar = this.p) != null && lVar.b() != com.anythink.expressad.exoplayer.b.b)) {
            this.I = i;
            return true;
        } else if (this.t && !i()) {
            this.H = true;
            return false;
        } else {
            this.w = this.t;
            this.F = 0L;
            this.I = 0;
            h[] hVarArr = this.q;
            int length = hVarArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    aVar.a(0L, 0L);
                    return true;
                }
                hVarArr[i3].a();
                i2 = i3 + 1;
            }
        }
    }

    private static boolean a(IOException iOException) {
        return iOException instanceof n;
    }

    private void b(int i) {
        if (this.C[i]) {
            return;
        }
        Format a2 = this.y.a(i).a(0);
        this.d.a(com.opos.exoplayer.core.i.j.e(a2.f), a2, 0, null, this.F);
        this.C[i] = true;
    }

    private void c(int i) {
        if (this.H && this.B[i] && !this.q[i].c()) {
            this.G = 0L;
            this.H = false;
            this.w = true;
            this.F = 0L;
            this.I = 0;
            for (h hVar : this.q) {
                hVar.a();
            }
            this.o.a((d.a) this);
        }
    }

    private boolean d(long j) {
        boolean z;
        int length = this.q.length;
        int i = 0;
        while (true) {
            int i2 = i;
            boolean z2 = true;
            if (i2 >= length) {
                z = true;
                break;
            }
            h hVar = this.q[i2];
            hVar.g();
            if (hVar.b(j, true, false) == -1) {
                z2 = false;
            }
            if (!z2) {
                z = false;
                if (this.B[i2]) {
                    break;
                } else if (!this.D) {
                    return false;
                }
            }
            i = i2 + 1;
        }
        return z;
    }

    private boolean i() {
        return this.w || n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.K || this.t || this.p == null || !this.s) {
            return;
        }
        h[] hVarArr = this.q;
        int length = hVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.k.b();
                int length2 = this.q.length;
                l[] lVarArr = new l[length2];
                this.B = new boolean[length2];
                this.A = new boolean[length2];
                this.C = new boolean[length2];
                this.z = this.p.b();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length2) {
                        break;
                    }
                    Format e = this.q[i4].e();
                    lVarArr[i4] = new l(e);
                    String str = e.f;
                    boolean z = true;
                    if (!com.opos.exoplayer.core.i.j.b(str)) {
                        z = com.opos.exoplayer.core.i.j.a(str);
                    }
                    this.B[i4] = z;
                    this.D = z | this.D;
                    i3 = i4 + 1;
                }
                this.y = new m(lVarArr);
                if (this.f25315c == -1 && this.E == -1 && this.p.b() == com.anythink.expressad.exoplayer.b.b) {
                    this.u = 6;
                }
                this.t = true;
                this.e.a(this.z, this.p.a());
                this.o.a((com.opos.exoplayer.core.e.d) this);
                return;
            } else if (hVarArr[i2].e() == null) {
                return;
            } else {
                i = i2 + 1;
            }
        }
    }

    private void k() {
        a aVar = new a(this.f25314a, this.b, this.j, this.k);
        if (this.t) {
            com.opos.exoplayer.core.i.a.b(n());
            long j = this.z;
            if (j != com.anythink.expressad.exoplayer.b.b && this.G >= j) {
                this.J = true;
                this.G = com.anythink.expressad.exoplayer.b.b;
                return;
            }
            aVar.a(this.p.b(this.G).f25250a.f25253c, this.G);
            this.G = com.anythink.expressad.exoplayer.b.b;
        }
        this.I = l();
        this.d.a(aVar.j, 1, -1, null, 0, null, aVar.i, this.z, this.i.a(aVar, this, this.u));
    }

    private int l() {
        h[] hVarArr = this.q;
        int length = hVarArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                return i3;
            }
            int b2 = hVarArr[i].b();
            i++;
            i2 = i3 + b2;
        }
    }

    private long m() {
        h[] hVarArr = this.q;
        int length = hVarArr.length;
        long j = Long.MIN_VALUE;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return j;
            }
            j = Math.max(j, hVarArr[i2].f());
            i = i2 + 1;
        }
    }

    private boolean n() {
        return this.G != com.anythink.expressad.exoplayer.b.b;
    }

    int a(int i, long j) {
        int i2 = 0;
        if (i()) {
            return 0;
        }
        h hVar = this.q[i];
        if (!this.J || j <= hVar.f()) {
            int b2 = hVar.b(j, true, true);
            if (b2 != -1) {
                i2 = b2;
            }
        } else {
            i2 = hVar.i();
        }
        if (i2 > 0) {
            b(i);
            return i2;
        }
        c(i);
        return i2;
    }

    int a(int i, com.opos.exoplayer.core.l lVar, com.opos.exoplayer.core.b.e eVar, boolean z) {
        if (i()) {
            return -3;
        }
        int a2 = this.q[i].a(lVar, eVar, z, this.J, this.F);
        if (a2 == -4) {
            b(i);
        } else if (a2 == -3) {
            c(i);
        }
        return a2;
    }

    @Override // com.opos.exoplayer.core.h.r.a
    public int a(a aVar, long j, long j2, IOException iOException) {
        boolean a2 = a(iOException);
        this.d.a(aVar.j, 1, -1, null, 0, null, aVar.i, this.z, j, j2, aVar.l, iOException, a2);
        a(aVar);
        if (a2) {
            return 3;
        }
        int l = l();
        boolean z = l > this.I;
        if (a(aVar, l)) {
            return z ? 1 : 0;
        }
        return 2;
    }

    @Override // com.opos.exoplayer.core.e.d
    public long a(long j, w wVar) {
        if (this.p.a()) {
            l.a b2 = this.p.b(j);
            return u.a(j, wVar, b2.f25250a.b, b2.b.b);
        }
        return 0L;
    }

    @Override // com.opos.exoplayer.core.e.d
    public long a(com.opos.exoplayer.core.g.f[] fVarArr, boolean[] zArr, i[] iVarArr, boolean[] zArr2, long j) {
        boolean z;
        long j2;
        com.opos.exoplayer.core.i.a.b(this.t);
        int i = this.x;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= fVarArr.length) {
                break;
            }
            if (iVarArr[i3] != null && (fVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((d) iVarArr[i3]).b;
                com.opos.exoplayer.core.i.a.b(this.A[i4]);
                this.x--;
                this.A[i4] = false;
                iVarArr[i3] = null;
            }
            i2 = i3 + 1;
        }
        boolean z2 = !this.v ? j == 0 : i != 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            z = z2;
            if (i6 >= fVarArr.length) {
                break;
            }
            z2 = z;
            if (iVarArr[i6] == null) {
                z2 = z;
                if (fVarArr[i6] != null) {
                    com.opos.exoplayer.core.g.f fVar = fVarArr[i6];
                    com.opos.exoplayer.core.i.a.b(fVar.e() == 1);
                    com.opos.exoplayer.core.i.a.b(fVar.b(0) == 0);
                    int a2 = this.y.a(fVar.d());
                    com.opos.exoplayer.core.i.a.b(!this.A[a2]);
                    this.x++;
                    this.A[a2] = true;
                    iVarArr[i6] = new d(a2);
                    zArr2[i6] = true;
                    z2 = z;
                    if (!z) {
                        h hVar = this.q[a2];
                        hVar.g();
                        z2 = hVar.b(j, true, true) == -1 && hVar.d() != 0;
                    }
                }
            }
            i5 = i6 + 1;
        }
        if (this.x == 0) {
            this.H = false;
            this.w = false;
            if (!this.i.a()) {
                h[] hVarArr = this.q;
                int length = hVarArr.length;
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    j2 = j;
                    if (i8 >= length) {
                        break;
                    }
                    hVarArr[i8].a();
                    i7 = i8 + 1;
                }
            } else {
                h[] hVarArr2 = this.q;
                int length2 = hVarArr2.length;
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 >= length2) {
                        break;
                    }
                    hVarArr2[i10].h();
                    i9 = i10 + 1;
                }
                this.i.b();
                j2 = j;
            }
        } else {
            j2 = j;
            if (z) {
                long b2 = b(j);
                int i11 = 0;
                while (true) {
                    int i12 = i11;
                    j2 = b2;
                    if (i12 >= iVarArr.length) {
                        break;
                    }
                    if (iVarArr[i12] != null) {
                        zArr2[i12] = true;
                    }
                    i11 = i12 + 1;
                }
            }
        }
        this.v = true;
        return j2;
    }

    @Override // com.opos.exoplayer.core.c.g
    public com.opos.exoplayer.core.c.n a(int i, int i2) {
        int length = this.q.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                h hVar = new h(this.f);
                hVar.a(this);
                int i5 = length + 1;
                int[] copyOf = Arrays.copyOf(this.r, i5);
                this.r = copyOf;
                copyOf[length] = i;
                h[] hVarArr = (h[]) Arrays.copyOf(this.q, i5);
                this.q = hVarArr;
                hVarArr[length] = hVar;
                return hVar;
            } else if (this.r[i4] == i) {
                return this.q[i4];
            } else {
                i3 = i4 + 1;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.g
    public void a() {
        this.s = true;
        this.n.post(this.l);
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(long j) {
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(long j, boolean z) {
        int length = this.q.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.q[i2].a(j, z, this.A[i2]);
            i = i2 + 1;
        }
    }

    @Override // com.opos.exoplayer.core.e.h.a
    public void a(Format format) {
        this.n.post(this.l);
    }

    @Override // com.opos.exoplayer.core.c.g
    public void a(com.opos.exoplayer.core.c.l lVar) {
        this.p = lVar;
        this.n.post(this.l);
    }

    @Override // com.opos.exoplayer.core.e.d
    public void a(d.a aVar, long j) {
        this.o = aVar;
        this.k.a();
        k();
    }

    @Override // com.opos.exoplayer.core.h.r.a
    public void a(a aVar, long j, long j2) {
        if (this.z == com.anythink.expressad.exoplayer.b.b) {
            long m = m();
            long j3 = m == Long.MIN_VALUE ? 0L : m + 10000;
            this.z = j3;
            this.e.a(j3, this.p.a());
        }
        this.d.a(aVar.j, 1, -1, null, 0, null, aVar.i, this.z, j, j2, aVar.l);
        a(aVar);
        this.J = true;
        this.o.a((d.a) this);
    }

    @Override // com.opos.exoplayer.core.h.r.a
    public void a(a aVar, long j, long j2, boolean z) {
        this.d.b(aVar.j, 1, -1, null, 0, null, aVar.i, this.z, j, j2, aVar.l);
        if (z) {
            return;
        }
        a(aVar);
        h[] hVarArr = this.q;
        int length = hVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            hVarArr[i2].a();
            i = i2 + 1;
        }
        if (this.x > 0) {
            this.o.a((d.a) this);
        }
    }

    boolean a(int i) {
        if (i()) {
            return false;
        }
        return this.J || this.q[i].c();
    }

    @Override // com.opos.exoplayer.core.e.d
    public long b(long j) {
        if (!this.p.a()) {
            j = 0;
        }
        this.F = j;
        this.w = false;
        if (n() || !d(j)) {
            this.H = false;
            this.G = j;
            this.J = false;
            if (this.i.a()) {
                this.i.b();
                return j;
            }
            for (h hVar : this.q) {
                hVar.a();
            }
            return j;
        }
        return j;
    }

    @Override // com.opos.exoplayer.core.e.d
    public m b() {
        return this.y;
    }

    @Override // com.opos.exoplayer.core.e.d
    public long c() {
        if (this.w) {
            if (this.J || l() > this.I) {
                this.w = false;
                return this.F;
            }
            return com.anythink.expressad.exoplayer.b.b;
        }
        return com.anythink.expressad.exoplayer.b.b;
    }

    @Override // com.opos.exoplayer.core.e.d
    public boolean c(long j) {
        boolean z;
        if (this.J || this.H || (this.t && this.x == 0)) {
            z = false;
        } else {
            z = this.k.a();
            if (!this.i.a()) {
                k();
                return true;
            }
        }
        return z;
    }

    @Override // com.opos.exoplayer.core.e.d
    public void c_() {
        h();
    }

    @Override // com.opos.exoplayer.core.e.d
    public long d() {
        long m;
        if (this.J) {
            return Long.MIN_VALUE;
        }
        if (n()) {
            return this.G;
        }
        if (this.D) {
            long j = Long.MAX_VALUE;
            int length = this.q.length;
            int i = 0;
            while (true) {
                m = j;
                if (i >= length) {
                    break;
                }
                long j2 = j;
                if (this.B[i]) {
                    j2 = Math.min(j, this.q[i].f());
                }
                i++;
                j = j2;
            }
        } else {
            m = m();
        }
        return m == Long.MIN_VALUE ? this.F : m;
    }

    @Override // com.opos.exoplayer.core.e.d
    public long e() {
        if (this.x == 0) {
            return Long.MIN_VALUE;
        }
        return d();
    }

    public void f() {
        if (this.t) {
            h[] hVarArr = this.q;
            int length = hVarArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                hVarArr[i2].h();
                i = i2 + 1;
            }
        }
        this.i.a(this);
        this.n.removeCallbacksAndMessages(null);
        this.K = true;
    }

    @Override // com.opos.exoplayer.core.h.r.c
    public void g() {
        h[] hVarArr = this.q;
        int length = hVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.j.a();
                return;
            } else {
                hVarArr[i2].a();
                i = i2 + 1;
            }
        }
    }

    void h() {
        this.i.a(this.u);
    }
}
