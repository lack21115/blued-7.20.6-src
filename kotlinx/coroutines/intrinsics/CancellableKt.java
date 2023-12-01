package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/intrinsics/CancellableKt.class */
public final class CancellableKt {
    public static final void a(Continuation<? super Unit> continuation, Continuation<?> continuation2) {
        try {
            Continuation a2 = IntrinsicsKt.a(continuation);
            Result.Companion companion = Result.f42293a;
            DispatchedContinuationKt.a(a2, Result.f(Unit.f42314a), null, 2, null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f42293a;
            continuation2.resumeWith(Result.f(ResultKt.a(th)));
        }
    }

    public static final <T> void a(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        try {
            Continuation a2 = IntrinsicsKt.a(IntrinsicsKt.a(function1, continuation));
            Result.Companion companion = Result.f42293a;
            DispatchedContinuationKt.a(a2, Result.f(Unit.f42314a), null, 2, null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f42293a;
            continuation.resumeWith(Result.f(ResultKt.a(th)));
        }
    }

    public static final <R, T> void a(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation, Function1<? super Throwable, Unit> function1) {
        try {
            Continuation a2 = IntrinsicsKt.a(IntrinsicsKt.a(function2, r, continuation));
            Result.Companion companion = Result.f42293a;
            DispatchedContinuationKt.a(a2, Result.f(Unit.f42314a), function1);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f42293a;
            continuation.resumeWith(Result.f(ResultKt.a(th)));
        }
    }

    public static /* synthetic */ void a(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i, Object obj2) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        a(function2, obj, continuation, function1);
    }
}
