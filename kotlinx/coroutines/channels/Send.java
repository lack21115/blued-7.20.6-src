package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/Send.class */
public abstract class Send extends LockFreeLinkedListNode {
    public abstract Object a();

    public abstract Symbol a(LockFreeLinkedListNode.PrepareOp prepareOp);

    public abstract void a(Closed<?> closed);

    public abstract void b();

    public void c() {
    }
}
