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

    /* renamed from: a  reason: collision with root package name */
    long f43005a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    /* synthetic */ Object f43006c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TickerChannelsKt$fixedDelayTicker$1(Continuation<? super TickerChannelsKt$fixedDelayTicker$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d;
        this.f43006c = obj;
        this.d |= Integer.MIN_VALUE;
        d = TickerChannelsKt.d(0L, 0L, null, this);
        return d;
    }
}
