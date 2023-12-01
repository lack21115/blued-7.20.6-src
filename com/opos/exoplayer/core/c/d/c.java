package com.opos.exoplayer.core.c.d;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.d.g;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.metadata.Metadata;
import java.util.ArrayList;
import java.util.Stack;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/c.class */
public final class c implements com.opos.exoplayer.core.c.e, com.opos.exoplayer.core.c.l {

    /* renamed from: a  reason: collision with root package name */
    public static final com.opos.exoplayer.core.c.h f11430a = new com.opos.exoplayer.core.c.h() { // from class: com.opos.exoplayer.core.c.d.c.1
        @Override // com.opos.exoplayer.core.c.h
        public com.opos.exoplayer.core.c.e[] a() {
            return new com.opos.exoplayer.core.c.e[]{new c()};
        }
    };
    private static final int b = u.f("qt  ");

    /* renamed from: c  reason: collision with root package name */
    private final int f11431c;
    private final com.opos.exoplayer.core.i.m d;
    private final com.opos.exoplayer.core.i.m e;
    private final com.opos.exoplayer.core.i.m f;
    private final Stack<g.a> g;
    private int h;
    private int i;
    private long j;
    private int k;
    private com.opos.exoplayer.core.i.m l;
    private int m;
    private int n;
    private int o;
    private com.opos.exoplayer.core.c.g p;
    private a[] q;
    private long[][] r;
    private int s;
    private long t;
    private boolean u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/c$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final e f11432a;
        public final m b;

        /* renamed from: c  reason: collision with root package name */
        public final n f11433c;
        public int d;

        public a(e eVar, m mVar, n nVar) {
            this.f11432a = eVar;
            this.b = mVar;
            this.f11433c = nVar;
        }
    }

    public c() {
        this(0);
    }

    public c(int i) {
        this.f11431c = i;
        this.f = new com.opos.exoplayer.core.i.m(16);
        this.g = new Stack<>();
        this.d = new com.opos.exoplayer.core.i.m(com.opos.exoplayer.core.i.k.f11800a);
        this.e = new com.opos.exoplayer.core.i.m(4);
        this.m = -1;
    }

    private static int a(m mVar, long j) {
        int a2 = mVar.a(j);
        int i = a2;
        if (a2 == -1) {
            i = mVar.b(j);
        }
        return i;
    }

    private static long a(m mVar, long j, long j2) {
        int a2 = a(mVar, j);
        return a2 == -1 ? j2 : Math.min(mVar.b[a2], j2);
    }

    private void a(long j) {
        while (!this.g.isEmpty() && this.g.peek().aQ == j) {
            g.a pop = this.g.pop();
            if (pop.aP == g.B) {
                a(pop);
                this.g.clear();
                this.h = 2;
            } else if (!this.g.isEmpty()) {
                this.g.peek().a(pop);
            }
        }
        if (this.h != 2) {
            d();
        }
    }

    private void a(g.a aVar) {
        Metadata metadata;
        int i;
        ArrayList arrayList = new ArrayList();
        com.opos.exoplayer.core.c.i iVar = new com.opos.exoplayer.core.c.i();
        g.b d = aVar.d(g.aA);
        if (d != null) {
            Metadata a2 = h.a(d, this.u);
            metadata = a2;
            if (a2 != null) {
                iVar.a(a2);
                metadata = a2;
            }
        } else {
            metadata = null;
        }
        int i2 = -1;
        long j = -9223372036854775807L;
        for (int i3 = 0; i3 < aVar.aS.size(); i3++) {
            g.a aVar2 = aVar.aS.get(i3);
            if (aVar2.aP == g.D) {
                e a3 = h.a(aVar2, aVar.d(g.C), (long) com.anythink.expressad.exoplayer.b.b, (DrmInitData) null, (this.f11431c & 1) != 0, this.u);
                if (a3 != null) {
                    m a4 = h.a(a3, aVar2.e(g.E).e(g.F).e(g.G), iVar);
                    if (a4.f11462a != 0) {
                        a aVar3 = new a(a3, a4, this.p.a(i3, a3.b));
                        Format a5 = a3.f.a(a4.d + 30);
                        Format format = a5;
                        if (a3.b == 1) {
                            Format format2 = a5;
                            if (iVar.a()) {
                                format2 = a5.a(iVar.b, iVar.f11558c);
                            }
                            format = format2;
                            if (metadata != null) {
                                format = format2.a(metadata);
                            }
                        }
                        aVar3.f11433c.a(format);
                        j = Math.max(j, a3.e != com.anythink.expressad.exoplayer.b.b ? a3.e : a4.g);
                        if (a3.b == 2) {
                            i = i2;
                            if (i2 == -1) {
                                i = arrayList.size();
                            }
                        } else {
                            i = i2;
                        }
                        arrayList.add(aVar3);
                        i2 = i;
                    }
                }
            }
        }
        this.s = i2;
        this.t = j;
        a[] aVarArr = (a[]) arrayList.toArray(new a[arrayList.size()]);
        this.q = aVarArr;
        this.r = a(aVarArr);
        this.p.a();
        this.p.a(this);
    }

    private static boolean a(int i) {
        return i == g.R || i == g.C || i == g.S || i == g.T || i == g.am || i == g.an || i == g.ao || i == g.Q || i == g.ap || i == g.aq || i == g.f11441ar || i == g.as || i == g.at || i == g.O || i == g.f11440a || i == g.aA;
    }

    private static boolean a(com.opos.exoplayer.core.i.m mVar) {
        mVar.c(8);
        if (mVar.o() == b) {
            return true;
        }
        mVar.d(4);
        while (mVar.b() > 0) {
            if (mVar.o() == b) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [long[], long[][]] */
    private static long[][] a(a[] aVarArr) {
        ?? r0 = new long[aVarArr.length];
        int[] iArr = new int[aVarArr.length];
        long[] jArr = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aVarArr.length) {
                break;
            }
            r0[i2] = new long[aVarArr[i2].b.f11462a];
            jArr[i2] = aVarArr[i2].b.e[0];
            i = i2 + 1;
        }
        long j = 0;
        int i3 = 0;
        while (i3 < aVarArr.length) {
            long j2 = Long.MAX_VALUE;
            int i4 = -1;
            int i5 = 0;
            while (i5 < aVarArr.length) {
                long j3 = j2;
                int i6 = i4;
                if (!zArr[i5]) {
                    j3 = j2;
                    i6 = i4;
                    if (jArr[i5] <= j2) {
                        j3 = jArr[i5];
                        i6 = i5;
                    }
                }
                i5++;
                j2 = j3;
                i4 = i6;
            }
            int i7 = iArr[i4];
            r0[i4][i7] = j;
            j += aVarArr[i4].b.f11463c[i7];
            int i8 = i7 + 1;
            iArr[i4] = i8;
            if (i8 < r0[i4].length) {
                jArr[i4] = aVarArr[i4].b.e[i8];
            } else {
                zArr[i4] = true;
                i3++;
            }
        }
        return r0;
    }

    private static boolean b(int i) {
        return i == g.B || i == g.D || i == g.E || i == g.F || i == g.G || i == g.P;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(com.opos.exoplayer.core.c.f r8) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.d.c.b(com.opos.exoplayer.core.c.f):boolean");
    }

    private boolean b(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        boolean z;
        long j = this.j - this.k;
        long c2 = fVar.c();
        com.opos.exoplayer.core.i.m mVar = this.l;
        if (mVar != null) {
            fVar.b(mVar.f11808a, this.k, (int) j);
            if (this.i == g.f11440a) {
                this.u = a(this.l);
            } else if (!this.g.isEmpty()) {
                this.g.peek().a(new g.b(this.i, this.l));
            }
        } else if (j >= 262144) {
            kVar.f11561a = fVar.c() + j;
            z = true;
            a(c2 + j);
            return z && this.h != 2;
        } else {
            fVar.b((int) j);
        }
        z = false;
        a(c2 + j);
        if (z) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bb, code lost:
        if (r0 < r18) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0104 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int c(long r8) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.d.c.c(long):int");
    }

    private int c(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        int i;
        long c2 = fVar.c();
        if (this.m == -1) {
            int c3 = c(c2);
            this.m = c3;
            if (c3 == -1) {
                return -1;
            }
        }
        a aVar = this.q[this.m];
        n nVar = aVar.f11433c;
        int i2 = aVar.d;
        long j = aVar.b.b[i2];
        int i3 = aVar.b.f11463c[i2];
        long j2 = (j - c2) + this.n;
        if (j2 < 0 || j2 >= 262144) {
            kVar.f11561a = j;
            return 1;
        }
        long j3 = j2;
        int i4 = i3;
        if (aVar.f11432a.g == 1) {
            j3 = j2 + 8;
            i4 = i3 - 8;
        }
        fVar.b((int) j3);
        if (aVar.f11432a.j == 0) {
            while (true) {
                int i5 = this.n;
                i = i4;
                if (i5 >= i4) {
                    break;
                }
                int a2 = nVar.a(fVar, i4 - i5, false);
                this.n += a2;
                this.o -= a2;
            }
        } else {
            byte[] bArr = this.e.f11808a;
            byte b2 = (byte) 0;
            bArr[0] = b2;
            bArr[1] = b2;
            bArr[2] = b2;
            int i6 = aVar.f11432a.j;
            int i7 = 4 - aVar.f11432a.j;
            while (true) {
                i = i4;
                if (this.n >= i4) {
                    break;
                }
                int i8 = this.o;
                if (i8 == 0) {
                    fVar.b(this.e.f11808a, i7, i6);
                    this.e.c(0);
                    this.o = this.e.u();
                    this.d.c(0);
                    nVar.a(this.d, 4);
                    this.n += 4;
                    i4 += i7;
                } else {
                    int a3 = nVar.a(fVar, i8, false);
                    this.n += a3;
                    this.o -= a3;
                }
            }
        }
        nVar.a(aVar.b.e[i2], aVar.b.f[i2], i, 0, null);
        aVar.d++;
        this.m = -1;
        this.n = 0;
        this.o = 0;
        return 0;
    }

    private void d() {
        this.h = 0;
        this.k = 0;
    }

    private void d(long j) {
        a[] aVarArr = this.q;
        int length = aVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            a aVar = aVarArr[i2];
            m mVar = aVar.b;
            int a2 = mVar.a(j);
            int i3 = a2;
            if (a2 == -1) {
                i3 = mVar.b(j);
            }
            aVar.d = i3;
            i = i2 + 1;
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        while (true) {
            int i = this.h;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return c(fVar, kVar);
                    }
                    throw new IllegalStateException();
                } else if (b(fVar, kVar)) {
                    return 1;
                }
            } else if (!b(fVar)) {
                return -1;
            }
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(long j, long j2) {
        this.g.clear();
        this.k = 0;
        this.m = -1;
        this.n = 0;
        this.o = 0;
        if (j == 0) {
            d();
        } else if (this.q != null) {
            d(j2);
        }
    }

    @Override // com.opos.exoplayer.core.c.e
    public void a(com.opos.exoplayer.core.c.g gVar) {
        this.p = gVar;
    }

    @Override // com.opos.exoplayer.core.c.l
    public boolean a() {
        return true;
    }

    @Override // com.opos.exoplayer.core.c.e
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        return k.b(fVar);
    }

    @Override // com.opos.exoplayer.core.c.l
    public long b() {
        return this.t;
    }

    @Override // com.opos.exoplayer.core.c.l
    public l.a b(long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        int b2;
        a[] aVarArr = this.q;
        if (aVarArr.length == 0) {
            return new l.a(com.opos.exoplayer.core.c.m.f11564a);
        }
        int i = this.s;
        if (i != -1) {
            m mVar = aVarArr[i].b;
            int a2 = a(mVar, j);
            if (a2 == -1) {
                return new l.a(com.opos.exoplayer.core.c.m.f11564a);
            }
            j4 = mVar.e[a2];
            long j7 = mVar.b[a2];
            if (j4 >= j || a2 >= mVar.f11462a - 1 || (b2 = mVar.b(j)) == -1 || b2 == a2) {
                j5 = -1;
                j6 = -9223372036854775807L;
            } else {
                j6 = mVar.e[b2];
                j5 = mVar.b[b2];
            }
            j3 = j6;
            j2 = j7;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -9223372036854775807L;
            j4 = j;
            j5 = -1;
        }
        int i2 = 0;
        long j8 = j2;
        long j9 = j5;
        while (true) {
            a[] aVarArr2 = this.q;
            if (i2 >= aVarArr2.length) {
                break;
            }
            long j10 = j9;
            long j11 = j8;
            if (i2 != this.s) {
                m mVar2 = aVarArr2[i2].b;
                long a3 = a(mVar2, j4, j8);
                j10 = j9;
                j11 = a3;
                if (j3 != com.anythink.expressad.exoplayer.b.b) {
                    j10 = a(mVar2, j3, j9);
                    j11 = a3;
                }
            }
            i2++;
            j9 = j10;
            j8 = j11;
        }
        com.opos.exoplayer.core.c.m mVar3 = new com.opos.exoplayer.core.c.m(j4, j8);
        return j3 == com.anythink.expressad.exoplayer.b.b ? new l.a(mVar3) : new l.a(mVar3, new com.opos.exoplayer.core.c.m(j3, j9));
    }

    @Override // com.opos.exoplayer.core.c.e
    public void c() {
    }
}
