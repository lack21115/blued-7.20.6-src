package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.i.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/i.class */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private final e f25174a = new e();
    private n b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.exoplayer.core.c.g f25175c;
    private g d;
    private long e;
    private long f;
    private long g;
    private int h;
    private int i;
    private a j;
    private long k;
    private boolean l;
    private boolean m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/i$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        Format f25176a;
        g b;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/i$b.class */
    public static final class b implements g {
        private b() {
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public long a(long j) {
            return 0L;
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public long a(com.opos.exoplayer.core.c.f fVar) {
            return -1L;
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public l c() {
            return new l.b(com.anythink.expressad.exoplayer.b.b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [com.opos.exoplayer.core.c.e.g] */
    private int a(com.opos.exoplayer.core.c.f fVar) {
        b bVar;
        boolean z = true;
        while (z) {
            if (!this.f25174a.a(fVar)) {
                this.h = 3;
                return -1;
            }
            this.k = fVar.c() - this.f;
            boolean a2 = a(this.f25174a.c(), this.f, this.j);
            z = a2;
            if (a2) {
                this.f = fVar.c();
                z = a2;
            }
        }
        this.i = this.j.f25176a.s;
        if (!this.m) {
            this.b.a(this.j.f25176a);
            this.m = true;
        }
        if (this.j.b != null) {
            bVar = this.j.b;
        } else if (fVar.d() != -1) {
            f b2 = this.f25174a.b();
            this.d = new c(this.f, fVar.d(), this, b2.i + b2.h, b2.f25171c);
            this.j = null;
            this.h = 2;
            this.f25174a.d();
            return 0;
        } else {
            bVar = new b();
        }
        this.d = bVar;
        this.j = null;
        this.h = 2;
        this.f25174a.d();
        return 0;
    }

    private int b(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        long a2 = this.d.a(fVar);
        if (a2 >= 0) {
            kVar.f25249a = a2;
            return 1;
        }
        if (a2 < -1) {
            c(-(a2 + 2));
        }
        if (!this.l) {
            this.f25175c.a(this.d.c());
            this.l = true;
        }
        if (this.k <= 0 && !this.f25174a.a(fVar)) {
            this.h = 3;
            return -1;
        }
        this.k = 0L;
        m c2 = this.f25174a.c();
        long b2 = b(c2);
        if (b2 >= 0) {
            long j = this.g;
            if (j + b2 >= this.e) {
                long a3 = a(j);
                this.b.a(c2, c2.c());
                this.b.a(a3, 1, c2.c(), 0, null);
                this.e = -1L;
            }
        }
        this.g += b2;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(com.opos.exoplayer.core.c.f fVar, com.opos.exoplayer.core.c.k kVar) {
        int i = this.h;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return b(fVar, kVar);
                }
                throw new IllegalStateException();
            }
            fVar.b((int) this.f);
            this.h = 2;
            return 0;
        }
        return a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long a(long j) {
        return (j * 1000000) / this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(long j, long j2) {
        this.f25174a.a();
        if (j == 0) {
            a(!this.l);
        } else if (this.h != 0) {
            this.e = this.d.a(j2);
            this.h = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.opos.exoplayer.core.c.g gVar, n nVar) {
        this.f25175c = gVar;
        this.b = nVar;
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        int i;
        if (z) {
            this.j = new a();
            this.f = 0L;
            i = 0;
        } else {
            i = 1;
        }
        this.h = i;
        this.e = -1L;
        this.g = 0L;
    }

    protected abstract boolean a(m mVar, long j, a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public long b(long j) {
        return (this.i * j) / 1000000;
    }

    protected abstract long b(m mVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(long j) {
        this.g = j;
    }
}
