package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1.class */
public final class LockFreeLinkedListNode$makeCondAddOp$1 extends LockFreeLinkedListNode.CondAddOp {
    final /* synthetic */ Function0<Boolean> a;

    @Override // kotlinx.coroutines.internal.AtomicOp
    public Object a(LockFreeLinkedListNode lockFreeLinkedListNode) {
        if (this.a.invoke().booleanValue()) {
            return null;
        }
        return LockFreeLinkedListKt.a();
    }
}
