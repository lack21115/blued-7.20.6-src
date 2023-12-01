package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__TransformKt$withIndex$$inlined$unsafeFlow$1.class */
public final class FlowKt__TransformKt$withIndex$$inlined$unsafeFlow$1<T> implements Flow<IndexedValue<? extends T>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Flow f43338a;

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(final FlowCollector<? super IndexedValue<? extends T>> flowCollector, Continuation<? super Unit> continuation) {
        final Ref.IntRef intRef = new Ref.IntRef();
        Object a2 = this.f43338a.a((FlowCollector) ((FlowCollector<T>) new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$withIndex$lambda-7$$inlined$collect$1
            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(T t, Continuation<? super Unit> continuation2) {
                FlowCollector flowCollector2 = FlowCollector.this;
                int i = intRef.f42543a;
                intRef.f42543a = i + 1;
                if (i >= 0) {
                    Object emit = flowCollector2.emit(new IndexedValue(i, t), continuation2);
                    return emit == IntrinsicsKt.a() ? emit : Unit.f42314a;
                }
                throw new ArithmeticException("Index overflow has happened");
            }
        }), continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
