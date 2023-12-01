package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1.class */
public final class FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1<T> implements FlowCollector<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function3 f43153a;
    final /* synthetic */ FlowCollector b;

    @Metadata
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1$1.class */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f43154a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 f43155c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f43154a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.f43155c.emit(null, this);
        }
    }

    public FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1(Function3 function3, FlowCollector flowCollector) {
        this.f43153a = function3;
        this.b = flowCollector;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        Object a2 = this.f43153a.a(this.b, t, continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
