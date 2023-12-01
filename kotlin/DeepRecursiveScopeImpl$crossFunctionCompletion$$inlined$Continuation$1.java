package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1.class */
public final class DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1 implements Continuation<Object> {
    final /* synthetic */ CoroutineContext a;
    final /* synthetic */ DeepRecursiveScopeImpl b;
    final /* synthetic */ Function3 c;
    final /* synthetic */ Continuation d;

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.a;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        this.b.a = this.c;
        this.b.b = this.d;
        this.b.c = obj;
    }
}
