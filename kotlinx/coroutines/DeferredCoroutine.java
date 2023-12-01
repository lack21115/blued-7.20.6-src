package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/DeferredCoroutine.class */
class DeferredCoroutine<T> extends AbstractCoroutine<T> implements Deferred<T>, SelectClause1<T> {
    public DeferredCoroutine(CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, true, z);
    }

    @Override // kotlinx.coroutines.Deferred
    public Object a(Continuation<? super T> continuation) {
        return c((Continuation<Object>) continuation);
    }

    @Override // kotlinx.coroutines.selects.SelectClause1
    public <R> void a(SelectInstance<? super R> selectInstance, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        b(selectInstance, function2);
    }

    @Override // kotlinx.coroutines.Deferred
    public T f() {
        return (T) p();
    }
}
