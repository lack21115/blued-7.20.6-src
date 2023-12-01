package kotlinx.coroutines.flow;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/StartedEagerly.class */
final class StartedEagerly implements SharingStarted {
    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow<SharingCommand> a(StateFlow<Integer> stateFlow) {
        return FlowKt.a(SharingCommand.START);
    }

    public String toString() {
        return "SharingStarted.Eagerly";
    }
}
