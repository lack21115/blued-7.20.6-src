package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/EmptyFlow.class */
final class EmptyFlow implements Flow {

    /* renamed from: a  reason: collision with root package name */
    public static final EmptyFlow f43055a = new EmptyFlow();

    private EmptyFlow() {
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<?> flowCollector, Continuation<? super Unit> continuation) {
        return Unit.f42314a;
    }
}
