package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/NoOpContinuation.class */
final class NoOpContinuation implements Continuation<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final NoOpContinuation f43496a = new NoOpContinuation();
    private static final CoroutineContext b = EmptyCoroutineContext.f42457a;

    private NoOpContinuation() {
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return b;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
    }
}
