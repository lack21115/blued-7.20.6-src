package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__MergeKt$flattenConcat$$inlined$unsafeFlow$1.class */
public final class FlowKt__MergeKt$flattenConcat$$inlined$unsafeFlow$1<T> implements Flow<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Flow f43226a;

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(final FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object a2 = this.f43226a.a(new FlowCollector<Flow<? extends T>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flattenConcat$lambda-1$$inlined$collect$1
            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(Flow<? extends T> flow, Continuation<? super Unit> continuation2) {
                Object a3 = FlowKt.a(FlowCollector.this, flow, continuation2);
                return a3 == IntrinsicsKt.a() ? a3 : Unit.f42314a;
            }
        }, continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
