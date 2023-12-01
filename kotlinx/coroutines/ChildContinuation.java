package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ChildContinuation.class */
public final class ChildContinuation extends JobCancellingNode {
    public final CancellableContinuationImpl<?> a;

    public ChildContinuation(CancellableContinuationImpl<?> cancellableContinuationImpl) {
        this.a = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void a(Throwable th) {
        CancellableContinuationImpl<?> cancellableContinuationImpl = this.a;
        cancellableContinuationImpl.c(cancellableContinuationImpl.a((Job) c()));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.a;
    }
}
