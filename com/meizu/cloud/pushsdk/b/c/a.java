package com.meizu.cloud.pushsdk.b.c;

import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/c/a.class */
public class a implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadPoolExecutor f23975a;

    /* renamed from: com.meizu.cloud.pushsdk.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/c/a$a.class */
    static class C0605a {

        /* renamed from: a  reason: collision with root package name */
        private static a f23976a = new a();
    }

    private a() {
        this.f23975a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new d().a("io-pool-%d").a());
    }

    public static a a() {
        return C0605a.f23976a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f23975a.execute(runnable);
    }
}
