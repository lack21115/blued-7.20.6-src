package com.tencent.qmsp.sdk.c;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/o.class */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f38580a = new AtomicInteger(0);

    public boolean a() {
        int i;
        do {
            i = this.f38580a.get();
            if ((i & 1) != 0) {
                return false;
            }
        } while (!this.f38580a.compareAndSet(i, i + 2));
        return true;
    }

    public void b() {
        int i;
        do {
            i = this.f38580a.get();
            if ((i & (-2)) == 0) {
                return;
            }
            if ((i & 1) != 0) {
                if ((this.f38580a.addAndGet(-2) & (-2)) == 0) {
                    synchronized (this.f38580a) {
                        this.f38580a.notifyAll();
                    }
                    return;
                }
                return;
            }
        } while (!this.f38580a.compareAndSet(i, i - 2));
    }

    public void c() {
        int i;
        if (this.f38580a.compareAndSet(0, 1) || this.f38580a.compareAndSet(1, 1)) {
            return;
        }
        do {
            i = this.f38580a.get();
        } while (!this.f38580a.compareAndSet(i, i | 1));
        synchronized (this.f38580a) {
            try {
                this.f38580a.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
