package com.zx.a.I8b7;

import com.zx.a.I8b7.u0;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/q.class */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f42165a;
    public final Deque<u0.a> b = new ArrayDeque();

    /* renamed from: c  reason: collision with root package name */
    public final Deque<u0.a> f42166c = new ArrayDeque();
    public final Deque<u0> d = new ArrayDeque();

    public final void a() {
        ExecutorService executorService;
        if (this.f42166c.size() < 64 && !this.b.isEmpty()) {
            Iterator<u0.a> it = this.b.iterator();
            while (it.hasNext()) {
                u0.a next = it.next();
                Iterator<u0.a> it2 = this.f42166c.iterator();
                if (it2.hasNext()) {
                    it2.next().getClass();
                    throw null;
                }
                it.remove();
                this.f42166c.add(next);
                synchronized (this) {
                    if (this.f42165a == null) {
                        this.f42165a = new ThreadPoolExecutor(1, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new p(this));
                    }
                    executorService = this.f42165a;
                }
                executorService.execute(next);
                if (this.f42166c.size() >= 64) {
                    return;
                }
            }
        }
    }

    public final <T> void a(Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                a();
            }
        }
    }
}
