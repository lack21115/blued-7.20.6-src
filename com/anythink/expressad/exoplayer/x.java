package com.anythink.expressad.exoplayer;

import android.os.Handler;
import android.os.SystemClock;
import java.util.concurrent.TimeoutException;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/x.class */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    private final b f7742a;
    private final a b;

    /* renamed from: c  reason: collision with root package name */
    private final ae f7743c;
    private int d;
    private Object e;
    private Handler f;
    private int g;
    private long h = com.anythink.expressad.exoplayer.b.b;
    private boolean i = true;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/x$a.class */
    public interface a {
        void a(x xVar);
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/x$b.class */
    public interface b {
        void a(int i, Object obj);
    }

    public x(a aVar, b bVar, ae aeVar, int i, Handler handler) {
        this.b = aVar;
        this.f7742a = bVar;
        this.f7743c = aeVar;
        this.f = handler;
        this.g = i;
    }

    private x a(int i, long j) {
        boolean z = true;
        com.anythink.expressad.exoplayer.k.a.b(!this.j);
        if (j == com.anythink.expressad.exoplayer.b.b) {
            z = false;
        }
        com.anythink.expressad.exoplayer.k.a.a(z);
        if (i < 0 || (!this.f7743c.a() && i >= this.f7743c.b())) {
            throw new o(this.f7743c, i, j);
        }
        this.g = i;
        this.h = j;
        return this;
    }

    private x a(long j) {
        com.anythink.expressad.exoplayer.k.a.b(!this.j);
        this.h = j;
        return this;
    }

    private x a(Handler handler) {
        com.anythink.expressad.exoplayer.k.a.b(!this.j);
        this.f = handler;
        return this;
    }

    private x b(boolean z) {
        com.anythink.expressad.exoplayer.k.a.b(!this.j);
        this.i = z;
        return this;
    }

    private x l() {
        synchronized (this) {
            com.anythink.expressad.exoplayer.k.a.b(this.j);
            this.m = true;
            a(false);
        }
        return this;
    }

    public final ae a() {
        return this.f7743c;
    }

    public final x a(int i) {
        com.anythink.expressad.exoplayer.k.a.b(!this.j);
        this.d = i;
        return this;
    }

    public final x a(Object obj) {
        com.anythink.expressad.exoplayer.k.a.b(!this.j);
        this.e = obj;
        return this;
    }

    public final void a(boolean z) {
        synchronized (this) {
            this.k = z | this.k;
            this.l = true;
            notifyAll();
        }
    }

    public final b b() {
        return this.f7742a;
    }

    public final int c() {
        return this.d;
    }

    public final Object d() {
        return this.e;
    }

    public final Handler e() {
        return this.f;
    }

    public final long f() {
        return this.h;
    }

    public final int g() {
        return this.g;
    }

    public final boolean h() {
        return this.i;
    }

    public final x i() {
        com.anythink.expressad.exoplayer.k.a.b(!this.j);
        if (this.h == com.anythink.expressad.exoplayer.b.b) {
            com.anythink.expressad.exoplayer.k.a.a(this.i);
        }
        this.j = true;
        this.b.a(this);
        return this;
    }

    public final boolean j() {
        boolean z;
        synchronized (this) {
            z = this.m;
        }
        return z;
    }

    public final boolean k() {
        boolean z;
        synchronized (this) {
            com.anythink.expressad.exoplayer.k.a.b(this.j);
            com.anythink.expressad.exoplayer.k.a.b(this.f.getLooper().getThread() != Thread.currentThread());
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (long j = 500; !this.l && j > 0; j = (elapsedRealtime + 500) - SystemClock.elapsedRealtime()) {
                wait(j);
            }
            if (!this.l) {
                throw new TimeoutException("Message delivery time out");
            }
            z = this.k;
        }
        return z;
    }
}
