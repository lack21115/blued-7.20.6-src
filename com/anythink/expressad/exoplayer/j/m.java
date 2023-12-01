package com.anythink.expressad.exoplayer.j;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.anythink.expressad.exoplayer.j.d;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/m.class */
public final class m implements aa<Object>, d {

    /* renamed from: a  reason: collision with root package name */
    public static final long f7587a = 1000000;
    public static final int b = 2000;

    /* renamed from: c  reason: collision with root package name */
    private static final int f7588c = 2000;
    private static final int d = 524288;
    private final Handler e;
    private final d.a f;
    private final com.anythink.expressad.exoplayer.k.y g;
    private final com.anythink.expressad.exoplayer.k.c h;
    private int i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;

    /* renamed from: com.anythink.expressad.exoplayer.j.m$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/m$1.class */
    final class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f7589a;
        final /* synthetic */ long b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f7590c;

        AnonymousClass1(int i, long j, long j2) {
            this.f7589a = i;
            this.b = j;
            this.f7590c = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            m.this.f.c();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/m$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Handler f7591a;
        private d.a b;

        /* renamed from: c  reason: collision with root package name */
        private long f7592c = 1000000;
        private int d = 2000;
        private com.anythink.expressad.exoplayer.k.c e = com.anythink.expressad.exoplayer.k.c.f7640a;

        private a a(int i) {
            this.d = i;
            return this;
        }

        private a a(long j) {
            this.f7592c = j;
            return this;
        }

        private a a(Handler handler, d.a aVar) {
            com.anythink.expressad.exoplayer.k.a.a((handler == null || aVar == null) ? false : true);
            this.f7591a = handler;
            this.b = aVar;
            return this;
        }

        private a a(com.anythink.expressad.exoplayer.k.c cVar) {
            this.e = cVar;
            return this;
        }

        private m a() {
            return new m(this.f7591a, this.b, this.f7592c, this.d, this.e, (byte) 0);
        }
    }

    public m() {
        this(null, null, 1000000L, 2000, com.anythink.expressad.exoplayer.k.c.f7640a);
    }

    @Deprecated
    private m(Handler handler, d.a aVar) {
        this(handler, aVar, 1000000L, 2000, com.anythink.expressad.exoplayer.k.c.f7640a);
    }

    @Deprecated
    private m(Handler handler, d.a aVar, int i) {
        this(handler, aVar, 1000000L, i, com.anythink.expressad.exoplayer.k.c.f7640a);
    }

    private m(Handler handler, d.a aVar, long j, int i, com.anythink.expressad.exoplayer.k.c cVar) {
        this.e = handler;
        this.f = aVar;
        this.g = new com.anythink.expressad.exoplayer.k.y(i);
        this.h = cVar;
        this.n = j;
    }

    /* synthetic */ m(Handler handler, d.a aVar, long j, int i, com.anythink.expressad.exoplayer.k.c cVar, byte b2) {
        this(handler, aVar, j, i, cVar);
    }

    private void a(int i, long j, long j2) {
        Handler handler = this.e;
        if (handler == null || this.f == null) {
            return;
        }
        handler.post(new AnonymousClass1(i, j, j2));
    }

    @Override // com.anythink.expressad.exoplayer.j.d
    public final long a() {
        long j;
        synchronized (this) {
            j = this.n;
        }
        return j;
    }

    @Override // com.anythink.expressad.exoplayer.j.aa
    public final void a(int i) {
        synchronized (this) {
            this.k += i;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.aa
    public final void b() {
        synchronized (this) {
            if (this.i == 0) {
                this.j = this.h.a();
            }
            this.i++;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.aa
    public final void c() {
        synchronized (this) {
            com.anythink.expressad.exoplayer.k.a.b(this.i > 0);
            long a2 = this.h.a();
            int i = (int) (a2 - this.j);
            long j = i;
            this.l += j;
            this.m += this.k;
            if (i > 0) {
                this.g.a((int) Math.sqrt(this.k), (float) ((this.k * 8000) / j));
                if (this.l >= 2000 || this.m >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.n = this.g.a();
                }
            }
            long j2 = this.k;
            long j3 = this.n;
            if (this.e != null && this.f != null) {
                this.e.post(new AnonymousClass1(i, j2, j3));
            }
            int i2 = this.i - 1;
            this.i = i2;
            if (i2 > 0) {
                this.j = a2;
            }
            this.k = 0L;
        }
    }
}
