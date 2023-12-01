package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/BroadcastChannel.class */
public interface BroadcastChannel<E> extends SendChannel<E> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/BroadcastChannel$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    void a(CancellationException cancellationException);

    ReceiveChannel<E> az_();
}
