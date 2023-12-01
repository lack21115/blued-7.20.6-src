package com.opos.mobad.f.a;

import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/m.class */
public class m<T> implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private volatile T f26123a;
    private a<T> b;

    /* renamed from: c  reason: collision with root package name */
    private volatile long f26124c = Long.MAX_VALUE;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/m$a.class */
    public interface a<T> {
        void a(T t);
    }

    public m(a<T> aVar) {
        this.b = aVar;
    }

    public void a() {
        this.f26124c = Long.MAX_VALUE;
        this.f26123a = null;
    }

    public void a(long j, T t) {
        long max = Math.max(0L, j);
        this.f26124c = SystemClock.uptimeMillis() + max;
        this.f26123a = t;
        com.opos.mobad.service.c.a(this, max);
    }

    public void b() {
        com.opos.mobad.service.c.b(this);
        this.f26123a = null;
    }

    @Override // java.lang.Runnable
    public void run() {
        a<T> aVar;
        if (SystemClock.uptimeMillis() >= this.f26124c && (aVar = this.b) != null) {
            aVar.a(this.f26123a);
        }
    }
}
