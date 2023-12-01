package kotlinx.coroutines.flow;

import $r8;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/StartedWhileSubscribed.class */
final class StartedWhileSubscribed implements SharingStarted {
    private final long b;
    private final long c;

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow<SharingCommand> a(StateFlow<Integer> stateFlow) {
        return FlowKt.b(FlowKt.a(FlowKt.a((Flow) stateFlow, (Function3) new StartedWhileSubscribed$command$1(this, null)), (Function2) new StartedWhileSubscribed$command$2(null)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof StartedWhileSubscribed) {
            StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
            return this.b == startedWhileSubscribed.b && this.c == startedWhileSubscribed.c;
        }
        return false;
    }

    public int hashCode() {
        return ($r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.b) * 31) + $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.c);
    }

    public String toString() {
        List a = CollectionsKt.a(2);
        if (this.b > 0) {
            a.add("stopTimeout=" + this.b + "ms");
        }
        if (this.c < Long.MAX_VALUE) {
            a.add("replayExpiration=" + this.c + "ms");
        }
        List a2 = CollectionsKt.a(a);
        return "SharingStarted.WhileSubscribed(" + CollectionsKt.a(a2, null, null, null, 0, null, null, 63, null) + ')';
    }
}
