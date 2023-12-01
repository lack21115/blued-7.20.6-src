package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/ChannelAsFlow.class */
final class ChannelAsFlow<T> extends ChannelFlow<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(ChannelAsFlow.class, "consumed");
    private volatile /* synthetic */ int consumed;
    private final ReceiveChannel<T> d;
    private final boolean e;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelAsFlow(ReceiveChannel<? extends T> receiveChannel, boolean z, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.d = receiveChannel;
        this.e = z;
        this.consumed = 0;
    }

    private final void d() {
        if (this.e) {
            boolean z = true;
            if (f.getAndSet(this, 1) != 0) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object a(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        Object b;
        b = FlowKt__ChannelsKt.b(new SendingCollector(producerScope), this.d, this.e, continuation);
        return b == IntrinsicsKt.a() ? b : Unit.f42314a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object b;
        if (this.b != -3) {
            Object a2 = super.a(flowCollector, continuation);
            return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
        }
        d();
        b = FlowKt__ChannelsKt.b(flowCollector, this.d, this.e, continuation);
        return b == IntrinsicsKt.a() ? b : Unit.f42314a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String a() {
        return Intrinsics.a("channel=", (Object) this.d);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ReceiveChannel<T> a(CoroutineScope coroutineScope) {
        d();
        return this.b == -3 ? this.d : super.a(coroutineScope);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ChannelFlow<T> a(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return new ChannelAsFlow(this.d, this.e, coroutineContext, i, bufferOverflow);
    }
}
