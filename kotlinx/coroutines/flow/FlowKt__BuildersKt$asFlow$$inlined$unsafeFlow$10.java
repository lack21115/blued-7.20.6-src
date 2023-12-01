package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.ranges.LongRange;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10.class */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10 implements Flow<Long> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LongRange f43057a;

    @Metadata
    @DebugMetadata(b = "Builders.kt", c = {115}, d = "collect", e = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1.class */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f43058a;
        int b;
        Object d;
        Object e;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f43058a = obj;
            this.b |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10.this.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0099  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(kotlinx.coroutines.flow.FlowCollector<? super java.lang.Long> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            r0 = r7
            boolean r0 = r0 instanceof kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10.AnonymousClass1
            if (r0 == 0) goto L2b
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1 r0 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10.AnonymousClass1) r0
            r9 = r0
            r0 = r9
            int r0 = r0.b
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L2b
            r0 = r9
            r1 = r9
            int r1 = r1.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = r1 + r2
            r0.b = r1
            r0 = r9
            r7 = r0
            goto L35
        L2b:
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1 r0 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1
            r1 = r0
            r2 = r5
            r3 = r7
            r1.<init>(r3)
            r7 = r0
        L35:
            r0 = r7
            java.lang.Object r0 = r0.f43058a
            r10 = r0
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r11 = r0
            r0 = r7
            int r0 = r0.b
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L71
            r0 = r8
            r1 = 1
            if (r0 != r1) goto L67
            r0 = r7
            java.lang.Object r0 = r0.e
            java.util.Iterator r0 = (java.util.Iterator) r0
            r6 = r0
            r0 = r7
            java.lang.Object r0 = r0.d
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            r9 = r0
            r0 = r10
            kotlin.ResultKt.a(r0)
            goto L90
        L67:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L71:
            r0 = r10
            kotlin.ResultKt.a(r0)
            r0 = r7
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            r9 = r0
            r0 = r5
            kotlin.ranges.LongRange r0 = r0.f43057a
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r10 = r0
            r0 = r6
            r9 = r0
            r0 = r10
            r6 = r0
        L90:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto Lcc
            r0 = r6
            java.lang.Object r0 = r0.next()
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.a(r0)
            r10 = r0
            r0 = r7
            r1 = r9
            r0.d = r1
            r0 = r7
            r1 = r6
            r0.e = r1
            r0 = r7
            r1 = 1
            r0.b = r1
            r0 = r9
            r1 = r10
            r2 = r7
            java.lang.Object r0 = r0.emit(r1, r2)
            r1 = r11
            if (r0 != r1) goto L90
            r0 = r11
            return r0
        Lcc:
            kotlin.Unit r0 = kotlin.Unit.f42314a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10.a(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
