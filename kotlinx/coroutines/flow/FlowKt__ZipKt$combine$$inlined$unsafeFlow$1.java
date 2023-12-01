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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Flow f43349a;
    final /* synthetic */ Flow b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function3 f43350c;

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        Function0 b;
        Flow flow = this.f43349a;
        Flow flow2 = this.b;
        b = FlowKt__ZipKt.b();
        Object a2 = CombineKt.a(flowCollector, new Flow[]{flow, flow2}, b, new FlowKt__ZipKt$combine$1$1(this.f43350c, null), continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
