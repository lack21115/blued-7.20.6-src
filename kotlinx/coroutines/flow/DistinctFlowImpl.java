package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/DistinctFlowImpl.class */
public final class DistinctFlowImpl<T> implements Flow<T> {
    public final Function1<T, Object> a;
    public final Function2<Object, Object, Boolean> b;
    private final Flow<T> c;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(Flow<? extends T> flow, Function1<? super T, ? extends Object> function1, Function2<Object, Object, Boolean> function2) {
        this.c = flow;
        this.a = function1;
        this.b = function2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.a = (T) NullSurrogateKt.a;
        Object a = this.c.a(new DistinctFlowImpl$collect$$inlined$collect$1(this, objectRef, flowCollector), continuation);
        return a == IntrinsicsKt.a() ? a : Unit.a;
    }
}
