package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ProducerScope.class */
public interface ProducerScope<E> extends CoroutineScope, SendChannel<E> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ProducerScope$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    SendChannel<E> r();
}
