package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ResumeOnCompletion.class */
public final class ResumeOnCompletion extends JobNode {

    /* renamed from: a  reason: collision with root package name */
    private final Continuation<Unit> f42850a;

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeOnCompletion(Continuation<? super Unit> continuation) {
        this.f42850a = continuation;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void a(Throwable th) {
        Continuation<Unit> continuation = this.f42850a;
        Unit unit = Unit.f42314a;
        Result.Companion companion = Result.f42293a;
        continuation.resumeWith(Result.f(unit));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.f42314a;
    }
}
