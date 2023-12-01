package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "TickerChannels.kt", c = {84, 88, 94, 96}, d = "fixedPeriodTicker", e = "kotlinx.coroutines.channels.TickerChannelsKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/TickerChannelsKt$fixedPeriodTicker$1.class */
public final class TickerChannelsKt$fixedPeriodTicker$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    long f43007a;
    long b;

    /* renamed from: c  reason: collision with root package name */
    Object f43008c;
    /* synthetic */ Object d;
    int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TickerChannelsKt$fixedPeriodTicker$1(Continuation<? super TickerChannelsKt$fixedPeriodTicker$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c2;
        this.d = obj;
        this.e |= Integer.MIN_VALUE;
        c2 = TickerChannelsKt.c(0L, 0L, null, this);
        return c2;
    }
}
