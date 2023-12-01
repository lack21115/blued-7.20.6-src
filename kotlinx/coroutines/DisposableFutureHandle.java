package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/DisposableFutureHandle.class */
final class DisposableFutureHandle implements DisposableHandle {
    private final Future<?> a;

    public DisposableFutureHandle(Future<?> future) {
        this.a = future;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        this.a.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.a + ']';
    }
}
