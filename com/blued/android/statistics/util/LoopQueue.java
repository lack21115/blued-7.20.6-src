package com.blued.android.statistics.util;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/util/LoopQueue.class */
public class LoopQueue {

    /* renamed from: a  reason: collision with root package name */
    private Object[] f18731a;
    private AtomicInteger b;

    /* renamed from: c  reason: collision with root package name */
    private AtomicInteger f18732c = new AtomicInteger(0);
    private AtomicInteger d = new AtomicInteger(0);

    public LoopQueue(int i) {
        this.b = new AtomicInteger(i);
        this.f18731a = new Object[i];
    }

    public void a(Object obj) {
        synchronized (this.f18731a) {
            this.f18731a[this.d.get()] = obj;
            this.d.set((this.d.get() + 1) % this.b.get());
        }
    }

    public boolean a() {
        boolean z;
        synchronized (this.f18731a) {
            z = this.f18732c.get() == this.d.get();
        }
        return z;
    }

    public Object[] a(int i) {
        synchronized (this.f18731a) {
            if (a()) {
                return null;
            }
            int b = b();
            if (i >= b) {
                i = b;
            }
            Object[] objArr = new Object[i];
            int i2 = (this.f18732c.get() + i) % this.b.get();
            if (i2 < this.f18732c.get()) {
                int i3 = this.b.get() - this.f18732c.get();
                System.arraycopy(this.f18731a, this.f18732c.get(), objArr, 0, i3);
                System.arraycopy(this.f18731a, 0, objArr, i3, i - i3);
            } else {
                System.arraycopy(this.f18731a, this.f18732c.get(), objArr, 0, i2 - this.f18732c.get());
            }
            for (int i4 = 0; i4 < i; i4++) {
                this.f18731a[(this.f18732c.get() + i4) % this.b.get()] = null;
            }
            this.f18732c.set((this.f18732c.get() + i) % this.b.get());
            return objArr;
        }
    }

    public int b() {
        int i;
        int i2;
        int i3;
        int i4;
        synchronized (this.f18731a) {
            i = this.d.get();
            i2 = this.f18732c.get();
            i3 = this.b.get();
            i4 = this.b.get();
        }
        return ((i - i2) + i3) % i4;
    }
}
