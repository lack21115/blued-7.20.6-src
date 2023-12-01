package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata
@DebugMetadata(b = "TickerChannels.kt", c = {72, 73}, d = "invokeSuspend", e = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/TickerChannelsKt$ticker$3.class */
final class TickerChannelsKt$ticker$3 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f43009a;
    final /* synthetic */ TickerMode b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f43010c;
    final /* synthetic */ long d;
    private /* synthetic */ Object e;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/TickerChannelsKt$ticker$3$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43011a;

        static {
            int[] iArr = new int[TickerMode.valuesCustom().length];
            iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
            iArr[TickerMode.FIXED_DELAY.ordinal()] = 2;
            f43011a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TickerChannelsKt$ticker$3(TickerMode tickerMode, long j, long j2, Continuation<? super TickerChannelsKt$ticker$3> continuation) {
        super(2, continuation);
        this.b = tickerMode;
        this.f43010c = j;
        this.d = j2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(ProducerScope<? super Unit> producerScope, Continuation<? super Unit> continuation) {
        return ((TickerChannelsKt$ticker$3) create(producerScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TickerChannelsKt$ticker$3 tickerChannelsKt$ticker$3 = new TickerChannelsKt$ticker$3(this.b, this.f43010c, this.d, continuation);
        tickerChannelsKt$ticker$3.e = obj;
        return tickerChannelsKt$ticker$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c2;
        Object d;
        Object a2 = IntrinsicsKt.a();
        int i = this.f43009a;
        if (i == 0) {
            ResultKt.a(obj);
            ProducerScope producerScope = (ProducerScope) this.e;
            int i2 = WhenMappings.f43011a[this.b.ordinal()];
            if (i2 == 1) {
                this.f43009a = 1;
                c2 = TickerChannelsKt.c(this.f43010c, this.d, producerScope.r(), this);
                if (c2 == a2) {
                    return a2;
                }
            } else if (i2 == 2) {
                this.f43009a = 2;
                d = TickerChannelsKt.d(this.f43010c, this.d, producerScope.r(), this);
                if (d == a2) {
                    return a2;
                }
            }
        } else if (i != 1 && i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        return Unit.f42314a;
    }
}
