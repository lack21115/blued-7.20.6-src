package com.opos.exoplayer.core;

import android.os.Handler;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/r.class */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    private final b f25556a;
    private final a b;

    /* renamed from: c  reason: collision with root package name */
    private final y f25557c;
    private int d;
    private Object e;
    private Handler f;
    private int g;
    private long h = com.anythink.expressad.exoplayer.b.b;
    private boolean i = true;
    private boolean j;
    private boolean k;
    private boolean l;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/r$a.class */
    public interface a {
        void a(r rVar);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/r$b.class */
    public interface b {
        void a(int i, Object obj);
    }

    public r(a aVar, b bVar, y yVar, int i, Handler handler) {
        this.b = aVar;
        this.f25556a = bVar;
        this.f25557c = yVar;
        this.f = handler;
        this.g = i;
    }

    public r a(int i) {
        com.opos.exoplayer.core.i.a.b(!this.j);
        this.d = i;
        return this;
    }

    public r a(Object obj) {
        com.opos.exoplayer.core.i.a.b(!this.j);
        this.e = obj;
        return this;
    }

    public y a() {
        return this.f25557c;
    }

    public void a(boolean z) {
        synchronized (this) {
            this.k = z | this.k;
            this.l = true;
            notifyAll();
        }
    }

    public b b() {
        return this.f25556a;
    }

    public int c() {
        return this.d;
    }

    public Object d() {
        return this.e;
    }

    public Handler e() {
        return this.f;
    }

    public long f() {
        return this.h;
    }

    public int g() {
        return this.g;
    }

    public boolean h() {
        return this.i;
    }

    public r i() {
        com.opos.exoplayer.core.i.a.b(!this.j);
        if (this.h == com.anythink.expressad.exoplayer.b.b) {
            com.opos.exoplayer.core.i.a.a(this.i);
        }
        this.j = true;
        this.b.a(this);
        return this;
    }

    public boolean j() {
        boolean z;
        synchronized (this) {
            com.opos.exoplayer.core.i.a.b(this.j);
            com.opos.exoplayer.core.i.a.b(this.f.getLooper().getThread() != Thread.currentThread());
            while (!this.l) {
                wait();
            }
            z = this.k;
        }
        return z;
    }
}
