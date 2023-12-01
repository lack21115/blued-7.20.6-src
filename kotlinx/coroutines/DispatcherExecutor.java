package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/DispatcherExecutor.class */
final class DispatcherExecutor implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineDispatcher f42809a;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f42809a.dispatch(EmptyCoroutineContext.f42457a, runnable);
    }

    public String toString() {
        return this.f42809a.toString();
    }
}
