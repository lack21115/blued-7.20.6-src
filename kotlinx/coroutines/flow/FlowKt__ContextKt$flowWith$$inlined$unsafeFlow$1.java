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
    final /* synthetic */ Flow a;
    final /* synthetic */ int b;
    final /* synthetic */ Function1 c;
    final /* synthetic */ CoroutineContext d;

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(final FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        Flow a;
        Flow a2;
        a = FlowKt__ContextKt.a(FlowKt.a(this.a, continuation.getContext().minusKey(Job.C_)), this.b, null, 2, null);
        a2 = FlowKt__ContextKt.a(FlowKt.a((Flow) this.c.invoke(a), this.d), this.b, null, 2, null);
        Object a3 = a2.a(new FlowCollector<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ContextKt$flowWith$lambda-3$$inlined$collect$1
            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(R r, Continuation<? super Unit> continuation2) {
                Object emit = FlowCollector.this.emit(r, continuation2);
                return emit == IntrinsicsKt.a() ? emit : Unit.a;
            }
        }, continuation);
        return a3 == IntrinsicsKt.a() ? a3 : Unit.a;
    }
}
