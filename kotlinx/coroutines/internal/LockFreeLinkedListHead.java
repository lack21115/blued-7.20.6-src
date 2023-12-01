package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/LockFreeLinkedListHead.class */
public class LockFreeLinkedListHead extends LockFreeLinkedListNode {
    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public boolean aA_() {
        return false;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final boolean aB_() {
        throw new IllegalStateException("head cannot be removed".toString());
    }

    public final boolean c() {
        return i() == this;
    }
}
