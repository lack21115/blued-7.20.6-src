package com.igexin.c.a.d;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/d/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> f9657a = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> b = new ConcurrentLinkedQueue<>();

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> f9658c = this.f9657a;

    private Iterator<com.igexin.c.a.d.a.e> e() {
        Iterator<com.igexin.c.a.d.a.e> it;
        synchronized (this) {
            it = this.f9658c.iterator();
        }
        return it;
    }

    public final void a() {
        synchronized (this) {
            this.f9658c = this.f9657a;
        }
    }

    public final void a(com.igexin.c.a.d.a.e eVar) {
        synchronized (this) {
            this.f9658c.offer(eVar);
        }
    }

    public final void b() {
        synchronized (this) {
            ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> concurrentLinkedQueue = this.b;
            this.f9658c = concurrentLinkedQueue;
            concurrentLinkedQueue.addAll(this.f9657a);
            this.f9657a.clear();
        }
    }

    public final boolean c() {
        boolean isEmpty;
        synchronized (this) {
            isEmpty = this.f9658c.isEmpty();
        }
        return isEmpty;
    }

    public final com.igexin.c.a.d.a.e d() {
        com.igexin.c.a.d.a.e poll;
        synchronized (this) {
            poll = this.f9658c.poll();
        }
        return poll;
    }
}
