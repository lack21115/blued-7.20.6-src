package kotlinx.coroutines.flow;

import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__CollectionKt.class */
public final /* synthetic */ class FlowKt__CollectionKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T, C extends java.util.Collection<? super T>> java.lang.Object a(kotlinx.coroutines.flow.Flow<? extends T> r4, final C r5, kotlin.coroutines.Continuation<? super C> r6) {
        /*
            r0 = r6
            boolean r0 = r0 instanceof kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1
            if (r0 == 0) goto L2b
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1 r0 = (kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1) r0
            r8 = r0
            r0 = r8
            int r0 = r0.f43106c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L2b
            r0 = r8
            r1 = r8
            int r1 = r1.f43106c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r1 + r2
            r0.f43106c = r1
            r0 = r8
            r6 = r0
            goto L34
        L2b:
            kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1 r0 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1
            r1 = r0
            r2 = r6
            r1.<init>(r2)
            r6 = r0
        L34:
            r0 = r6
            java.lang.Object r0 = r0.b
            r8 = r0
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r9 = r0
            r0 = r6
            int r0 = r0.f43106c
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L66
            r0 = r7
            r1 = 1
            if (r0 != r1) goto L5c
            r0 = r6
            java.lang.Object r0 = r0.f43105a
            java.util.Collection r0 = (java.util.Collection) r0
            r4 = r0
            r0 = r8
            kotlin.ResultKt.a(r0)
            r0 = r4
            return r0
        L5c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L66:
            r0 = r8
            kotlin.ResultKt.a(r0)
            kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$$inlined$collect$1 r0 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$$inlined$collect$1
            r1 = r0
            r2 = r5
            r1.<init>()
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            r8 = r0
            r0 = r6
            r1 = r5
            r0.f43105a = r1
            r0 = r6
            r1 = 1
            r0.f43106c = r1
            r0 = r4
            r1 = r8
            r2 = r6
            java.lang.Object r0 = r0.a(r1, r2)
            r1 = r9
            if (r0 != r1) goto L93
            r0 = r9
            return r0
        L93:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CollectionKt.a(kotlinx.coroutines.flow.Flow, java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
