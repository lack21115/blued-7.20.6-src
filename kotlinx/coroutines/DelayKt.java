package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/DelayKt.class */
public final class DelayKt {
    public static final long a(long j) {
        if (Duration.a(j, Duration.a.a()) > 0) {
            return RangesKt.a(Duration.p(j), 1L);
        }
        return 0L;
    }

    public static final Object a(long j, Continuation<? super Unit> continuation) {
        if (j <= 0) {
            return Unit.a;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        if (j < Long.MAX_VALUE) {
            a(cancellableContinuationImpl2.getContext()).a(j, cancellableContinuationImpl2);
        }
        Object h = cancellableContinuationImpl.h();
        if (h == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return h == IntrinsicsKt.a() ? h : Unit.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(kotlin.coroutines.Continuation<?> r5) {
        /*
            r0 = r5
            boolean r0 = r0 instanceof kotlinx.coroutines.DelayKt$awaitCancellation$1
            if (r0 == 0) goto L26
            r0 = r5
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = (kotlinx.coroutines.DelayKt$awaitCancellation$1) r0
            r7 = r0
            r0 = r7
            int r0 = r0.b
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L26
            r0 = r7
            r1 = r7
            int r1 = r1.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r1 + r2
            r0.b = r1
            r0 = r7
            r5 = r0
            goto L2f
        L26:
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = new kotlinx.coroutines.DelayKt$awaitCancellation$1
            r1 = r0
            r2 = r5
            r1.<init>(r2)
            r5 = r0
        L2f:
            r0 = r5
            java.lang.Object r0 = r0.a
            r8 = r0
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r7 = r0
            r0 = r5
            int r0 = r0.b
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L57
            r0 = r6
            r1 = 1
            if (r0 == r1) goto L50
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L50:
            r0 = r8
            kotlin.ResultKt.a(r0)
            goto L93
        L57:
            r0 = r8
            kotlin.ResultKt.a(r0)
            r0 = r5
            r1 = 1
            r0.b = r1
            r0 = r5
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            r5 = r0
            kotlinx.coroutines.CancellableContinuationImpl r0 = new kotlinx.coroutines.CancellableContinuationImpl
            r1 = r0
            r2 = r5
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.a(r2)
            r3 = 1
            r1.<init>(r2, r3)
            r8 = r0
            r0 = r8
            r0.e()
            r0 = r8
            kotlinx.coroutines.CancellableContinuation r0 = (kotlinx.coroutines.CancellableContinuation) r0
            r9 = r0
            r0 = r8
            java.lang.Object r0 = r0.h()
            r8 = r0
            r0 = r8
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            if (r0 != r1) goto L8c
            r0 = r5
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L8c:
            r0 = r8
            r1 = r7
            if (r0 != r1) goto L93
            r0 = r7
            return r0
        L93:
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r1 = r0
            r1.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DelayKt.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Delay a(CoroutineContext coroutineContext) {
        CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor.a);
        Delay delay = element instanceof Delay ? (Delay) element : null;
        Delay delay2 = delay;
        if (delay == null) {
            delay2 = DefaultExecutorKt.a();
        }
        return delay2;
    }
}
