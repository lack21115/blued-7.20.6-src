package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.lc;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.amap.api.col.3sl.ld  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ld.class */
public abstract class ld {
    protected ThreadPoolExecutor a;
    private ConcurrentHashMap<lc, Future<?>> c = new ConcurrentHashMap<>();
    protected lc.a b = new lc.a() { // from class: com.amap.api.col.3sl.ld.1
        @Override // com.amap.api.col.p0003sl.lc.a
        public final void a(lc lcVar) {
            ld.this.a(lcVar, false);
        }

        @Override // com.amap.api.col.p0003sl.lc.a
        public final void b(lc lcVar) {
            ld.this.a(lcVar, true);
        }
    };

    private void a(lc lcVar, Future<?> future) {
        synchronized (this) {
            try {
                this.c.put(lcVar, future);
            } catch (Throwable th) {
                iw.c(th, "TPool", "addQueue");
                th.printStackTrace();
            }
        }
    }

    private boolean b(lc lcVar) {
        boolean z;
        synchronized (this) {
            try {
                z = this.c.containsKey(lcVar);
            } catch (Throwable th) {
                iw.c(th, "TPool", "contain");
                th.printStackTrace();
                z = false;
            }
        }
        return z;
    }

    public final void a(long j, TimeUnit timeUnit) {
        try {
            if (this.a != null) {
                this.a.awaitTermination(j, timeUnit);
            }
        } catch (InterruptedException e) {
        }
    }

    public final void a(lc lcVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (b(lcVar) || (threadPoolExecutor = this.a) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        lcVar.f = this.b;
        try {
            Future<?> submit = this.a.submit(lcVar);
            if (submit == null) {
                return;
            }
            a(lcVar, submit);
        } catch (RejectedExecutionException e) {
            iw.c(e, "TPool", "addTask");
        }
    }

    protected final void a(lc lcVar, boolean z) {
        synchronized (this) {
            try {
                Future<?> remove = this.c.remove(lcVar);
                if (z && remove != null) {
                    remove.cancel(true);
                }
            } catch (Throwable th) {
                iw.c(th, "TPool", "removeQueue");
                th.printStackTrace();
            }
        }
    }

    public final Executor d() {
        return this.a;
    }

    public final void e() {
        try {
            for (Map.Entry<lc, Future<?>> entry : this.c.entrySet()) {
                Future<?> future = this.c.get(entry.getKey());
                if (future != null) {
                    try {
                        future.cancel(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            this.c.clear();
        } catch (Throwable th) {
            iw.c(th, "TPool", "destroy");
            th.printStackTrace();
        }
        ThreadPoolExecutor threadPoolExecutor = this.a;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }
}
