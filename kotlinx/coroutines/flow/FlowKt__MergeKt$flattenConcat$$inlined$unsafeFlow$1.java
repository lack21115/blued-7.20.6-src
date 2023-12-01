package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__MergeKt$flattenConcat$$inlined$unsafeFlow$1.class */
public final class FlowKt__MergeKt$flattenConcat$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Flow a;

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(final FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object a = this.a.a(new FlowCollector<Flow<? extends T>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flattenConcat$lambda-1$$inlined$collect$1
            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(Flow<? extends T> flow, Continuation<? super Unit> continuation2) {
                Object a2 = FlowKt.a(FlowCollector.this, flow, continuation2);
                return a2 == IntrinsicsKt.a() ? a2 : Unit.a;
            }
        }, continuation);
        return a == IntrinsicsKt.a() ? a : Unit.a;
    }
}
