package com.opos.exoplayer.core.i;

import java.util.PriorityQueue;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/p.class */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final Object f11812a;
    private final PriorityQueue<Integer> b;

    /* renamed from: c  reason: collision with root package name */
    private int f11813c;

    public void a(int i) {
        synchronized (this.f11812a) {
            this.b.add(Integer.valueOf(i));
            this.f11813c = Math.max(this.f11813c, i);
        }
    }

    public void b(int i) {
        synchronized (this.f11812a) {
            this.b.remove(Integer.valueOf(i));
            this.f11813c = this.b.isEmpty() ? Integer.MIN_VALUE : this.b.peek().intValue();
            this.f11812a.notifyAll();
        }
    }
}
