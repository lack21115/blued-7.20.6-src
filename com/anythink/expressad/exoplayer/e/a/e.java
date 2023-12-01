package com.anythink.expressad.exoplayer.e.a;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.anythink.expressad.exoplayer.d.e;
import com.anythink.expressad.exoplayer.e.a.a;
import com.anythink.expressad.exoplayer.e.k;
import com.anythink.expressad.exoplayer.k.ac;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.o;
import com.anythink.expressad.exoplayer.k.p;
import com.anythink.expressad.exoplayer.k.s;
import com.anythink.expressad.exoplayer.t;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/e.class */
public final class e implements com.anythink.expressad.exoplayer.e.e {
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 4;
    public static final int h = 16;
    private static final int i = 8;
    private static final String j = "FragmentedMp4Extractor";
    private static final int n = 0;
    private static final int o = 1;
    private static final int p = 2;
    private static final int q = 3;
    private static final int r = 4;
    private final ac A;
    private final s B;
    private final byte[] C;
    private final ArrayDeque<a.C0125a> D;
    private final ArrayDeque<b> E;
    private final com.anythink.expressad.exoplayer.e.m F;
    private int G;
    private int H;
    private long I;
    private int J;
    private s K;
    private long L;
    private int M;
    private long N;
    private long O;
    private long P;
    private c Q;
    private int R;
    private int S;
    private int T;
    private boolean U;
    private com.anythink.expressad.exoplayer.e.g V;
    private com.anythink.expressad.exoplayer.e.m[] W;
    private com.anythink.expressad.exoplayer.e.m[] X;
    private boolean Y;
    private final int s;
    private final j t;
    private final List<com.anythink.expressad.exoplayer.m> u;
    private final com.anythink.expressad.exoplayer.d.e v;
    private final SparseArray<c> w;
    private final s x;
    private final s y;
    private final s z;
    public static final com.anythink.expressad.exoplayer.e.h d = new com.anythink.expressad.exoplayer.e.h() { // from class: com.anythink.expressad.exoplayer.e.a.e.1
        @Override // com.anythink.expressad.exoplayer.e.h
        public final com.anythink.expressad.exoplayer.e.e[] a() {
            return new com.anythink.expressad.exoplayer.e.e[]{new e()};
        }
    };
    private static final int k = af.f("seig");
    private static final byte[] l = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final com.anythink.expressad.exoplayer.m m = com.anythink.expressad.exoplayer.m.a((String) null, o.ai);

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/e$a.class */
    public @interface a {
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/e$b.class */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f7293a;
        public final int b;

        public b(long j, int i) {
            this.f7293a = j;
            this.b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/e$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final com.anythink.expressad.exoplayer.e.m f7294a;

        /* renamed from: c  reason: collision with root package name */
        public j f7295c;
        public com.anythink.expressad.exoplayer.e.a.c d;
        public int e;
        public int f;
        public int g;
        public int h;
        public final l b = new l();
        private final s i = new s(1);
        private final s j = new s();

        public c(com.anythink.expressad.exoplayer.e.m mVar) {
            this.f7294a = mVar;
        }

        static /* synthetic */ void a(c cVar) {
            if (cVar.b.m) {
                s sVar = cVar.b.q;
                k e = cVar.e();
                if (e.d != 0) {
                    sVar.d(e.d);
                }
                if (cVar.b.n[cVar.e]) {
                    sVar.d(sVar.e() * 6);
                }
            }
        }

        private void d() {
            if (this.b.m) {
                s sVar = this.b.q;
                k e = e();
                if (e.d != 0) {
                    sVar.d(e.d);
                }
                if (this.b.n[this.e]) {
                    sVar.d(sVar.e() * 6);
                }
            }
        }

        private k e() {
            return this.b.o != null ? this.b.o : this.f7295c.a(this.b.f7308a.f7288a);
        }

        public final void a() {
            this.b.a();
            this.e = 0;
            this.g = 0;
            this.f = 0;
            this.h = 0;
        }

        public final void a(long j) {
            long a2 = com.anythink.expressad.exoplayer.b.a(j);
            int i = this.e;
            while (true) {
                int i2 = i;
                if (i2 >= this.b.f || this.b.b(i2) >= a2) {
                    return;
                }
                if (this.b.l[i2]) {
                    this.h = i2;
                }
                i = i2 + 1;
            }
        }

        public final void a(com.anythink.expressad.exoplayer.d.e eVar) {
            k a2 = this.f7295c.a(this.b.f7308a.f7288a);
            this.f7294a.a(this.f7295c.h.a(eVar.a(a2 != null ? a2.b : null)));
        }

        public final void a(j jVar, com.anythink.expressad.exoplayer.e.a.c cVar) {
            this.f7295c = (j) com.anythink.expressad.exoplayer.k.a.a(jVar);
            this.d = (com.anythink.expressad.exoplayer.e.a.c) com.anythink.expressad.exoplayer.k.a.a(cVar);
            this.f7294a.a(jVar.h);
            a();
        }

        public final boolean b() {
            this.e++;
            int i = this.f + 1;
            this.f = i;
            int[] iArr = this.b.h;
            int i2 = this.g;
            if (i == iArr[i2]) {
                this.g = i2 + 1;
                this.f = 0;
                return false;
            }
            return true;
        }

        public final int c() {
            s sVar;
            int length;
            if (this.b.m) {
                k e = e();
                if (e.d != 0) {
                    sVar = this.b.q;
                    length = e.d;
                } else {
                    byte[] bArr = e.e;
                    this.j.a(bArr, bArr.length);
                    sVar = this.j;
                    length = bArr.length;
                }
                boolean z = this.b.n[this.e];
                this.i.f7674a[0] = (byte) ((z ? 128 : 0) | length);
                this.i.c(0);
                this.f7294a.a(this.i, 1);
                this.f7294a.a(sVar, length);
                if (z) {
                    s sVar2 = this.b.q;
                    int e2 = sVar2.e();
                    sVar2.d(-2);
                    int i = (e2 * 6) + 2;
                    this.f7294a.a(sVar2, i);
                    return length + 1 + i;
                }
                return length + 1;
            }
            return 0;
        }
    }

    public e() {
        this(0);
    }

    public e(int i2) {
        this(i2, null);
    }

    private e(int i2, ac acVar) {
        this(i2, acVar, null, null);
    }

    private e(int i2, ac acVar, j jVar, com.anythink.expressad.exoplayer.d.e eVar) {
        this(i2, acVar, jVar, eVar, Collections.emptyList());
    }

    private e(int i2, ac acVar, j jVar, com.anythink.expressad.exoplayer.d.e eVar, List<com.anythink.expressad.exoplayer.m> list) {
        this(i2, acVar, jVar, eVar, list, null);
    }

    private e(int i2, ac acVar, j jVar, com.anythink.expressad.exoplayer.d.e eVar, List<com.anythink.expressad.exoplayer.m> list, com.anythink.expressad.exoplayer.e.m mVar) {
        this.s = i2 | (jVar != null ? 8 : 0);
        this.A = acVar;
        this.t = jVar;
        this.v = eVar;
        this.u = Collections.unmodifiableList(list);
        this.F = mVar;
        this.B = new s(16);
        this.x = new s(p.f7664a);
        this.y = new s(5);
        this.z = new s();
        this.C = new byte[16];
        this.D = new ArrayDeque<>();
        this.E = new ArrayDeque<>();
        this.w = new SparseArray<>();
        this.O = com.anythink.expressad.exoplayer.b.b;
        this.N = com.anythink.expressad.exoplayer.b.b;
        this.P = com.anythink.expressad.exoplayer.b.b;
        a();
    }

    private static int a(c cVar, int i2, long j2, int i3, s sVar, int i4) {
        sVar.c(8);
        int b2 = com.anythink.expressad.exoplayer.e.a.a.b(sVar.i());
        j jVar = cVar.f7295c;
        l lVar = cVar.b;
        com.anythink.expressad.exoplayer.e.a.c cVar2 = lVar.f7308a;
        lVar.h[i2] = sVar.m();
        lVar.g[i2] = lVar.f7309c;
        if ((b2 & 1) != 0) {
            long[] jArr = lVar.g;
            jArr[i2] = jArr[i2] + sVar.i();
        }
        boolean z = (b2 & 4) != 0;
        int i5 = cVar2.d;
        if (z) {
            i5 = sVar.m();
        }
        boolean z2 = (b2 & 256) != 0;
        boolean z3 = (b2 & 512) != 0;
        boolean z4 = (b2 & 1024) != 0;
        boolean z5 = (b2 & 2048) != 0;
        long j3 = 0;
        if (jVar.j != null) {
            j3 = 0;
            if (jVar.j.length == 1) {
                j3 = 0;
                if (jVar.j[0] == 0) {
                    j3 = af.a(jVar.k[0], 1000L, jVar.e);
                }
            }
        }
        int[] iArr = lVar.i;
        int[] iArr2 = lVar.j;
        long[] jArr2 = lVar.k;
        boolean[] zArr = lVar.l;
        boolean z6 = jVar.d == 2 && (i3 & 1) != 0;
        int i6 = i4 + lVar.h[i2];
        long j4 = jVar.e;
        if (i2 > 0) {
            j2 = lVar.s;
        }
        long j5 = j2;
        while (i4 < i6) {
            int m2 = z2 ? sVar.m() : cVar2.b;
            int m3 = z3 ? sVar.m() : cVar2.f7289c;
            int i7 = (i4 == 0 && z) ? i5 : z4 ? sVar.i() : cVar2.d;
            if (z5) {
                iArr2[i4] = (int) ((sVar.i() * 1000) / j4);
            } else {
                iArr2[i4] = 0;
            }
            jArr2[i4] = af.a(j5, 1000L, j4) - j3;
            iArr[i4] = m3;
            zArr[i4] = ((i7 >> 16) & 1) == 0 && (!z6 || i4 == 0);
            i4++;
            j5 += m2;
        }
        lVar.s = j5;
        return i6;
    }

    private static Pair<Long, com.anythink.expressad.exoplayer.e.a> a(s sVar, long j2) {
        long n2;
        long n3;
        sVar.c(8);
        int a2 = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
        sVar.d(4);
        long h2 = sVar.h();
        if (a2 == 0) {
            n2 = sVar.h();
            n3 = sVar.h();
        } else {
            n2 = sVar.n();
            n3 = sVar.n();
        }
        long j3 = j2 + n3;
        long a3 = af.a(n2, 1000000L, h2);
        sVar.d(2);
        int e2 = sVar.e();
        int[] iArr = new int[e2];
        long[] jArr = new long[e2];
        long[] jArr2 = new long[e2];
        long[] jArr3 = new long[e2];
        long j4 = a3;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= e2) {
                return Pair.create(Long.valueOf(a3), new com.anythink.expressad.exoplayer.e.a(iArr, jArr, jArr2, jArr3));
            }
            int i4 = sVar.i();
            if ((i4 & Integer.MIN_VALUE) != 0) {
                throw new t("Unhandled indirect reference");
            }
            long h3 = sVar.h();
            iArr[i3] = i4 & Integer.MAX_VALUE;
            jArr[i3] = j3;
            jArr3[i3] = j4;
            n2 += h3;
            j4 = af.a(n2, 1000000L, h2);
            jArr2[i3] = j4 - jArr3[i3];
            sVar.d(4);
            j3 += iArr[i3];
            i2 = i3 + 1;
        }
    }

    private static com.anythink.expressad.exoplayer.d.e a(List<a.b> list) {
        ArrayList arrayList;
        int size = list.size();
        int i2 = 0;
        ArrayList arrayList2 = null;
        while (true) {
            arrayList = arrayList2;
            if (i2 >= size) {
                break;
            }
            a.b bVar = list.get(i2);
            ArrayList arrayList3 = arrayList;
            if (bVar.aU == com.anythink.expressad.exoplayer.e.a.a.Z) {
                arrayList3 = arrayList;
                if (arrayList == null) {
                    arrayList3 = new ArrayList();
                }
                byte[] bArr = bVar.aV.f7674a;
                UUID a2 = h.a(bArr);
                if (a2 == null) {
                    Log.w(j, "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList3.add(new e.a(a2, "video/mp4", bArr));
                }
            }
            i2++;
            arrayList2 = arrayList3;
        }
        if (arrayList == null) {
            return null;
        }
        return new com.anythink.expressad.exoplayer.d.e(arrayList);
    }

    private static com.anythink.expressad.exoplayer.e.a.c a(SparseArray<com.anythink.expressad.exoplayer.e.a.c> sparseArray, int i2) {
        return sparseArray.size() == 1 ? sparseArray.valueAt(0) : (com.anythink.expressad.exoplayer.e.a.c) com.anythink.expressad.exoplayer.k.a.a(sparseArray.get(i2));
    }

    private static c a(SparseArray<c> sparseArray) {
        int size = sparseArray.size();
        c cVar = null;
        long j2 = Long.MAX_VALUE;
        int i2 = 0;
        while (i2 < size) {
            c valueAt = sparseArray.valueAt(i2);
            c cVar2 = cVar;
            long j3 = j2;
            if (valueAt.g != valueAt.b.e) {
                long j4 = valueAt.b.g[valueAt.g];
                cVar2 = cVar;
                j3 = j2;
                if (j4 < j2) {
                    cVar2 = valueAt;
                    j3 = j4;
                }
            }
            i2++;
            cVar = cVar2;
            j2 = j3;
        }
        return cVar;
    }

    private static c a(s sVar, SparseArray<c> sparseArray) {
        sVar.c(8);
        int b2 = com.anythink.expressad.exoplayer.e.a.a.b(sVar.i());
        c b3 = b(sparseArray, sVar.i());
        if (b3 == null) {
            return null;
        }
        if ((b2 & 1) != 0) {
            long n2 = sVar.n();
            b3.b.f7309c = n2;
            b3.b.d = n2;
        }
        com.anythink.expressad.exoplayer.e.a.c cVar = b3.d;
        b3.b.f7308a = new com.anythink.expressad.exoplayer.e.a.c((b2 & 2) != 0 ? sVar.m() - 1 : cVar.f7288a, (b2 & 8) != 0 ? sVar.m() : cVar.b, (b2 & 16) != 0 ? sVar.m() : cVar.f7289c, (b2 & 32) != 0 ? sVar.m() : cVar.d);
        return b3;
    }

    private void a() {
        this.G = 0;
        this.J = 0;
    }

    private void a(long j2) {
        while (!this.D.isEmpty() && this.D.peek().aV == j2) {
            a(this.D.pop());
        }
        a();
    }

    private void a(a.C0125a c0125a) {
        if (c0125a.aU == com.anythink.expressad.exoplayer.e.a.a.G) {
            b(c0125a);
        } else if (c0125a.aU == com.anythink.expressad.exoplayer.e.a.a.P) {
            c(c0125a);
        } else if (this.D.isEmpty()) {
        } else {
            this.D.peek().a(c0125a);
        }
    }

    private static void a(a.C0125a c0125a, SparseArray<c> sparseArray, int i2, byte[] bArr) {
        int size = c0125a.aX.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                return;
            }
            a.C0125a c0125a2 = c0125a.aX.get(i4);
            if (c0125a2.aU == com.anythink.expressad.exoplayer.e.a.a.Q) {
                b(c0125a2, sparseArray, i2, bArr);
            }
            i3 = i4 + 1;
        }
    }

    private static void a(a.C0125a c0125a, c cVar, long j2, int i2) {
        int i3;
        List<a.b> list = c0125a.aW;
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i3 = i6;
            if (i4 >= size) {
                break;
            }
            a.b bVar = list.get(i4);
            int i7 = i5;
            int i8 = i3;
            if (bVar.aU == com.anythink.expressad.exoplayer.e.a.a.E) {
                s sVar = bVar.aV;
                sVar.c(12);
                int m2 = sVar.m();
                i7 = i5;
                i8 = i3;
                if (m2 > 0) {
                    i8 = i3 + m2;
                    i7 = i5 + 1;
                }
            }
            i4++;
            i5 = i7;
            i6 = i8;
        }
        cVar.g = 0;
        cVar.f = 0;
        cVar.e = 0;
        cVar.b.a(i5, i3);
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            a.b bVar2 = list.get(i11);
            int i12 = i9;
            int i13 = i10;
            if (bVar2.aU == com.anythink.expressad.exoplayer.e.a.a.E) {
                i13 = a(cVar, i9, j2, i2, bVar2.aV, i10);
                i12 = i9 + 1;
            }
            i11++;
            i9 = i12;
            i10 = i13;
        }
    }

    private void a(a.b bVar, long j2) {
        long n2;
        long n3;
        if (!this.D.isEmpty()) {
            this.D.peek().a(bVar);
        } else if (bVar.aU == com.anythink.expressad.exoplayer.e.a.a.F) {
            s sVar = bVar.aV;
            sVar.c(8);
            int a2 = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
            sVar.d(4);
            long h2 = sVar.h();
            if (a2 == 0) {
                n2 = sVar.h();
                n3 = sVar.h();
            } else {
                n2 = sVar.n();
                n3 = sVar.n();
            }
            long j3 = j2 + n3;
            long a3 = af.a(n2, 1000000L, h2);
            sVar.d(2);
            int e2 = sVar.e();
            int[] iArr = new int[e2];
            long[] jArr = new long[e2];
            long[] jArr2 = new long[e2];
            long[] jArr3 = new long[e2];
            long j4 = n2;
            long j5 = a3;
            for (int i2 = 0; i2 < e2; i2++) {
                int i3 = sVar.i();
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    throw new t("Unhandled indirect reference");
                }
                long h3 = sVar.h();
                iArr[i2] = i3 & Integer.MAX_VALUE;
                jArr[i2] = j3;
                jArr3[i2] = j5;
                j4 += h3;
                j5 = af.a(j4, 1000000L, h2);
                jArr2[i2] = j5 - jArr3[i2];
                sVar.d(4);
                j3 += iArr[i2];
            }
            Pair create = Pair.create(Long.valueOf(a3), new com.anythink.expressad.exoplayer.e.a(iArr, jArr, jArr2, jArr3));
            this.P = ((Long) create.first).longValue();
            this.V.a((com.anythink.expressad.exoplayer.e.k) create.second);
            this.Y = true;
        } else if (bVar.aU == com.anythink.expressad.exoplayer.e.a.a.aL) {
            s sVar2 = bVar.aV;
            com.anythink.expressad.exoplayer.e.m[] mVarArr = this.W;
            if (mVarArr == null || mVarArr.length == 0) {
                return;
            }
            sVar2.c(12);
            int a4 = sVar2.a();
            sVar2.p();
            sVar2.p();
            long a5 = af.a(sVar2.h(), 1000000L, sVar2.h());
            com.anythink.expressad.exoplayer.e.m[] mVarArr2 = this.W;
            int length = mVarArr2.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length) {
                    break;
                }
                com.anythink.expressad.exoplayer.e.m mVar = mVarArr2[i5];
                sVar2.c(12);
                mVar.a(sVar2, a4);
                i4 = i5 + 1;
            }
            long j6 = this.P;
            if (j6 == com.anythink.expressad.exoplayer.b.b) {
                this.E.addLast(new b(a5, a4));
                this.M += a4;
                return;
            }
            long j7 = j6 + a5;
            ac acVar = this.A;
            long j8 = j7;
            if (acVar != null) {
                j8 = acVar.b(j7);
            }
            com.anythink.expressad.exoplayer.e.m[] mVarArr3 = this.W;
            int length2 = mVarArr3.length;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= length2) {
                    return;
                }
                mVarArr3[i7].a(j8, 1, a4, 0, null);
                i6 = i7 + 1;
            }
        }
    }

    private static void a(k kVar, s sVar, l lVar) {
        int i2;
        int i3 = kVar.d;
        sVar.c(8);
        boolean z = true;
        if ((com.anythink.expressad.exoplayer.e.a.a.b(sVar.i()) & 1) == 1) {
            sVar.d(8);
        }
        int d2 = sVar.d();
        int m2 = sVar.m();
        if (m2 != lVar.f) {
            throw new t("Length mismatch: " + m2 + ", " + lVar.f);
        }
        if (d2 == 0) {
            boolean[] zArr = lVar.n;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                i2 = i5;
                if (i4 >= m2) {
                    break;
                }
                int d3 = sVar.d();
                i5 += d3;
                zArr[i4] = d3 > i3;
                i4++;
            }
        } else {
            if (d2 <= i3) {
                z = false;
            }
            i2 = (d2 * m2) + 0;
            Arrays.fill(lVar.n, 0, m2, z);
        }
        lVar.a(i2);
    }

    private void a(s sVar) {
        com.anythink.expressad.exoplayer.e.m[] mVarArr = this.W;
        if (mVarArr == null || mVarArr.length == 0) {
            return;
        }
        sVar.c(12);
        int a2 = sVar.a();
        sVar.p();
        sVar.p();
        long a3 = af.a(sVar.h(), 1000000L, sVar.h());
        com.anythink.expressad.exoplayer.e.m[] mVarArr2 = this.W;
        int length = mVarArr2.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            com.anythink.expressad.exoplayer.e.m mVar = mVarArr2[i3];
            sVar.c(12);
            mVar.a(sVar, a2);
            i2 = i3 + 1;
        }
        long j2 = this.P;
        if (j2 == com.anythink.expressad.exoplayer.b.b) {
            this.E.addLast(new b(a3, a2));
            this.M += a2;
            return;
        }
        long j3 = j2 + a3;
        ac acVar = this.A;
        long j4 = j3;
        if (acVar != null) {
            j4 = acVar.b(j3);
        }
        com.anythink.expressad.exoplayer.e.m[] mVarArr3 = this.W;
        int length2 = mVarArr3.length;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length2) {
                return;
            }
            mVarArr3[i5].a(j4, 1, a2, 0, null);
            i4 = i5 + 1;
        }
    }

    private static void a(s sVar, int i2, l lVar) {
        sVar.c(i2 + 8);
        int b2 = com.anythink.expressad.exoplayer.e.a.a.b(sVar.i());
        if ((b2 & 1) != 0) {
            throw new t("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (b2 & 2) != 0;
        int m2 = sVar.m();
        if (m2 == lVar.f) {
            Arrays.fill(lVar.n, 0, m2, z);
            lVar.a(sVar.a());
            lVar.a(sVar);
            return;
        }
        throw new t("Length mismatch: " + m2 + ", " + lVar.f);
    }

    private static void a(s sVar, l lVar) {
        sVar.c(8);
        int i2 = sVar.i();
        if ((com.anythink.expressad.exoplayer.e.a.a.b(i2) & 1) == 1) {
            sVar.d(8);
        }
        int m2 = sVar.m();
        if (m2 != 1) {
            throw new t("Unexpected saio entry count: ".concat(String.valueOf(m2)));
        }
        lVar.d += com.anythink.expressad.exoplayer.e.a.a.a(i2) == 0 ? sVar.h() : sVar.n();
    }

    private static void a(s sVar, l lVar, byte[] bArr) {
        sVar.c(8);
        sVar.a(bArr, 0, 16);
        if (Arrays.equals(bArr, l)) {
            a(sVar, 16, lVar);
        }
    }

    private static void a(s sVar, s sVar2, String str, l lVar) {
        byte[] bArr;
        sVar.c(8);
        int i2 = sVar.i();
        if (sVar.i() != k) {
            return;
        }
        if (com.anythink.expressad.exoplayer.e.a.a.a(i2) == 1) {
            sVar.d(4);
        }
        if (sVar.i() != 1) {
            throw new t("Entry count in sbgp != 1 (unsupported).");
        }
        sVar2.c(8);
        int i3 = sVar2.i();
        if (sVar2.i() != k) {
            return;
        }
        int a2 = com.anythink.expressad.exoplayer.e.a.a.a(i3);
        if (a2 == 1) {
            if (sVar2.h() == 0) {
                throw new t("Variable length description in sgpd found (unsupported)");
            }
        } else if (a2 >= 2) {
            sVar2.d(4);
        }
        if (sVar2.h() != 1) {
            throw new t("Entry count in sgpd != 1 (unsupported).");
        }
        sVar2.d(1);
        int d2 = sVar2.d();
        if (sVar2.d() == 1) {
            int d3 = sVar2.d();
            byte[] bArr2 = new byte[16];
            sVar2.a(bArr2, 0, 16);
            if (d3 == 0) {
                int d4 = sVar2.d();
                bArr = new byte[d4];
                sVar2.a(bArr, 0, d4);
            } else {
                bArr = null;
            }
            lVar.m = true;
            lVar.o = new k(true, str, d3, bArr2, (d2 & 240) >> 4, d2 & 15, bArr);
        }
    }

    private static boolean a(int i2) {
        return i2 == com.anythink.expressad.exoplayer.e.a.a.X || i2 == com.anythink.expressad.exoplayer.e.a.a.W || i2 == com.anythink.expressad.exoplayer.e.a.a.H || i2 == com.anythink.expressad.exoplayer.e.a.a.F || i2 == com.anythink.expressad.exoplayer.e.a.a.Y || i2 == com.anythink.expressad.exoplayer.e.a.a.B || i2 == com.anythink.expressad.exoplayer.e.a.a.C || i2 == com.anythink.expressad.exoplayer.e.a.a.T || i2 == com.anythink.expressad.exoplayer.e.a.a.D || i2 == com.anythink.expressad.exoplayer.e.a.a.E || i2 == com.anythink.expressad.exoplayer.e.a.a.Z || i2 == com.anythink.expressad.exoplayer.e.a.a.ah || i2 == com.anythink.expressad.exoplayer.e.a.a.ai || i2 == com.anythink.expressad.exoplayer.e.a.a.am || i2 == com.anythink.expressad.exoplayer.e.a.a.al || i2 == com.anythink.expressad.exoplayer.e.a.a.aj || i2 == com.anythink.expressad.exoplayer.e.a.a.ak || i2 == com.anythink.expressad.exoplayer.e.a.a.V || i2 == com.anythink.expressad.exoplayer.e.a.a.S || i2 == com.anythink.expressad.exoplayer.e.a.a.aL;
    }

    private static Pair<Integer, com.anythink.expressad.exoplayer.e.a.c> b(s sVar) {
        sVar.c(12);
        return Pair.create(Integer.valueOf(sVar.i()), new com.anythink.expressad.exoplayer.e.a.c(sVar.m() - 1, sVar.m(), sVar.m(), sVar.i()));
    }

    private static c b(SparseArray<c> sparseArray, int i2) {
        return sparseArray.size() == 1 ? sparseArray.valueAt(0) : sparseArray.get(i2);
    }

    private void b() {
        int i2;
        if (this.W == null) {
            com.anythink.expressad.exoplayer.e.m[] mVarArr = new com.anythink.expressad.exoplayer.e.m[2];
            this.W = mVarArr;
            com.anythink.expressad.exoplayer.e.m mVar = this.F;
            if (mVar != null) {
                mVarArr[0] = mVar;
                i2 = 1;
            } else {
                i2 = 0;
            }
            int i3 = i2;
            if ((this.s & 4) != 0) {
                this.W[i2] = this.V.a(this.w.size(), 4);
                i3 = i2 + 1;
            }
            com.anythink.expressad.exoplayer.e.m[] mVarArr2 = (com.anythink.expressad.exoplayer.e.m[]) Arrays.copyOf(this.W, i3);
            this.W = mVarArr2;
            int length = mVarArr2.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length) {
                    break;
                }
                mVarArr2[i5].a(m);
                i4 = i5 + 1;
            }
        }
        if (this.X != null) {
            return;
        }
        this.X = new com.anythink.expressad.exoplayer.e.m[this.u.size()];
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= this.X.length) {
                return;
            }
            com.anythink.expressad.exoplayer.e.m a2 = this.V.a(this.w.size() + 1 + i7, 3);
            a2.a(this.u.get(i7));
            this.X[i7] = a2;
            i6 = i7 + 1;
        }
    }

    private void b(long j2) {
        while (!this.E.isEmpty()) {
            b removeFirst = this.E.removeFirst();
            this.M -= removeFirst.b;
            long j3 = removeFirst.f7293a + j2;
            ac acVar = this.A;
            long j4 = j3;
            if (acVar != null) {
                j4 = acVar.b(j3);
            }
            com.anythink.expressad.exoplayer.e.m[] mVarArr = this.W;
            int length = mVarArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < length) {
                    mVarArr[i3].a(j4, 1, removeFirst.b, this.M, null);
                    i2 = i3 + 1;
                }
            }
        }
    }

    private void b(a.C0125a c0125a) {
        com.anythink.expressad.exoplayer.k.a.b(this.t == null, "Unexpected moov box.");
        com.anythink.expressad.exoplayer.d.e eVar = this.v;
        if (eVar == null) {
            eVar = a(c0125a.aW);
        }
        a.C0125a e2 = c0125a.e(com.anythink.expressad.exoplayer.e.a.a.R);
        SparseArray sparseArray = new SparseArray();
        int size = e2.aW.size();
        long j2 = -9223372036854775807L;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                break;
            }
            a.b bVar = e2.aW.get(i3);
            if (bVar.aU == com.anythink.expressad.exoplayer.e.a.a.D) {
                Pair<Integer, com.anythink.expressad.exoplayer.e.a.c> b2 = b(bVar.aV);
                sparseArray.put(b2.first.intValue(), b2.second);
            } else if (bVar.aU == com.anythink.expressad.exoplayer.e.a.a.S) {
                j2 = c(bVar.aV);
            }
            i2 = i3 + 1;
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = c0125a.aX.size();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= size2) {
                break;
            }
            a.C0125a c0125a2 = c0125a.aX.get(i5);
            if (c0125a2.aU == com.anythink.expressad.exoplayer.e.a.a.I) {
                j a2 = com.anythink.expressad.exoplayer.e.a.b.a(c0125a2, c0125a.d(com.anythink.expressad.exoplayer.e.a.a.H), j2, eVar, (this.s & 16) != 0, false);
                if (a2 != null) {
                    sparseArray2.put(a2.f7305c, a2);
                }
            }
            i4 = i5 + 1;
        }
        int size3 = sparseArray2.size();
        if (this.w.size() == 0) {
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= size3) {
                    b();
                    this.V.c_();
                    return;
                }
                j jVar = (j) sparseArray2.valueAt(i7);
                c cVar = new c(this.V.a(i7, jVar.d));
                cVar.a(jVar, a(sparseArray, jVar.f7305c));
                this.w.put(jVar.f7305c, cVar);
                this.O = Math.max(this.O, jVar.g);
                i6 = i7 + 1;
            }
        } else {
            com.anythink.expressad.exoplayer.k.a.b(this.w.size() == size3);
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= size3) {
                    return;
                }
                j jVar2 = (j) sparseArray2.valueAt(i9);
                this.w.get(jVar2.f7305c).a(jVar2, a(sparseArray, jVar2.f7305c));
                i8 = i9 + 1;
            }
        }
    }

    private static void b(a.C0125a c0125a, SparseArray<c> sparseArray, int i2, byte[] bArr) {
        c a2 = a(c0125a.d(com.anythink.expressad.exoplayer.e.a.a.C).aV, sparseArray);
        if (a2 == null) {
            return;
        }
        l lVar = a2.b;
        long j2 = lVar.s;
        a2.a();
        long j3 = j2;
        if (c0125a.d(com.anythink.expressad.exoplayer.e.a.a.B) != null) {
            j3 = j2;
            if ((i2 & 2) == 0) {
                j3 = d(c0125a.d(com.anythink.expressad.exoplayer.e.a.a.B).aV);
            }
        }
        a(c0125a, a2, j3, i2);
        k a3 = a2.f7295c.a(lVar.f7308a.f7288a);
        a.b d2 = c0125a.d(com.anythink.expressad.exoplayer.e.a.a.ah);
        if (d2 != null) {
            a(a3, d2.aV, lVar);
        }
        a.b d3 = c0125a.d(com.anythink.expressad.exoplayer.e.a.a.ai);
        if (d3 != null) {
            a(d3.aV, lVar);
        }
        a.b d4 = c0125a.d(com.anythink.expressad.exoplayer.e.a.a.am);
        if (d4 != null) {
            a(d4.aV, 0, lVar);
        }
        a.b d5 = c0125a.d(com.anythink.expressad.exoplayer.e.a.a.aj);
        a.b d6 = c0125a.d(com.anythink.expressad.exoplayer.e.a.a.ak);
        if (d5 != null && d6 != null) {
            a(d5.aV, d6.aV, a3 != null ? a3.b : null, lVar);
        }
        int size = c0125a.aW.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.b bVar = c0125a.aW.get(i3);
            if (bVar.aU == com.anythink.expressad.exoplayer.e.a.a.al) {
                a(bVar.aV, lVar, bArr);
            }
        }
    }

    private static void b(s sVar, l lVar) {
        a(sVar, 0, lVar);
    }

    private static boolean b(int i2) {
        return i2 == com.anythink.expressad.exoplayer.e.a.a.G || i2 == com.anythink.expressad.exoplayer.e.a.a.I || i2 == com.anythink.expressad.exoplayer.e.a.a.J || i2 == com.anythink.expressad.exoplayer.e.a.a.K || i2 == com.anythink.expressad.exoplayer.e.a.a.L || i2 == com.anythink.expressad.exoplayer.e.a.a.P || i2 == com.anythink.expressad.exoplayer.e.a.a.Q || i2 == com.anythink.expressad.exoplayer.e.a.a.R || i2 == com.anythink.expressad.exoplayer.e.a.a.U;
    }

    private boolean b(com.anythink.expressad.exoplayer.e.f fVar) {
        if (this.J == 0) {
            if (!fVar.a(this.B.f7674a, 0, 8, true)) {
                return false;
            }
            this.J = 8;
            this.B.c(0);
            this.I = this.B.h();
            this.H = this.B.i();
        }
        long j2 = this.I;
        if (j2 == 1) {
            fVar.b(this.B.f7674a, 8, 8);
            this.J += 8;
            this.I = this.B.n();
        } else if (j2 == 0) {
            long d2 = fVar.d();
            long j3 = d2;
            if (d2 == -1) {
                j3 = d2;
                if (!this.D.isEmpty()) {
                    j3 = this.D.peek().aV;
                }
            }
            if (j3 != -1) {
                this.I = (j3 - fVar.c()) + this.J;
            }
        }
        if (this.I >= this.J) {
            long c2 = fVar.c() - this.J;
            if (this.H == com.anythink.expressad.exoplayer.e.a.a.P) {
                int size = this.w.size();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= size) {
                        break;
                    }
                    l lVar = this.w.valueAt(i3).b;
                    lVar.b = c2;
                    lVar.d = c2;
                    lVar.f7309c = c2;
                    i2 = i3 + 1;
                }
            }
            if (this.H == com.anythink.expressad.exoplayer.e.a.a.m) {
                this.Q = null;
                this.L = this.I + c2;
                if (!this.Y) {
                    this.V.a(new k.b(this.O, c2));
                    this.Y = true;
                }
                this.G = 2;
                return true;
            }
            int i4 = this.H;
            if (i4 == com.anythink.expressad.exoplayer.e.a.a.G || i4 == com.anythink.expressad.exoplayer.e.a.a.I || i4 == com.anythink.expressad.exoplayer.e.a.a.J || i4 == com.anythink.expressad.exoplayer.e.a.a.K || i4 == com.anythink.expressad.exoplayer.e.a.a.L || i4 == com.anythink.expressad.exoplayer.e.a.a.P || i4 == com.anythink.expressad.exoplayer.e.a.a.Q || i4 == com.anythink.expressad.exoplayer.e.a.a.R || i4 == com.anythink.expressad.exoplayer.e.a.a.U) {
                long c3 = (fVar.c() + this.I) - 8;
                this.D.push(new a.C0125a(this.H, c3));
                if (this.I == this.J) {
                    a(c3);
                    return true;
                }
                a();
                return true;
            }
            int i5 = this.H;
            if (!(i5 == com.anythink.expressad.exoplayer.e.a.a.X || i5 == com.anythink.expressad.exoplayer.e.a.a.W || i5 == com.anythink.expressad.exoplayer.e.a.a.H || i5 == com.anythink.expressad.exoplayer.e.a.a.F || i5 == com.anythink.expressad.exoplayer.e.a.a.Y || i5 == com.anythink.expressad.exoplayer.e.a.a.B || i5 == com.anythink.expressad.exoplayer.e.a.a.C || i5 == com.anythink.expressad.exoplayer.e.a.a.T || i5 == com.anythink.expressad.exoplayer.e.a.a.D || i5 == com.anythink.expressad.exoplayer.e.a.a.E || i5 == com.anythink.expressad.exoplayer.e.a.a.Z || i5 == com.anythink.expressad.exoplayer.e.a.a.ah || i5 == com.anythink.expressad.exoplayer.e.a.a.ai || i5 == com.anythink.expressad.exoplayer.e.a.a.am || i5 == com.anythink.expressad.exoplayer.e.a.a.al || i5 == com.anythink.expressad.exoplayer.e.a.a.aj || i5 == com.anythink.expressad.exoplayer.e.a.a.ak || i5 == com.anythink.expressad.exoplayer.e.a.a.V || i5 == com.anythink.expressad.exoplayer.e.a.a.S || i5 == com.anythink.expressad.exoplayer.e.a.a.aL)) {
                if (this.I <= 2147483647L) {
                    this.K = null;
                    this.G = 1;
                    return true;
                }
                throw new t("Skipping atom with length > 2147483647 (unsupported).");
            } else if (this.J == 8) {
                long j4 = this.I;
                if (j4 <= 2147483647L) {
                    this.K = new s((int) j4);
                    System.arraycopy((Object) this.B.f7674a, 0, (Object) this.K.f7674a, 0, 8);
                    this.G = 1;
                    return true;
                }
                throw new t("Leaf atom with length > 2147483647 (unsupported).");
            } else {
                throw new t("Leaf atom defines extended atom size (unsupported).");
            }
        }
        throw new t("Atom size less than header length (unsupported).");
    }

    private static long c(s sVar) {
        sVar.c(8);
        return com.anythink.expressad.exoplayer.e.a.a.a(sVar.i()) == 0 ? sVar.h() : sVar.n();
    }

    private void c(a.C0125a c0125a) {
        a(c0125a, this.w, this.s, this.C);
        com.anythink.expressad.exoplayer.d.e a2 = this.v != null ? null : a(c0125a.aW);
        if (a2 != null) {
            int size = this.w.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    break;
                }
                this.w.valueAt(i3).a(a2);
                i2 = i3 + 1;
            }
        }
        if (this.N == com.anythink.expressad.exoplayer.b.b) {
            return;
        }
        int size2 = this.w.size();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= size2) {
                this.N = com.anythink.expressad.exoplayer.b.b;
                return;
            } else {
                this.w.valueAt(i5).a(this.N);
                i4 = i5 + 1;
            }
        }
    }

    private void c(com.anythink.expressad.exoplayer.e.f fVar) {
        long n2;
        long n3;
        int i2 = ((int) this.I) - this.J;
        s sVar = this.K;
        if (sVar != null) {
            fVar.b(sVar.f7674a, 8, i2);
            a.b bVar = new a.b(this.H, this.K);
            long c2 = fVar.c();
            if (!this.D.isEmpty()) {
                this.D.peek().a(bVar);
            } else if (bVar.aU == com.anythink.expressad.exoplayer.e.a.a.F) {
                s sVar2 = bVar.aV;
                sVar2.c(8);
                int a2 = com.anythink.expressad.exoplayer.e.a.a.a(sVar2.i());
                sVar2.d(4);
                long h2 = sVar2.h();
                if (a2 == 0) {
                    n2 = sVar2.h();
                    n3 = sVar2.h();
                } else {
                    n2 = sVar2.n();
                    n3 = sVar2.n();
                }
                long j2 = c2 + n3;
                long a3 = af.a(n2, 1000000L, h2);
                sVar2.d(2);
                int e2 = sVar2.e();
                int[] iArr = new int[e2];
                long[] jArr = new long[e2];
                long[] jArr2 = new long[e2];
                long[] jArr3 = new long[e2];
                long j3 = a3;
                long j4 = n2;
                long j5 = j2;
                for (int i3 = 0; i3 < e2; i3++) {
                    int i4 = sVar2.i();
                    if ((i4 & Integer.MIN_VALUE) != 0) {
                        throw new t("Unhandled indirect reference");
                    }
                    long h3 = sVar2.h();
                    iArr[i3] = i4 & Integer.MAX_VALUE;
                    jArr[i3] = j5;
                    jArr3[i3] = j3;
                    j4 += h3;
                    j3 = af.a(j4, 1000000L, h2);
                    jArr2[i3] = j3 - jArr3[i3];
                    sVar2.d(4);
                    j5 += iArr[i3];
                }
                Pair create = Pair.create(Long.valueOf(a3), new com.anythink.expressad.exoplayer.e.a(iArr, jArr, jArr2, jArr3));
                this.P = ((Long) create.first).longValue();
                this.V.a((com.anythink.expressad.exoplayer.e.k) create.second);
                this.Y = true;
            } else if (bVar.aU == com.anythink.expressad.exoplayer.e.a.a.aL) {
                s sVar3 = bVar.aV;
                com.anythink.expressad.exoplayer.e.m[] mVarArr = this.W;
                if (mVarArr != null && mVarArr.length != 0) {
                    sVar3.c(12);
                    int a4 = sVar3.a();
                    sVar3.p();
                    sVar3.p();
                    long a5 = af.a(sVar3.h(), 1000000L, sVar3.h());
                    com.anythink.expressad.exoplayer.e.m[] mVarArr2 = this.W;
                    int length = mVarArr2.length;
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= length) {
                            break;
                        }
                        com.anythink.expressad.exoplayer.e.m mVar = mVarArr2[i6];
                        sVar3.c(12);
                        mVar.a(sVar3, a4);
                        i5 = i6 + 1;
                    }
                    long j6 = this.P;
                    if (j6 != com.anythink.expressad.exoplayer.b.b) {
                        long j7 = j6 + a5;
                        ac acVar = this.A;
                        long j8 = j7;
                        if (acVar != null) {
                            j8 = acVar.b(j7);
                        }
                        com.anythink.expressad.exoplayer.e.m[] mVarArr3 = this.W;
                        int length2 = mVarArr3.length;
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            if (i8 >= length2) {
                                break;
                            }
                            mVarArr3[i8].a(j8, 1, a4, 0, null);
                            i7 = i8 + 1;
                        }
                    } else {
                        this.E.addLast(new b(a5, a4));
                        this.M += a4;
                    }
                }
            }
        } else {
            fVar.c(i2);
        }
        a(fVar.c());
    }

    private static long d(s sVar) {
        sVar.c(8);
        return com.anythink.expressad.exoplayer.e.a.a.a(sVar.i()) == 1 ? sVar.n() : sVar.h();
    }

    private void d(com.anythink.expressad.exoplayer.e.f fVar) {
        int size = this.w.size();
        c cVar = null;
        long j2 = Long.MAX_VALUE;
        int i2 = 0;
        while (i2 < size) {
            l lVar = this.w.valueAt(i2).b;
            c cVar2 = cVar;
            long j3 = j2;
            if (lVar.r) {
                cVar2 = cVar;
                j3 = j2;
                if (lVar.d < j2) {
                    j3 = lVar.d;
                    cVar2 = this.w.valueAt(i2);
                }
            }
            i2++;
            cVar = cVar2;
            j2 = j3;
        }
        if (cVar == null) {
            this.G = 3;
            return;
        }
        int c2 = (int) (j2 - fVar.c());
        if (c2 < 0) {
            throw new t("Offset to encryption data was negative.");
        }
        fVar.c(c2);
        l lVar2 = cVar.b;
        fVar.b(lVar2.q.f7674a, 0, lVar2.p);
        lVar2.q.c(0);
        lVar2.r = false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private boolean e(com.anythink.expressad.exoplayer.e.f fVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.anythink.expressad.exoplayer.e.e
    public final int a(com.anythink.expressad.exoplayer.e.f fVar, com.anythink.expressad.exoplayer.e.j jVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void a(long j2, long j3) {
        int size = this.w.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                this.E.clear();
                this.M = 0;
                this.N = j3;
                this.D.clear();
                a();
                return;
            }
            this.w.valueAt(i3).a();
            i2 = i3 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void a(com.anythink.expressad.exoplayer.e.g gVar) {
        this.V = gVar;
        j jVar = this.t;
        if (jVar != null) {
            c cVar = new c(gVar.a(0, jVar.d));
            cVar.a(this.t, new com.anythink.expressad.exoplayer.e.a.c(0, 0, 0, 0));
            this.w.put(0, cVar);
            b();
            this.V.c_();
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final boolean a(com.anythink.expressad.exoplayer.e.f fVar) {
        return i.a(fVar);
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void c() {
    }
}
