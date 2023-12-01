package com.anythink.expressad.exoplayer.k;

import android.os.SystemClock;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4810a;

    private boolean a(long j) {
        boolean z;
        synchronized (this) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = j + elapsedRealtime;
            for (long j3 = elapsedRealtime; !this.f4810a && j3 < j2; j3 = SystemClock.elapsedRealtime()) {
                wait(j2 - j3);
            }
            z = this.f4810a;
        }
        return z;
    }

    public final boolean a() {
        synchronized (this) {
            if (this.f4810a) {
                return false;
            }
            this.f4810a = true;
            notifyAll();
            return true;
        }
    }

    public final boolean b() {
        boolean z;
        synchronized (this) {
            z = this.f4810a;
            this.f4810a = false;
        }
        return z;
    }

    public final void c() {
        synchronized (this) {
            while (!this.f4810a) {
                wait();
            }
        }
    }
}
