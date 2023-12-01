package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/jvm/internal/BaseContinuationImpl.class */
public abstract class BaseContinuationImpl implements Serializable, Continuation<Object>, CoroutineStackFrame {
    private final Continuation<Object> completion;

    public BaseContinuationImpl(Continuation<Object> continuation) {
        this.completion = continuation;
    }

    public Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.e(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public Continuation<Unit> create(Continuation<?> completion) {
        Intrinsics.e(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<Object> continuation = this.completion;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    public final Continuation<Object> getCompletion() {
        return this.completion;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return DebugMetadataKt.a(this);
    }

    protected abstract Object invokeSuspend(Object obj);

    protected void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.coroutines.Continuation<java.lang.Object>] */
    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object invokeSuspend;
        BaseContinuationImpl baseContinuationImpl = this;
        do {
            DebugProbesKt.b(baseContinuationImpl);
            BaseContinuationImpl baseContinuationImpl2 = baseContinuationImpl;
            baseContinuationImpl = baseContinuationImpl2.completion;
            Intrinsics.a(baseContinuationImpl);
            try {
                invokeSuspend = baseContinuationImpl2.invokeSuspend(obj);
            } catch (Throwable th) {
                Result.Companion companion = Result.a;
                obj = Result.f(ResultKt.a(th));
            }
            if (invokeSuspend == IntrinsicsKt.a()) {
                return;
            }
            Result.Companion companion2 = Result.a;
            obj = Result.f(invokeSuspend);
            baseContinuationImpl2.releaseIntercepted();
        } while (baseContinuationImpl instanceof BaseContinuationImpl);
        baseContinuationImpl.resumeWith(obj);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append((Serializable) stackTraceElement);
        return sb.toString();
    }
}
