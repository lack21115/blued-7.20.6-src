package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ThreadPoolDispatcher.class */
public final class ThreadPoolDispatcher extends ExecutorCoroutineDispatcherBase {
    private final int b;
    private final String d;
    private final Executor e;

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor a() {
        return this.e;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcherBase, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((ExecutorService) a()).shutdown();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcherBase, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "ThreadPoolDispatcher[" + this.b + ", " + this.d + ']';
    }
}
