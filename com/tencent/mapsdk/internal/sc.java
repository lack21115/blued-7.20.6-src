package com.tencent.mapsdk.internal;

import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/sc.class */
public class sc extends Thread {
    private static final int f = 80;
    private rc b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f24314c = false;
    private volatile boolean d = false;
    private volatile boolean e = false;

    public sc(rc rcVar) {
        setName("tms-texture");
        this.b = rcVar;
    }

    private boolean d() {
        rc rcVar = this.b;
        if (rcVar != null) {
            return rcVar.L();
        }
        return false;
    }

    public void a() {
        this.d = true;
    }

    public void b() {
        this.d = false;
        synchronized (this) {
            notifyAll();
        }
    }

    public void c() {
        this.d = false;
        this.f24314c = true;
        synchronized (this) {
            notifyAll();
        }
    }

    public boolean e() {
        return this.e;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.f24314c) {
            boolean z = false;
            if (!this.d) {
                z = d();
            }
            if (!z) {
                try {
                    synchronized (this) {
                        wait(80L);
                    }
                } catch (InterruptedException e) {
                    na.c(Log.getStackTraceString(e));
                    Thread.currentThread().interrupt();
                }
            }
        }
        this.e = true;
    }
}
