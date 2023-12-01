package com.opos.mobad.d.a;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.opos.mobad.d.a.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/a/h.class */
public class h implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private static Handler f25966c = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    private Runnable f25967a;
    private volatile long b = Long.MAX_VALUE;
    private int d;

    public h(d.a aVar) {
        this.d = aVar.a();
    }

    public void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public void a(Runnable runnable, long j) {
        if (this.f25967a != null) {
            com.opos.cmn.an.f.a.b("TimeoutController", "start but is running");
            return;
        }
        this.f25967a = runnable;
        long max = Math.max(0L, j);
        this.b = SystemClock.elapsedRealtime() + max;
        f25966c.postDelayed(this, max);
    }

    public boolean a() {
        return this.f25967a != null;
    }

    public int b() {
        return this.d;
    }

    public void c() {
        this.b = Long.MAX_VALUE;
    }

    public void d() {
        f25966c.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        if (SystemClock.elapsedRealtime() >= this.b && (runnable = this.f25967a) != null) {
            runnable.run();
            this.f25967a = null;
        }
    }
}
