package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CancelFutureOnCompletion.class */
final class CancelFutureOnCompletion extends JobNode {

    /* renamed from: a  reason: collision with root package name */
    private final Future<?> f42784a;

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void a(Throwable th) {
        this.f42784a.cancel(false);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.f42314a;
    }
}
