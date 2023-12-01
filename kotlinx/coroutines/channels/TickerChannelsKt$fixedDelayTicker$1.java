package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "TickerChannels.kt", c = {106, 108, 109}, d = "fixedDelayTicker", e = "kotlinx.coroutines.channels.TickerChannelsKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/TickerChannelsKt$fixedDelayTicker$1.class */
public final class TickerChannelsKt$fixedDelayTicker$1 extends ContinuationImpl {
    long a;
    Object b;
    /* synthetic */ Object c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TickerChannelsKt$fixedDelayTicker$1(Continuation<? super TickerChannelsKt$fixedDelayTicker$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d;
        this.c = obj;
        this.d |= Integer.MIN_VALUE;
        d = TickerChannelsKt.d(0L, 0L, null, this);
        return d;
    }
}
