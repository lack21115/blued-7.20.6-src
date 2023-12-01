package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ResumeAwaitOnCompletion.class */
public final class ResumeAwaitOnCompletion<T> extends JobNode {

    /* renamed from: a  reason: collision with root package name */
    private final CancellableContinuationImpl<T> f42849a;

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeAwaitOnCompletion(CancellableContinuationImpl<? super T> cancellableContinuationImpl) {
        this.f42849a = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void a(Throwable th) {
        Object l = c().l();
        if (DebugKt.a() && !(!(l instanceof Incomplete))) {
            throw new AssertionError();
        }
        if (l instanceof CompletedExceptionally) {
            CancellableContinuationImpl<T> cancellableContinuationImpl = this.f42849a;
            Throwable th2 = ((CompletedExceptionally) l).f42791a;
            Result.Companion companion = Result.f42293a;
            cancellableContinuationImpl.resumeWith(Result.f(ResultKt.a(th2)));
            return;
        }
        CancellableContinuationImpl<T> cancellableContinuationImpl2 = this.f42849a;
        Object b = JobSupportKt.b(l);
        Result.Companion companion2 = Result.f42293a;
        cancellableContinuationImpl2.resumeWith(Result.f(b));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.f42314a;
    }
}
