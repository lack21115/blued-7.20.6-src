package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ChildHandleNode.class */
public final class ChildHandleNode extends JobCancellingNode implements ChildHandle {
    public final ChildJob a;

    public ChildHandleNode(ChildJob childJob) {
        this.a = childJob;
    }

    @Override // kotlinx.coroutines.ChildHandle
    public Job a() {
        return c();
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void a(Throwable th) {
        this.a.a((ParentJob) c());
    }

    @Override // kotlinx.coroutines.ChildHandle
    public boolean b(Throwable th) {
        return c().c(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.a;
    }
}
