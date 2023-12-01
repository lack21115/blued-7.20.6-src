package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1.class */
public final class DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1 implements Continuation<Object> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CoroutineContext f42277a;
    final /* synthetic */ DeepRecursiveScopeImpl b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function3 f42278c;
    final /* synthetic */ Continuation d;

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f42277a;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        this.b.f42275a = this.f42278c;
        this.b.b = this.d;
        this.b.f42276c = obj;
    }
}
