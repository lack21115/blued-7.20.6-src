package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/StandaloneCoroutine.class */
class StandaloneCoroutine extends AbstractCoroutine<Unit> {
    public StandaloneCoroutine(CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, true, z);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected boolean f(Throwable th) {
        CoroutineExceptionHandlerKt.a(getContext(), th);
        return true;
    }
}
