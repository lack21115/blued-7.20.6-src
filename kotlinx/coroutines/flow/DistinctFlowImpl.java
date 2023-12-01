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

    /* renamed from: a  reason: collision with root package name */
    public final Function1<T, Object> f43049a;
    public final Function2<Object, Object, Boolean> b;

    /* renamed from: c  reason: collision with root package name */
    private final Flow<T> f43050c;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(Flow<? extends T> flow, Function1<? super T, ? extends Object> function1, Function2<Object, Object, Boolean> function2) {
        this.f43050c = flow;
        this.f43049a = function1;
        this.b = function2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f42545a = (T) NullSurrogateKt.f43498a;
        Object a2 = this.f43050c.a(new DistinctFlowImpl$collect$$inlined$collect$1(this, objectRef, flowCollector), continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
