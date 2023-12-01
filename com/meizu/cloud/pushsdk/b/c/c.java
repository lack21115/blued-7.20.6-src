package com.meizu.cloud.pushsdk.b.c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/c/c.class */
public class c implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadPoolExecutor f23979a;

    /* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/c/c$a.class */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static c f23980a = new c();
    }

    private c() {
        this.f23979a = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new d().a("single-pool-%d").a());
    }

    public static c a() {
        return a.f23980a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f23979a.execute(runnable);
    }
}
