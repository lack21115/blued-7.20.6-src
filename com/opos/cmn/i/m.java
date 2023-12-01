package com.opos.cmn.i;

import android.os.Handler;
import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/m.class */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f11292a;
    private volatile long b = Long.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    private Handler f11293c;

    public m(Handler handler, Runnable runnable) {
        this.f11293c = handler;
        this.f11292a = runnable;
    }

    public void a() {
        this.b = Long.MAX_VALUE;
    }

    public void a(long j) {
        long max = Math.max(0L, j);
        this.b = SystemClock.uptimeMillis() + max;
        this.f11293c.postDelayed(this, max);
    }

    public void b() {
        this.f11293c.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis >= this.b) {
            Runnable runnable = this.f11292a;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        com.opos.cmn.an.f.a.b("", "run but outline:" + this.b + ",current:" + uptimeMillis);
    }
}
