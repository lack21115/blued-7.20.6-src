package com.anythink.expressad.exoplayer.h;

import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.h.s;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/e.class */
public final class e extends f<Void> {

    /* renamed from: a  reason: collision with root package name */
    private final s f4604a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f4605c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final ArrayList<d> g;
    private final ae.b h;
    private Object i;
    private a j;
    private b k;
    private long l;
    private long m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/e$a.class */
    public static final class a extends p {

        /* renamed from: c  reason: collision with root package name */
        private final long f4606c;
        private final long d;
        private final long e;
        private final boolean f;

        public a(com.anythink.expressad.exoplayer.ae aeVar, long j, long j2) {
            super(aeVar);
            boolean z;
            if (aeVar.c() != 1) {
                throw new b(0);
            }
            ae.b a2 = aeVar.a(0, new ae.b(), false);
            long max = Math.max(0L, j);
            long max2 = j2 == Long.MIN_VALUE ? a2.i : Math.max(0L, j2);
            long j3 = max2;
            if (a2.i != com.anythink.expressad.exoplayer.b.b) {
                j3 = max2 > a2.i ? a2.i : max2;
                if (max != 0 && !a2.d) {
                    throw new b(1);
                }
                if (max > j3) {
                    throw new b(2);
                }
            }
            this.f4606c = max;
            this.d = j3;
            int i = (j3 > com.anythink.expressad.exoplayer.b.b ? 1 : (j3 == com.anythink.expressad.exoplayer.b.b ? 0 : -1));
            this.e = i == 0 ? -9223372036854775807L : j3 - max;
            if (a2.e) {
                z = true;
                if (i != 0) {
                    if (a2.i != com.anythink.expressad.exoplayer.b.b && j3 == a2.i) {
                        z = true;
                    }
                }
                this.f = z;
            }
            z = false;
            this.f = z;
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final ae.a a(int i, ae.a aVar, boolean z) {
            this.b.a(0, aVar, z);
            long b = aVar.b() - this.f4606c;
            long j = this.e;
            return aVar.a(aVar.f4322a, aVar.b, j == com.anythink.expressad.exoplayer.b.b ? -9223372036854775807L : j - b, b);
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final ae.b a(int i, ae.b bVar, boolean z, long j) {
            this.b.a(0, bVar, z, 0L);
            bVar.j += this.f4606c;
            bVar.i = this.e;
            bVar.e = this.f;
            if (bVar.h != com.anythink.expressad.exoplayer.b.b) {
                bVar.h = Math.max(bVar.h, this.f4606c);
                bVar.h = this.d == com.anythink.expressad.exoplayer.b.b ? bVar.h : Math.min(bVar.h, this.d);
                bVar.h -= this.f4606c;
            }
            long a2 = com.anythink.expressad.exoplayer.b.a(this.f4606c);
            if (bVar.b != com.anythink.expressad.exoplayer.b.b) {
                bVar.b += a2;
            }
            if (bVar.f4325c != com.anythink.expressad.exoplayer.b.b) {
                bVar.f4325c += a2;
            }
            return bVar;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/e$b.class */
    public static final class b extends IOException {

        /* renamed from: a  reason: collision with root package name */
        public static final int f4607a = 0;
        public static final int b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f4608c = 2;
        public final int d;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/e$b$a.class */
        public @interface a {
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public b(int r5) {
            /*
                r4 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = r0
                java.lang.String r2 = "Illegal clipping: "
                r1.<init>(r2)
                r7 = r0
                r0 = r5
                if (r0 == 0) goto L2a
                r0 = r5
                r1 = 1
                if (r0 == r1) goto L24
                r0 = r5
                r1 = 2
                if (r0 == r1) goto L1e
                java.lang.String r0 = "unknown"
                r6 = r0
                goto L2d
            L1e:
                java.lang.String r0 = "start exceeds end"
                r6 = r0
                goto L2d
            L24:
                java.lang.String r0 = "not seekable to start"
                r6 = r0
                goto L2d
            L2a:
                java.lang.String r0 = "invalid period count"
                r6 = r0
            L2d:
                r0 = r7
                r1 = r6
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r4
                r1 = r7
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                r0 = r4
                r1 = r5
                r0.d = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.e.b.<init>(int):void");
        }

        private static String a(int i) {
            return i != 0 ? i != 1 ? i != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    private e(s sVar, long j) {
        this(sVar, 0L, j, true, true);
    }

    private e(s sVar, long j, long j2) {
        this(sVar, j, j2, true, false);
    }

    @Deprecated
    private e(s sVar, long j, long j2, boolean z) {
        this(sVar, j, j2, z, false);
    }

    private e(s sVar, long j, long j2, boolean z, boolean z2) {
        com.anythink.expressad.exoplayer.k.a.a(j >= 0);
        this.f4604a = (s) com.anythink.expressad.exoplayer.k.a.a(sVar);
        this.b = j;
        this.f4605c = j2;
        this.d = z;
        this.e = false;
        this.f = z2;
        this.g = new ArrayList<>();
        this.h = new ae.b();
    }

    private void a(com.anythink.expressad.exoplayer.ae aeVar) {
        long j;
        long j2;
        aeVar.a(0, this.h, false);
        long j3 = this.h.j;
        if (this.j == null || this.g.isEmpty() || this.e) {
            long j4 = this.b;
            long j5 = this.f4605c;
            j = j4;
            j2 = j5;
            if (this.f) {
                long j6 = this.h.h;
                j = j4 + j6;
                j2 = j5 + j6;
            }
            this.l = j3 + j;
            this.m = this.f4605c != Long.MIN_VALUE ? j3 + j2 : Long.MIN_VALUE;
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                this.g.get(i).a(this.l, this.m);
            }
        } else {
            long j7 = this.l;
            j2 = this.f4605c == Long.MIN_VALUE ? Long.MIN_VALUE : this.m - j3;
            j = j7 - j3;
        }
        try {
            a aVar = new a(aeVar, j, j2);
            this.j = aVar;
            a(aVar, this.i);
        } catch (b e) {
            this.k = e;
        }
    }

    private long b(long j) {
        if (j == com.anythink.expressad.exoplayer.b.b) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        long a2 = com.anythink.expressad.exoplayer.b.a(this.b);
        long max = Math.max(0L, j - a2);
        long j2 = this.f4605c;
        long j3 = max;
        if (j2 != Long.MIN_VALUE) {
            j3 = Math.min(com.anythink.expressad.exoplayer.b.a(j2) - a2, max);
        }
        return j3;
    }

    private void b(com.anythink.expressad.exoplayer.ae aeVar, Object obj) {
        if (this.k != null) {
            return;
        }
        this.i = obj;
        a(aeVar);
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    protected final /* synthetic */ long a(long j) {
        if (j == com.anythink.expressad.exoplayer.b.b) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        long a2 = com.anythink.expressad.exoplayer.b.a(this.b);
        long max = Math.max(0L, j - a2);
        long j2 = this.f4605c;
        long j3 = max;
        if (j2 != Long.MIN_VALUE) {
            j3 = Math.min(com.anythink.expressad.exoplayer.b.a(j2) - a2, max);
        }
        return j3;
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        d dVar = new d(this.f4604a.a(aVar, bVar), this.d, this.l, this.m);
        this.g.add(dVar);
        return dVar;
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a() {
        super.a();
        this.k = null;
        this.j = null;
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(r rVar) {
        com.anythink.expressad.exoplayer.k.a.b(this.g.remove(rVar));
        this.f4604a.a(((d) rVar).f4600a);
        if (!this.g.isEmpty() || this.e) {
            return;
        }
        a(this.j.b);
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z) {
        super.a(hVar, z);
        a((e) null, this.f4604a);
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    protected final /* bridge */ /* synthetic */ void a(Void r4, s sVar, com.anythink.expressad.exoplayer.ae aeVar, Object obj) {
        if (this.k == null) {
            this.i = obj;
            a(aeVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.s
    public final void b() {
        b bVar = this.k;
        if (bVar != null) {
            throw bVar;
        }
        super.b();
    }
}
