package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1.class */
public final class FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1<T> implements Flow<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Flow f43199a;
    final /* synthetic */ Function2 b;

    @Metadata
    @DebugMetadata(b = "Limit.kt", c = {124}, d = "collect", e = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1.class */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f43200a;
        int b;
        Object d;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f43200a = obj;
            this.b |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1.this.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(kotlinx.coroutines.flow.FlowCollector<? super T> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            r0 = r7
            boolean r0 = r0 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L2b
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1.AnonymousClass1) r0
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
            kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1
            r1 = r0
            r2 = r5
            r3 = r7
            r1.<init>(r3)
            r7 = r0
        L35:
            r0 = r7
            java.lang.Object r0 = r0.f43200a
            r10 = r0
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
            r9 = r0
            r0 = r7
            int r0 = r0.b
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L6c
            r0 = r8
            r1 = 1
            if (r0 != r1) goto L62
            r0 = r7
            java.lang.Object r0 = r0.d
            kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda-9$$inlined$collectWhile$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1) r0
            r6 = r0
            r0 = r10
            kotlin.ResultKt.a(r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L5e
            goto Lb7
        L5e:
            r7 = move-exception
            goto Laf
        L62:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r0
        L6c:
            r0 = r10
            kotlin.ResultKt.a(r0)
            r0 = r7
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            r10 = r0
            r0 = r5
            kotlinx.coroutines.flow.Flow r0 = r0.f43199a
            r10 = r0
            kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda-9$$inlined$collectWhile$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda-9$$inlined$collectWhile$1
            r1 = r0
            r2 = r5
            kotlin.jvm.functions.Function2 r2 = r2.b
            r3 = r6
            r1.<init>(r2, r3)
            r6 = r0
            r0 = r6
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> Lae
            r11 = r0
            r0 = r7
            r1 = r6
            r0.d = r1     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> Lae
            r0 = r7
            r1 = 1
            r0.b = r1     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> Lae
            r0 = r10
            r1 = r11
            r2 = r7
            java.lang.Object r0 = r0.a(r1, r2)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> Lae
            r7 = r0
            r0 = r7
            r1 = r9
            if (r0 != r1) goto Lb7
            r0 = r9
            return r0
        Lae:
            r7 = move-exception
        Laf:
            r0 = r7
            r1 = r6
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.a(r0, r1)
        Lb7:
            kotlin.Unit r0 = kotlin.Unit.f42314a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1.a(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
