package com.opos.exoplayer.core.h;

import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.opos.exoplayer.core.h.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/k.class */
public final class k implements d, t<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f11765a;
    private final d.a b;

    /* renamed from: c  reason: collision with root package name */
    private final com.opos.exoplayer.core.i.q f11766c;
    private final com.opos.exoplayer.core.i.b d;
    private int e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;

    public k() {
        this(null, null);
    }

    public k(Handler handler, d.a aVar) {
        this(handler, aVar, 2000);
    }

    public k(Handler handler, d.a aVar, int i) {
        this(handler, aVar, i, com.opos.exoplayer.core.i.b.f11791a);
    }

    public k(Handler handler, d.a aVar, int i, com.opos.exoplayer.core.i.b bVar) {
        this.f11765a = handler;
        this.b = aVar;
        this.f11766c = new com.opos.exoplayer.core.i.q(i);
        this.d = bVar;
        this.j = -1L;
    }

    private void a(final int i, final long j, final long j2) {
        Handler handler = this.f11765a;
        if (handler == null || this.b == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.opos.exoplayer.core.h.k.1
            @Override // java.lang.Runnable
            public void run() {
                k.this.b.a(i, j, j2);
            }
        });
    }

    @Override // com.opos.exoplayer.core.h.d
    public long a() {
        long j;
        synchronized (this) {
            j = this.j;
        }
        return j;
    }

    @Override // com.opos.exoplayer.core.h.t
    public void a(Object obj) {
        synchronized (this) {
            com.opos.exoplayer.core.i.a.b(this.e > 0);
            long a2 = this.d.a();
            int i = (int) (a2 - this.f);
            long j = i;
            this.h += j;
            this.i += this.g;
            if (i > 0) {
                this.f11766c.a((int) Math.sqrt(this.g), (float) ((this.g * 8000) / j));
                if (this.h >= 2000 || this.i >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    float a3 = this.f11766c.a(0.5f);
                    this.j = Float.isNaN(a3) ? -1L : a3;
                }
            }
            a(i, this.g, this.j);
            int i2 = this.e - 1;
            this.e = i2;
            if (i2 > 0) {
                this.f = a2;
            }
            this.g = 0L;
        }
    }

    @Override // com.opos.exoplayer.core.h.t
    public void a(Object obj, int i) {
        synchronized (this) {
            this.g += i;
        }
    }

    @Override // com.opos.exoplayer.core.h.t
    public void a(Object obj, i iVar) {
        synchronized (this) {
            if (this.e == 0) {
                this.f = this.d.a();
            }
            this.e++;
        }
    }
}
