package com.tencent.beacon.a.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseArray;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/b/i.class */
public class i extends com.tencent.beacon.a.b.a {

    /* renamed from: c  reason: collision with root package name */
    private static final int f34931c;
    private static final int d;
    private static final AtomicInteger e;
    private final ScheduledExecutorService f;
    private final SparseArray<a> g;
    private final SparseArray<Handler> h;
    private final j i;
    private boolean j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/b/i$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f34932a;
        private final long b;

        /* renamed from: c  reason: collision with root package name */
        private final long f34933c;
        private final TimeUnit d;
        private Future<?> e;

        a(Future<?> future, Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            this.e = future;
            this.f34932a = runnable;
            this.b = j;
            this.f34933c = j2;
            this.d = timeUnit;
        }

        boolean a() {
            return this.e.isCancelled();
        }

        boolean a(boolean z) {
            return this.e.cancel(z);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f34931c = availableProcessors;
        d = Math.max(2, Math.min(availableProcessors - 1, 3));
        e = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ScheduledExecutorService scheduledExecutorService) {
        this.j = false;
        j jVar = new j();
        this.i = jVar;
        this.f = scheduledExecutorService == null ? Executors.newScheduledThreadPool(d, jVar) : scheduledExecutorService;
        this.g = new SparseArray<>();
        this.h = new SparseArray<>();
    }

    private Runnable b(Runnable runnable) {
        return new h(this, runnable);
    }

    private boolean f() {
        if (this.j) {
            com.tencent.beacon.base.util.c.b("[task] was closed , should all stopped!", new Object[0]);
            return true;
        }
        return false;
    }

    @Override // com.tencent.beacon.a.b.a
    public Handler a(int i) {
        Handler handler;
        synchronized (this) {
            Handler handler2 = this.h.get(i);
            handler = handler2;
            if (handler2 == null) {
                HandlerThread handlerThread = new HandlerThread(this.i.a());
                handlerThread.start();
                handler = new Handler(handlerThread.getLooper());
            }
            this.h.put(i, handler);
        }
        return handler;
    }

    @Override // com.tencent.beacon.a.b.a
    public void a(int i, long j, long j2, Runnable runnable) {
        synchronized (this) {
            if (f()) {
                return;
            }
            a aVar = this.g.get(i);
            if (aVar == null || aVar.a()) {
                Runnable b = b(runnable);
                if (j <= 0) {
                    j = 0;
                }
                if (j2 < 100) {
                    j2 = 100;
                }
                a aVar2 = new a(this.f.scheduleAtFixedRate(b, j, j2, TimeUnit.MILLISECONDS), b, j, j2, TimeUnit.MILLISECONDS);
                com.tencent.beacon.base.util.c.a("[task] add a new polling task! taskId: %d , periodTime: %d", Integer.valueOf(i), Long.valueOf(j2));
                this.g.put(i, aVar2);
            }
        }
    }

    @Override // com.tencent.beacon.a.b.a
    public void a(int i, boolean z) {
        a aVar = this.g.get(i);
        if (aVar == null || aVar.a()) {
            return;
        }
        com.tencent.beacon.base.util.c.a("[task] cancel a old pollingTaskWrapper!", new Object[0]);
        aVar.a(z);
    }

    @Override // com.tencent.beacon.a.b.a
    public void a(long j, Runnable runnable) {
        synchronized (this) {
            if (f()) {
                return;
            }
            Runnable b = b(runnable);
            if (j <= 0) {
                j = 0;
            }
            this.f.schedule(b, j, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.tencent.beacon.a.b.a
    public void a(Runnable runnable) {
        synchronized (this) {
            if (f()) {
                return;
            }
            this.f.execute(b(runnable));
        }
    }

    @Override // com.tencent.beacon.a.b.a
    public void a(boolean z) {
        synchronized (this) {
            if (f()) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.g.size()) {
                    com.tencent.beacon.base.util.c.a("[task] All schedule tasks stop", new Object[0]);
                    return;
                } else {
                    a(this.g.keyAt(i2), z);
                    i = i2 + 1;
                }
            }
        }
    }

    @Override // com.tencent.beacon.a.b.a
    public void b(int i) {
        synchronized (this) {
            if (c()) {
                a aVar = this.g.get(i);
                if (aVar != null) {
                    if (!aVar.a()) {
                        return;
                    }
                    aVar.e = this.f.scheduleAtFixedRate(aVar.f34932a, aVar.b, aVar.f34933c, aVar.d);
                }
            }
        }
    }

    @Override // com.tencent.beacon.a.b.a
    public void d() {
        synchronized (this) {
            com.tencent.beacon.base.util.c.a("[task] Resumed all schedule task", new Object[0]);
            if (f()) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.g.size()) {
                    com.tencent.beacon.base.util.c.a("[task] Resumed all schedule task", new Object[0]);
                    return;
                } else {
                    b(this.g.keyAt(i2));
                    i = i2 + 1;
                }
            }
        }
    }
}
