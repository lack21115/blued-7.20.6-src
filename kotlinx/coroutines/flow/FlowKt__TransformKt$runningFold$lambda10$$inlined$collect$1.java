package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda-10$$inlined$collect$1  reason: invalid class name */
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__TransformKt$runningFold$lambda-10$$inlined$collect$1.class */
public final class FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1<T> implements FlowCollector<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f43329a;
    final /* synthetic */ Function3 b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ FlowCollector f43330c;

    @Metadata
    @DebugMetadata(b = "Transform.kt", c = {135, 136}, d = "emit", e = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda-10$$inlined$collect$1")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda-10$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__TransformKt$runningFold$lambda-10$$inlined$collect$1$1.class */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f43331a;
        int b;
        Object d;
        Object e;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f43331a = obj;
            this.b |= Integer.MIN_VALUE;
            return FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1.this.emit(null, this);
        }
    }

    public FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1(Ref.ObjectRef objectRef, Function3 function3, FlowCollector flowCollector) {
        this.f43329a = objectRef;
        this.b = function3;
        this.f43330c = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0101  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object emit(T r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
