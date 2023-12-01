package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2.class */
public final class FlowKt__CollectKt$collectIndexed$2<T> implements FlowCollector<T> {
    final /* synthetic */ Function3<Integer, T, Continuation<? super Unit>, Object> a;
    private int b;

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        Function3<Integer, T, Continuation<? super Unit>, Object> function3 = this.a;
        int i = this.b;
        this.b = i + 1;
        if (i >= 0) {
            Object a = function3.a(Boxing.a(i), t, continuation);
            return a == IntrinsicsKt.a() ? a : Unit.a;
        }
        throw new ArithmeticException("Index overflow has happened");
    }
}
