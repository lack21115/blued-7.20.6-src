package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/DisposeOnCompletion.class */
public final class DisposeOnCompletion extends JobNode {
    private final DisposableHandle a;

    public DisposeOnCompletion(DisposableHandle disposableHandle) {
        this.a = disposableHandle;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void a(Throwable th) {
        this.a.dispose();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.a;
    }
}
