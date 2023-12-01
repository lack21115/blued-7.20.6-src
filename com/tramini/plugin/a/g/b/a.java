package com.tramini.plugin.a.g.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/g/b/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f26848a;
    private ExecutorService b;

    protected a() {
        this.b = null;
        this.b = new ThreadPoolExecutor(0, 50, 60L, TimeUnit.SECONDS, new SynchronousQueue());
    }

    public static a a() {
        if (f26848a == null) {
            f26848a = new a();
        }
        return f26848a;
    }

    public final void a(b bVar) {
        this.b.execute(bVar);
    }

    public final void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public final void a(final Runnable runnable, final long j) {
        if (runnable != null) {
            b bVar = new b() { // from class: com.tramini.plugin.a.g.b.a.1
                @Override // com.tramini.plugin.a.g.b.b
                public final void a() {
                    try {
                        Thread.sleep(j);
                    } catch (InterruptedException e) {
                    }
                    runnable.run();
                }
            };
            bVar.a(Long.valueOf(System.currentTimeMillis() / 1000).intValue());
            a(bVar);
        }
    }
}
