package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.class */
public final class FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1<T> implements Flow<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Flow f43321a;
    final /* synthetic */ Function2 b;

    @Metadata
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2.class */
    public static final class AnonymousClass2 implements FlowCollector<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlowCollector f43322a;
        final /* synthetic */ Function2 b;

        @Metadata
        @DebugMetadata(b = "Transform.kt", c = {136, 137}, d = "emit", e = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2")
        /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1  reason: invalid class name */
        /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1.class */
        public static final class AnonymousClass1 extends ContinuationImpl {

            /* renamed from: a  reason: collision with root package name */
            /* synthetic */ Object f43323a;
            int b;
            Object d;
            Object e;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f43323a = obj;
                this.b |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(FlowCollector flowCollector, Function2 function2) {
            this.f43322a = flowCollector;
            this.b = function2;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00de  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
            /*
                Method dump skipped, instructions count: 229
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector flowCollector, Continuation continuation) {
        Object a2 = this.f43321a.a(new AnonymousClass2(flowCollector, this.b), continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
