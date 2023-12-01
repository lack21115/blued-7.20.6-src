package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ActorScope.class */
public interface ActorScope<E> extends CoroutineScope, ReceiveChannel<E> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ActorScope$DefaultImpls.class */
    public static final class DefaultImpls {
    }
}
