package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/JobKt.class */
public final class JobKt {
    public static final CompletableJob a(Job job) {
        return JobKt__JobKt.a(job);
    }

    public static final DisposableHandle a(Job job, DisposableHandle disposableHandle) {
        return JobKt__JobKt.a(job, disposableHandle);
    }

    public static final void a(CoroutineContext coroutineContext) {
        JobKt__JobKt.a(coroutineContext);
    }

    public static final void a(CoroutineContext coroutineContext, CancellationException cancellationException) {
        JobKt__JobKt.a(coroutineContext, cancellationException);
    }

    public static final void a(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        JobKt__FutureKt.a(cancellableContinuation, future);
    }

    public static final Job b(CoroutineContext coroutineContext) {
        return JobKt__JobKt.b(coroutineContext);
    }

    public static final void b(Job job) {
        JobKt__JobKt.b(job);
    }
}
