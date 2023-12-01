package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__LimitKt.class */
final /* synthetic */ class FlowKt__LimitKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(kotlinx.coroutines.flow.Flow<? extends T> r4, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r0 = r6
            boolean r0 = r0 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1
            if (r0 == 0) goto L2b
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1) r0
            r8 = r0
            r0 = r8
            int r0 = r0.c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L2b
            r0 = r8
            r1 = r8
            int r1 = r1.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r1 + r2
            r0.c = r1
            r0 = r8
            r6 = r0
            goto L34
        L2b:
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1
            r1 = r0
            r2 = r6
            r1.<init>(r2)
            r6 = r0
        L34:
            r0 = r6
            java.lang.Object r0 = r0.b
            r9 = r0
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r8 = r0
            r0 = r6
            int r0 = r0.c
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L6b
            r0 = r7
            r1 = 1
            if (r0 != r1) goto L61
            r0 = r6
            java.lang.Object r0 = r0.a
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1) r0
            r4 = r0
            r0 = r9
            kotlin.ResultKt.a(r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L5d
            goto La9
        L5d:
            r5 = move-exception
            goto La1
        L61:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L6b:
            r0 = r9
            kotlin.ResultKt.a(r0)
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1
            r1 = r0
            r2 = r5
            r1.<init>(r2)
            r5 = r0
            r0 = r5
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L9c
            r9 = r0
            r0 = r6
            r1 = r5
            r0.a = r1     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L9c
            r0 = r6
            r1 = 1
            r0.c = r1     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L9c
            r0 = r4
            r1 = r9
            r2 = r6
            java.lang.Object r0 = r0.a(r1, r2)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L9c
            r4 = r0
            r0 = r4
            r1 = r8
            if (r0 != r1) goto La9
            r0 = r8
            return r0
        L9c:
            r6 = move-exception
            r0 = r5
            r4 = r0
            r0 = r6
            r5 = r0
        La1:
            r0 = r5
            r1 = r4
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.a(r0, r1)
        La9:
            kotlin.Unit r0 = kotlin.Unit.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt.a(kotlinx.coroutines.flow.Flow, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final <T> Flow<T> a(final Flow<? extends T> flow, final Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
                Object a = Flow.this.a(new FlowKt__LimitKt$dropWhile$lambda4$$inlined$collect$1(new Ref.BooleanRef(), flowCollector, function2), continuation);
                return a == IntrinsicsKt.a() ? a : Unit.a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object b(kotlinx.coroutines.flow.FlowCollector<? super T> r4, T r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r0 = r6
            boolean r0 = r0 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1
            if (r0 == 0) goto L2b
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1) r0
            r8 = r0
            r0 = r8
            int r0 = r0.c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L2b
            r0 = r8
            r1 = r8
            int r1 = r1.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r1 + r2
            r0.c = r1
            r0 = r8
            r6 = r0
            goto L34
        L2b:
            kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1
            r1 = r0
            r2 = r6
            r1.<init>(r2)
            r6 = r0
        L34:
            r0 = r6
            java.lang.Object r0 = r0.b
            r9 = r0
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r10 = r0
            r0 = r6
            int r0 = r0.c
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L68
            r0 = r7
            r1 = 1
            if (r0 == r1) goto L57
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L57:
            r0 = r6
            java.lang.Object r0 = r0.a
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            r8 = r0
            r0 = r9
            kotlin.ResultKt.a(r0)
            goto L8a
        L68:
            r0 = r9
            kotlin.ResultKt.a(r0)
            r0 = r6
            r1 = r4
            r0.a = r1
            r0 = r6
            r1 = 1
            r0.c = r1
            r0 = r4
            r8 = r0
            r0 = r4
            r1 = r5
            r2 = r6
            java.lang.Object r0 = r0.emit(r1, r2)
            r1 = r10
            if (r0 != r1) goto L8a
            r0 = r10
            return r0
        L8a:
            kotlinx.coroutines.flow.internal.AbortFlowException r0 = new kotlinx.coroutines.flow.internal.AbortFlowException
            r1 = r0
            r2 = r8
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt.b(kotlinx.coroutines.flow.FlowCollector, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
