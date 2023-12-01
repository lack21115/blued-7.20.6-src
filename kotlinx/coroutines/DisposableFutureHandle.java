package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/DisposableFutureHandle.class */
final class DisposableFutureHandle implements DisposableHandle {

    /* renamed from: a  reason: collision with root package name */
    private final Future<?> f42812a;

    public DisposableFutureHandle(Future<?> future) {
        this.f42812a = future;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        this.f42812a.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.f42812a + ']';
    }
}
