package com.anythink.expressad.exoplayer.h;

import com.anythink.expressad.exoplayer.h.r;
import com.anythink.expressad.exoplayer.h.t;
import com.anythink.expressad.exoplayer.j.h;
import com.anythink.expressad.exoplayer.j.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/ac.class */
public final class ac implements r, t.a<b> {
    private static final int i = 1024;
    final com.anythink.expressad.exoplayer.m b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f4568c;
    boolean d;
    boolean e;
    boolean f;
    byte[] g;
    int h;
    private final com.anythink.expressad.exoplayer.j.k j;
    private final h.a k;
    private final int l;
    private final t.a m;
    private final af n;
    private final long p;
    private int q;
    private final ArrayList<a> o = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    final com.anythink.expressad.exoplayer.j.t f4567a = new com.anythink.expressad.exoplayer.j.t("Loader:SingleSampleMediaPeriod");

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/ac$a.class */
    final class a implements y {
        private static final int b = 0;

        /* renamed from: c  reason: collision with root package name */
        private static final int f4569c = 1;
        private static final int d = 2;
        private int e;
        private boolean f;

        private a() {
        }

        /* synthetic */ a(ac acVar, byte b2) {
            this();
        }

        private void d() {
            if (this.f) {
                return;
            }
            ac.this.m.a(com.anythink.expressad.exoplayer.k.o.d(ac.this.b.h), ac.this.b, 0, (Object) null, 0L);
            this.f = true;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(long j) {
            if (j <= 0 || this.e == 2) {
                return 0;
            }
            this.e = 2;
            d();
            return 1;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z) {
            int i = this.e;
            if (i == 2) {
                eVar.b(4);
                return -4;
            } else if (z || i == 0) {
                nVar.f4882a = ac.this.b;
                this.e = 1;
                return -5;
            } else if (ac.this.e) {
                if (ac.this.f) {
                    eVar.f = 0L;
                    eVar.b(1);
                    eVar.d(ac.this.h);
                    eVar.e.put(ac.this.g, 0, ac.this.h);
                    d();
                } else {
                    eVar.b(4);
                }
                this.e = 2;
                return -4;
            } else {
                return -3;
            }
        }

        public final void a() {
            if (this.e == 2) {
                this.e = 1;
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final boolean b() {
            return ac.this.e;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final void c() {
            if (ac.this.f4568c) {
                return;
            }
            ac.this.f4567a.c();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/ac$b.class */
    static final class b implements t.c {

        /* renamed from: a  reason: collision with root package name */
        public final com.anythink.expressad.exoplayer.j.k f4571a;
        private final com.anythink.expressad.exoplayer.j.h b;

        /* renamed from: c  reason: collision with root package name */
        private int f4572c;
        private byte[] d;

        public b(com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.j.h hVar) {
            this.f4571a = kVar;
            this.b = hVar;
        }

        @Override // com.anythink.expressad.exoplayer.j.t.c
        public final void a() {
        }

        @Override // com.anythink.expressad.exoplayer.j.t.c
        public final void b() {
            int i = 0;
            this.f4572c = 0;
            try {
                this.b.a(this.f4571a);
                while (i != -1) {
                    int i2 = this.f4572c + i;
                    this.f4572c = i2;
                    if (this.d == null) {
                        this.d = new byte[1024];
                    } else if (i2 == this.d.length) {
                        this.d = Arrays.copyOf(this.d, this.d.length * 2);
                    }
                    i = this.b.a(this.d, this.f4572c, this.d.length - this.f4572c);
                }
            } finally {
                com.anythink.expressad.exoplayer.k.af.a(this.b);
            }
        }
    }

    public ac(com.anythink.expressad.exoplayer.j.k kVar, h.a aVar, com.anythink.expressad.exoplayer.m mVar, long j, int i2, t.a aVar2, boolean z) {
        this.j = kVar;
        this.k = aVar;
        this.b = mVar;
        this.p = j;
        this.l = i2;
        this.m = aVar2;
        this.f4568c = z;
        this.n = new af(new ae(mVar));
        aVar2.a();
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private int a2(b bVar, long j, long j2, IOException iOException) {
        int i2 = this.q + 1;
        this.q = i2;
        boolean z = this.f4568c && i2 >= this.l;
        this.m.a(bVar.f4571a, 1, -1, this.b, 0, null, 0L, this.p, j, j2, bVar.f4572c, iOException, z);
        if (z) {
            this.e = true;
            return 2;
        }
        return 0;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private void a2(b bVar, long j, long j2) {
        this.m.a(bVar.f4571a, 1, -1, this.b, 0, null, 0L, this.p, j, j2, bVar.f4572c);
        this.h = bVar.f4572c;
        this.g = bVar.d;
        this.e = true;
        this.f = true;
    }

    private void b(b bVar, long j, long j2) {
        this.m.b(bVar.f4571a, 1, -1, null, 0, null, 0L, this.p, j, j2, bVar.f4572c);
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* bridge */ /* synthetic */ int a(b bVar, long j, long j2, IOException iOException) {
        b bVar2 = bVar;
        int i2 = this.q + 1;
        this.q = i2;
        boolean z = this.f4568c && i2 >= this.l;
        this.m.a(bVar2.f4571a, 1, -1, this.b, 0, null, 0L, this.p, j, j2, bVar2.f4572c, iOException, z);
        if (z) {
            this.e = true;
            return 2;
        }
        return 0;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(long j, com.anythink.expressad.exoplayer.ac acVar) {
        return j;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(com.anythink.expressad.exoplayer.i.f[] fVarArr, boolean[] zArr, y[] yVarArr, boolean[] zArr2, long j) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= fVarArr.length) {
                return j;
            }
            if (yVarArr[i3] != null && (fVarArr[i3] == null || !zArr[i3])) {
                this.o.remove(yVarArr[i3]);
                yVarArr[i3] = null;
            }
            if (yVarArr[i3] == null && fVarArr[i3] != null) {
                a aVar = new a(this, (byte) 0);
                this.o.add(aVar);
                yVarArr[i3] = aVar;
                zArr2[i3] = true;
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a() {
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(long j, boolean z) {
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(r.a aVar, long j) {
        aVar.a((r) this);
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(b bVar, long j, long j2) {
        b bVar2 = bVar;
        this.m.a(bVar2.f4571a, 1, -1, this.b, 0, null, 0L, this.p, j, j2, bVar2.f4572c);
        this.h = bVar2.f4572c;
        this.g = bVar2.d;
        this.e = true;
        this.f = true;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(b bVar, long j, long j2, boolean z) {
        b bVar2 = bVar;
        this.m.b(bVar2.f4571a, 1, -1, null, 0, null, 0L, this.p, j, j2, bVar2.f4572c);
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final void a_(long j) {
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long b(long j) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.o.size()) {
                return j;
            }
            this.o.get(i3).a();
            i2 = i3 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final af b() {
        return this.n;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long c() {
        if (this.d) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        this.m.c();
        this.d = true;
        return com.anythink.expressad.exoplayer.b.b;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j) {
        if (this.e || this.f4567a.a()) {
            return false;
        }
        this.m.a(this.j, 1, -1, this.b, 0, null, 0L, this.p, this.f4567a.a(new b(this.j, this.k.a()), this, this.l));
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long d() {
        return this.e ? Long.MIN_VALUE : 0L;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long e() {
        return (this.e || this.f4567a.a()) ? Long.MIN_VALUE : 0L;
    }

    public final void f() {
        this.f4567a.a((t.d) null);
        this.m.b();
    }
}
