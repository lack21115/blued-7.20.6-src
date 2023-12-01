package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/SelectAwaitOnCompletion.class */
public final class SelectAwaitOnCompletion<T, R> extends JobNode {

    /* renamed from: a  reason: collision with root package name */
    private final SelectInstance<R> f42853a;
    private final Function2<T, Continuation<? super R>, Object> b;

    /* JADX WARN: Multi-variable type inference failed */
    public SelectAwaitOnCompletion(SelectInstance<? super R> selectInstance, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        this.f42853a = selectInstance;
        this.b = function2;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void a(Throwable th) {
        if (this.f42853a.g()) {
            c().c(this.f42853a, this.b);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.f42314a;
    }
}
