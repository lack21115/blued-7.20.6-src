package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelKt.class */
public final class ChannelKt {
    public static final <E> Channel<E> a(int i, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        if (i == -2) {
            int i2 = 1;
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                i2 = Channel.f42899a.a();
            }
            return new ArrayChannel(i2, bufferOverflow, function1);
        } else if (i == -1) {
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                return new ConflatedChannel(function1);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        } else if (i == 0) {
            return bufferOverflow == BufferOverflow.SUSPEND ? (AbstractChannel) new RendezvousChannel(function1) : (AbstractChannel) new ArrayChannel(1, bufferOverflow, function1);
        } else if (i != Integer.MAX_VALUE) {
            return (i == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) ? (AbstractChannel) new ConflatedChannel(function1) : (AbstractChannel) new ArrayChannel(i, bufferOverflow, function1);
        } else {
            return new LinkedListChannel(function1);
        }
    }

    public static /* synthetic */ Channel a(int i, BufferOverflow bufferOverflow, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        return a(i, bufferOverflow, function1);
    }
}
