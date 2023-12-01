package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/CombineKt.class */
public final class CombineKt {
    public static final <R, T> Object a(FlowCollector<? super R> flowCollector, Flow<? extends T>[] flowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object a = FlowCoroutineKt.a(new CombineKt$combineInternal$2(flowArr, function0, function3, flowCollector, null), continuation);
        return a == IntrinsicsKt.a() ? a : Unit.a;
    }

    public static final <T1, T2, R> Flow<R> a(final Flow<? extends T1> flow, final Flow<? extends T2> flow2, final Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return new Flow<R>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
                Object a = CoroutineScopeKt.a(new CombineKt$zipImpl$1$1(flowCollector, Flow.this, flow, function3, null), continuation);
                return a == IntrinsicsKt.a() ? a : Unit.a;
            }
        };
    }
}
