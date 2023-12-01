package kotlinx.coroutines.channels;

import com.blued.das.client.chatroom.ChatRoomProtos;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [V] */
@Metadata
@DebugMetadata(b = "Deprecated.kt", c = {415, ChatRoomProtos.Event.YY_LIFT_MASK_POP_USE_CLICK_VALUE, 399}, d = "invokeSuspend", e = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$zip$2.class */
final class ChannelsKt__DeprecatedKt$zip$2<V> extends SuspendLambda implements Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    Object f42987a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    Object f42988c;
    Object d;
    Object e;
    int f;
    final /* synthetic */ ReceiveChannel<R> g;
    final /* synthetic */ ReceiveChannel<E> h;
    final /* synthetic */ Function2<E, R, V> i;
    private /* synthetic */ Object j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__DeprecatedKt$zip$2(ReceiveChannel<? extends R> receiveChannel, ReceiveChannel<? extends E> receiveChannel2, Function2<? super E, ? super R, ? extends V> function2, Continuation<? super ChannelsKt__DeprecatedKt$zip$2> continuation) {
        super(2, continuation);
        this.g = receiveChannel;
        this.h = receiveChannel2;
        this.i = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(ProducerScope<? super V> producerScope, Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$zip$2) create(producerScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$zip$2 channelsKt__DeprecatedKt$zip$2 = new ChannelsKt__DeprecatedKt$zip$2(this.g, this.h, this.i, continuation);
        channelsKt__DeprecatedKt$zip$2.j = obj;
        return channelsKt__DeprecatedKt$zip$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x024c A[Catch: all -> 0x029f, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x029f, blocks: (B:74:0x023e, B:77:0x024c), top: B:101:0x023e }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02a3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x02c0 -> B:26:0x0132). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            Method dump skipped, instructions count: 735
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
