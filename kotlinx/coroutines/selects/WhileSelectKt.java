package kotlinx.coroutines.selects;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/WhileSelectKt.class */
public final class WhileSelectKt {
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00a5 -> B:27:0x00ab). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(kotlin.jvm.functions.Function1<? super kotlinx.coroutines.selects.SelectBuilder<? super java.lang.Boolean>, kotlin.Unit> r4, kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r0 = r5
            boolean r0 = r0 instanceof kotlinx.coroutines.selects.WhileSelectKt$whileSelect$1
            if (r0 == 0) goto L26
            r0 = r5
            kotlinx.coroutines.selects.WhileSelectKt$whileSelect$1 r0 = (kotlinx.coroutines.selects.WhileSelectKt$whileSelect$1) r0
            r7 = r0
            r0 = r7
            int r0 = r0.f43611c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L26
            r0 = r7
            r1 = r7
            int r1 = r1.f43611c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r1 + r2
            r0.f43611c = r1
            r0 = r7
            r5 = r0
            goto L2f
        L26:
            kotlinx.coroutines.selects.WhileSelectKt$whileSelect$1 r0 = new kotlinx.coroutines.selects.WhileSelectKt$whileSelect$1
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
            int r0 = r0.f43611c
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L60
            r0 = r6
            r1 = 1
            if (r0 != r1) goto L56
            r0 = r5
            java.lang.Object r0 = r0.f43610a
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r4 = r0
            r0 = r7
            kotlin.ResultKt.a(r0)
            goto Lab
        L56:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L60:
            r0 = r7
            kotlin.ResultKt.a(r0)
        L64:
            r0 = r5
            r1 = r4
            r0.f43610a = r1
            r0 = r5
            r1 = 1
            r0.f43611c = r1
            r0 = r5
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            r9 = r0
            kotlinx.coroutines.selects.SelectBuilderImpl r0 = new kotlinx.coroutines.selects.SelectBuilderImpl
            r1 = r0
            r2 = r9
            r1.<init>(r2)
            r7 = r0
            r0 = r4
            r1 = r7
            java.lang.Object r0 = r0.invoke(r1)     // Catch: java.lang.Throwable -> L89
            goto L91
        L89:
            r10 = move-exception
            r0 = r7
            r1 = r10
            r0.b(r1)
        L91:
            r0 = r7
            java.lang.Object r0 = r0.b()
            r7 = r0
            r0 = r7
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            if (r0 != r1) goto La2
            r0 = r9
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        La2:
            r0 = r7
            r1 = r8
            if (r0 != r1) goto Lab
            r0 = r8
            return r0
        Lab:
            r0 = r7
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto Lb8
            goto L64
        Lb8:
            kotlin.Unit r0 = kotlin.Unit.f42314a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.WhileSelectKt.a(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
