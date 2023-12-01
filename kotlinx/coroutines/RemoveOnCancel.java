package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/RemoveOnCancel.class */
public final class RemoveOnCancel extends BeforeResumeCancelHandler {

    /* renamed from: a  reason: collision with root package name */
    private final LockFreeLinkedListNode f42848a;

    public RemoveOnCancel(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.f42848a = lockFreeLinkedListNode;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void a(Throwable th) {
        this.f42848a.aB_();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.f42314a;
    }

    public String toString() {
        return "RemoveOnCancel[" + this.f42848a + ']';
    }
}
