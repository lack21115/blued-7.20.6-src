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
    final /* synthetic */ BroadcastChannel a;

    @Override // kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object a = FlowKt.a(flowCollector, this.a.az_(), continuation);
        return a == IntrinsicsKt.a() ? a : Unit.a;
    }
}
