package com.tencent.qimei.b;

import android.util.SparseArray;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/b/c.class */
public class c extends a {
    public static final int b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f38313c;
    public final ScheduledExecutorService d;
    public boolean e = false;
    public final d f;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        b = availableProcessors;
        f38313c = Math.max(2, Math.min(availableProcessors - 1, 3));
        new AtomicInteger(0);
    }

    public c() {
        d dVar = new d();
        this.f = dVar;
        this.d = Executors.newScheduledThreadPool(f38313c, dVar);
        new SparseArray();
        new SparseArray();
    }

    @Override // com.tencent.qimei.b.a
    public void a(long j, Runnable runnable) {
        synchronized (this) {
            if (this.e) {
                return;
            }
            b bVar = new b(this, runnable);
            if (j <= 0) {
                j = 0;
            }
            this.d.schedule(bVar, j, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.tencent.qimei.b.a
    public void a(Runnable runnable) {
        synchronized (this) {
            if (this.e) {
                return;
            }
            try {
                this.d.execute(new b(this, runnable));
            } catch (Exception e) {
            }
        }
    }
}
