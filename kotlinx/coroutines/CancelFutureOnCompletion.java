package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CancelFutureOnCompletion.class */
final class CancelFutureOnCompletion extends JobNode {
    private final Future<?> a;

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void a(Throwable th) {
        this.a.cancel(false);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.a;
    }
}
