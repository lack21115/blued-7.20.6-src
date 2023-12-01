package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/StartedLazily.class */
final class StartedLazily implements SharingStarted {
    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow<SharingCommand> a(StateFlow<Integer> stateFlow) {
        return FlowKt.a((Function2) new StartedLazily$command$1(stateFlow, null));
    }

    public String toString() {
        return "SharingStarted.Lazily";
    }
}
