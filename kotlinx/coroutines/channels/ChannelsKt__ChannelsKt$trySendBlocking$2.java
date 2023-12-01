package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata
@DebugMetadata(b = "Channels.kt", c = {92}, d = "invokeSuspend", e = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelsKt__ChannelsKt$trySendBlocking$2.class */
final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChannelResult<? extends Unit>>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f42908a;
    final /* synthetic */ SendChannel<E> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ E f42909c;
    private /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__ChannelsKt$trySendBlocking$2(SendChannel<? super E> sendChannel, E e, Continuation<? super ChannelsKt__ChannelsKt$trySendBlocking$2> continuation) {
        super(2, continuation);
        this.b = sendChannel;
        this.f42909c = e;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ChannelResult<Unit>> continuation) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 channelsKt__ChannelsKt$trySendBlocking$2 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.b, this.f42909c, continuation);
        channelsKt__ChannelsKt$trySendBlocking$2.d = obj;
        return channelsKt__ChannelsKt$trySendBlocking$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f;
        Object a2 = IntrinsicsKt.a();
        int i = this.f42908a;
        try {
            if (i == 0) {
                ResultKt.a(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.d;
                SendChannel<E> sendChannel = this.b;
                E e = this.f42909c;
                Result.Companion companion = Result.f42293a;
                this.f42908a = 1;
                if (sendChannel.a(e, this) == a2) {
                    return a2;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.a(obj);
            }
            f = Result.f(Unit.f42314a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f42293a;
            f = Result.f(ResultKt.a(th));
        }
        return ChannelResult.h(Result.a(f) ? ChannelResult.f42903a.a((ChannelResult.Companion) Unit.f42314a) : ChannelResult.f42903a.a(Result.c(f)));
    }
}
