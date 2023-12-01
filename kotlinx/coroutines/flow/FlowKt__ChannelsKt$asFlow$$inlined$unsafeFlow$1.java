package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.BroadcastChannel;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1.class */
public final class FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1<T> implements Flow<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BroadcastChannel f43090a;

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object a2 = FlowKt.a(flowCollector, this.f43090a.az_(), continuation);
        return a2 == IntrinsicsKt.a() ? a2 : Unit.f42314a;
    }
}
