package com.anythink.expressad.exoplayer.e.a;

import com.anythink.expressad.exoplayer.e.a.a;
import com.anythink.expressad.exoplayer.e.a.b;
import com.anythink.expressad.exoplayer.e.k;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.p;
import com.anythink.expressad.exoplayer.k.s;
import com.anythink.expressad.exoplayer.t;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/g.class */
public final class g implements com.anythink.expressad.exoplayer.e.e, com.anythink.expressad.exoplayer.e.k {
    public static final int e = 1;
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = 2;
    private static final long j = 262144;
    private static final long k = 10485760;
    private long[][] A;
    private int B;
    private long C;
    private boolean D;
    private final int l;
    private final s m;
    private final s n;
    private final s o;
    private final ArrayDeque<a.C0054a> p;
    private int q;
    private int r;
    private long s;
    private int t;
    private s u;
    private int v;
    private int w;
    private int x;
    private com.anythink.expressad.exoplayer.e.g y;
    private b[] z;
    public static final com.anythink.expressad.exoplayer.e.h d = new com.anythink.expressad.exoplayer.e.h() { // from class: com.anythink.expressad.exoplayer.e.a.g.1
        @Override // com.anythink.expressad.exoplayer.e.h
        public final com.anythink.expressad.exoplayer.e.e[] a() {
            return new com.anythink.expressad.exoplayer.e.e[]{new g()};
        }
    };
    private static final int i = af.f("qt  ");

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/g$a.class */
    public @interface a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/g$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final j f4459a;
        public final m b;

        /* renamed from: c  reason: collision with root package name */
        public final com.anythink.expressad.exoplayer.e.m f4460c;
        public int d;

        public b(j jVar, m mVar, com.anythink.expressad.exoplayer.e.m mVar2) {
            this.f4459a = jVar;
            this.b = mVar;
            this.f4460c = mVar2;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/g$c.class */
    @interface c {
    }

    public g() {
        this(0);
    }

    public g(int i2) {
        this.l = i2;
        this.o = new s(16);
        this.p = new ArrayDeque<>();
        this.m = new s(p.f4825a);
        this.n = new s(4);
        this.v = -1;
    }

    private static int a(m mVar, long j2) {
        int a2 = mVar.a(j2);
        int i2 = a2;
        if (a2 == -1) {
            i2 = mVar.b(j2);
        }
        return i2;
    }

    private static long a(m mVar, long j2, long j3) {
        int a2 = a(mVar, j2);
        return a2 == -1 ? j3 : Math.min(mVar.f4472c[a2], j3);
    }

    private ArrayList<m> a(a.C0054a c0054a, com.anythink.expressad.exoplayer.e.i iVar, boolean z) {
        j a2;
        ArrayList<m> arrayList = new ArrayList<>();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= c0054a.aX.size()) {
                return arrayList;
            }
            a.C0054a c0054a2 = c0054a.aX.get(i3);
            if (c0054a2.aU == com.anythink.expressad.exoplayer.e.a.a.I && (a2 = com.anythink.expressad.exoplayer.e.a.b.a(c0054a2, c0054a.d(com.anythink.expressad.exoplayer.e.a.a.H), (long) com.anythink.expressad.exoplayer.b.b, (com.anythink.expressad.exoplayer.d.e) null, z, this.D)) != null) {
                m a3 = com.anythink.expressad.exoplayer.e.a.b.a(a2, c0054a2.e(com.anythink.expressad.exoplayer.e.a.a.J).e(com.anythink.expressad.exoplayer.e.a.a.K).e(com.anythink.expressad.exoplayer.e.a.a.L), iVar);
                if (a3.b != 0) {
                    arrayList.add(a3);
                }
            }
            i2 = i3 + 1;
        }
    }

    private void a(a.C0054a c0054a) {
        com.anythink.expressad.exoplayer.g.a aVar;
        ArrayList<m> a2;
        int i2;
        ArrayList arrayList = new ArrayList();
        com.anythink.expressad.exoplayer.e.i iVar = new com.anythink.expressad.exoplayer.e.i();
        a.b d2 = c0054a.d(com.anythink.expressad.exoplayer.e.a.a.aF);
        if (d2 != null) {
            com.anythink.expressad.exoplayer.g.a a3 = com.anythink.expressad.exoplayer.e.a.b.a(d2, this.D);
            aVar = a3;
            if (a3 != null) {
                iVar.a(a3);
                aVar = a3;
            }
        } else {
            aVar = null;
        }
        int i3 = 0;
        try {
            a2 = a(c0054a, iVar, (this.l & 1) != 0);
        } catch (b.g e2) {
            iVar = new com.anythink.expressad.exoplayer.e.i();
            a2 = a(c0054a, iVar, true);
        }
        int size = a2.size();
        int i4 = -1;
        long j2 = -9223372036854775807L;
        while (i3 < size) {
            m mVar = a2.get(i3);
            j jVar = mVar.f4471a;
            b bVar = new b(jVar, mVar, this.y.a(i3, jVar.d));
            com.anythink.expressad.exoplayer.m a4 = jVar.h.a(mVar.e + 30);
            com.anythink.expressad.exoplayer.m mVar2 = a4;
            if (jVar.d == 1) {
                com.anythink.expressad.exoplayer.m mVar3 = a4;
                if (iVar.a()) {
                    mVar3 = a4.a(iVar.b, iVar.f4480c);
                }
                mVar2 = mVar3;
                if (aVar != null) {
                    mVar2 = mVar3.a(aVar);
                }
            }
            bVar.f4460c.a(mVar2);
            j2 = Math.max(j2, jVar.g != com.anythink.expressad.exoplayer.b.b ? jVar.g : mVar.h);
            if (jVar.d == 2) {
                i2 = i4;
                if (i4 == -1) {
                    i2 = arrayList.size();
                }
            } else {
                i2 = i4;
            }
            arrayList.add(bVar);
            i3++;
            i4 = i2;
        }
        this.B = i4;
        this.C = j2;
        b[] bVarArr = (b[]) arrayList.toArray(new b[arrayList.size()]);
        this.z = bVarArr;
        this.A = a(bVarArr);
        this.y.c_();
        this.y.a(this);
    }

    private static boolean a(int i2) {
        return i2 == com.anythink.expressad.exoplayer.e.a.a.W || i2 == com.anythink.expressad.exoplayer.e.a.a.H || i2 == com.anythink.expressad.exoplayer.e.a.a.X || i2 == com.anythink.expressad.exoplayer.e.a.a.Y || i2 == com.anythink.expressad.exoplayer.e.a.a.f4435ar || i2 == com.anythink.expressad.exoplayer.e.a.a.as || i2 == com.anythink.expressad.exoplayer.e.a.a.at || i2 == com.anythink.expressad.exoplayer.e.a.a.V || i2 == com.anythink.expressad.exoplayer.e.a.a.au || i2 == com.anythink.expressad.exoplayer.e.a.a.av || i2 == com.anythink.expressad.exoplayer.e.a.a.aw || i2 == com.anythink.expressad.exoplayer.e.a.a.ax || i2 == com.anythink.expressad.exoplayer.e.a.a.ay || i2 == com.anythink.expressad.exoplayer.e.a.a.T || i2 == com.anythink.expressad.exoplayer.e.a.a.f || i2 == com.anythink.expressad.exoplayer.e.a.a.aF;
    }

    private static boolean a(s sVar) {
        sVar.c(8);
        if (sVar.i() == i) {
            return true;
        }
        sVar.d(4);
        while (sVar.a() > 0) {
            if (sVar.i() == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [long[], long[][]] */
    private static long[][] a(b[] bVarArr) {
        ?? r0 = new long[bVarArr.length];
        int[] iArr = new int[bVarArr.length];
        long[] jArr = new long[bVarArr.length];
        boolean[] zArr = new boolean[bVarArr.length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= bVarArr.length) {
                break;
            }
            r0[i3] = new long[bVarArr[i3].b.b];
            jArr[i3] = bVarArr[i3].b.f[0];
            i2 = i3 + 1;
        }
        long j2 = 0;
        int i4 = 0;
        while (i4 < bVarArr.length) {
            long j3 = Long.MAX_VALUE;
            int i5 = -1;
            int i6 = 0;
            while (i6 < bVarArr.length) {
                long j4 = j3;
                int i7 = i5;
                if (!zArr[i6]) {
                    j4 = j3;
                    i7 = i5;
                    if (jArr[i6] <= j3) {
                        j4 = jArr[i6];
                        i7 = i6;
                    }
                }
                i6++;
                j3 = j4;
                i5 = i7;
            }
            int i8 = iArr[i5];
            r0[i5][i8] = j2;
            j2 += bVarArr[i5].b.d[i8];
            int i9 = i8 + 1;
            iArr[i5] = i9;
            if (i9 < r0[i5].length) {
                jArr[i5] = bVarArr[i5].b.f[i9];
            } else {
                zArr[i5] = true;
                i4++;
            }
        }
        return r0;
    }

    private void b(long j2) {
        while (!this.p.isEmpty() && this.p.peek().aV == j2) {
            a.C0054a pop = this.p.pop();
            if (pop.aU == com.anythink.expressad.exoplayer.e.a.a.G) {
                a(pop);
                this.p.clear();
                this.q = 2;
            } else if (!this.p.isEmpty()) {
                this.p.peek().a(pop);
            }
        }
        if (this.q != 2) {
            d();
        }
    }

    private static boolean b(int i2) {
        return i2 == com.anythink.expressad.exoplayer.e.a.a.G || i2 == com.anythink.expressad.exoplayer.e.a.a.I || i2 == com.anythink.expressad.exoplayer.e.a.a.J || i2 == com.anythink.expressad.exoplayer.e.a.a.K || i2 == com.anythink.expressad.exoplayer.e.a.a.L || i2 == com.anythink.expressad.exoplayer.e.a.a.U;
    }

    private boolean b(com.anythink.expressad.exoplayer.e.f fVar) {
        if (this.t == 0) {
            if (!fVar.a(this.o.f4835a, 0, 8, true)) {
                return false;
            }
            this.t = 8;
            this.o.c(0);
            this.s = this.o.h();
            this.r = this.o.i();
        }
        long j2 = this.s;
        if (j2 == 1) {
            fVar.b(this.o.f4835a, 8, 8);
            this.t += 8;
            this.s = this.o.n();
        } else if (j2 == 0) {
            long d2 = fVar.d();
            long j3 = d2;
            if (d2 == -1) {
                j3 = d2;
                if (!this.p.isEmpty()) {
                    j3 = this.p.peek().aV;
                }
            }
            if (j3 != -1) {
                this.s = (j3 - fVar.c()) + this.t;
            }
        }
        if (this.s >= this.t) {
            int i2 = this.r;
            if (i2 == com.anythink.expressad.exoplayer.e.a.a.G || i2 == com.anythink.expressad.exoplayer.e.a.a.I || i2 == com.anythink.expressad.exoplayer.e.a.a.J || i2 == com.anythink.expressad.exoplayer.e.a.a.K || i2 == com.anythink.expressad.exoplayer.e.a.a.L || i2 == com.anythink.expressad.exoplayer.e.a.a.U) {
                long c2 = (fVar.c() + this.s) - this.t;
                this.p.push(new a.C0054a(this.r, c2));
                if (this.s == this.t) {
                    b(c2);
                    return true;
                }
                d();
                return true;
            }
            int i3 = this.r;
            if (!(i3 == com.anythink.expressad.exoplayer.e.a.a.W || i3 == com.anythink.expressad.exoplayer.e.a.a.H || i3 == com.anythink.expressad.exoplayer.e.a.a.X || i3 == com.anythink.expressad.exoplayer.e.a.a.Y || i3 == com.anythink.expressad.exoplayer.e.a.a.f4435ar || i3 == com.anythink.expressad.exoplayer.e.a.a.as || i3 == com.anythink.expressad.exoplayer.e.a.a.at || i3 == com.anythink.expressad.exoplayer.e.a.a.V || i3 == com.anythink.expressad.exoplayer.e.a.a.au || i3 == com.anythink.expressad.exoplayer.e.a.a.av || i3 == com.anythink.expressad.exoplayer.e.a.a.aw || i3 == com.anythink.expressad.exoplayer.e.a.a.ax || i3 == com.anythink.expressad.exoplayer.e.a.a.ay || i3 == com.anythink.expressad.exoplayer.e.a.a.T || i3 == com.anythink.expressad.exoplayer.e.a.a.f || i3 == com.anythink.expressad.exoplayer.e.a.a.aF)) {
                this.u = null;
                this.q = 1;
                return true;
            }
            com.anythink.expressad.exoplayer.k.a.b(this.t == 8);
            com.anythink.expressad.exoplayer.k.a.b(this.s <= 2147483647L);
            this.u = new s((int) this.s);
            System.arraycopy(this.o.f4835a, 0, this.u.f4835a, 0, 8);
            this.q = 1;
            return true;
        }
        throw new t("Atom size less than header length (unsupported).");
    }

    private boolean b(com.anythink.expressad.exoplayer.e.f fVar, com.anythink.expressad.exoplayer.e.j jVar) {
        boolean z;
        boolean z2;
        long j2 = this.s - this.t;
        long c2 = fVar.c();
        s sVar = this.u;
        if (sVar != null) {
            fVar.b(sVar.f4835a, this.t, (int) j2);
            if (this.r == com.anythink.expressad.exoplayer.e.a.a.f) {
                s sVar2 = this.u;
                sVar2.c(8);
                if (sVar2.i() == i) {
                    z2 = true;
                    break;
                }
                sVar2.d(4);
                while (sVar2.a() > 0) {
                    if (sVar2.i() == i) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                this.D = z2;
            } else if (!this.p.isEmpty()) {
                this.p.peek().a(new a.b(this.r, this.u));
            }
        } else if (j2 >= 262144) {
            jVar.f4481a = fVar.c() + j2;
            z = true;
            b(c2 + j2);
            return z && this.q != 2;
        } else {
            fVar.c((int) j2);
        }
        z = false;
        b(c2 + j2);
        if (z) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d0, code lost:
        if (r0 < r22) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0121 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int c(long r8) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.e.a.g.c(long):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00e1, code lost:
        if (r0 < r23) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0132 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int c(com.anythink.expressad.exoplayer.e.f r9, com.anythink.expressad.exoplayer.e.j r10) {
        /*
            Method dump skipped, instructions count: 828
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.e.a.g.c(com.anythink.expressad.exoplayer.e.f, com.anythink.expressad.exoplayer.e.j):int");
    }

    private void d() {
        this.q = 0;
        this.t = 0;
    }

    private void d(long j2) {
        b[] bVarArr = this.z;
        int length = bVarArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            b bVar = bVarArr[i3];
            m mVar = bVar.b;
            int a2 = mVar.a(j2);
            int i4 = a2;
            if (a2 == -1) {
                i4 = mVar.b(j2);
            }
            bVar.d = i4;
            i2 = i3 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f2, code lost:
        if (r0 < r23) goto L158;
     */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0445 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0699 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0000 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0000 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0143 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0128  */
    @Override // com.anythink.expressad.exoplayer.e.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(com.anythink.expressad.exoplayer.e.f r9, com.anythink.expressad.exoplayer.e.j r10) {
        /*
            Method dump skipped, instructions count: 1702
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.e.a.g.a(com.anythink.expressad.exoplayer.e.f, com.anythink.expressad.exoplayer.e.j):int");
    }

    @Override // com.anythink.expressad.exoplayer.e.k
    public final k.a a(long j2) {
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        int b2;
        b[] bVarArr = this.z;
        if (bVarArr.length == 0) {
            return new k.a(com.anythink.expressad.exoplayer.e.l.f4484a);
        }
        int i2 = this.B;
        if (i2 != -1) {
            m mVar = bVarArr[i2].b;
            int a2 = a(mVar, j2);
            if (a2 == -1) {
                return new k.a(com.anythink.expressad.exoplayer.e.l.f4484a);
            }
            j5 = mVar.f[a2];
            long j9 = mVar.f4472c[a2];
            if (j5 >= j2 || a2 >= mVar.b - 1 || (b2 = mVar.b(j2)) == -1 || b2 == a2) {
                j7 = -1;
                j8 = -9223372036854775807L;
            } else {
                j8 = mVar.f[b2];
                j7 = mVar.f4472c[b2];
            }
            j4 = j8;
            j6 = j7;
            j3 = j9;
        } else {
            j3 = Long.MAX_VALUE;
            j4 = -9223372036854775807L;
            j5 = j2;
            j6 = -1;
        }
        int i3 = 0;
        while (true) {
            b[] bVarArr2 = this.z;
            if (i3 >= bVarArr2.length) {
                break;
            }
            long j10 = j6;
            long j11 = j3;
            if (i3 != this.B) {
                m mVar2 = bVarArr2[i3].b;
                j11 = a(mVar2, j5, j3);
                long j12 = j6;
                if (j4 != com.anythink.expressad.exoplayer.b.b) {
                    j12 = a(mVar2, j4, j6);
                }
                j10 = j12;
            }
            i3++;
            j6 = j10;
            j3 = j11;
        }
        com.anythink.expressad.exoplayer.e.l lVar = new com.anythink.expressad.exoplayer.e.l(j5, j3);
        return j4 == com.anythink.expressad.exoplayer.b.b ? new k.a(lVar) : new k.a(lVar, new com.anythink.expressad.exoplayer.e.l(j4, j6));
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void a(long j2, long j3) {
        this.p.clear();
        this.t = 0;
        this.v = -1;
        this.w = 0;
        this.x = 0;
        if (j2 == 0) {
            d();
            return;
        }
        b[] bVarArr = this.z;
        if (bVarArr != null) {
            for (b bVar : bVarArr) {
                m mVar = bVar.b;
                int a2 = mVar.a(j3);
                int i2 = a2;
                if (a2 == -1) {
                    i2 = mVar.b(j3);
                }
                bVar.d = i2;
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void a(com.anythink.expressad.exoplayer.e.g gVar) {
        this.y = gVar;
    }

    @Override // com.anythink.expressad.exoplayer.e.k
    public final boolean a() {
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final boolean a(com.anythink.expressad.exoplayer.e.f fVar) {
        return i.b(fVar);
    }

    @Override // com.anythink.expressad.exoplayer.e.k
    public final long b() {
        return this.C;
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void c() {
    }
}
