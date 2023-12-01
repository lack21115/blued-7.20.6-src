package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.SemaphoreKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/ChannelFlowMerge.class */
public final class ChannelFlowMerge<T> extends ChannelFlow<T> {
    private final Flow<Flow<T>> d;
    private final int e;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge(Flow<? extends Flow<? extends T>> flow, int i, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        super(coroutineContext, i2, bufferOverflow);
        this.d = flow;
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object a(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        Object a = this.d.a(new ChannelFlowMerge$collectTo$$inlined$collect$1((Job) continuation.getContext().get(Job.C_), SemaphoreKt.a(this.e, 0, 2, null), producerScope, new SendingCollector(producerScope)), continuation);
        return a == IntrinsicsKt.a() ? a : Unit.a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected String a() {
        return Intrinsics.a("concurrency=", (Object) Integer.valueOf(this.e));
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ReceiveChannel<T> a(CoroutineScope coroutineScope) {
        return FlowCoroutineKt.a(coroutineScope, this.a, this.b, b());
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow<T> a(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return new ChannelFlowMerge(this.d, this.e, coroutineContext, i, bufferOverflow);
    }
}
