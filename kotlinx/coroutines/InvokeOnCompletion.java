package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/InvokeOnCompletion.class */
public final class InvokeOnCompletion extends JobNode {

    /* renamed from: a  reason: collision with root package name */
    private final Function1<Throwable, Unit> f42834a;

    /* JADX WARN: Multi-variable type inference failed */
    public InvokeOnCompletion(Function1<? super Throwable, Unit> function1) {
        this.f42834a = function1;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void a(Throwable th) {
        this.f42834a.invoke(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.f42314a;
    }
}
