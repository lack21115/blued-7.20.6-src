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
        Object a2;
        CoroutineContext context = continuation.getContext();
        JobKt.a(context);
        Continuation a3 = IntrinsicsKt.a(continuation);
        DispatchedContinuation dispatchedContinuation = a3 instanceof DispatchedContinuation ? (DispatchedContinuation) a3 : null;
        if (dispatchedContinuation == null) {
            a2 = Unit.f42314a;
        } else {
            if (dispatchedContinuation.b.isDispatchNeeded(context)) {
                dispatchedContinuation.a(context, (CoroutineContext) Unit.f42314a);
            } else {
                YieldContext yieldContext = new YieldContext();
                dispatchedContinuation.a(context.plus(yieldContext), (CoroutineContext) Unit.f42314a);
                if (yieldContext.b) {
                    a2 = DispatchedContinuationKt.a(dispatchedContinuation) ? IntrinsicsKt.a() : Unit.f42314a;
                }
            }
            a2 = IntrinsicsKt.a();
        }
        if (a2 == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
