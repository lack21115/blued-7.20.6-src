package com.tencent.tmsqmsp.sdk.c;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/c/o.class */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f39736a = new AtomicInteger(0);

    public boolean a() {
        int i;
        do {
            i = this.f39736a.get();
            if ((i & 1) != 0) {
                return false;
            }
        } while (!this.f39736a.compareAndSet(i, i + 2));
        return true;
    }

    public void b() {
        int i;
        do {
            i = this.f39736a.get();
            if ((i & (-2)) == 0) {
                return;
            }
            if ((i & 1) != 0) {
                if ((this.f39736a.addAndGet(-2) & (-2)) == 0) {
                    synchronized (this.f39736a) {
                        this.f39736a.notifyAll();
                    }
                    return;
                }
                return;
            }
        } while (!this.f39736a.compareAndSet(i, i - 2));
    }

    public void c() {
        int i;
        if (this.f39736a.compareAndSet(0, 1) || this.f39736a.compareAndSet(1, 1)) {
            return;
        }
        do {
            i = this.f39736a.get();
        } while (!this.f39736a.compareAndSet(i, i | 1));
        synchronized (this.f39736a) {
            try {
                this.f39736a.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
