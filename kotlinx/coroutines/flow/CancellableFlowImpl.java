package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.JobKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/CancellableFlowImpl.class */
final class CancellableFlowImpl<T> implements CancellableFlow<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Flow<T> f43047a;

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableFlowImpl(Flow<? extends T> flow) {
        this.f43047a = flow;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(final FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object a2 = this.f43047a.a((FlowCollector) ((FlowCollector<T>) new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.CancellableFlowImpl$collect$$inlined$collect$1
            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(T t, Continuation<? super Unit> continuation2) {
                JobKt.a(continuation2.getContext());
                Object emit = FlowCollector.this.emit(t, continuation2);
                return emit == IntrinsicsKt.a() ? emit : Unit.f42314a;
            }
        }), continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
