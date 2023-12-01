package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function3;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/DeepRecursiveScopeImpl.class */
final class DeepRecursiveScopeImpl<T, R> extends DeepRecursiveScope<T, R> implements Continuation<R> {

    /* renamed from: a  reason: collision with root package name */
    private Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> f42275a;
    private Continuation<Object> b;

    /* renamed from: c  reason: collision with root package name */
    private Object f42276c;

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f42457a;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        this.b = null;
        this.f42276c = obj;
    }
}
