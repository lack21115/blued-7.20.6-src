package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.class */
public final class FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1<T> implements Flow<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Flow f43305a;

    @Metadata
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2.class */
    public static final class AnonymousClass2 implements FlowCollector<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlowCollector f43306a;

        @Metadata
        @DebugMetadata(b = "Transform.kt", c = {136}, d = "emit", e = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2")
        /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1  reason: invalid class name */
        /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1.class */
        public static final class AnonymousClass1 extends ContinuationImpl {

            /* renamed from: a  reason: collision with root package name */
            /* synthetic */ Object f43307a;
            int b;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f43307a = obj;
                this.b |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(FlowCollector flowCollector) {
            this.f43306a = flowCollector;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
            /*
                r5 = this;
                r0 = r7
                boolean r0 = r0 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L2b
                r0 = r7
                kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
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
                kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1
                r1 = r0
                r2 = r5
                r3 = r7
                r1.<init>(r3)
                r7 = r0
            L35:
                r0 = r7
                java.lang.Object r0 = r0.f43307a
                r10 = r0
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
                r9 = r0
                r0 = r7
                int r0 = r0.b
                r8 = r0
                r0 = r8
                if (r0 == 0) goto L60
                r0 = r8
                r1 = 1
                if (r0 != r1) goto L56
                r0 = r10
                kotlin.ResultKt.a(r0)
                goto L8b
            L56:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                r1 = r0
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r0
            L60:
                r0 = r10
                kotlin.ResultKt.a(r0)
                r0 = r5
                kotlinx.coroutines.flow.FlowCollector r0 = r0.f43306a
                r10 = r0
                r0 = r7
                kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
                r11 = r0
                r0 = r6
                if (r0 == 0) goto L8b
                r0 = r7
                r1 = 1
                r0.b = r1
                r0 = r10
                r1 = r6
                r2 = r7
                java.lang.Object r0 = r0.emit(r1, r2)
                r1 = r9
                if (r0 != r1) goto L8b
                r0 = r9
                return r0
            L8b:
                kotlin.Unit r0 = kotlin.Unit.f42314a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector flowCollector, Continuation continuation) {
        Object a2 = this.f43305a.a(new AnonymousClass2(flowCollector), continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
