package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$unsafeFlow$1.class */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$1<R> implements Flow<R> {
    final /* synthetic */ Flow a;
    final /* synthetic */ Flow b;
    final /* synthetic */ Function3 c;

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        Function0 b;
        Flow flow = this.a;
        Flow flow2 = this.b;
        b = FlowKt__ZipKt.b();
        Object a = CombineKt.a(flowCollector, new Flow[]{flow, flow2}, b, new FlowKt__ZipKt$combine$1$1(this.c, null), continuation);
        return a == IntrinsicsKt.a() ? a : Unit.a;
    }
}
