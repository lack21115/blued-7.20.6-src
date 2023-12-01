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
            Executor a = a();
            ScheduledExecutorService scheduledExecutorService = a instanceof ScheduledExecutorService ? (ScheduledExecutorService) a : null;
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
        ScheduledFuture<?> a = this.b ? a(runnable, coroutineContext, j) : null;
        return a != null ? new DisposableFutureHandle(a) : DefaultExecutor.b.a(j, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.Delay
    public void a(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        ScheduledFuture<?> a = this.b ? a(new ResumeUndispatchedRunnable(this, cancellableContinuation), cancellableContinuation.getContext(), j) : null;
        if (a != null) {
            JobKt.a(cancellableContinuation, a);
        } else {
            DefaultExecutor.b.a(j, cancellableContinuation);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor a = a();
        ExecutorService executorService = a instanceof ExecutorService ? (ExecutorService) a : null;
        if (executorService == null) {
            return;
        }
        executorService.shutdown();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            Executor a = a();
            AbstractTimeSource a2 = AbstractTimeSourceKt.a();
            a.execute(a2 == null ? runnable : a2.a(runnable));
        } catch (RejectedExecutionException e) {
            AbstractTimeSource a3 = AbstractTimeSourceKt.a();
            if (a3 != null) {
                a3.c();
            }
            a(coroutineContext, e);
            Dispatchers dispatchers = Dispatchers.a;
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
