package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/EmptyFlow.class */
final class EmptyFlow implements Flow {
    public static final EmptyFlow a = new EmptyFlow();

    private EmptyFlow() {
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<?> flowCollector, Continuation<? super Unit> continuation) {
        return Unit.a;
    }
}
