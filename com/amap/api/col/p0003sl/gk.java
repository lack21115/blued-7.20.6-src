package com.amap.api.col.p0003sl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.amap.api.col.3sl.gk  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gk.class */
public class gk {
    private static volatile gk c;
    private BlockingQueue<Runnable> a = new LinkedBlockingQueue();
    private ExecutorService b;

    private gk() {
        this.b = null;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.b = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 1L, TimeUnit.SECONDS, this.a, new ThreadPoolExecutor.AbortPolicy());
    }

    public static gk a() {
        if (c == null) {
            synchronized (gk.class) {
                try {
                    if (c == null) {
                        c = new gk();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    public static void b() {
        if (c != null) {
            synchronized (gk.class) {
                try {
                    if (c != null) {
                        c.b.shutdownNow();
                        c.b = null;
                        c = null;
                    }
                } finally {
                }
            }
        }
    }

    public final void a(Runnable runnable) {
        ExecutorService executorService = this.b;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }
}
