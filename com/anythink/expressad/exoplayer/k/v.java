package com.anythink.expressad.exoplayer.k;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/v.class */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    private final Object f7678a = new Object();
    private final PriorityQueue<Integer> b = new PriorityQueue<>(10, Collections.reverseOrder());

    /* renamed from: c  reason: collision with root package name */
    private int f7679c = Integer.MIN_VALUE;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/v$a.class */
    public static final class a extends IOException {
        public a(int i, int i2) {
            super("Priority too low [priority=" + i + ", highest=" + i2 + "]");
        }
    }

    private boolean b(int i) {
        boolean z;
        synchronized (this.f7678a) {
            z = this.f7679c == i;
        }
        return z;
    }

    public final void a() {
        synchronized (this.f7678a) {
            this.b.add(0);
            this.f7679c = Math.max(this.f7679c, 0);
        }
    }

    public final void a(int i) {
        synchronized (this.f7678a) {
            if (this.f7679c != i) {
                throw new a(i, this.f7679c);
            }
        }
    }

    public final void b() {
        synchronized (this.f7678a) {
            while (this.f7679c != 0) {
                this.f7678a.wait();
            }
        }
    }

    public final void c() {
        synchronized (this.f7678a) {
            this.b.remove(0);
            this.f7679c = this.b.isEmpty() ? Integer.MIN_VALUE : this.b.peek().intValue();
            this.f7678a.notifyAll();
        }
    }
}
