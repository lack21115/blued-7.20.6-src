package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/LockFreeLinkedListKt.class */
public final class LockFreeLinkedListKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f43537a = new Symbol("CONDITION_FALSE");
    private static final Object b = new Symbol("LIST_EMPTY");

    public static final Object a() {
        return f43537a;
    }

    public static final LockFreeLinkedListNode a(Object obj) {
        Removed removed = obj instanceof Removed ? (Removed) obj : null;
        LockFreeLinkedListNode lockFreeLinkedListNode = removed == null ? null : removed.f43558a;
        LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode;
        if (lockFreeLinkedListNode == null) {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) obj;
        }
        return lockFreeLinkedListNode2;
    }

    public static final Object b() {
        return b;
    }
}
