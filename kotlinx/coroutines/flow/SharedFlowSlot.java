package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/SharedFlowSlot.class */
public final class SharedFlowSlot extends AbstractSharedFlowSlot<SharedFlowImpl<?>> {

    /* renamed from: a  reason: collision with root package name */
    public long f43417a = -1;
    public Continuation<? super Unit> b;

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public boolean a(SharedFlowImpl<?> sharedFlowImpl) {
        if (this.f43417a >= 0) {
            return false;
        }
        this.f43417a = sharedFlowImpl.c();
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public Continuation<Unit>[] b(SharedFlowImpl<?> sharedFlowImpl) {
        if (DebugKt.a()) {
            if (!(this.f43417a >= 0)) {
                throw new AssertionError();
            }
        }
        long j = this.f43417a;
        this.f43417a = -1L;
        this.b = null;
        return sharedFlowImpl.a(j);
    }
}
