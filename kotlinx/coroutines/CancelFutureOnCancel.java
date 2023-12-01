package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CancelFutureOnCancel.class */
final class CancelFutureOnCancel extends CancelHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Future<?> f42783a;

    public CancelFutureOnCancel(Future<?> future) {
        this.f42783a = future;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void a(Throwable th) {
        this.f42783a.cancel(false);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.f42314a;
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.f42783a + ']';
    }
}
