package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/LazyDeferredCoroutine.class */
final class LazyDeferredCoroutine<T> extends DeferredCoroutine<T> {
    private final Continuation<Unit> b;

    public LazyDeferredCoroutine(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        super(coroutineContext, false);
        this.b = IntrinsicsKt.a(function2, this, this);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void m() {
        CancellableKt.a(this.b, this);
    }
}
