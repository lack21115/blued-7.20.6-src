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

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineContext f43511a;
    private final Object b;

    /* renamed from: c  reason: collision with root package name */
    private final Function2<T, Continuation<? super Unit>, Object> f43512c;

    public UndispatchedContextCollector(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        this.f43511a = coroutineContext;
        this.b = ThreadContextKt.a(coroutineContext);
        this.f43512c = new UndispatchedContextCollector$emitRef$1(flowCollector, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        Object a2 = ChannelFlowKt.a(this.f43511a, t, this.b, this.f43512c, continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
