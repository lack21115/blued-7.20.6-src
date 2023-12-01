package com.meizu.cloud.pushsdk.b.c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/c/c.class */
public class c implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadPoolExecutor f10368a;

    /* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/c/c$a.class */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static c f10369a = new c();
    }

    private c() {
        this.f10368a = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new d().a("single-pool-%d").a());
    }

    public static c a() {
        return a.f10369a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f10368a.execute(runnable);
    }
}
