package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/UndispatchedContextCollector.class */
final class UndispatchedContextCollector<T> implements FlowCollector<T> {
    private final CoroutineContext a;
    private final Object b;
    private final Function2<T, Continuation<? super Unit>, Object> c;

    public UndispatchedContextCollector(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        this.a = coroutineContext;
        this.b = ThreadContextKt.a(coroutineContext);
        this.c = new UndispatchedContextCollector$emitRef$1(flowCollector, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        Object a = ChannelFlowKt.a(this.a, t, this.b, this.c, continuation);
        return a == IntrinsicsKt.a() ? a : Unit.a;
    }
}
