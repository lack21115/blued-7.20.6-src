package kotlinx.coroutines.internal;

import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/Removed.class */
public final class Removed {
    public final LockFreeLinkedListNode a;

    public Removed(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.a = lockFreeLinkedListNode;
    }

    public String toString() {
        return "Removed[" + this.a + ']';
    }
}
