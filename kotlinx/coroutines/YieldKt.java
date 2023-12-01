package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/YieldKt.class */
public final class YieldKt {
    public static final Object a(Continuation<? super Unit> continuation) {
        Object a;
        CoroutineContext context = continuation.getContext();
        JobKt.a(context);
        Continuation a2 = IntrinsicsKt.a(continuation);
        DispatchedContinuation dispatchedContinuation = a2 instanceof DispatchedContinuation ? (DispatchedContinuation) a2 : null;
        if (dispatchedContinuation == null) {
            a = Unit.a;
        } else {
            if (dispatchedContinuation.b.isDispatchNeeded(context)) {
                dispatchedContinuation.a(context, (CoroutineContext) Unit.a);
            } else {
                YieldContext yieldContext = new YieldContext();
                dispatchedContinuation.a(context.plus(yieldContext), (CoroutineContext) Unit.a);
                if (yieldContext.b) {
                    a = DispatchedContinuationKt.a(dispatchedContinuation) ? IntrinsicsKt.a() : Unit.a;
                }
            }
            a = IntrinsicsKt.a();
        }
        if (a == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return a == IntrinsicsKt.a() ? a : Unit.a;
    }
}
