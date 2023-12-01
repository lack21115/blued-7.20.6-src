package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/DisposeOnCancel.class */
public final class DisposeOnCancel extends CancelHandler {
    private final DisposableHandle a;

    public DisposeOnCancel(DisposableHandle disposableHandle) {
        this.a = disposableHandle;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void a(Throwable th) {
        this.a.dispose();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.a + ']';
    }
}
