package com.meizu.cloud.pushsdk.b.c;

import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/c/a.class */
public class a implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadPoolExecutor f10364a;

    /* renamed from: com.meizu.cloud.pushsdk.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/c/a$a.class */
    static class C0435a {

        /* renamed from: a  reason: collision with root package name */
        private static a f10365a = new a();
    }

    private a() {
        this.f10364a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new d().a("io-pool-%d").a());
    }

    public static a a() {
        return C0435a.f10365a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f10364a.execute(runnable);
    }
}
