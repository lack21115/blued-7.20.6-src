package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/SelectJoinOnCompletion.class */
final class SelectJoinOnCompletion<R> extends JobNode {
    private final SelectInstance<R> a;
    private final Function1<Continuation<? super R>, Object> b;

    /* JADX WARN: Multi-variable type inference failed */
    public SelectJoinOnCompletion(SelectInstance<? super R> selectInstance, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        this.a = selectInstance;
        this.b = function1;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void a(Throwable th) {
        if (this.a.g()) {
            CancellableKt.a(this.b, this.a.a());
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.a;
    }
}
