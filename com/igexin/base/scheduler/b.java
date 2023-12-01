package com.igexin.base.scheduler;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/base/scheduler/b.class */
final class b extends ScheduledThreadPoolExecutor {
    private static final AtomicLong b = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    InterfaceC0275b f9606a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/base/scheduler/b$a.class */
    public final class a<V> extends FutureTask<V> implements RunnableScheduledFuture<V> {
        private BaseTask b;

        /* renamed from: c  reason: collision with root package name */
        private long f9608c;
        private volatile long d;
        private final long e;
        private final int f;

        a(BaseTask baseTask, long j) {
            super(baseTask, null);
            this.b = baseTask;
            this.d = b.a(b.this, baseTask.getInitDelay(), TimeUnit.MILLISECONDS);
            this.e = baseTask.getPeriod();
            this.f = baseTask.getTaskLevel();
            this.f9608c = j;
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Delayed delayed) {
            Delayed delayed2 = delayed;
            if (delayed2 != this) {
                long delay = getDelay(TimeUnit.NANOSECONDS);
                long delay2 = delayed2.getDelay(TimeUnit.NANOSECONDS);
                if (delayed2 instanceof a) {
                    a aVar = (a) delayed2;
                    int i = this.f - aVar.f;
                    if (delay <= 0 && delay2 <= 0) {
                        if (i > 0) {
                            return -1;
                        }
                        if (i < 0) {
                            return 1;
                        }
                    }
                    int i2 = ((delay - delay2) > 0L ? 1 : ((delay - delay2) == 0L ? 0 : -1));
                    if (i2 > 0) {
                        return 1;
                    }
                    if (i2 < 0 || i > 0) {
                        return -1;
                    }
                    if (i < 0) {
                        return 1;
                    }
                    int i3 = ((this.f9608c - aVar.f9608c) > 0L ? 1 : ((this.f9608c - aVar.f9608c) == 0L ? 0 : -1));
                    if (i3 < 0) {
                        return -1;
                    }
                    if (i3 > 0) {
                        return 1;
                    }
                }
                int i4 = ((delay - delay2) > 0L ? 1 : ((delay - delay2) == 0L ? 0 : -1));
                if (i4 < 0) {
                    return -1;
                }
                return i4 > 0 ? 1 : 0;
            }
            return 0;
        }

        @Override // java.util.concurrent.FutureTask
        protected final void done() {
            this.b.setIsRunning(false);
            b.a(b.this, this.b);
            try {
                get();
                this.b.done();
            } catch (Throwable th) {
                if (th instanceof CancellationException) {
                    this.b.onCancel();
                } else {
                    this.b.onException(th);
                }
            }
        }

        @Override // java.util.concurrent.Delayed
        public final long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(this.d - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override // java.util.concurrent.RunnableScheduledFuture
        public final boolean isPeriodic() {
            return this.e != 0;
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            boolean isPeriodic = isPeriodic();
            if (b.super.isShutdown()) {
                cancel(false);
            } else if (!isPeriodic) {
                super.run();
            } else if (super.runAndReset()) {
                long convert = TimeUnit.NANOSECONDS.convert(this.e, TimeUnit.MILLISECONDS);
                if (convert > 0) {
                    this.d += convert;
                } else {
                    this.d = b.this.a(-convert);
                }
                b.super.getQueue().add(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.igexin.base.scheduler.b$b  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/base/scheduler/b$b.class */
    public interface InterfaceC0275b {
        void a(BaseTask baseTask);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(long j) {
        long j2;
        long nanoTime = System.nanoTime();
        if (j < 4611686018427387903L) {
            j2 = j;
        } else {
            Delayed delayed = (Delayed) super.getQueue().peek();
            j2 = j;
            if (delayed != null) {
                long delay = delayed.getDelay(TimeUnit.NANOSECONDS);
                j2 = j;
                if (delay < 0) {
                    j2 = j;
                    if (j - delay < 0) {
                        j2 = delay + Long.MAX_VALUE;
                    }
                }
            }
        }
        return nanoTime + j2;
    }

    static /* synthetic */ long a(b bVar, long j, TimeUnit timeUnit) {
        long j2 = j;
        if (j < 0) {
            j2 = 0;
        }
        return bVar.a(timeUnit.toNanos(j2));
    }

    static /* synthetic */ void a(b bVar, BaseTask baseTask) {
        InterfaceC0275b interfaceC0275b = bVar.f9606a;
        if (interfaceC0275b != null) {
            interfaceC0275b.a(baseTask);
        }
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected final <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> runnableScheduledFuture) {
        BaseTask baseTask = (BaseTask) runnable;
        a aVar = new a(baseTask, b.getAndIncrement());
        baseTask.bind(aVar);
        return aVar;
    }
}
