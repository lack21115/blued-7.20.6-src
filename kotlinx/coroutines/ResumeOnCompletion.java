package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ResumeOnCompletion.class */
public final class ResumeOnCompletion extends JobNode {
    private final Continuation<Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeOnCompletion(Continuation<? super Unit> continuation) {
        this.a = continuation;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void a(Throwable th) {
        Continuation<Unit> continuation = this.a;
        Unit unit = Unit.a;
        Result.Companion companion = Result.a;
        continuation.resumeWith(Result.f(unit));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.a;
    }
}
