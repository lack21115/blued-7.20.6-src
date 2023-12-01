package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ExecutorCoroutineDispatcherBase.class */
public abstract class ExecutorCoroutineDispatcherBase extends ExecutorCoroutineDispatcher implements Delay {
    private boolean b;

    private final ScheduledFuture<?> a(Runnable runnable, CoroutineContext coroutineContext, long j) {
        try {
            Executor a2 = a();
            ScheduledExecutorService scheduledExecutorService = a2 instanceof ScheduledExecutorService ? (ScheduledExecutorService) a2 : null;
            if (scheduledExecutorService == null) {
                return null;
            }
            return scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            a(coroutineContext, e);
            return null;
        }
    }

    private final void a(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        JobKt.a(coroutineContext, ExceptionsKt.a("The task was rejected", rejectedExecutionException));
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle a(long j, Runnable runnable, CoroutineContext coroutineContext) {
        ScheduledFuture<?> a2 = this.b ? a(runnable, coroutineContext, j) : null;
        return a2 != null ? new DisposableFutureHandle(a2) : DefaultExecutor.b.a(j, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.Delay
    public void a(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        ScheduledFuture<?> a2 = this.b ? a(new ResumeUndispatchedRunnable(this, cancellableContinuation), cancellableContinuation.getContext(), j) : null;
        if (a2 != null) {
            JobKt.a(cancellableContinuation, a2);
        } else {
            DefaultExecutor.b.a(j, cancellableContinuation);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor a2 = a();
        ExecutorService executorService = a2 instanceof ExecutorService ? (ExecutorService) a2 : null;
        if (executorService == null) {
            return;
        }
        executorService.shutdown();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            Executor a2 = a();
            AbstractTimeSource a3 = AbstractTimeSourceKt.a();
            a2.execute(a3 == null ? runnable : a3.a(runnable));
        } catch (RejectedExecutionException e) {
            AbstractTimeSource a4 = AbstractTimeSourceKt.a();
            if (a4 != null) {
                a4.c();
            }
            a(coroutineContext, e);
            Dispatchers dispatchers = Dispatchers.f42810a;
            Dispatchers.c().dispatch(coroutineContext, runnable);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ExecutorCoroutineDispatcherBase) && ((ExecutorCoroutineDispatcherBase) obj).a() == a();
    }

    public int hashCode() {
        return System.identityHashCode(a());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return a().toString();
    }
}
