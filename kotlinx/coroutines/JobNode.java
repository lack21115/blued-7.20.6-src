package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/JobNode.class */
public abstract class JobNode extends CompletionHandlerBase implements DisposableHandle, Incomplete {
    public JobSupport c;

    public final void a(JobSupport jobSupport) {
        this.c = jobSupport;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean as_() {
        return true;
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList at_() {
        return null;
    }

    public final JobSupport c() {
        JobSupport jobSupport = this.c;
        if (jobSupport != null) {
            return jobSupport;
        }
        Intrinsics.c("job");
        throw null;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        c().a(this);
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return DebugStringsKt.b(this) + '@' + DebugStringsKt.a(this) + "[job@" + DebugStringsKt.a(c()) + ']';
    }
}
