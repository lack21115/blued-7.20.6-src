package com.opos.mobad.c.b;

import android.os.Handler;
import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/c/b/c.class */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f25810a;
    private volatile long b = Long.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    private Handler f25811c;

    public c(Handler handler, Runnable runnable) {
        this.f25811c = handler;
        this.f25810a = runnable;
    }

    public void a() {
        this.b = Long.MAX_VALUE;
    }

    public void a(long j) {
        long max = Math.max(0L, j);
        this.b = SystemClock.uptimeMillis() + max;
        this.f25811c.postDelayed(this, max);
    }

    public void b() {
        this.f25811c.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis >= this.b) {
            Runnable runnable = this.f25810a;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        com.opos.cmn.an.f.a.b("", "run but outline:" + this.b + ",current:" + uptimeMillis);
    }
}
