package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CancelFutureOnCancel.class */
final class CancelFutureOnCancel extends CancelHandler {
    private final Future<?> a;

    public CancelFutureOnCancel(Future<?> future) {
        this.a = future;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void a(Throwable th) {
        this.a.cancel(false);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.a;
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.a + ']';
    }
}
