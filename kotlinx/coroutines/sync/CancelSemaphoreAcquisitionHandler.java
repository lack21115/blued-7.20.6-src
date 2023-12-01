package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.CancelHandler;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/CancelSemaphoreAcquisitionHandler.class */
final class CancelSemaphoreAcquisitionHandler extends CancelHandler {
    private final SemaphoreSegment a;
    private final int b;

    public CancelSemaphoreAcquisitionHandler(SemaphoreSegment semaphoreSegment, int i) {
        this.a = semaphoreSegment;
        this.b = i;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void a(Throwable th) {
        this.a.a(this.b);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.a;
    }

    public String toString() {
        return "CancelSemaphoreAcquisitionHandler[" + this.a + ", " + this.b + ']';
    }
}
