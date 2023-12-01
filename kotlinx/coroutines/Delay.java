package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/Delay.class */
public interface Delay {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/Delay$DefaultImpls.class */
    public static final class DefaultImpls {
        public static DisposableHandle a(Delay delay, long j, Runnable runnable, CoroutineContext coroutineContext) {
            return DefaultExecutorKt.a().a(j, runnable, coroutineContext);
        }
    }

    DisposableHandle a(long j, Runnable runnable, CoroutineContext coroutineContext);

    void a(long j, CancellableContinuation<? super Unit> cancellableContinuation);
}
