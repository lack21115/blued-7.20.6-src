package com.alibaba.mtl.appmonitor.c;

import com.alibaba.mtl.appmonitor.c.b;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/c/c.class */
public class c<T extends b> {
    private static AtomicLong c = new AtomicLong(0);
    private static AtomicLong d = new AtomicLong(0);
    private final int m = 20;
    private Integer b = null;

    /* renamed from: a  reason: collision with other field name */
    private AtomicLong f22a = new AtomicLong(0);

    /* renamed from: b  reason: collision with other field name */
    private AtomicLong f24b = new AtomicLong(0);
    private ConcurrentLinkedQueue<T> a = new ConcurrentLinkedQueue<>();

    /* renamed from: b  reason: collision with other field name */
    private Set<Integer> f23b = new HashSet();

    public T a() {
        c.getAndIncrement();
        this.f22a.getAndIncrement();
        T poll = this.a.poll();
        if (poll != null) {
            this.f23b.remove(Integer.valueOf(System.identityHashCode(poll)));
            this.f24b.getAndIncrement();
            d.getAndIncrement();
        }
        return poll;
    }

    public void a(T t) {
        t.clean();
        if (this.a.size() < 20) {
            synchronized (this.f23b) {
                int identityHashCode = System.identityHashCode(t);
                if (!this.f23b.contains(Integer.valueOf(identityHashCode))) {
                    this.f23b.add(Integer.valueOf(identityHashCode));
                    this.a.offer(t);
                }
            }
        }
    }
}
