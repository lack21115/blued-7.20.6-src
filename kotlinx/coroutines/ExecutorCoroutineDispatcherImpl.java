package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ExecutorCoroutineDispatcherImpl.class */
final class ExecutorCoroutineDispatcherImpl extends ExecutorCoroutineDispatcherBase {
    private final Executor b;

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor a() {
        return this.b;
    }
}
