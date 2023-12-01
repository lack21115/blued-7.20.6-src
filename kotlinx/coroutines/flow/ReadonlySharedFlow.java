package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.FusibleFlow;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/ReadonlySharedFlow.class */
final class ReadonlySharedFlow<T> implements CancellableFlow<T>, SharedFlow<T>, FusibleFlow<T> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ SharedFlow<T> f43406a;

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return this.f43406a.a(flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> a_(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return SharedFlowKt.a(this, coroutineContext, i, bufferOverflow);
    }
}
