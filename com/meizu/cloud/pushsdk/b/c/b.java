package com.meizu.cloud.pushsdk.b.c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/c/b.class */
public class b implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadPoolExecutor f10366a;

    /* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/c/b$a.class */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static b f10367a = new b();
    }

    private b() {
        this.f10366a = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new d().a((Integer) 10).a("message-pool-%d").a());
    }

    public static b a() {
        return a.f10367a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f10366a.execute(runnable);
    }
}
