package com.opos.exoplayer.core;

import android.util.Pair;
import com.opos.exoplayer.core.e.a.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/y.class */
public abstract class y {

    /* renamed from: a  reason: collision with root package name */
    public static final y f25593a = new y() { // from class: com.opos.exoplayer.core.y.1
        @Override // com.opos.exoplayer.core.y
        public int a(Object obj) {
            return -1;
        }

        @Override // com.opos.exoplayer.core.y
        public a a(int i, a aVar, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.opos.exoplayer.core.y
        public b a(int i, b bVar, boolean z, long j) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.opos.exoplayer.core.y
        public int b() {
            return 0;
        }

        @Override // com.opos.exoplayer.core.y
        public int c() {
            return 0;
        }
    };

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/y$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Object f25594a;
        public Object b;

        /* renamed from: c  reason: collision with root package name */
        public int f25595c;
        public long d;
        private long e;
        private com.opos.exoplayer.core.e.a.a f;

        public int a(int i, int i2) {
            return this.f.d[i].a(i2);
        }

        public int a(long j) {
            return this.f.a(j);
        }

        public long a() {
            return this.d;
        }

        public long a(int i) {
            return this.f.f25277c[i];
        }

        public a a(Object obj, Object obj2, int i, long j, long j2) {
            return a(obj, obj2, i, j, j2, com.opos.exoplayer.core.e.a.a.f25276a);
        }

        public a a(Object obj, Object obj2, int i, long j, long j2, com.opos.exoplayer.core.e.a.a aVar) {
            this.f25594a = obj;
            this.b = obj2;
            this.f25595c = i;
            this.d = j;
            this.e = j2;
            this.f = aVar;
            return this;
        }

        public int b(int i) {
            return this.f.d[i].a();
        }

        public int b(long j) {
            return this.f.b(j);
        }

        public long b() {
            return com.opos.exoplayer.core.b.a(this.e);
        }

        public boolean b(int i, int i2) {
            a.C0658a c0658a = this.f.d[i];
            return (c0658a.f25280a == -1 || c0658a.f25281c[i2] == 0) ? false : true;
        }

        public long c() {
            return this.e;
        }

        public long c(int i, int i2) {
            a.C0658a c0658a = this.f.d[i];
            return c0658a.f25280a != -1 ? c0658a.d[i2] : com.anythink.expressad.exoplayer.b.b;
        }

        public boolean c(int i) {
            return !this.f.d[i].b();
        }

        public int d() {
            return this.f.b;
        }

        public int d(int i) {
            return this.f.d[i].f25280a;
        }

        public long e() {
            return this.f.e;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/y$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Object f25596a;
        public long b;

        /* renamed from: c  reason: collision with root package name */
        public long f25597c;
        public boolean d;
        public boolean e;
        public int f;
        public int g;
        public long h;
        public long i;
        public long j;

        public long a() {
            return this.h;
        }

        public b a(Object obj, long j, long j2, boolean z, boolean z2, long j3, long j4, int i, int i2, long j5) {
            this.f25596a = obj;
            this.b = j;
            this.f25597c = j2;
            this.d = z;
            this.e = z2;
            this.h = j3;
            this.i = j4;
            this.f = i;
            this.g = i2;
            this.j = j5;
            return this;
        }

        public long b() {
            return com.opos.exoplayer.core.b.a(this.i);
        }

        public long c() {
            return this.j;
        }
    }

    public int a(int i, int i2, boolean z) {
        int i3;
        if (i2 != 0) {
            i3 = i;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException();
                }
                if (i == a(z)) {
                    return b(z);
                }
            }
            return i3;
        } else if (i == a(z)) {
            return -1;
        }
        i3 = i + 1;
        return i3;
    }

    public final int a(int i, a aVar, b bVar, int i2, boolean z) {
        int i3 = a(i, aVar).f25595c;
        if (a(i3, bVar).g == i) {
            int a2 = a(i3, i2, z);
            if (a2 == -1) {
                return -1;
            }
            return a(a2, bVar).f;
        }
        return i + 1;
    }

    public abstract int a(Object obj);

    public int a(boolean z) {
        if (a()) {
            return -1;
        }
        return b() - 1;
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i, long j) {
        return a(bVar, aVar, i, j, 0L);
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i, long j, long j2) {
        com.opos.exoplayer.core.i.a.a(i, 0, b());
        a(i, bVar, false, j2);
        long j3 = j;
        if (j == com.anythink.expressad.exoplayer.b.b) {
            long a2 = bVar.a();
            j3 = a2;
            if (a2 == com.anythink.expressad.exoplayer.b.b) {
                return null;
            }
        }
        int i2 = bVar.f;
        long c2 = bVar.c() + j3;
        while (true) {
            long a3 = a(i2, aVar).a();
            if (a3 == com.anythink.expressad.exoplayer.b.b || c2 < a3 || i2 >= bVar.g) {
                break;
            }
            c2 -= a3;
            i2++;
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(c2));
    }

    public final a a(int i, a aVar) {
        return a(i, aVar, false);
    }

    public abstract a a(int i, a aVar, boolean z);

    public final b a(int i, b bVar) {
        return a(i, bVar, false);
    }

    public final b a(int i, b bVar, boolean z) {
        return a(i, bVar, z, 0L);
    }

    public abstract b a(int i, b bVar, boolean z, long j);

    public final boolean a() {
        return b() == 0;
    }

    public abstract int b();

    public int b(int i, int i2, boolean z) {
        int i3;
        if (i2 != 0) {
            i3 = i;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException();
                }
                if (i == b(z)) {
                    return a(z);
                }
            }
            return i3;
        } else if (i == b(z)) {
            return -1;
        }
        i3 = i - 1;
        return i3;
    }

    public int b(boolean z) {
        return a() ? -1 : 0;
    }

    public final boolean b(int i, a aVar, b bVar, int i2, boolean z) {
        return a(i, aVar, bVar, i2, z) == -1;
    }

    public abstract int c();
}
