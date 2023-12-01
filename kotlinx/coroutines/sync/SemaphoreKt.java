package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/sync/SemaphoreKt.class */
public final class SemaphoreKt {
    private static final int a;
    private static final Symbol b;
    private static final Symbol c;
    private static final Symbol d;
    private static final Symbol e;
    private static final int f;

    static {
        int a2;
        int a3;
        a2 = SystemPropsKt__SystemProps_commonKt.a("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, (Object) null);
        a = a2;
        b = new Symbol("PERMIT");
        c = new Symbol("TAKEN");
        d = new Symbol("BROKEN");
        e = new Symbol("CANCELLED");
        a3 = SystemPropsKt__SystemProps_commonKt.a("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, (Object) null);
        f = a3;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(kotlinx.coroutines.sync.Semaphore r4, kotlin.jvm.functions.Function0<? extends T> r5, kotlin.coroutines.Continuation<? super T> r6) {
        /*
            r0 = r6
            boolean r0 = r0 instanceof kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            if (r0 == 0) goto L28
            r0 = r6
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = (kotlinx.coroutines.sync.SemaphoreKt$withPermit$1) r0
            r8 = r0
            r0 = r8
            int r0 = r0.d
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L28
            r0 = r8
            r1 = r8
            int r1 = r1.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r1 + r2
            r0.d = r1
            goto L32
        L28:
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = new kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            r1 = r0
            r2 = r6
            r1.<init>(r2)
            r8 = r0
        L32:
            r0 = r8
            java.lang.Object r0 = r0.c
            r9 = r0
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r10 = r0
            r0 = r8
            int r0 = r0.d
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L71
            r0 = r7
            r1 = 1
            if (r0 != r1) goto L67
            r0 = r8
            java.lang.Object r0 = r0.b
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r5 = r0
            r0 = r8
            java.lang.Object r0 = r0.a
            kotlinx.coroutines.sync.Semaphore r0 = (kotlinx.coroutines.sync.Semaphore) r0
            r6 = r0
            r0 = r9
            kotlin.ResultKt.a(r0)
            goto L9a
        L67:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L71:
            r0 = r9
            kotlin.ResultKt.a(r0)
            r0 = r8
            r1 = r4
            r0.a = r1
            r0 = r8
            r1 = r5
            r0.b = r1
            r0 = r8
            r1 = 1
            r0.d = r1
            r0 = r4
            r6 = r0
            r0 = r4
            r1 = r8
            java.lang.Object r0 = r0.a(r1)
            r1 = r10
            if (r0 != r1) goto L9a
            r0 = r10
            return r0
        L9a:
            r0 = r5
            java.lang.Object r0 = r0.invoke()     // Catch: java.lang.Throwable -> Lb1
            r4 = r0
            r0 = 1
            kotlin.jvm.internal.InlineMarker.b(r0)
            r0 = r6
            r0.a()
            r0 = 1
            kotlin.jvm.internal.InlineMarker.c(r0)
            r0 = r4
            return r0
        Lb1:
            r4 = move-exception
            r0 = 1
            kotlin.jvm.internal.InlineMarker.b(r0)
            r0 = r6
            r0.a()
            r0 = 1
            kotlin.jvm.internal.InlineMarker.c(r0)
            r0 = r4
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreKt.a(kotlinx.coroutines.sync.Semaphore, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Semaphore a(int i, int i2) {
        return new SemaphoreImpl(i, i2);
    }

    public static /* synthetic */ Semaphore a(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return a(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SemaphoreSegment b(long j, SemaphoreSegment semaphoreSegment) {
        return new SemaphoreSegment(j, semaphoreSegment, 0);
    }
}
