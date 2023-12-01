package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/StartedWhileSubscribed.class */
final class StartedWhileSubscribed implements SharingStarted {
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f43428c;

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow<SharingCommand> a(StateFlow<Integer> stateFlow) {
        return FlowKt.b(FlowKt.a(FlowKt.a((Flow) stateFlow, (Function3) new StartedWhileSubscribed$command$1(this, null)), (Function2) new StartedWhileSubscribed$command$2(null)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof StartedWhileSubscribed) {
            StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
            return this.b == startedWhileSubscribed.b && this.f43428c == startedWhileSubscribed.f43428c;
        }
        return false;
    }

    public int hashCode() {
        return (C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.b) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f43428c);
    }

    public String toString() {
        List a2 = CollectionsKt.a(2);
        if (this.b > 0) {
            a2.add("stopTimeout=" + this.b + "ms");
        }
        if (this.f43428c < Long.MAX_VALUE) {
            a2.add("replayExpiration=" + this.f43428c + "ms");
        }
        List a3 = CollectionsKt.a(a2);
        return "SharingStarted.WhileSubscribed(" + CollectionsKt.a(a3, null, null, null, 0, null, null, 63, null) + ')';
    }
}
