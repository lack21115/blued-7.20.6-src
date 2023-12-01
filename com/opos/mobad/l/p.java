package com.opos.mobad.l;

import android.os.Handler;
import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/l/p.class */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f12637a;
    private volatile long b = Long.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    private Handler f12638c;

    public p(Handler handler, Runnable runnable) {
        this.f12638c = handler;
        this.f12637a = runnable;
    }

    public void a() {
        this.b = Long.MAX_VALUE;
    }

    public void a(long j) {
        long max = Math.max(0L, j);
        this.b = SystemClock.uptimeMillis() + max;
        this.f12638c.postDelayed(this, max);
    }

    public void b() {
        this.f12638c.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        if (SystemClock.uptimeMillis() >= this.b && (runnable = this.f12637a) != null) {
            runnable.run();
        }
    }
}
