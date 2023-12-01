package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CancellableContinuationKt.class */
public final class CancellableContinuationKt {
    public static final <T> CancellableContinuationImpl<T> a(Continuation<? super T> continuation) {
        if (continuation instanceof DispatchedContinuation) {
            CancellableContinuationImpl<T> e = ((DispatchedContinuation) continuation).e();
            if (e == null || !e.f()) {
                e = null;
            }
            CancellableContinuationImpl<T> cancellableContinuationImpl = e;
            if (e == null) {
                cancellableContinuationImpl = new CancellableContinuationImpl<>(continuation, 2);
            }
            return cancellableContinuationImpl;
        }
        return new CancellableContinuationImpl<>(continuation, 1);
    }

    public static final void a(CancellableContinuation<?> cancellableContinuation, DisposableHandle disposableHandle) {
        cancellableContinuation.a((Function1<? super Throwable, Unit>) new DisposeOnCancel(disposableHandle));
    }

    public static final void a(CancellableContinuation<?> cancellableContinuation, LockFreeLinkedListNode lockFreeLinkedListNode) {
        cancellableContinuation.a((Function1<? super Throwable, Unit>) new RemoveOnCancel(lockFreeLinkedListNode));
    }
}
