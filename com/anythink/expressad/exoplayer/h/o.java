package com.anythink.expressad.exoplayer.h;

import android.net.Uri;
import android.os.Handler;
import com.anythink.expressad.exoplayer.h.a.c;
import com.anythink.expressad.exoplayer.h.n;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.h.t;
import com.anythink.expressad.exoplayer.j.h;
import java.io.IOException;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/o.class */
public final class o extends com.anythink.expressad.exoplayer.h.c implements n.c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7476a = 3;
    public static final int b = 6;

    /* renamed from: c  reason: collision with root package name */
    public static final int f7477c = -1;
    public static final int d = 1048576;
    private final Uri e;
    private final h.a f;
    private final com.anythink.expressad.exoplayer.e.h g;
    private final int h;
    private final String i;
    private final int j;
    private final Object k;
    private long l;
    private boolean m;

    @Deprecated
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/o$a.class */
    public interface a {
        void a();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/o$b.class */
    static final class b extends k {

        /* renamed from: a  reason: collision with root package name */
        private final a f7478a;

        public b(a aVar) {
            this.f7478a = (a) com.anythink.expressad.exoplayer.k.a.a(aVar);
        }

        @Override // com.anythink.expressad.exoplayer.h.k, com.anythink.expressad.exoplayer.h.t
        public final void a(int i, s.a aVar, t.b bVar, t.c cVar, IOException iOException, boolean z) {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/o$c.class */
    public static final class c implements c.e {

        /* renamed from: a  reason: collision with root package name */
        private final h.a f7479a;
        private com.anythink.expressad.exoplayer.e.h b;

        /* renamed from: c  reason: collision with root package name */
        private String f7480c;
        private Object d;
        private int e = -1;
        private int f = 1048576;
        private boolean g;

        public c(h.a aVar) {
            this.f7479a = aVar;
        }

        private c a(int i) {
            com.anythink.expressad.exoplayer.k.a.b(!this.g);
            this.e = i;
            return this;
        }

        private c a(com.anythink.expressad.exoplayer.e.h hVar) {
            com.anythink.expressad.exoplayer.k.a.b(!this.g);
            this.b = hVar;
            return this;
        }

        private c a(Object obj) {
            com.anythink.expressad.exoplayer.k.a.b(!this.g);
            this.d = obj;
            return this;
        }

        private c a(String str) {
            com.anythink.expressad.exoplayer.k.a.b(!this.g);
            this.f7480c = str;
            return this;
        }

        @Deprecated
        private o a(Uri uri, Handler handler, t tVar) {
            o b = b(uri);
            if (handler != null && tVar != null) {
                b.a(handler, tVar);
            }
            return b;
        }

        private c b(int i) {
            com.anythink.expressad.exoplayer.k.a.b(!this.g);
            this.f = i;
            return this;
        }

        @Override // com.anythink.expressad.exoplayer.h.a.c.e
        /* renamed from: a */
        public final o b(Uri uri) {
            this.g = true;
            if (this.b == null) {
                this.b = new com.anythink.expressad.exoplayer.e.c();
            }
            return new o(uri, this.f7479a, this.b, this.e, this.f7480c, this.f, this.d, (byte) 0);
        }

        @Override // com.anythink.expressad.exoplayer.h.a.c.e
        public final int[] a() {
            return new int[]{3};
        }
    }

    private o(Uri uri, h.a aVar, com.anythink.expressad.exoplayer.e.h hVar, int i, String str, int i2, Object obj) {
        this.e = uri;
        this.f = aVar;
        this.g = hVar;
        this.h = i;
        this.i = str;
        this.j = i2;
        this.l = com.anythink.expressad.exoplayer.b.b;
        this.k = obj;
    }

    /* synthetic */ o(Uri uri, h.a aVar, com.anythink.expressad.exoplayer.e.h hVar, int i, String str, int i2, Object obj, byte b2) {
        this(uri, aVar, hVar, i, str, i2, obj);
    }

    @Deprecated
    private o(Uri uri, h.a aVar, com.anythink.expressad.exoplayer.e.h hVar, Handler handler, a aVar2) {
        this(uri, aVar, hVar, handler, aVar2, null);
    }

    @Deprecated
    private o(Uri uri, h.a aVar, com.anythink.expressad.exoplayer.e.h hVar, Handler handler, a aVar2, String str) {
        this(uri, aVar, hVar, handler, aVar2, str, (byte) 0);
    }

    @Deprecated
    private o(Uri uri, h.a aVar, com.anythink.expressad.exoplayer.e.h hVar, Handler handler, a aVar2, String str, byte b2) {
        this(uri, aVar, hVar, -1, str, 1048576, (Object) null);
        if (aVar2 == null || handler == null) {
            return;
        }
        a(handler, new b(aVar2));
    }

    private void b(long j, boolean z) {
        this.l = j;
        this.m = z;
        a(new ab(j, z, false, this.k), (Object) null);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        com.anythink.expressad.exoplayer.k.a.a(aVar.f7484a == 0);
        return new n(this.e, this.f.a(), this.g.a(), this.h, a(aVar), this, bVar, this.i, this.j);
    }

    @Override // com.anythink.expressad.exoplayer.h.c
    public final void a() {
    }

    @Override // com.anythink.expressad.exoplayer.h.n.c
    public final void a(long j, boolean z) {
        long j2 = j;
        if (j == com.anythink.expressad.exoplayer.b.b) {
            j2 = this.l;
        }
        if (this.l == j2 && this.m == z) {
            return;
        }
        b(j2, z);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(r rVar) {
        ((n) rVar).f();
    }

    @Override // com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z) {
        b(this.l, false);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void b() {
    }
}
