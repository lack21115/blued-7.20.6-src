package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.NopCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__CollectKt.class */
public final /* synthetic */ class FlowKt__CollectKt {
    public static final Object a(Flow<?> flow, Continuation<? super Unit> continuation) {
        Object a2 = flow.a(NopCollector.f43497a, continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }

    public static final <T> Object a(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Flow a2;
        a2 = FlowKt__ContextKt.a(FlowKt.b(flow, function2), 0, null, 2, null);
        Object a3 = FlowKt.a(a2, continuation);
        return a3 == IntrinsicsKt.a() ? a3 : Unit.f42314a;
    }

    public static final <T> Object a(FlowCollector<? super T> flowCollector, Flow<? extends T> flow, Continuation<? super Unit> continuation) {
        FlowKt.a((FlowCollector<?>) flowCollector);
        Object a2 = flow.a(flowCollector, continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
