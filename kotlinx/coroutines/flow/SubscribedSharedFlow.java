package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/SubscribedSharedFlow.class */
final class SubscribedSharedFlow<T> implements SharedFlow<T> {
    private final SharedFlow<T> a;
    private final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> b;

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object a = this.a.a(new SubscribedFlowCollector(flowCollector, this.b), continuation);
        return a == IntrinsicsKt.a() ? a : Unit.a;
    }
}
