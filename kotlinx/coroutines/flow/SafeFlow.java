package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/SafeFlow.class */
final class SafeFlow<T> extends AbstractFlow<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> f43408a;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeFlow(Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.f43408a = function2;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    public Object b(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object invoke = this.f43408a.invoke(flowCollector, continuation);
        return invoke == IntrinsicsKt.a() ? invoke : Unit.f42314a;
    }
}
