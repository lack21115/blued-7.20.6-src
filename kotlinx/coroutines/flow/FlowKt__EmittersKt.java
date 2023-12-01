package kotlinx.coroutines.flow;

import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__EmittersKt.class */
public final /* synthetic */ class FlowKt__EmittersKt {
    public static final void a(FlowCollector<?> flowCollector) {
        if (flowCollector instanceof ThrowingCollector) {
            throw ((ThrowingCollector) flowCollector).a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARN: Type inference failed for: r8v0, types: [kotlin.coroutines.Continuation, kotlin.coroutines.Continuation<? super kotlin.Unit>] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object b(kotlinx.coroutines.flow.FlowCollector<? super T> r5, kotlin.jvm.functions.Function3<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super java.lang.Throwable, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r6, java.lang.Throwable r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r0 = r8
            boolean r0 = r0 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1
            if (r0 == 0) goto L28
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1) r0
            r10 = r0
            r0 = r10
            int r0 = r0.c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L28
            r0 = r10
            r1 = r10
            int r1 = r1.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r1 + r2
            r0.c = r1
            goto L32
        L28:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1
            r1 = r0
            r2 = r8
            r1.<init>(r2)
            r10 = r0
        L32:
            r0 = r10
            java.lang.Object r0 = r0.b
            r11 = r0
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r12 = r0
            r0 = r10
            int r0 = r0.c
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L6b
            r0 = r9
            r1 = 1
            if (r0 != r1) goto L61
            r0 = r10
            java.lang.Object r0 = r0.a
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r8 = r0
            r0 = r11
            kotlin.ResultKt.a(r0)     // Catch: java.lang.Throwable -> L9a
            goto L96
        L61:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L6b:
            r0 = r11
            kotlin.ResultKt.a(r0)
            r0 = r7
            r8 = r0
            r0 = r10
            r1 = r7
            r0.a = r1     // Catch: java.lang.Throwable -> L9a
            r0 = r7
            r8 = r0
            r0 = r10
            r1 = 1
            r0.c = r1     // Catch: java.lang.Throwable -> L9a
            r0 = r7
            r8 = r0
            r0 = r6
            r1 = r5
            r2 = r7
            r3 = r10
            java.lang.Object r0 = r0.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L9a
            r5 = r0
            r0 = r5
            r1 = r12
            if (r0 != r1) goto L96
            r0 = r12
            return r0
        L96:
            kotlin.Unit r0 = kotlin.Unit.a
            return r0
        L9a:
            r5 = move-exception
            r0 = r8
            if (r0 == 0) goto La9
            r0 = r8
            r1 = r5
            if (r0 == r1) goto La9
            r0 = r5
            r1 = r8
            kotlin.ExceptionsKt.a(r0, r1)
        La9:
            r0 = r5
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt.b(kotlinx.coroutines.flow.FlowCollector, kotlin.jvm.functions.Function3, java.lang.Throwable, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
