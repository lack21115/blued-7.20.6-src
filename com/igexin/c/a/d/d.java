package com.igexin.c.a.d;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/d/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> f23265a = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> b = new ConcurrentLinkedQueue<>();

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> f23266c = this.f23265a;

    private Iterator<com.igexin.c.a.d.a.e> e() {
        Iterator<com.igexin.c.a.d.a.e> it;
        synchronized (this) {
            it = this.f23266c.iterator();
        }
        return it;
    }

    public final void a() {
        synchronized (this) {
            this.f23266c = this.f23265a;
        }
    }

    public final void a(com.igexin.c.a.d.a.e eVar) {
        synchronized (this) {
            this.f23266c.offer(eVar);
        }
    }

    public final void b() {
        synchronized (this) {
            ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> concurrentLinkedQueue = this.b;
            this.f23266c = concurrentLinkedQueue;
            concurrentLinkedQueue.addAll(this.f23265a);
            this.f23265a.clear();
        }
    }

    public final boolean c() {
        boolean isEmpty;
        synchronized (this) {
            isEmpty = this.f23266c.isEmpty();
        }
        return isEmpty;
    }

    public final com.igexin.c.a.d.a.e d() {
        com.igexin.c.a.d.a.e poll;
        synchronized (this) {
            poll = this.f23266c.poll();
        }
        return poll;
    }
}
