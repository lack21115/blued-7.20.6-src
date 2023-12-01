package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/ContinuationKt.class */
public final class ContinuationKt {
    public static final <R, T> void a(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> completion) {
        Intrinsics.e(function2, "<this>");
        Intrinsics.e(completion, "completion");
        Continuation a2 = IntrinsicsKt.a(IntrinsicsKt.a(function2, r, completion));
        Result.Companion companion = Result.f42293a;
        a2.resumeWith(Result.f(Unit.f42314a));
    }
}
