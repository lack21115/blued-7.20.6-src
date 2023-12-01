package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/ChildHandleNode.class */
public final class ChildHandleNode extends JobCancellingNode implements ChildHandle {

    /* renamed from: a  reason: collision with root package name */
    public final ChildJob f42788a;

    public ChildHandleNode(ChildJob childJob) {
        this.f42788a = childJob;
    }

    @Override // kotlinx.coroutines.ChildHandle
    public Job a() {
        return c();
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void a(Throwable th) {
        this.f42788a.a((ParentJob) c());
    }

    @Override // kotlinx.coroutines.ChildHandle
    public boolean b(Throwable th) {
        return c().c(th);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.f42314a;
    }
}
