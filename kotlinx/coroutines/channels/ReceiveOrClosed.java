package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ReceiveOrClosed.class */
public interface ReceiveOrClosed<E> {
    Symbol a(E e, LockFreeLinkedListNode.PrepareOp prepareOp);

    void b(E e);

    Object h();
}
