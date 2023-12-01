package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/InvokeOnCancel.class */
public final class InvokeOnCancel extends CancelHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Function1<Throwable, Unit> f42832a;

    /* JADX WARN: Multi-variable type inference failed */
    public InvokeOnCancel(Function1<? super Throwable, Unit> function1) {
        this.f42832a = function1;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void a(Throwable th) {
        this.f42832a.invoke(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.f42314a;
    }

    public String toString() {
        return "InvokeOnCancel[" + DebugStringsKt.b(this.f42832a) + '@' + DebugStringsKt.a(this) + ']';
    }
}
