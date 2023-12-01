package com.tencent.tmsbeacon.a.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.tencent.tmsbeacon.base.util.c;
import com.tencent.tmsbeacon.base.util.e;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/b/f.class */
public class f extends com.tencent.tmsbeacon.a.b.a {
    private static final int b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f39466c;
    private static final AtomicInteger d;
    private final ScheduledExecutorService e;
    private final SparseArray<b> f;
    private final SparseArray<Handler> g;
    private final g h;
    private boolean i;
    private boolean j;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/b/f$a.class */
    public class a implements Runnable {
        public final /* synthetic */ Runnable b;

        public a(Runnable runnable) {
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } catch (Throwable th) {
                if (f.d.addAndGet(1) < 100) {
                    d.b().a("599", "[task] run occur error!", th);
                }
                e.a(th.getMessage());
                c.a(th);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/b/f$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f39468a;
        private final long b;

        /* renamed from: c  reason: collision with root package name */
        private final long f39469c;
        private final TimeUnit d;
        private Future<?> e;

        public b(Future<?> future, Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            this.e = future;
            this.f39468a = runnable;
            this.b = j;
            this.f39469c = j2;
            this.d = timeUnit;
        }

        public boolean a() {
            return this.e.isCancelled();
        }

        public boolean a(boolean z) {
            return this.e.cancel(z);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        b = availableProcessors;
        f39466c = Math.max(2, Math.min(availableProcessors - 1, 3));
        d = new AtomicInteger(0);
    }

    public f() {
        this(null);
    }

    public f(ScheduledExecutorService scheduledExecutorService) {
        this.i = false;
        this.j = true;
        g gVar = new g();
        this.h = gVar;
        this.e = scheduledExecutorService == null ? Executors.newScheduledThreadPool(f39466c, gVar) : scheduledExecutorService;
        this.f = new SparseArray<>();
        this.g = new SparseArray<>();
    }

    private Runnable b(Runnable runnable) {
        return new a(runnable);
    }

    private boolean e() {
        if (this.i) {
            c.b("[task] was closed , should all stopped!", new Object[0]);
            return true;
        }
        return false;
    }

    @Override // com.tencent.tmsbeacon.a.b.a
    public Handler a(int i) {
        Handler handler;
        synchronized (this) {
            Handler handler2 = this.g.get(i);
            handler = handler2;
            if (handler2 == null) {
                HandlerThread handlerThread = new HandlerThread(this.h.a());
                handlerThread.start();
                handler = new Handler(handlerThread.getLooper());
            }
            this.g.put(i, handler);
        }
        return handler;
    }

    @Override // com.tencent.tmsbeacon.a.b.a
    public void a(int i, long j, long j2, Runnable runnable) {
        synchronized (this) {
            if (e()) {
                return;
            }
            b bVar = this.f.get(i);
            if (bVar == null || bVar.a()) {
                Runnable b2 = b(runnable);
                if (j <= 0) {
                    j = 0;
                }
                if (j2 < 500) {
                    j2 = 500;
                }
                ScheduledExecutorService scheduledExecutorService = this.e;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                b bVar2 = new b(scheduledExecutorService.scheduleAtFixedRate(b2, j, j2, timeUnit), b2, j, j2, timeUnit);
                c.a("[task] add a new polling task! taskId: %d , periodTime: %d", Integer.valueOf(i), Long.valueOf(j2));
                this.f.put(i, bVar2);
            }
        }
    }

    @Override // com.tencent.tmsbeacon.a.b.a
    public void a(int i, boolean z) {
        b bVar = this.f.get(i);
        if (bVar == null || bVar.a()) {
            return;
        }
        c.a("[task] cancel a old pollingTaskWrapper!", new Object[0]);
        bVar.a(z);
    }

    @Override // com.tencent.tmsbeacon.a.b.a
    public void a(long j, Runnable runnable) {
        synchronized (this) {
            if (e()) {
                return;
            }
            Runnable b2 = b(runnable);
            if (j <= 0) {
                j = 0;
            }
            this.e.schedule(b2, j, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.tencent.tmsbeacon.a.b.a
    public void a(Runnable runnable) {
        synchronized (this) {
            if (e()) {
                return;
            }
            this.e.execute(b(runnable));
        }
    }

    @Override // com.tencent.tmsbeacon.a.b.a
    public void a(boolean z) {
        synchronized (this) {
            if (e()) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f.size()) {
                    this.j = false;
                    c.a("[task] All schedule tasks stop", new Object[0]);
                    return;
                }
                a(this.f.keyAt(i2), z);
                i = i2 + 1;
            }
        }
    }

    @Override // com.tencent.tmsbeacon.a.b.a
    public void b(int i) {
        synchronized (this) {
            if (this.j) {
                b bVar = this.f.get(i);
                if (bVar != null) {
                    if (!bVar.a()) {
                        return;
                    }
                    bVar.e = this.e.scheduleAtFixedRate(bVar.f39468a, bVar.b, bVar.f39469c, bVar.d);
                }
            }
        }
    }

    @Override // com.tencent.tmsbeacon.a.b.a
    public void c() {
        synchronized (this) {
            c.a("[task] Resumed all schedule task", new Object[0]);
            if (e()) {
                return;
            }
            this.j = true;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f.size()) {
                    c.a("[task] Resumed all schedule task", new Object[0]);
                    return;
                } else {
                    b(this.f.keyAt(i2));
                    i = i2 + 1;
                }
            }
        }
    }
}
