package com.opos.mobad.f.a;

import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/n.class */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f12437a;
    private volatile long b = Long.MAX_VALUE;

    public n(Runnable runnable) {
        this.f12437a = runnable;
    }

    public void a() {
        this.b = Long.MAX_VALUE;
    }

    public void a(long j) {
        long max = Math.max(0L, j);
        this.b = SystemClock.uptimeMillis() + max;
        com.opos.mobad.service.c.a(this, max);
    }

    public void b() {
        com.opos.mobad.service.c.b(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        if (SystemClock.uptimeMillis() >= this.b && (runnable = this.f12437a) != null) {
            runnable.run();
        }
    }
}
