package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1.class */
public final class LockFreeLinkedListNode$makeCondAddOp$1 extends LockFreeLinkedListNode.CondAddOp {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function0<Boolean> f43545a;

    @Override // kotlinx.coroutines.internal.AtomicOp
    public Object a(LockFreeLinkedListNode lockFreeLinkedListNode) {
        if (this.f43545a.invoke().booleanValue()) {
            return null;
        }
        return LockFreeLinkedListKt.a();
    }
}
