package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.FusibleFlow;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/ReadonlyStateFlow.class */
final class ReadonlyStateFlow<T> implements CancellableFlow<T>, StateFlow<T>, FusibleFlow<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Job f43407a;
    private final /* synthetic */ StateFlow<T> b;

    /* JADX WARN: Multi-variable type inference failed */
    public ReadonlyStateFlow(StateFlow<? extends T> stateFlow, Job job) {
        this.f43407a = job;
        this.b = stateFlow;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return this.b.a(flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> a_(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return StateFlowKt.a(this, coroutineContext, i, bufferOverflow);
    }
}
