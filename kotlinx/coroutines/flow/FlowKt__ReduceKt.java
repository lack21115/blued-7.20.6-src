package kotlinx.coroutines.flow;

import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ReduceKt.class */
public final /* synthetic */ class FlowKt__ReduceKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T, R> java.lang.Object a(kotlinx.coroutines.flow.Flow<? extends T> r5, R r6, kotlin.jvm.functions.Function3<? super R, ? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super R> r8) {
        /*
            r0 = r8
            boolean r0 = r0 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1
            if (r0 == 0) goto L2b
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1) r0
            r10 = r0
            r0 = r10
            int r0 = r0.c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L2b
            r0 = r10
            r1 = r10
            int r1 = r1.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r1 + r2
            r0.c = r1
            r0 = r10
            r8 = r0
            goto L34
        L2b:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1
            r1 = r0
            r2 = r8
            r1.<init>(r2)
            r8 = r0
        L34:
            r0 = r8
            java.lang.Object r0 = r0.b
            r10 = r0
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r11 = r0
            r0 = r8
            int r0 = r0.c
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L6a
            r0 = r9
            r1 = 1
            if (r0 != r1) goto L60
            r0 = r8
            java.lang.Object r0 = r0.a
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            r5 = r0
            r0 = r10
            kotlin.ResultKt.a(r0)
            goto Laa
        L60:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L6a:
            r0 = r10
            kotlin.ResultKt.a(r0)
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = r10
            r1 = r6
            r0.a = r1
            kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$$inlined$collect$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$$inlined$collect$1
            r1 = r0
            r2 = r10
            r3 = r7
            r1.<init>(r2, r3)
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            r6 = r0
            r0 = r8
            r1 = r10
            r0.a = r1
            r0 = r8
            r1 = 1
            r0.c = r1
            r0 = r5
            r1 = r6
            r2 = r8
            java.lang.Object r0 = r0.a(r1, r2)
            r1 = r11
            if (r0 != r1) goto La7
            r0 = r11
            return r0
        La7:
            r0 = r10
            r5 = r0
        Laa:
            r0 = r5
            T r0 = r0.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.a(kotlinx.coroutines.flow.Flow, java.lang.Object, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(kotlinx.coroutines.flow.Flow<? extends T> r4, kotlin.coroutines.Continuation<? super T> r5) {
        /*
            r0 = r5
            boolean r0 = r0 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1
            if (r0 == 0) goto L26
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1) r0
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
            kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1
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
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            r4 = r0
            r0 = r7
            kotlin.ResultKt.a(r0)
            goto L9d
        L56:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L60:
            r0 = r7
            kotlin.ResultKt.a(r0)
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.flow.internal.NullSurrogateKt.a
            r0.a = r1
            kotlinx.coroutines.flow.FlowKt__ReduceKt$single$$inlined$collect$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$single$$inlined$collect$1
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
            if (r0 != r1) goto L9b
            r0 = r8
            return r0
        L9b:
            r0 = r7
            r4 = r0
        L9d:
            r0 = r4
            T r0 = r0.a
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.flow.internal.NullSurrogateKt.a
            if (r0 == r1) goto Lac
            r0 = r4
            T r0 = r0.a
            return r0
        Lac:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r1 = r0
            java.lang.String r2 = "Flow is empty"
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.a(kotlinx.coroutines.flow.Flow, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(kotlinx.coroutines.flow.Flow<? extends T> r5, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> r6, kotlin.coroutines.Continuation<? super T> r7) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.a(kotlinx.coroutines.flow.Flow, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b8  */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.internal.Symbol, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <S, T extends S> java.lang.Object a(kotlinx.coroutines.flow.Flow<? extends T> r5, kotlin.jvm.functions.Function3<? super S, ? super T, ? super kotlin.coroutines.Continuation<? super S>, ? extends java.lang.Object> r6, kotlin.coroutines.Continuation<? super S> r7) {
        /*
            r0 = r7
            boolean r0 = r0 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1
            if (r0 == 0) goto L2b
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1) r0
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
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1
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
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            r5 = r0
            r0 = r9
            kotlin.ResultKt.a(r0)
            goto La9
        L5d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L67:
            r0 = r9
            kotlin.ResultKt.a(r0)
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = r9
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.flow.internal.NullSurrogateKt.a
            r0.a = r1
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1
            r1 = r0
            r2 = r9
            r3 = r6
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
            if (r0 != r1) goto La6
            r0 = r10
            return r0
        La6:
            r0 = r9
            r5 = r0
        La9:
            r0 = r5
            T r0 = r0.a
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.flow.internal.NullSurrogateKt.a
            if (r0 == r1) goto Lb8
            r0 = r5
            T r0 = r0.a
            return r0
        Lb8:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r1 = r0
            java.lang.String r2 = "Empty flow can't be reduced"
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.a(kotlinx.coroutines.flow.Flow, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object b(kotlinx.coroutines.flow.Flow<? extends T> r4, kotlin.coroutines.Continuation<? super T> r5) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.b(kotlinx.coroutines.flow.Flow, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object b(kotlinx.coroutines.flow.Flow<? extends T> r5, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> r6, kotlin.coroutines.Continuation<? super T> r7) {
        /*
            Method dump skipped, instructions count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.b(kotlinx.coroutines.flow.Flow, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object c(kotlinx.coroutines.flow.Flow<? extends T> r4, kotlin.coroutines.Continuation<? super T> r5) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.c(kotlinx.coroutines.flow.Flow, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object d(kotlinx.coroutines.flow.Flow<? extends T> r4, kotlin.coroutines.Continuation<? super T> r5) {
        /*
            Method dump skipped, instructions count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.d(kotlinx.coroutines.flow.Flow, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object e(kotlinx.coroutines.flow.Flow<? extends T> r4, kotlin.coroutines.Continuation<? super T> r5) {
        /*
            r0 = r5
            boolean r0 = r0 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1
            if (r0 == 0) goto L26
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1) r0
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
            kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1
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
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            r4 = r0
            r0 = r7
            kotlin.ResultKt.a(r0)
            goto L9d
        L56:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L60:
            r0 = r7
            kotlin.ResultKt.a(r0)
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.flow.internal.NullSurrogateKt.a
            r0.a = r1
            kotlinx.coroutines.flow.FlowKt__ReduceKt$last$$inlined$collect$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$last$$inlined$collect$1
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
            if (r0 != r1) goto L9b
            r0 = r8
            return r0
        L9b:
            r0 = r7
            r4 = r0
        L9d:
            r0 = r4
            T r0 = r0.a
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.flow.internal.NullSurrogateKt.a
            if (r0 == r1) goto Lac
            r0 = r4
            T r0 = r0.a
            return r0
        Lac:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r1 = r0
            java.lang.String r2 = "Expected at least one element"
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.e(kotlinx.coroutines.flow.Flow, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object f(kotlinx.coroutines.flow.Flow<? extends T> r4, kotlin.coroutines.Continuation<? super T> r5) {
        /*
            r0 = r5
            boolean r0 = r0 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1
            if (r0 == 0) goto L26
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1) r0
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
            kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1
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
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
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
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r1 = r0
            r1.<init>()
            r7 = r0
            kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$$inlined$collect$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$$inlined$collect$1
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
            T r0 = r0.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.f(kotlinx.coroutines.flow.Flow, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
