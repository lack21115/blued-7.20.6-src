package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CompletableDeferredImpl.class */
final class CompletableDeferredImpl<T> extends JobSupport implements CompletableDeferred<T>, SelectClause1<T> {
    @Override // kotlinx.coroutines.Deferred
    public Object a(Continuation<? super T> continuation) {
        return c((Continuation<Object>) continuation);
    }

    @Override // kotlinx.coroutines.selects.SelectClause1
    public <R> void a(SelectInstance<? super R> selectInstance, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        b(selectInstance, function2);
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public boolean a(T t) {
        return f(t);
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public boolean a(Throwable th) {
        return f(new CompletedExceptionally(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean e() {
        return true;
    }

    @Override // kotlinx.coroutines.Deferred
    public T f() {
        return (T) p();
    }
}
