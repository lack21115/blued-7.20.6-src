package com.opos.exoplayer.core.i;

import java.util.PriorityQueue;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/i/p.class */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final Object f25500a;
    private final PriorityQueue<Integer> b;

    /* renamed from: c  reason: collision with root package name */
    private int f25501c;

    public void a(int i) {
        synchronized (this.f25500a) {
            this.b.add(Integer.valueOf(i));
            this.f25501c = Math.max(this.f25501c, i);
        }
    }

    public void b(int i) {
        synchronized (this.f25500a) {
            this.b.remove(Integer.valueOf(i));
            this.f25501c = this.b.isEmpty() ? Integer.MIN_VALUE : this.b.peek().intValue();
            this.f25500a.notifyAll();
        }
    }
}
