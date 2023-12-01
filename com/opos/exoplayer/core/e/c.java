package com.opos.exoplayer.core.e;

import android.net.Uri;
import android.os.Handler;
import com.opos.exoplayer.core.e.e;
import com.opos.exoplayer.core.e.f;
import com.opos.exoplayer.core.e.o;
import com.opos.exoplayer.core.h.g;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/c.class */
public final class c implements e, o.c {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f11594a;
    private final g.a b;

    /* renamed from: c  reason: collision with root package name */
    private final com.opos.exoplayer.core.c.h f11595c;
    private final int d;
    private final f.a e;
    private final String f;
    private final int g;
    private e.a h;
    private long i;
    private boolean j;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/c$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final g.a f11596a;
        private com.opos.exoplayer.core.c.h b;

        /* renamed from: c  reason: collision with root package name */
        private String f11597c;
        private int d = -1;
        private int e = 1048576;
        private boolean f;

        public a(g.a aVar) {
            this.f11596a = aVar;
        }

        public c a(Uri uri) {
            return a(uri, null, null);
        }

        public c a(Uri uri, Handler handler, f fVar) {
            this.f = true;
            if (this.b == null) {
                this.b = new com.opos.exoplayer.core.c.c();
            }
            return new c(uri, this.f11596a, this.b, this.d, handler, fVar, this.f11597c, this.e);
        }
    }

    private c(Uri uri, g.a aVar, com.opos.exoplayer.core.c.h hVar, int i, Handler handler, f fVar, String str, int i2) {
        this.f11594a = uri;
        this.b = aVar;
        this.f11595c = hVar;
        this.d = i;
        this.e = new f.a(handler, fVar);
        this.f = str;
        this.g = i2;
    }

    private void b(long j, boolean z) {
        this.i = j;
        this.j = z;
        this.h.a(this, new k(j, z, false), null);
    }

    @Override // com.opos.exoplayer.core.e.e
    public d a(e.b bVar, com.opos.exoplayer.core.h.b bVar2) {
        com.opos.exoplayer.core.i.a.a(bVar.f11598a == 0);
        return new o(this.f11594a, this.b.a(), this.f11595c.a(), this.d, this.e, this, bVar2, this.f, this.g);
    }

    @Override // com.opos.exoplayer.core.e.e
    public void a() {
    }

    @Override // com.opos.exoplayer.core.e.o.c
    public void a(long j, boolean z) {
        long j2 = j;
        if (j == com.anythink.expressad.exoplayer.b.b) {
            j2 = this.i;
        }
        if (this.i == j2 && this.j == z) {
            return;
        }
        b(j2, z);
    }

    @Override // com.opos.exoplayer.core.e.e
    public void a(d dVar) {
        ((o) dVar).f();
    }

    @Override // com.opos.exoplayer.core.e.e
    public void a(com.opos.exoplayer.core.i iVar, boolean z, e.a aVar) {
        this.h = aVar;
        b(com.anythink.expressad.exoplayer.b.b, false);
    }

    @Override // com.opos.exoplayer.core.e.e
    public void b() {
        this.h = null;
    }
}
