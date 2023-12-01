package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ResumeAwaitOnCompletion.class */
public final class ResumeAwaitOnCompletion<T> extends JobNode {
    private final CancellableContinuationImpl<T> a;

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeAwaitOnCompletion(CancellableContinuationImpl<? super T> cancellableContinuationImpl) {
        this.a = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void a(Throwable th) {
        Object l = c().l();
        if (DebugKt.a() && !(!(l instanceof Incomplete))) {
            throw new AssertionError();
        }
        if (l instanceof CompletedExceptionally) {
            CancellableContinuationImpl<T> cancellableContinuationImpl = this.a;
            Throwable th2 = ((CompletedExceptionally) l).a;
            Result.Companion companion = Result.a;
            cancellableContinuationImpl.resumeWith(Result.f(ResultKt.a(th2)));
            return;
        }
        CancellableContinuationImpl<T> cancellableContinuationImpl2 = this.a;
        Object b = JobSupportKt.b(l);
        Result.Companion companion2 = Result.a;
        cancellableContinuationImpl2.resumeWith(Result.f(b));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.a;
    }
}
