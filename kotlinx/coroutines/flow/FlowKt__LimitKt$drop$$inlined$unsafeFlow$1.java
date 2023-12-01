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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Flow f43186a;
    final /* synthetic */ int b;

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(final FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        final Ref.IntRef intRef = new Ref.IntRef();
        Flow flow = this.f43186a;
        final int i = this.b;
        Object a2 = flow.a((FlowCollector) ((FlowCollector<T>) new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$drop$lambda-2$$inlined$collect$1
            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(T t, Continuation<? super Unit> continuation2) {
                if (Ref.IntRef.this.f42543a >= i) {
                    Object emit = flowCollector.emit(t, continuation2);
                    if (emit == IntrinsicsKt.a()) {
                        return emit;
                    }
                } else {
                    Ref.IntRef.this.f42543a++;
                    int i2 = Ref.IntRef.this.f42543a;
                }
                return Unit.f42314a;
            }
        }), continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
