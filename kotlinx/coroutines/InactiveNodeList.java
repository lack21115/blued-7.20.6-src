package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/InactiveNodeList.class */
public final class InactiveNodeList implements Incomplete {

    /* renamed from: a  reason: collision with root package name */
    private final NodeList f42828a;

    public InactiveNodeList(NodeList nodeList) {
        this.f42828a = nodeList;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean as_() {
        return false;
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList at_() {
        return this.f42828a;
    }

    public String toString() {
        return DebugKt.b() ? at_().a("New") : super.toString();
    }
}
