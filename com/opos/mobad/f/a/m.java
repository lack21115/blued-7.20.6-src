package com.opos.mobad.f.a;

import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/m.class */
public class m<T> implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private volatile T f12435a;
    private a<T> b;

    /* renamed from: c  reason: collision with root package name */
    private volatile long f12436c = Long.MAX_VALUE;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/m$a.class */
    public interface a<T> {
        void a(T t);
    }

    public m(a<T> aVar) {
        this.b = aVar;
    }

    public void a() {
        this.f12436c = Long.MAX_VALUE;
        this.f12435a = null;
    }

    public void a(long j, T t) {
        long max = Math.max(0L, j);
        this.f12436c = SystemClock.uptimeMillis() + max;
        this.f12435a = t;
        com.opos.mobad.service.c.a(this, max);
    }

    public void b() {
        com.opos.mobad.service.c.b(this);
        this.f12435a = null;
    }

    @Override // java.lang.Runnable
    public void run() {
        a<T> aVar;
        if (SystemClock.uptimeMillis() >= this.f12436c && (aVar = this.b) != null) {
            aVar.a(this.f12435a);
        }
    }
}
