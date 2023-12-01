package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.Job;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/ScopeCoroutine.class */
public class ScopeCoroutine<T> extends AbstractCoroutine<T> implements CoroutineStackFrame {
    public final Continuation<T> c;

    /* JADX WARN: Multi-variable type inference failed */
    public ScopeCoroutine(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, true, true);
        this.c = continuation;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public void c(Object obj) {
        Continuation<T> continuation = this.c;
        continuation.resumeWith(CompletionStateKt.a(obj, continuation));
    }

    @Override // kotlinx.coroutines.JobSupport
    public void d(Object obj) {
        DispatchedContinuationKt.a(IntrinsicsKt.a(this.c), CompletionStateKt.a(obj, this.c), null, 2, null);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean d() {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.c;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    public final Job r() {
        ChildHandle ax_ = ax_();
        if (ax_ == null) {
            return null;
        }
        return ax_.a();
    }
}
