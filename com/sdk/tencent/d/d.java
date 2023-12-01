package com.sdk.tencent.d;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/d/d.class */
public class d implements Executor {

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadFactory f28036c = new a();

    /* renamed from: a  reason: collision with root package name */
    public final BlockingQueue<Runnable> f28037a;
    public final ThreadPoolExecutor b;

    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/d/d$a.class */
    public static final class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f28038a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "PriorityExecutor #" + this.f28038a.getAndIncrement());
        }
    }

    public d(int i) {
        f fVar = new f();
        this.f28037a = fVar;
        this.b = new ThreadPoolExecutor(i, 256, 1L, TimeUnit.SECONDS, fVar, f28036c);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.b.execute(runnable);
    }
}
