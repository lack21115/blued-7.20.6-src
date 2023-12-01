package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1.class */
public final class FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1<R> implements Flow<R> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function3 f43493a;

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        Object a2 = FlowCoroutineKt.a(new FlowCoroutineKt$scopedFlow$1$1(this.f43493a, flowCollector, null), continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
