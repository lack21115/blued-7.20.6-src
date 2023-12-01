package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/DisposeOnCancel.class */
public final class DisposeOnCancel extends CancelHandler {

    /* renamed from: a  reason: collision with root package name */
    private final DisposableHandle f42813a;

    public DisposeOnCancel(DisposableHandle disposableHandle) {
        this.f42813a = disposableHandle;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void a(Throwable th) {
        this.f42813a.dispose();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.f42314a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f42813a + ']';
    }
}
