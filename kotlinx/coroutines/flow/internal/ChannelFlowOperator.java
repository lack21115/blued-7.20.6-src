package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/ChannelFlowOperator.class */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {
    protected final Flow<S> d;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(Flow<? extends S> flow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.d = flow;
    }

    private final Object a(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
        FlowCollector b;
        b = ChannelFlowKt.b(flowCollector, continuation.getContext());
        Object a2 = ChannelFlowKt.a(coroutineContext, b, null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), continuation, 4, null);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }

    static /* synthetic */ Object a(ChannelFlowOperator channelFlowOperator, ProducerScope producerScope, Continuation continuation) {
        Object b = channelFlowOperator.b(new SendingCollector(producerScope), continuation);
        return b == IntrinsicsKt.a() ? b : Unit.f42314a;
    }

    static /* synthetic */ Object a(ChannelFlowOperator channelFlowOperator, FlowCollector flowCollector, Continuation continuation) {
        if (channelFlowOperator.b == -3) {
            CoroutineContext context = continuation.getContext();
            CoroutineContext plus = context.plus(channelFlowOperator.f43446a);
            if (Intrinsics.a(plus, context)) {
                Object b = channelFlowOperator.b(flowCollector, continuation);
                return b == IntrinsicsKt.a() ? b : Unit.f42314a;
            } else if (Intrinsics.a(plus.get(ContinuationInterceptor.f42453a), context.get(ContinuationInterceptor.f42453a))) {
                Object a2 = channelFlowOperator.a(flowCollector, plus, continuation);
                return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
            }
        }
        Object a3 = super.a(flowCollector, continuation);
        return a3 == IntrinsicsKt.a() ? a3 : Unit.f42314a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object a(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return a(this, producerScope, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return a((ChannelFlowOperator) this, (FlowCollector) flowCollector, (Continuation) continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object b(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return this.d + " -> " + super.toString();
    }
}
