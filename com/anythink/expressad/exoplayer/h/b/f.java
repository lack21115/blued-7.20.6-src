package com.anythink.expressad.exoplayer.h.b;

import com.anythink.expressad.exoplayer.h.b.g;
import com.anythink.expressad.exoplayer.h.t;
import com.anythink.expressad.exoplayer.h.x;
import com.anythink.expressad.exoplayer.h.y;
import com.anythink.expressad.exoplayer.h.z;
import com.anythink.expressad.exoplayer.j.t;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.m;
import com.anythink.expressad.exoplayer.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/b/f.class */
public final class f<T extends g> implements y, z, t.a<c>, t.d {
    private static final String d = "ChunkSampleStream";

    /* renamed from: a  reason: collision with root package name */
    public final int f4592a;
    long b;

    /* renamed from: c  reason: collision with root package name */
    boolean f4593c;
    private final int[] e;
    private final m[] f;
    private final boolean[] g;
    private final T h;
    private final z.a<f<T>> i;
    private final t.a j;
    private final int k;
    private final com.anythink.expressad.exoplayer.j.t l = new com.anythink.expressad.exoplayer.j.t("Loader:ChunkSampleStream");
    private final e m = new e();
    private final ArrayList<com.anythink.expressad.exoplayer.h.b.a> n;
    private final List<com.anythink.expressad.exoplayer.h.b.a> o;
    private final x p;
    private final x[] q;
    private final com.anythink.expressad.exoplayer.h.b.b r;
    private m s;
    private b<T> t;
    private long u;
    private long v;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/b/f$a.class */
    public final class a implements y {

        /* renamed from: a  reason: collision with root package name */
        public final f<T> f4594a;

        /* renamed from: c  reason: collision with root package name */
        private final x f4595c;
        private final int d;
        private boolean e;

        public a(f<T> fVar, x xVar, int i) {
            this.f4594a = fVar;
            this.f4595c = xVar;
            this.d = i;
        }

        private void a() {
            com.anythink.expressad.exoplayer.k.a.b(f.this.g[this.d]);
            f.this.g[this.d] = false;
        }

        private void d() {
            if (this.e) {
                return;
            }
            f.this.j.a(f.this.e[this.d], f.this.f[this.d], 0, (Object) null, f.this.v);
            this.e = true;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(long j) {
            int i;
            if (!f.this.f4593c || j <= this.f4595c.g()) {
                int a2 = this.f4595c.a(j, true);
                i = a2;
                if (a2 == -1) {
                    i = 0;
                }
            } else {
                i = this.f4595c.k();
            }
            if (i > 0) {
                d();
            }
            return i;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z) {
            if (f.this.a()) {
                return -3;
            }
            int a2 = this.f4595c.a(nVar, eVar, z, f.this.f4593c, f.this.b);
            if (a2 == -4) {
                d();
            }
            return a2;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final boolean b() {
            if (f.this.f4593c) {
                return true;
            }
            return !f.this.a() && this.f4595c.c();
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final void c() {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/b/f$b.class */
    public interface b<T extends g> {
        void a();
    }

    private f(int i, int[] iArr, m[] mVarArr, T t, z.a<f<T>> aVar, com.anythink.expressad.exoplayer.j.b bVar, long j, int i2, t.a aVar2) {
        this.f4592a = i;
        this.e = iArr;
        this.f = mVarArr;
        this.h = t;
        this.i = aVar;
        this.j = aVar2;
        this.k = i2;
        ArrayList<com.anythink.expressad.exoplayer.h.b.a> arrayList = new ArrayList<>();
        this.n = arrayList;
        this.o = Collections.unmodifiableList(arrayList);
        int i3 = 0;
        int length = iArr == null ? 0 : iArr.length;
        this.q = new x[length];
        this.g = new boolean[length];
        int i4 = length + 1;
        int[] iArr2 = new int[i4];
        x[] xVarArr = new x[i4];
        x xVar = new x(bVar);
        this.p = xVar;
        iArr2[0] = i;
        xVarArr[0] = xVar;
        while (true) {
            int i5 = i3;
            if (i5 >= length) {
                this.r = new com.anythink.expressad.exoplayer.h.b.b(iArr2, xVarArr);
                this.u = j;
                this.v = j;
                return;
            }
            x xVar2 = new x(bVar);
            this.q[i5] = xVar2;
            i3 = i5 + 1;
            xVarArr[i3] = xVar2;
            iArr2[i3] = iArr[i5];
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cd A[RETURN] */
    /* renamed from: a  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a2(com.anythink.expressad.exoplayer.h.b.c r21, long r22, long r24, java.io.IOException r26) {
        /*
            r20 = this;
            r0 = r21
            long r0 = r0.d()
            r29 = r0
            r0 = r21
            boolean r0 = r0 instanceof com.anythink.expressad.exoplayer.h.b.a
            r31 = r0
            r0 = r20
            java.util.ArrayList<com.anythink.expressad.exoplayer.h.b.a> r0 = r0.n
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
            r28 = r0
            r0 = r29
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L35
            r0 = r31
            if (r0 == 0) goto L35
            r0 = r20
            r1 = r28
            boolean r0 = r0.a(r1)
            if (r0 != 0) goto L2f
            goto L35
        L2f:
            r0 = 0
            r27 = r0
            goto L38
        L35:
            r0 = 1
            r27 = r0
        L38:
            r0 = r20
            T extends com.anythink.expressad.exoplayer.h.b.g r0 = r0.h
            boolean r0 = r0.f()
            if (r0 == 0) goto L89
            r0 = r27
            if (r0 != 0) goto L54
            java.lang.String r0 = "ChunkSampleStream"
            java.lang.String r1 = "Ignoring attempt to cancel non-cancelable load."
            int r0 = android.util.Log.w(r0, r1)
            goto L89
        L54:
            r0 = r31
            if (r0 == 0) goto L83
            r0 = r20
            r1 = r28
            com.anythink.expressad.exoplayer.h.b.a r0 = r0.d(r1)
            r1 = r21
            if (r0 != r1) goto L69
            r0 = 1
            r31 = r0
            goto L6c
        L69:
            r0 = 0
            r31 = r0
        L6c:
            r0 = r31
            com.anythink.expressad.exoplayer.k.a.b(r0)
            r0 = r20
            java.util.ArrayList<com.anythink.expressad.exoplayer.h.b.a> r0 = r0.n
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L83
            r0 = r20
            r1 = r20
            long r1 = r1.v
            r0.u = r1
        L83:
            r0 = 1
            r31 = r0
            goto L8c
        L89:
            r0 = 0
            r31 = r0
        L8c:
            r0 = r20
            com.anythink.expressad.exoplayer.h.t$a r0 = r0.j
            r1 = r21
            com.anythink.expressad.exoplayer.j.k r1 = r1.b
            r2 = r21
            int r2 = r2.f4586c
            r3 = r20
            int r3 = r3.f4592a
            r4 = r21
            com.anythink.expressad.exoplayer.m r4 = r4.d
            r5 = r21
            int r5 = r5.e
            r6 = r21
            java.lang.Object r6 = r6.f
            r7 = r21
            long r7 = r7.g
            r8 = r21
            long r8 = r8.h
            r9 = r22
            r10 = r24
            r11 = r29
            r12 = r26
            r13 = r31
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r0 = r31
            if (r0 == 0) goto Lcd
            r0 = r20
            com.anythink.expressad.exoplayer.h.z$a<com.anythink.expressad.exoplayer.h.b.f<T extends com.anythink.expressad.exoplayer.h.b.g>> r0 = r0.i
            r1 = r20
            r0.a(r1)
            r0 = 2
            return r0
        Lcd:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.b.f.a2(com.anythink.expressad.exoplayer.h.b.c, long, long, java.io.IOException):int");
    }

    private f<T>.a a(long j, int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.q.length) {
                throw new IllegalStateException();
            }
            if (this.e[i3] == i) {
                com.anythink.expressad.exoplayer.k.a.b(!this.g[i3]);
                this.g[i3] = true;
                this.q[i3].i();
                this.q[i3].a(j, true);
                return new a(this, this.q[i3], i3);
            }
            i2 = i3 + 1;
        }
    }

    private void a(int i, int i2) {
        int b2 = b(i - i2, 0);
        int b3 = i2 == 1 ? b2 : b(i - 1, b2);
        while (b2 <= b3) {
            c(b2);
            b2++;
        }
    }

    private void a(long j, boolean z) {
        int d2 = this.p.d();
        this.p.a(j, z, true);
        int d3 = this.p.d();
        if (d3 > d2) {
            long h = this.p.h();
            int i = 0;
            while (true) {
                int i2 = i;
                x[] xVarArr = this.q;
                if (i2 >= xVarArr.length) {
                    break;
                }
                xVarArr[i2].a(h, z, this.g[i2]);
                i = i2 + 1;
            }
            int b2 = b(d3, 0);
            if (b2 > 0) {
                af.a((List) this.n, 0, b2);
            }
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private void a2(c cVar, long j, long j2) {
        this.j.a(cVar.b, cVar.f4586c, this.f4592a, cVar.d, cVar.e, cVar.f, cVar.g, cVar.h, j, j2, cVar.d());
        this.i.a(this);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private void a2(c cVar, long j, long j2, boolean z) {
        this.j.b(cVar.b, cVar.f4586c, this.f4592a, cVar.d, cVar.e, cVar.f, cVar.g, cVar.h, j, j2, cVar.d());
        if (z) {
            return;
        }
        this.p.a();
        x[] xVarArr = this.q;
        int length = xVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.i.a(this);
                return;
            } else {
                xVarArr[i2].a();
                i = i2 + 1;
            }
        }
    }

    private void a(b<T> bVar) {
        this.t = bVar;
        this.p.j();
        x[] xVarArr = this.q;
        int length = xVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.l.a(this);
                return;
            } else {
                xVarArr[i2].j();
                i = i2 + 1;
            }
        }
    }

    private boolean a(int i) {
        int e;
        int i2;
        com.anythink.expressad.exoplayer.h.b.a aVar = this.n.get(i);
        if (this.p.e() > aVar.a(0)) {
            return true;
        }
        int i3 = 0;
        do {
            x[] xVarArr = this.q;
            if (i3 >= xVarArr.length) {
                return false;
            }
            e = xVarArr[i3].e();
            i2 = i3 + 1;
            i3 = i2;
        } while (e <= aVar.a(i2));
        return true;
    }

    private static boolean a(c cVar) {
        return cVar instanceof com.anythink.expressad.exoplayer.h.b.a;
    }

    private int b(int i, int i2) {
        int i3;
        do {
            i3 = i2 + 1;
            if (i3 >= this.n.size()) {
                return this.n.size() - 1;
            }
            i2 = i3;
        } while (this.n.get(i3).a(0) <= i);
        return i3 - 1;
    }

    private void b(int i) {
        int b2 = b(i, 0);
        if (b2 > 0) {
            af.a((List) this.n, 0, b2);
        }
    }

    private void b(long j) {
        com.anythink.expressad.exoplayer.h.b.a aVar;
        boolean z;
        this.v = j;
        this.p.i();
        if (a()) {
            z = false;
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                aVar = null;
                if (i2 >= this.n.size()) {
                    break;
                }
                aVar = this.n.get(i2);
                int i3 = (aVar.g > j ? 1 : (aVar.g == j ? 0 : -1));
                if (i3 != 0 || aVar.f4583a != com.anythink.expressad.exoplayer.b.b) {
                    aVar = null;
                    if (i3 > 0) {
                        break;
                    }
                    i = i2 + 1;
                } else {
                    break;
                }
            }
            if (aVar != null) {
                z = this.p.b(aVar.a(0));
                this.b = Long.MIN_VALUE;
            } else {
                z = this.p.a(j, (j > e() ? 1 : (j == e() ? 0 : -1)) < 0) != -1;
                this.b = this.v;
            }
        }
        if (z) {
            x[] xVarArr = this.q;
            int length = xVarArr.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length) {
                    return;
                }
                x xVar = xVarArr[i5];
                xVar.i();
                xVar.a(j, false);
                i4 = i5 + 1;
            }
        } else {
            this.u = j;
            this.f4593c = false;
            this.n.clear();
            if (this.l.a()) {
                this.l.b();
                return;
            }
            this.p.a();
            x[] xVarArr2 = this.q;
            int length2 = xVarArr2.length;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= length2) {
                    return;
                }
                xVarArr2[i7].a();
                i6 = i7 + 1;
            }
        }
    }

    private void c(int i) {
        com.anythink.expressad.exoplayer.h.b.a aVar = this.n.get(i);
        m mVar = aVar.d;
        if (!mVar.equals(this.s)) {
            this.j.a(this.f4592a, mVar, aVar.e, aVar.f, aVar.g);
        }
        this.s = mVar;
    }

    private com.anythink.expressad.exoplayer.h.b.a d(int i) {
        com.anythink.expressad.exoplayer.h.b.a aVar = this.n.get(i);
        ArrayList<com.anythink.expressad.exoplayer.h.b.a> arrayList = this.n;
        af.a((List) arrayList, i, arrayList.size());
        int i2 = 0;
        this.p.a(aVar.a(0));
        while (true) {
            x[] xVarArr = this.q;
            if (i2 >= xVarArr.length) {
                return aVar;
            }
            x xVar = xVarArr[i2];
            i2++;
            xVar.a(aVar.a(i2));
        }
    }

    private T f() {
        return this.h;
    }

    private long h() {
        return this.h.a();
    }

    private void i() {
        this.t = null;
        this.p.j();
        x[] xVarArr = this.q;
        int length = xVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.l.a(this);
                return;
            } else {
                xVarArr[i2].j();
                i = i2 + 1;
            }
        }
    }

    private com.anythink.expressad.exoplayer.h.b.a j() {
        ArrayList<com.anythink.expressad.exoplayer.h.b.a> arrayList = this.n;
        return arrayList.get(arrayList.size() - 1);
    }

    @Override // com.anythink.expressad.exoplayer.h.y
    public final int a(long j) {
        int i = 0;
        if (a()) {
            return 0;
        }
        if (!this.f4593c || j <= this.p.g()) {
            int a2 = this.p.a(j, true);
            if (a2 != -1) {
                i = a2;
            }
        } else {
            i = this.p.k();
        }
        if (i > 0) {
            a(this.p.e(), i);
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d2 A[RETURN] */
    @Override // com.anythink.expressad.exoplayer.j.t.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ int a(com.anythink.expressad.exoplayer.h.b.c r21, long r22, long r24, java.io.IOException r26) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.b.f.a(com.anythink.expressad.exoplayer.j.t$c, long, long, java.io.IOException):int");
    }

    @Override // com.anythink.expressad.exoplayer.h.y
    public final int a(n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z) {
        if (a()) {
            return -3;
        }
        int a2 = this.p.a(nVar, eVar, z, this.f4593c, this.b);
        if (a2 == -4) {
            a(this.p.e(), 1);
        }
        return a2;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(c cVar, long j, long j2) {
        c cVar2 = cVar;
        this.j.a(cVar2.b, cVar2.f4586c, this.f4592a, cVar2.d, cVar2.e, cVar2.f, cVar2.g, cVar2.h, j, j2, cVar2.d());
        this.i.a(this);
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(c cVar, long j, long j2, boolean z) {
        c cVar2 = cVar;
        this.j.b(cVar2.b, cVar2.f4586c, this.f4592a, cVar2.d, cVar2.e, cVar2.f, cVar2.g, cVar2.h, j, j2, cVar2.d());
        if (z) {
            return;
        }
        this.p.a();
        x[] xVarArr = this.q;
        int length = xVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.i.a(this);
                return;
            } else {
                xVarArr[i2].a();
                i = i2 + 1;
            }
        }
    }

    final boolean a() {
        return this.u != com.anythink.expressad.exoplayer.b.b;
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final void a_(long j) {
        if (this.l.a() || a()) {
            return;
        }
        int size = this.n.size();
        int c2 = this.h.c();
        int i = c2;
        if (size <= c2) {
            return;
        }
        while (true) {
            if (i >= size) {
                i = size;
                break;
            } else if (!a(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i == size) {
            return;
        }
        long j2 = j().h;
        com.anythink.expressad.exoplayer.h.b.a d2 = d(i);
        if (this.n.isEmpty()) {
            this.u = this.v;
        }
        this.f4593c = false;
        this.j.a(this.f4592a, d2.g, j2);
    }

    @Override // com.anythink.expressad.exoplayer.h.y
    public final boolean b() {
        if (this.f4593c) {
            return true;
        }
        return !a() && this.p.c();
    }

    @Override // com.anythink.expressad.exoplayer.h.y
    public final void c() {
        this.l.c();
        this.l.a();
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j) {
        boolean z = false;
        if (this.f4593c || this.l.a()) {
            return false;
        }
        boolean a2 = a();
        if (!a2) {
            j();
        }
        boolean z2 = this.m.b;
        c cVar = this.m.f4591a;
        e eVar = this.m;
        eVar.f4591a = null;
        eVar.b = false;
        if (z2) {
            this.u = com.anythink.expressad.exoplayer.b.b;
            this.f4593c = true;
            return true;
        } else if (cVar == null) {
            return false;
        } else {
            if (cVar instanceof com.anythink.expressad.exoplayer.h.b.a) {
                com.anythink.expressad.exoplayer.h.b.a aVar = (com.anythink.expressad.exoplayer.h.b.a) cVar;
                if (a2) {
                    if (aVar.g == this.u) {
                        z = true;
                    }
                    this.b = z ? Long.MIN_VALUE : this.u;
                    this.u = com.anythink.expressad.exoplayer.b.b;
                }
                aVar.a(this.r);
                this.n.add(aVar);
            }
            this.j.a(cVar.b, cVar.f4586c, this.f4592a, cVar.d, cVar.e, cVar.f, cVar.g, cVar.h, this.l.a(cVar, this, this.k));
            return true;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final long d() {
        if (this.f4593c) {
            return Long.MIN_VALUE;
        }
        if (a()) {
            return this.u;
        }
        long j = this.v;
        com.anythink.expressad.exoplayer.h.b.a j2 = j();
        if (!j2.f()) {
            if (this.n.size() > 1) {
                ArrayList<com.anythink.expressad.exoplayer.h.b.a> arrayList = this.n;
                j2 = arrayList.get(arrayList.size() - 2);
            } else {
                j2 = null;
            }
        }
        long j3 = j;
        if (j2 != null) {
            j3 = Math.max(j, j2.h);
        }
        return Math.max(j3, this.p.g());
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final long e() {
        if (a()) {
            return this.u;
        }
        if (this.f4593c) {
            return Long.MIN_VALUE;
        }
        return j().h;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.d
    public final void g() {
        this.p.a();
        x[] xVarArr = this.q;
        int length = xVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            xVarArr[i2].a();
            i = i2 + 1;
        }
    }
}
