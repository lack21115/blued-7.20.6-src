package com.tencent.tmsbeacon.a.b;

import com.tencent.tmsbeacon.base.util.c;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/b/g.class */
public final class g implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f25779a = new AtomicInteger(1);

    public String a() {
        return "beacon-thread-" + this.f25779a.getAndIncrement();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        try {
            return new Thread(runnable, a());
        } catch (Exception e) {
            c.a(e);
            return null;
        } catch (OutOfMemoryError e2) {
            c.b("[task] memory not enough, create thread failed.", new Object[0]);
            return null;
        }
    }
}
