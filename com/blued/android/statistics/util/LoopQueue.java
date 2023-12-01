package com.blued.android.statistics.util;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/util/LoopQueue.class */
public class LoopQueue {
    private Object[] a;
    private AtomicInteger b;
    private AtomicInteger c = new AtomicInteger(0);
    private AtomicInteger d = new AtomicInteger(0);

    public LoopQueue(int i) {
        this.b = new AtomicInteger(i);
        this.a = new Object[i];
    }

    public void a(Object obj) {
        synchronized (this.a) {
            this.a[this.d.get()] = obj;
            this.d.set((this.d.get() + 1) % this.b.get());
        }
    }

    public boolean a() {
        boolean z;
        synchronized (this.a) {
            z = this.c.get() == this.d.get();
        }
        return z;
    }

    public Object[] a(int i) {
        synchronized (this.a) {
            if (a()) {
                return null;
            }
            int b = b();
            if (i >= b) {
                i = b;
            }
            Object[] objArr = new Object[i];
            int i2 = (this.c.get() + i) % this.b.get();
            if (i2 < this.c.get()) {
                int i3 = this.b.get() - this.c.get();
                System.arraycopy(this.a, this.c.get(), objArr, 0, i3);
                System.arraycopy(this.a, 0, objArr, i3, i - i3);
            } else {
                System.arraycopy(this.a, this.c.get(), objArr, 0, i2 - this.c.get());
            }
            for (int i4 = 0; i4 < i; i4++) {
                this.a[(this.c.get() + i4) % this.b.get()] = null;
            }
            this.c.set((this.c.get() + i) % this.b.get());
            return objArr;
        }
    }

    public int b() {
        int i;
        int i2;
        int i3;
        int i4;
        synchronized (this.a) {
            i = this.d.get();
            i2 = this.c.get();
            i3 = this.b.get();
            i4 = this.b.get();
        }
        return ((i - i2) + i3) % i4;
    }
}
