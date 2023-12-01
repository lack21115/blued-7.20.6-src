package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ContextKt$flowWith$$inlined$unsafeFlow$1.class */
public final class FlowKt__ContextKt$flowWith$$inlined$unsafeFlow$1<R> implements Flow<R> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Flow f43107a;
    final /* synthetic */ int b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function1 f43108c;
    final /* synthetic */ CoroutineContext d;

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(final FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        Flow a2;
        Flow a3;
        a2 = FlowKt__ContextKt.a(FlowKt.a(this.f43107a, continuation.getContext().minusKey(Job.C_)), this.b, null, 2, null);
        a3 = FlowKt__ContextKt.a(FlowKt.a((Flow) this.f43108c.invoke(a2), this.d), this.b, null, 2, null);
        Object a4 = a3.a(new FlowCollector<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ContextKt$flowWith$lambda-3$$inlined$collect$1
            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(R r, Continuation<? super Unit> continuation2) {
                Object emit = FlowCollector.this.emit(r, continuation2);
                return emit == IntrinsicsKt.a() ? emit : Unit.f42314a;
            }
        }, continuation);
        return a4 == IntrinsicsKt.a() ? a4 : Unit.f42314a;
    }
}
