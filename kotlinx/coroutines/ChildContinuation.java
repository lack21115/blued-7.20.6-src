package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ChildContinuation.class */
public final class ChildContinuation extends JobCancellingNode {

    /* renamed from: a  reason: collision with root package name */
    public final CancellableContinuationImpl<?> f42787a;

    public ChildContinuation(CancellableContinuationImpl<?> cancellableContinuationImpl) {
        this.f42787a = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void a(Throwable th) {
        CancellableContinuationImpl<?> cancellableContinuationImpl = this.f42787a;
        cancellableContinuationImpl.c(cancellableContinuationImpl.a((Job) c()));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.f42314a;
    }
}
