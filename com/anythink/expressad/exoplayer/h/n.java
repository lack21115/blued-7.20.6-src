package com.anythink.expressad.exoplayer.h;

import android.net.Uri;
import android.os.Handler;
import com.anythink.expressad.exoplayer.e.k;
import com.anythink.expressad.exoplayer.h.r;
import com.anythink.expressad.exoplayer.h.t;
import com.anythink.expressad.exoplayer.h.x;
import com.anythink.expressad.exoplayer.j.t;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/n.class */
final class n implements com.anythink.expressad.exoplayer.e.g, r, x.b, t.a<a>, t.d {

    /* renamed from: a  reason: collision with root package name */
    private static final long f7467a = 10000;
    private af A;
    private boolean[] C;
    private boolean[] D;
    private boolean[] E;
    private boolean F;
    private long H;
    private boolean J;
    private int K;
    private boolean L;
    private boolean M;
    private final Uri b;

    /* renamed from: c  reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.j.h f7468c;
    private final int d;
    private final t.a e;
    private final c f;
    private final com.anythink.expressad.exoplayer.j.b g;
    private final String h;
    private final long i;
    private final b k;
    private r.a p;
    private com.anythink.expressad.exoplayer.e.k q;
    private boolean t;
    private boolean u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private int z;
    private final com.anythink.expressad.exoplayer.j.t j = new com.anythink.expressad.exoplayer.j.t("Loader:ExtractorMediaPeriod");
    private final com.anythink.expressad.exoplayer.k.f l = new com.anythink.expressad.exoplayer.k.f();
    private final Runnable m = new Runnable() { // from class: com.anythink.expressad.exoplayer.h.n.1
        @Override // java.lang.Runnable
        public final void run() {
            n.a(n.this);
        }
    };
    private final Runnable n = new Runnable() { // from class: com.anythink.expressad.exoplayer.h.n.2
        @Override // java.lang.Runnable
        public final void run() {
            if (n.this.M) {
                return;
            }
            n.this.p.a((r.a) n.this);
        }
    };
    private final Handler o = new Handler();
    private int[] s = new int[0];
    private x[] r = new x[0];
    private long I = com.anythink.expressad.exoplayer.b.b;
    private long G = -1;
    private long B = com.anythink.expressad.exoplayer.b.b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/n$a.class */
    public final class a implements t.c {
        private final Uri b;

        /* renamed from: c  reason: collision with root package name */
        private final com.anythink.expressad.exoplayer.j.h f7472c;
        private final b d;
        private final com.anythink.expressad.exoplayer.k.f e;
        private volatile boolean g;
        private long i;
        private com.anythink.expressad.exoplayer.j.k j;
        private long l;
        private final com.anythink.expressad.exoplayer.e.j f = new com.anythink.expressad.exoplayer.e.j();
        private boolean h = true;
        private long k = -1;

        public a(Uri uri, com.anythink.expressad.exoplayer.j.h hVar, b bVar, com.anythink.expressad.exoplayer.k.f fVar) {
            this.b = (Uri) com.anythink.expressad.exoplayer.k.a.a(uri);
            this.f7472c = (com.anythink.expressad.exoplayer.j.h) com.anythink.expressad.exoplayer.k.a.a(hVar);
            this.d = (b) com.anythink.expressad.exoplayer.k.a.a(bVar);
            this.e = fVar;
        }

        @Override // com.anythink.expressad.exoplayer.j.t.c
        public final void a() {
            this.g = true;
        }

        public final void a(long j, long j2) {
            this.f.f7320a = j;
            this.i = j2;
            this.h = true;
        }

        @Override // com.anythink.expressad.exoplayer.j.t.c
        public final void b() {
            int i;
            int i2 = 0;
            while (i2 == 0 && !this.g) {
                com.anythink.expressad.exoplayer.e.b bVar = null;
                try {
                    long j = this.f.f7320a;
                    com.anythink.expressad.exoplayer.j.k kVar = new com.anythink.expressad.exoplayer.j.k(this.b, j, n.this.h);
                    this.j = kVar;
                    long a2 = this.f7472c.a(kVar);
                    this.k = a2;
                    if (a2 != -1) {
                        this.k = a2 + j;
                    }
                    com.anythink.expressad.exoplayer.e.b bVar2 = new com.anythink.expressad.exoplayer.e.b(this.f7472c, j, this.k);
                    int i3 = i2;
                    try {
                        com.anythink.expressad.exoplayer.e.e a3 = this.d.a(bVar2, this.f7472c.a());
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
                            int a4 = a3.a(bVar2, this.f);
                            i4 = a4;
                            if (bVar2.c() > n.this.i + j2) {
                                j2 = bVar2.c();
                                this.e.b();
                                n.this.o.post(n.this.n);
                                i4 = a4;
                            }
                        }
                        if (i4 == 1) {
                            i = 0;
                        } else {
                            this.f.f7320a = bVar2.c();
                            this.l = this.f.f7320a - this.j.e;
                            i = i4;
                        }
                        i2 = i;
                        com.anythink.expressad.exoplayer.k.af.a(this.f7472c);
                    } catch (Throwable th) {
                        bVar = bVar2;
                        th = th;
                        i2 = i3;
                        if (i2 != 1 && bVar != null) {
                            this.f.f7320a = bVar.c();
                            this.l = this.f.f7320a - this.j.e;
                        }
                        com.anythink.expressad.exoplayer.k.af.a(this.f7472c);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/n$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final com.anythink.expressad.exoplayer.e.e[] f7473a;
        private final com.anythink.expressad.exoplayer.e.g b;

        /* renamed from: c  reason: collision with root package name */
        private com.anythink.expressad.exoplayer.e.e f7474c;

        public b(com.anythink.expressad.exoplayer.e.e[] eVarArr, com.anythink.expressad.exoplayer.e.g gVar) {
            this.f7473a = eVarArr;
            this.b = gVar;
        }

        public final com.anythink.expressad.exoplayer.e.e a(com.anythink.expressad.exoplayer.e.f fVar, Uri uri) {
            com.anythink.expressad.exoplayer.e.e eVar = this.f7474c;
            if (eVar != null) {
                return eVar;
            }
            com.anythink.expressad.exoplayer.e.e[] eVarArr = this.f7473a;
            int length = eVarArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                com.anythink.expressad.exoplayer.e.e eVar2 = eVarArr[i2];
                try {
                } catch (EOFException e) {
                } catch (Throwable th) {
                    fVar.a();
                    throw th;
                }
                if (eVar2.a(fVar)) {
                    this.f7474c = eVar2;
                    fVar.a();
                    break;
                }
                continue;
                fVar.a();
                i = i2 + 1;
            }
            com.anythink.expressad.exoplayer.e.e eVar3 = this.f7474c;
            if (eVar3 != null) {
                eVar3.a(this.b);
                return this.f7474c;
            }
            throw new ag("None of the available extractors (" + com.anythink.expressad.exoplayer.k.af.a(this.f7473a) + ") could read the stream.", uri);
        }

        public final void a() {
            if (this.f7474c != null) {
                this.f7474c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/n$c.class */
    public interface c {
        void a(long j, boolean z);
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/n$d.class */
    final class d implements y {
        private final int b;

        public d(int i) {
            this.b = i;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(long j) {
            return n.this.a(this.b, j);
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z) {
            return n.this.a(this.b, nVar, eVar, z);
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final boolean b() {
            return n.this.a(this.b);
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final void c() {
            n.this.h();
        }
    }

    public n(Uri uri, com.anythink.expressad.exoplayer.j.h hVar, com.anythink.expressad.exoplayer.e.e[] eVarArr, int i, t.a aVar, c cVar, com.anythink.expressad.exoplayer.j.b bVar, String str, int i2) {
        this.b = uri;
        this.f7468c = hVar;
        this.d = i;
        this.e = aVar;
        this.f = cVar;
        this.g = bVar;
        this.h = str;
        this.i = i2;
        this.k = new b(eVarArr, this);
        this.v = i == -1 ? 3 : i;
        aVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e6 A[RETURN] */
    /* renamed from: a  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a2(com.anythink.expressad.exoplayer.h.n.a r21, long r22, long r24, java.io.IOException r26) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.n.a2(com.anythink.expressad.exoplayer.h.n$a, long, long, java.io.IOException):int");
    }

    private void a(a aVar) {
        if (this.G == -1) {
            this.G = aVar.k;
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private void a2(a aVar, long j, long j2) {
        if (this.B == com.anythink.expressad.exoplayer.b.b) {
            long n = n();
            long j3 = n == Long.MIN_VALUE ? 0L : n + 10000;
            this.B = j3;
            this.f.a(j3, this.q.a());
        }
        this.e.a(aVar.j, 1, -1, null, 0, null, aVar.i, this.B, j, j2, aVar.l);
        a(aVar);
        this.L = true;
        this.p.a((r.a) this);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private void a2(a aVar, long j, long j2, boolean z) {
        this.e.b(aVar.j, 1, -1, null, 0, null, aVar.i, this.B, j, j2, aVar.l);
        if (z) {
            return;
        }
        a(aVar);
        x[] xVarArr = this.r;
        int length = xVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            xVarArr[i2].a();
            i = i2 + 1;
        }
        if (this.z > 0) {
            this.p.a((r.a) this);
        }
    }

    static /* synthetic */ void a(n nVar) {
        if (nVar.M || nVar.u || nVar.q == null || !nVar.t) {
            return;
        }
        x[] xVarArr = nVar.r;
        int length = xVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                nVar.l.b();
                int length2 = nVar.r.length;
                ae[] aeVarArr = new ae[length2];
                nVar.D = new boolean[length2];
                nVar.C = new boolean[length2];
                nVar.E = new boolean[length2];
                nVar.B = nVar.q.b();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length2) {
                        break;
                    }
                    com.anythink.expressad.exoplayer.m f = nVar.r[i4].f();
                    aeVarArr[i4] = new ae(f);
                    String str = f.h;
                    boolean z = true;
                    if (!com.anythink.expressad.exoplayer.k.o.b(str)) {
                        z = com.anythink.expressad.exoplayer.k.o.a(str);
                    }
                    nVar.D[i4] = z;
                    nVar.F = z | nVar.F;
                    i3 = i4 + 1;
                }
                nVar.A = new af(aeVarArr);
                if (nVar.d == -1 && nVar.G == -1 && nVar.q.b() == com.anythink.expressad.exoplayer.b.b) {
                    nVar.v = 6;
                }
                nVar.u = true;
                nVar.f.a(nVar.B, nVar.q.a());
                nVar.p.a((r) nVar);
                return;
            } else if (xVarArr[i2].f() == null) {
                return;
            } else {
                i = i2 + 1;
            }
        }
    }

    private boolean a(a aVar, int i) {
        com.anythink.expressad.exoplayer.e.k kVar;
        if (this.G != -1 || ((kVar = this.q) != null && kVar.b() != com.anythink.expressad.exoplayer.b.b)) {
            this.K = i;
            return true;
        }
        if (this.u && !j()) {
            this.J = true;
            return false;
        }
        this.x = this.u;
        this.H = 0L;
        this.K = 0;
        for (x xVar : this.r) {
            xVar.a();
        }
        aVar.a(0L, 0L);
        return true;
    }

    private static boolean a(IOException iOException) {
        return iOException instanceof ag;
    }

    private void b(int i) {
        if (this.E[i]) {
            return;
        }
        com.anythink.expressad.exoplayer.m a2 = this.A.a(i).a(0);
        this.e.a(com.anythink.expressad.exoplayer.k.o.d(a2.h), a2, 0, (Object) null, this.H);
        this.E[i] = true;
    }

    private void c(int i) {
        if (this.J && this.D[i] && !this.r[i].c()) {
            this.I = 0L;
            this.J = false;
            this.x = true;
            this.H = 0L;
            this.K = 0;
            for (x xVar : this.r) {
                xVar.a();
            }
            this.p.a((r.a) this);
        }
    }

    private boolean d(long j) {
        int length = this.r.length;
        int i = 0;
        while (true) {
            int i2 = i;
            boolean z = true;
            if (i2 >= length) {
                return true;
            }
            x xVar = this.r[i2];
            xVar.i();
            if (xVar.a(j, false) == -1) {
                z = false;
            }
            if (!z && (this.D[i2] || !this.F)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private boolean j() {
        return this.x || o();
    }

    private void k() {
        if (this.M || this.u || this.q == null || !this.t) {
            return;
        }
        x[] xVarArr = this.r;
        int length = xVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.l.b();
                int length2 = this.r.length;
                ae[] aeVarArr = new ae[length2];
                this.D = new boolean[length2];
                this.C = new boolean[length2];
                this.E = new boolean[length2];
                this.B = this.q.b();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length2) {
                        break;
                    }
                    com.anythink.expressad.exoplayer.m f = this.r[i4].f();
                    aeVarArr[i4] = new ae(f);
                    String str = f.h;
                    boolean z = true;
                    if (!com.anythink.expressad.exoplayer.k.o.b(str)) {
                        z = com.anythink.expressad.exoplayer.k.o.a(str);
                    }
                    this.D[i4] = z;
                    this.F = z | this.F;
                    i3 = i4 + 1;
                }
                this.A = new af(aeVarArr);
                if (this.d == -1 && this.G == -1 && this.q.b() == com.anythink.expressad.exoplayer.b.b) {
                    this.v = 6;
                }
                this.u = true;
                this.f.a(this.B, this.q.a());
                this.p.a((r) this);
                return;
            } else if (xVarArr[i2].f() == null) {
                return;
            } else {
                i = i2 + 1;
            }
        }
    }

    private void l() {
        a aVar = new a(this.b, this.f7468c, this.k, this.l);
        if (this.u) {
            com.anythink.expressad.exoplayer.k.a.b(o());
            long j = this.B;
            if (j != com.anythink.expressad.exoplayer.b.b && this.I >= j) {
                this.L = true;
                this.I = com.anythink.expressad.exoplayer.b.b;
                return;
            }
            aVar.a(this.q.a(this.I).f7321a.f7324c, this.I);
            this.I = com.anythink.expressad.exoplayer.b.b;
        }
        this.K = m();
        this.e.a(aVar.j, 1, -1, null, 0, null, aVar.i, this.B, this.j.a(aVar, this, this.v));
    }

    private int m() {
        int i = 0;
        for (x xVar : this.r) {
            i += xVar.b();
        }
        return i;
    }

    private long n() {
        x[] xVarArr = this.r;
        int length = xVarArr.length;
        long j = Long.MIN_VALUE;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return j;
            }
            j = Math.max(j, xVarArr[i2].g());
            i = i2 + 1;
        }
    }

    private boolean o() {
        return this.I != com.anythink.expressad.exoplayer.b.b;
    }

    final int a(int i, long j) {
        int i2 = 0;
        if (j()) {
            return 0;
        }
        x xVar = this.r[i];
        if (!this.L || j <= xVar.g()) {
            int a2 = xVar.a(j, true);
            if (a2 != -1) {
                i2 = a2;
            }
        } else {
            i2 = xVar.k();
        }
        if (i2 > 0) {
            b(i);
            return i2;
        }
        c(i);
        return i2;
    }

    final int a(int i, com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z) {
        if (j()) {
            return -3;
        }
        int a2 = this.r[i].a(nVar, eVar, z, this.L, this.H);
        if (a2 == -4) {
            b(i);
            return a2;
        }
        if (a2 == -3) {
            c(i);
        }
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00eb A[RETURN] */
    @Override // com.anythink.expressad.exoplayer.j.t.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ int a(com.anythink.expressad.exoplayer.h.n.a r21, long r22, long r24, java.io.IOException r26) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.n.a(com.anythink.expressad.exoplayer.j.t$c, long, long, java.io.IOException):int");
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(long j, com.anythink.expressad.exoplayer.ac acVar) {
        if (this.q.a()) {
            k.a a2 = this.q.a(j);
            return com.anythink.expressad.exoplayer.k.af.a(j, acVar, a2.f7321a.b, a2.b.b);
        }
        return 0L;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(com.anythink.expressad.exoplayer.i.f[] fVarArr, boolean[] zArr, y[] yVarArr, boolean[] zArr2, long j) {
        boolean z;
        long j2;
        com.anythink.expressad.exoplayer.k.a.b(this.u);
        int i = this.z;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= fVarArr.length) {
                break;
            }
            if (yVarArr[i3] != null && (fVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((d) yVarArr[i3]).b;
                com.anythink.expressad.exoplayer.k.a.b(this.C[i4]);
                this.z--;
                this.C[i4] = false;
                yVarArr[i3] = null;
            }
            i2 = i3 + 1;
        }
        boolean z2 = !this.w ? j == 0 : i != 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            z = z2;
            if (i6 >= fVarArr.length) {
                break;
            }
            z2 = z;
            if (yVarArr[i6] == null) {
                z2 = z;
                if (fVarArr[i6] != null) {
                    com.anythink.expressad.exoplayer.i.f fVar = fVarArr[i6];
                    com.anythink.expressad.exoplayer.k.a.b(fVar.g() == 1);
                    com.anythink.expressad.exoplayer.k.a.b(fVar.b(0) == 0);
                    int a2 = this.A.a(fVar.f());
                    com.anythink.expressad.exoplayer.k.a.b(!this.C[a2]);
                    this.z++;
                    this.C[a2] = true;
                    yVarArr[i6] = new d(a2);
                    zArr2[i6] = true;
                    z2 = z;
                    if (!z) {
                        x xVar = this.r[a2];
                        xVar.i();
                        z2 = xVar.a(j, true) == -1 && xVar.e() != 0;
                    }
                }
            }
            i5 = i6 + 1;
        }
        if (this.z == 0) {
            this.J = false;
            this.x = false;
            if (!this.j.a()) {
                x[] xVarArr = this.r;
                int length = xVarArr.length;
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    j2 = j;
                    if (i8 >= length) {
                        break;
                    }
                    xVarArr[i8].a();
                    i7 = i8 + 1;
                }
            } else {
                x[] xVarArr2 = this.r;
                int length2 = xVarArr2.length;
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 >= length2) {
                        break;
                    }
                    xVarArr2[i10].j();
                    i9 = i10 + 1;
                }
                this.j.b();
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
                    if (i12 >= yVarArr.length) {
                        break;
                    }
                    if (yVarArr[i12] != null) {
                        zArr2[i12] = true;
                    }
                    i11 = i12 + 1;
                }
            }
        }
        this.w = true;
        return j2;
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final com.anythink.expressad.exoplayer.e.m a(int i, int i2) {
        int length = this.r.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                x xVar = new x(this.g);
                xVar.a(this);
                int i5 = length + 1;
                int[] copyOf = Arrays.copyOf(this.s, i5);
                this.s = copyOf;
                copyOf[length] = i;
                x[] xVarArr = (x[]) Arrays.copyOf(this.r, i5);
                this.r = xVarArr;
                xVarArr[length] = xVar;
                return xVar;
            } else if (this.s[i4] == i) {
                return this.r[i4];
            } else {
                i3 = i4 + 1;
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a() {
        h();
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(long j, boolean z) {
        int length = this.r.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.r[i2].a(j, z, this.C[i2]);
            i = i2 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final void a(com.anythink.expressad.exoplayer.e.k kVar) {
        this.q = kVar;
        this.o.post(this.m);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(r.a aVar, long j) {
        this.p = aVar;
        this.l.a();
        l();
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(a aVar, long j, long j2) {
        a aVar2 = aVar;
        if (this.B == com.anythink.expressad.exoplayer.b.b) {
            long n = n();
            long j3 = n == Long.MIN_VALUE ? 0L : n + 10000;
            this.B = j3;
            this.f.a(j3, this.q.a());
        }
        this.e.a(aVar2.j, 1, -1, null, 0, null, aVar2.i, this.B, j, j2, aVar2.l);
        a(aVar2);
        this.L = true;
        this.p.a((r.a) this);
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(a aVar, long j, long j2, boolean z) {
        a aVar2 = aVar;
        this.e.b(aVar2.j, 1, -1, null, 0, null, aVar2.i, this.B, j, j2, aVar2.l);
        if (z) {
            return;
        }
        a(aVar2);
        x[] xVarArr = this.r;
        int length = xVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            xVarArr[i2].a();
            i = i2 + 1;
        }
        if (this.z > 0) {
            this.p.a((r.a) this);
        }
    }

    final boolean a(int i) {
        if (j()) {
            return false;
        }
        return this.L || this.r[i].c();
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final void a_(long j) {
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long b(long j) {
        if (!this.q.a()) {
            j = 0;
        }
        this.H = j;
        this.x = false;
        if (o() || !d(j)) {
            this.J = false;
            this.I = j;
            this.L = false;
            if (this.j.a()) {
                this.j.b();
                return j;
            }
            for (x xVar : this.r) {
                xVar.a();
            }
            return j;
        }
        return j;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final af b() {
        return this.A;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long c() {
        if (!this.y) {
            this.e.c();
            this.y = true;
        }
        if (this.x) {
            if (this.L || m() > this.K) {
                this.x = false;
                return this.H;
            }
            return com.anythink.expressad.exoplayer.b.b;
        }
        return com.anythink.expressad.exoplayer.b.b;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j) {
        if (this.L || this.J) {
            return false;
        }
        if (this.u && this.z == 0) {
            return false;
        }
        boolean a2 = this.l.a();
        if (!this.j.a()) {
            l();
            a2 = true;
        }
        return a2;
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final void c_() {
        this.t = true;
        this.o.post(this.m);
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long d() {
        long n;
        if (this.L) {
            return Long.MIN_VALUE;
        }
        if (o()) {
            return this.I;
        }
        if (this.F) {
            long j = Long.MAX_VALUE;
            int length = this.r.length;
            int i = 0;
            while (true) {
                n = j;
                if (i >= length) {
                    break;
                }
                long j2 = j;
                if (this.D[i]) {
                    j2 = Math.min(j, this.r[i].g());
                }
                i++;
                j = j2;
            }
        } else {
            n = n();
        }
        return n == Long.MIN_VALUE ? this.H : n;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long e() {
        if (this.z == 0) {
            return Long.MIN_VALUE;
        }
        return d();
    }

    public final void f() {
        if (this.u) {
            x[] xVarArr = this.r;
            int length = xVarArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                xVarArr[i2].j();
                i = i2 + 1;
            }
        }
        this.j.a(this);
        this.o.removeCallbacksAndMessages(null);
        this.p = null;
        this.M = true;
        this.e.b();
    }

    @Override // com.anythink.expressad.exoplayer.j.t.d
    public final void g() {
        x[] xVarArr = this.r;
        int length = xVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.k.a();
                return;
            } else {
                xVarArr[i2].a();
                i = i2 + 1;
            }
        }
    }

    final void h() {
        this.j.a(this.v);
    }

    @Override // com.anythink.expressad.exoplayer.h.x.b
    public final void i() {
        this.o.post(this.m);
    }
}
