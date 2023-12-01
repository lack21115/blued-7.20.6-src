package com.amap.api.col.p0003sl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.amap.api.col.3sl.gk  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gk.class */
public class gk {

    /* renamed from: c  reason: collision with root package name */
    private static volatile gk f4994c;

    /* renamed from: a  reason: collision with root package name */
    private BlockingQueue<Runnable> f4995a = new LinkedBlockingQueue();
    private ExecutorService b;

    private gk() {
        this.b = null;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.b = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 1L, TimeUnit.SECONDS, this.f4995a, new ThreadPoolExecutor.AbortPolicy());
    }

    public static gk a() {
        if (f4994c == null) {
            synchronized (gk.class) {
                try {
                    if (f4994c == null) {
                        f4994c = new gk();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f4994c;
    }

    public static void b() {
        if (f4994c != null) {
            synchronized (gk.class) {
                try {
                    if (f4994c != null) {
                        f4994c.b.shutdownNow();
                        f4994c.b = null;
                        f4994c = null;
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
