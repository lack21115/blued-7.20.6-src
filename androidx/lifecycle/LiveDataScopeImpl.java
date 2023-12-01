package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/LiveDataScopeImpl.class */
public final class LiveDataScopeImpl<T> implements LiveDataScope<T> {
    private final CoroutineContext coroutineContext;
    private CoroutineLiveData<T> target;

    public LiveDataScopeImpl(CoroutineLiveData<T> target, CoroutineContext context) {
        Intrinsics.e(target, "target");
        Intrinsics.e(context, "context");
        this.target = target;
        this.coroutineContext = context.plus(Dispatchers.b().a());
    }

    @Override // androidx.lifecycle.LiveDataScope
    public Object emit(T t, Continuation<? super Unit> continuation) {
        Object a2 = BuildersKt.a(this.coroutineContext, new LiveDataScopeImpl$emit$2(this, t, null), continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }

    @Override // androidx.lifecycle.LiveDataScope
    public Object emitSource(LiveData<T> liveData, Continuation<? super DisposableHandle> continuation) {
        return BuildersKt.a(this.coroutineContext, new LiveDataScopeImpl$emitSource$2(this, liveData, null), continuation);
    }

    @Override // androidx.lifecycle.LiveDataScope
    public T getLatestValue() {
        return this.target.getValue();
    }

    public final CoroutineLiveData<T> getTarget$lifecycle_livedata_ktx_release() {
        return this.target;
    }

    public final void setTarget$lifecycle_livedata_ktx_release(CoroutineLiveData<T> coroutineLiveData) {
        Intrinsics.e(coroutineLiveData, "<set-?>");
        this.target = coroutineLiveData;
    }
}
