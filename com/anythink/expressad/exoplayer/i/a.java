package com.anythink.expressad.exoplayer.i;

import com.anythink.expressad.exoplayer.h.ae;
import com.anythink.expressad.exoplayer.i.f;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.m;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/a.class */
public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4682a = 10000;
    public static final int b = 25000;

    /* renamed from: c  reason: collision with root package name */
    public static final int f4683c = 25000;
    public static final float d = 0.75f;
    public static final float e = 0.75f;
    public static final long f = 2000;
    private final com.anythink.expressad.exoplayer.j.d j;
    private final long k;
    private final long l;
    private final long m;
    private final float n;
    private final float o;
    private final long p;
    private final com.anythink.expressad.exoplayer.k.c q;
    private float r;
    private int s;
    private int t;
    private long u;

    /* renamed from: com.anythink.expressad.exoplayer.i.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/a$a.class */
    public static final class C0064a implements f.a {

        /* renamed from: a  reason: collision with root package name */
        private final com.anythink.expressad.exoplayer.j.d f4684a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4685c;
        private final int d;
        private final float e;
        private final float f;
        private final long g;
        private final com.anythink.expressad.exoplayer.k.c h;

        public C0064a(com.anythink.expressad.exoplayer.j.d dVar) {
            this(dVar, 10000, 25000, 25000, 0.75f, com.anythink.expressad.exoplayer.k.c.f4801a);
        }

        private C0064a(com.anythink.expressad.exoplayer.j.d dVar, int i, int i2, int i3, float f) {
            this(dVar, i, i2, i3, f, com.anythink.expressad.exoplayer.k.c.f4801a);
        }

        private C0064a(com.anythink.expressad.exoplayer.j.d dVar, int i, int i2, int i3, float f, com.anythink.expressad.exoplayer.k.c cVar) {
            this.f4684a = dVar;
            this.b = i;
            this.f4685c = i2;
            this.d = i3;
            this.e = f;
            this.f = 0.75f;
            this.g = 2000L;
            this.h = cVar;
        }

        private a b(ae aeVar, int... iArr) {
            return new a(aeVar, iArr, this.f4684a, this.b, this.f4685c, this.d, this.e, this.f, this.g, this.h);
        }

        @Override // com.anythink.expressad.exoplayer.i.f.a
        public final /* synthetic */ f a(ae aeVar, int[] iArr) {
            return new a(aeVar, iArr, this.f4684a, this.b, this.f4685c, this.d, this.e, this.f, this.g, this.h);
        }
    }

    private a(ae aeVar, int[] iArr, com.anythink.expressad.exoplayer.j.d dVar) {
        this(aeVar, iArr, dVar, 10000L, 25000L, 25000L, 0.75f, 0.75f, 2000L, com.anythink.expressad.exoplayer.k.c.f4801a);
    }

    public a(ae aeVar, int[] iArr, com.anythink.expressad.exoplayer.j.d dVar, long j, long j2, long j3, float f2, float f3, long j4, com.anythink.expressad.exoplayer.k.c cVar) {
        super(aeVar, iArr);
        this.j = dVar;
        this.k = j * 1000;
        this.l = j2 * 1000;
        this.m = j3 * 1000;
        this.n = f2;
        this.o = f3;
        this.p = j4;
        this.q = cVar;
        this.r = 1.0f;
        this.t = 1;
        this.u = com.anythink.expressad.exoplayer.b.b;
        this.s = a(Long.MIN_VALUE);
    }

    private int a(long j) {
        long a2 = ((float) this.j.a()) * this.n;
        int i = 0;
        for (int i2 = 0; i2 < this.h; i2++) {
            if (j == Long.MIN_VALUE || !b(i2, j)) {
                if (Math.round(a(i2).d * this.r) <= a2) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    private long b(long j) {
        return (j > com.anythink.expressad.exoplayer.b.b ? 1 : (j == com.anythink.expressad.exoplayer.b.b ? 0 : -1)) != 0 && (j > this.k ? 1 : (j == this.k ? 0 : -1)) <= 0 ? ((float) j) * this.o : this.k;
    }

    @Override // com.anythink.expressad.exoplayer.i.b, com.anythink.expressad.exoplayer.i.f
    public final int a(long j, List<? extends com.anythink.expressad.exoplayer.h.b.i> list) {
        long a2 = this.q.a();
        long j2 = this.u;
        if (j2 == com.anythink.expressad.exoplayer.b.b || a2 - j2 >= this.p) {
            this.u = a2;
            if (list.isEmpty()) {
                return 0;
            }
            int size = list.size();
            if (af.b(list.get(size - 1).g - j, this.r) < this.m) {
                return size;
            }
            m a3 = a(a(a2));
            for (int i = 0; i < size; i++) {
                com.anythink.expressad.exoplayer.h.b.i iVar = list.get(i);
                m mVar = iVar.d;
                if (af.b(iVar.g - j, this.r) >= this.m && mVar.d < a3.d && mVar.n != -1 && mVar.n < 720 && mVar.m != -1 && mVar.m < 1280 && mVar.n < a3.n) {
                    return i;
                }
            }
            return size;
        }
        return list.size();
    }

    @Override // com.anythink.expressad.exoplayer.i.b, com.anythink.expressad.exoplayer.i.f
    public final void a() {
        this.u = com.anythink.expressad.exoplayer.b.b;
    }

    @Override // com.anythink.expressad.exoplayer.i.b, com.anythink.expressad.exoplayer.i.f
    public final void a(float f2) {
        this.r = f2;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final void a(long j, long j2) {
        long a2 = this.q.a();
        int i = this.s;
        int a3 = a(a2);
        this.s = a3;
        if (a3 == i) {
            return;
        }
        if (!b(i, a2)) {
            m a4 = a(i);
            m a5 = a(this.s);
            if (a5.d > a4.d) {
                if (j < ((j2 > com.anythink.expressad.exoplayer.b.b ? 1 : (j2 == com.anythink.expressad.exoplayer.b.b ? 0 : -1)) != 0 && (j2 > this.k ? 1 : (j2 == this.k ? 0 : -1)) <= 0 ? ((float) j2) * this.o : this.k)) {
                    this.s = i;
                }
            }
            if (a5.d < a4.d && j >= this.l) {
                this.s = i;
            }
        }
        if (this.s != i) {
            this.t = 3;
        }
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int b() {
        return this.s;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int c() {
        return this.t;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final Object d() {
        return null;
    }
}
