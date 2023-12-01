package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/StackFrameContinuation.class */
final class StackFrameContinuation<T> implements Continuation<T>, CoroutineStackFrame {

    /* renamed from: a  reason: collision with root package name */
    private final Continuation<T> f43510a;
    private final CoroutineContext b;

    /* JADX WARN: Multi-variable type inference failed */
    public StackFrameContinuation(Continuation<? super T> continuation, CoroutineContext coroutineContext) {
        this.f43510a = continuation;
        this.b = coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f43510a;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.b;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        this.f43510a.resumeWith(obj);
    }
}
