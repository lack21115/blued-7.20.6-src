package com.tencent.qmsp.sdk.c;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/c/o.class */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f24889a = new AtomicInteger(0);

    public boolean a() {
        int i;
        do {
            i = this.f24889a.get();
            if ((i & 1) != 0) {
                return false;
            }
        } while (!this.f24889a.compareAndSet(i, i + 2));
        return true;
    }

    public void b() {
        int i;
        do {
            i = this.f24889a.get();
            if ((i & (-2)) == 0) {
                return;
            }
            if ((i & 1) != 0) {
                if ((this.f24889a.addAndGet(-2) & (-2)) == 0) {
                    synchronized (this.f24889a) {
                        this.f24889a.notifyAll();
                    }
                    return;
                }
                return;
            }
        } while (!this.f24889a.compareAndSet(i, i - 2));
    }

    public void c() {
        int i;
        if (this.f24889a.compareAndSet(0, 1) || this.f24889a.compareAndSet(1, 1)) {
            return;
        }
        do {
            i = this.f24889a.get();
        } while (!this.f24889a.compareAndSet(i, i | 1));
        synchronized (this.f24889a) {
            try {
                this.f24889a.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
