package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/DisposeOnCompletion.class */
public final class DisposeOnCompletion extends JobNode {

    /* renamed from: a  reason: collision with root package name */
    private final DisposableHandle f42814a;

    public DisposeOnCompletion(DisposableHandle disposableHandle) {
        this.f42814a = disposableHandle;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void a(Throwable th) {
        this.f42814a.dispose();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.f42314a;
    }
}
