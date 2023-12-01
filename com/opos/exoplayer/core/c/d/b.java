package com.opos.exoplayer.core.c.d;

import android.util.Pair;
import android.util.SparseArray;
import com.anythink.expressad.exoplayer.k.o;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.d.g;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.s;
import com.opos.exoplayer.core.i.u;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/b.class */
public final class b implements com.opos.exoplayer.core.c.e {

    /* renamed from: a  reason: collision with root package name */
    public static final com.opos.exoplayer.core.c.h f25113a = new com.opos.exoplayer.core.c.h() { // from class: com.opos.exoplayer.core.c.d.b.1
        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new b()};
        }
    };
    private static final int b = u.f("seig");

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f25114c = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final Format d = Format.a((String) null, o.ai, Long.MAX_VALUE);
    private int A;
    private long B;
    private long C;
    private C0652b D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private com.opos.exoplayer.core.c.g I;
    private n[] J;
    private n[] K;
    private boolean L;
    private final int e;
    private final e f;
    private final List<Format> g;
    private final DrmInitData h;
    private final SparseArray<C0652b> i;
    private final com.opos.exoplayer.core.i.m j;
    private final com.opos.exoplayer.core.i.m k;
    private final com.opos.exoplayer.core.i.m l;
    private final com.opos.exoplayer.core.i.m m;
    private final com.opos.exoplayer.core.i.m n;
    private final s o;
    private final com.opos.exoplayer.core.i.m p;
    private final byte[] q;
    private final Stack<g.a> r;
    private final ArrayDeque<a> s;
    private final n t;
    private int u;
    private int v;
    private long w;
    private int x;
    private com.opos.exoplayer.core.i.m y;
    private long z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f25115a;
        public final int b;

        public a(long j, int i) {
            this.f25115a = j;
            this.b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.exoplayer.core.c.d.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/b$b.class */
    public static final class C0652b {

        /* renamed from: a  reason: collision with root package name */
        public final l f25116a = new l();
        public final n b;

        /* renamed from: c  reason: collision with root package name */
        public e f25117c;
        public i d;
        public int e;
        public int f;
        public int g;

        public C0652b(n nVar) {
            this.b = nVar;
        }

        public void a() {
            this.f25116a.a();
            this.e = 0;
            this.g = 0;
            this.f = 0;
        }

        public void a(e eVar, i iVar) {
            this.f25117c = (e) com.opos.exoplayer.core.i.a.a(eVar);
            this.d = (i) com.opos.exoplayer.core.i.a.a(iVar);
            this.b.a(eVar.f);
            a();
        }

        public void a(DrmInitData drmInitData) {
            f a2 = this.f25117c.a(this.f25116a.f25148a.f25143a);
            this.b.a(this.f25117c.f.a(drmInitData.a(a2 != null ? a2.b : null)));
        }
    }

    public b() {
        this(0);
    }

    public b(int i) {
        this(i, null);
    }

    public b(int i, s sVar) {
        this(i, sVar, null, null);
    }

    public b(int i, s sVar, e eVar, DrmInitData drmInitData) {
        this(i, sVar, eVar, drmInitData, Collections.emptyList());
    }

    public b(int i, s sVar, e eVar, DrmInitData drmInitData, List<Format> list) {
        this(i, sVar, eVar, drmInitData, list, null);
    }

    public b(int i, s sVar, e eVar, DrmInitData drmInitData, List<Format> list, n nVar) {
        this.e = i | (eVar != null ? 8 : 0);
        this.o = sVar;
        this.f = eVar;
        this.h = drmInitData;
        this.g = Collections.unmodifiableList(list);
        this.t = nVar;
        this.p = new com.opos.exoplayer.core.i.m(16);
        this.j = new com.opos.exoplayer.core.i.m(com.opos.exoplayer.core.i.k.f25488a);
        this.k = new com.opos.exoplayer.core.i.m(5);
        this.l = new com.opos.exoplayer.core.i.m();
        this.m = new com.opos.exoplayer.core.i.m(1);
        this.n = new com.opos.exoplayer.core.i.m();
        this.q = new byte[16];
        this.r = new Stack<>();
        this.s = new ArrayDeque<>();
        this.i = new SparseArray<>();
        this.B = com.anythink.expressad.exoplayer.b.b;
        this.C = com.anythink.expressad.exoplayer.b.b;
        a();
    }

    private int a(C0652b c0652b) {
        com.opos.exoplayer.core.i.m mVar;
        int length;
        l lVar = c0652b.f25116a;
        f a2 = lVar.o != null ? lVar.o : c0652b.f25117c.a(lVar.f25148a.f25143a);
        if (a2.d != 0) {
            com.opos.exoplayer.core.i.m mVar2 = lVar.q;
            length = a2.d;
            mVar = mVar2;
        } else {
            byte[] bArr = a2.e;
            this.n.a(bArr, bArr.length);
            mVar = this.n;
            length = bArr.length;
        }
        boolean z = lVar.n[c0652b.e];
        this.m.f25496a[0] = (byte) ((z ? 128 : 0) | length);
        this.m.c(0);
        n nVar = c0652b.b;
        nVar.a(this.m, 1);
        nVar.a(mVar, length);
        if (z) {
            com.opos.exoplayer.core.i.m mVar3 = lVar.q;
            int h = mVar3.h();
            mVar3.d(-2);
            int i = (h * 6) + 2;
            nVar.a(mVar3, i);
            return length + 1 + i;
        }
        return length + 1;
    }

    private static int a(C0652b c0652b, int i, long j, int i2, com.opos.exoplayer.core.i.m mVar, int i3) {
        mVar.c(8);
        int b2 = g.b(mVar.o());
        e eVar = c0652b.f25117c;
        l lVar = c0652b.f25116a;
        i iVar = lVar.f25148a;
        lVar.h[i] = mVar.u();
        lVar.g[i] = lVar.f25149c;
        if ((b2 & 1) != 0) {
            long[] jArr = lVar.g;
            jArr[i] = jArr[i] + mVar.o();
        }
        boolean z = (b2 & 4) != 0;
        int i4 = iVar.d;
        if (z) {
            i4 = mVar.u();
        }
        boolean z2 = (b2 & 256) != 0;
        boolean z3 = (b2 & 512) != 0;
        boolean z4 = (b2 & 1024) != 0;
        boolean z5 = (b2 & 2048) != 0;
        long j2 = 0;
        if (eVar.h != null) {
            j2 = 0;
            if (eVar.h.length == 1) {
                j2 = 0;
                if (eVar.h[0] == 0) {
                    j2 = u.d(eVar.i[0], 1000L, eVar.f25125c);
                }
            }
        }
        int[] iArr = lVar.i;
        int[] iArr2 = lVar.j;
        long[] jArr2 = lVar.k;
        boolean[] zArr = lVar.l;
        boolean z6 = eVar.b == 2 && (i2 & 1) != 0;
        int i5 = i3 + lVar.h[i];
        long j3 = eVar.f25125c;
        if (i > 0) {
            j = lVar.s;
        }
        int i6 = i3;
        while (i6 < i5) {
            int u = z2 ? mVar.u() : iVar.b;
            int u2 = z3 ? mVar.u() : iVar.f25144c;
            int o = (i6 == 0 && z) ? i4 : z4 ? mVar.o() : iVar.d;
            if (z5) {
                iArr2[i6] = (int) ((mVar.o() * 1000) / j3);
            } else {
                iArr2[i6] = 0;
            }
            jArr2[i6] = u.d(j, 1000L, j3) - j2;
            iArr[i6] = u2;
            zArr[i6] = ((o >> 16) & 1) == 0 && (!z6 || i6 == 0);
            j += u;
            i6++;
        }
        lVar.s = j;
        return i5;
    }

    private static Pair<Long, com.opos.exoplayer.core.c.a> a(com.opos.exoplayer.core.i.m mVar, long j) {
        long w;
        long w2;
        mVar.c(8);
        int a2 = g.a(mVar.o());
        mVar.d(4);
        long m = mVar.m();
        if (a2 == 0) {
            w = mVar.m();
            w2 = mVar.m();
        } else {
            w = mVar.w();
            w2 = mVar.w();
        }
        long j2 = w2 + j;
        long d2 = u.d(w, 1000000L, m);
        mVar.d(2);
        int h = mVar.h();
        int[] iArr = new int[h];
        long[] jArr = new long[h];
        long[] jArr2 = new long[h];
        long[] jArr3 = new long[h];
        long j3 = d2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= h) {
                return Pair.create(Long.valueOf(d2), new com.opos.exoplayer.core.c.a(iArr, jArr, jArr2, jArr3));
            }
            int o = mVar.o();
            if ((o & Integer.MIN_VALUE) != 0) {
                throw new com.opos.exoplayer.core.o("Unhandled indirect reference");
            }
            long m2 = mVar.m();
            iArr[i2] = o & Integer.MAX_VALUE;
            jArr[i2] = j2;
            jArr3[i2] = j3;
            w += m2;
            j3 = u.d(w, 1000000L, m);
            jArr2[i2] = j3 - jArr3[i2];
            mVar.d(4);
            j2 += iArr[i2];
            i = i2 + 1;
        }
    }

    private static C0652b a(SparseArray<C0652b> sparseArray) {
        long j;
        int size = sparseArray.size();
        C0652b c0652b = null;
        long j2 = Long.MAX_VALUE;
        int i = 0;
        while (i < size) {
            C0652b valueAt = sparseArray.valueAt(i);
            if (valueAt.g == valueAt.f25116a.e) {
                j = j2;
            } else {
                long j3 = valueAt.f25116a.g[valueAt.g];
                j = j2;
                if (j3 < j2) {
                    c0652b = valueAt;
                    j = j3;
                }
            }
            i++;
            j2 = j;
        }
        return c0652b;
    }

    private static C0652b a(com.opos.exoplayer.core.i.m mVar, SparseArray<C0652b> sparseArray, int i) {
        mVar.c(8);
        int b2 = g.b(mVar.o());
        C0652b c0652b = sparseArray.get((i & 8) == 0 ? mVar.o() : 0);
        if (c0652b == null) {
            return null;
        }
        if ((b2 & 1) != 0) {
            long w = mVar.w();
            c0652b.f25116a.f25149c = w;
            c0652b.f25116a.d = w;
        }
        i iVar = c0652b.d;
        c0652b.f25116a.f25148a = new i((b2 & 2) != 0 ? mVar.u() - 1 : iVar.f25143a, (b2 & 8) != 0 ? mVar.u() : iVar.b, (b2 & 16) != 0 ? mVar.u() : iVar.f25144c, (b2 & 32) != 0 ? mVar.u() : iVar.d);
        return c0652b;
    }

    private static DrmInitData a(List<g.b> list) {
        ArrayList arrayList;
        int size = list.size();
        int i = 0;
        ArrayList arrayList2 = null;
        while (true) {
            arrayList = arrayList2;
            if (i >= size) {
                break;
            }
            g.b bVar = list.get(i);
            ArrayList arrayList3 = arrayList;
            if (bVar.aP == g.U) {
                arrayList3 = arrayList;
                if (arrayList == null) {
                    arrayList3 = new ArrayList();
                }
                byte[] bArr = bVar.aQ.f25496a;
                UUID a2 = d.a(bArr);
                if (a2 == null) {
                    com.opos.cmn.an.f.a.c("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList3.add(new DrmInitData.SchemeData(a2, "video/mp4", bArr));
                }
            }
            i++;
            arrayList2 = arrayList3;
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private void a() {
        this.u = 0;
        this.x = 0;
    }

    private void a(long j) {
        while (!this.r.isEmpty() && this.r.peek().aQ == j) {
            a(this.r.pop());
        }
        a();
    }

    private static void a(f fVar, com.opos.exoplayer.core.i.m mVar, l lVar) {
        int i;
        int i2 = fVar.d;
        mVar.c(8);
        boolean z = true;
        if ((g.b(mVar.o()) & 1) == 1) {
            mVar.d(8);
        }
        int g = mVar.g();
        int u = mVar.u();
        if (u != lVar.f) {
            throw new com.opos.exoplayer.core.o("Length mismatch: " + u + ", " + lVar.f);
        }
        if (g == 0) {
            boolean[] zArr = lVar.n;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                i = i3;
                if (i4 >= u) {
                    break;
                }
                int g2 = mVar.g();
                zArr[i4] = g2 > i2;
                i4++;
                i3 += g2;
            }
        } else {
            if (g <= i2) {
                z = false;
            }
            i = (g * u) + 0;
            Arrays.fill(lVar.n, 0, u, z);
        }
        lVar.a(i);
    }

    private void a(g.a aVar) {
        if (aVar.aP == g.B) {
            b(aVar);
        } else if (aVar.aP == g.K) {
            c(aVar);
        } else if (this.r.isEmpty()) {
        } else {
            this.r.peek().a(aVar);
        }
    }

    private static void a(g.a aVar, SparseArray<C0652b> sparseArray, int i, byte[] bArr) {
        int size = aVar.aS.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            g.a aVar2 = aVar.aS.get(i3);
            if (aVar2.aP == g.L) {
                b(aVar2, sparseArray, i, bArr);
            }
            i2 = i3 + 1;
        }
    }

    private static void a(g.a aVar, C0652b c0652b, long j, int i) {
        int i2;
        List<g.b> list = aVar.aR;
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i2 = i5;
            if (i3 >= size) {
                break;
            }
            g.b bVar = list.get(i3);
            int i6 = i4;
            int i7 = i2;
            if (bVar.aP == g.z) {
                com.opos.exoplayer.core.i.m mVar = bVar.aQ;
                mVar.c(12);
                int u = mVar.u();
                i6 = i4;
                i7 = i2;
                if (u > 0) {
                    i7 = i2 + u;
                    i6 = i4 + 1;
                }
            }
            i3++;
            i4 = i6;
            i5 = i7;
        }
        c0652b.g = 0;
        c0652b.f = 0;
        c0652b.e = 0;
        c0652b.f25116a.a(i4, i2);
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i10 < size) {
            g.b bVar2 = list.get(i10);
            int i11 = i8;
            int i12 = i9;
            if (bVar2.aP == g.z) {
                i11 = a(c0652b, i9, j, i, bVar2.aQ, i8);
                i12 = i9 + 1;
            }
            i10++;
            i8 = i11;
            i9 = i12;
        }
    }

    private void a(g.b bVar, long j) {
        if (!this.r.isEmpty()) {
            this.r.peek().a(bVar);
        } else if (bVar.aP != g.A) {
            if (bVar.aP == g.aG) {
                a(bVar.aQ);
            }
        } else {
            Pair<Long, com.opos.exoplayer.core.c.a> a2 = a(bVar.aQ, j);
            this.C = a2.first.longValue();
            this.I.a(a2.second);
            this.L = true;
        }
    }

    private void a(com.opos.exoplayer.core.i.m mVar) {
        n[] nVarArr = this.J;
        if (nVarArr == null || nVarArr.length == 0) {
            return;
        }
        mVar.c(12);
        int b2 = mVar.b();
        mVar.y();
        mVar.y();
        long d2 = u.d(mVar.m(), 1000000L, mVar.m());
        n[] nVarArr2 = this.J;
        int length = nVarArr2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            n nVar = nVarArr2[i2];
            mVar.c(12);
            nVar.a(mVar, b2);
            i = i2 + 1;
        }
        if (this.C == com.anythink.expressad.exoplayer.b.b) {
            this.s.addLast(new a(d2, b2));
            this.A += b2;
            return;
        }
        n[] nVarArr3 = this.J;
        int length2 = nVarArr3.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                return;
            }
            nVarArr3[i4].a(this.C + d2, 1, b2, 0, null);
            i3 = i4 + 1;
        }
    }

    private static void a(com.opos.exoplayer.core.i.m mVar, int i, l lVar) {
        mVar.c(i + 8);
        int b2 = g.b(mVar.o());
        if ((b2 & 1) != 0) {
            throw new com.opos.exoplayer.core.o("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (b2 & 2) != 0;
        int u = mVar.u();
        if (u == lVar.f) {
            Arrays.fill(lVar.n, 0, u, z);
            lVar.a(mVar.b());
            lVar.a(mVar);
            return;
        }
        throw new com.opos.exoplayer.core.o("Length mismatch: " + u + ", " + lVar.f);
    }

    private static void a(com.opos.exoplayer.core.i.m mVar, l lVar) {
        mVar.c(8);
        int o = mVar.o();
        if ((g.b(o) & 1) == 1) {
            mVar.d(8);
        }
        int u = mVar.u();
        if (u == 1) {
            int a2 = g.a(o);
            lVar.d = (a2 == 0 ? mVar.m() : mVar.w()) + lVar.d;
            return;
        }
        throw new com.opos.exoplayer.core.o("Unexpected saio entry count: " + u);
    }

    private static void a(com.opos.exoplayer.core.i.m mVar, l lVar, byte[] bArr) {
        mVar.c(8);
        mVar.a(bArr, 0, 16);
        if (Arrays.equals(bArr, f25114c)) {
            a(mVar, 16, lVar);
        }
    }

    private static void a(com.opos.exoplayer.core.i.m mVar, com.opos.exoplayer.core.i.m mVar2, String str, l lVar) {
        byte[] bArr;
        mVar.c(8);
        int o = mVar.o();
        if (mVar.o() != b) {
            return;
        }
        if (g.a(o) == 1) {
            mVar.d(4);
        }
        if (mVar.o() != 1) {
            throw new com.opos.exoplayer.core.o("Entry count in sbgp != 1 (unsupported).");
        }
        mVar2.c(8);
        int o2 = mVar2.o();
        if (mVar2.o() == b) {
            int a2 = g.a(o2);
            if (a2 == 1) {
                if (mVar2.m() == 0) {
                    throw new com.opos.exoplayer.core.o("Variable length description in sgpd found (unsupported)");
                }
            } else if (a2 >= 2) {
                mVar2.d(4);
            }
            if (mVar2.m() != 1) {
                throw new com.opos.exoplayer.core.o("Entry count in sgpd != 1 (unsupported).");
            }
            mVar2.d(1);
            int g = mVar2.g();
            boolean z = mVar2.g() == 1;
            if (z) {
                int g2 = mVar2.g();
                byte[] bArr2 = new byte[16];
                mVar2.a(bArr2, 0, 16);
                if (z && g2 == 0) {
                    int g3 = mVar2.g();
                    bArr = new byte[g3];
                    mVar2.a(bArr, 0, g3);
                } else {
                    bArr = null;
                }
                lVar.m = true;
                lVar.o = new f(z, str, g2, bArr2, (g & 240) >> 4, g & 15, bArr);
            }
        }
    }

    private static boolean a(int i) {
        return i == g.S || i == g.R || i == g.C || i == g.A || i == g.T || i == g.w || i == g.x || i == g.O || i == g.y || i == g.z || i == g.U || i == g.ac || i == g.ad || i == g.ah || i == g.ag || i == g.ae || i == g.af || i == g.Q || i == g.N || i == g.aG;
    }

    private static Pair<Integer, i> b(com.opos.exoplayer.core.i.m mVar) {
        mVar.c(12);
        return Pair.create(Integer.valueOf(mVar.o()), new i(mVar.u() - 1, mVar.u(), mVar.u(), mVar.o()));
    }

    private void b() {
        int i;
        if (this.J == null) {
            n[] nVarArr = new n[2];
            this.J = nVarArr;
            n nVar = this.t;
            if (nVar != null) {
                nVarArr[0] = nVar;
                i = 1;
            } else {
                i = 0;
            }
            int i2 = i;
            if ((this.e & 4) != 0) {
                this.J[i] = this.I.a(this.i.size(), 4);
                i2 = i + 1;
            }
            n[] nVarArr2 = (n[]) Arrays.copyOf(this.J, i2);
            this.J = nVarArr2;
            int length = nVarArr2.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    break;
                }
                nVarArr2[i4].a(d);
                i3 = i4 + 1;
            }
        }
        if (this.K != null) {
            return;
        }
        this.K = new n[this.g.size()];
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.K.length) {
                return;
            }
            n a2 = this.I.a(this.i.size() + 1 + i6, 3);
            a2.a(this.g.get(i6));
            this.K[i6] = a2;
            i5 = i6 + 1;
        }
    }

    private void b(long j) {
        while (!this.s.isEmpty()) {
            a removeFirst = this.s.removeFirst();
            this.A -= removeFirst.b;
            n[] nVarArr = this.J;
            int length = nVarArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    nVarArr[i2].a(removeFirst.f25115a + j, 1, removeFirst.b, this.A, null);
                    i = i2 + 1;
                }
            }
        }
    }

    private void b(g.a aVar) {
        com.opos.exoplayer.core.i.a.b(this.f == null, "Unexpected moov box.");
        DrmInitData drmInitData = this.h;
        if (drmInitData == null) {
            drmInitData = a(aVar.aR);
        }
        g.a e = aVar.e(g.M);
        SparseArray sparseArray = new SparseArray();
        int size = e.aR.size();
        long j = -9223372036854775807L;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            g.b bVar = e.aR.get(i2);
            if (bVar.aP == g.y) {
                Pair<Integer, i> b2 = b(bVar.aQ);
                sparseArray.put(b2.first.intValue(), b2.second);
            } else if (bVar.aP == g.N) {
                j = c(bVar.aQ);
            }
            i = i2 + 1;
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = aVar.aS.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size2) {
                break;
            }
            g.a aVar2 = aVar.aS.get(i4);
            if (aVar2.aP == g.D) {
                e a2 = h.a(aVar2, aVar.d(g.C), j, drmInitData, (this.e & 16) != 0, false);
                if (a2 != null) {
                    sparseArray2.put(a2.f25124a, a2);
                }
            }
            i3 = i4 + 1;
        }
        int size3 = sparseArray2.size();
        if (this.i.size() == 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= size3) {
                    b();
                    this.I.a();
                    return;
                }
                e eVar = (e) sparseArray2.valueAt(i6);
                C0652b c0652b = new C0652b(this.I.a(i6, eVar.b));
                c0652b.a(eVar, (i) sparseArray.get(eVar.f25124a));
                this.i.put(eVar.f25124a, c0652b);
                this.B = Math.max(this.B, eVar.e);
                i5 = i6 + 1;
            }
        } else {
            com.opos.exoplayer.core.i.a.b(this.i.size() == size3);
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= size3) {
                    return;
                }
                e eVar2 = (e) sparseArray2.valueAt(i8);
                this.i.get(eVar2.f25124a).a(eVar2, (i) sparseArray.get(eVar2.f25124a));
                i7 = i8 + 1;
            }
        }
    }

    private static void b(g.a aVar, SparseArray<C0652b> sparseArray, int i, byte[] bArr) {
        C0652b a2 = a(aVar.d(g.x).aQ, sparseArray, i);
        if (a2 == null) {
            return;
        }
        l lVar = a2.f25116a;
        long j = lVar.s;
        a2.a();
        long j2 = j;
        if (aVar.d(g.w) != null) {
            j2 = j;
            if ((i & 2) == 0) {
                j2 = d(aVar.d(g.w).aQ);
            }
        }
        a(aVar, a2, j2, i);
        f a3 = a2.f25117c.a(lVar.f25148a.f25143a);
        g.b d2 = aVar.d(g.ac);
        if (d2 != null) {
            a(a3, d2.aQ, lVar);
        }
        g.b d3 = aVar.d(g.ad);
        if (d3 != null) {
            a(d3.aQ, lVar);
        }
        g.b d4 = aVar.d(g.ah);
        if (d4 != null) {
            b(d4.aQ, lVar);
        }
        g.b d5 = aVar.d(g.ae);
        g.b d6 = aVar.d(g.af);
        if (d5 != null && d6 != null) {
            a(d5.aQ, d6.aQ, a3 != null ? a3.b : null, lVar);
        }
        int size = aVar.aR.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            g.b bVar = aVar.aR.get(i3);
            if (bVar.aP == g.ag) {
                a(bVar.aQ, lVar, bArr);
            }
            i2 = i3 + 1;
        }
    }

    private static void b(com.opos.exoplayer.core.i.m mVar, l lVar) {
        a(mVar, 0, lVar);
    }

    private static boolean b(int i) {
        return i == g.B || i == g.D || i == g.E || i == g.F || i == g.G || i == g.K || i == g.L || i == g.M || i == g.P;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0243  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(com.opos.exoplayer.core.c.f r9) {
        /*
            Method dump skipped, instructions count: 590
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.d.b.b(com.opos.exoplayer.core.c.f):boolean");
    }

    private static long c(com.opos.exoplayer.core.i.m mVar) {
        mVar.c(8);
        return g.a(mVar.o()) == 0 ? mVar.m() : mVar.w();
    }

    private void c(g.a aVar) {
        a(aVar, this.i, this.e, this.q);
        DrmInitData a2 = this.h != null ? null : a(aVar.aR);
        if (a2 == null) {
            return;
        }
        int size = this.i.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.i.valueAt(i2).a(a2);
            i = i2 + 1;
        }
    }

    private void c(com.opos.exoplayer.core.c.f fVar) {
        int i = ((int) this.w) - this.x;
        com.opos.exoplayer.core.i.m mVar = this.y;
        if (mVar != null) {
            fVar.b(mVar.f25496a, 8, i);
            a(new g.b(this.v, this.y), fVar.c());
        } else {
            fVar.b(i);
        }
        a(fVar.c());
    }

    private static long d(com.opos.exoplayer.core.i.m mVar) {
        mVar.c(8);
        return g.a(mVar.o()) == 1 ? mVar.w() : mVar.m();
    }

    private void d(com.opos.exoplayer.core.c.f fVar) {
        int size = this.i.size();
        C0652b c0652b = null;
        long j = Long.MAX_VALUE;
        int i = 0;
        while (i < size) {
            l lVar = this.i.valueAt(i).f25116a;
            C0652b c0652b2 = c0652b;
            long j2 = j;
            if (lVar.r) {
                c0652b2 = c0652b;
                j2 = j;
                if (lVar.d < j) {
                    j2 = lVar.d;
                    c0652b2 = this.i.valueAt(i);
                }
            }
            i++;
            c0652b = c0652b2;
            j = j2;
        }
        if (c0652b == null) {
            this.u = 3;
            return;
        }
        int c2 = (int) (j - fVar.c());
        if (c2 < 0) {
            throw new com.opos.exoplayer.core.o("Offset to encryption data was negative.");
        }
        fVar.b(c2);
        c0652b.f25116a.a(fVar);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private boolean e(com.opos.exoplayer.core.c.f fVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        while (true) {
            int i = this.u;
            if (i != 0) {
                if (i == 1) {
                    c(fVar);
                } else if (i == 2) {
                    d(fVar);
                } else if (e(fVar)) {
                    return 0;
                }
            } else if (!b(fVar)) {
                return -1;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        int size = this.i.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.s.clear();
                this.A = 0;
                this.r.clear();
                a();
                return;
            }
            this.i.valueAt(i2).a();
            i = i2 + 1;
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.I = gVar;
        e eVar = this.f;
        if (eVar != null) {
            C0652b c0652b = new C0652b(gVar.a(0, eVar.b));
            c0652b.a(this.f, new i(0, 0, 0, 0));
            this.i.put(0, c0652b);
            b();
            this.I.a();
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        return k.a(fVar);
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
