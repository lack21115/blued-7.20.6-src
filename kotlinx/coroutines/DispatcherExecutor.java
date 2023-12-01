package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/DispatcherExecutor.class */
final class DispatcherExecutor implements Executor {
    public final CoroutineDispatcher a;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.dispatch(EmptyCoroutineContext.a, runnable);
    }

    public String toString() {
        return this.a.toString();
    }
}
