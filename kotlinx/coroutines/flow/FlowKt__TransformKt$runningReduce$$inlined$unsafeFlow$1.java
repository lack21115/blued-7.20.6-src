package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1.class */
public final class FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Flow a;
    final /* synthetic */ Function3 b;

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.a = (T) NullSurrogateKt.a;
        Object a = this.a.a(new FlowKt__TransformKt$runningReduce$lambda12$$inlined$collect$1(objectRef, this.b, flowCollector), continuation);
        return a == IntrinsicsKt.a() ? a : Unit.a;
    }
}
