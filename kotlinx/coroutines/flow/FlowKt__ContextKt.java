package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ContextKt.class */
public final /* synthetic */ class FlowKt__ContextKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> a(Flow<? extends T> flow) {
        return flow instanceof CancellableFlow ? flow : new CancellableFlowImpl(flow);
    }

    public static final <T> Flow<T> a(Flow<? extends T> flow, int i, BufferOverflow bufferOverflow) {
        if (i >= 0 || i == -2 || i == -1) {
            boolean z = true;
            if (i == -1) {
                z = bufferOverflow == BufferOverflow.SUSPEND;
            }
            if (z) {
                if (i == -1) {
                    bufferOverflow = BufferOverflow.DROP_OLDEST;
                    i = 0;
                }
                return flow instanceof FusibleFlow ? FusibleFlow.DefaultImpls.a((FusibleFlow) flow, null, i, bufferOverflow, 1, null) : new ChannelFlowOperatorImpl(flow, null, i, bufferOverflow, 2, null);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        throw new IllegalArgumentException(Intrinsics.a("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ", (Object) Integer.valueOf(i)).toString());
    }

    public static /* synthetic */ Flow a(Flow flow, int i, BufferOverflow bufferOverflow, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return FlowKt.a(flow, i, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> a(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        a(coroutineContext);
        return Intrinsics.a(coroutineContext, EmptyCoroutineContext.f42457a) ? flow : flow instanceof FusibleFlow ? FusibleFlow.DefaultImpls.a((FusibleFlow) flow, coroutineContext, 0, null, 6, null) : new ChannelFlowOperatorImpl(flow, coroutineContext, 0, null, 12, null);
    }

    private static final void a(CoroutineContext coroutineContext) {
        if (!(coroutineContext.get(Job.C_) == null)) {
            throw new IllegalArgumentException(Intrinsics.a("Flow context cannot contain job in it. Had ", (Object) coroutineContext).toString());
        }
    }
}
