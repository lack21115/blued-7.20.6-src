package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelsKt.class */
public final class ChannelsKt {
    public static final <K, V, M extends Map<? super K, ? super V>> Object a(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, M m, Continuation<? super M> continuation) {
        return ChannelsKt__DeprecatedKt.a((ReceiveChannel) receiveChannel, (Map) m, (Continuation) continuation);
    }

    public static final <E> Object a(ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.a(receiveChannel, continuation);
    }

    public static final void a(ReceiveChannel<?> receiveChannel, Throwable th) {
        ChannelsKt__Channels_commonKt.a(receiveChannel, th);
    }

    public static final <E, C extends Collection<? super E>> Object b(ReceiveChannel<? extends E> receiveChannel, C c2, Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.b((ReceiveChannel) receiveChannel, (Collection) c2, (Continuation) continuation);
    }

    public static final <E, C extends SendChannel<? super E>> Object b(ReceiveChannel<? extends E> receiveChannel, C c2, Continuation<? super C> continuation) {
        return ChannelsKt__DeprecatedKt.b((ReceiveChannel) receiveChannel, (SendChannel) c2, (Continuation) continuation);
    }
}
