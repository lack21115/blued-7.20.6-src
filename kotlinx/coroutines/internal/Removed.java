package kotlinx.coroutines.internal;

import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/Removed.class */
public final class Removed {

    /* renamed from: a  reason: collision with root package name */
    public final LockFreeLinkedListNode f43558a;

    public Removed(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.f43558a = lockFreeLinkedListNode;
    }

    public String toString() {
        return "Removed[" + this.f43558a + ']';
    }
}
