package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
@DebugMetadata(b = "Errors.kt", c = {124}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ErrorsKt$retry$3.class */
final class FlowKt__ErrorsKt$retry$3<T> extends SuspendLambda implements Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> {
    int a;
    /* synthetic */ Object b;
    /* synthetic */ long c;
    final /* synthetic */ long d;
    final /* synthetic */ Function2<Throwable, Continuation<? super Boolean>, Object> e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ErrorsKt$retry$3(long j, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super FlowKt__ErrorsKt$retry$3> continuation) {
        super(4, continuation);
        this.d = j;
        this.e = function2;
    }

    public final Object a(FlowCollector<? super T> flowCollector, Throwable th, long j, Continuation<? super Boolean> continuation) {
        FlowKt__ErrorsKt$retry$3 flowKt__ErrorsKt$retry$3 = new FlowKt__ErrorsKt$retry$3(this.d, this.e, continuation);
        flowKt__ErrorsKt$retry$3.b = th;
        flowKt__ErrorsKt$retry$3.c = j;
        return flowKt__ErrorsKt$retry$3.invokeSuspend(Unit.a);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* synthetic */ Object invoke(Object obj, Throwable th, Long l, Continuation<? super Boolean> continuation) {
        return a((FlowCollector) obj, th, l.longValue(), continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0068, code lost:
        if (((java.lang.Boolean) r6).booleanValue() != false) goto L9;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r10 = r0
            r0 = r5
            int r0 = r0.a
            r7 = r0
            r0 = 1
            r8 = r0
            r0 = r7
            if (r0 == 0) goto L26
            r0 = r7
            r1 = 1
            if (r0 != r1) goto L1c
            r0 = r6
            kotlin.ResultKt.a(r0)
            goto L61
        L1c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L26:
            r0 = r6
            kotlin.ResultKt.a(r0)
            r0 = r5
            java.lang.Object r0 = r0.b
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r6 = r0
            r0 = r5
            long r0 = r0.c
            r1 = r5
            long r1 = r1.d
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L6e
            r0 = r5
            kotlin.jvm.functions.Function2<java.lang.Throwable, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r0 = r0.e
            r9 = r0
            r0 = r5
            r1 = 1
            r0.a = r1
            r0 = r9
            r1 = r6
            r2 = r5
            java.lang.Object r0 = r0.invoke(r1, r2)
            r9 = r0
            r0 = r9
            r6 = r0
            r0 = r9
            r1 = r10
            if (r0 != r1) goto L61
            r0 = r10
            return r0
        L61:
            r0 = r6
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L6e
            goto L70
        L6e:
            r0 = 0
            r8 = r0
        L70:
            r0 = r8
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.a(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
