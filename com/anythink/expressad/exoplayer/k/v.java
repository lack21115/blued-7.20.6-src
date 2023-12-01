package com.anythink.expressad.exoplayer.k;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/v.class */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    private final Object f4839a = new Object();
    private final PriorityQueue<Integer> b = new PriorityQueue<>(10, Collections.reverseOrder());

    /* renamed from: c  reason: collision with root package name */
    private int f4840c = Integer.MIN_VALUE;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/v$a.class */
    public static final class a extends IOException {
        public a(int i, int i2) {
            super("Priority too low [priority=" + i + ", highest=" + i2 + "]");
        }
    }

    private boolean b(int i) {
        boolean z;
        synchronized (this.f4839a) {
            z = this.f4840c == i;
        }
        return z;
    }

    public final void a() {
        synchronized (this.f4839a) {
            this.b.add(0);
            this.f4840c = Math.max(this.f4840c, 0);
        }
    }

    public final void a(int i) {
        synchronized (this.f4839a) {
            if (this.f4840c != i) {
                throw new a(i, this.f4840c);
            }
        }
    }

    public final void b() {
        synchronized (this.f4839a) {
            while (this.f4840c != 0) {
                this.f4839a.wait();
            }
        }
    }

    public final void c() {
        synchronized (this.f4839a) {
            this.b.remove(0);
            this.f4840c = this.b.isEmpty() ? Integer.MIN_VALUE : this.b.peek().intValue();
            this.f4839a.notifyAll();
        }
    }
}
