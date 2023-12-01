package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__LimitKt$drop$$inlined$unsafeFlow$1.class */
public final class FlowKt__LimitKt$drop$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Flow a;
    final /* synthetic */ int b;

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(final FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        final Ref.IntRef intRef = new Ref.IntRef();
        Flow flow = this.a;
        final int i = this.b;
        Object a = flow.a((FlowCollector) ((FlowCollector<T>) new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$drop$lambda-2$$inlined$collect$1
            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(T t, Continuation<? super Unit> continuation2) {
                if (Ref.IntRef.this.a >= i) {
                    Object emit = flowCollector.emit(t, continuation2);
                    if (emit == IntrinsicsKt.a()) {
                        return emit;
                    }
                } else {
                    Ref.IntRef.this.a++;
                    int i2 = Ref.IntRef.this.a;
                }
                return Unit.a;
            }
        }), continuation);
        return a == IntrinsicsKt.a() ? a : Unit.a;
    }
}
