package kotlinx.coroutines.flow;

import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__CountKt.class */
public final /* synthetic */ class FlowKt__CountKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(kotlinx.coroutines.flow.Flow<? extends T> r4, kotlin.coroutines.Continuation<? super java.lang.Integer> r5) {
        /*
            r0 = r5
            boolean r0 = r0 instanceof kotlinx.coroutines.flow.FlowKt__CountKt$count$1
            if (r0 == 0) goto L26
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__CountKt$count$1 r0 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$1) r0
            r7 = r0
            r0 = r7
            int r0 = r0.c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L26
            r0 = r7
            r1 = r7
            int r1 = r1.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r1 + r2
            r0.c = r1
            r0 = r7
            r5 = r0
            goto L2f
        L26:
            kotlinx.coroutines.flow.FlowKt__CountKt$count$1 r0 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$1
            r1 = r0
            r2 = r5
            r1.<init>(r2)
            r5 = r0
        L2f:
            r0 = r5
            java.lang.Object r0 = r0.b
            r7 = r0
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r8 = r0
            r0 = r5
            int r0 = r0.c
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L60
            r0 = r6
            r1 = 1
            if (r0 != r1) goto L56
            r0 = r5
            java.lang.Object r0 = r0.a
            kotlin.jvm.internal.Ref$IntRef r0 = (kotlin.jvm.internal.Ref.IntRef) r0
            r4 = r0
            r0 = r7
            kotlin.ResultKt.a(r0)
            goto L96
        L56:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L60:
            r0 = r7
            kotlin.ResultKt.a(r0)
            kotlin.jvm.internal.Ref$IntRef r0 = new kotlin.jvm.internal.Ref$IntRef
            r1 = r0
            r1.<init>()
            r7 = r0
            kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$1 r0 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$1
            r1 = r0
            r2 = r7
            r1.<init>()
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            r9 = r0
            r0 = r5
            r1 = r7
            r0.a = r1
            r0 = r5
            r1 = 1
            r0.c = r1
            r0 = r4
            r1 = r9
            r2 = r5
            java.lang.Object r0 = r0.a(r1, r2)
            r1 = r8
            if (r0 != r1) goto L94
            r0 = r8
            return r0
        L94:
            r0 = r7
            r4 = r0
        L96:
            r0 = r4
            int r0 = r0.a
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.a(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CountKt.a(kotlinx.coroutines.flow.Flow, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(kotlinx.coroutines.flow.Flow<? extends T> r5, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) {
        /*
            r0 = r7
            boolean r0 = r0 instanceof kotlinx.coroutines.flow.FlowKt__CountKt$count$3
            if (r0 == 0) goto L2b
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__CountKt$count$3 r0 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$3) r0
            r9 = r0
            r0 = r9
            int r0 = r0.c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L2b
            r0 = r9
            r1 = r9
            int r1 = r1.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r1 + r2
            r0.c = r1
            r0 = r9
            r7 = r0
            goto L34
        L2b:
            kotlinx.coroutines.flow.FlowKt__CountKt$count$3 r0 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$3
            r1 = r0
            r2 = r7
            r1.<init>(r2)
            r7 = r0
        L34:
            r0 = r7
            java.lang.Object r0 = r0.b
            r9 = r0
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r10 = r0
            r0 = r7
            int r0 = r0.c
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L67
            r0 = r8
            r1 = 1
            if (r0 != r1) goto L5d
            r0 = r7
            java.lang.Object r0 = r0.a
            kotlin.jvm.internal.Ref$IntRef r0 = (kotlin.jvm.internal.Ref.IntRef) r0
            r5 = r0
            r0 = r9
            kotlin.ResultKt.a(r0)
            goto La1
        L5d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L67:
            r0 = r9
            kotlin.ResultKt.a(r0)
            kotlin.jvm.internal.Ref$IntRef r0 = new kotlin.jvm.internal.Ref$IntRef
            r1 = r0
            r1.<init>()
            r9 = r0
            kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2 r0 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2
            r1 = r0
            r2 = r6
            r3 = r9
            r1.<init>(r2, r3)
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            r6 = r0
            r0 = r7
            r1 = r9
            r0.a = r1
            r0 = r7
            r1 = 1
            r0.c = r1
            r0 = r5
            r1 = r6
            r2 = r7
            java.lang.Object r0 = r0.a(r1, r2)
            r1 = r10
            if (r0 != r1) goto L9e
            r0 = r10
            return r0
        L9e:
            r0 = r9
            r5 = r0
        La1:
            r0 = r5
            int r0 = r0.a
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.a(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CountKt.a(kotlinx.coroutines.flow.Flow, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
