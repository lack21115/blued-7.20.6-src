package com.tencent.beacon.a.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/b/j.class */
public final class j implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f34934a = new AtomicInteger(1);

    public String a() {
        return "beacon-thread-" + this.f34934a.getAndIncrement();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        try {
            return new Thread(runnable, a());
        } catch (Exception e) {
            com.tencent.beacon.base.util.c.a(e);
            return null;
        } catch (OutOfMemoryError e2) {
            com.tencent.beacon.base.util.c.b("[task] memory not enough, create thread failed.", new Object[0]);
            return null;
        }
    }
}
