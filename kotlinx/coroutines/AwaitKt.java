package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/AwaitKt.class */
public final class AwaitKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(java.util.Collection<? extends kotlinx.coroutines.Job> r4, kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r0 = r5
            boolean r0 = r0 instanceof kotlinx.coroutines.AwaitKt$joinAll$3
            if (r0 == 0) goto L26
            r0 = r5
            kotlinx.coroutines.AwaitKt$joinAll$3 r0 = (kotlinx.coroutines.AwaitKt$joinAll$3) r0
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
            kotlinx.coroutines.AwaitKt$joinAll$3 r0 = new kotlinx.coroutines.AwaitKt$joinAll$3
            r1 = r0
            r2 = r5
            r1.<init>(r2)
            r5 = r0
        L2f:
            r0 = r5
            java.lang.Object r0 = r0.b
            r8 = r0
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r7 = r0
            r0 = r5
            int r0 = r0.c
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L61
            r0 = r6
            r1 = 1
            if (r0 != r1) goto L57
            r0 = r5
            java.lang.Object r0 = r0.a
            java.util.Iterator r0 = (java.util.Iterator) r0
            r4 = r0
            r0 = r8
            kotlin.ResultKt.a(r0)
            goto L70
        L57:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L61:
            r0 = r8
            kotlin.ResultKt.a(r0)
            r0 = r4
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r4 = r0
        L70:
            r0 = r4
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L9c
            r0 = r4
            java.lang.Object r0 = r0.next()
            kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
            r8 = r0
            r0 = r5
            r1 = r4
            r0.a = r1
            r0 = r5
            r1 = 1
            r0.c = r1
            r0 = r8
            r1 = r5
            java.lang.Object r0 = r0.b(r1)
            r1 = r7
            if (r0 != r1) goto L70
            r0 = r7
            return r0
        L9c:
            kotlin.Unit r0 = kotlin.Unit.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.a(java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bc  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00ad -> B:22:0x00b3). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(kotlinx.coroutines.Job[] r4, kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            Method dump skipped, instructions count: 192
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.a(kotlinx.coroutines.Job[], kotlin.coroutines.Continuation):java.lang.Object");
    }
}
