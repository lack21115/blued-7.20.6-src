package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/NodeList.class */
public final class NodeList extends LockFreeLinkedListHead implements Incomplete {
    public final String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        NodeList nodeList = this;
        LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) nodeList.i();
        boolean z = true;
        while (true) {
            boolean z2 = z;
            if (Intrinsics.a(lockFreeLinkedListNode, nodeList)) {
                sb.append("]");
                String sb2 = sb.toString();
                Intrinsics.c(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
            boolean z3 = z2;
            if (lockFreeLinkedListNode instanceof JobNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                if (z2) {
                    z2 = false;
                } else {
                    sb.append(", ");
                }
                sb.append(jobNode);
                z3 = z2;
            }
            lockFreeLinkedListNode = lockFreeLinkedListNode.j();
            z = z3;
        }
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean as_() {
        return true;
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList at_() {
        return this;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return DebugKt.b() ? a("Active") : super.toString();
    }
}
