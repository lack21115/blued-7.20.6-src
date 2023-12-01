package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/Empty.class */
public final class Empty implements Incomplete {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f42815a;

    public Empty(boolean z) {
        this.f42815a = z;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean as_() {
        return this.f42815a;
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
