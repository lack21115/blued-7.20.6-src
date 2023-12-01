package com.zx.a.I8b7;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/p.class */
public class p implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public AtomicInteger f28471a = new AtomicInteger(0);

    public p(q qVar) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        StringBuilder a2 = m2.a("ZXHttpClient dispatcher's thread");
        a2.append(this.f28471a.getAndIncrement());
        thread.setName(a2.toString());
        return thread;
    }
}
