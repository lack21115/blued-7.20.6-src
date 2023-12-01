package com.opos.mobad.c.b;

import android.os.Handler;
import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/c/b/c.class */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f12122a;
    private volatile long b = Long.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    private Handler f12123c;

    public c(Handler handler, Runnable runnable) {
        this.f12123c = handler;
        this.f12122a = runnable;
    }

    public void a() {
        this.b = Long.MAX_VALUE;
    }

    public void a(long j) {
        long max = Math.max(0L, j);
        this.b = SystemClock.uptimeMillis() + max;
        this.f12123c.postDelayed(this, max);
    }

    public void b() {
        this.f12123c.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis >= this.b) {
            Runnable runnable = this.f12122a;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        com.opos.cmn.an.f.a.b("", "run but outline:" + this.b + ",current:" + uptimeMillis);
    }
}
