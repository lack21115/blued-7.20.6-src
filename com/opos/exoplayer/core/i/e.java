package com.opos.exoplayer.core.i;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f25484a;

    public boolean a() {
        boolean z;
        synchronized (this) {
            z = true;
            if (this.f25484a) {
                z = false;
            } else {
                this.f25484a = true;
                notifyAll();
            }
        }
        return z;
    }

    public boolean b() {
        boolean z;
        synchronized (this) {
            z = this.f25484a;
            this.f25484a = false;
        }
        return z;
    }

    public void c() {
        synchronized (this) {
            while (!this.f25484a) {
                wait();
            }
        }
    }
}
