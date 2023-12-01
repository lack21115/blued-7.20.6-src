package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/InactiveNodeList.class */
public final class InactiveNodeList implements Incomplete {
    private final NodeList a;

    public InactiveNodeList(NodeList nodeList) {
        this.a = nodeList;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean as_() {
        return false;
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList at_() {
        return this.a;
    }

    public String toString() {
        return DebugKt.b() ? at_().a("New") : super.toString();
    }
}
