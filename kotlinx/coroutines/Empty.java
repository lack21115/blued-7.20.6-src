package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/Empty.class */
public final class Empty implements Incomplete {
    private final boolean a;

    public Empty(boolean z) {
        this.a = z;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean as_() {
        return this.a;
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList at_() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(as_() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
